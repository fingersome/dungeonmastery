package dungeonmastery.inventory;

import dungeonmastery.item.ItemSoul;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IChatComponent;

 public class InventoryCharacter implements IInventory
{
/** The name your custom inventory will display in the GUI, possibly just "Inventory" */
private final String name = "Custom Inventory";

/** The key used to store and retrieve the inventory from NBT */
private final String tagName = "CustomInvTag";

/** Define the inventory size here for easy reference */
// This is also the place to define which slot is which if you have different types,
// for example SLOT_SHIELD = 0, SLOT_AMULET = 1;
public static final int INV_SIZE = 2;

/** Inventory's size must be same as number of slots you add to the Container class */
private ItemStack[] inventory = new ItemStack[INV_SIZE];

public InventoryCharacter()
{
// don't need anything here!
}

@Override
public int getSizeInventory()
{
return inventory.length;
}

@Override
public ItemStack getStackInSlot(int slot)
{
return inventory[slot];
}

@Override
public ItemStack decrStackSize(int slot, int amount)
{
ItemStack stack = getStackInSlot(slot);
if (stack != null)
{
if (stack.stackSize > amount)
{
stack = stack.splitStack(amount);
if (stack.stackSize == 0)
{
setInventorySlotContents(slot, null);
}
}
else
{
setInventorySlotContents(slot, null);
}

this.markDirty();
}
return stack;
}

@Override
public ItemStack getStackInSlotOnClosing(int slot)
{
ItemStack stack = getStackInSlot(slot);
if (stack != null)
{
setInventorySlotContents(slot, null);
}
return stack;
}

@Override
public void setInventorySlotContents(int slot, ItemStack itemstack)
{
this.inventory[slot] = itemstack;

if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
{
itemstack.stackSize = this.getInventoryStackLimit();
}

this.markDirty();
}

@Override
public String getName() 
{
	return null;
}

/**
* Our custom slots are similar to armor - only one item per slot
*/
@Override
public int getInventoryStackLimit()
{
return 1;
}



@Override
public boolean isUseableByPlayer(EntityPlayer entityplayer)
{
return true;
}



/**
* This method doesn't seem to do what it claims to do, as
* items can still be left-clicked and placed in the inventory
* even when this returns false
*/
@Override
public boolean isItemValidForSlot(int slot, ItemStack itemstack)
{
// If you have different kinds of slots, then check them here:
// if (slot == SLOT_SHIELD && itemstack.getItem() instanceof ItemShield) return true;

// For now, only ItemUseMana items can be stored in these slots
return itemstack.getItem() instanceof ItemSoul;
}

public void writeToNBT(NBTTagCompound compound)
{
NBTTagList items = new NBTTagList();

for (int i = 0; i < getSizeInventory(); ++i)
{
if (getStackInSlot(i) != null)
{
NBTTagCompound item = new NBTTagCompound();
item.setByte("Slot", (byte) i);
getStackInSlot(i).writeToNBT(item);
items.appendTag(item);
}
}

// We're storing our items in a custom tag list using our 'tagName' from above
// to prevent potential conflicts
compound.setTag(tagName, items);
}

public void readFromNBT(NBTTagCompound compound)
{
	NBTTagList items = compound.getTagList(tagName, 0);
	for (int i = 0; i < items.tagCount(); ++i) 
	{
		NBTTagCompound item = (NBTTagCompound) items.getCompoundTagAt(i);
		byte slot = item.getByte("Slot");
		if (slot >= 0 && slot < getSizeInventory()) 
		{
			inventory[slot] = ItemStack.loadItemStackFromNBT(item);
		}
	}
}

@Override
public boolean hasCustomName() 
{
	return false;
}

@Override
public IChatComponent getDisplayName() 
{
	return null;
}

@Override
public void markDirty() 
{
	{
		for (int i = 0; i < this.getSizeInventory(); ++i)
		{
		if (this.getStackInSlot(i) != null && this.getStackInSlot(i).stackSize == 0)
		this.setInventorySlotContents(i, null);
		}
	}
}

@Override
public void openInventory(EntityPlayer player) 
{
	
}

@Override
public void closeInventory(EntityPlayer player) 
{
	
}

@Override
public int getField(int id) 
{
	return 0;
}

@Override
public void setField(int id, int value) 
{
	
}

@Override
public int getFieldCount() 
{
	return 0;
}

@Override
public void clear() 
{
	
}
}