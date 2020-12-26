package com.doctorquantum.frostbite.common.item;

import com.doctorquantum.frostbite.common.block.ModBlocks;
import com.doctorquantum.frostbite.common.util.ModItemGroup;
import com.doctorquantum.frostbite.common.util.ModRegistry;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	
	public static final ModRegistry<Item> ITEMS = new ModRegistry<>(ForgeRegistries.ITEMS);

	public static final RegistryObject<Item> NETHER_CHILLI = ITEMS.register("nether_chilli", () -> new NetherChilliItem(new Item.Properties().group(ModItemGroup.FROSTBITE)));
	public static final RegistryObject<Item> NETHER_CHILLI_SPROUT = ITEMS.register("nether_chilli_sprout", () -> new BlockNamedItem(ModBlocks.NETHER_CHILLI.get(), new Item.Properties().group(ModItemGroup.FROSTBITE)));

	public static final RegistryObject<Item> GAMBESON_HELMET = ITEMS.register("gambeson_helmet", () -> new WarmArmorItem(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Item.Properties().group(ModItemGroup.FROSTBITE)));
	public static final RegistryObject<Item> GAMBESON_CHESTPLATE = ITEMS.register("gambeson_chestplate", () -> new WarmArmorItem(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, new Item.Properties().group(ModItemGroup.FROSTBITE)));
	public static final RegistryObject<Item> GAMBESON_LEGGINGS = ITEMS.register("gambeson_leggings", () -> new WarmArmorItem(ArmorMaterial.LEATHER, EquipmentSlotType.LEGS, new Item.Properties().group(ModItemGroup.FROSTBITE)));
	public static final RegistryObject<Item> GAMBESON_BOOTS = ITEMS.register("gambeson_boots", () -> new WarmArmorItem(ArmorMaterial.LEATHER, EquipmentSlotType.FEET, new Item.Properties().group(ModItemGroup.FROSTBITE)));

}