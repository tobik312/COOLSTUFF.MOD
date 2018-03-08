package git.tobik312.coolstuffmod;

import git.tobik312.coolstuffmod.proxy.CommonProxy;
import git.tobik312.coolstuffmod.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class CoolStuffMod {
    
	//SetProxy
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
    
    //
    //CreativeModCustomTab
	//
    public static CreativeTabs creativeTab = new CreativeTabs("coolstuff"){

    	//TabIcon
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.APPLE);
		}
		
		//TabName
		@Override
		public String getTranslatedTabLabel(){
			return "Cool stuff";
		}
	
    };

}
