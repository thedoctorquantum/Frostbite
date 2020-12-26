package com.doctorquantum.frostbite.common.world.gen;

import com.doctorquantum.frostbite.common.block.ModBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class VerglasTree extends BigTree {

	public static final TreeFeatureConfig NORMAL_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ModBlocks.VERGLAS_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(ModBlocks.VERGLAS_LEAVES.get().getDefaultState()), 
			new SpruceFoliagePlacer(2, 1)))
			.baseHeight(6)
			.heightRandA(3)
			.trunkHeight(1)
			.trunkHeightRandom(1)
			.trunkTopOffsetRandom(2)
			.ignoreVines()
			.setSapling((IPlantable) ModBlocks.VERGLAS_SAPLING.get()).build();
	
	public static final HugeTreeFeatureConfig MEGA_CONFIG = (new HugeTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ModBlocks.VERGLAS_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(ModBlocks.VERGLAS_LEAVES.get().getDefaultState())))
			.baseHeight(13)
			.heightInterval(15)
			.crownHeight(13)
			.decorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(Blocks.PACKED_ICE.getDefaultState()))))
			.setSapling((IPlantable) ModBlocks.VERGLAS_SAPLING.get()).build();
	
	public static final HugeTreeFeatureConfig MEGA_PINE_CONFIG = (new HugeTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ModBlocks.VERGLAS_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(ModBlocks.VERGLAS_LEAVES.get().getDefaultState()))
			.baseHeight(13)
			.heightInterval(15)
			.crownHeight(3)
			.decorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(Blocks.PACKED_ICE.getDefaultState()))))
			.setSapling((IPlantable) ModBlocks.VERGLAS_SAPLING.get()).build());
	
	@Nullable
   	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
	   return Feature.NORMAL_TREE.withConfiguration(NORMAL_CONFIG);
	}

	@Nullable
	protected ConfiguredFeature<HugeTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
		return Feature.MEGA_SPRUCE_TREE.withConfiguration(p_225547_1_.nextBoolean() ? MEGA_CONFIG : MEGA_PINE_CONFIG);
	}

}
