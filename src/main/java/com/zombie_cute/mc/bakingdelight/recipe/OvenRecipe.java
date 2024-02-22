package com.zombie_cute.mc.bakingdelight.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class OvenRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;
    public OvenRecipe(Identifier id,DefaultedList<Ingredient> ingredients, ItemStack itemStack){
        this.id = id;
        this.output = itemStack;
        this.recipeItems = ingredients;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (world.isClient){
            return false;
        }

        return recipeItems.get(0).test(inventory.getStack(0))&&
                recipeItems.get(1).test(inventory.getStack(1))&&
                recipeItems.get(2).test(inventory.getStack(2))&&
                recipeItems.get(3).test(inventory.getStack(3));
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(this.recipeItems.size());
        list.addAll(recipeItems);
        return list;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }
    public static class Type implements RecipeType<OvenRecipe>{
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID  = "oven_baking";
    }
    public static class Serializer implements RecipeSerializer<OvenRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "oven_baking";

        @Override
        public OvenRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json,"output"));

            JsonArray ingredients = JsonHelper.getArray(json,"ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(4,Ingredient.EMPTY);

            for(int i=0;i<inputs.size();i++){
                inputs.set(i,Ingredient.fromJson(ingredients.get(i)));
            }

            return new OvenRecipe(id, inputs, output);
        }

        @Override
        public OvenRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(),Ingredient.EMPTY);

            for(int i =0;i<inputs.size();i++){
                inputs.set(i,Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new OvenRecipe(id, inputs, output);
        }

        @Override
        public void write(PacketByteBuf buf, OvenRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for(Ingredient ingredient : recipe.getIngredients()){
                ingredient.write(buf);
            }
            buf.writeItemStack(recipe.output);
        }
    }
}
