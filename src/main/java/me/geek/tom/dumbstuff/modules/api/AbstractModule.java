package me.geek.tom.dumbstuff.modules.api;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.IEventBus;

public abstract class AbstractModule {

    private ForgeConfigSpec.BooleanValue ENABLED;

    /**
     * Register this modules config.
     * Custom implementations <b>MUST</b> call the super method for {@link #isEnabled()} to function correctly.
     *
     * @param builder The {@link ForgeConfigSpec.Builder} to attach the config to
     */
    public void registerConfig(ForgeConfigSpec.Builder builder) {
        ENABLED = builder.comment("Should this module be enabled")
                .define("enabled", false);
    }

    /**
     * Gets the name of the module
     *
     * @return The name of the module, as used in the config file.
     */
    public abstract String getName();

    /**
     * Get the description of this module
     *
     * @return The description, as shown in the config file.
     */
    public abstract String getDescription();

    /**
     * Allows the module to register events onto {@link net.minecraftforge.common.MinecraftForge#EVENT_BUS}
     *
     * @param bus {@link net.minecraftforge.common.MinecraftForge#EVENT_BUS}
     */
    public abstract void registerEvents(IEventBus bus);

    public boolean isEnabled() {
        return ENABLED != null ? ENABLED.get() : false;
    }
}
