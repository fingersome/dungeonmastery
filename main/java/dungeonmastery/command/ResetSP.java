package dungeonmastery.command;

import dungeonmastery.entity.CharacterInfo;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;

public class ResetSP extends CommandBase
{

	@Override
	public String getName() 
	{
		return "resetsp";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) 
	{
		return null;
	}

	@Override
	public void execute(ICommandSender sender, String[] args)
			throws CommandException 
	{
		EntityPlayerMP commandSender = CommandBase.getCommandSenderAsPlayer(sender);
		
		CharacterInfo.get(commandSender).replenishSlots();
		System.out.println("command sent");
	}

}
