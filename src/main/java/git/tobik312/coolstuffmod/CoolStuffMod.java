package git.tobik312.coolstuffmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;


@Mod(modid = CoolStuffMod.MODID, name = CoolStuffMod.NAME, version = CoolStuffMod.VERSION)
public class CoolStuffMod {
	
	public static final String MODID = "coolstuffmod";
    public static final String NAME = "Cool stuff mod";
    public static final String VERSION = "0.1";
<<<<<<< HEAD
=======
    
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
    
    //CustomItems
    public static final ItemBuilder cigaretteItem = new ItemBuilder("Cigarette",20);
    
    //
>>>>>>> 0bd909f4566538575a40507144002271917ad122

}
