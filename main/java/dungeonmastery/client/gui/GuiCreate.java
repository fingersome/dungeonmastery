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

	private ResourceLocation textureblank = new ResourceLocation(ModInfo.MODID + ":" + "textures/gui/guiPage.png");
	private ResourceLocation texturelast = new ResourceLocation(ModInfo.MODID + ":" + "textures/gui/guiPageDark.png");
	
	//holds race & class strings for display
	private int page = 0;
	private String chosenRace;
	private String chosenClass;
	
	//holds values for attributes
	private int attributes[] = {10, 10, 10, 10, 10, 10};
	
	//holds total pool of attribute points (or the number left after spending)
	private int attPool = 72 - (attributes[0] + attributes[1] + attributes[2] + attributes[3] + attributes[4] + attributes[5]);
	
	//converts pool total to string for display
	private String stringPool = String.valueOf(attPool);
	
	//converts attribute totals to string for display
	private String stringStr = String.valueOf(attributes[0]);
	private String stringDex = String.valueOf(attributes[1]);
	private String stringCon = String.valueOf(attributes[2]);
	private String stringInt = String.valueOf(attributes[3]);
	private String stringWis = String.valueOf(attributes[4]);
	private String stringCha = String.valueOf(attributes[5]);
	
	//holds which skills are trained: 
	//									acrob, 	arcan, 	athel,
	//									bluff, 	diplo, 	dunge,
	//									endur, 	heal, 	histo,
	//									insig, 	intim, 	natur,
	//	 								perc, 	reli, 	stea,
	//									stre, 	thie
	
	private boolean skillTraining[] = {	false, false, false, 
										false, false, false,
										false, false, false,
										false, false, false, 
										false, false, false,
										false, false};

	//holds skill modifiers after calculation ready for sync to CharacterInfo
	private int skillMods[] = {	0,0,0,
								0,0,0,
								0,0,0,
								0,0,0,
								0,0,0,
								0,0};
	
	public GuiCreate(InventoryPlayer invPlayer, World world, int x, int y, int z) 
	{
		super(new ContainerDungeonBook(invPlayer, world, x, y, z));
	}
		
	@Override
	public void initGui()
	{
		super.initGui();	
		buttonList.clear();
		
		buttonList.add(new GuiButton(0, guiLeft + 28, guiTop - 10, 120, 20, "Create a character"));
	}
	
	//page 1 of gui
	public void initGui1()
	{
		super.initGui();
		buttonList.clear();

		buttonList.add(new GuiButton(1, guiLeft + 15, guiTop + 5, 70, 20, "Dragonborn"));
		buttonList.add(new GuiButton(2, guiLeft + 15, guiTop + 25, 70, 20, "Dwarf"));
		buttonList.add(new GuiButton(3, guiLeft + 15, guiTop + 45, 70, 20, "Eladrin"));
		buttonList.add(new GuiButton(4, guiLeft + 15, guiTop + 65, 70, 20, "Elf"));
		buttonList.add(new GuiButton(5, guiLeft + 15, guiTop + 85, 70, 20, "Half-elf"));
		buttonList.add(new GuiButton(6, guiLeft + 15, guiTop + 105, 70, 20, "Halfling"));
		buttonList.add(new GuiButton(7, guiLeft + 15, guiTop + 125, 70, 20, "Human"));
		buttonList.add(new GuiButton(8, guiLeft + 15, guiTop + 145, 70, 20, "Tiefling"));

		buttonList.add(new GuiButton(9, guiLeft + 90, guiTop + 5, 70, 20, "Deva"));
		buttonList.add(new GuiButton(10, guiLeft + 90, guiTop + 25, 70, 20, "Gnome"));
		buttonList.add(new GuiButton(11, guiLeft + 90, guiTop + 45, 70, 20, "Goliath"));
		buttonList.add(new GuiButton(12, guiLeft + 90, guiTop + 65, 70, 20, "Half-Orc"));
		buttonList.add(new GuiButton(13, guiLeft + 90, guiTop + 85, 70, 20, "Shifter"));
		buttonList.add(new GuiButton(14, guiLeft + 90, guiTop + 105, 70, 20, "Githzerai"));
		buttonList.add(new GuiButton(15, guiLeft + 90, guiTop + 125, 70, 20, "Minotaur"));
		buttonList.add(new GuiButton(16, guiLeft + 90, guiTop + 145, 70, 20, "Wilden"));
	}
	
	//page 2 of gui
	public void initGui2()
	{
		super.initGui();
		buttonList.clear();
		
		buttonList.add(new GuiButton(17, guiLeft + 15, guiTop + 5, 70, 20, "Cleric"));
		buttonList.add(new GuiButton(18, guiLeft + 15, guiTop + 25, 70, 20, "Fighter"));
		buttonList.add(new GuiButton(19, guiLeft + 15, guiTop + 45, 70, 20, "Paladin"));
		buttonList.add(new GuiButton(20, guiLeft + 15, guiTop + 65, 70, 20, "Ranger"));
		buttonList.add(new GuiButton(21, guiLeft + 15, guiTop + 85, 70, 20, "Rogue"));
		buttonList.add(new GuiButton(22, guiLeft + 15, guiTop + 105, 70, 20, "Warlock"));
		buttonList.add(new GuiButton(23, guiLeft + 15, guiTop + 125, 70, 20, "Warlord"));
		buttonList.add(new GuiButton(24, guiLeft + 15, guiTop + 145, 70, 20, "Wizard"));
		buttonList.add(new GuiButton(25, guiLeft + 90, guiTop + 5, 70, 20, "Avenger"));
		buttonList.add(new GuiButton(26, guiLeft + 90, guiTop + 25, 70, 20, "Barbarian"));
		buttonList.add(new GuiButton(27, guiLeft + 90, guiTop + 45, 70, 20, "Bard"));
		buttonList.add(new GuiButton(28, guiLeft + 90, guiTop + 65, 70, 20, "Druid"));
		buttonList.add(new GuiButton(29, guiLeft + 90, guiTop + 85, 70, 20, "Invoker"));
		buttonList.add(new GuiButton(30, guiLeft + 90, guiTop + 105, 70, 20, "Shaman"));
		buttonList.add(new GuiButton(31, guiLeft + 90, guiTop + 125, 70, 20, "Sorcerer"));
		buttonList.add(new GuiButton(32, guiLeft + 90, guiTop + 145, 70, 20, "Warden"));
		
		buttonList.add(new GuiButton(33, guiLeft + 15, guiTop + 170, 20, 20, "<"));
	}
	
	
	//page 3 of gui
	public void initGui3()
	{
		super.initGui();
		buttonList.clear();
		
		GuiButton strlabel = new GuiButton(0, guiLeft + 20, guiTop + 10, 70, 20, "Strength");
		strlabel.enabled = false;
		buttonList.add(strlabel);
		buttonList.add(new GuiButton(34, guiLeft + 130, guiTop + 10, 20, 20, "+"));
		buttonList.add(new GuiButton(35, guiLeft + 100, guiTop + 10, 20, 20, "-"));		
		
		GuiButton dexlabel = new GuiButton(0, guiLeft + 20, guiTop + 35, 70, 20, "Dexterity");
		dexlabel.enabled = false;
		buttonList.add(dexlabel);
		buttonList.add(new GuiButton(36, guiLeft + 130, guiTop + 35, 20, 20, "+"));
		buttonList.add(new GuiButton(37, guiLeft + 100, guiTop + 35, 20, 20, "-"));		
		
		GuiButton conlabel = new GuiButton(0, guiLeft + 20, guiTop + 60, 70, 20, "Constitution");
		conlabel.enabled = false;
		buttonList.add(conlabel);
		buttonList.add(new GuiButton(38, guiLeft + 130, guiTop + 60, 20, 20, "+"));
		buttonList.add(new GuiButton(39, guiLeft + 100, guiTop + 60, 20, 20, "-"));
		
		GuiButton intlabel = new GuiButton(0, guiLeft + 20, guiTop + 85, 70, 20, "Intellect");
		intlabel.enabled = false;
		buttonList.add(intlabel);
		buttonList.add(new GuiButton(40, guiLeft + 130, guiTop + 85, 20, 20, "+"));
		buttonList.add(new GuiButton(41, guiLeft + 100, guiTop + 85, 20, 20, "-"));
		
		GuiButton wislabel = new GuiButton(0, guiLeft + 20, guiTop + 110, 70, 20, "Wisdom");
		wislabel.enabled = false;
		buttonList.add(wislabel);
		buttonList.add(new GuiButton(42, guiLeft + 130, guiTop + 110, 20, 20, "+"));
		buttonList.add(new GuiButton(43, guiLeft + 100, guiTop + 110, 20, 20, "-"));
		
		GuiButton chalabel = new GuiButton(0, guiLeft + 20, guiTop + 135, 70, 20, "Charisma");
		chalabel.enabled = false;
		buttonList.add(chalabel);
		buttonList.add(new GuiButton(44, guiLeft + 130, guiTop + 135, 20, 20, "+"));
		buttonList.add(new GuiButton(45, guiLeft + 100, guiTop + 135, 20, 20, "-"));

		buttonList.add(new GuiButton(46, guiLeft + 15, guiTop + 170, 20, 20, "<"));
		buttonList.add(new GuiButton(47, guiLeft + 140, guiTop + 170, 20, 20, ">"));
	}

	private boolean buttonEnabled[] = {	true,true,true,
										true,true,true,
										true,true,true,
										true,true,true,
										true,true,true,
										true,true};
	
	//page 4 of gui
	public void initGui4()
	{
		super.initGui();
		buttonList.clear();
		
		buttonList.add(new GuiButton(48, guiLeft + 15, guiTop + 5, 70, 20, "Acrobatics"));
		buttonList.add(new GuiButton(49, guiLeft + 15, guiTop + 25, 70, 20, "Arcana"));
		buttonList.add(new GuiButton(50, guiLeft + 15, guiTop + 45, 70, 20, "Atheletics"));
		buttonList.add(new GuiButton(51, guiLeft + 15, guiTop + 65, 70, 20, "Bluff"));
		buttonList.add(new GuiButton(52, guiLeft + 15, guiTop + 85, 70, 20, "Diplomacy"));
		buttonList.add(new GuiButton(53, guiLeft + 15, guiTop + 105, 70, 20, "Dungeoneer"));
		buttonList.add(new GuiButton(54, guiLeft + 15, guiTop + 125, 70, 20, "Endurance"));
		buttonList.add(new GuiButton(55, guiLeft + 15, guiTop + 145, 70, 20, "Heal"));
		buttonList.add(new GuiButton(56, guiLeft + 90, guiTop + 5, 70, 20, "History"));
		buttonList.add(new GuiButton(57, guiLeft + 90, guiTop + 25, 70, 20, "Insight"));
		buttonList.add(new GuiButton(58, guiLeft + 90, guiTop + 45, 70, 20, "Intimidate"));
		buttonList.add(new GuiButton(59, guiLeft + 90, guiTop + 65, 70, 20, "Nature"));
		buttonList.add(new GuiButton(60, guiLeft + 90, guiTop + 85, 70, 20, "Perception"));
		buttonList.add(new GuiButton(61, guiLeft + 90, guiTop + 105, 70, 20, "Religion"));
		buttonList.add(new GuiButton(62, guiLeft + 90, guiTop + 125, 70, 20, "Stealth"));
		buttonList.add(new GuiButton(63, guiLeft + 90, guiTop + 145, 70, 20, "Streetwise"));
		buttonList.add(new GuiButton(64, guiLeft + 90, guiTop + 165, 70, 20, "Thievery"));

		buttonList.add(new GuiButton(65, guiLeft + 15, guiTop + 170, 20, 20, "<"));
		buttonList.add(new GuiButton(66, guiLeft + 65, guiTop + 170, 20, 20, ">"));
	}
	
	//page 5 of gui
	public void initGui5()
	{
		super.initGui();
		buttonList.clear();	
		
		buttonList.add(new GuiButton(67, guiLeft + 15, guiTop + 170, 40, 20, "Reset"));
		buttonList.add(new GuiButton(68, guiLeft + 115, guiTop + 170, 40, 20, "Play"));
	}
	
	
	@Override
	protected void actionPerformed(GuiButton button)
	{
		switch(button.id)
		{
			case 0:	page = 1;
					initGui1();
					break;
										
			case 1: chosenRace = "Dragonborn";
					page = 2;
					initGui2();	
					break;
			case 2: chosenRace = "Dwarf";
					page = 2;
					initGui2();	
					break;
			case 3: chosenRace = "Eladrin";
					page = 2;
					initGui2();	
					break;
			case 4: chosenRace = "Elf";
					page = 2;
					initGui2();	
					break;
			case 5: chosenRace = "Half-elf";
					page = 2;
					initGui2();	
					break;
			case 6: chosenRace = "Halfling";
					page = 2;
					initGui2();	
					break;
			case 7: chosenRace = "Human";
					page = 2;
					initGui2();	
					break;
			case 8: chosenRace = "Tiefling";
					page = 2;
					initGui2();			
					break;
			case 9: chosenRace = "Deva";
					page = 2;
					initGui2();			
					break;
			case 10:chosenRace = "Gnome";
					page = 2;
					initGui2();			
					break;
			case 11:chosenRace = "Goliath";
					page = 2;
					initGui2();			
					break;
			case 12: chosenRace = "Half-Orc";
					page = 2;
					initGui2();			
					break;
			case 13: chosenRace = "Shifter";
					page = 2;
					initGui2();			
					break;
			case 14: chosenRace = "Githzerai";
					page = 2;
					initGui2();			
					break;
			case 15: chosenRace = "Minotaur";
					page = 2;
					initGui2();			
					break;
			case 16: chosenRace = "Wilden";
					page = 2;
					initGui2();			
					break;
					
			case 17: chosenClass = "Cleric";
					page = 3;
					initGui3();
					break;					
			case 18: chosenClass = "Fighter";
					page = 3;
					initGui3();
					break;					
			case 19:chosenClass = "Paladin";
					page = 3;
					initGui3();
					break;					
			case 20:chosenClass = "Ranger";
					page = 3;
					initGui3();
					break;					
			case 21:chosenClass = "Rogue";
					page = 3;
					initGui3();
					break;					
			case 22:chosenClass = "Warlock";
					page = 3;
					initGui3();	
					break;					
			case 23:chosenClass = "Warlord";
					page = 3;
					initGui3();
					break;					
			case 24:chosenClass = "Wizard";
					page = 3;
					initGui3();
					break;
			case 25:chosenClass = "Avenger";
					page = 3;
					initGui3();
					break;
			case 26:chosenClass = "Barbarian";
					page = 3;
					initGui3();
					break;
			case 27:chosenClass = "Bard";
					page = 3;
					initGui3();
					break;
			case 28:chosenClass = "Druid";
					page = 3;
					initGui3();
					break;
			case 29:chosenClass = "Invoker";
					page = 3;
					initGui3();
					break;
			case 30:chosenClass = "Shaman";
					page = 3;
					initGui3();
					break;
			case 31:chosenClass = "Sorcerer";
					page = 3;
					initGui3();
					break;
			case 32:chosenClass = "Warden";
					page = 3;
					initGui3();
					break;
			
					
			case 33:chosenRace = "";
					page = 1;
					initGui1();
					break;	
					
					
					
			case 34:System.out.println("str up");
					break;					
			case 35:System.out.println("str down");
					break;
			case 36:System.out.println("dex up");
					break;	
			case 37:System.out.println("dex down");
					break;		
			case 38:System.out.println("con up");
					break;				
			case 39:System.out.println("con down");
					break;		
			case 40:System.out.println("int up");
					break;							
			case 41:System.out.println("int down");
					break;			
			case 42:System.out.println("wis up");
					break;					
			case 43:System.out.println("wis down");
					break;
			case 44:System.out.println("cha up");
					break;					
			case 45:System.out.println("cha down");
					break;
					
			case 46:chosenClass = "";
					page = 2;
					initGui2();
					break;	
			case 47:page = 4;
					initGui4();
					break;		
					
			case 48:System.out.println("acro trained");
					skillTraining[0] = true;
					break;
			case 49:System.out.println("arca trained");
					skillTraining[1] = true;
					break;
			case 50:System.out.println("athe trained");
					skillTraining[2] = true;
					break;
			case 51:System.out.println("bluf trained");
					skillTraining[3] = true;
					break;
			case 52:System.out.println("dipl trained");
					skillTraining[4] = true;
					break;
			case 53:System.out.println("dung trained");
					skillTraining[5] = true;
					break;
			case 54:System.out.println("endu trained");
					skillTraining[6] = true;
					break;
			case 55:System.out.println("heal trained");		
					skillTraining[7] = true;
					break;
			case 56:System.out.println("hist trained");
					skillTraining[8] = true;
					break;
			case 57:System.out.println("insi trained");
					skillTraining[9] = true;
					break;
			case 58:System.out.println("inti trained");
					skillTraining[10] = true;
					break;
			case 59:System.out.println("natu trained");
					skillTraining[11] = true;
					break;
			case 60:System.out.println("perc trained");
					skillTraining[12] = true;
					break;
			case 61:System.out.println("reli trained");
					skillTraining[13] = true;
					break;
			case 62:System.out.println("stea trained");
					skillTraining[14] = true;
					break;
			case 63:System.out.println("stre trained");
					skillTraining[15] = true;
					break;
			case 64:System.out.println("thie trained");
					skillTraining[16] = true;
					break;
			
			case 65:page = 3;
					initGui3();
					skillTraining[0] = false;
					skillTraining[1] = false;
					skillTraining[2] = false;
					skillTraining[3] = false;
					skillTraining[4] = false;
					skillTraining[5] = false;
					skillTraining[6] = false;
					skillTraining[7] = false;
					skillTraining[8] = false;
					skillTraining[9] = false;
					skillTraining[10] = false;
					skillTraining[11] = false;
					skillTraining[12] = false;
					skillTraining[13] = false;
					skillTraining[14] = false;
					skillTraining[15] = false;
					skillTraining[16] = false;
					break;
			case 66:page = 5;
					initGui5();
					calculateSkills();
					break;
			
					
			case 67:page = 1;
					initGui1();
					chosenRace = "";
					chosenClass = "";
					attributes[0] = 10;
					attributes[1] = 10;
					attributes[2] = 10;
					attributes[3] = 10;
					attributes[4] = 10;
					attributes[5] = 10;
					skillTraining[0] = false;
					skillTraining[1] = false;
					skillTraining[2] = false;
					skillTraining[3] = false;
					skillTraining[4] = false;
					skillTraining[5] = false;
					skillTraining[6] = false;
					skillTraining[7] = false;
					skillTraining[8] = false;
					skillTraining[9] = false;
					skillTraining[10] = false;
					skillTraining[11] = false;
					skillTraining[12] = false;
					skillTraining[13] = false;
					skillTraining[14] = false;
					skillTraining[15] = false;
					skillTraining[16] = false;
					
					break;	
			case 68:;
					break;	
					
			default:;
		}		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		if(page == 1)
		{
		drawTextPage1();
		}
			else if (page == 2)
			{
			drawTextPage1();
			drawTextPage2();
			}
			else if (page == 3)
			{
			drawTextPage1();
			drawTextPage2();
			drawTextPage3();
				fontRendererObj.drawString("Points:", -70, 30, 0x505050);
				fontRendererObj.drawString(stringPool, -30, 30, 0xffffff);
			}
			else if (page == 4)
			{
				drawTextPage1();
				drawTextPage2();
				drawTextPage4();
			}
		
			else if(page == 5)
			{
				//fontRendererObj.drawString("Review your Character:", 20, -10, 0x000000);
				drawTextPage1();
				drawTextPage2();
				drawTextPage3();
				drawTextPage4();
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
	
	public void drawTextPage4()
	{

		fontRendererObj.drawString("Trained in:", -80, -10, 0x505050);
		
		if(skillTraining[0] == true)
	{fontRendererObj.drawString("Acrobatics", 	-80, 10, 0xffffff);}
		if(skillTraining[1] == true)
	{fontRendererObj.drawString("Arcana", 		-80, 20, 0xffffff);}
		if(skillTraining[2] == true)
	{fontRendererObj.drawString("Atheletics", 	-80, 30, 0xffffff);}
		if(skillTraining[3] == true)
	{fontRendererObj.drawString("Bluff", 		-80, 40, 0xffffff);}
		if(skillTraining[4] == true)
	{fontRendererObj.drawString("Diplomacy",	-80, 50, 0xffffff);}
		if(skillTraining[5] == true)
	{fontRendererObj.drawString("Dungeoneering",-80, 60, 0xffffff);}
		if(skillTraining[6] == true)
	{fontRendererObj.drawString("Endurance", 	-80, 70, 0xffffff);}
		if(skillTraining[7] == true)
	{fontRendererObj.drawString("Heal", 		-80, 80, 0xffffff);}
		if(skillTraining[8] == true)
	{fontRendererObj.drawString("History", 		-80, 90, 0xffffff);}
		if(skillTraining[9] == true)
	{fontRendererObj.drawString("Insight", 		-80, 100, 0xffffff);}
		if(skillTraining[10] == true)
	{fontRendererObj.drawString("Intimidate", 	-80, 110, 0xffffff);}
		if(skillTraining[11] == true)
	{fontRendererObj.drawString("Nature", 		-80, 120, 0xffffff);}
		if(skillTraining[12] == true)
	{fontRendererObj.drawString("Perception", 	-80, 130, 0xffffff);}
		if(skillTraining[13] == true)
	{fontRendererObj.drawString("Religion", 	-80, 140, 0xffffff);}
		if(skillTraining[14] == true)
	{fontRendererObj.drawString("Stealth", 		-80, 150, 0xffffff);}
		if(skillTraining[15] == true)
	{fontRendererObj.drawString("Streetwise", 	-80, 160, 0xffffff);}
		if(skillTraining[16] == true)
	{fontRendererObj.drawString("Thievery", 	-80, 170, 0xffffff);}
	}
	
	/** x size of the inventory window in pixels. Defined as float, passed as int */
	private float xSize_lo;

	/** y size of the inventory window in pixels. Defined as float, passed as int. */
	private float ySize_lo;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) 
	{
		super.drawScreen(mouseX, mouseY, partialTicks);
		xSize_lo = mouseX;
		ySize_lo = mouseY;
	}
			
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1,int var2, int var3) 
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
	
		
		if(page == 5)
		{
			this.mc.renderEngine.bindTexture(texturelast);
			this.drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
		}
		else
		{
			this.mc.renderEngine.bindTexture(textureblank);
			this.drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
		}
	
	}
	
    public void calculateSkills()
    {
    	if (skillTraining[0] == true){skillMods[0] += 5;}
    	if (skillTraining[1] == true){skillMods[1] += 5;}
    	if (skillTraining[2] == true){skillMods[2] += 5;}
    	if (skillTraining[3] == true){skillMods[3] += 5;}
    	if (skillTraining[4] == true){skillMods[4] += 5;}
    	if (skillTraining[5] == true){skillMods[5] += 5;}
    	if (skillTraining[6] == true){skillMods[6] += 5;}
    	if (skillTraining[7] == true){skillMods[7] += 5;}
    	if (skillTraining[8] == true){skillMods[8] += 5;}
    	if (skillTraining[9] == true){skillMods[9] += 5;}
    	if (skillTraining[10] == true){skillMods[10] += 5;}
    	if (skillTraining[11] == true){skillMods[11] += 5;}
    	if (skillTraining[12] == true){skillMods[12] += 5;}
    	if (skillTraining[13] == true){skillMods[13] += 5;}
    	if (skillTraining[14] == true){skillMods[14] += 5;}
    	if (skillTraining[15] == true){skillMods[15] += 5;}
    	if (skillTraining[16] == true){skillMods[16] += 5;}
    }

	
}