package dungeonmastery;

import dungeonmastery.block.BlockList;
import dungeonmastery.client.gui.GuiHandler;
import dungeonmastery.item.ItemDungeonBook;
import dungeonmastery.item.ItemList;
import dungeonmastery.proxy.CommonProxy;
import dungeonmastery.tabs.CreativeTabDungeon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = ModInfo.MODID, version = ModInfo.VERSION)
public class DungeonMastery
{
	@Instance(ModInfo.MODID)
	public static DungeonMastery instance;

	@SidedProxy(clientSide = "dungeonmastery.proxy.ClientProxy", serverSide = "dungeonmastery.proxy.CommonProxy")     
	public static CommonProxy proxy;
	
	public static ItemList items;
	
	public static CreativeTabs tabdungeon = new CreativeTabDungeon(CreativeTabs.getNextID(), "dungeontab");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
	
		items.Init();
		
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) 
	{
		
		if(event.getSide() == Side.CLIENT)
		{
		    	RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		    		
		    	renderItem.getItemModelMesher().register(ItemList.itemDungeonBook, 0, new ModelResourceLocation(ModInfo.MODID + ":" + ((ItemDungeonBook) ItemList.itemDungeonBook).getName(), "inventory"));
		}
		

		new GuiHandler();
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{

	}
	
	@EventHandler
	public void ServerStart(FMLServerStartingEvent event)
	{

	}
}
