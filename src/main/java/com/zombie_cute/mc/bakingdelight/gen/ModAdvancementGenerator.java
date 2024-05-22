package com.zombie_cute.mc.bakingdelight.gen;

import com.zombie_cute.mc.bakingdelight.Bakingdelight;
import com.zombie_cute.mc.bakingdelight.block.ModBlocks;
import com.zombie_cute.mc.bakingdelight.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;


public class ModAdvancementGenerator extends FabricAdvancementProvider {

    public ModAdvancementGenerator(FabricDataOutput output) {
        super(output);
    }
    public static final String GET_WHISK_TITLE = "advancement.bakingdelight.get_whisk_title";
    public static final String GET_WHISK_DESC = "advancement.bakingdelight.get_whisk_desc";
    public static final String GET_AMETHYST_TOOL_TITLE = "advancement.bakingdelight.get_amethyst_tool_title";
    public static final String GET_AMETHYST_TOOL_DESC = "advancement.bakingdelight.get_amethyst_tool_desc";
    public static final String GET_NETHERITE_WHISK_TITLE = "advancement.bakingdelight.get_netherite_whisk_title";
    public static final String GET_NETHERITE_WHISK_DESC = "advancement.bakingdelight.get_netherite_whisk_desc";
    public static final String GET_CUTTLEBONE_TITLE = "advancement.bakingdelight.get_cuttlebone_title";
    public static final String GET_CUTTLEBONE_DESC = "advancement.bakingdelight.get_cuttlebone_desc";
    public static final String GET_TRUFFLE_TITLE = "advancement.bakingdelight.get_truffle_title";
    public static final String GET_TRUFFLE_DESC = "advancement.bakingdelight.get_truffle_desc";
    public static final String GET_ALL_AMETHYST_TITLE = "advancement.bakingdelight.get_all_amethyst_title";
    public static final String GET_ALL_AMETHYST_DESC = "advancement.bakingdelight.get_all_amethyst_desc";
    public static final String GET_CHERRY_BOMB_TITLE = "advancement.bakingdelight.get_cherry_bomb_title";
    public static final String GET_CHERRY_BOMB_DESC = "advancement.bakingdelight.get_cherry_bomb_desc";
    public static final String GET_GLASS_BOWL_TITLE = "advancement.bakingdelight.get_glass_bowl_title";
    public static final String GET_GLASS_BOWL_DESC = "advancement.bakingdelight.get_glass_bowl_desc";
    public static final String GET_MASHED_POTATO_TITLE = "advancement.bakingdelight.get_mashed_potato_title";
    public static final String GET_MASHED_POTATO_DESC = "advancement.bakingdelight.get_mashed_potato_desc";
    public static final String GET_POTATO_STARCH_TITLE = "advancement.bakingdelight.get_potato_starch_title";
    public static final String GET_POTATO_STARCH_DESC = "advancement.bakingdelight.get_potato_starch_desc";
    public static final String GET_FREEZER_TITLE = "advancement.bakingdelight.get_freezer_title";
    public static final String GET_FREEZER_DESC = "advancement.bakingdelight.get_freezer_desc";
    public static final String GET_BLUE_ICE_TITLE = "advancement.bakingdelight.get_blue_ice_title";
    public static final String GET_BLUE_ICE_DESC = "advancement.bakingdelight.get_blue_ice_desc";
    public static final String GET_OVEN_TITLE = "advancement.bakingdelight.get_oven_title";
    public static final String GET_OVEN_DESC = "advancement.bakingdelight.get_oven_desc";
    public static final String GET_EGG_TART_TITLE = "advancement.bakingdelight.get_egg_tart_title";
    public static final String GET_EGG_TART_DESC = "advancement.bakingdelight.get_egg_tart_desc";
    public static final String GET_PUDDING_WIP_1_TITLE = "advancement.bakingdelight.get_pudding_wip_1_title";
    public static final String GET_PUDDING_WIP_1_DESC = "advancement.bakingdelight.get_pudding_wip_1_desc";
    public static final String GET_PUDDING_WIP_2_TITLE = "advancement.bakingdelight.get_pudding_wip_2_title";
    public static final String GET_PUDDING_WIP_2_DESC = "advancement.bakingdelight.get_pudding_wip_2_desc";
    public static final String GET_ALL_PUDDING_TITLE = "advancement.bakingdelight.get_all_pudding_title";
    public static final String GET_ALL_PUDDING_DESC = "advancement.bakingdelight.get_all_pudding_desc";
    public static final String GET_MOUSSE_WIP_TITLE = "advancement.bakingdelight.get_mousse_wip_title";
    public static final String GET_MOUSSE_WIP_DESC = "advancement.bakingdelight.get_mousse_wip_desc";
    public static final String GET_ALL_MOUSSE_TITLE = "advancement.bakingdelight.get_all_mousse_title";
    public static final String GET_ALL_MOUSSE_DESC = "advancement.bakingdelight.get_all_mousse_desc";
    public static final String GET_CREAM_BUCKET_TITLE = "advancement.bakingdelight.get_cream_bucket_title";
    public static final String GET_CREAM_BUCKET_DESC = "advancement.bakingdelight.get_cream_bucket_desc";
    public static final String GET_BUTTER_TITLE = "advancement.bakingdelight.get_butter_title";
    public static final String GET_BUTTER_DESC = "advancement.bakingdelight.get_butter_desc";
    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement getStart = Advancement.Builder.create()
                .display(
                        ModBlocks.FREEZER,
                        Text.translatable("itemgroup.bakingdelight"),
                        Text.translatable("advancement.bakingdelight.get_start_desc"),
                        new Identifier("textures/block/beehive_end.png"),
                        AdvancementFrame.TASK,
                        false,
                        false,
                        false
                )
                .criterion("get_start", ConsumeItemCriterion.Conditions.item(Items.BREAD))
                .build(consumer, Bakingdelight.MOD_ID + "/root");
        Advancement getWhisk = Advancement.Builder.create().parent(getStart)
                .display(
                        ModItems.IRON_WHISK,
                        Text.translatable(GET_WHISK_TITLE),
                        Text.translatable(GET_WHISK_DESC),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("iron_whisk", InventoryChangedCriterion.Conditions.items(ModItems.IRON_WHISK))
                .criterion("wooden_whisk", InventoryChangedCriterion.Conditions.items(ModItems.WOODEN_WHISK))
                .criterion("stone_whisk", InventoryChangedCriterion.Conditions.items(ModItems.STONE_WHISK))
                .criterion("copper_whisk", InventoryChangedCriterion.Conditions.items(ModItems.COPPER_WHISK))
                .criterion("golden_whisk", InventoryChangedCriterion.Conditions.items(ModItems.GOLDEN_WHISK))
                .criterion("amethyst_whisk", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_WHISK))
                .criterion("diamond_whisk", InventoryChangedCriterion.Conditions.items(ModItems.DIAMOND_WHISK))
                .criterion("netherite_whisk", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_WHISK))
                .requirements(new String[][]{new String[]{"iron_whisk","wooden_whisk","stone_whisk","copper_whisk","golden_whisk","amethyst_whisk","diamond_whisk","netherite_whisk"}})
                .build(consumer, Bakingdelight.MOD_ID + "/got_whisk");
        Advancement getAmethystTool = Advancement.Builder.create().parent(getStart)
                .display(
                        ModItems.AMETHYST_KNIFE,
                        Text.translatable(GET_AMETHYST_TOOL_TITLE),
                        Text.translatable(GET_AMETHYST_TOOL_DESC),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("amethyst_whisk", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_WHISK))
                .criterion("amethyst_sword", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_SWORD))
                .criterion("amethyst_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_PICKAXE))
                .criterion("amethyst_axe", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_AXE))
                .criterion("amethyst_shovel", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_SHOVEL))
                .criterion("amethyst_hoe", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_HOE))
                .criterion("amethyst_knife", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_KNIFE))
                .requirements(new String[][]{new String[]{"amethyst_whisk","amethyst_sword","amethyst_pickaxe","amethyst_axe","amethyst_shovel","amethyst_hoe","amethyst_knife"}})
                .build(consumer, Bakingdelight.MOD_ID + "/got_amethyst_tool");
        Advancement getNetheriteWhisk = Advancement.Builder.create().parent(getWhisk)
                .display(
                        ModItems.NETHERITE_WHISK,
                        Text.translatable(GET_NETHERITE_WHISK_TITLE),
                        Text.translatable(GET_NETHERITE_WHISK_DESC),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1000))
                .criterion("netherite_whisk", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_WHISK))
                .build(consumer, Bakingdelight.MOD_ID + "/got_netherite_whisk");
        Advancement getCuttlebone = Advancement.Builder.create().parent(getAmethystTool)
                .display(
                        ModItems.CUTTLEBONE,
                        Text.translatable(GET_CUTTLEBONE_TITLE),
                        Text.translatable(GET_CUTTLEBONE_DESC),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("cuttlebone", InventoryChangedCriterion.Conditions.items(ModItems.CUTTLEBONE))
                .criterion("glow_cuttlebone", InventoryChangedCriterion.Conditions.items(ModItems.GLOW_CUTTLEBONE))
                .requirements(new String[][]{new String[]{"cuttlebone","glow_cuttlebone"}})
                .build(consumer, Bakingdelight.MOD_ID + "/got_cuttlebone");
        Advancement getTruffle = Advancement.Builder.create().parent(getStart)
                .display(
                        ModItems.BLACK_TRUFFLE,
                        Text.translatable(GET_TRUFFLE_TITLE),
                        Text.translatable(GET_TRUFFLE_DESC),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("black_truffle", InventoryChangedCriterion.Conditions.items(ModItems.BLACK_TRUFFLE))
                .criterion("white_truffle", InventoryChangedCriterion.Conditions.items(ModItems.WHITE_TRUFFLE))
                .requirements(new String[][]{new String[]{"black_truffle","white_truffle"}})
                .build(consumer, Bakingdelight.MOD_ID + "/got_truffle");
        Advancement getAllAmethyst = Advancement.Builder.create().parent(getAmethystTool)
                .display(
                        Items.AMETHYST_SHARD,
                        Text.translatable(GET_ALL_AMETHYST_TITLE),
                        Text.translatable(GET_ALL_AMETHYST_DESC),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("amethyst_whisk", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_WHISK))
                .criterion("amethyst_sword", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_SWORD))
                .criterion("amethyst_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_PICKAXE))
                .criterion("amethyst_axe", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_AXE))
                .criterion("amethyst_shovel", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_SHOVEL))
                .criterion("amethyst_hoe", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_HOE))
                .criterion("amethyst_knife", InventoryChangedCriterion.Conditions.items(ModItems.AMETHYST_KNIFE))
                .build(consumer, Bakingdelight.MOD_ID + "/got_all_amethyst");
        Advancement GetCherryBomb = Advancement.Builder.create().parent(getStart)
                .display(
                        ModItems.CHERRY,
                        Text.translatable(GET_CHERRY_BOMB_TITLE),
                        Text.translatable(GET_CHERRY_BOMB_DESC),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        true
                )
                .criterion("cherry_bomb", InventoryChangedCriterion.Conditions.items(ModItems.CHERRY_BOMB))
                .build(consumer, Bakingdelight.MOD_ID + "/got_cherry_bomb");
        Advancement getGlassBowl = Advancement.Builder.create().parent(getWhisk)
                .display(
                        ModBlocks.GLASS_BOWL,
                        Text.translatable(GET_GLASS_BOWL_TITLE),
                        Text.translatable(GET_GLASS_BOWL_DESC),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("glass_bowl", InventoryChangedCriterion.Conditions.items(ModBlocks.GLASS_BOWL))
                .build(consumer, Bakingdelight.MOD_ID + "/got_glass_bowl");
        Advancement getMashedPotato = Advancement.Builder.create().parent(getGlassBowl)
                .display(
                        ModItems.MASHED_POTATO,
                        Text.translatable(GET_MASHED_POTATO_TITLE),
                        Text.translatable(GET_MASHED_POTATO_DESC),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("mashed_potato", InventoryChangedCriterion.Conditions.items(ModItems.MASHED_POTATO))
                .build(consumer, Bakingdelight.MOD_ID + "/got_mashed_potato");
        Advancement getPotatoStarch = Advancement.Builder.create().parent(getMashedPotato)
                .display(
                        ModItems.POTATO_STARCH,
                        Text.translatable(GET_POTATO_STARCH_TITLE),
                        Text.translatable(GET_POTATO_STARCH_DESC),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("potato_starch", InventoryChangedCriterion.Conditions.items(ModItems.POTATO_STARCH))
                .build(consumer, Bakingdelight.MOD_ID + "/got_potato_starch");
        Advancement getFreezer = Advancement.Builder.create().parent(getStart)
                .display(
                        ModBlocks.FREEZER,
                        Text.translatable(GET_FREEZER_TITLE),
                        Text.translatable(GET_FREEZER_DESC),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("freezer", InventoryChangedCriterion.Conditions.items(ModBlocks.FREEZER))
                .build(consumer, Bakingdelight.MOD_ID + "/got_freezer");
        Advancement getBlueIce = Advancement.Builder.create().parent(getFreezer)
                .display(
                        Items.BLUE_ICE,
                        Text.translatable(GET_BLUE_ICE_TITLE),
                        Text.translatable(GET_BLUE_ICE_DESC),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("blue_ice", InventoryChangedCriterion.Conditions.items(Items.BLUE_ICE))
                .build(consumer, Bakingdelight.MOD_ID + "/got_blue_ice");
        Advancement getAdvanceFurnace = Advancement.Builder.create().parent(getStart)
                .display(
                        ModBlocks.ADVANCE_FURNACE,
                        Text.translatable("advancement.bakingdelight.get_advance_furnace.title"),
                        Text.translatable("advancement.bakingdelight.get_advance_furnace.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("advance_furnace", InventoryChangedCriterion.Conditions.items(ModBlocks.ADVANCE_FURNACE))
                .build(consumer, Bakingdelight.MOD_ID + "/got_advance_furnace");
        Advancement getBakingTray = Advancement.Builder.create().parent(getAdvanceFurnace)
                .display(
                        ModBlocks.BAKING_TRAY,
                        Text.translatable("advancement.bakingdelight.get_baking_tray.title"),
                        Text.translatable("advancement.bakingdelight.get_baking_tray.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("baking_tray", InventoryChangedCriterion.Conditions.items(ModBlocks.BAKING_TRAY))
                .build(consumer, Bakingdelight.MOD_ID + "/got_baking_tray");
        Advancement getOven = Advancement.Builder.create().parent(getBakingTray)
                .display(
                        ModBlocks.OVEN,
                        Text.translatable(GET_OVEN_TITLE),
                        Text.translatable(GET_OVEN_DESC),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("oven", InventoryChangedCriterion.Conditions.items(ModBlocks.OVEN))
                .build(consumer, Bakingdelight.MOD_ID + "/got_oven");
        Advancement getCrowbar = Advancement.Builder.create().parent(getOven)
                .display(
                        ModItems.CROWBAR,
                        Text.translatable("advancement.bakingdelight.get_crowbar.title"),
                        Text.translatable("advancement.bakingdelight.get_crowbar.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("crowbar", InventoryChangedCriterion.Conditions.items(ModItems.CROWBAR))
                .build(consumer, Bakingdelight.MOD_ID + "/got_crowbar");
        Advancement getEggTart = Advancement.Builder.create().parent(getOven)
                .display(
                        ModItems.EGG_TART,
                        Text.translatable(GET_EGG_TART_TITLE),
                        Text.translatable(GET_EGG_TART_DESC),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        false,
                        false
                )
                .criterion("egg_tart", InventoryChangedCriterion.Conditions.items(ModItems.EGG_TART))
                .build(consumer, Bakingdelight.MOD_ID + "/got_egg_tart");
        Advancement getCream = Advancement.Builder.create().parent(getGlassBowl)
                .display(
                        ModItems.CREAM_BUCKET,
                        Text.translatable(GET_CREAM_BUCKET_TITLE),
                        Text.translatable(GET_CREAM_BUCKET_DESC),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("cream", InventoryChangedCriterion.Conditions.items(ModItems.CREAM_BUCKET))
                .build(consumer, Bakingdelight.MOD_ID + "/got_cream");
        Advancement getButter = Advancement.Builder.create().parent(getCream)
                .display(
                        ModItems.BUTTER,
                        Text.translatable(GET_BUTTER_TITLE),
                        Text.translatable(GET_BUTTER_DESC),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("butter", InventoryChangedCriterion.Conditions.items(ModItems.BUTTER))
                .build(consumer, Bakingdelight.MOD_ID + "/got_butter");
        Advancement getPuddingWIP1 = Advancement.Builder.create().parent(getButter)
                .display(
                        ModItems.PUDDING_WIP_1,
                        Text.translatable(GET_PUDDING_WIP_1_TITLE),
                        Text.translatable(GET_PUDDING_WIP_1_DESC),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("pudding_wip_1", InventoryChangedCriterion.Conditions.items(ModItems.PUDDING_WIP_1))
                .build(consumer, Bakingdelight.MOD_ID + "/got_pudding_wip_1");
        Advancement getPuddingWIP2 = Advancement.Builder.create().parent(getPuddingWIP1)
                .display(
                        ModItems.PUDDING_WIP_2,
                        Text.translatable(GET_PUDDING_WIP_2_TITLE),
                        Text.translatable(GET_PUDDING_WIP_2_DESC),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("pudding_wip_2", InventoryChangedCriterion.Conditions.items(ModItems.PUDDING_WIP_2))
                .build(consumer, Bakingdelight.MOD_ID + "/got_pudding_wip_2");
        Advancement getAllPudding = Advancement.Builder.create().parent(getPuddingWIP2)
                .display(
                        ModItems.APPLE_PUDDING,
                        Text.translatable(GET_ALL_PUDDING_TITLE),
                        Text.translatable(GET_ALL_PUDDING_DESC),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("apple_pudding", InventoryChangedCriterion.Conditions.items(ModItems.APPLE_PUDDING))
                .criterion("matcha_pudding", InventoryChangedCriterion.Conditions.items(ModItems.MATCHA_PUDDING))
                .build(consumer, Bakingdelight.MOD_ID + "/got_all_pudding");
        Advancement getMousseWIP = Advancement.Builder.create().parent(getFreezer)
                .display(
                        ModItems.MOUSSE_WIP,
                        Text.translatable(GET_MOUSSE_WIP_TITLE),
                        Text.translatable(GET_MOUSSE_WIP_DESC),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("mousse_wip", InventoryChangedCriterion.Conditions.items(ModItems.MOUSSE_WIP))
                .build(consumer, Bakingdelight.MOD_ID + "/got_mousse_wip");
        Advancement getAllMousse = Advancement.Builder.create().parent(getMousseWIP)
                .display(
                        ModItems.CHERRY_MOUSSE,
                        Text.translatable(GET_ALL_MOUSSE_TITLE),
                        Text.translatable(GET_ALL_MOUSSE_DESC),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("cherry_mousse", InventoryChangedCriterion.Conditions.items(ModItems.CHERRY_MOUSSE))
                .criterion("chocolate_mousse", InventoryChangedCriterion.Conditions.items(ModItems.CHOCOLATE_MOUSSE))
                .criterion("cream_mousse", InventoryChangedCriterion.Conditions.items(ModItems.CREAM_MOUSSE))
                .criterion("golden_apple_mousse", InventoryChangedCriterion.Conditions.items(ModItems.GOLDEN_APPLE_MOUSSE))
                .criterion("matcha_mousse", InventoryChangedCriterion.Conditions.items(ModItems.MATCHA_MOUSSE))
                .criterion("pumpkin_mousse", InventoryChangedCriterion.Conditions.items(ModItems.PUMPKIN_MOUSSE))
                .build(consumer, Bakingdelight.MOD_ID + "/got_all_mousse");
        Advancement getWheatFlour = Advancement.Builder.create().parent(getGlassBowl)
                .display(
                        ModItems.WHEAT_FLOUR,
                        Text.translatable("advancement.bakingdelight.get_wheat_flour.title"),
                        Text.translatable("advancement.bakingdelight.get_wheat_flour.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("wheat_flour", InventoryChangedCriterion.Conditions.items(ModItems.WHEAT_FLOUR))
                .build(consumer, Bakingdelight.MOD_ID + "/got_wheat_flour");
        Advancement getWheatDough = Advancement.Builder.create().parent(getWheatFlour)
                .display(
                        ModBlocks.WHEAT_DOUGH,
                        Text.translatable("advancement.bakingdelight.get_wheat_dough.title"),
                        Text.translatable("advancement.bakingdelight.get_wheat_dough.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("wheat_dough", InventoryChangedCriterion.Conditions.items(ModBlocks.WHEAT_DOUGH))
                .build(consumer, Bakingdelight.MOD_ID + "/got_wheat_dough");
        Advancement getKneadingStick = Advancement.Builder.create().parent(getWheatDough)
                .display(
                        ModItems.KNEADING_STICK,
                        Text.translatable("advancement.bakingdelight.get_kneading_stick.title"),
                        Text.translatable("advancement.bakingdelight.get_kneading_stick.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("kneading_stick", InventoryChangedCriterion.Conditions.items(ModItems.KNEADING_STICK))
                .build(consumer, Bakingdelight.MOD_ID + "/got_kneading_stick");
        Advancement getRawPizza = Advancement.Builder.create().parent(getKneadingStick)
                .display(
                        ModBlocks.RAW_PIZZA,
                        Text.translatable("advancement.bakingdelight.get_raw_pizza.title"),
                        Text.translatable("advancement.bakingdelight.get_raw_pizza.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("raw_pizza", InventoryChangedCriterion.Conditions.items(ModBlocks.RAW_PIZZA))
                .build(consumer, Bakingdelight.MOD_ID + "/got_raw_pizza");
        Advancement getPizza = Advancement.Builder.create().parent(getRawPizza)
                .display(
                        ModBlocks.PIZZA,
                        Text.translatable("advancement.bakingdelight.get_pizza.title"),
                        Text.translatable("advancement.bakingdelight.get_pizza.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("pizza", InventoryChangedCriterion.Conditions.items(ModBlocks.PIZZA))
                .build(consumer, Bakingdelight.MOD_ID + "/got_pizza");
        Advancement getBlackPepper = Advancement.Builder.create().parent(getStart)
                .display(
                        ModItems.BLACK_PEPPER_CORN,
                        Text.translatable("advancement.bakingdelight.get_black_pepper.title"),
                        Text.translatable("advancement.bakingdelight.get_black_pepper.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("black_pepper", InventoryChangedCriterion.Conditions.items(ModItems.BLACK_PEPPER_CORN))
                .build(consumer, Bakingdelight.MOD_ID + "/got_black_pepper");
        Advancement getCheese = Advancement.Builder.create().parent(getOven)
                .display(
                        ModItems.CHEESE,
                        Text.translatable("advancement.bakingdelight.get_cheese.title"),
                        Text.translatable("advancement.bakingdelight.get_cheese.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("cheese", InventoryChangedCriterion.Conditions.items(ModItems.CHEESE))
                .build(consumer, Bakingdelight.MOD_ID + "/got_cheese");
        Advancement getBDCAndBDI = Advancement.Builder.create().parent(getStart)
                .display(
                        ModBlocks.BIOGAS_DIGESTER_IO,
                        Text.translatable("advancement.bakingdelight.bdc_bdi.title"),
                        Text.translatable("advancement.bakingdelight.bdc_bdi.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("bdc", InventoryChangedCriterion.Conditions.items(ModBlocks.BIOGAS_DIGESTER_CONTROLLER))
                .criterion("bdi", InventoryChangedCriterion.Conditions.items(ModBlocks.BIOGAS_DIGESTER_IO))
                .build(consumer, Bakingdelight.MOD_ID + "/got_bdc_bdi");
        Advancement getGasCanister = Advancement.Builder.create().parent(getBDCAndBDI)
                .display(
                        ModBlocks.GAS_CANISTER,
                        Text.translatable("advancement.bakingdelight.gas_canister.title"),
                        Text.translatable("advancement.bakingdelight.gas_canister.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("gas_canister", InventoryChangedCriterion.Conditions.items(ModBlocks.GAS_CANISTER))
                .build(consumer, Bakingdelight.MOD_ID + "/got_gas_canister");
        Advancement getGasCookingStove = Advancement.Builder.create().parent(getGasCanister)
                .display(
                        ModBlocks.GAS_COOKING_STOVE,
                        Text.translatable("advancement.bakingdelight.gas_cooking_stove.title"),
                        Text.translatable("advancement.bakingdelight.gas_cooking_stove.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        false,
                        false
                )
                .criterion("gas_cooking_stove", InventoryChangedCriterion.Conditions.items(ModBlocks.GAS_COOKING_STOVE))
                .build(consumer, Bakingdelight.MOD_ID + "/got_gas_cooking_stove");
        Advancement getWoodenBasin = Advancement.Builder.create().parent(getGasCookingStove)
                .display(
                        ModBlocks.WOODEN_BASIN,
                        Text.translatable("advancement.bakingdelight.wooden_basin.title"),
                        Text.translatable("advancement.bakingdelight.wooden_basin.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("wooden_basin", InventoryChangedCriterion.Conditions.items(ModBlocks.WOODEN_BASIN))
                .build(consumer, Bakingdelight.MOD_ID + "/got_wooden_basin");
        Advancement getFilter = Advancement.Builder.create().parent(getWoodenBasin)
                .display(
                        ModItems.FILTER,
                        Text.translatable("advancement.bakingdelight.filter.title"),
                        Text.translatable("advancement.bakingdelight.filter.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("filter", InventoryChangedCriterion.Conditions.items(ModItems.FILTER))
                .build(consumer, Bakingdelight.MOD_ID + "/got_filter");
        Advancement getVegetableOil = Advancement.Builder.create().parent(getFilter)
                .display(
                        ModItems.VEGETABLE_OIL_BOTTLE,
                        Text.translatable("advancement.bakingdelight.vegetable_oil.title"),
                        Text.translatable("advancement.bakingdelight.vegetable_oil.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("bottle", InventoryChangedCriterion.Conditions.items(ModItems.VEGETABLE_OIL_BOTTLE))
                .criterion("bucket", InventoryChangedCriterion.Conditions.items(ModItems.VEGETABLE_OIL_BUCKET))
                .requirements(new String[][]{new String[]{"bottle","bucket"}})
                .build(consumer, Bakingdelight.MOD_ID + "/got_vegetable_oil");
        Advancement getDeepFryer = Advancement.Builder.create().parent(getVegetableOil)
                .display(
                        ModBlocks.DEEP_FRYER,
                        Text.translatable("advancement.bakingdelight.deep_fryer.title"),
                        Text.translatable("advancement.bakingdelight.deep_fryer.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("deep_fryer", InventoryChangedCriterion.Conditions.items(ModBlocks.DEEP_FRYER))
                .build(consumer, Bakingdelight.MOD_ID + "/got_deep_fryer");
        Advancement getDeepFryBasket = Advancement.Builder.create().parent(getVegetableOil)
                .display(
                        ModBlocks.DEEP_FRY_BASKET,
                        Text.translatable("advancement.bakingdelight.deep_fry_basket.title"),
                        Text.translatable("advancement.bakingdelight.deep_fry_basket.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("deep_fry_basket", InventoryChangedCriterion.Conditions.items(ModBlocks.DEEP_FRY_BASKET))
                .build(consumer, Bakingdelight.MOD_ID + "/got_deep_fry_basket");
        Advancement eatAllFriedFood = Advancement.Builder.create().parent(getDeepFryer)
                .display(
                        ModItems.FRIED_MILK,
                        Text.translatable("advancement.bakingdelight.all_fried.title"),
                        Text.translatable("advancement.bakingdelight.all_fried.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(550))
                .criterion("potato_chip", ConsumeItemCriterion.Conditions.item(ModItems.POTATO_CHIP))
                .criterion("onion_ring", ConsumeItemCriterion.Conditions.item(ModItems.ONION_RING))
                .criterion("salmon", ConsumeItemCriterion.Conditions.item(ModItems.FRIED_SALMON))
                .criterion("milk", ConsumeItemCriterion.Conditions.item(ModItems.FRIED_MILK))
                .criterion("dough_stick", ConsumeItemCriterion.Conditions.item(ModItems.FRIED_DOUGH_STICK))
                .criterion("cod", ConsumeItemCriterion.Conditions.item(ModItems.FRIED_COD))
                .criterion("apple", ConsumeItemCriterion.Conditions.item(ModItems.FRIED_APPLE))
                .criterion("cheese_ball", ConsumeItemCriterion.Conditions.item(ModItems.CHEESE_BALL))
                .criterion("chicken_fillet", ConsumeItemCriterion.Conditions.item(ModItems.CHICKEN_FILLET))
                .build(consumer, Bakingdelight.MOD_ID + "/eat_all_fried");
        Advancement eatWitherCake = Advancement.Builder.create().parent(getStart)
                .display(
                        ModItems.WITHER_ROSE_CAKE,
                        Text.translatable("advancement.bakingdelight.wither_rose_cake.title"),
                        Text.translatable("advancement.bakingdelight.wither_rose_cake.desc"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true
                )
                .rewards(AdvancementRewards.Builder.experience(1500))
                .criterion("wither_rose_cake", ConsumeItemCriterion.Conditions.item(ModItems.WITHER_ROSE_CAKE))
                .build(consumer, Bakingdelight.MOD_ID + "/eat_wither_rose_cake");
        Advancement getSpatula = Advancement.Builder.create().parent(getGasCookingStove)
                .display(
                        ModItems.SPATULA,
                        Text.translatable("advancement.bakingdelight.spatula.title"),
                        Text.translatable("advancement.bakingdelight.spatula.desc"),
                        null,
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .criterion("spatula", InventoryChangedCriterion.Conditions.items(ModItems.SPATULA))
                .build(consumer, Bakingdelight.MOD_ID + "/got_spatula");
        Advancement getKitchenUtensilHolder = Advancement.Builder.create().parent(getStart)
                .display(
                        ModBlocks.KITCHEN_UTENSIL_HOLDER,
                        Text.translatable("advancement.bakingdelight.kuh.title"),
                        Text.translatable("advancement.bakingdelight.kuh.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("kuh", InventoryChangedCriterion.Conditions.items(ModBlocks.KITCHEN_UTENSIL_HOLDER))
                .build(consumer, Bakingdelight.MOD_ID + "/got_kuh");
        Advancement getCuisineTable = Advancement.Builder.create().parent(getStart)
                .display(
                        ModBlocks.CUISINE_TABLE,
                        Text.translatable("advancement.bakingdelight.cuisine_table.title"),
                        Text.translatable("advancement.bakingdelight.cuisine_table.desc"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("cuisine_table", InventoryChangedCriterion.Conditions.items(ModBlocks.CUISINE_TABLE))
                .build(consumer, Bakingdelight.MOD_ID + "/got_cuisine_table");
    }
}
