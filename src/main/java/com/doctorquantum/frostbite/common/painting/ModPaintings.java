package com.doctorquantum.frostbite.common.painting;

import com.doctorquantum.frostbite.Frostbite;
import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPaintings {

    public static final DeferredRegister<PaintingType> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, Frostbite.MODID);

    public static final RegistryObject<PaintingType> THAW = PAINTINGS.register("thaw", () -> new PaintingType(32, 16));

}
