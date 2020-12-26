package com.doctorquantum.frostbite.common.datagen;

import com.doctorquantum.frostbite.Frostbite;
import com.doctorquantum.frostbite.common.block.ModBlocks;
import com.doctorquantum.frostbite.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;

import java.util.stream.Stream;

public class ItemModels extends ItemModelProvider {
	
	public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Frostbite.MODID, existingFileHelper);
	}
	
	@Override
	protected void registerModels() {
		final Stream<Item> items = ModItems.ITEMS.getEntries();
		final Stream<Block> blocks = ModBlocks.BLOCKS.getBlacklistedStream(
				ModBlocks.VERGLAS_FENCE, 
				ModBlocks.VERGLAS_SAPLING, 
				ModBlocks.PERMAFROST_BRICK_WALL, 
				ModBlocks.NETHER_CHILLI
		);
		
		withExistingParent(ModBlocks.VERGLAS_FENCE.get().getRegistryName().getPath(), modLoc("block/verglas_fence_inventory"));
		withExistingParent(ModBlocks.PERMAFROST_BRICK_WALL.get().getRegistryName().getPath(), modLoc("block/permafrost_brick_wall_inventory"));
		singleTexture(ModBlocks.VERGLAS_SAPLING.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", modLoc("block/verglas_sapling"));
			
		items.forEach(item -> {
			if(item instanceof SwordItem || item instanceof ToolItem) {
				singleTexture(item.getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", modLoc("item/" + item));
			} else {
				singleTexture(item.getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", modLoc("item/" + item));
			}
		});
		blocks.filter((block) -> !(block instanceof FenceBlock)).forEach(block -> {
			withExistingParent(block.getRegistryName().getPath(), modLoc("block/" + block.asItem()));
		});
	}
	
	@Override
	public String getName() {
		return Frostbite.MODID + ":item_models";
	}

}
