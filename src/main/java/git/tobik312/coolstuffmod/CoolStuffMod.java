package git.tobik312.coolstuffmod;

import git.tobik312.coolstuffmod.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;


@Mod(modid = CoolStuffMod.MODID, name = CoolStuffMod.NAME, version = CoolStuffMod.VERSION)
public class CoolStuffMod {
	
	//References
	public static final String MODID = "coolstuffmod";
    public static final String NAME = "Cool stuff mod";
    public static final String VERSION = "0.1";
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";
	public static final String CLIENT_PROXY_CLASS = "git.tobik312.coolstuffmod.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "git.tobik312.coolstuffmod.proxy.CommonProxy";
    
	//SetProxy
    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
    
    //
    //
	//CreativeModCustomTab
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
