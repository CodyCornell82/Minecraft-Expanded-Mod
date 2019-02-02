package com.codycornell82.minecraftPlus;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;

public class BushPlacer implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case 1:
			generateEnd(world, random, chunkX, chunkZ);
			break;
		case 0:
			generateOverworld(world, random, chunkX, chunkZ);
			break;
		case -1:
			generateNether(world, random, chunkX, chunkZ);
			break;
		}
	}

	public void generateEnd(World world, Random rand, int x, int z) {
		generateOre(Blocks.end_stone, world, rand, x, z, 1, 100, 1, 20, 100,
				Blocks.air);
		generateOre(Blocks.glowstone, world, rand, x, z, 3, 5, 10, 20, 100,
				Blocks.end_stone);
		generateOre(MinecraftPlus.FarlandOre, world, rand, x, z, 3, 5, 30, 20,
				100, Blocks.end_stone);
	}

	public void generateOverworld(World world, Random rand, int x, int z) {
		generateOre(MinecraftPlus.bush, world, rand, x, z, 1, 10, 50, 20, 100,
				Blocks.tallgrass);
		generateOre(MinecraftPlus.CobaltOre, world, rand, x, z, 3, 5, 10, 1, 12,
				Blocks.stone);
		generateOre(MinecraftPlus.SilverOre, world, rand, x, z, 1, 10, 20, 1,
				200, Blocks.stone);
		generateOre(MinecraftPlus.DustBlock, world, rand, x, z, 3, 10, 20, 1,
				200, Blocks.sand);
		generateOre(MinecraftPlus.DustBlock, world, rand, x, z, 3, 10, 20, 1,
				200, Blocks.sandstone);
		generateOre(MinecraftPlus.woodrootPlant, world, rand, x, z, 1, 10, 50,
				20, 100, Blocks.tallgrass);
		generateOre(MinecraftPlus.DustBlock, world, rand, x, z, 3, 10, 20, 1,
				200, Blocks.dirt);
		generateOre(MinecraftPlus.berryPlant, world, rand, x, z, 1, 10, 50, 20,
				100, Blocks.tallgrass);
		generateOre(MinecraftPlus.CopperOre, world, rand, x, z, 1, 10, 20, 1,
				200, Blocks.stone);
		generateOre(MinecraftPlus.TinOre, world, rand, x, z, 1, 10, 20, 1,
				200, Blocks.stone);

	}

	public void generateNether(World world, Random rand, int x, int z) {
		generateOre(MinecraftPlus.RedOre, world, rand, x, z, 3, 13, 20, 1, 200,
				Blocks.netherrack);
		generateOre(MinecraftPlus.RedOre, world, rand, x, z, 1, 3, 20, 1, 200,
				Blocks.quartz_ore);
	}

	public void generateOre(Block block, World world, Random random,
			int chunkX, int chunkZ, int minVienSize, int maxVienSize,
			int chance, int minY, int maxY, Block generateIn) {
		int VienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
		int hightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block, VienSize, generateIn);
		for (int i = 0; i < chance; i++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(hightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			gen.generate(world, random, xRand, yRand, zRand);
		}
	}
}
