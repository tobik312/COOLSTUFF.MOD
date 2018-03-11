package git.tobik312.coolstuffmod;

import git.tobik312.coolstuffmod.blocks.rack.TileEntityDryingRack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	
	public static void registerTileEntities() {
		
		GameRegistry.registerTileEntity(TileEntityDryingRack.class, "drying_rack");
		
	}

}
