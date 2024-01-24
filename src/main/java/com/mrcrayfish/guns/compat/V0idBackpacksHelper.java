package com.mrcrayfish.guns.compat;

import com.mrcrayfish.guns.common.AmmoContext;
import com.mrcrayfish.guns.item.ItemGun;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.IItemHandler;
import v0id.api.vsb.capability.IBackpack;
import v0id.vsb.container.ContainerBackpack;
import v0id.vsb.util.VSBUtils;

public class V0idBackpacksHelper {
    public static AmmoContext findAmmo(EntityPlayer player, ResourceLocation id) {
        final ItemStack backpackStack = VSBUtils.getBackpack(player, -1);
        if (backpackStack.isEmpty()) return AmmoContext.NONE;
        final IBackpack backpack = IBackpack.of(backpackStack);
        if (backpack == null) return AmmoContext.NONE;
        final IItemHandler inv = backpack.getInventory();
        for (int i = 0; i < inv.getSlots(); ++i) {
            final ItemStack stack = inv.getStackInSlot(i);
            if (!ItemGun.isAmmo(stack, id)) continue;
            return AmmoContext.of(stack, () -> new ContainerBackpack.ContainerBackpackInventory(
                    backpackStack, player.inventory, -1, -1
            ).detectAndSendChanges());
        }
        return AmmoContext.NONE;
    }
}
