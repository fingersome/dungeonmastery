package dungeonmastery.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;

public class RollDice implements ICommand
{
	private List aliases;
	public RollDice()
	{
		this.aliases = new ArrayList();
	    	this.aliases.add("roll");
	    	this.aliases.add("r");
	}
	
	@Override
	public String getName()
	{
		return "roll";
	}
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
	    return "roll (x)d(y)[+z] - rolls x dice of y size with mod z.";
	}
	
	@Override
	public List getAliases()
	{
	    return this.aliases;
	}
	
	@Override
	public void execute(ICommandSender icommandsender, String[] astring)
	{
		EntityPlayer player = null;
		if (icommandsender instanceof EntityPlayer)
		{
			player = (EntityPlayer)icommandsender;
		}
		if(astring.length == 0)
		{
			ChatHandler.sendToPlayer("Invalid Message", player);
			return;
		}
		ChatHandler.sendToAll(player.getDisplayName() + " rolled a " + getRoll(astring[0],player) + " on "+astring[0], player.getEntityWorld());
		System.out.println("Test!");
	}
	public static String getRoll(String rolltext, EntityPlayer player)
	{ 															
		String[] split = rolltext.split("d"); 					// separate number of dice from dice size
		int num = Integer.parseInt(split[0]); 					// assign number of dice to this variable
		int size = Integer.parseInt(split[1].split("\\+")[0]); 	// assign size of dice to this one
		int mod = 0; 											// default for modifier is 0
		if (rolltext.contains("+"))								// is there a mod specified?
		{ 							
		mod = Integer.parseInt(split[1].split("\\+")[1]); 		// if so, assign it to our mod variable
		}
		String result = ""; 			// set up result -- mainly because I'm tired of eclipse telling me I'm not returning anything.
		int total = 0; 					// set up total 
		int critCount = 0; 				// counter for number of crits
		for (int i=0;i<num;i++)  		//actually roll the dice
		{
			int roll = player.getRNG().nextInt(size)+1;
			total += roll;
			if (roll == size) 
			{					//did they roll max? 
				critCount++; 	// increment crit count
			}
		}
		total += mod;
		result = String.valueOf(total)+" - ("+String.valueOf(critCount)+" crits)";
		return result;
	}
	
	/**
	 * Use this to roll dice behind the scenes.
	 * dSize is the size of the dice being rolled.
	 * nDice is the number of dice to roll
	 * mod is the modifier to use
	 */
	public static int numberRoll(int dSize, int nDice, int mod)
	{
		int result = 0;
		for (int i=0;i<nDice;i++)
		{
			int roll = (int)Math.round((Math.random()*dSize)); 	//make a roll
			result += roll; 									// add the result to the total
		}
		result += mod; 											// add the modifier at the end like a smart kid.
		return result;
	}
	
	@Override
	public boolean isUsernameIndex(String[] astring, int i)
	{
		return false;
	}

	@Override
	public boolean canCommandSenderUse(ICommandSender sender) 
	{
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) 
	{
		return null;
	}
	
	@Override
	public int compareTo(Object o)
	{
		return 0;
	}
}