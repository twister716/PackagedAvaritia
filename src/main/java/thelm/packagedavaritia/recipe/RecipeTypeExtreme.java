package thelm.packagedavaritia.recipe;

import java.awt.Color;
import java.util.stream.IntStream;

import it.unimi.dsi.fastutil.ints.IntRBTreeSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import morph.avaritia.init.ModBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thelm.packagedauto.api.IRecipeInfo;
import thelm.packagedauto.api.IRecipeType;
import thelm.packagedavaritia.PackagedAvaritia;

public class RecipeTypeExtreme implements IRecipeType {

	public static final RecipeTypeExtreme INSTANCE = new RecipeTypeExtreme();
	public static final ResourceLocation NAME = new ResourceLocation(PackagedAvaritia.MOD_ID, "extreme");
	public static final IntSet SLOTS;
	public static final Color COLOR = new Color(255, 255, 255, 0);
	public static final Color COLOR_DISABLED = new Color(64, 64, 64, 255);

	static {
		SLOTS = new IntRBTreeSet();
		IntStream.range(0, 81).forEachOrdered(SLOTS::add);
	}

	protected RecipeTypeExtreme() {};

	@Override
	public ResourceLocation getName() {
		return NAME;
	}

	@Override
	public String getLocalizedName() {
		return I18n.translateToLocal("recipe.packagedavaritia.extreme");
	}

	@Override
	public String getLocalizedNameShort() {
		return I18n.translateToLocal("recipe.packagedavaritia.extreme.short");
	}

	@Override
	public IRecipeInfo getNewRecipeInfo() {
		return new RecipeInfoExtreme();
	}

	@Override
	public IntSet getEnabledSlots() {
		return SLOTS;
	}

	@Override
	public boolean canSetOutput() {
		return false;
	}

	@Override
	public boolean hasMachine() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Object getRepresentation() {
		return new ItemStack(ModBlocks.extremeCraftingTable);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Color getSlotColor(int slot) {
		if(slot >= 81 && slot != 85 && slot < 90) {
			return COLOR_DISABLED;
		}
		return COLOR;
	}
}
