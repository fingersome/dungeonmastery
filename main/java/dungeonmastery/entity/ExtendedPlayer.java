package dungeonmastery.entity;

import dungeonmastery.inventory.InventoryCharacter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties
{

public final InventoryCharacter inventory = new InventoryCharacter();
	
public final static String CHAR_PROPS = "ExtendedPlayer";
private final EntityPlayer player;
private int currentLesser, maxLesser;

public static final int SSLOT_WATCHER = 20;

public ExtendedPlayer(EntityPlayer player)
{
this.player = player;
this.maxLesser = 4;
this.player.getDataWatcher().addObject(SSLOT_WATCHER, this.maxLesser);


}

/**
* Used to register these extended properties for the player during EntityConstructing event
* This method is for convenience only; it will make your code look nicer
*/
public static final void register(EntityPlayer player)
{
player.registerExtendedProperties(ExtendedPlayer.CHAR_PROPS, new ExtendedPlayer(player));
}

/**
* Returns ExtendedPlayer properties for player
* This method is for convenience only; it will make your code look nicer
*/
public static final ExtendedPlayer get(EntityPlayer player)
{
return (ExtendedPlayer) player.getExtendedProperties(CHAR_PROPS);
}

@Override
public void saveNBTData(NBTTagCompound compound)
{
NBTTagCompound properties = new NBTTagCompound();

inventory.writeToNBT(properties);
properties.setInteger("CurrentLesser", this.player.getDataWatcher().getWatchableObjectInt(SSLOT_WATCHER));
properties.setInteger("MaxLesser", this.maxLesser);

compound.setTag(CHAR_PROPS, properties);
}

@Override
public void loadNBTData(NBTTagCompound compound)
{
NBTTagCompound properties = (NBTTagCompound) compound.getTag(CHAR_PROPS);
inventory.readFromNBT(properties);
this.player.getDataWatcher().updateObject(SSLOT_WATCHER, properties.getInteger("CurrentMana"));
this.maxLesser = properties.getInteger("MaxLesser");

System.out.println("[DM PROPS] Spell Slots from NBT: " + this.currentLesser + "/" + this.maxLesser);
}

@Override
public void init(Entity entity, World world) {}


/**
* Returns true if the amount of spell slots was consumed or false
* if the player's current spell slots were insufficient
*/
public final boolean consumeLesser(int amount)
{
// This variable makes it easier to write the rest of the method
int mana = this.player.getDataWatcher().getWatchableObjectInt(SSLOT_WATCHER);

boolean sufficient = amount <= mana;
mana -= (amount < mana ? amount : mana);

// Update the data watcher object with the new value
this.player.getDataWatcher().updateObject(SSLOT_WATCHER, mana);

return sufficient;
}


public final void replenishLesser()
{
this.player.getDataWatcher().updateObject(SSLOT_WATCHER, this.maxLesser);
}


public final int getCurrentLesser()
{
return this.player.getDataWatcher().getWatchableObjectInt(SSLOT_WATCHER);
}


public final void setCurrentLesser(int amount)
{
this.player.getDataWatcher().updateObject(SSLOT_WATCHER, (amount < this.maxLesser ? amount : this.maxLesser));
}


public final int getMaxLesser()
{
	return maxLesser;
}

public void replenishSlots() 
{
	replenishLesser();	
	//replenishMinor();
	//replenishStandard();
	//replenishMajor();
	//replenishDaily();
}

}