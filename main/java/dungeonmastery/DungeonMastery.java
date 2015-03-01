package dungeonmastery;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;

import org.apache.logging.log4j.Logger;

import dungeonmastery.block.BlockDevice;
import dungeonmastery.block.BlockInfo;
import dungeonmastery.block.BlockList;
import dungeonmastery.client.gui.GuiHandler;
import dungeonmastery.config.ConfigHandler;
import dungeonmastery.event.DMEventHandler;
import dungeonmastery.item.ItemDungeonBook;
import dungeonmastery.item.ItemList;
import dungeonmastery.item.ItemSoul;
import dungeonmastery.proxy.ClientProxy;
import dungeonmastery.proxy.CommonProxy;
import dungeonmastery.tabs.CreativeTabDMCore;

@Mod(modid = ModInfo.MODID, version = ModInfo.VERSION)
public class DungeonMastery
{
	@Instance(ModInfo.MODID)
	public static DungeonMastery instance;

	@SidedProxy(clientSide = "dungeonmastery.proxy.ClientProxy", serverSide = "dungeonmastery.proxy.CommonProxy")     
	public static CommonProxy proxy;
	public static ItemList items;
	public static BlockList blocks;
	public static CreativeTabs tabdungeon = new CreativeTabDMCore(CreativeTabs.getNextID(), "dungeontab");
	public static Logger logger;
	private static int modGuiIndex = 10;

	public static final int GUI_PLAYER_INV = modGuiIndex++,	GUI_ITEM_INV = modGuiIndex++;
	
	public static Block blockDevice;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		logger = event.getModLog();
		logger.info("Beginning pre-initialization");
		ConfigHandler.init(event.getSuggestedConfigurationFile());

		items.Init();

		blockDevice = new BlockDevice();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) 
	{

		
		logger.info("Beginning initialization");
		if(event.getSide() == Side.CLIENT)
		{
		    	RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		    	
		    	//blocks
	    		renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockDevice), 0, new ModelResourceLocation(ModInfo.MODID + ":" + ((BlockDevice) blockDevice).getName(), "inventory"));
	    		
		    	//items
		    	renderItem.getItemModelMesher().register(ItemList.itemDungeonBook, 0, new ModelResourceLocation(ModInfo.MODID + ":" + ((ItemDungeonBook) ItemList.itemDungeonBook).getName(), "inventory"));
		    	renderItem.getItemModelMesher().register(ItemList.itemSoul, 0, new ModelResourceLocation(ModInfo.MODID + ":" + ((ItemSoul) ItemList.itemSoul).getName(), "inventory"));
		
		    	
	    		
	    }
	    
		new GuiHandler();
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		logger.info("Beginning post-initialization");
		MinecraftForge.EVENT_BUS.register(new DMEventHandler());
		
		proxy.registerRenderers();

	}
	
	@EventHandler
	public void ServerStart(FMLServerStartingEvent event)
	{

	}
}
