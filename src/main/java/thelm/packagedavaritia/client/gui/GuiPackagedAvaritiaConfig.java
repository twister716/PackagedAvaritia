package thelm.packagedavaritia.client.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import thelm.packagedavaritia.config.PackagedAvaritiaConfig;

public class GuiPackagedAvaritiaConfig extends GuiConfig {

	public GuiPackagedAvaritiaConfig(GuiScreen parent) {
		super(parent, getConfigElements(), "packagedavaritia", false, false, getAbridgedConfigPath(PackagedAvaritiaConfig.config.toString()));
	}

	private static List<IConfigElement> getConfigElements() {
		ArrayList<IConfigElement> list = new ArrayList<>();
		for(String category : PackagedAvaritiaConfig.config.getCategoryNames()) {
			list.add(new ConfigElement(PackagedAvaritiaConfig.config.getCategory(category)));
		}
		return list;
	}
}
