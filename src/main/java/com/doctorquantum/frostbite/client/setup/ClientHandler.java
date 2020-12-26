package com.doctorquantum.frostbite.client.setup;

import com.doctorquantum.frostbite.Frostbite;
import com.doctorquantum.frostbite.common.block.ModBlocks;
import com.doctorquantum.frostbite.common.block.ModSaplingBlock;
import com.doctorquantum.frostbite.common.block.NetherChilliBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.stream.Stream;

@Mod.EventBusSubscriber(modid = Frostbite.MODID, bus = Bus.MOD)
public final class ClientHandler {

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        Stream<Block> blocks = ModBlocks.BLOCKS.getWhitelistFilteredByType(NetherChilliBlock.class, ModSaplingBlock.class);
        RenderTypeLookup.setRenderLayer(ModBlocks.NETHER_CHILLI.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.VERGLAS_SAPLING.get(), RenderType.getCutout());
        blocks.forEach(block -> {
            RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
        });
    }

}
