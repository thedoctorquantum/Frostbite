package com.doctorquantum.frostbite.common.world.biome;

import com.doctorquantum.frostbite.common.util.ModRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {

	public static final ModRegistry<Biome> BIOMES = new ModRegistry<Biome>(ForgeRegistries.BIOMES);
	
	public static final RegistryObject<Biome> FROZEN_WASTELAND = BIOMES.register("frozen_wasteland", () -> new FrozenWastelandBiome());
	
	public static void registerBiomes() {
		registerBiome(FROZEN_WASTELAND.get(), Type.PLAINS);
	}
	
	private static void registerBiome(Biome biome, Type... types) { 
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
	
}
