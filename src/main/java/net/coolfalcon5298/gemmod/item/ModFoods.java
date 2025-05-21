package net.coolfalcon5298.gemmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1f).build();
    public static FoodProperties CORN = new FoodProperties.Builder().nutrition(5)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200), 0.1f).build();

}
