package thelm.packagedavaritia;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import thelm.packagedavaritia.block.ExtremeCrafterBlock;
import thelm.packagedavaritia.client.event.ClientEventHandler;
import thelm.packagedavaritia.event.CommonEventHandler;

@Mod(PackagedAvaritia.MOD_ID)
public class PackagedAvaritia {

	public static final String MOD_ID = "packagedavaritia";
	public static final ItemGroup ITEM_GROUP = new ItemGroup("packagedavaritia") {
		@OnlyIn(Dist.CLIENT)
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ExtremeCrafterBlock.INSTANCE);
		}
	};
	public static PackagedAvaritia core;

	public PackagedAvaritia() {
		core = this;
		CommonEventHandler.getInstance().onConstruct();
		DistExecutor.runWhenOn(Dist.CLIENT, ()->()->{
			ClientEventHandler.getInstance().onConstruct();
		});
	}
}
