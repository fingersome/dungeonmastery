package dungeonmastery.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import dungeonmastery.DungeonMastery;
import dungeonmastery.entity.ExtendedPlayer;

public class DMEventHandler
{
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) 
	{
		if (event.entity instanceof EntityPlayer) 
		{
			if (ExtendedPlayer.get((EntityPlayer) event.entity) == null) 
			{
				DungeonMastery.logger.info("Registering extended properties for player");
				ExtendedPlayer.register((EntityPlayer) event.entity);
			}
		}
	}
}