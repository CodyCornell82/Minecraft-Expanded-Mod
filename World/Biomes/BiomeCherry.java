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

public class BiomeCherry extends BiomeGenBase {
	public static final Height biomeHeight = new Height(0.1f, 0.02f);

	public BiomeCherry(int id) {
		super(id);
		this.setHeight(biomeHeight);
		this.setColor(3715170);
		this.setTemperatureRainfall(0.9f, 1.0f);
		this.waterColorMultiplier = 3224043;
		this.flowers.clear();
		this.addFlower(Blocks.red_flower, 0, 30);
		this.addFlower(Blocks.yellow_flower, 0, 30);
		this.theBiomeDecorator.treesPerChunk = 5;
		this.theBiomeDecorator.mushroomsPerChunk = 3;
		this.theBiomeDecorator.grassPerChunk = 10;
		this.theBiomeDecorator.waterlilyPerChunk = 2;
		this.theBiomeDecorator.flowersPerChunk = 4;
		this.theBiomeDecorator.generateLakes = true;
	}

	@Override
	public int getBiomeGrassColor(int x, int y, int z) {
		return 3715170;
	}

	@Override
	public int getBiomeFoliageColor(int x, int y, int z) {
		return 16758269;
	}
}
