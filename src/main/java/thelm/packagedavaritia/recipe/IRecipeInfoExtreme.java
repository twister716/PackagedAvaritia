package thelm.packagedavaritia.recipe;

import java.util.Collections;
import java.util.List;

import morph.avaritia.recipe.extreme.IExtremeRecipe;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import thelm.packagedauto.api.IRecipeInfo;

public interface IRecipeInfoExtreme extends IRecipeInfo {

	ItemStack getOutput();

	IExtremeRecipe getRecipe();

	InventoryCrafting getMatrix();

	@Override
	default List<ItemStack> getOutputs() {
		return Collections.singletonList(getOutput());
	}
}
