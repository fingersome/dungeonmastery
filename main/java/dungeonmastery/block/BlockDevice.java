package dungeonmastery.block;
 
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import dungeonmastery.DungeonMastery;
import dungeonmastery.ModInfo;
 
public class BlockDevice extends Block
{
private final String name = BlockInfo.BLOCK_DEVICE_UNLOCALIZED;

	public BlockDevice()
	{
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(ModInfo.MODID + "." + name);
		setCreativeTab(DungeonMastery.tabdungeon);
	}
	
	public String getName()
	{
		return name;
	}
}