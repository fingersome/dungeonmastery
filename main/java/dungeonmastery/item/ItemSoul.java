package dungeonmastery.item;

import dungeonmastery.DungeonMastery;
import dungeonmastery.ModInfo;
import dungeonmastery.entity.ExtendedPlayer;
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
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
	if (!world.isRemote)
		{
	
		ExtendedPlayer props = ExtendedPlayer.get(player);
	
		// Here we'll use the method we made to see if the player has enough mana to do something
		// We'll print something to the console for debugging, but I'm sure you'll find a much
		// better action to perform.
		if (props.consumeMana(15))
			{
				System.out.println("[MANA ITEM] Player had enough mana. Do something awesome!");
			}
		else
			{
				System.out.println("[MANA ITEM] Player ran out of mana. Sad face.");
				props.replenishMana();
			}
		}
	return itemstack;
	}	
}