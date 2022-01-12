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
 * Class: StoreCommand
 */

public class StoreCommand extends BaseCommand {

    private final FileConfig mainConfig = CommandBlocker.get().getMainConfig();

    @Command(name = "store", aliases = "tienda")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        for (String str : mainConfig.getStringList("STORE_COMMAND.LINES")) {
            player.sendMessage(CC.translate(str.replace("<player>", player.getDisplayName())));
        }
    }
}
