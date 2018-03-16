package git.tobik312.coolstuffmod;

import git.tobik312.coolstuffmod.items.ModItems;
import git.tobik312.coolstuffmod.proxy.CommonProxy;
import git.tobik312.coolstuffmod.utils.Reference;
import git.tobik312.coolstuffmod.utils.RegisterHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class CoolStuffMod {
	
	@Instance
	public static CoolStuffMod instance;
    
	//SetProxy
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
    
    //
    //CreativeModCustomTab
	//
    public static CreativeTabs CREATIVE_TAB = new CreativeTabs("coolstuff"){

    	//TabIcon
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.CIGARETTE);
		}
		
		//TabName
		@Override
		public String getTranslatedTabLabel(){
			return "Cool stuff";
		}
	
    };
    

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {RegisterHandler.preInitRegistries();}
	@EventHandler
	public static void init(FMLInitializationEvent event) {RegisterHandler.initRegistries();}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {RegisterHandler.postInitRegistries();}

}
