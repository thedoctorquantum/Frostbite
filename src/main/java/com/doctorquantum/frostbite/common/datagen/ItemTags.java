package com.doctorquantum.frostbite.common.datagen;

import com.doctorquantum.frostbite.Frostbite;
import com.doctorquantum.frostbite.common.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ItemTags extends ItemTagsProvider {
	
	public ItemTags(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void registerTags() {
		getBuilder(new Tag<>(new ResourceLocation("logs"))).add(ModBlocks.VERGLAS_LOG.get().asItem());
		getBuilder(new Tag<>(new ResourceLocation("planks"))).add(ModBlocks.VERGLAS_PLANKS.get().asItem());
		getBuilder(new Tag<>(new ResourceLocation("wooden_slabs"))).add(ModBlocks.VERGLAS_SLAB.get().asItem());
	}
	
	public ResourceLocation forgeLoc(String path) {
		return new ResourceLocation("forge", path);
	}
	
	@Override
	public String getName() {
		return Frostbite.MODID + ":item_tags";
	}

}
