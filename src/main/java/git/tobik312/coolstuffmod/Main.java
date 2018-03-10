package git.tobik312.coolstuffmod;

import git.tobik312.coolstuffmod.init.ModItems;
import git.tobik312.coolstuffmod.proxy.CommonProxy;
import git.tobik312.coolstuffmod.util.Reference;
import git.tobik312.coolstuffmod.util.handlers.SmeltingHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static CreativeTabs MYTAB = new CreativeTabs("coolstuff") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.CIGARETTE);
		}
		
		@Override
		public String getTranslatedTabLabel(){
			return "Cool stuff";
		}
		
	};
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event){
		SmeltingHandler.registerSmelting();
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		
	}
	
}
