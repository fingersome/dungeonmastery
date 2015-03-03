package dungeonmastery.item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemCoinGold extends Item
{
	private final String name = ItemInfo.ITEM_COIN_GOLD_UNLOCALIZED;
	public static EntityPlayer player;

	
	public ItemCoinGold()
	{
		GameRegistry.registerItem(this, name);
		this.setMaxStackSize(50);
	}
	
	public String getName()
	{
		return name;
	}
}