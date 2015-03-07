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
	public int page = 0;
	public String chosenRace;
	public String chosenClass;
	
	//holds starting value for skills
	public int attStr = 10;
	public int attDex = 10;
	public int attCon = 10;
	public int attInt = 10;
	public int attWis = 10;
	public int attCha = 10;
	
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
		
		buttonList.add(new GuiButton(0, guiLeft + 28, guiTop, 120, 20, "Create a Character"));
		
	}
	
	//page 1 of gui
	public void initGui1()
	{
		super.initGui();
		
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
	
	//page 2 of gui
	public void initGui2()
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
	
	
	//page 3 of gui
	public void initGui3()
	{
		super.initGui();
		buttonList.clear();
		
		buttonList.add(new GuiButton(19, guiLeft + 130, guiTop + 10, 20, 20, "+"));
		buttonList.add(new GuiButton(20, guiLeft + 100, guiTop + 10, 20, 20, "-"));
		buttonList.add(new GuiButton(21, guiLeft + 130, guiTop + 35, 20, 20, "+"));
		buttonList.add(new GuiButton(22, guiLeft + 100, guiTop + 35, 20, 20, "-"));
		buttonList.add(new GuiButton(23, guiLeft + 130, guiTop + 60, 20, 20, "+"));
		buttonList.add(new GuiButton(24, guiLeft + 100, guiTop + 60, 20, 20, "-"));
		buttonList.add(new GuiButton(25, guiLeft + 130, guiTop + 85, 20, 20, "+"));
		buttonList.add(new GuiButton(26, guiLeft + 100, guiTop + 85, 20, 20, "-"));
		buttonList.add(new GuiButton(27, guiLeft + 130, guiTop + 110, 20, 20, "+"));
		buttonList.add(new GuiButton(28, guiLeft + 100, guiTop + 110, 20, 20, "-"));
		buttonList.add(new GuiButton(29, guiLeft + 130, guiTop + 135, 20, 20, "+"));
		buttonList.add(new GuiButton(30, guiLeft + 100, guiTop + 135, 20, 20, "-"));

		buttonList.add(new GuiButton(31, guiLeft + 12, guiTop + 170, 20, 20, "<"));
		buttonList.add(new GuiButton(32, guiLeft + 140, guiTop + 170, 20, 20, ">"));
		
	}
	
	//page 4 of gui
	public void initGui4()
	{
		super.initGui();
		buttonList.clear();
		
		buttonList.add(new GuiButton(33, guiLeft + 90, guiTop + 10, 80, 20, "Acrobatics"));
		buttonList.add(new GuiButton(34, guiLeft + 90, guiTop + 35, 80, 20, "Arcana"));
		buttonList.add(new GuiButton(35, guiLeft + 90, guiTop + 60, 80, 20, "Atheletics"));
		buttonList.add(new GuiButton(36, guiLeft + 90, guiTop + 85, 80, 20, "Bluff"));
		buttonList.add(new GuiButton(37, guiLeft + 90, guiTop + 110, 80, 20, "Diplomacy"));
		buttonList.add(new GuiButton(38, guiLeft + 90, guiTop + 135, 80, 20, "Dungeoneering"));
		buttonList.add(new GuiButton(39, guiLeft + 90, guiTop + 135, 80, 20, "Endurance"));
		buttonList.add(new GuiButton(40, guiLeft + 90, guiTop + 135, 80, 20, "Heal"));
		buttonList.add(new GuiButton(41, guiLeft + 90, guiTop + 135, 80, 20, "History"));
		buttonList.add(new GuiButton(42, guiLeft + 90, guiTop + 135, 80, 20, "Insight"));
		buttonList.add(new GuiButton(43, guiLeft + 90, guiTop + 135, 80, 20, "Intimidate"));
		buttonList.add(new GuiButton(44, guiLeft + 90, guiTop + 135, 80, 20, "Nature"));
		buttonList.add(new GuiButton(45, guiLeft + 90, guiTop + 135, 80, 20, "Perception"));
		buttonList.add(new GuiButton(46, guiLeft + 90, guiTop + 135, 80, 20, "Religion"));
		buttonList.add(new GuiButton(47, guiLeft + 90, guiTop + 135, 80, 20, "Stealth"));
		buttonList.add(new GuiButton(48, guiLeft + 90, guiTop + 135, 80, 20, "Streetwise"));
		buttonList.add(new GuiButton(49, guiLeft + 90, guiTop + 135, 80, 20, "Thievery"));

		buttonList.add(new GuiButton(50, guiLeft + 12, guiTop + 170, 20, 20, "<"));
		buttonList.add(new GuiButton(51, guiLeft + 140, guiTop + 170, 20, 20, ">"));
		
	}
	
	//page 5 of gui
	public void initGui5()
	{
		super.initGui();
		buttonList.clear();

		buttonList.add(new GuiButton(52, guiLeft + 12, guiTop + 170, 60, 20, "Reset"));
		buttonList.add(new GuiButton(53, guiLeft + 100, guiTop + 170, 60, 20, "Play"));
		
	}
	
	EntityPlayer player;
	
	
	@Override
	protected void actionPerformed(GuiButton button)
	{
		
		
		switch(button.id)
		{
			case 0:	page = 1;
					initGui1();
					break;
					
			case 1:	;
					break;
					
					
			case 2: chosenRace = "Dragonborn";
					page = 2;
					initGui2();	
					break;
			case 3: chosenRace = "Dwarf";
					page = 2;
					initGui2();	
					break;
			case 4: chosenRace = "Eladrin";
					page = 2;
					initGui2();	
					break;
			case 5: chosenRace = "Elf";
					page = 2;
					initGui2();	
					break;
			case 6: chosenRace = "Half-elf";
					page = 2;
					initGui2();	
					break;
			case 7: chosenRace = "Halfling";
					page = 2;
					initGui2();	
					break;
			case 8: chosenRace = "Human";
					page = 2;
					initGui2();	
					break;
			case 9: chosenRace = "Tiefling";
					page = 2;
					initGui2();			
					break;
					
			case 10: chosenClass = "Cleric";
					page = 3;
					initGui3();
					break;					
			case 11: chosenClass = "Fighter";
					page = 3;
					initGui3();
					break;					
			case 12:chosenClass = "Paladin";
					page = 3;
					initGui3();
					break;					
			case 13:chosenClass = "Ranger";
					page = 3;
					initGui3();
					break;					
			case 14:chosenClass = "Rogue";
					page = 3;
					initGui3();
					break;					
			case 15:chosenClass = "Warlock";
					page = 3;
					initGui3();	
					break;					
			case 16:chosenClass = "Warlord";
					page = 3;
					initGui3();
					break;					
			case 17:chosenClass = "Wizard";
					page = 3;
					initGui3();
					break;
					
			case 18:chosenRace = "";
					page = 1;
					initGui1();
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
					
			case 31:chosenClass = "";
					page = 2;
					initGui2();
					break;	
			case 32:page = 5;
					initGui5();
					break;		
					
			case 33:System.out.println("acro trained");
					break;
			case 34:System.out.println("arca trained");
					break;
			case 35:System.out.println("athe trained");
					break;
			case 36:System.out.println("bluf trained");
					break;
			case 37:System.out.println("dipl trained");
					break;
			case 38:System.out.println("dung trained");
					break;
			case 39:System.out.println("endu trained");
					break;
			case 40:System.out.println("heal trained");
					break;
			case 41:System.out.println("hist trained");
					break;
			case 42:System.out.println("insi trained");
					break;
			case 43:System.out.println("inti trained");
					break;
			case 44:System.out.println("natu trained");
					break;
			case 45:System.out.println("perc trained");
					break;
			case 46:System.out.println("reli trained");
					break;
			case 47:System.out.println("stea trained");
					break;
			case 48:System.out.println("stre trained");
					break;
			case 49:System.out.println("thie trained");
					break;
			
			case 50:page = 4;
					initGui4();
					break;
			case 51:page = 5;
					initGui5();
					break;
			
					
			case 52:page = 1;
					initGui1();
					chosenRace = "";
					chosenClass = "";
					attStr = 10;
					attDex = 10;
					attCon = 10;
					attInt = 10;
					attWis = 10;
					attCha = 10;
					
					break;	
			case 53:;
					break;	
					
			default:;
		}		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		if(page == 1)
		{
			fontRendererObj.drawString("Pick a Race:", 20, -10, 0x000000);
		drawTextPage1();
		}
			else if (page == 2)
			{
				fontRendererObj.drawString("Pick a Class:", 20, -10, 0x000000);
			drawTextPage1();
			drawTextPage2();
			}
			else if (page == 3)
			{
				fontRendererObj.drawString("Pick your Stats:", 20, -10, 0x000000);
			drawTextPage1();
			drawTextPage2();
			drawTextPage3();
			}
		
	}
	
	
	public void drawTextPage1()
	{
	fontRendererObj.drawString("Race:", 200, -10, 0x505050);
	fontRendererObj.drawString(chosenRace, 235, -10, 0xffffff);
	}
		
	
	public void drawTextPage2()
	{
	fontRendererObj.drawString("Class:", 200, 10, 0x505050);
	fontRendererObj.drawString(chosenClass, 235, 10, 0xffffff);
	}

	public void drawTextPage3()
	{
	
	fontRendererObj.drawString("Points:", -70, 30, 0x505050);
	fontRendererObj.drawString(stringPool, -30, 30, 0xffffff);

	fontRendererObj.drawString("Strength", 20, 15, 0x940000);
	fontRendererObj.drawString("Dexterity", 20, 40, 0x127A00);
	fontRendererObj.drawString("Constitution", 20, 65, 0xB35F00);
	fontRendererObj.drawString("Intellect", 20, 90, 0x0054B5);
	fontRendererObj.drawString("Wisdom", 20, 115, 0x60008C);
	fontRendererObj.drawString("Charisma", 20, 140, 0xD9009F);
	
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