package dev._2lstudios.viapotions.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import com.viaversion.viaversion.api.Via;

public class VersionUtil {

	public static final float VERSION;

	static {
		final String[] version = Bukkit.getServer().getBukkitVersion().split("-")[0].split("\\.");
		if (version[2].length() <= 1) {
			version[2] = '0' + version[2];
		}
		// For example: 8.08, 19.01, 20.04
		VERSION = Float.parseFloat(version[1] + '.' + version[2]);
	}

	private final Plugin viaVersion;

	public VersionUtil(final Plugin plugin) {
		final PluginManager pluginManager = plugin.getServer().getPluginManager();

		viaVersion = pluginManager.getPlugin("ViaVersion");
	}

	public int getVersion(Player player) {
		if (viaVersion != null) {
			return getViaVersionVersion(player);
		}

		return -1;
	}

	private int getViaVersionVersion(Player player) {
		return Via.getAPI().getPlayerVersion(player.getUniqueId());
	}
}
