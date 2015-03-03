package dungeonmastery.item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemCoinCopper extends Item
{
	private final String name = ItemInfo.ITEM_COIN_COPPER_UNLOCALIZED;
	public static EntityPlayer player;

	
	public ItemCoinCopper()
	{
		GameRegistry.registerItem(this, name);
		this.setMaxStackSize(50);
	}
	
	public String getName()
	{
		return name;
	}
}