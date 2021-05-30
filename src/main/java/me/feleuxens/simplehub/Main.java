package me.feleuxens.simplehub;

import me.feleuxens.simplehub.commands.ClearHubCommand;
import me.feleuxens.simplehub.commands.HubCommand;
import me.feleuxens.simplehub.commands.SetHubCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;


public class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        Main.instance = this;

        this.saveDefaultConfig();

        Objects.requireNonNull(this.getCommand("sethub")).setExecutor(new SetHubCommand());
        Objects.requireNonNull(this.getCommand("hub")).setExecutor(new HubCommand());
        Objects.requireNonNull(this.getCommand("clearhub")).setExecutor(new ClearHubCommand());
    }

    @Override
    public void onDisable() {
        this.saveConfig();
    }

    public double[] getHubCoordinates() {
        double[] coordinates = {0,0,0};
        coordinates[0] = this.getConfig().getDouble("hub.x");
        coordinates[1] = this.getConfig().getDouble("hub.y");
        coordinates[2] = this.getConfig().getDouble("hub.z");
        return coordinates;
    }

    public String getHubWorldName() {
        return this.getConfig().getString("hub.world");
    }

    public void saveHub(String world, double x, double y, double z) {
        if (world == null) {
            getLogger().info("Hub cleared.");
        } else {
            getLogger().info("Saving hub.");
        }

        this.getConfig().set("hub.world", world);
        this.getConfig().set("hub.x", x);
        this.getConfig().set("hub.y", y);
        this.getConfig().set("hub.z", z);

        this.saveConfig();
        this.reloadConfig();
    }

    public static Main getInstance() {
        return instance;
    }

}
