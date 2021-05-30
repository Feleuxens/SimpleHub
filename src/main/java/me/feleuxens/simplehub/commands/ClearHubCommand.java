package me.feleuxens.simplehub.commands;

import me.feleuxens.simplehub.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;


public class ClearHubCommand implements CommandExecutor {
    private final Main main = Main.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
            main.saveHub(null, 0, 0, 0);
            sender.sendMessage(ChatColor.DARK_GREEN + "Cleared hub!");
            return true;
        }
        sender.sendMessage("/clearhub can only be used by players or the console!");
        return false;
    }
}