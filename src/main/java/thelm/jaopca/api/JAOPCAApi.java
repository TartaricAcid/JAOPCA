package thelm.jaopca.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

/**
 * Contains all lists and maps used by this mod (and other stuff)
 * @author TheLMiffy1111
 */
public class JAOPCAApi {

	/**
	 * Contains all blocks registered by this mod, row = entry name, column = ore name
	 */
	public static final HashBasedTable<String,String,Block> BLOCKS_TABLE = HashBasedTable.<String,String,Block>create();

	/**
	 * Contains all items registered by this mod, row = entry name, column = ore name
	 */
	public static final HashBasedTable<String,String,Item> ITEMS_TABLE = HashBasedTable.<String,String,Item>create();

	/**
	 * Contains all fluids registered by this mod, row = entry name, column = ore name
	 */
	public static final HashBasedTable<String,String,Fluid> FLUIDS_TABLE = HashBasedTable.<String,String,Fluid>create();

	/**
	 * List of all {@link ItemEntry}s.
	 */
	public static final ArrayList<ItemEntry> ITEM_ENTRY_LIST = Lists.<ItemEntry>newArrayList();

	/**
	 * A map for convenience of all {@link ItemEntry}s.
	 */
	public static final HashMap<String,ItemEntry> NAME_TO_ITEM_ENTRY_MAP = Maps.<String,ItemEntry>newHashMap();

	/**
	 * A map for convenience of all {@link ItemEntry}s.
	 */
	public static final LinkedHashMultimap<EnumEntryType,ItemEntry> TYPE_TO_ITEM_ENTRY_MAP = LinkedHashMultimap.<EnumEntryType,ItemEntry>create();

	/**
	 * List of all {@link IOreEntry}s.
	 */
	public static final ArrayList<IOreEntry> ORE_ENTRY_LIST = Lists.<IOreEntry>newArrayList();

	/**
	 * List of all {@link ModuleBase}s.
	 */
	public static final ArrayList<ModuleBase> MODULE_LIST = Lists.<ModuleBase>newArrayList();

	/**
	 * A map for convenience of all {@link ModuleBase}s.
	 */
	public static final HashMap<String,ModuleBase> NAME_TO_MODULE_MAP = Maps.<String,ModuleBase>newHashMap();

	/**
	 * A {@link ItemEntry} name to {@link IOreEntry} for convenience.
	 */
	public static final LinkedHashMultimap<String,IOreEntry> ENTRY_NAME_TO_ORES_MAP = LinkedHashMultimap.<String,IOreEntry>create();

	public static final LinkedHashMultimap<ModuleBase,IOreEntry> MODULE_TO_ORES_MAP = LinkedHashMultimap.<ModuleBase,IOreEntry>create();

	public static final LinkedHashMultimap<EnumOreType,IOreEntry> ORE_TYPE_TO_ORES_MAP = LinkedHashMultimap.<EnumOreType,IOreEntry>create();

	/**
	 * Set of textures to register
	 */
	public static final HashSet<ResourceLocation> TEXTURES = Sets.<ResourceLocation>newHashSet();

	public static final Logger LOGGER = LogManager.getLogger("JAOPCA");

	/**
	 * Register your {@link ModuleBase}s here.
	 * @param module The module to register
	 */
	public static void registerModule(ModuleBase module) {
		MODULE_LIST.add(module);
		NAME_TO_MODULE_MAP.put(module.getName(), module);
	}

	public static boolean isModuleLoaded(String name) {
		return NAME_TO_MODULE_MAP.containsKey(name);
	}
}
