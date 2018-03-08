package git.tobik312.coolstuffmod;

import net.minecraft.item.Item;

public class ItemBuilder extends Item {
	
	public ItemBuilder(String name,int maxSize){
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CoolStuffMod.creativeTab);
		setMaxStackSize(maxSize);
	}

}
