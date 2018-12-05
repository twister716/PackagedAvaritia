package thelm.packagedavaritia.container;

import net.minecraft.entity.player.InventoryPlayer;
import thelm.packagedauto.container.ContainerTileBase;
import thelm.packagedauto.slot.SlotBase;
import thelm.packagedauto.slot.SlotRemoveOnly;
import thelm.packagedavaritia.slot.SlotExtremeCrafterRemoveOnly;
import thelm.packagedavaritia.tile.TileExtremeCrafter;

public class ContainerExtremeCrafter extends ContainerTileBase<TileExtremeCrafter> {

	public ContainerExtremeCrafter(InventoryPlayer playerInventory, TileExtremeCrafter tile) {
		super(playerInventory, tile);
		addSlotToContainer(new SlotBase(inventory, 82, 8, 107));
		for(int i = 0; i < 9; ++i) {
			for(int j = 0; j < 9; ++j) {
				addSlotToContainer(new SlotExtremeCrafterRemoveOnly(tile, i*9+j, 44+j*18, 17+i*18));
			}
		}
		addSlotToContainer(new SlotRemoveOnly(inventory, 81, 242, 89));
		setupPlayerInventory();
	}

	@Override
	public int getPlayerInvX() {
		return 56;
	}

	@Override
	public int getPlayerInvY() {
		return 192;
	}
}
