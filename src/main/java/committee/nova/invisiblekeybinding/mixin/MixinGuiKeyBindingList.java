package committee.nova.invisiblekeybinding.mixin;

import committee.nova.invisiblekeybinding.api.ExtendedCategoryEntry;
import committee.nova.invisiblekeybinding.api.ExtendedKeyEntry;
import committee.nova.invisiblekeybinding.config.IKConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiKeyBindingList;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.List;

@Mixin(GuiKeyBindingList.class)
public class MixinGuiKeyBindingList {
    @Mutable
    @Shadow
    @Final
    private GuiListExtended.IGuiListEntry[] listEntries;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(GuiControls controls, Minecraft mcIn, CallbackInfo ci) {
        final List<GuiListExtended.IGuiListEntry> entries = Arrays.asList(this.listEntries);
        this.listEntries = entries.stream().filter(e -> {
            final List<String> categories = IKConfig.getInvisibleCategories();
            if ((e instanceof ExtendedKeyEntry)) {
                final KeyBinding binding = ((ExtendedKeyEntry) e).invisiblekeybinding$getKeyBinding();
                return !(categories.contains(I18n.format(binding.getKeyCategory())) ||
                        categories.contains(binding.getKeyCategory()) ||
                        IKConfig.getInvisibleKeybindings().contains(binding.getKeyDescription()));
            }
            if ((e instanceof ExtendedCategoryEntry)) {
                return !(categories.contains(((ExtendedCategoryEntry) e).invisiblekeybinding$getLabelText()) ||
                        categories.contains(((ExtendedCategoryEntry) e).invisiblekeybinding$getLabelKey()));
            }
            return true;
        }).toArray(GuiListExtended.IGuiListEntry[]::new);
    }
}
