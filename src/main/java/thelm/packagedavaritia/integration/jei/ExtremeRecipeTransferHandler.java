package thelm.packagedavaritia.integration.jei;

import java.util.Map;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import mezz.jei.api.gui.IGuiIngredient;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import thelm.packagedauto.container.ContainerEncoder;
import thelm.packagedauto.network.PacketHandler;
import thelm.packagedauto.network.packet.PacketSetRecipe;

public class ExtremeRecipeTransferHandler implements IRecipeTransferHandler<ContainerEncoder> {

	public static final ExtremeRecipeTransferHandler INSTANCE = new ExtremeRecipeTransferHandler();

	@Override
	public Class<ContainerEncoder> getContainerClass() {
		return ContainerEncoder.class;
	}

	@Override
	public IRecipeTransferError transferRecipe(ContainerEncoder container, IRecipeLayout recipeLayout, EntityPlayer player, boolean maxTransfer, boolean doTransfer) {
		if(!doTransfer) {
			return null;
		}
		Int2ObjectMap<ItemStack> map = new Int2ObjectOpenHashMap<>();
		Map<Integer, ? extends IGuiIngredient<ItemStack>> ingredients = recipeLayout.getItemStacks().getGuiIngredients();
		int index = 0;
		for(Map.Entry<Integer, ? extends IGuiIngredient<ItemStack>> entry : ingredients.entrySet()) {
			if(index >= 81) {
				break;
			}
			IGuiIngredient<ItemStack> ingredient = entry.getValue();
			if(ingredient.isInput()) {
				ItemStack displayed = entry.getValue().getDisplayedIngredient();
				if(displayed != null && !displayed.isEmpty()) {
					map.put(index, displayed);
				}
				++index;
			}
		}
		PacketHandler.INSTANCE.sendToServer(new PacketSetRecipe(map));
		return null;
	}
}
