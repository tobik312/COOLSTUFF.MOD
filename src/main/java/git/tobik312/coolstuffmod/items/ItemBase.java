package git.tobik312.coolstuffmod.items;

import git.tobik312.coolstuffmod.Main;
import git.tobik312.coolstuffmod.init.ModItems;
import git.tobik312.coolstuffmod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
	
	public ItemBase(String name){
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		
		ModItems.ITEMS.add(this);
		
	}
	
	@Override
	public void registerModels() {

		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
	
}
