package es.hulk.cmdblocker.commands;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import es.hulk.cmdblocker.CommandBlocker;
import es.hulk.cmdblocker.utils.CC;
import es.hulk.cmdblocker.utils.command.BaseCommand;
import es.hulk.cmdblocker.utils.command.Command;
import es.hulk.cmdblocker.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 12/01/2022
 * Project: CustomCommandBlocker
 * Class: CMDBlockerCommand
 */

public class CMDBlockerCommand extends BaseCommand {

    @Command(name = "cmdblocker")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(CC.translate(""));
            player.sendMessage(CC.translate("&aCustomCommandBlocker"));
            player.sendMessage(CC.translate(""));
            player.sendMessage(CC.translate("&aVersion&7: &b1.0"));
            player.sendMessage(CC.translate("&aAuthor&7: &bElTitoHulk"));
            player.sendMessage(CC.translate("&aGithub&7: &bgithub.com/miquelangelamengual"));
        }

        if (args.length > 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                CommandBlocker.get().getMainConfig().reload();
                player.sendMessage(CC.translate("&aConfig reloaded"));
            }
        }
    }
}
