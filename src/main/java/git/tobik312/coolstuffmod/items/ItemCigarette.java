package git.tobik312.coolstuffmod.items;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemCigarette extends ItemBuilder{
	
	public boolean inUse = false;

	public ItemCigarette() {
		super("cigarette", 20);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
		if(inUse) return new ActionResult<ItemStack>(EnumActionResult.FAIL,new ItemStack(this));
		inUse = true;
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS,new ItemStack(this));
	}
	
	public void renderItem(ItemRenderer type, ItemStack stack, Object... data){
		GL11.glTranslatef(300.0F, 7.0F, -1.5F);
		GL11.glRotatef(30, 1, 1, 1);
	}

}
