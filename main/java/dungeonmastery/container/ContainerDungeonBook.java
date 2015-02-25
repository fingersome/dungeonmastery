package dungeonmastery.container;

import dungeonmastery.tile.TileEntityDungeonBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public class ContainerDungeonBook extends Container {

	public ContainerDungeonBook(InventoryPlayer invPlayer, World world, int x,int y, int z) 
	{

	}


	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{

		return true;
	}

}
