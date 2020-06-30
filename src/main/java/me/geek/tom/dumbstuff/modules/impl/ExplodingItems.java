package me.geek.tom.dumbstuff.modules.impl;

import me.geek.tom.dumbstuff.Config;
import me.geek.tom.dumbstuff.modules.api.AbstractModule;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class ExplodingItems extends AbstractModule {

    public static ForgeConfigSpec.BooleanValue EXPLODING_ITEMS_CAUSES_FIRE;
    public static ForgeConfigSpec.DoubleValue EXPLODING_ITEMS_RADIUS;

    private void onItemPickup(PlayerEvent.ItemPickupEvent event) {
        if (!isEnabled()) return;
        World world = event.getOriginalEntity().getEntityWorld();
        if (world.isRemote) return;
        BlockPos pos = new BlockPos(event.getPlayer().getPositionVec());
        world.createExplosion(event.getPlayer(),
                pos.getX(), pos.getY(), pos.getZ(),
                (float)(double)EXPLODING_ITEMS_RADIUS.get(),
                EXPLODING_ITEMS_CAUSES_FIRE.get(),
                Explosion.Mode.DESTROY
        );
    }

    @Override
    public void registerConfig(ForgeConfigSpec.Builder builder) {
        super.registerConfig(builder);

        EXPLODING_ITEMS_CAUSES_FIRE = builder.comment("Should the explosion create fire")
                .define("causeFire", false);
        EXPLODING_ITEMS_RADIUS = builder.comment("The radius of the explosion")
                .defineInRange("explosionRadius", 3.0, 1.0, 15.0);
    }

    @Override
    public String getName() {
        return "explodingItems";
    }

    @Override
    public String getDescription() {
        return "Makes items explode when you pick them up";
    }

    @Override
    public void registerEvents(IEventBus bus) {
        bus.addListener(this::onItemPickup);
    }
}
