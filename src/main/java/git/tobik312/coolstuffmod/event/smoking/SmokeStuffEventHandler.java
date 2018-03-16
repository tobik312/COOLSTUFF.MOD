package git.tobik312.coolstuffmod.event.smoking;

import git.tobik312.coolstuffmod.utils.CoolStuffItemAction;
import git.tobik312.coolstuffmod.utils.ItemCoolStuff;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class SmokeStuffEventHandler{
		
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onPlayerRender(RenderPlayerEvent.Pre event) {
		EntityPlayer player = event.getEntityPlayer();
		if(player.getActiveHand()!=EnumHand.MAIN_HAND) return;
		
    	ItemStack itemStack = player.getActiveItemStack();
    	
		if(!(itemStack.getItem() instanceof ItemCoolStuff)) return;
		
		ItemCoolStuff item = (ItemCoolStuff) itemStack.getItem();

		if(item.getCoolStuffUseAction()==CoolStuffItemAction.SMOKING){
			if(!(event.getRenderer() instanceof RenderSmokingPlayer)){
				event.setCanceled(true);
				new RenderSmokingPlayer(event.getRenderer().getRenderManager()).doRender((AbstractClientPlayer) player,
						event.getX(),
						event.getY(),
						event.getZ(),
						0.0625F
						,event.getPartialRenderTick());
			}
		}
	}
    	
}
