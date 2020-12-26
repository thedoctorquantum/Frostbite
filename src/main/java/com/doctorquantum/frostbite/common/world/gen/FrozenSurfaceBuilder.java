package com.doctorquantum.frostbite.common.world.gen;

import com.doctorquantum.frostbite.common.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class FrozenSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	
	public static SurfaceBuilderConfig CONFIG = new SurfaceBuilderConfig(
			Blocks.PACKED_ICE.getDefaultState(), 
			ModBlocks.PERMAFROST.get().getDefaultState(), 
			Blocks.GRAVEL.getDefaultState()
	);
	
	public FrozenSurfaceBuilder() {
		super(SurfaceBuilderConfig::deserialize);
	}
	
	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, 
	double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, CONFIG);
	}

}