package git.tobik312.coolstuffmod.blocks.rack;

import git.tobik312.coolstuffmod.items.ModItems;
import net.minecraft.item.ItemStack;
import java.util.Map;
import java.util.Map.Entry;
import com.google.common.collect.Maps;

public class DryingRackRecipes {
	
	private static final DryingRackRecipes INSTANCE = new DryingRackRecipes();
	private final Map<ItemStack, ItemStack> dryingList = Maps.<ItemStack, ItemStack>newHashMap();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static DryingRackRecipes getInstance() {
		
		return INSTANCE;
		
	}
	
	private DryingRackRecipes() {
		
		addDryingRecipe(new ItemStack(ModItems.TOBACCO_LEAF), new ItemStack(ModItems.DRIED_TOBACCO_LEAF), 5.0F);
		
	}

	
	public void addDryingRecipe(ItemStack input, ItemStack result, float experience) {
		
		this.dryingList.put(input, result);
		this.experienceList.put(result, Float.valueOf(experience));
		
	}
	
	public ItemStack getDryingResult(ItemStack input) {
		
		for(Entry<ItemStack, ItemStack> entry : this.dryingList.entrySet()) {
			
			if (this.compareItemStacks(input, (ItemStack)entry.getKey())) {
				
                return (ItemStack)entry.getValue();
                
            }
			
		}
		
		return ItemStack.EMPTY;
		
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
		
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
        
    }
	
	public Map<ItemStack, ItemStack> getDryingList() {
		
		return this.dryingList;
		
	}
	
	public float getDryingExperience(ItemStack stack) {
		
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
			
			if (this.compareItemStacks(stack, (ItemStack)entry.getKey())) {
				
                return ((Float)entry.getValue()).floatValue();
                
            }
			
		}
		
		return 0.0F;
		
	}
	
}
