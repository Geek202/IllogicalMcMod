package me.geek.tom.dumbstuff;

import me.geek.tom.dumbstuff.modules.api.AbstractModule;
import me.geek.tom.dumbstuff.modules.impl.BouncyBlocks;
import me.geek.tom.dumbstuff.modules.impl.ExplodingItems;
import me.geek.tom.dumbstuff.modules.impl.InvertPortals;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.StartupMessageManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Mod(Break.MODID)
public class Break {
    public static final String MODID = "breakmc";
    public static final Logger LOGGER = LogManager.getLogger();

    private static final List<AbstractModule> MODULES = new ArrayList<>();

    public Break() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);

        MODULES.add(new ExplodingItems());
        MODULES.add(new InvertPortals());
        MODULES.add(new BouncyBlocks());

        for (AbstractModule module : MODULES) {
            LOGGER.info("Registering " + module.getName() + " to the EventBus!");
            module.registerEvents(MinecraftForge.EVENT_BUS);
        }

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
    }

    public static List<AbstractModule> getModules() {
        return MODULES;
    }

    private void init(FMLCommonSetupEvent event) {
        StartupMessageManager.addModMessage("breakmc::init");
    }
}
