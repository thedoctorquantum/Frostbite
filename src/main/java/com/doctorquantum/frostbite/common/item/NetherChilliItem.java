package com.doctorquantum.frostbite.common.item;

import com.doctorquantum.frostbite.common.effects.ModEffects;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;

public class NetherChilliItem extends Item {

	public NetherChilliItem(Properties properties) {
		super(properties.food(new Food.Builder().hunger(6).fastToEat().effect(() -> new EffectInstance(ModEffects.COZY.get(), 600), 1f).build()));
	}
	
}