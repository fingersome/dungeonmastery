package dungeonmastery.command;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class ChatHandler 
{

	public static void sendToPlayer(String message, EntityPlayer player)
	{
		if(message.length() > 0)
		{
			player.addChatMessage(new ChatComponentTranslation(message));
		}
	}
	
	public static void sendToAll(String message, World world) 
	{
		List<Entity> l = world.getLoadedEntityList();
		for (Entity entity : l) 
		{
			if (entity instanceof EntityPlayer) 
			{
				((EntityPlayer) entity).addChatMessage(new ChatComponentTranslation(message));
			}
		}
	}
	
}