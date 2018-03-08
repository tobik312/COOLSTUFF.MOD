package git.tobik312.coolstuffmod.items;

import git.tobik312.coolstuffmod.CoolStuffMod;
import net.minecraft.item.Item;

public class ItemBuilder extends Item{
	
	public ItemBuilder(String name,int maxSize){
		setCreativeTab(CoolStuffMod.creativeTab);
		setUnlocalizedName(name);
		setMaxStackSize(maxSize);
		setRegistryName(name);
		ModItems.ITEMS.add(this);
	}
	
}
