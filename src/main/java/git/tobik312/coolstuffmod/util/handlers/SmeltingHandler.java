package git.tobik312.coolstuffmod.util.handlers;

import git.tobik312.coolstuffmod.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingHandler {
	
	public static void registerSmelting(){
		GameRegistry.addSmelting(ModItems.TOBACCO_LEAF, new ItemStack(ModItems.DRIED_TOBACCO_LEAF), 10);
	}
	
}
