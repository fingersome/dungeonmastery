package dungeonmastery.entity;

import dungeonmastery.inventory.InventoryCharacter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class CharacterInfo implements IExtendedEntityProperties
{

public final InventoryCharacter inventory = new InventoryCharacter();
	
public final static String CHAR_PROPS = "CharacterInfo";
private final EntityPlayer player;

//variables to hold the character's level and current experience
public int charLevel;
public int charEXP;

//variable to hold the character's race
public String charRace[] = {};

//variable to hold the character's class
public String charClass[] = {};

//an array that holds the character's attributes (str, dex, con, int, wis, cha)
public double charAttributes[] = {0, 0, 0, 0, 0, 0};

//variables to hold the amount of points spent in each attribute
private double pointStr = charAttributes[0] - 10;
private double pointDex = charAttributes[1] - 10;
private double pointCon = charAttributes[2] - 10;
private double pointInt = charAttributes[3] - 10;
private double pointWis = charAttributes[4] - 10;
private double pointCha = charAttributes[5] - 10;

//variables to hold the modifier for each attribute, i.e half the points spent in the given attribute (rounded down)
public int modStr = (int) Math.floor(pointStr / 2);
public int modDex = (int) Math.floor(pointDex / 2);
public int modCon = (int) Math.floor(pointCon / 2);
public int modInt = (int) Math.floor(pointInt / 2);
public int modWis = (int) Math.floor(pointWis / 2);
public int modCha = (int) Math.floor(pointCha / 2);

// an array that holds the character's skills: 
// 							acro, arca, athle, 
//							bluf, dipl, dung, 
//							endu, heal, hist, 
//							insi, inti, natu, 
//							perc, reli, stea, 
//							stre, thie
public int charSkills[] = {0,0,0,
							0,0,0,
							0,0,0,
							0,0,0,
							0,0,0,
							0,0};

//variables to hold the current and maximum spells slots in each category of slot
private int currentLesser, maxLesser;
private int currentMinor, maxMinor;
private int currentSmall, maxSmall;
private int currentStandard, maxStandard;
private int currentGreater, maxGreater;
private int currentDaily, maxDaily;

public static final int SSLOT_WATCHER = 20;

public CharacterInfo(EntityPlayer player)
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
player.registerExtendedProperties(CharacterInfo.CHAR_PROPS, new CharacterInfo(player));
}

/**
* Returns ExtendedPlayer properties for player
* This method is for convenience only; it will make your code look nicer
*/
public static final CharacterInfo get(EntityPlayer player)
{
return (CharacterInfo) player.getExtendedProperties(CHAR_PROPS);
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