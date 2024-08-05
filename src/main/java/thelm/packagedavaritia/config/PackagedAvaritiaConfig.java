package thelm.packagedavaritia.config;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thelm.packagedavaritia.tile.TileExtremeCrafter;

public class PackagedAvaritiaConfig {

	private PackagedAvaritiaConfig() {}

	public static Configuration config;

	public static void init(File file) {
		MinecraftForge.EVENT_BUS.register(PackagedAvaritiaConfig.class);
		config = new Configuration(file);
		config.load();
		init();
	}

	public static void init() {
		String category;
		category = "blocks.extreme_crafter";
		TileExtremeCrafter.energyCapacity = config.get(category, "energy_capacity", 5000, "How much FE the Extreme Package Crafter should hold.", 0, Integer.MAX_VALUE).getInt();
		TileExtremeCrafter.energyReq = config.get(category, "energy_req", 500, "How much FE the Extreme Package Crafter should use.", 0, Integer.MAX_VALUE).getInt();
		TileExtremeCrafter.energyUsage = config.get(category, "energy_usage", 100, "How much FE/t maximum the Extreme Package Crafter should use.", 0, Integer.MAX_VALUE).getInt();
		TileExtremeCrafter.drawMEEnergy = config.get(category, "draw_me_energy", TileExtremeCrafter.drawMEEnergy, "Should the Extreme Packager Crafter draw energy from ME systems.").getBoolean();
		if(config.hasChanged()) {
			config.save();
		}
	}

	@SubscribeEvent
	public static void onConfigChanged(OnConfigChangedEvent event) {
		if(event.getModID().equals("packagedavaritia")) {
			init();
		}
	}
}
