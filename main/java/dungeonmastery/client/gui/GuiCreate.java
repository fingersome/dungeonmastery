package dungeonmastery.client.gui;

import net.minecraft.client.Minecraft;
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
	
	//holds race & class strings for display
	public String chosenRace;
	public String chosenClass;
	public boolean firstScreen = true;
	public boolean isCharacter;
	
	//holds starting value for skills
	public int attStr;
	public int attDex;
	public int attCon;
	public int attInt;
	public int attWis;
	public int attCha;
	
	//holds total pool of attribute points (or the number left after spending)
	public int attPool = 72 - (attStr + attDex + attCon + attInt + attWis + attCha);
	
	//converts pool total to string for display
	public String stringPool = String.valueOf(attPool);
	
	//converts attribute totals to string for display
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
		
		buttonList.add(new GuiButton(0, guiLeft + 26, guiTop + 50, 120, 20, "Create a Character"));
		
		GuiButton dmButton = new GuiButton(1, guiLeft + 26, guiTop + 80, 120, 20, "Manage a Campaign");
		//dmButton.enabled = false;
		buttonList.add(dmButton);
		
	}
	
	//page 2 of gui
	public void initGui2()
	{
		super.initGui();
		firstScreen = false;
		
		buttonList.clear();
		
		buttonList.add(new GuiButton(2, guiLeft + 48, guiTop + 10, 80, 20, "Dragonborn"));
		buttonList.add(new GuiButton(3, guiLeft + 48, guiTop + 30, 80, 20, "Dwarf"));
		buttonList.add(new GuiButton(4, guiLeft + 48, guiTop + 50, 80, 20, "Eladrin"));
		buttonList.add(new GuiButton(5, guiLeft + 48, guiTop + 70, 80, 20, "Elf"));
		buttonList.add(new GuiButton(6, guiLeft + 48, guiTop + 90, 80, 20, "Half-elf"));
		buttonList.add(new GuiButton(7, guiLeft + 48, guiTop + 110, 80, 20, "Halfling"));
		buttonList.add(new GuiButton(8, guiLeft + 48, guiTop + 130, 80, 20, "Human"));
		buttonList.add(new GuiButton(9, guiLeft + 48, guiTop + 150, 80, 20, "Tiefling"));
		
	}
	
	//page 3 of gui
	public void initGui3()
	{
		super.initGui();
		
		buttonList.clear();
		
		buttonList.add(new GuiButton(10, guiLeft + 48, guiTop + 10, 80, 20, "Cleric"));
		buttonList.add(new GuiButton(11, guiLeft + 48, guiTop + 30, 80, 20, "Fighter"));
		buttonList.add(new GuiButton(12, guiLeft + 48, guiTop + 50, 80, 20, "Paladin"));
		buttonList.add(new GuiButton(13, guiLeft + 48, guiTop + 70, 80, 20, "Ranger"));
		buttonList.add(new GuiButton(14, guiLeft + 48, guiTop + 90, 80, 20, "Rogue"));
		buttonList.add(new GuiButton(15, guiLeft + 48, guiTop + 110, 80, 20, "Warlock"));
		buttonList.add(new GuiButton(16, guiLeft + 48, guiTop + 130, 80, 20, "Warlord"));
		buttonList.add(new GuiButton(17, guiLeft + 48, guiTop + 150, 80, 20, "Wizard"));

		buttonList.add(new GuiButton(18, guiLeft + 12, guiTop + 170, 20, 20, "<"));
		
	}
	
	
	//page 4 of gui
	public void initGui4()
	{
		super.initGui();
		buttonList.clear();
		
		buttonList.add(new GuiButton(19, guiLeft + 90, guiTop + 10, 20, 20, "+"));
		buttonList.add(new GuiButton(20, guiLeft + 60, guiTop + 10, 20, 20, "-"));
		buttonList.add(new GuiButton(21, guiLeft + 90, guiTop + 35, 20, 20, "+"));
		buttonList.add(new GuiButton(22, guiLeft + 60, guiTop + 35, 20, 20, "-"));
		buttonList.add(new GuiButton(23, guiLeft + 90, guiTop + 60, 20, 20, "+"));
		buttonList.add(new GuiButton(24, guiLeft + 60, guiTop + 60, 20, 20, "-"));
		buttonList.add(new GuiButton(25, guiLeft + 90, guiTop + 85, 20, 20, "+"));
		buttonList.add(new GuiButton(26, guiLeft + 60, guiTop + 85, 20, 20, "-"));
		buttonList.add(new GuiButton(27, guiLeft + 90, guiTop + 110, 20, 20, "+"));
		buttonList.add(new GuiButton(28, guiLeft + 60, guiTop + 110, 20, 20, "-"));
		buttonList.add(new GuiButton(29, guiLeft + 90, guiTop + 135, 20, 20, "+"));
		buttonList.add(new GuiButton(30, guiLeft + 60, guiTop + 135, 20, 20, "-"));

		buttonList.add(new GuiButton(31, guiLeft + 12, guiTop + 170, 20, 20, "<"));
		buttonList.add(new GuiButton(32, guiLeft + 140, guiTop + 170, 20, 20, ">"));
		
	}
	
	//page 5 of gui
	public void initGui5()
	{
		super.initGui();
		buttonList.clear();

		buttonList.add(new GuiButton(33, guiLeft + 12, guiTop + 170, 60, 20, "Reset"));
		buttonList.add(new GuiButton(34, guiLeft + 100, guiTop + 170, 60, 20, "Play"));
		
	}
	
	EntityPlayer player;
	
	
	@Override
	protected void actionPerformed(GuiButton button)
	{
		
		
		switch(button.id)
		{
			case 0:	initGui2();
					isCharacter = true;
					break;
			case 1:	Minecraft.getMinecraft().displayGuiScreen(null);
					break;
			case 2: chosenRace = "Dragonborn";
					initGui3();	
					break;
			case 3: chosenRace = "Dwarf";
					initGui3();	
					break;
			case 4: chosenRace = "Eladrin";
					initGui3();	
					break;
			case 5: chosenRace = "Elf";
					initGui3();	
					break;
			case 6: chosenRace = "Half-elf";
					initGui3();	
					break;
			case 7: chosenRace = "Halfling";
					initGui3();	
					break;
			case 8: chosenRace = "Human";
					initGui3();	
					break;
			case 9: chosenRace = "Tiefling";
					initGui3();	
					break;
					
			case 10: chosenClass = "Cleric";
					initGui4();
					break;					
			case 11: chosenClass = "Fighter";
					initGui4();
					break;					
			case 12:chosenClass = "Paladin";
					initGui4();
					break;					
			case 13:chosenClass = "Ranger";
					initGui4();
					break;					
			case 14:chosenClass = "Rogue";
					initGui4();
					break;					
			case 15:chosenClass = "Warlock";
					initGui4();					
					break;					
			case 16:chosenClass = "Warlord";
					initGui4();
					break;					
			case 17:chosenClass = "Wizard";
					initGui4();
					break;
			case 18:initGui2();
					chosenRace = "";
					break;	
					
			case 19:System.out.println("str up");
					break;					
			case 20:System.out.println("str down");
					break;
			case 21:System.out.println("dex up");
					break;	
			case 22:System.out.println("dex down");
					break;		
			case 23:System.out.println("con up");
					break;				
			case 24:System.out.println("con down");
					break;		
			case 25:System.out.println("int up");
					break;							
			case 26:System.out.println("int down");
					break;			
			case 27:System.out.println("wis up");
					break;					
			case 28:System.out.println("wis down");
					break;
			case 29:System.out.println("cha up");
					break;					
			case 30:System.out.println("cha down");
					break;
					
			case 31:initGui3();
					chosenClass = "";
					break;	
			case 32:initGui5();
					break;		
					
			case 33:initGui2();
					chosenRace = "";
					chosenClass = "";
					attStr = 10;
					attDex = 10;
					attCon = 10;
					attInt = 10;
					attWis = 10;
					attCha = 10;
					
					break;	
			case 34: ;
					break;	
					
			default: ;
		}		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		
			if(firstScreen == true)
			{
			fontRendererObj.drawString("Do you want to:", 48, 5, 0x000000);
			}
			else
			{
			if(isCharacter == true)
			{
			fontRendererObj.drawString("Create a Character", 40, -10, 0x000000);
			}
			
			fontRendererObj.drawString("Race:", 200, -10, 0x505050);
			fontRendererObj.drawString(chosenRace, 235, -10, 0xffffff);
			
			fontRendererObj.drawString("Class:", 200, 10, 0x505050);
			fontRendererObj.drawString(chosenClass, 235, 10, 0xffffff);

			fontRendererObj.drawString("Points:", -70, 30, 0x505050);
			fontRendererObj.drawString(stringPool, -30, 30, 0xffffff);
			
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