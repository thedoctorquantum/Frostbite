package com.doctorquantum.frostbite.common.datagen;

import com.doctorquantum.frostbite.Frostbite;
import com.doctorquantum.frostbite.common.block.ModBlocks;
import com.doctorquantum.frostbite.common.effects.ModEffects;
import com.doctorquantum.frostbite.common.item.ModItems;
import com.doctorquantum.frostbite.common.util.ModItemGroup;
import com.doctorquantum.frostbite.common.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.Stream;

public class Language extends LanguageProvider {
	
	private final String locale;
	
	public Language(DataGenerator gen, String locale) {
		super(gen, Frostbite.MODID, locale);
		this.locale = locale;
	} 
	
	@Override
	protected void addTranslations() {
		Stream<Item> items = ModItems.ITEMS.getEntries();
		Stream<Block> blocks = ModBlocks.BLOCKS.getEntries();
		items.forEach(item -> {
			add(item.getTranslationKey(), createLocalizedName(item));
		});
		blocks.forEach(block -> {
			add(block.getTranslationKey(), createLocalizedName(block));
		});
		add(ModEffects.FROSTBITE.get(), "Frostbite");
		add(ModEffects.COZY.get(), "Cozy");
		add(ModBiomes.FROZEN_WASTELAND.get(), "Frozen Wasteland");
		add(ModItemGroup.FROSTBITE.getTranslationKey(), "Frostbite");
	}
	
	protected String createLocalizedName(IItemProvider item) {
		String[] words = StringUtils.split(item.asItem().toString().replace('_', ' '));
		for(int i = 0; i < words.length; i++) {
			words[i] = StringUtils.capitalize(words[i]);
		}
		return Arrays.toString(words).replace(",", "").replace("[", "").replace("]", "");
	}
	
	@Override
	public String getName() {
		return Frostbite.MODID + ":language/" + locale;
	}
	
}
