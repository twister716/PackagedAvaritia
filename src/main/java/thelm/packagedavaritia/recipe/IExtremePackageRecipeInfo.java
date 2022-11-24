package thelm.packagedavaritia.recipe;

import java.util.List;

import morph.avaritia.api.ExtremeCraftingRecipe;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import thelm.packagedauto.api.IPackageRecipeInfo;

public interface IExtremePackageRecipeInfo extends IPackageRecipeInfo {

	ItemStack getOutput();

	ExtremeCraftingRecipe getRecipe();

	Container getMatrix();

	List<ItemStack> getRemainingItems();

	@Override
	default List<ItemStack> getOutputs() {
		return List.of(getOutput());
	}
}
