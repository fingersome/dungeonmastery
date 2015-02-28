package dungeonmastery.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties
{

public final static String CHAR_PROPS = "ExtendedPlayer";
private final EntityPlayer player;
private int currentLesser, maxLesser;

public ExtendedPlayer(EntityPlayer player)
{
this.player = player;
this.currentLesser = this.maxLesser = 4;
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

properties.setInteger("CurrentLesser", this.currentLesser);
properties.setInteger("MaxLesser", this.maxLesser);

compound.setTag(CHAR_PROPS, properties);
}

@Override
public void loadNBTData(NBTTagCompound compound)
{
NBTTagCompound properties = (NBTTagCompound) compound.getTag(CHAR_PROPS);

this.currentLesser = properties.getInteger("CurrentLesser");
this.maxLesser = properties.getInteger("MaxLesser");

System.out.println("[DM PROPS] Spell Slots from NBT: " + this.currentLesser + "/" + this.maxLesser);
}

@Override
public void init(Entity entity, World world) {}


/**
* Returns true if the amount of spell slots was consumed or false
* if the player's current spell slots were insufficient
*/
public boolean consumeLesser(int amount)
{
// Does the player have enough spell slots?
boolean sufficient = amount <= this.currentLesser;

// Consume the amount anyway; if it's more than the player's current spell slots,
// spell slots will be set to 0
this.currentLesser -= (amount < this.currentLesser ? amount : this.currentLesser);

// Return if the player had enough spell slots
return sufficient;
}

public void replenishLesser()
{
this.currentLesser = this.maxLesser;
}

public int getMaxLesser()
{
	return maxLesser;
}

public int getCurrentLesser()
{
	return currentLesser;
}

}