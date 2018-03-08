package git.tobik312.coolstuffmod;

import net.minecraft.item.Item;

public class ItemBuilder extends Item {
	
	public ItemBuilder(String name,int maxSize,String textureName){
		setCreativeTab(CoolStuffMod.creativeTab);
		setUnlocalizedName(name);
		setMaxStackSize(maxSize);
		setRegistryName(name);
		setTextureName(CoolStuffMod.MODID+":"+textureName+".png");
	}

}
