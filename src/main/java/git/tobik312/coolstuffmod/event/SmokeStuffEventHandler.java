package git.tobik312.coolstuffmod.event;

import java.util.HashMap;
import java.util.Map;

import git.tobik312.coolstuffmod.items.ItemCigarette;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class SmokeStuffEventHandler {
	
	public static float RENDER_SCALE = 0.0625F;
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onPlayerRender(RenderPlayerEvent.Pre event) {
		EntityPlayer player = event.getEntityPlayer();
		Item itemInHand = player.getHeldItem(EnumHand.MAIN_HAND).getItem();
		if(itemInHand instanceof ItemCigarette && ((ItemCigarette) itemInHand).inUse){
			event.getRenderer().getMainModel().bipedRightArm.isHidden = true;
		}
			
	}
    
	@SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onPlayerRender(RenderPlayerEvent.Post event) {
    	EntityPlayer player = event.getEntityPlayer();
    	Item itemInHand = player.getHeldItem(EnumHand.MAIN_HAND).getItem();
    	if(itemInHand instanceof ItemCigarette && ((ItemCigarette) itemInHand).inUse){
    		ResourceLocation texture = event.getRenderer().getEntityTexture((AbstractClientPlayer) player);
    		event.getRenderer().bindTexture(texture);
    		event.getRenderer().getMainModel().bipedRightArm.isHidden=false;
    		event.getRenderer().getMainModel().bipedRightArm.rotationPointZ = -MathHelper.sin((float) Math.toRadians(player.renderYawOffset)) * 5.0F;
    		event.getRenderer().getMainModel().bipedRightArm.rotationPointY = 20;
    		event.getRenderer().getMainModel().bipedRightArm.rotationPointX = -MathHelper.cos((float) Math.toRadians(player.renderYawOffset)) * 5.0F;
    		//Math.toRadians(player.rotationYawHead) - dependent
    		event.getRenderer().getMainModel().bipedRightArm.rotateAngleX = 1.22f;
    		event.getRenderer().getMainModel().bipedRightArm.rotateAngleY = (float) -Math.toRadians(player.renderYawOffset);
    		event.getRenderer().getMainModel().bipedRightArm.rotateAngleZ = -0.52f;
    		//
    		event.getRenderer().getMainModel().bipedRightArm.renderWithRotation(RENDER_SCALE);
    		event.getRenderer().getMainModel().bipedRightArm.rotationPointY = 2;
    	}
    }

	private static Map<EntityPlayer,Integer> playerTickCount = new HashMap<EntityPlayer,Integer>();
	@SubscribeEvent
	public static void playerTickEvent(PlayerTickEvent event){
    	EntityPlayer player = event.player;
    	Item itemInHand = player.getHeldItem(EnumHand.MAIN_HAND).getItem();
		if(!playerTickCount.containsKey(player)) playerTickCount.put(player, 0);
    	if(itemInHand instanceof ItemCigarette && ((ItemCigarette) itemInHand).inUse){
    		int actualPlayerTicks = playerTickCount.get(player);
    		playerTickCount.replace(player, ++actualPlayerTicks);
    		if(actualPlayerTicks==80){
    			((ItemCigarette) itemInHand).inUse = false;
    			playerTickCount.replace(player,0);
    		}
    	}
	}
	
}
