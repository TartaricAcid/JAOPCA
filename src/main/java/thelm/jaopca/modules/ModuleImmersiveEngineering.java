package thelm.jaopca.modules;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import com.google.common.collect.Lists;

import blusunrize.immersiveengineering.common.IERecipes;
import thelm.jaopca.api.EnumOreType;
import thelm.jaopca.api.IOreEntry;
import thelm.jaopca.api.JAOPCAApi;
import thelm.jaopca.api.ModuleBase;
import thelm.jaopca.api.utils.Utils;

public class ModuleImmersiveEngineering extends ModuleBase {

	@Override
	public String getName() {
		return "immersiveengineering";
	}

	@Override
	public List<String> getDependencies() {
		return Lists.<String>newArrayList("dust");
	}

	@Override
	public EnumSet<EnumOreType> getOreTypes() {
		return EnumSet.<EnumOreType>copyOf(Arrays.asList(EnumOreType.ORE));
	}

	@Override
	public List<String> getOreBlacklist() {
		return Lists.<String>newArrayList(
				"Iron", "Gold", "Copper", "Lead", "Silver", "Nickel", "Platinum", "Tungsten", "Uranium", "Yellorium", "Plutonium", "Osmium", "Iridium", "FzDarkIron", "Lapis", "Redstone", "Quartz", "Nikolite"
				);
	}

	@Override
	public void init() {
		IERecipes.oreOutputSecondaries.replace("Iridium", new Object[] {"dustPlatinum", Float.valueOf(0.1F)});

		for(IOreEntry entry : JAOPCAApi.MODULE_TO_ORES_MAP.get(this)) {
			if(entry.hasExtra()) {
				String s = Utils.oreNameToType(entry.getExtra())==EnumOreType.GEM?"gem":"dust";

				IERecipes.oreOutputSecondaries.put(entry.getOreName(), new Object[] {s+entry.getExtra(), 0.1F});
			}
		}
	}
}
