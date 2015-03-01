package dungeonmastery.event;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import dungeonmastery.DungeonMastery;
import dungeonmastery.entity.ExtendedPlayer;
import dungeonmastery.item.ItemList;
import dungeonmastery.item.ItemSoul;

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
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) 
	{
		if (event.entity instanceof EntityPlayer) 
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			
			if (player.isPlayerFullyAsleep()) 
			{
				player.addChatMessage(new ChatComponentText("Ah, a full nights sleep and I feel rested, and ready for adventure!"));
				ExtendedPlayer.get(player).replenishSlots();
			}
		}
	}
}