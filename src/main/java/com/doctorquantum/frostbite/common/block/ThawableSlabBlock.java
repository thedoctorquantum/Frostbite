package com.doctorquantum.frostbite.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ThawableSlabBlock extends SlabBlock {

	private final Block thawBlock;
	
	public ThawableSlabBlock(Block thawBlock, Properties properties) {
		super(properties.tickRandomly());
		this.thawBlock = thawBlock;
	}
	
	@Override
	public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		Random random = world.getRandom();
		boolean canThaw = world.getBiome(pos).getTemperature(pos) > -1f || world.getLightFor(LightType.BLOCK, pos) > 11f - state.getOpacity(world, pos);
		if(canThaw) {
			thaw(state, world, pos);
		}
	}
	
	public void thaw(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, thawBlock.getDefaultState().with(TYPE, state.get(TYPE)));
	}

}
