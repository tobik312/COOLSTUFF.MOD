package git.tobik312.coolstuffmod.items;

import git.tobik312.coolstuffmod.CoolStuffMod;
import git.tobik312.coolstuffmod.utils.CoolStuffItemAction;
import git.tobik312.coolstuffmod.utils.ItemCoolStuff;
import net.minecraft.item.Item;

public class ItemBuilder extends Item implements ItemCoolStuff{
	
	public ItemBuilder(String name,int maxSize){
		setCreativeTab(CoolStuffMod.CREATIVE_TAB);
		setUnlocalizedName(name);
		setMaxStackSize(maxSize);
		setRegistryName(name);
		ModItems.ITEMS.add(this);
	}
	
	public ItemBuilder(String name){
		new ItemBuilder(name, 64);
	}
	
	public void registerModels() {
		CoolStuffMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	public CoolStuffItemAction getCoolStuffUseAction(){
		return CoolStuffItemAction.NONE;
	}
	
}
