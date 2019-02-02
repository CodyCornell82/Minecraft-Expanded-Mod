package com.codycornell82.minecraftPlus;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class Bush extends Block implements IShearable {

	protected Bush(Material material) {
		super(material);
		this.setStepSound(soundTypeGrass);
		this.setHardness(0.5f);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return MinecraftPlus.berry;
	}

	@Override
	public int quantityDropped(Random rand) {
		return 1 + rand.nextInt(6);
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x,
			int y, int z) {

		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world,
			int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
		return ret;
	}

}
