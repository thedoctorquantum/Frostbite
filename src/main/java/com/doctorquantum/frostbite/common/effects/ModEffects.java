package com.doctorquantum.frostbite.common.effects;

import com.doctorquantum.frostbite.common.util.ModRegistry;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {

	public static final ModRegistry<Effect> EFFECTS = new ModRegistry<>(ForgeRegistries.POTIONS);
	public static final ModRegistry<Potion> POTIONS = new ModRegistry<>(ForgeRegistries.POTION_TYPES);
		
	public static final RegistryObject<FrostBiteEffect> FROSTBITE = EFFECTS.register("frostbite", FrostBiteEffect::new);
	public static final RegistryObject<CozyEffect> COZY = EFFECTS.register("cozy", CozyEffect::new);
	public static final RegistryObject<Potion> FROSTBITE_POTION = POTIONS.register("frostbite", () -> new Potion(new EffectInstance(FROSTBITE.get(), 1200, 0)));
	
}