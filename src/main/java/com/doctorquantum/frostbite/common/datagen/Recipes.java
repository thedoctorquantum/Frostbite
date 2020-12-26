package com.doctorquantum.frostbite.common.datagen;

import com.doctorquantum.frostbite.Frostbite;
import com.doctorquantum.frostbite.common.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;

import java.util.function.Consumer;

public class Recipes extends ModRecipeProvider {
		
	public Recipes(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		bricksRecipe(consumer, ModBlocks.PERMAFROST.get(), ModBlocks.PERMAFROST_BRICKS.get());
		slabRecipe(consumer, ModBlocks.PERMAFROST_BRICKS.get(), ModBlocks.PERMAFROST_BRICK_SLAB.get());
		stairsRecipe(consumer, ModBlocks.PERMAFROST_BRICKS.get(), ModBlocks.PERMAFROST_BRICK_STAIRS.get());
		wallRecipe(consumer, ModBlocks.PERMAFROST_BRICKS.get(), ModBlocks.PERMAFROST_BRICK_WALL.get());
		woodRecipe(consumer, ModBlocks.VERGLAS_LOG.get(), ModBlocks.VERGLAS_WOOD.get());
		slabRecipe(consumer, ModBlocks.VERGLAS_PLANKS.get(), ModBlocks.VERGLAS_SLAB.get());
		stairsRecipe(consumer, ModBlocks.VERGLAS_PLANKS.get(), ModBlocks.VERGLAS_STAIRS.get());
		fenceRecipe(consumer, ModBlocks.VERGLAS_PLANKS.get(), ModBlocks.VERGLAS_FENCE.get());
		fenceGateRecipe(consumer, ModBlocks.VERGLAS_PLANKS.get(), ModBlocks.VERGLAS_FENCE_GATE.get());
		planksRecipe(consumer, ModBlocks.VERGLAS_LOG.get(), ModBlocks.VERGLAS_PLANKS.get());
		planksRecipe(consumer, ModBlocks.VERGLAS_WOOD.get(), ModBlocks.VERGLAS_PLANKS.get());
	}
	
	@Override
	public String getName() {
		return Frostbite.MODID + ":recipes";
	}
	
}
