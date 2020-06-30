package me.geek.tom.dumbstuff.modules.impl;

import me.geek.tom.dumbstuff.modules.api.AbstractModule;
import net.minecraftforge.eventbus.api.IEventBus;

public class BouncyBlocks extends AbstractModule {

    private static BouncyBlocks INSTANCE;

    public static boolean enabled() {
        return INSTANCE.isEnabled();
    }

    public BouncyBlocks() {
        INSTANCE = this;
    }

    @Override
    public String getName() {
        return "bouncyBlocks";
    }

    @Override
    public String getDescription() {
        return "Makes all blocks bounce you like slime. BEWARE: This does NOT block fall damage!";
    }

    @Override
    public void registerEvents(IEventBus bus) { }
}
