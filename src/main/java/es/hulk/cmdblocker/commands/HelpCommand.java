package es.hulk.cmdblocker.commands;

import es.hulk.cmdblocker.CommandBlocker;
import es.hulk.cmdblocker.utils.CC;
import es.hulk.cmdblocker.utils.FileConfig;
import es.hulk.cmdblocker.utils.command.BaseCommand;
import es.hulk.cmdblocker.utils.command.Command;
import es.hulk.cmdblocker.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 12/01/2022
 * Project: CustomCommandBlocker
 * Class: HelpCommand
 */

public class HelpCommand extends BaseCommand {

    private final FileConfig mainConfig = CommandBlocker.get().getMainConfig();

    @Command(name = "help")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        for (String str : mainConfig.getStringList("HELP_COMMAND.LINES")) {
            player.sendMessage(CC.translate(str.replace("<player>", player.getDisplayName())));
        }
    }
}
