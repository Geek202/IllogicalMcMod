package me.geek.tom.dumbstuff;

import me.geek.tom.dumbstuff.modules.api.AbstractModule;
import net.minecraftforge.common.ForgeConfigSpec;

public class Config {

    public static ForgeConfigSpec COMMON_CONFIG;

    public static final String CATEGORY_MODULES = "modules";
    
    public static ForgeConfigSpec.BooleanValue INVERT_PORTALS_ENABLED;
    
    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.comment("Module settings")
                .push(CATEGORY_MODULES);

        for (AbstractModule module : Break.getModules())
            addModule(COMMON_BUILDER, module);

        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    private static void addModule(ForgeConfigSpec.Builder builder, AbstractModule module) {
        builder.comment(module.getDescription())
                .push(module.getName());
        module.registerConfig(builder);
        builder.pop();
    }
}
