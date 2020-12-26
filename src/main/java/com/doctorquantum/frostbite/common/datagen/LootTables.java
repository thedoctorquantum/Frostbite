package com.doctorquantum.frostbite.common.datagen;

import com.doctorquantum.frostbite.Frostbite;
import com.doctorquantum.frostbite.common.block.ModBlocks;
import com.doctorquantum.frostbite.common.block.WildCropBlock;
import net.minecraft.data.DataGenerator;

public class LootTables extends LootGenerator {

	public LootTables(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
	}
	
	@Override
	protected void registerTables() {
		ModBlocks.BLOCKS.getEntries()
		.filter(block -> !(block instanceof WildCropBlock))
		.forEach(block -> {
			registerSelfDropping(block);
		});
	}
	
    @Override
    public String getName() {
		return Frostbite.MODID + ":loot_tables";
    }
	
}
