package com.doctorquantum.frostbite.common.datagen;

import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.registry.Registry;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
	
	public ModRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	public void helmetRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output)
			.patternLine("000")
			.patternLine("0 0")
			.key('0', input)
			.setGroup(null)
	        .addCriterion(output.asItem().toString(), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer);
	}
	
	public void chestplateRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output)
			.patternLine("0 0")
			.patternLine("000")
			.patternLine("000")
			.key('0', input)
			.setGroup(null)
	        .addCriterion(output.asItem().toString(), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer);
	}
	
	public void leggingsRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output)
			.patternLine("000")
			.patternLine("0 0")
			.patternLine("0 0")
			.key('0', input)
			.setGroup(null)
	        .addCriterion(output.asItem().toString(), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer);
	}
	
	public void bootsRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output)
			.patternLine("0 0")
			.patternLine("0 0")
			.key('0', input)
			.setGroup(null)
	        .addCriterion(output.asItem().toString(), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer);
	}
	
	public void swordRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output)
			.patternLine("0")
			.patternLine("0")
			.patternLine("1")
			.key('0', input)
			.key('1', Items.STICK)
			.setGroup(null)
	        .addCriterion(output.asItem().toString(), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer);
	}
	
	public void pickaxeRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output)
			.patternLine("000")
			.patternLine(" 1 ")
			.patternLine(" 1 ")
			.key('0', input)
			.key('1', Items.STICK)
			.setGroup(null)
	        .addCriterion(output.asItem().toString(), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer);
	}
	
	public void shovelRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output)
			.patternLine("0")
			.patternLine("1")
			.patternLine("1")
			.key('0', input)
			.key('1', Items.STICK)
			.setGroup(null)
	        .addCriterion(output.asItem().toString(), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer);
	}
	
	public void axeRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output)
			.patternLine("00")
			.patternLine("01")
			.patternLine(" 1")
			.key('0', input)
			.key('1', Items.STICK)
			.setGroup(null)
	        .addCriterion(output.asItem().toString(), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer);
	}
	
	public void hoeRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output)
			.patternLine("00")
			.patternLine(" 1")
			.patternLine(" 1")
			.key('0', input)
			.key('1', Items.STICK)
			.setGroup(null)
	        .addCriterion(output.asItem().toString(), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer);
	}
	
	public void conversionRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output, boolean isShapeless) {
		if(isShapeless) {
			ShapelessRecipeBuilder.shapelessRecipe(output, 9)
			.addIngredient(input)
			.setGroup(null)
		    .addCriterion(recipeName(input, output), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer, recipeName(input, output));
		} else if(!isShapeless) {
			ShapedRecipeBuilder.shapedRecipe(output)
			.patternLine("000")
			.patternLine("000")
			.patternLine("000")
			.key('0', input)
			.setGroup(null)
	        .addCriterion(recipeName(input, output), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer, recipeName(input, output));
		}
	}
	
	public void slabRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output)
		.patternLine("000")
		.key('0', input)
		.setGroup(null)
        .addCriterion(recipeName(input, output), InventoryChangeTrigger.Instance.forItems(input))
		.build(consumer, recipeName(input, output));
	}
	
	public void stairsRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output, 4)
		.patternLine("0  ")
		.patternLine("00 ")
		.patternLine("000")
		.key('0', input)
		.setGroup(null)
        .addCriterion(recipeName(input, output), InventoryChangeTrigger.Instance.forItems(input))
		.build(consumer, recipeName(input, output));
	}
	
	public void wallRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output, 6)
		.patternLine("000")
		.patternLine("000")
		.key('0', input)
		.setGroup(null)
        .addCriterion(recipeName(input, output), InventoryChangeTrigger.Instance.forItems(input))
		.build(consumer, recipeName(input, output));
	}
	
	public void fenceRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output)
		.patternLine("010")
		.patternLine("010")
		.key('0', input)
		.key('1', Items.STICK)
		.setGroup(null)
        .addCriterion(recipeName(input, output), InventoryChangeTrigger.Instance.forItems(input))
		.build(consumer, recipeName(input, output));
	}
	
	public void fenceGateRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output)
		.patternLine("101")
		.patternLine("101")
		.key('0', input)
		.key('1', Items.STICK)
		.setGroup(null)
        .addCriterion(recipeName(input, output), InventoryChangeTrigger.Instance.forItems(input))
		.build(consumer, recipeName(input, output));
	}
	
	public void planksRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapelessRecipeBuilder.shapelessRecipe(output, 4)
		.addIngredient(input)
		.setGroup(null)
	    .addCriterion(recipeName(input, output), InventoryChangeTrigger.Instance.forItems(input))
		.build(consumer, recipeName(input, output));
	}
	
	public void woodRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output, 3)
		.patternLine("00")
		.patternLine("00")
		.key('0', input)
		.setGroup(null)
        .addCriterion(recipeName(input, output), InventoryChangeTrigger.Instance.forItems(input))
		.build(consumer, recipeName(input, output));
	}
	
	public void bricksRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output) {
		ShapedRecipeBuilder.shapedRecipe(output, 4)
		.patternLine("00")
		.patternLine("00")
		.key('0', input)
		.setGroup(null)
        .addCriterion(recipeName(input, output), InventoryChangeTrigger.Instance.forItems(input))
		.build(consumer, recipeName(input, output));
	}
	
	public void smeltingRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output, float experience, int cookingTime, boolean useOutputAsName) {
		if(useOutputAsName) {
			CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(input), output, experience, cookingTime)
		    .addCriterion(output.asItem().toString(), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer);
		} else { 
			CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(input), output, experience, cookingTime)
		    .addCriterion(recipeName(input, output), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer, recipeName(input, output));
		}
	}
	
	public void blastingRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output, float experience, int cookingTime, boolean useOutputAsName) {
		if(useOutputAsName) {
			CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(input), output, experience, cookingTime)
		    .addCriterion(output.asItem().toString(), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer);
		} else { 
			CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(input), output, experience, cookingTime)
		    .addCriterion(blastingRecipeName(input, output), InventoryChangeTrigger.Instance.forItems(input))
			.build(consumer, blastingRecipeName(input, output));
		}
	}
	
	public String recipeName(IItemProvider input, IItemProvider output) {
		return Registry.ITEM.getKey(output.asItem()).toString() + "_from_" + input.asItem();
	}
	
	public String blastingRecipeName(IItemProvider input, IItemProvider output) {
		return Registry.ITEM.getKey(output.asItem()).toString() + "_blasting_from_" + input.asItem();
	}
	
}
