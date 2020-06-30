package me.geek.tom.dumbstuff.mixins.mixins;

import me.geek.tom.dumbstuff.modules.impl.BouncyBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class MixinBlock {

    @Inject(method = "onLanded", cancellable = true,
            at = @At("HEAD"))
    private void onOnLanded(IBlockReader world, Entity entity, CallbackInfo ci) {
        if (entity.isSuppressingBounce() || !BouncyBlocks.enabled()) return;
        ci.cancel();

        // Borrowed from slime block
        Vector3d vector3d = entity.getMotion();
        if (vector3d.y < 0.0D) {
            double scale = entity instanceof LivingEntity ? 1.0D : 0.8D;
            entity.setMotion(vector3d.x, -vector3d.y * scale, vector3d.z);
        }
    }

}
