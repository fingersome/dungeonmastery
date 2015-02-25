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

public class ItemDungeonBook extends Item
{
	private final String name = ItemInfo.ITEM_DUNGEON_BOOK_UNLOCALIZED;
	public static EntityPlayer player;

	
	public ItemDungeonBook()
	{
		GameRegistry.registerItem(this, name);
		this.setMaxStackSize(1);
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		playerIn.openGui(ModInfo.MODID, 0, worldIn, 0, 0, 0);

        return itemStackIn;
    }
	
	
}