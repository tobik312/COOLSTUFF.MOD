package git.tobik312.coolstuffmod.items;


import git.tobik312.coolstuffmod.CoolStuffMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

public class ItemCigarette extends ItemBuilder{
	
	public boolean inUse = false;

	public ItemCigarette() {
		super("cigarette", 20);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
		if(inUse) return new ActionResult<ItemStack>(EnumActionResult.FAIL,new ItemStack(this));
		inUse = true;
		player.setActiveHand(hand);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS,new ItemStack(this));
	}

}
