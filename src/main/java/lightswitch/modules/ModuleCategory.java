package lightswitch.modules;

import lightswitch.Lightswitch;
import meteordevelopment.meteorclient.systems.modules.Module;

public class ModuleCategory extends Module {
    public ModuleCategory() {
        super(Lightswitch.CATEGORY, "Lightswitch", "An example module in a custom category.");
    }
}
