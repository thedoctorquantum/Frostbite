package com.doctorquantum.frostbite.common.item;

import com.doctorquantum.frostbite.common.effects.ModEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

public class WarmArmorItem extends ArmorItem {

    public WarmArmorItem(IArmorMaterial material, EquipmentSlotType slot, Properties builder) {
        super(material, slot, builder);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        Iterable<ItemStack> armor = player.getArmorInventoryList();
        int validPieces = 0;
        for(ItemStack armourPiece : armor) {
            if(armourPiece.getItem() instanceof WarmArmorItem) {
                validPieces++;
            }
        }
        if(validPieces == 4) {
            player.removePotionEffect(ModEffects.FROSTBITE.get());
            player.addPotionEffect(new EffectInstance(ModEffects.COZY.get(), 200));
        }
    }

}
