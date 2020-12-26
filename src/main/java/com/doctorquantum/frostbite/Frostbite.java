package com.doctorquantum.frostbite;

import com.doctorquantum.frostbite.common.setup.RegistryHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Frostbite.MODID)
public final class Frostbite {
	
    public static final String MODID = "frostbite";

    public Frostbite() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
		RegistryHandler.register(modEventBus);
		forgeEventBus.register(this);
    }
    
}
