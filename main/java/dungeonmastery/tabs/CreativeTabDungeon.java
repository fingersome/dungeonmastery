package dungeonmastery.tabs;

import dungeonmastery.item.ItemList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public final class CreativeTabDungeon extends CreativeTabs
{

    public CreativeTabDungeon(int id, String name)
    {
        super(id, name);
    }

	@Override
	public Item getTabIconItem() 
	{
		return ItemList.itemDungeonBook;
	}	

}
