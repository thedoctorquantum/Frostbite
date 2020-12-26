package com.doctorquantum.frostbite.common.setup;

import com.doctorquantum.frostbite.Frostbite;
import com.doctorquantum.frostbite.common.block.ModBlocks;
import com.doctorquantum.frostbite.common.effects.ModEffects;
import com.doctorquantum.frostbite.common.item.ModItems;
import com.doctorquantum.frostbite.common.painting.ModPaintings;
import com.doctorquantum.frostbite.common.util.ModItemGroup;
import com.doctorquantum.frostbite.common.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.stream.Stream;

@Mod.EventBusSubscriber(modid = Frostbite.MODID, bus = Bus.MOD)
public final class RegistryHandler {

    public static void register(final IEventBus eventBus) {
        ModEffects.EFFECTS.register(eventBus);
        ModEffects.POTIONS.register(eventBus);
        ModBlocks.BLOCKS.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ModBiomes.BIOMES.register(eventBus);
        ModPaintings.PAINTINGS.register(eventBus);
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
        ModBiomes.registerBiomes();
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
        final Stream<Block> blocks = ModBlocks.BLOCKS.getBlacklistedStream(ModBlocks.NETHER_CHILLI);
        blocks.forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(ModItemGroup.FROSTBITE);
            final BlockItem blockItem = (BlockItem) new BlockItem(block, properties).setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }

}
