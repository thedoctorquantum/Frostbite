package com.doctorquantum.frostbite.common.effects;

import com.doctorquantum.frostbite.common.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;

import java.util.ArrayList;
import java.util.List;

public class FrostBiteEffect extends Effect {

	public FrostBiteEffect() {
		super(EffectType.HARMFUL, 0x9de1f2);
	}

	@Override
	public void performEffect(LivingEntity livingEntity, int amplifier) {
		if(livingEntity.getHealth() > 1.0F) {
			livingEntity.attackEntityFrom(DamageSource.MAGIC, 1.0F);
		}
		super.performEffect(livingEntity, amplifier);
	}

}
