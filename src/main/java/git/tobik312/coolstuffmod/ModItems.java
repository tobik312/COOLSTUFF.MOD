package git.tobik312.coolstuffmod;

import java.util.ArrayList;
import java.util.List;

import jline.internal.Log;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	
	public static final Item cigaretteItem = (Item) new ItemBuilder("Cigarette",20);
	
	public static void register(IForgeRegistry<Item> registry){
		registry.registerAll(cigaretteItem);
	}
	
	public static void registerModels() {
	}

}
