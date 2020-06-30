package me.geek.tom.dumbstuff.mixins.mixins;

import me.geek.tom.dumbstuff.Break;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MainMenuScreen.class)
public abstract class MixinMainMenuScreen extends Screen {
    protected MixinMainMenuScreen(ITextComponent titleIn) {
        super(titleIn);
    }

    @Inject(method = "func_231160_c_",
            at = @At("RETURN"))
    private void onInit(CallbackInfo ci) {
        Break.LOGGER.info("Mixins are working!");
    }
}
