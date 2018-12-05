package thelm.packagedavaritia.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;

@JEIPlugin
public class PackagedAvaritiaJEIPlugin implements IModPlugin {

	public static final String EXTREME_CRAFTING = "Avatitia.Extreme";

	@Override
	public void register(IModRegistry registry) {
		registry.getRecipeTransferRegistry().addRecipeTransferHandler(ExtremeRecipeTransferHandler.INSTANCE, EXTREME_CRAFTING);;
	}
}
