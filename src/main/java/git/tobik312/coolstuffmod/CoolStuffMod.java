package git.tobik312.coolstuffmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


@Mod(modid = CoolStuffMod.MODID, name = CoolStuffMod.NAME, version = CoolStuffMod.VERSION)
public class CoolStuffMod {
	
	public static final String MODID = "coolstuffmod";
    public static final String NAME = "Cool stuff mod";
    public static final String VERSION = "0.1";
    
    
    public static CreativeTabs creativeTab = new CreativeTabs("coolstuff"){

    	//Ikonka
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.APPLE);
		}
		
		//Nazwa
		@Override
		public String getTranslatedTabLabel(){
			return "Cool stuff";
		}
	
    };
    
    
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e){
    	
    }

    @EventHandler
    public void init(FMLInitializationEvent e){
    	
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e){
    	
    }

}
