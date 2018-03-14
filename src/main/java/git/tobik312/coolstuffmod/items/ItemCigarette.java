package git.tobik312.coolstuffmod.items;

import git.tobik312.coolstuffmod.event.smoking.ItemSmokeStuff;
import git.tobik312.coolstuffmod.utils.CoolStuffItemAction;
import net.minecraft.item.ItemStack;

public class ItemCigarette extends ItemSmokeStuff{
	
	public boolean inUse = false;

	public ItemCigarette() {
		super("cigarette", 20);
	}

	@Override	
	public int getMaxItemUseDuration(ItemStack stack){
        return 120;
    }


	@Override
	public CoolStuffItemAction getCoolStuffUseAction() {
		return CoolStuffItemAction.SMOKING;
	}

}
