package me.feleuxens.simplehub.commands;

import me.feleuxens.simplehub.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getScheduler;

public class HubCommand implements CommandExecutor {
    private final Main main = Main.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            String worldName = main.getHubWorldName();
            if (worldName == null) {
                player.sendMessage(ChatColor.RED + "No hub is set.");
                return true;
            }

            World world = Bukkit.getServer().getWorld(worldName);
            double[] coordinates = main.getHubCoordinates();

            player.sendMessage(ChatColor.DARK_GREEN + "Teleporting in 3");
            getScheduler().runTaskLater(main, () -> {
                player.sendMessage(ChatColor.DARK_GREEN + "Teleporting in 2");
                getScheduler().runTaskLater(main, () -> {
                    player.sendMessage(ChatColor.DARK_GREEN + "Teleporting in 1");
                    getScheduler().runTaskLater(main, () -> {
                        float yaw = player.getLocation().getYaw();
                        float pitch = player.getLocation().getPitch();
                        player.teleport(new Location(world, coordinates[0], coordinates[1], coordinates[2], yaw, pitch));
                    }, 20L);
                }, 20L);
            }, 20L);
            return true;
        }
        sender.sendMessage("/hub can only be used by players!");
        return true;
    }
}
