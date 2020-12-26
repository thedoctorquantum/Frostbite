package com.doctorquantum.frostbite.common.datagen;

import com.doctorquantum.frostbite.Frostbite;
import com.doctorquantum.frostbite.common.block.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class BlockTags extends BlockTagsProvider {
	
	public BlockTags(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void registerTags() {
		getBuilder(new Tag<>(new ResourceLocation("leaves"))).add(ModBlocks.VERGLAS_LEAVES.get());
		getBuilder(new Tag<>(new ResourceLocation("walls"))).add(ModBlocks.PERMAFROST_BRICK_WALL.get());
		getBuilder(new Tag<>(forgeLoc("fences/wooden"))).add(ModBlocks.VERGLAS_FENCE.get());
		getBuilder(new Tag<>(forgeLoc("fence_gates/wooden"))).add(ModBlocks.VERGLAS_FENCE_GATE.get());
		getBuilder(new Tag<>(new ResourceLocation("fences"))).add(ModBlocks.VERGLAS_FENCE.get());
		getBuilder(new Tag<>(new ResourceLocation("fence_gates"))).add(ModBlocks.VERGLAS_FENCE_GATE.get());
	}
	
	public ResourceLocation forgeLoc(String path) {
		return new ResourceLocation("forge", path);
	}
	
	@Override
	public String getName() {
		return Frostbite.MODID + ":block_tags";
	}

}
