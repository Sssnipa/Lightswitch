package lightswitch;

import lightswitch.commands.ExampleCommand;
import lightswitch.modules.ModuleCategory;
import lightswitch.modules.chat.BurrowAlert;
import lightswitch.modules.chat.PopCounter;
import lightswitch.modules.combat.SurroundPlus;
import meteordevelopment.meteorclient.MeteorAddon;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.systems.commands.Commands;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.invoke.MethodHandles;

public class Lightswitch extends MeteorAddon {
    public static final Logger LOG = LogManager.getLogger();
    public static final Category CATEGORY = new Category("Ligthswitch");
    public static final String VERSION = "0.1";

    @Override
    public void onInitialize() {
        LOG.info("Initializing Lightswitch");

        // Required when using @EventHandler
        MeteorClient.EVENT_BUS.registerLambdaFactory("meteordevelopment.addons.template", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));

        // Modules
        Modules.get().add(new ModuleCategory());
        Modules.get().add(new SurroundPlus());
        Modules.get().add(new BurrowAlert());
        Modules.get().add(new PopCounter());

        // Commands
        Commands.get().add(new ExampleCommand());

        // HUD
        //HUD hud = Modules.get().get(HUD.class);
        //hud.elements.add(new HudExample(hud));
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }
}
