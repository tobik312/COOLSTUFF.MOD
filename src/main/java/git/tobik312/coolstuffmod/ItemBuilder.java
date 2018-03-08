package git.tobik312.coolstuffmod;

import net.minecraft.item.Item;

public class ItemBuilder extends Item {
	
	public ItemBuilder(String name,int maxSize){
		setCreativeTab(CoolStuffMod.creativeTab);
		setUnlocalizedName(CoolStuffMod.MODID+"_"+name);
		setMaxStackSize(maxSize);
		setRegistryName(name);
	}

}
