package git.tobik312.coolstuffmod.init;

import java.util.ArrayList;
import java.util.List;

import git.tobik312.coolstuffmod.items.ItemBase;
import net.minecraft.item.Item;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();

	public static final Item CIGARETTE = new ItemBase("cigarette", 1);
	public static final Item CIGARETTE_PAPER = new ItemBase("cigarette_paper", 32);
	public static final Item FILTER = new ItemBase("filter", 16);
	public static final Item TOBACCO_LEAF = new ItemBase("tobacco_leaf", 64);
	public static final Item DRIED_TOBACCO_LEAF = new ItemBase("dried_tobacco_leaf", 64);
	
}