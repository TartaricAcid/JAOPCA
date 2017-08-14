package thelm.jaopca.api.item;

import net.minecraft.item.EnumRarity;
import thelm.jaopca.api.IObjectWithProperty;
import thelm.jaopca.api.IOreEntry;
import thelm.jaopca.api.ItemEntry;

public interface IItemBlockWithProperty extends IObjectWithProperty {
	
	IItemBlockWithProperty setMaxStackSize(int maxStkSize);
	IItemBlockWithProperty setRarity(EnumRarity rarity);
}