package thelm.packagedavaritia.recipe;

import morph.avaritia.recipe.extreme.IExtremeRecipe;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import thelm.packagedauto.api.IRecipeInfo;

public interface IRecipeInfoExtreme extends IRecipeInfo {

	ItemStack getOutput();

	IExtremeRecipe getRecipe();

	InventoryCrafting getMatrix();
}
