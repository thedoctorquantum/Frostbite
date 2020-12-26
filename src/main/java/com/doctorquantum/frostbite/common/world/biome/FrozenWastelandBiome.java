package com.doctorquantum.frostbite.common.world.biome;

import com.doctorquantum.frostbite.common.world.gen.FrozenSurfaceBuilder;
import com.doctorquantum.frostbite.common.world.gen.VerglasTree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

public class FrozenWastelandBiome extends Biome {

	private final static Builder BUILDER = new Biome.Builder()
			.temperature(-2f)
			.scale(1.2f)
			.waterColor(0x31def5)
			.waterFogColor(0x31def5)
			.surfaceBuilder(new FrozenSurfaceBuilder(), FrozenSurfaceBuilder.CONFIG)
			.category(Category.PLAINS)
			.downfall(2f)
			.depth(0.12f)
			.parent(null)
			.precipitation(RainType.SNOW);
	
	public FrozenWastelandBiome() {
		super(BUILDER);
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addOres(this);
		addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(VerglasTree.NORMAL_CONFIG)
		.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1f, 1))));
	}
	
	@Override
	public boolean doesSnowGenerate(IWorldReader worldIn, BlockPos pos) {
		return true;
	}
	
	@Override
	public int getSkyColor() {
		return 0xd3DDDE;
	}

}
