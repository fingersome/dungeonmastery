package dungeonmastery.client.gui;

import dungeonmastery.DungeonMastery;
import dungeonmastery.container.ContainerCharacterInv;
import dungeonmastery.container.ContainerDungeonBook;
import dungeonmastery.entity.CharacterInfo;
import dungeonmastery.inventory.InventoryCharacter;
import dungeonmastery.tile.TileEntityDungeonBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler 
{

	public GuiHandler() 
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(DungeonMastery.instance, this);
	}
		
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		switch(ID) 
		{
		case 0: return new ContainerDungeonBook(player.inventory, world, x, y, z);
		case 1: return new ContainerCharacterInv(player, player.inventory, CharacterInfo.get(player).inventory);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		switch(ID) 
		{
		case 0: return new GuiCreate(player.inventory, world, x, y, z);
		case 1: return new GuiCharacterInventory(player, player.inventory, CharacterInfo.get(player).inventory);
		}

		return null;
	}

}


