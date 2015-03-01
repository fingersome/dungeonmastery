package dungeonmastery.tabs;

import dungeonmastery.item.ItemList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public final class CreativeTabDMCore extends CreativeTabs
{

    public CreativeTabDMCore(int id, String name)
    {
        super(id, name);
    }

	@Override
	public Item getTabIconItem() 
	{
		return ItemList.itemDungeonBook;
	}	

}
