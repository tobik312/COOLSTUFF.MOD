package git.tobik312.coolstuffmod.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;

public class ModItems {
	
	public static List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item CIGARETTE = new ItemBuilder("cigarette", 1);
	public static final Item CIGARETTE_PAPER = new ItemBuilder("cigarette_paper", 32);
	public static final Item FILTER = new ItemBuilder("filter", 16);
	public static final Item TOBACCO_LEAF = new ItemBuilder("tobacco_leaf", 64);
	public static final Item DRIED_TOBACCO_LEAF = new ItemBuilder("dried_tobacco_leaf", 64);

}
