package net.legacy.legacies.integration;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.yus.foodmod.config.FoodmodConfig;
import net.yus.foodmod.init.Iteminit;

public class MoreFoodLootTables {
    private static final ResourceLocation JUNGLE_LEAVES_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "blocks/jungle_leaves");
    private static final ResourceLocation MANGROVE_LEAVES_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "blocks/mangrove_leaves");
    private static final ResourceLocation GRASS_BLOCK_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "blocks/short_grass");
    private static final ResourceLocation FERN_BLOCK_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "blocks/fern");
    private static final ResourceLocation TRAILRUIN_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "archaeology/trail_ruins_common");
    private static final ResourceLocation MANSION_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/woodland_mansion");
    private static final ResourceLocation STRONGHOLD_CROSSING_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/stronghold_crossing");
    private static final ResourceLocation STRONGHOLD_CORRIDOR_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/stronghold_corridor");
    private static final ResourceLocation UNDERWATER_RUIN_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/underwater_ruin_big");
    private static final ResourceLocation SIMPLE_DUNGEON_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/simple_dungeon");
    private static final ResourceLocation PILLAGER_OUTPOST_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/pillager_outpost");
    private static final ResourceLocation NETHER_BRIDGE_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/nether_bridge");
    private static final ResourceLocation IGLOO_STRUCTURE_CHEST_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/igloo_chest");
    private static final ResourceLocation SHIPWRECK_STRUCTURE_SUPPLY_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/shipwreck_supply");
    private static final ResourceLocation BASTION_OTHER_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/bastion_other");
    private static final ResourceLocation ANCIENT_CITY_ICE_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/ancient_city_ice_box");
    private static final ResourceLocation BASTION_HOGLIN_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/bastion_hoglin_stable");
    private static final ResourceLocation END_CITY_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/end_city_treasure");
    private static final ResourceLocation VILLAGE_STRUCTURE_PLAINS_HOUSE_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/village/village_plains_house");
    private static final ResourceLocation VILLAGE_STRUCTURE_DESERT_HOUSE_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/village/village_desert_house");
    private static final ResourceLocation VILLAGE_STRUCTURE_TAIGA_HOUSE_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/village/village_taiga_house");
    private static final ResourceLocation VILLAGE_STRUCTURE_SNOWY_HOUSE_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/village/village_snowy_house");
    private static final ResourceLocation ABANDONED_STRUCTURE_MINESHAFT_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/abandoned_mineshaft");
    private static final ResourceLocation JUNGLE_TEMPLE_STRUCTURE_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/jungle_temple");
    private static final ResourceLocation DESERT_PYRAMID_STRUCTURE_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/desert_pyramid");
    private static final ResourceLocation RUINED_PORTAL_STRUCTURE_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/ruined_portal");

    public static void modifyLootTables() {
        FoodmodConfig config = (FoodmodConfig) AutoConfig.getConfigHolder(FoodmodConfig.class).getConfig();
        if (config.disableLootInjects) {
            LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
                LootPool.Builder poolBuilder;
/*                if (source.isBuiltin() && GRASS_BLOCK_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.06F)).add(LootItem.lootTableItem(Iteminit.RICE_SEEDS)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && FERN_BLOCK_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.1F)).add(LootItem.lootTableItem(Iteminit.BLUE_BERRIES)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }*/

                if (source.isBuiltin() && JUNGLE_LEAVES_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.005F)).add(LootItem.lootTableItem(Iteminit.BANANA)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && MANGROVE_LEAVES_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.005F)).add(LootItem.lootTableItem(Iteminit.KIWI)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && TRAILRUIN_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.01F)).add(LootItem.lootTableItem(Iteminit.RICE_SEEDS)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && MANSION_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.GOLDEN_POTATO)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && MANSION_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.1F)).add(LootItem.lootTableItem(Iteminit.RICE_SEEDS)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && STRONGHOLD_CROSSING_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.025F)).add(LootItem.lootTableItem(Iteminit.GOLDEN_POTATO)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && STRONGHOLD_CROSSING_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(Iteminit.RICE)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && STRONGHOLD_CORRIDOR_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(Iteminit.RICE)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && UNDERWATER_RUIN_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.04F)).add(LootItem.lootTableItem(Iteminit.GOLDEN_POTATO)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && SIMPLE_DUNGEON_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.1F)).add(LootItem.lootTableItem(Iteminit.RICE_SEEDS)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && SIMPLE_DUNGEON_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.GOLDEN_POTATO)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && SIMPLE_DUNGEON_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.25F)).add(LootItem.lootTableItem(Iteminit.BANANA)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && SHIPWRECK_STRUCTURE_SUPPLY_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(Iteminit.BANANA)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && SHIPWRECK_STRUCTURE_SUPPLY_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(Iteminit.RICE)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && RUINED_PORTAL_STRUCTURE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.1F)).add(LootItem.lootTableItem(Iteminit.GOLDEN_POTATO)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && RUINED_PORTAL_STRUCTURE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(Iteminit.FUNGUS_STEW)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && RUINED_PORTAL_STRUCTURE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(Iteminit.COOKED_NETHER_WART)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && PILLAGER_OUTPOST_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(Iteminit.BLUE_BERRIES)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && NETHER_BRIDGE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.COOKED_NETHER_WART)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && JUNGLE_TEMPLE_STRUCTURE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(Iteminit.COOKED_BAMBOO)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && JUNGLE_TEMPLE_STRUCTURE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(Iteminit.BANANA)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && IGLOO_STRUCTURE_CHEST_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.5F)).add(LootItem.lootTableItem(Iteminit.CANDY_CANE)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && IGLOO_STRUCTURE_CHEST_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.6F)).add(LootItem.lootTableItem(Iteminit.MARSHMALLOW)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && END_CITY_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.CHORUS_FRUIT_BUBBLEGUM)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && DESERT_PYRAMID_STRUCTURE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.5F)).add(LootItem.lootTableItem(Iteminit.COOKED_SUGAR_CANE)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 8.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && DESERT_PYRAMID_STRUCTURE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.GOLDEN_POTATO)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && BASTION_OTHER_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.COOKED_WARPED_FUNGUS)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && BASTION_OTHER_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.COOKED_CRIMSON_FUNGUS)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && BASTION_OTHER_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.COOKED_NETHER_WART)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && BASTION_OTHER_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.NETHER_WART_SOUP)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && BASTION_OTHER_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.FUNGUS_STEW)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && BASTION_HOGLIN_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.COOKED_WARPED_FUNGUS)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && BASTION_HOGLIN_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.COOKED_CRIMSON_FUNGUS)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && BASTION_HOGLIN_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.COOKED_NETHER_WART)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && BASTION_HOGLIN_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.NETHER_WART_SOUP)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && BASTION_HOGLIN_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.FUNGUS_STEW)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && ANCIENT_CITY_ICE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.5F)).add(LootItem.lootTableItem(Iteminit.BLUE_BERRIES)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 10.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && ANCIENT_CITY_ICE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.4F)).add(LootItem.lootTableItem(Iteminit.BANANA)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 10.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && ANCIENT_CITY_ICE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(Iteminit.CHOCOLATE_BAR)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && ANCIENT_CITY_ICE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.5F)).add(LootItem.lootTableItem(Iteminit.MARSHMALLOW)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 10.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && ANCIENT_CITY_ICE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(Iteminit.SLICE_OF_CAKE)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 7.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && ABANDONED_STRUCTURE_MINESHAFT_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.RICE_SEEDS)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && ABANDONED_STRUCTURE_MINESHAFT_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.2F)).add(LootItem.lootTableItem(Iteminit.GOLDEN_POTATO)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && ABANDONED_STRUCTURE_MINESHAFT_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(Iteminit.BLUE_BERRIES)).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 6.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && VILLAGE_STRUCTURE_DESERT_HOUSE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.7F)).add(LootItem.lootTableItem(Iteminit.COOKED_SUGAR_CANE)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && VILLAGE_STRUCTURE_SNOWY_HOUSE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(Iteminit.CANDY_CANE)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && VILLAGE_STRUCTURE_SNOWY_HOUSE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.4F)).add(LootItem.lootTableItem(Iteminit.MARSHMALLOW)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && VILLAGE_STRUCTURE_PLAINS_HOUSE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.4F)).add(LootItem.lootTableItem(Iteminit.RICE)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (source.isBuiltin() && VILLAGE_STRUCTURE_TAIGA_HOUSE_ID.equals(key.location())) {
                    poolBuilder = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(LootItemRandomChanceCondition.randomChance(0.4F)).add(LootItem.lootTableItem(Iteminit.BLUE_BERRIES)).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

            });
        }
    }
}