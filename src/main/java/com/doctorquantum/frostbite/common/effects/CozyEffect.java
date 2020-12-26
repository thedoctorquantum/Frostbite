package com.doctorquantum.frostbite.common.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;

import java.util.Collection;

public class CozyEffect extends Effect {
	
	public CozyEffect() {
		super(EffectType.BENEFICIAL, 0x0);
	}
		
	@Override
	public void performEffect(LivingEntity entity, int amplifier) {
		Collection<EffectInstance> effects =  entity.getActivePotionEffects();
		for(EffectInstance effect : effects) {
			Effect potion = effect.getPotion();
			if(effect.getPotion() == ModEffects.FROSTBITE.get()) {
				entity.removePotionEffect(potion);
			}
		}
	}
	
}
