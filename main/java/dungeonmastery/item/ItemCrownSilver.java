package dungeonmastery.item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemCrownSilver extends Item
{
	private final String name = ItemInfo.ITEM_CROWN_SILVER_UNLOCALIZED;
	public static EntityPlayer player;

	
	public ItemCrownSilver()
	{
		GameRegistry.registerItem(this, name);
		this.setMaxStackSize(50);
	}
	
	public String getName()
	{
		return name;
	}
}