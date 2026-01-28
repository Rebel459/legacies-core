package net.legacy.legacies.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.legacy.legacies.Legacies;
import net.legacy.legacies.util.RegistryHelper;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.GenerationStep;

public class LegaciesBiomeModifications {

    public static void init() {
        jungleFlowers();
        palmTrees();
    }

    private static void jungleFlowers() {
        BiomeModifications.create(Legacies.id("jungle_flowers")).add(
                ModificationPhase.ADDITIONS,
                BiomeSelectors.all(),
                (biomeSelectionContext, context) -> {
                    BiomeModificationContext.GenerationSettingsContext generationSettings = context.getGenerationSettings();

                    if (biomeSelectionContext.hasTag(RegistryHelper.biomeTag("legacies:feature/has_jungle_flowers"))) {
                        generationSettings.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, RegistryHelper.placedFeature("wilderwild:flower_jungle"));
                        generationSettings.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, RegistryHelper.placedFeature("wilderwild:tall_flower_jungle"));
                    }
                    if (biomeSelectionContext.hasTag(RegistryHelper.biomeTag("legacies:feature/has_sparse_jungle_flowers"))) {
                        generationSettings.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, RegistryHelper.placedFeature("wilderwild:flower_sparse_jungle"));
                    }
                });
    }

    private static void palmTrees() {
        BiomeModifications.create(Legacies.id("palm_trees")).add(
                ModificationPhase.POST_PROCESSING,
                BiomeSelectors.all(),
                (biomeSelectionContext, context) -> {
                    BiomeModificationContext.GenerationSettingsContext generationSettings = context.getGenerationSettings();
                    if (biomeSelectionContext.getBiomeKey().equals(RegistryHelper.biome("bloom:tropical_beach"))) {
                        generationSettings.addFeature(
                                GenerationStep.Decoration.VEGETAL_DECORATION,
                                RegistryHelper.placedFeature("wilderwild:palms_warm_beach")
                        );
                        generationSettings.addFeature(
                                GenerationStep.Decoration.VEGETAL_DECORATION,
                                RegistryHelper.placedFeature("wilderwild:fallen_palm_placed_rare")
                        );
                    }

                    if (biomeSelectionContext.getBiomeKey().equals(RegistryHelper.biome("wilderwild:oasis"))) {
                        generationSettings.addFeature(
                                GenerationStep.Decoration.VEGETAL_DECORATION,
                                RegistryHelper.placedFeature("wilderwild:palms_oasis")
                        );
                        generationSettings.addFeature(
                                GenerationStep.Decoration.VEGETAL_DECORATION,
                                RegistryHelper.placedFeature("wilderwild:fallen_palm_placed")
                        );
                    }
                });
    }
}
