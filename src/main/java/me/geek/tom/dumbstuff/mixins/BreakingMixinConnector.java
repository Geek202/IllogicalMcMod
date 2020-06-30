package me.geek.tom.dumbstuff.mixins;

import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;

public class BreakingMixinConnector implements IMixinConnector {
    @Override
    public void connect() {
        Mixins.addConfiguration("break.mixins.json");
    }
}
