package git.tobik312.coolstuffmod.items;

import git.tobik312.coolstuffmod.CoolStuffMod;
import git.tobik312.coolstuffmod.CustomModel;
import git.tobik312.coolstuffmod.utils.CoolStuffItemAction;
import git.tobik312.coolstuffmod.utils.ItemCoolStuff;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemBuilder extends Item implements CustomModel,ItemCoolStuff{
	
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
