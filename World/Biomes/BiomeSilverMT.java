package com.codycornell82.minecraftPlus.World.Biomes;

import java.util.Random;

import com.codycornell82.minecraftPlus.MinecraftPlus;
import com.codycornell82.minecraftPlus.World.Biomes.feature.WorldGenSilverWoodTree;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeSilverMT extends BiomeGenBase {
	public static final Height biomeHeight = new Height(1.5f, 0.2f);
	private static final WorldGenSilverWoodTree field_150627_aC = new WorldGenSilverWoodTree(
			MinecraftPlus.Log, MinecraftPlus.leaf, 0, 0);

	public BiomeSilverMT(int id) {
		super(id);
		this.setHeight(biomeHeight);
		this.setColor(15790320);
		this.setTemperatureRainfall(0.9f, 1.0f);
		this.waterColorMultiplier = 15790320;
		this.flowers.clear();
		this.addFlower(Blocks.red_flower, 0, 30);
		this.addFlower(Blocks.yellow_flower, 0, 30);
	}

	public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
		return (WorldGenAbstractTree) (p_150567_1_.nextInt(5) > 0 ? field_150627_aC
				: this.worldGeneratorTrees);
	}

	@Override
	public int getBiomeGrassColor(int x, int y, int z) {
		return 15790320;
	}

	@Override
	public int getBiomeFoliageColor(int x, int y, int z) {
		return 15790320;
	}

	@Override
	public int getSkyColorByTemp(float color1) {
		return 0;
	}

}
