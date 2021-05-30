package me.feleuxens.simplehub.commands;

import me.feleuxens.simplehub.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class SetHubCommand implements CommandExecutor {
    private final Main main = Main.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String worldName = Objects.requireNonNull(player.getLocation().getWorld()).getName();
            main.saveHub(worldName, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
            player.sendMessage(ChatColor.DARK_GREEN + "Set hub position successfully!");
            return true;
        }
        sender.sendMessage("/sethub can currently only be used by players!");
        return false;
    }
}
