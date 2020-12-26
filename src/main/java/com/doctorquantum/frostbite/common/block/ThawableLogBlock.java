package com.doctorquantum.frostbite.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ThawableLogBlock extends LogBlock {

	private final Block thawBlock;
	
	public ThawableLogBlock(Block thawBlock, MaterialColor verticalColorIn, Properties properties) {
		super(verticalColorIn, properties);
		this.thawBlock = thawBlock;
	}
	
	@Override
	public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		Random random = world.getRandom();
		boolean canThaw = world.getBiome(pos).getDefaultTemperature() > -1f || world.getLightFor(LightType.BLOCK, pos) > 11f;
		if(canThaw) {
			thaw(state, world, pos);
		}
	}
	
	public void thaw(BlockState state, World world, BlockPos pos) {
		world.setBlockState(pos, thawBlock.getDefaultState().with(LogBlock.AXIS, state.get(LogBlock.AXIS)));
	}

}
