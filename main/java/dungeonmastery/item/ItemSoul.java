package dungeonmastery.item;

import dungeonmastery.DungeonMastery;
import dungeonmastery.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemSoul extends Item
{
	private final String name = ItemInfo.ITEM_SOUL_UNLOCALIZED;
	public static EntityPlayer player;

	
	public ItemSoul()
	{
		GameRegistry.registerItem(this, name);
		this.setMaxStackSize(1);
	}
	
	public String getName()
	{
		return name;
	}
	
	
}