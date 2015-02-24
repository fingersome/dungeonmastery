package dungeonmastery.item;

import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import dungeonmastery.DungeonMastery;
import dungeonmastery.ModInfo;

public class ItemList
{
	//DECLARE ITEMS
	
	public static Item itemDungeonBook;
	
	
	public static void Init()
	{
		//INITIALISE ITEMS
		itemDungeonBook = new ItemDungeonBook().setUnlocalizedName(ModInfo.MODID + "." + ItemInfo.ITEM_DUNGEON_BOOK_UNLOCALIZED).setCreativeTab(DungeonMastery.tabdungeon);
		
	}
	
	public void renderTextures() 
	{
	
	}
	
	public static void RegisterRecipes()
	{
		
	}

	
	
}
