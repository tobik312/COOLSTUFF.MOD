package git.tobik312.coolstuffmod.utils.handlers;

import git.tobik312.coolstuffmod.CustomModel;
import git.tobik312.coolstuffmod.items.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegisterHandler {
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
		
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event){
		
		for(Item item : ModItems.ITEMS){
			
			if(item instanceof CustomModel){
				
				((CustomModel) item).registerModels();
				
			}
			
		}
		
	}

}
