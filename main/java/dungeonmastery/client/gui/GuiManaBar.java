package dungeonmastery.client.gui;

import org.lwjgl.opengl.GL11;

import dungeonmastery.entity.ExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiManaBar extends Gui
{
private Minecraft mc;
/* (my added notes:)
ResourceLocation takes 2 arguments: your mod id and the path to your texture file, starting from the folder 'textures/' from '/src/minecraft/assets/yourmodid/', or you can write it all as a single argument.

The texture file must be 256x256 (or multiples thereof)

If you want a texture to test out the tutorial with, I've uploaded the mana_bar.png to my github page:
https://github.com/coolAlias/Forge_Tutorials/tree/master/textures/gui
*/
private static final ResourceLocation texturepath = new ResourceLocation("dungeonmastery", "textures/gui/guiOverlay.png");

public GuiManaBar(Minecraft mc)
{
super();
// We need this to invoke the render engine.
this.mc = mc;
}

//
// This event is called by GuiIngameForge during each frame by
// GuiIngameForge.pre() and GuiIngameForce.post().
//
@SubscribeEvent(priority = EventPriority.NORMAL)
public void onRenderExperienceBar(RenderGameOverlayEvent event)
{
	
// We draw after the ExperienceBar has drawn. The event raised by GuiIngameForge.pre()
// will return true from isCancelable. If you call event.setCanceled(true) in
// that case, the portion of rendering which this event represents will be canceled.
// We want to draw *after* the experience bar is drawn, so we make sure isCancelable() returns
// false and that the eventType represents the ExperienceBar event.
	if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
	{
		return;
	}


/** Start of my tutorial */

// Get our extended player properties and assign it locally so we can easily access it
ExtendedPlayer props = ExtendedPlayer.get(this.mc.thePlayer);

// If for some reason these properties don't exist (perhaps in multiplayer?)
// or the player doesn't have mana, return. Note that I added a new method
// 'getMaxMana()' to ExtendedPlayer for this purpose
if (props == null || props.getMaxMana() == 0)
{
return;
}

// Starting position for the mana bar - 2 pixels from the top left corner.
int xPos = event.resolution.getScaledWidth() / 2;
int yPos = event.resolution.getScaledHeight() - 49;

// Be sure to offset based on your texture size or your texture will not be truly centered:
// int xPos = (event.resolution.getScaledWidth() + textureWidth) / 2;
// int yPos = (event.resolution.getScaledHeight() + textureHeight) / 2;

// setting all color values to 1.0F will render the texture as it looks in your texture file
GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

// Somewhere in Minecraft vanilla code it says to do this because of a lighting bug
GL11.glDisable(GL11.GL_LIGHTING);

// Bind your texture to the render engine
this.mc.getTextureManager().bindTexture(texturepath);

/*
The parameters for drawTexturedModalRect are as follows:

drawTexturedModalRect(int x, int y, int u, int v, int width, int height);

x and y are the on-screen position at which to render.
u and v are the coordinates of the most upper-left pixel in your texture file from which to start drawing.
width and height are how many pixels to render from the start point (u, v)
*/
// First draw the background layer. In my texture file, it starts at the upper-
// left corner (x=0, y=0), ends at 50 pixels (so it's 51 pixels long) and is 4 pixels thick (y value)
this.drawTexturedModalRect(xPos - 91 , yPos, 0, 0, 182, 5);
// Then draw the foreground; it's located just below the background in my
// texture file, so it starts at x=0, y=4, is only 2 pixels thick and 49 length
// Why y=4 and not y=5? Y starts at 0, so 0,1,2,3 = 4 pixels for the background

// However, we want the length to be based on current mana, so we need a new variable:
int manabarwidth = (int)(((float) props.getCurrentMana() / props.getMaxMana()) * 49);
// Now we can draw our mana bar at yPos+1 so it centers in the background:
this.drawTexturedModalRect(xPos - 91,  yPos, 0, 5, manabarwidth, 5);
}
}