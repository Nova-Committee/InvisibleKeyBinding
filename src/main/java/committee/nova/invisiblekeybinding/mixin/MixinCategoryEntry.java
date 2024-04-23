package committee.nova.invisiblekeybinding.mixin;

import committee.nova.invisiblekeybinding.api.ExtendedCategoryEntry;
import net.minecraft.client.gui.GuiKeyBindingList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiKeyBindingList.CategoryEntry.class)
public class MixinCategoryEntry implements ExtendedCategoryEntry {
    @Shadow
    @Final
    private String labelText;

    @Unique
    private String invisiblekeybinding$labelKey = "";

    @Inject(method = "<init>", at = @At("RETURN"))
    private void inject$init(GuiKeyBindingList this$0, String name, CallbackInfo ci) {
        this.invisiblekeybinding$labelKey = name;
    }

    @Override
    public String invisiblekeybinding$getLabelText() {
        return this.labelText;
    }

    @Override
    public String invisiblekeybinding$getLabelKey() {
        return invisiblekeybinding$labelKey;
    }
}
