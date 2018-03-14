package git.tobik312.coolstuffmod.event.smoking;

import git.tobik312.coolstuffmod.utils.CoolStuffItemAction;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class SmokeStuffEventHandler{
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onPlayerRender(RenderPlayerEvent.Pre event) {
		EntityPlayer player = event.getEntityPlayer();
    	ItemStack itemStack = player.getHeldItem(EnumHand.MAIN_HAND);
    	
		if(!(itemStack.getItem() instanceof ItemSmokeStuff)) return;
		
		ItemSmokeStuff item = (ItemSmokeStuff) itemStack.getItem();
		
		if(item.getCoolStuffUseAction()==CoolStuffItemAction.SMOKING && item.isSmoking()){
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
