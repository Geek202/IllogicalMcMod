package me.geek.tom.dumbstuff.mixins.mixins;

import me.geek.tom.dumbstuff.event.GetPortalTargetEvent;
import net.minecraft.entity.Entity;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Entity.class)
public class MixinEntity {
    @ModifyArg(method = "updatePortal",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;getWorld(Lnet/minecraft/util/RegistryKey;)Lnet/minecraft/world/server/ServerWorld;"))
    private RegistryKey<World> getTargetWorld(RegistryKey<World> target) {
        GetPortalTargetEvent event = new GetPortalTargetEvent(target);
        MinecraftForge.EVENT_BUS.post(event);
        return event.getTarget();
    }
}
