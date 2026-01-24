package net.legacy.legacies.mixin.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = CombatRules.class)
public class CombatRulesMixin {

    @Inject(at = @At(value = "HEAD"), method = "getDamageAfterAbsorb", cancellable = true)
    private static void getDamageAfterAbsorb(LivingEntity livingEntity, float f, DamageSource damageSource, float defence, float toughness, CallbackInfoReturnable<Float> cir) {
        float multiplier = 0.75F;
        defence = defence * multiplier;
        toughness = toughness * multiplier;

        float i = 2.0F + toughness / 4.0F;
        float j = Mth.clamp(defence - f / i, defence * 0.2F, 20.0F);
        float k = j / 25.0F;
        ItemStack itemStack = damageSource.getWeaponItem();
        float l;
        if (itemStack != null && livingEntity.level() instanceof ServerLevel serverLevel) {
            l = Mth.clamp(EnchantmentHelper.modifyArmorEffectiveness(serverLevel, itemStack, livingEntity, damageSource, k), 0.0F, 1.0F);
        } else {
            l = k;
        }

        float m = 1.0F - l;
        cir.setReturnValue(f * m);
    }
}
