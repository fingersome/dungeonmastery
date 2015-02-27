package dungeonmastery.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import dungeonmastery.DungeonMastery;
import dungeonmastery.client.gui.GuiManaBar;

public class ClientProxy extends CommonProxy
{
	
	private final Minecraft mc = Minecraft.getMinecraft();
	
		// can register other client-side only things here, too:
	@Override
	public void registerRenderers()
	{
			// The RenderGameOverlayEvent is in the MinecraftForge package, so we will
			// register our mana bar overlay to that event bus:
			MinecraftForge.EVENT_BUS.register(new GuiManaBar(mc));
	}

}