package thelm.packagedavaritia.recipe;

import java.util.List;

import committee.nova.mods.avaritia.api.common.crafting.ISpecialRecipe;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import thelm.packagedauto.api.IPackageRecipeInfo;

public interface IExtremePackageRecipeInfo extends IPackageRecipeInfo {

	ItemStack getOutput();

	ISpecialRecipe getRecipe();

	Container getMatrix();

	List<ItemStack> getRemainingItems();

	@Override
	default List<ItemStack> getOutputs() {
		ItemStack output = getOutput();
		return output.isEmpty() ? List.of() : List.of(output);
	}
}
