package git.tobik312.coolstuffmod.blocks.rack.slots;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class OutputSlotDryingRack extends Slot {
	
	//Actually in use, don't know why giving warnings
	@SuppressWarnings("unused")
	private final EntityPlayer player;
	@SuppressWarnings("unused")
	private int removeCount;
	
	public OutputSlotDryingRack(EntityPlayer player, IInventory inventory, int index, int x, int y) {
		
		super(inventory, index, x, y);
		this.player = player;
		
	}
	
	public boolean isItemValid(@Nullable ItemStack stack) {
		
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
