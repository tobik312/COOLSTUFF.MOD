package git.tobik312.coolstuffmod.blocks;

import git.tobik312.coolstuffmod.CoolStuffMod;
import git.tobik312.coolstuffmod.items.ModItems;
import git.tobik312.coolstuffmod.utils.CustomModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBuilder extends Block implements CustomModel{
	
	public BlockBuilder(String name, Material material) {
		
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CoolStuffMod.CREATIVE_TAB);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}

	@Override
	public void registerModels() {
		
		CoolStuffMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	
}
