package com.codycornell82.minecraftPlus.PowerBlocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class WorkBenchCraftingManager {
	/** The static instance of this class */
	private static final WorkBenchCraftingManager instance = new WorkBenchCraftingManager();
	/** A list of all the recipes added */
	private List recipes = new ArrayList();
	private static final String __OBFID = "CL_00000090";

	/**
	 * Returns the static instance of this class
	 */
	public static final WorkBenchCraftingManager getInstance() {
		/** The static instance of this class */
		return instance;
	}

	private WorkBenchCraftingManager() {
		recipes = new ArrayList();
		this.addRecipe(new ItemStack(Items.saddle, 1), new Object[] { "LLL",
				"L L", "I I", 'I', Items.iron_ingot, 'L', Items.leather });
		this.addRecipe(new ItemStack(Items.name_tag, 1), new Object[] { "SP",
				'P', Items.paper, 'S', Items.string });
		this.addRecipe(new ItemStack(Items.diamond_horse_armor, 1),
				new Object[] { "  D", "DWD", "D D", 'D', Items.diamond, 'W',
						Blocks.wool });
		this.addRecipe(new ItemStack(Items.iron_horse_armor, 1), new Object[] {
				"  I", "IWI", "I I", 'I', Items.iron_ingot, 'W', Blocks.wool });
		this.addRecipe(new ItemStack(Items.golden_horse_armor, 1),
				new Object[] { "  G", "GWG", "G G", 'G', Items.gold_ingot, 'W',
						Blocks.wool });
		this.addRecipe(new ItemStack(MinecraftPlus.boss, 1), new Object[] {
				"FVVF", "VEGV", "VGEV", "FVVF", 'G', Items.gold_ingot, 'E',
				Items.ender_eye, 'V', MinecraftPlus.Visber, 'F',
				MinecraftPlus.FarNug });
		this.addRecipe(new ItemStack(MinecraftPlus.CallBow, 1), new Object[] {
				" FS", "C S", " FS", 'F', MinecraftPlus.FarBar, 'S',
				MinecraftPlus.CallerSkin, 'C', MinecraftPlus.CobaltBar });
		this.addRecipe(new ItemStack(MinecraftPlus.SwordNew, 1), new Object[] {
				"FC", "FC", "FC", " S", 'F', MinecraftPlus.RedQuartz, 'S',
				MinecraftPlus.CallerSkin, 'C', MinecraftPlus.CobaltBar });
		this.addRecipe(new ItemStack(MinecraftPlus.NewBoot, 1), new Object[] {
				"S S", "C C", "F F", 'F', MinecraftPlus.RedQuartz, 'S',
				MinecraftPlus.CallerSkin, 'C', MinecraftPlus.CobaltBar });
		this.addRecipe(new ItemStack(MinecraftPlus.NewChest, 1), new Object[] {
				"CSSC", "CFFC", "CCCC", 'F', MinecraftPlus.RedQuartz, 'S',
				MinecraftPlus.CallerSkin, 'C', MinecraftPlus.CobaltBar });
		this.addRecipe(new ItemStack(MinecraftPlus.NewHead, 1), new Object[] {
				"CFC", "CSC", 'F', MinecraftPlus.RedQuartz, 'S',
				MinecraftPlus.CallerSkin, 'C', MinecraftPlus.CobaltBar });
		this.addRecipe(new ItemStack(MinecraftPlus.NewLegs, 1), new Object[] {
				"SSSS", "CFFC", "C  C", "C  C", 'F', MinecraftPlus.RedQuartz,
				'S', MinecraftPlus.CallerSkin, 'C', MinecraftPlus.CobaltBar });
		this.addRecipe(new ItemStack(MinecraftPlus.MakeSpawn, 1), new Object[] {
				"FVVF", "VEGV", "VGEV", "FVVF", 'G', Items.netherbrick, 'E',
				Items.blaze_rod, 'V', Blocks.nether_brick, 'F',
				MinecraftPlus.FarNug });

		Collections.sort(this.recipes, new WorkBenchRecipeSorter(this));
	}

	public WorkBenchShapedRecipes addRecipe(ItemStack p_92103_1_,
			Object... p_92103_2_) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;

		if (p_92103_2_[i] instanceof String[]) {
			String[] astring = (String[]) ((String[]) p_92103_2_[i++]);

			for (int l = 0; l < astring.length; ++l) {
				String s1 = astring[l];
				++k;
				j = s1.length();
				s = s + s1;
			}
		} else {
			while (p_92103_2_[i] instanceof String) {
				String s2 = (String) p_92103_2_[i++];
				++k;
				j = s2.length();
				s = s + s2;
			}
		}

		HashMap hashmap;

		for (hashmap = new HashMap(); i < p_92103_2_.length; i += 2) {
			Character character = (Character) p_92103_2_[i];
			ItemStack itemstack1 = null;

			if (p_92103_2_[i + 1] instanceof Item) {
				itemstack1 = new ItemStack((Item) p_92103_2_[i + 1]);
			} else if (p_92103_2_[i + 1] instanceof Block) {
				itemstack1 = new ItemStack((Block) p_92103_2_[i + 1], 1, 32767);
			} else if (p_92103_2_[i + 1] instanceof ItemStack) {
				itemstack1 = (ItemStack) p_92103_2_[i + 1];
			}

			hashmap.put(character, itemstack1);
		}

		ItemStack[] aitemstack = new ItemStack[j * k];

		for (int i1 = 0; i1 < j * k; ++i1) {
			char c0 = s.charAt(i1);

			if (hashmap.containsKey(Character.valueOf(c0))) {
				aitemstack[i1] = ((ItemStack) hashmap
						.get(Character.valueOf(c0))).copy();
			} else {
				aitemstack[i1] = null;
			}
		}

		WorkBenchShapedRecipes shapedrecipes = new WorkBenchShapedRecipes(j, k,
				aitemstack, p_92103_1_);
		this.recipes.add(shapedrecipes);
		return shapedrecipes;
	}

	public void addShapelessRecipe(ItemStack p_77596_1_, Object... p_77596_2_) {
		ArrayList arraylist = new ArrayList();
		Object[] aobject = p_77596_2_;
		int i = p_77596_2_.length;

		for (int j = 0; j < i; ++j) {
			Object object1 = aobject[j];

			if (object1 instanceof ItemStack) {
				arraylist.add(((ItemStack) object1).copy());
			} else if (object1 instanceof Item) {
				arraylist.add(new ItemStack((Item) object1));
			} else {
				if (!(object1 instanceof Block)) {
					throw new RuntimeException("Invalid shapeless recipe!");
				}

				arraylist.add(new ItemStack((Block) object1));
			}
		}

		this.recipes.add(new ShapelessRecipes(p_77596_1_, arraylist));
	}

	public ItemStack findMatchingRecipe(InventoryCrafting p_82787_1_,
			World p_82787_2_) {
		int i = 0;
		ItemStack itemstack = null;
		ItemStack itemstack1 = null;
		int j;

		for (j = 0; j < p_82787_1_.getSizeInventory(); ++j) {
			ItemStack itemstack2 = p_82787_1_.getStackInSlot(j);

			if (itemstack2 != null) {
				if (i == 0) {
					itemstack = itemstack2;
				}

				if (i == 1) {
					itemstack1 = itemstack2;
				}

				++i;
			}
		}

		if (i == 2 && itemstack.getItem() == itemstack1.getItem()
				&& itemstack.stackSize == 1 && itemstack1.stackSize == 1
				&& itemstack.getItem().isRepairable()) {
			Item item = itemstack.getItem();
			int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
			int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
			int l = j1 + k + item.getMaxDamage() * 5 / 100;
			int i1 = item.getMaxDamage() - l;

			if (i1 < 0) {
				i1 = 0;
			}

			return new ItemStack(itemstack.getItem(), 1, i1);
		} else {
			for (j = 0; j < this.recipes.size(); ++j) {
				IRecipe irecipe = (IRecipe) this.recipes.get(j);

				if (irecipe.matches(p_82787_1_, p_82787_2_)) {
					return irecipe.getCraftingResult(p_82787_1_);
				}
			}

			return null;
		}
	}

	/**
	 * returns the List<> of all recipes
	 */
	public List getRecipeList() {
		return this.recipes;
	}
}