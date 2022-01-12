package es.hulk.cmdblocker.listeners;

import es.hulk.cmdblocker.CommandBlocker;
import es.hulk.cmdblocker.utils.CC;
import es.hulk.cmdblocker.utils.FileConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Hulk
 * at 12/01/2022
 * Project: CustomCommandBlocker
 * Class: JoinListener
 */

public class JoinListener implements Listener {

    private final FileConfig mainConfig = CommandBlocker.get().getMainConfig();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        for (String str : mainConfig.getStringList("WELCOME_MESSAGE.LINES")) {
            player.sendMessage(CC.translate(str.replace("<player>", player.getDisplayName())));
        }
    }
}
