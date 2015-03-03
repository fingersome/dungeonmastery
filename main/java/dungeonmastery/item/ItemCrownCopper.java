package dungeonmastery.item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemCrownCopper extends Item
{
	private final String name = ItemInfo.ITEM_CROWN_COPPER_UNLOCALIZED;
	public static EntityPlayer player;

	
	public ItemCrownCopper()
	{
		GameRegistry.registerItem(this, name);
		this.setMaxStackSize(50);
	}
	
	public String getName()
	{
		return name;
	}
}