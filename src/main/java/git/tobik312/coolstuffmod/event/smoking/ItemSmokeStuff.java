package git.tobik312.coolstuffmod.event.smoking;

import java.util.Random;

import git.tobik312.coolstuffmod.items.ItemBuilder;
import git.tobik312.coolstuffmod.utils.CoolStuffItemAction;
import jline.internal.Log;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public abstract class ItemSmokeStuff extends ItemBuilder {
	
	private int smokeTicks = 0;

	public ItemSmokeStuff(String name, int maxSize) {
		super(name, maxSize);
	}
	
	protected boolean isSmoking(){
		return (this.smokeTicks>0) ? true : false;
	}
		
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
		ItemStack stack = player.getHeldItem(hand);
		if(this.getCoolStuffUseAction()==CoolStuffItemAction.SMOKING && !this.isSmoking() && hand==EnumHand.MAIN_HAND){
			this.smokeTicks++;
	        return new ActionResult<ItemStack>(EnumActionResult.PASS,stack);
		}else{
	        return new ActionResult<ItemStack>(EnumActionResult.FAIL,stack);
		}
    }
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected){
		if(this.getCoolStuffUseAction()==CoolStuffItemAction.SMOKING && isSmoking() && isSelected){
			int maxItemUseDuration = getMaxItemUseDuration(stack);
			if(maxItemUseDuration>this.smokeTicks){
				this.smokeTicks++;
			}else{
				for(int i=0;i<5;i++){
					Random random = new Random();
					float randX = random.nextFloat()/5;
					float randZ = random.nextFloat()/5;
					float speedY = (random.nextFloat()/10)+0.2f;
					Minecraft.getMinecraft().world.spawnParticle(EnumParticleTypes.CLOUD,entity.posX+randX,entity.posY+(entity.height),entity.posZ+randZ,0,speedY,0);
				}
				this.smokeTicks = 0;
			}
		}
    }
	
	public abstract int getMaxItemUseDuration(ItemStack itemStack);
	
	public abstract CoolStuffItemAction getCoolStuffUseAction();

}
