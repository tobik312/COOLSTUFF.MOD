package git.tobik312.coolstuffmod.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;

public class ModItems {
	
	public static List<Item> ITEMS = new ArrayList<Item>();
	
	public static Item CIGARETTE = (Item) new ItemBuilder("cigarette",1);
	public static Item CIGARETTE_PAPER = (Item) new ItemBuilder("cigarette_paper",32);
	public static Item FILTER = (Item) new ItemBuilder("filter",16);
	public static Item TOBACCO_LEAF = (Item) new ItemBuilder("tobacco_leaf");
	public static Item DRIED_TOBACCO_LEAF = (Item) new ItemBuilder("dried_tobacco_leaf");

}
