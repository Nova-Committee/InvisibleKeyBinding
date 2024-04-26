package committee.nova.invisiblekeybinding;

import committee.nova.invisiblekeybinding.config.IKConfig;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(InvisibleKeybinding.MODID)
public class InvisibleKeybinding {
    public static final String MODID = "invisiblekeybinding";

    public InvisibleKeybinding() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, IKConfig.CFG);
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class,
                () -> new IExtensionPoint.DisplayTest("", (remoteVersion, isFromServer) -> true));
    }
}
