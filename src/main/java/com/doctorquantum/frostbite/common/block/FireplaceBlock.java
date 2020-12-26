package com.doctorquantum.frostbite.common.block;

import com.doctorquantum.frostbite.common.effects.ModEffects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class FireplaceBlock extends DirectionalBlock {

	private static final VoxelShape NORTH_SHAPE = Stream.of(
			Block.makeCuboidShape(1, 0, 3, 15, 12, 15),
			Block.makeCuboidShape(13, 0, 2, 15, 10, 3),
			Block.makeCuboidShape(1, 0, 2, 3, 10, 3),
			Block.makeCuboidShape(0, 12, 0, 16, 13, 16),
			Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
			Block.makeCuboidShape(3, 0, 2, 13, 2, 3),
			Block.makeCuboidShape(1, 10, 2, 15, 12, 3),
			Block.makeCuboidShape(3, 16, 3, 13, 24, 13))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

	private static final VoxelShape SOUTH_SHAPE = Stream.of(
			Block.makeCuboidShape(1, 0, 1, 15, 12, 13),
			Block.makeCuboidShape(1, 0, 13, 3, 10, 14),
			Block.makeCuboidShape(13, 0, 13, 15, 10, 14),
			Block.makeCuboidShape(0, 12, 0, 16, 13, 16),
			Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
			Block.makeCuboidShape(3, 0, 13, 13, 2, 14),
			Block.makeCuboidShape(1, 10, 13, 15, 12, 14),
			Block.makeCuboidShape(3, 16, 3, 13, 24, 13))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	
	private static final VoxelShape EAST_SHAPE = Stream.of(
			Block.makeCuboidShape(1, 0, 1, 13, 12, 15),
			Block.makeCuboidShape(13, 0, 13, 14, 10, 15),
			Block.makeCuboidShape(13, 0, 1, 14, 10, 3),
			Block.makeCuboidShape(0, 12, 0, 16, 13, 16),
			Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
			Block.makeCuboidShape(13, 0, 3, 14, 2, 13),
			Block.makeCuboidShape(13, 10, 1, 14, 12, 15),
			Block.makeCuboidShape(3, 16, 3, 13, 24, 13))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	
	private static final VoxelShape WEST_SHAPE = Stream.of(
			Block.makeCuboidShape(3, 0, 1, 15, 12, 15),
			Block.makeCuboidShape(2, 0, 1, 3, 10, 3),
			Block.makeCuboidShape(2, 0, 13, 3, 10, 15),
			Block.makeCuboidShape(0, 12, 0, 16, 13, 16),
			Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
			Block.makeCuboidShape(2, 0, 3, 3, 2, 13),
			Block.makeCuboidShape(2, 10, 1, 3, 12, 15),
			Block.makeCuboidShape(3, 16, 3, 13, 24, 13))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	
	public FireplaceBlock(Properties properties) {
		super(properties.lightValue(12));
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		switch(state.get(FACING)) {
			case NORTH:
				return NORTH_SHAPE;
			case SOUTH:
				return SOUTH_SHAPE;
			case EAST:
				return EAST_SHAPE;
			case WEST:
				return WEST_SHAPE;
		}
		return NORTH_SHAPE;
	}
	
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	public static void spawnSmokeParticles(World world, BlockPos pos, boolean spawnExtraSmoke) {
		Random random = world.getRandom();
		world.addOptionalParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, true,
				(double) pos.getX() + 0.5D + random.nextDouble() / 3.0D * (double) (random.nextBoolean() ? 1 : -1),
				(double) pos.getY() + 0.8D + random.nextDouble() + random.nextDouble(),
				(double) pos.getZ() + 0.5D + random.nextDouble() / 3.0D * (double) (random.nextBoolean() ? 1 : -1),
				0.0D, 0.07D, 0.0D);
	}
	
	@Override
	public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		super.tick(state, world, pos, rand);
		double d0 = (2 * 10 + 10);
        AxisAlignedBB axisalignedbb = (new AxisAlignedBB(pos).grow(d0).expand(0.0D, world.getHeight(), 0.0D));
        List<PlayerEntity> list = world.getEntitiesWithinAABB(PlayerEntity.class, axisalignedbb);
        for(PlayerEntity playerentity : list) {
           playerentity.addPotionEffect(new EffectInstance(ModEffects.COZY.get(), 300, 1));
        }
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World world, BlockPos pos, Random rand) {
		spawnSmokeParticles(world.getWorld(), pos, true);
		double d0 = (double) pos.getX() + 0.5D;
		double d1 = (double) pos.getY();
		double d2 = (double) pos.getZ() + 0.5D;
		if (rand.nextDouble() < 0.1D) {
			world.playSound(d0, d1, d2, SoundEvents.BLOCK_BLASTFURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
		}
		Direction direction = state.get(FACING);
		Direction.Axis direction$axis = direction.getAxis();
		double d3 = 0.52D;
		double d4 = rand.nextDouble() * 0.6D - 0.3D;
		double d5 = direction$axis == Direction.Axis.X ? (double) direction.getXOffset() * 0.52D : d4;
		double d6 = rand.nextDouble() * 9.0D / 16.0D;
		double d7 = direction$axis == Direction.Axis.Z ? (double) direction.getZOffset() * 0.52D : d4;
		world.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
	}
	
}