package dungeonmastery.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigHandler
{

	public static final String CONFIG_CATAGORY = "CONFIGURATION FILE";
	public static final String CATEGORY_ATTRIBUTES = "ATTRIBUTES";
	
	public static void init(File file)
	{
		Configuration config = new Configuration(file);

		config.load();



		config.save();
	}
}