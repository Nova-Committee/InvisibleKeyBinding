package committee.nova.invisiblekeybinding.client;

import committee.nova.invisiblekeybinding.InvisibleKeyBinding;
import committee.nova.invisiblekeybinding.config.IKConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;

import java.util.Collections;
import java.util.Set;

public class GuiFactory implements IModGuiFactory {

    @Override
    public void initialize(Minecraft minecraftInstance) {

    }

    @Override
    public boolean hasConfigGui() {
        return true;
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parentScreen) {
        return new GuiConfig(
                parentScreen,
                ConfigElement.from(IKConfig.class).getChildElements(),
                InvisibleKeyBinding.MODID,
                false,
                false,
                I18n.format("screen.invisiblekeybinding.config")
        );
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return Collections.emptySet();
    }
}
