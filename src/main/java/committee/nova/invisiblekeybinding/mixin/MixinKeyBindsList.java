package committee.nova.invisiblekeybinding.mixin;

import committee.nova.invisiblekeybinding.config.IKConfig;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.controls.KeyBindsList;
import net.minecraft.client.resources.language.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Arrays;
import java.util.List;

@Mixin(KeyBindsList.class)
public class MixinKeyBindsList {
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lorg/apache/commons/lang3/ArrayUtils;clone([Ljava/lang/Object;)[Ljava/lang/Object;", remap = false))
    private Object[] redirect$init(Object[] array) {
        if (!(array instanceof KeyMapping[] mappings)) return array;
        final List<? extends String> keybindings = IKConfig.invisibleKeybindings.get();
        final List<? extends String> categories = IKConfig.invisibleCategories.get();
        return Arrays.stream(mappings)
                .filter(k -> !keybindings.contains(k.getName()) && !categories.contains(k.getCategory()) &&
                        !keybindings.contains(I18n.get(k.getName())) && !categories.contains(I18n.get(k.getCategory())))
                .toArray(KeyMapping[]::new);
    }
}
