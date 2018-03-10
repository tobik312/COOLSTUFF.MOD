package git.tobik312.coolstuffmod.items;

import git.tobik312.coolstuffmod.Main;
import git.tobik312.coolstuffmod.init.ModItems;
import git.tobik312.coolstuffmod.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
	
	public ItemBase(String name, int maxSize){
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.MYTAB);
		setMaxStackSize(maxSize);
		ModItems.ITEMS.add(this);
		
	}
	
	@Override
	public void registerModels() {

		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
	
}
