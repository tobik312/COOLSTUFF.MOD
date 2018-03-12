package git.tobik312.coolstuffmod.blocks.rack;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.actors.threadpool.Arrays;

public class TileEntityDryingRack extends TileEntity implements IInventory, ITickable {
	
	private ItemStack[] dryerItemStacks = new ItemStack[3];
    private int dryerBurnTime;
    private int currentItemBurnTime;
    private int cookTime;
    private int totalCookTime;
    private String customName;
	
	@Override
	public String getName() {
		
		return this.hasCustomName() ? this.customName : "container.drying_rack";
		
	}
	
	@Override
	public boolean hasCustomName() {
		
		return this.customName != null && !this.customName.isEmpty();
		
	}
	
	public void setCustomName(String customName) {
		
		this.customName = customName;
		
	}
	
	@Override
	public ITextComponent getDisplayName() {
		
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
		
	}
	
	@Override
	public int getSizeInventory() {
		
		return this.dryerItemStacks.length;
		
	}
	
	@Override
	public boolean isEmpty() {
		
		for(ItemStack stack : this.dryerItemStacks) {
			
			if(!stack.isEmpty()) return false;
			
		}
		
		return true;
		
	}
	
	@Override
	public ItemStack getStackInSlot(int index) {
		
		return this.dryerItemStacks[index];
		
	}
	
	@SuppressWarnings("unchecked")
	@Nullable
	public ItemStack decrStackSize(int index, int count) {
		
        return ItemStackHelper.getAndSplit(Arrays.asList(this.dryerItemStacks), index, count);
        
    }

	@SuppressWarnings("unchecked")
	@Nullable
	public ItemStack removeStackFromSlot(int index) {
		
		return ItemStackHelper.getAndRemove(Arrays.asList(this.dryerItemStacks), index);
		
	}

	@Override
	public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
		
        boolean flag = stack != null && stack.isItemEqual(this.dryerItemStacks[index]) && ItemStack.areItemStackTagsEqual(stack, this.dryerItemStacks[index]);
        this.dryerItemStacks[index] = stack;

        if (stack != null && stack.getCount() > this.getInventoryStackLimit()) {
        	
            stack.setCount(this.getInventoryStackLimit());
            
        }

        if (index == 0 && !flag) {
        	
            this.totalCookTime = this.getCookTime(stack);
            this.cookTime = 0;
            this.markDirty();
            
        }
}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.dryerItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
        	
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");

            if (j >= 0 && j < this.dryerItemStacks.length){
            	
                this.dryerItemStacks[j] = new ItemStack(nbttagcompound);
                
            }
            
        }

        this.dryerBurnTime = compound.getShort("BurnTime");
        this.cookTime = compound.getShort("CookTime");
        this.totalCookTime = compound.getShort("CookTimeTotal");
        this.currentItemBurnTime = getItemBurnTime(this.dryerItemStacks[1]);

        if (compound.hasKey("CustomName", 8)) {
        	
            this.customName = compound.getString("CustomName");
            
        }
}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		
		super.writeToNBT(compound);
		compound.setInteger("BurnTime", (short)this.dryerBurnTime);
		compound.setInteger("CookTime", (short)this.cookTime);
		compound.setInteger("CookTimeTotal", (short)this.totalCookTime);
		NBTTagList nbttaglist = new NBTTagList();
		
		for (int i = 0; i < this.dryerItemStacks.length; ++i) {
			
            if (this.dryerItemStacks[i] != null) {
            	
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.dryerItemStacks[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
                
            }
            
        }
		
		if(this.hasCustomName()) compound.setString("CustomName", this.customName);
		return compound;
		
	}

	@Override
	public int getInventoryStackLimit() {
		
		return 64;
		
	}
	
	public boolean isBurning() {
		
		return this.dryerBurnTime > 0;
		
	}
	
	@SideOnly(Side.CLIENT)
	public static boolean isBurning(IInventory inventory) {
		
		return inventory.getField(0) > 0;
		
	}
	
	public void update() {
		
		boolean flag = this.isBurning();
        boolean flag1 = false;

        if (this.isBurning()) {
        	
            --this.dryerBurnTime;
            
        }

        if (!this.world.isRemote) {
        	
            if (this.isBurning() || this.dryerItemStacks[1] != null && this.dryerItemStacks[0] != null) {
            	
                if (!this.isBurning() && this.canSmelt()) {
                	
                    this.dryerBurnTime = getItemBurnTime(this.dryerItemStacks[1]);
                    this.currentItemBurnTime = this.dryerBurnTime;

                    if (this.isBurning()) {
                    	
                    	flag1 = true;

                        if (this.dryerItemStacks[1] != null) {
                        	
                            this.dryerItemStacks[1].setCount(this.dryerItemStacks[1].getCount()-1);

                            if (this.dryerItemStacks[1].getCount() == 0) {
                            	
                                Item item = this.dryerItemStacks[1].getItem().getContainerItem();
                                this.dryerItemStacks[1] = item != null ? new ItemStack(item) : null;
                                
                            }
                            
                        }
                        
                    }
                    
                }

                if (this.isBurning() && this.canSmelt()) {
                	
                    ++this.cookTime;

                    if (this.cookTime == this.totalCookTime) {
                    	
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime(this.dryerItemStacks[0]);
                        this.smeltItem();
                        flag1 = true;
                        
                    }
                    
                }
                
                else {
                	
                    this.cookTime = 0;
                    
                }
                
            }
            
            else if (!this.isBurning() && this.cookTime > 0) {
            	
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
                
            }

            if (flag != this.isBurning()) {
            	
                flag1 = true;
                DryingRack.setState(this.isBurning(), this.world, this.pos);
                
            }
            
        }

        if (flag1) {
        	
            this.markDirty();
            
        }
		
	}
	
	public int getCookTime(@Nullable ItemStack input) {
		
		return 400;
		
	}
	
	private boolean canSmelt() {
		
        if (this.dryerItemStacks[0] == null) {
        	
            return false;
            
        }
        
        else {
        	
            ItemStack itemstack = DryingRackRecipes.getInstance().getDryingResult(this.dryerItemStacks[0]);
            return itemstack == null ? false : (this.dryerItemStacks[2] == null ? true : (!this.dryerItemStacks[2].isItemEqual(itemstack) ? false : (this.dryerItemStacks[2].getCount() < this.getInventoryStackLimit() && this.dryerItemStacks[2].getCount() < this.dryerItemStacks[2].getMaxStackSize() ? true : this.dryerItemStacks[2].getCount() < itemstack.getMaxStackSize())));
        
        }
        
}
	
	public void smeltItem() {
		
        if (this.canSmelt()) {
        	
            ItemStack itemstack = DryingRackRecipes.getInstance().getDryingResult(this.dryerItemStacks[0]);

            if (this.dryerItemStacks[2] == null) {
            	
                this.dryerItemStacks[2] = itemstack.copy();
                
            }
            
            else if (this.dryerItemStacks[2].getItem() == itemstack.getItem()) {
            	
                this.dryerItemStacks[0].setCount(this.dryerItemStacks[0].getCount()+1);
                
            }

            this.dryerItemStacks[0].setCount(this.dryerItemStacks[0].getCount()-1);

            if (this.dryerItemStacks[0].getCount()<= 0) {
            	
                this.dryerItemStacks[0] = null;
                
            }
            
        }
        
	}
	
	public static int getItemBurnTime(ItemStack stack) {
		
		if(stack.isEmpty()) return 0;
		else {
			
			Item item = stack.getItem();

			if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR) {
				
				Block block = Block.getBlockFromItem(item);

				if (block == Blocks.WOODEN_SLAB) return 150;
				if (block.getDefaultState().getMaterial() == Material.WOOD) return 300;
				if (block == Blocks.COAL_BLOCK) return 16000;
				
			}

			if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 200;
			if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) return 200;
			if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName())) return 200;
			if (item == Items.STICK) return 100;
			if (item == Items.COAL) return 1600;
			if (item == Items.LAVA_BUCKET) return 20000;
			if (item == Item.getItemFromBlock(Blocks.SAPLING)) return 100;
			if (item == Items.BLAZE_ROD) return 2400;

			return 0;
			
		}
		
	}
		
	public static boolean isItemFuel(ItemStack stack) {
		
		return getItemBurnTime(stack) > 0;
		
	}
	
	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
		
	}

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		
		if(index == 2) return false;
		else if(index != 1) return true;
		else {
			
			return isItemFuel(stack);
			
		}
		
	}
	
	public String getGuiID() {
		
		return "coolstuffmod:drying_rack";
		
	}

	@Override
	public int getField(int id) {
		
		switch(id) {
		
		case 0:
			
			return this.dryerBurnTime;
			
		case 1:
			
			return this.currentItemBurnTime;
			
		case 2:
			
			return this.cookTime;
			
		case 3:
			
			return this.totalCookTime;
			
		default:
			
			return 0;
			
		}
		
	}

	@Override
	public void setField(int id, int value) {
		
		switch(id) {
		
		case 0:
			
			this.dryerBurnTime = value;
			break;
			
		case 1:
			
			this.currentItemBurnTime = value;
			break;
			
		case 2:
			
			this.cookTime = value;
			break;
			
		case 3:
			
			this.totalCookTime = value;
			
		}
		
	}

	@Override
	public int getFieldCount() {
		
		return 4;
		
	}
	
	@Override
	public void clear() {
		
        for (int i = 0; i < this.dryerItemStacks.length; ++i) {
        	
            this.dryerItemStacks[i] = null;
            
        }
        
    }
	
}