package com.mrcrayfish.guns.init;

import net.minecraftforge.fml.common.Loader;

public class ModCompatibilities {
    private static boolean v0idSmartBackpacks;

    public static void init() {
        v0idSmartBackpacks = Loader.isModLoaded("v0idssmartbackpacks");
    }

    public static boolean isV0idSmartBackpacksLoaded() {
        return v0idSmartBackpacks;
    }
}
