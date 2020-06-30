package me.geek.tom.dumbstuff.event;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.Event;

public class GetPortalTargetEvent extends Event {

    private RegistryKey<World> target;

    public GetPortalTargetEvent(RegistryKey<World> target) {
        this.target = target;
    }

    public RegistryKey<World> getTarget() {
        return target;
    }

    public void setTarget(RegistryKey<World> target) {
        this.target = target;
    }

    @Override
    public boolean isCancelable() {
        return false;
    }

}
