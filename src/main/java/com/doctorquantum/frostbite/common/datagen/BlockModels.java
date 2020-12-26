package com.doctorquantum.frostbite.common.datagen;

import com.doctorquantum.frostbite.Frostbite;
import com.doctorquantum.frostbite.common.block.FireplaceBlock;
import com.doctorquantum.frostbite.common.block.ModBlocks;
import com.doctorquantum.frostbite.common.block.WildCropBlock;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

import java.util.stream.Stream;

public class BlockModels extends BlockStateProvider {
	
	private final ExistingFileHelper existingFileHelper;
	
	public BlockModels(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, Frostbite.MODID, exFileHelper);
		this.existingFileHelper = exFileHelper;
	}
	
	@Override
	protected void registerStatesAndModels() {
		Stream<Block> blocks = ModBlocks.BLOCKS.getEntries();
		
		slabBlock((SlabBlock) ModBlocks.PERMAFROST_BRICK_SLAB.get(), modLoc("block/permafrost_bricks"), modLoc("block/permafrost_bricks"));
		stairsBlock((StairsBlock) ModBlocks.PERMAFROST_BRICK_STAIRS.get(), modLoc("block/permafrost_bricks"));
		wallBlock((WallBlock) ModBlocks.PERMAFROST_BRICK_WALL.get(), modLoc("block/permafrost_bricks"));
		models().wallInventory(ModBlocks.PERMAFROST_BRICK_WALL.get().getRegistryName().getPath() + "_inventory",  modLoc("block/permafrost_bricks"));
		models().cubeAll(ModBlocks.VERGLAS_WOOD.get().getRegistryName().getPath(), modLoc("block/verglas_log"));	
		slabBlock((SlabBlock) ModBlocks.VERGLAS_SLAB.get(), modLoc("block/verglas_planks"), modLoc("block/verglas_planks"));
		stairsBlock((StairsBlock) ModBlocks.VERGLAS_STAIRS.get(), modLoc("block/verglas_planks"));
		fenceBlock((FenceBlock) ModBlocks.VERGLAS_FENCE.get(), modLoc("block/verglas_planks"));
		models().fenceInventory(ModBlocks.VERGLAS_FENCE.get().getRegistryName().getPath() + "_inventory", modLoc("block/verglas_planks"));
		fenceGateBlock((FenceGateBlock) ModBlocks.VERGLAS_FENCE_GATE.get(), modLoc("block/verglas_planks"));
		logBlock((LogBlock) ModBlocks.VERGLAS_LOG.get());
		
		ModBlocks.BLOCKS.getBlacklistFilteredByType(
			FenceBlock.class, 
			FenceGateBlock.class,
			WildCropBlock.class,
			BushBlock.class,
			LogBlock.class,
			SlabBlock.class,
			StairsBlock.class,
			WallBlock.class,
			FireplaceBlock.class
		).forEach(block -> {
			if(block != ModBlocks.VERGLAS_WOOD.get()) {
				simpleBlock(block);
			}
		});
		for(int i = 0; i < 4; i++) {
			models().cross("nether_chill_stage" + i, modLoc("block/nether_chilli_stage" + i));
		}
		blocks.filter((block) -> block instanceof BushBlock)
			  .forEach(block -> {
				  models().cross(block.getRegistryName().getPath(), modLoc("block/" + block.getRegistryName().getPath()));
			  });
	}
	
	@Override
	public String getName() {
		return Frostbite.MODID + ":block_models";
	}

}
