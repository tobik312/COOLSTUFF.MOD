package git.tobik312.coolstuffmod.items;

import java.util.Random;

import git.tobik312.coolstuffmod.utils.CoolStuffItemAction;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class ItemCigarette extends ItemBuilder {
			
    public ItemCigarette() {
		super("cigarette",20);
	}

	/**
     * Called when player start smoking.
     */
	@Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
		ItemStack stack = player.getHeldItem(hand);
		if(this.getCoolStuffUseAction()==CoolStuffItemAction.SMOKING && hand==EnumHand.MAIN_HAND){
			player.setActiveHand(hand);
	        return new ActionResult<ItemStack>(EnumActionResult.PASS,stack);
		}
	        
		return new ActionResult<ItemStack>(EnumActionResult.FAIL,stack);
    }
	
	/**
	 * Called when player stop smoking.
	 */
    @Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase entity, int timeLeft){
    	if(!(entity instanceof EntityPlayer)) return;
		for(int i=0;i<5;i++){
			Random random = new Random();
			float randX = random.nextFloat()/5;
			float randZ = random.nextFloat()/5;
			float speedY = (random.nextFloat()/10)+0.2f;
			world.spawnParticle(EnumParticleTypes.CLOUD,entity.posX+randX,entity.posY+(entity.height),entity.posZ+randZ,0,speedY,0);
		}
    }
	
    /**
     * returns the action that specifies what animation to play when the items is being used
     */	
	@Override
	public CoolStuffItemAction getCoolStuffUseAction(){
		return CoolStuffItemAction.SMOKING;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack itemStack){
		return 30;
	}
	
}
