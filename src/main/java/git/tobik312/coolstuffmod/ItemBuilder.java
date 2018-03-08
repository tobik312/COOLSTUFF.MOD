package git.tobik312.coolstuffmod;

import net.minecraft.item.Item;

public abstract class ItemBuilder extends Item {
	
	public ItemBuilder(String name,int maxSize){
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CoolStuffMod.creativeTab);
		setMaxStackSize(maxSize);
	}

}
