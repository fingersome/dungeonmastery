package dungeonmastery.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import dungeonmastery.ModInfo;
import dungeonmastery.container.ContainerDungeonBook;


public class GuiDungeonBook extends GuiContainer
{
	private int xSize = 256;
	private int ySize = 256;
	
	private ResourceLocation texture = new ResourceLocation(ModInfo.MODID + ":" + "textures/gui/guiPage.png");
	
	
	public GuiDungeonBook(InventoryPlayer invPlayer, World world, int x, int y, int z) 
	{
		super(new ContainerDungeonBook(invPlayer, world, x, y, z));
	}


	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		this.fontRendererObj.drawString("Create a Character", 10, 5, 0x990000);
	}
	
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1,int var2, int var3) 
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
		
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		
		this.drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
	}

	
}