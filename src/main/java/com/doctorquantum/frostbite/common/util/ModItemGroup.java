package com.doctorquantum.frostbite.common.util;

import com.doctorquantum.frostbite.Frostbite;
import com.doctorquantum.frostbite.common.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
	
	public static final ItemGroup FROSTBITE = new ItemGroup(Frostbite.MODID) {
		
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.PERMAFROST.get());	
		}
		
	};	
	
}
