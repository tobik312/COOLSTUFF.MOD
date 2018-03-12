package git.tobik312.coolstuffmod.blocks.rack.slots;

import git.tobik312.coolstuffmod.blocks.rack.TileEntityDryingRack;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class FuelSlotDryingRack extends Slot {
	
	public FuelSlotDryingRack(IInventory inventory, int index, int x, int y) {
		
		super(inventory, index, x, y);
		
	}
	
	public boolean isItemValid(ItemStack stack) {
		
		return TileEntityDryingRack.isItemFuel(stack);
		
	}
	
	public int getItemStackLimit(ItemStack stack) {
		
		return super.getItemStackLimit(stack);
		
	}
	
}
