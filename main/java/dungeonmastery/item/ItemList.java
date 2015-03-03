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
	public static Item itemSoul;

	public static Item itemCoinCopper;
	public static Item itemCoinSilver;
	public static Item itemCoinGold;

	public static Item itemCrownCopper;
	public static Item itemCrownSilver;
	public static Item itemCrownGold;
	
	
	public static void Init()
	{
		//INITIALISE ITEMS
		itemDungeonBook = new ItemDungeonBook().setUnlocalizedName(ModInfo.MODID + "." + ItemInfo.ITEM_DUNGEON_BOOK_UNLOCALIZED).setCreativeTab(DungeonMastery.tabdungeon);
		itemSoul = new ItemSoul().setUnlocalizedName(ModInfo.MODID + "." + ItemInfo.ITEM_SOUL_UNLOCALIZED).setCreativeTab(DungeonMastery.tabdungeon);
		
		itemCoinCopper = new ItemCoinCopper().setUnlocalizedName(ModInfo.MODID + "." + ItemInfo.ITEM_COIN_COPPER_UNLOCALIZED).setCreativeTab(DungeonMastery.tabdungeon);
		itemCoinSilver = new ItemCoinSilver().setUnlocalizedName(ModInfo.MODID + "." + ItemInfo.ITEM_COIN_SILVER_UNLOCALIZED).setCreativeTab(DungeonMastery.tabdungeon);
		itemCoinGold = new ItemCoinGold().setUnlocalizedName(ModInfo.MODID + "." + ItemInfo.ITEM_COIN_GOLD_UNLOCALIZED).setCreativeTab(DungeonMastery.tabdungeon);
		
		itemCrownCopper = new ItemCrownCopper().setUnlocalizedName(ModInfo.MODID + "." + ItemInfo.ITEM_CROWN_COPPER_UNLOCALIZED).setCreativeTab(DungeonMastery.tabdungeon);
		itemCrownSilver = new ItemCrownSilver().setUnlocalizedName(ModInfo.MODID + "." + ItemInfo.ITEM_CROWN_SILVER_UNLOCALIZED).setCreativeTab(DungeonMastery.tabdungeon);
		itemCrownGold = new ItemCrownGold().setUnlocalizedName(ModInfo.MODID + "." + ItemInfo.ITEM_CROWN_GOLD_UNLOCALIZED).setCreativeTab(DungeonMastery.tabdungeon);
		
	}
	
}
