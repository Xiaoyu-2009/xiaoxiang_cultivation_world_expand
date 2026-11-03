package dev.xiaoyu.xiaoxiang_cultivation_world_expand.mixin.net.minecraft.gametest.framework;

import net.minecraft.gametest.framework.GameTestRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.annotation.IncompleteAnnotationException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.Function;

@Mixin(GameTestRegistry.class)
public class GameTestRegistryMixin {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Inject(method = "registerBatchFunction", at = @At("HEAD"), cancellable = true)
    private static void skipIncompleteBatch(Method testMethod, Class annotationType, Function valueGetter, Map positioning, CallbackInfo ci) {
        Object annotation = testMethod.getAnnotation(annotationType);
        if (annotation == null) {
            return;
        }
        try {
            valueGetter.apply(annotation);
        } catch (IncompleteAnnotationException e) {
            ci.cancel();
        }
    }
}