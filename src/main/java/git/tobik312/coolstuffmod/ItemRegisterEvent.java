package git.tobik312.coolstuffmod;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ItemRegisterEvent {
	
	private Item item;
	
	public ItemRegisterEvent(Item item){
		this.item = item;
	}

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(item);
    }
	
}
