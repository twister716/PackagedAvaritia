package thelm.packagedavaritia;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import thelm.packagedavaritia.proxy.CommonProxy;

@Mod(
		modid = PackagedAvaritia.MOD_ID,
		name = PackagedAvaritia.NAME,
		version = PackagedAvaritia.VERSION,
		dependencies = PackagedAvaritia.DEPENDENCIES
		)
public class PackagedAvaritia {

	public static final String MOD_ID = "packagedavaritia";
	public static final String NAME = "PackagedAvaritia";
	public static final String VERSION = "1.12.2-1.0.0.1";
	public static final String DEPENDENCIES = "required-after:packagedauto@[1.12.2-1.0.0.0,);required-after:avaritia;";
	@Instance
	public static PackagedAvaritia instance;
	@SidedProxy(clientSide = "thelm.packagedavaritia.proxy.ClientProxy", serverSide = "thelm.packagedavaritia.proxy.CommonProxy", modId = PackagedAvaritia.MOD_ID)
	public static CommonProxy proxy;
	public static ModMetadata metadata;

	@EventHandler
	public void firstMovement(FMLPreInitializationEvent event) {
		proxy.registerBlocks();
		proxy.registerItems();
		proxy.registerModels();
		proxy.registerTileEntities();
		proxy.registerMisc();
	}
}
