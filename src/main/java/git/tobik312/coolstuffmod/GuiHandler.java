package git.tobik312.coolstuffmod;

import git.tobik312.coolstuffmod.blocks.rack.ContainerDryingRack;
import git.tobik312.coolstuffmod.blocks.rack.GuiDryingRack;
import git.tobik312.coolstuffmod.blocks.rack.TileEntityDryingRack;
import git.tobik312.coolstuffmod.utils.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == Reference.GUI_DRYING_RACK) return new ContainerDryingRack(player.inventory, (TileEntityDryingRack)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
	
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_DRYING_RACK) return new GuiDryingRack(player.inventory, (TileEntityDryingRack)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}

}
