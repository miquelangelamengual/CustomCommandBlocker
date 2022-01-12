package es.hulk.cmdblocker;

import es.hulk.cmdblocker.commands.*;
import es.hulk.cmdblocker.listeners.JoinListener;
import es.hulk.cmdblocker.utils.FileConfig;
import es.hulk.cmdblocker.utils.command.CommandManager;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter @Setter
public class CommandBlocker extends JavaPlugin {

    private CommandManager commandManager;
    private FileConfig mainConfig;

    @Override
    public void onEnable() {
        this.commandManager = new CommandManager(this, null);
        this.mainConfig = new FileConfig(this, "config.yml");

        if (mainConfig.getBoolean("WELCOME_MESSAGE.ENABLE")) {
            Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        }

        if (mainConfig.getBoolean("DISCORD_COMMAND.ENABLE")) {
            new DiscordCommand();
        }

        if (mainConfig.getBoolean("STORE_COMMAND.ENABLE")) {
            new StoreCommand();
        }

        if (mainConfig.getBoolean("PLUGINS_COMMAND.ENABLE")) {
            new PluginsCommand();
        }

        if (mainConfig.getBoolean("HELP_COMMAND.ENABLE")) {
            new HelpCommand();
        }

        new CMDBlockerCommand();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static CommandBlocker get() {
        return getPlugin(CommandBlocker.class);
    }
}
