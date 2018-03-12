package git.tobik312.coolstuffmod.blocks.rack.slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class OutputSlotDryingRack extends Slot {
	
	private final EntityPlayer player;
	private int removeCount;
	
	public OutputSlotDryingRack(EntityPlayer player, IInventory inventory, int index, int x, int y) {
		
		super(inventory, index, x, y);
		this.player = player;
		
	}
	
	public boolean isItemValid(ItemStack stack) {
		
		return false;
		
	}
	
	public ItemStack onTake(EntityPlayer player, ItemStack stack) {
		
		this.onCrafting(stack);
		super.onTake(player, stack);
		return stack;
		
	}
	
	public ItemStack decrStackSize(int amount) {
		
		if(this.getHasStack()) this.removeCount += Math.min(amount, this.getStack().getCount());
		return super.decrStackSize(amount);
		
	}
	
}
