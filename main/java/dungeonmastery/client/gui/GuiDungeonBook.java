package dungeonmastery.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import dungeonmastery.container.ContainerDungeonBook;


public class GuiDungeonBook extends GuiContainer
{

	private ResourceLocation texture = new ResourceLocation("dungeonmastery:textures/gui/guiDungeonBook.png");
	
	public GuiDungeonBook(InventoryPlayer invPlayer, World world, int x, int y, int z) 
	{
		super(new ContainerDungeonBook(invPlayer, world, x, y, z));
		System.out.println("GuiDungeonBook");
	}


	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j){
		this.fontRendererObj.drawString("Dungeon Book", 10, 5, 0x990000);
		System.out.println("GuiDungeonBook1");
	}
	
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1,int var2, int var3) {
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
		
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		
		this.drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
		System.out.println("GuiDungeonBook2");
	}

	
}