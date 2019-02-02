package com.codycornell82.minecraftPlus.PowerBlocks;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class WorkBenchRecipeSorter implements Comparator {

	final WorkBenchCraftingManager WorkBench;

	public WorkBenchRecipeSorter(WorkBenchCraftingManager wb) {
		this.WorkBench = wb;
	}

	public int compaireRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof WorkBenchShaplessRecipes
				&& irecipe2 instanceof WorkBenchShapedRecipes ? 1
				: (irecipe2 instanceof WorkBenchShaplessRecipes
						&& irecipe1 instanceof WorkBenchShapedRecipes ? -1
						: (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1
								: (irecipe2.getRecipeSize() > irecipe1
										.getRecipeSize() ? 1 : 0)));
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		return this.compaireRecipes((IRecipe) arg0, (IRecipe) arg1);
	}

}
