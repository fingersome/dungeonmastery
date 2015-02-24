package dungeonmastery.item;

import dungeonmastery.DungeonMastery;
import dungeonmastery.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemDungeonBook extends Item
{
	private final String name = ItemInfo.ITEM_DUNGEON_BOOK_UNLOCALIZED;
	
	public ItemDungeonBook()
	{
		GameRegistry.registerItem(this, name);
	}
	
	public String getName()
	{
		return name;
	}
}