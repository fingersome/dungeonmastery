package dungeonmastery.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
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


public class GuiCreate extends GuiContainer
{
	private int xSize = 256;
	private int ySize = 256;
	
	private ResourceLocation texture = new ResourceLocation(ModInfo.MODID + ":" + "textures/gui/guiPage.png");
	
	
	public String chosenClass;
	public String chosenRace;
	
	//holds starting value for skills
	public int attStr = 10;
	public int attDex = 10;
	public int attCon = 10;
	public int attInt = 10;
	public int attWis = 10;
	public int attCha = 10;
	
	//holds total pool of attribute points
	public int attPool = 70 - (attStr + attDex + attCon + attInt + attWis + attCha);

	public String stringStr = String.valueOf(attStr);
	public String stringDex = String.valueOf(attDex);
	public String stringCon = String.valueOf(attCon);
	public String stringInt = String.valueOf(attInt);
	public String stringWis = String.valueOf(attWis);
	public String stringCha = String.valueOf(attCha);
	
	public GuiCreate(InventoryPlayer invPlayer, World world, int x, int y, int z) 
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
	
	public void initGui2()
	{
		super.initGui();
		buttonList.clear();
		
		buttonList.add(new GuiButton(8, guiLeft + 48, guiTop + 10, 80, 20, "Cleric"));
		buttonList.add(new GuiButton(9, guiLeft + 48, guiTop + 30, 80, 20, "Fighter"));
		buttonList.add(new GuiButton(10, guiLeft + 48, guiTop + 50, 80, 20, "Paladin"));
		buttonList.add(new GuiButton(11, guiLeft + 48, guiTop + 70, 80, 20, "Ranger"));
		buttonList.add(new GuiButton(12, guiLeft + 48, guiTop + 90, 80, 20, "Rogue"));
		buttonList.add(new GuiButton(13, guiLeft + 48, guiTop + 110, 80, 20, "Warlock"));
		buttonList.add(new GuiButton(14, guiLeft + 48, guiTop + 130, 80, 20, "Warlord"));
		buttonList.add(new GuiButton(15, guiLeft + 48, guiTop + 150, 80, 20, "Wizard"));

		buttonList.add(new GuiButton(16, guiLeft + 12, guiTop + 170, 20, 20, "<"));
		
	}
	
	public void initGui3()
	{
		super.initGui();
		buttonList.clear();

		buttonList.add(new GuiButton(17, guiLeft + 100, guiTop + 10, 20, 20, "+"));
		buttonList.add(new GuiButton(18, guiLeft + 60, guiTop + 10, 20, 20, "-"));
		buttonList.add(new GuiButton(19, guiLeft + 100, guiTop + 35, 20, 20, "+"));
		buttonList.add(new GuiButton(20, guiLeft + 60, guiTop + 35, 20, 20, "-"));
		buttonList.add(new GuiButton(21, guiLeft + 100, guiTop + 60, 20, 20, "+"));
		buttonList.add(new GuiButton(22, guiLeft + 60, guiTop + 60, 20, 20, "-"));
		buttonList.add(new GuiButton(23, guiLeft + 100, guiTop + 85, 20, 20, "+"));
		buttonList.add(new GuiButton(24, guiLeft + 60, guiTop + 85, 20, 20, "-"));
		buttonList.add(new GuiButton(25, guiLeft + 100, guiTop + 110, 20, 20, "+"));
		buttonList.add(new GuiButton(26, guiLeft + 60, guiTop + 110, 20, 20, "-"));
		buttonList.add(new GuiButton(27, guiLeft + 100, guiTop + 135, 20, 20, "+"));
		buttonList.add(new GuiButton(28, guiLeft + 60, guiTop + 135, 20, 20, "-"));
		
		buttonList.add(new GuiButton(29, guiLeft + 12, guiTop + 170, 20, 20, "<"));
		
	}
	
	@Override
	protected void actionPerformed(GuiButton button)
	{
		
		
		switch(button.id)
		{
			case 0: chosenRace = "Dragonborn";
					initGui2();	
					break;
			case 1: chosenRace = "Dwarf";
					initGui2();	
					break;
			case 2: chosenRace = "Eladrin";
					initGui2();	
					break;
			case 3: chosenRace = "Elf";
					initGui2();	
					break;
			case 4: chosenRace = "Half-elf";
					initGui2();	
					break;
			case 5: chosenRace = "Halfling";
					initGui2();	
					break;
			case 6: chosenRace = "Human";
					initGui2();	
					break;
			case 7: chosenRace = "Tiefling";
					initGui2();	
					break;
					
			case 8: chosenClass = "Cleric";
					initGui3();
					break;					
			case 9: chosenClass = "Fighter";
					initGui3();
					break;					
			case 10:chosenClass = "Paladin";
					initGui3();
					break;					
			case 11:chosenClass = "Ranger";
					initGui3();
					break;					
			case 12:chosenClass = "Rogue";
					initGui3();
					break;					
			case 13:chosenClass = "Warlock";
					initGui3();					
					break;					
			case 14:chosenClass = "Warlord";
					initGui3();
					break;					
			case 15:chosenClass = "Wizard";
					initGui3();
					break;
			case 16:initGui();
					break;	
					
			case 17: if(attPool > 0) 
						{attStr ++;}
					else {return;}
			
					break;					
			case 18: attStr --;
					break;					
			case 19:attDex ++;
					break;					
			case 20:attDex --;
					break;					
			case 21:attCon ++;
					break;					
			case 22:attCon --;	
					break;					
			case 23:attInt ++;
					break;					
			case 24:attInt --;
					break;			
			case 25:attWis ++;
					break;					
			case 26:attWis --;
					break;
			case 27:attCha ++;
					break;					
			case 28:attCha --;
					break;
					
			case 29:initGui2();
					break;	
			default: return;
		}		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
			fontRendererObj.drawString("Create a Character", 40, -10, 0x990000);
			
			fontRendererObj.drawString("Race:", 200, -10, 0x505050);
			fontRendererObj.drawString(chosenRace, 235, -10, 0xffffff);
			
			fontRendererObj.drawString("Class:", 200, 10, 0x505050);
			fontRendererObj.drawString(chosenClass, 235, 10, 0xffffff);

			fontRendererObj.drawString("Strength:", 200, 30, 0x505050);
			fontRendererObj.drawString(stringStr, 270, 30, 0xffffff);
			
			fontRendererObj.drawString("Dexterity:", 200, 50, 0x505050);
			fontRendererObj.drawString(stringDex, 270, 50, 0xffffff);
			
			fontRendererObj.drawString("Constitution:", 200, 70, 0x505050);
			fontRendererObj.drawString(stringCon, 270, 70, 0xffffff);

			fontRendererObj.drawString("Intellect:", 200, 90, 0x505050);
			fontRendererObj.drawString(stringInt, 270, 90, 0xffffff);

			fontRendererObj.drawString("Wisdom:", 200, 110, 0x505050);
			fontRendererObj.drawString(stringWis, 270, 110, 0xffffff);

			fontRendererObj.drawString("Charisma:", 200, 130, 0x505050);
			fontRendererObj.drawString(stringCha, 270, 130, 0xffffff);
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