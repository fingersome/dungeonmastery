package dungeonmastery.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
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
	public void initGui()
	{
		super.initGui();
		buttonList.clear();
		buttonList.add(new GuiButton(0, guiLeft + 48, guiTop + 10, 80, 20, "Dragonborn"));
		buttonList.add(new GuiButton(1, guiLeft + 48, guiTop + 30, 80, 20, "Dwarf"));
		buttonList.add(new GuiButton(2, guiLeft + 48, guiTop + 50, 80, 20, "Eladrin"));
		buttonList.add(new GuiButton(3, guiLeft + 48, guiTop + 70, 80, 20, "Elf"));
		buttonList.add(new GuiButton(4, guiLeft + 48, guiTop + 90, 80, 20, "Half-elf"));
		buttonList.add(new GuiButton(5, guiLeft + 48, guiTop + 110, 80, 20, "Halfling"));
		buttonList.add(new GuiButton(6, guiLeft + 48, guiTop + 130, 80, 20, "Human"));
		buttonList.add(new GuiButton(7, guiLeft + 48, guiTop + 150, 80, 20, "Tiefling"));
	}
	
	
	protected void actionPerformed(GuiButton button, EntityPlayer player)
	{
		switch(button.id)
		{
			case 0: player.addChatComponentMessage(new ChatComponentText("dragonborn selected"));
			case 1: return;
			case 2: return;
			default: return;
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		fontRendererObj.drawString("Choose a Race", 52, -10, 0x990000);
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