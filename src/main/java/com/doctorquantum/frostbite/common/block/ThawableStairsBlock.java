package com.doctorquantum.frostbite.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Supplier;

public class ThawableStairsBlock extends StairsBlock {

	private final Block thawBlock;
	
	public ThawableStairsBlock(Block thawBlock, Supplier<BlockState> supplier, Properties properties) {
		super(supplier, properties.tickRandomly());
		this.thawBlock = thawBlock;
	}
	
	@Override
	public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		Random random = world.getRandom();
		boolean canThaw = world.getBiome(pos).getTemperature(pos) > -1f || world.getLightFor(LightType.BLOCK, pos) > 11;
		if(canThaw) {
			thaw(state, world, pos);
		}
	}
	
	public void thaw(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, thawBlock.getDefaultState().with(FACING, state.get(FACING)));
	}

}
