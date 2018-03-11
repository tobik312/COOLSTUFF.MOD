package git.tobik312.coolstuffmod.blocks.rack;

import git.tobik312.coolstuffmod.items.ModItems;
import net.minecraft.item.ItemStack;

import java.util.Map;
import java.util.Map.Entry;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

public class DryingRackRecipes {
	
	private static final DryingRackRecipes INSTANCE = new DryingRackRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> dryingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static DryingRackRecipes getInstance() {
		
		return INSTANCE;
		
	}
	
	private DryingRackRecipes() {
		
		addDryingRecipe(new ItemStack(ModItems.DRIED_TOBACCO_LEAF), new ItemStack(ModItems.DRIED_TOBACCO_LEAF), 5.0F);
		
	}

	
	public void addDryingRecipe(ItemStack input, ItemStack result, float experience) {
		
		if(getDryingResult(input) != ItemStack.EMPTY) return;
		this.dryingList.put(input, input, result);
		this.experienceList.put(result, Float.valueOf(experience));
		
	}
	
	public ItemStack getDryingResult(ItemStack input) {
		
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.dryingList.columnMap().entrySet()) {
			
			for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
				
				return (ItemStack)ent.getValue();
				
			}
			
		}
		
		return ItemStack.EMPTY;
		
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDryingList() {
		
		return this.dryingList;
		
	}
	
	public float getDryingExperience(ItemStack stack) {
		
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
			
			return ((Float)entry.getValue()).floatValue();
			
		}
		
		return 0.0F;
		
	}
	
}
