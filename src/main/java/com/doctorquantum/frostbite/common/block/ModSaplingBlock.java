package com.doctorquantum.frostbite.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.Random;
import java.util.function.Supplier;

public class ModSaplingBlock extends BushBlock implements IGrowable {

	public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
	private static final VoxelShape SHAPE = Block.makeCuboidShape(2.0d, 0.0d, 2.0d, 14.0d, 12.0d, 14.0d);
	private final Supplier<Tree> tree;
	
	public ModSaplingBlock(Supplier<Tree> tree, Properties properties) {
		super(properties);
		this.tree = tree;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		super.tick(state, worldIn, pos, rand);
		if(!worldIn.isAreaLoaded(pos, 1)) {
			return;
		}
		if(worldIn.getLight(pos.up()) >= 9 && rand.nextInt() == 7) {
			this.grow(worldIn, rand, pos, state);
		}
	}
	
	public void grow(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
		if(state.get(STAGE) == 0) {
			world.setBlockState(pos, state.cycle(STAGE), 4);
		} else {
			if(!ForgeEventFactory.saplingGrowTree(world, rand, pos)) { return; }
			this.tree.get().place(world, world.getChunkProvider().getChunkGenerator(), pos, state, rand);
		}
	}
	
	@Override
	public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
		this.grow(world, pos, state, rand);
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return (double) worldIn.rand.nextFloat() < 0.45d;
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(STAGE);
	}

}
