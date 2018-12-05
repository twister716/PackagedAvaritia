package thelm.packagedavaritia.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import thelm.packagedauto.api.RecipeTypeRegistry;
import thelm.packagedavaritia.PackagedAvaritia;
import thelm.packagedavaritia.block.BlockExtremeCrafter;
import thelm.packagedavaritia.recipe.RecipeTypeExtreme;
import thelm.packagedavaritia.tile.TileExtremeCrafter;

public class CommonProxy {

	public void registerBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
	}

	public void registerItem(Item item) {
		ForgeRegistries.ITEMS.register(item);
	}

	public void registerBlocks() {
		registerBlock(BlockExtremeCrafter.INSTANCE);
	}

	public void registerItems() {
		registerItem(BlockExtremeCrafter.ITEM_INSTANCE);
	}

	public void registerModels() {}

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileExtremeCrafter.class, new ResourceLocation(PackagedAvaritia.MOD_ID, "extreme_crafter"));
	}

	public void registerMisc() {
		RecipeTypeRegistry.registerRecipeType(RecipeTypeExtreme.INSTANCE);
	}
}
