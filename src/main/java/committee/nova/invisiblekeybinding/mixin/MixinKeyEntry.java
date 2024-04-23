package committee.nova.invisiblekeybinding.mixin;

import committee.nova.invisiblekeybinding.api.ExtendedKeyEntry;
import net.minecraft.client.gui.GuiKeyBindingList;
import net.minecraft.client.settings.KeyBinding;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GuiKeyBindingList.KeyEntry.class)
public class MixinKeyEntry implements ExtendedKeyEntry {

    @Shadow
    @Final
    private KeyBinding keybinding;

    @Override
    public KeyBinding invisiblekeybinding$getKeyBinding() {
        return this.keybinding;
    }
}
