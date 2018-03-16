package git.tobik312.coolstuffmod;

import git.tobik312.coolstuffmod.blocks.ModBlocks;
import git.tobik312.coolstuffmod.items.ModItems;
import git.tobik312.coolstuffmod.utils.CustomModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod.EventBusSubscriber
public class RegisterHandler {
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event){
		
		for(Item item : ModItems.ITEMS){
			if(item instanceof CustomModel){
				((CustomModel) item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS){
			if(block instanceof CustomModel){
				((CustomModel)block).registerModels();
			}
}
		
	}
	
	public static void preInitRegistries() {}
	
	public static void initRegistries() {
		
		NetworkRegistry.INSTANCE.registerGuiHandler(CoolStuffMod.instance, new GuiHandler());
		
	}
	
	public static void postInitRegistries() {}

}
