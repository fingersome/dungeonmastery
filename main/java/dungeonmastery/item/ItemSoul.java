package dungeonmastery.item;

import dungeonmastery.DungeonMastery;
import dungeonmastery.ModInfo;
import dungeonmastery.entity.ExtendedPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
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
		int cost = 1;
	
		// Here we'll use the method we made to see if the player has enough slots to do something
		// We'll print something to the console for debugging, but I'm sure you'll find a much
		// better action to perform.
			if (props.consumeLesser(cost))
			{
				System.out.println("[SLOT TEST ITEM] Player had enough slots. I CAST MAGIC MISSILE!");
				player.addChatComponentMessage(new ChatComponentText("I CAST MAGIC MISSILE"));
			}
			else
			{
				System.out.println("[SLOT TEST ITEM] Player needs " + cost + " slots. Player has " + props.getCurrentLesser() + " slots.");
				player.addChatComponentMessage(new ChatComponentText("I CAST- oh i'm out of spell slots..."));
				props.replenishLesser();
			}
		}
		return itemstack;
	}
}
