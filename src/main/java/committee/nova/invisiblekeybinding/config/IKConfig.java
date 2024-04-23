package committee.nova.invisiblekeybinding.config;

import committee.nova.invisiblekeybinding.InvisibleKeyBinding;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Arrays;
import java.util.List;

@Config(modid = InvisibleKeyBinding.MODID)
@Config.LangKey("screen.invisiblekeybinding.config")
@Mod.EventBusSubscriber
public final class IKConfig {
    @Config.Comment("List of names of the keybindings that should be invisible.")
    @Config.LangKey("options.invisiblekeybinding.keybindings")
    public static String[] invisibleKeybindings = new String[]{
            "example.key1.name",
            "example.key2.name"
    };

    @Config.Comment("List of names of the keybinding categories that should be invisible")
    @Config.LangKey("options.invisiblekeybinding.categories")
    public static String[] invisibleCategories = new String[]{
            "ExampleCategory1",
            "ExampleCategory2"
    };

    public static List<String> getInvisibleKeybindings() {
        return Arrays.asList(invisibleKeybindings);
    }

    public static List<String> getInvisibleCategories() {
        return Arrays.asList(invisibleCategories);
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(InvisibleKeyBinding.MODID)) {
            ConfigManager.sync(InvisibleKeyBinding.MODID, Config.Type.INSTANCE);
        }
    }
}
