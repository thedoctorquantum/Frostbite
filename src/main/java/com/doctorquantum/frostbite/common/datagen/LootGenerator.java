package com.doctorquantum.frostbite.common.datagen;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.BlockStateProperty;
import net.minecraft.world.storage.loot.conditions.SurvivesExplosion;
import net.minecraft.world.storage.loot.functions.ExplosionDecay;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;

public abstract class LootGenerator implements IDataProvider {
	
	private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
	
	protected final Map<ResourceLocation, LootTable> tables = Maps.newHashMap();
	private final DataGenerator dataGenerator;
	
	public LootGenerator(DataGenerator gen) {
		dataGenerator = gen;
	}

	public void act(@Nonnull DirectoryCache outCache) {
		tables.clear();
		Path outFolder = this.dataGenerator.getOutputFolder();
		registerTables();
		ValidationTracker validator = new ValidationTracker(
				LootParameterSets.GENERIC,
				(p_229442_0_) -> null,
				tables::get
		);
		tables.forEach((name, table) -> {
			LootTableManager.func_227508_a_(validator, name, table);
		});
		Multimap<String, String> problems = validator.getProblems();
		if(!problems.isEmpty()) {
			throw new IllegalStateException("Failed to validate loot tables, see logs");
		}
		else {
			tables.forEach((name, table) -> {
				Path out = getPath(outFolder, name);
				try {
					IDataProvider.save(GSON, outCache, LootTableManager.toJson(table), out);
				} catch(IOException x) {
					x.printStackTrace();
				}
			});
		}
	}

	private static Path getPath(Path path, ResourceLocation resource) {
		return path.resolve("data/" + resource.getNamespace() + "/loot_tables/" + resource.getPath() + ".json");
	}

	protected abstract void registerTables();
	
	protected void registerSelfDropping(Block block, LootPool.Builder... pool) {
		LootPool.Builder[] withSelf = Arrays.copyOf(pool, pool.length + 1);
		withSelf[withSelf.length - 1] = LootPool.builder().acceptCondition(SurvivesExplosion.builder())
				.rolls(ConstantRange.of(1))
				.addEntry(ItemLootEntry.builder(block));
				
		register(block, withSelf);
	}
	
	protected void registerWildCrop(Block block, IItemProvider crop, LootPool.Builder... pool) {
		LootPool.Builder[] withSelf = Arrays.copyOf(pool, pool.length + 1);
		withSelf[withSelf.length - 1] = LootPool.builder().acceptFunction(ExplosionDecay.builder()).rolls(ConstantRange.of(1))
				.addEntry(ItemLootEntry.builder(block))
				.addEntry(ItemLootEntry.builder(crop))
				.acceptCondition(BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder()
				.withStringProp(block.getStateContainer().getProperty("age"), "3")));
		register(block, withSelf);
	}
	
	protected void register(Block b, LootTable.Builder table) {
		register(b.getRegistryName(), table);
	}
	
	protected void register(Block b, LootPool.Builder... pools) {
		LootTable.Builder builder = LootTable.builder();
		for(LootPool.Builder pool : pools) {
			builder.addLootPool(pool);
		}
		register(b, builder);
	}

	protected void register(ResourceLocation name, LootTable.Builder table) {
		if(tables.put(new ResourceLocation(name.getNamespace(), "blocks/" + name.getPath()), table.setParameterSet(LootParameterSets.BLOCK).build()) != null) {
			throw new IllegalStateException("Duplicate loot table " + name);
		}
	}
    
}
