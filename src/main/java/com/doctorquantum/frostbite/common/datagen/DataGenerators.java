package com.doctorquantum.frostbite.common.datagen;

import com.doctorquantum.frostbite.Frostbite;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Frostbite.MODID, bus = Bus.MOD)
public class DataGenerators {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
        if(event.includeClient()) {
        	generator.addProvider(new BlockModels(generator, event.getExistingFileHelper()));
            generator.addProvider(new ItemModels(generator, event.getExistingFileHelper()));
            generator.addProvider(new Language(generator, "en_us"));
        }			
		if(event.includeServer()) {
			generator.addProvider(new Recipes(generator));
			generator.addProvider(new LootTables(generator));
			generator.addProvider(new ItemTags(generator));
			generator.addProvider(new BlockTags(generator));
		}
	}	
	
}	