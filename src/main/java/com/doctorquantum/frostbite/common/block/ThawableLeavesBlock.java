package com.doctorquantum.frostbite.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ThawableLeavesBlock extends LeavesBlock {

	private final Block thawBlock;
	
	public ThawableLeavesBlock(Block thawBlock, Properties properties) {
		super(properties);
		this.thawBlock = thawBlock;
	}
	
	@Override
	public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		Random random = world.getRandom();
		boolean canThaw = world.getBiome(pos).getTemperature(pos) > -1f || world.getLightFor(LightType.BLOCK, pos) > 11 ;
		if(canThaw) {
			thaw(state, world, pos);
		}
	}
	
	public void thaw(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, thawBlock.getDefaultState());
	}

}
