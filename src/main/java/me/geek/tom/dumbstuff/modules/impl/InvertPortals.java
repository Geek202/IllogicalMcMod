package me.geek.tom.dumbstuff.modules.impl;

import me.geek.tom.dumbstuff.event.GetPortalTargetEvent;
import me.geek.tom.dumbstuff.modules.api.AbstractModule;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.IEventBus;

public class InvertPortals extends AbstractModule {
    private void onGetPortalTarget(GetPortalTargetEvent event) {
        if (!isEnabled()) return;
        if (event.getTarget() == World.field_234918_g_) return;
        if (event.getTarget() == World.field_234919_h_) event.setTarget(World.field_234920_i_);
        else if (event.getTarget() == World.field_234920_i_) event.setTarget(World.field_234919_h_);
    }

    @Override
    public String getName() {
        return "invertPortals";
    }

    @Override
    public String getDescription() {
        return "Makes nether portals take you to the end, and end portals take you to the nether";
    }

    @Override
    public void registerEvents(IEventBus bus) {
        bus.addListener(this::onGetPortalTarget);
    }
}
