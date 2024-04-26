package committee.nova.invisiblekeybinding.config;

import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class IKConfig {
    public static final ForgeConfigSpec CFG;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> invisibleKeybindings;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> invisibleCategories;

    static {
        final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("InvisibleKeybinding Settings").push("general");
        invisibleKeybindings = builder.comment("Keybindings that should be invisible in the controls screen")
                .define("invisibleKeybindings", Lists.newArrayList("key.example1", "key.example2"));
        invisibleCategories = builder.comment("Keybinding categories that should be invisible in the controls screen")
                .define("invisibleCategories", Lists.newArrayList("key.categories.example1", "key.categories.example2"));
        builder.pop();
        CFG = builder.build();
    }
}
