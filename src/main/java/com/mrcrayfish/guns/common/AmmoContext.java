package com.mrcrayfish.guns.common;

import net.minecraft.item.ItemStack;

public class AmmoContext {
    private static final Runnable NOOP = () -> {
    };
    public static final AmmoContext NONE = new AmmoContext(ItemStack.EMPTY, NOOP);

    private final ItemStack ammo;
    private final Runnable onConsume;

    private AmmoContext(ItemStack ammo, Runnable onConsume) {
        this.ammo = ammo;
        this.onConsume = onConsume;
    }

    public static AmmoContext of(ItemStack ammo, Runnable onConsume) {
        return new AmmoContext(ammo, onConsume);
    }

    public static AmmoContext of(ItemStack ammo) {
        return new AmmoContext(ammo, NOOP);
    }

    public ItemStack ammo() {
        return ammo;
    }

    public void onConsume() {
        onConsume.run();
    }
}
