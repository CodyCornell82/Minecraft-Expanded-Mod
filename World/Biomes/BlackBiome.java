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

public class BlackBiome extends BiomeGenBase {
	public static final Height biomeHeight = new Height(0.1f, 0.02f);

	public BlackBiome(int id) {
		super(id);
		this.setHeight(biomeHeight);
		this.setColor(4071062);
		this.waterColorMultiplier = 4071062;
		this.flowers.clear();
		this.theBiomeDecorator.treesPerChunk = 1;
		this.theBiomeDecorator.mushroomsPerChunk = 3;
		this.theBiomeDecorator.grassPerChunk = 1;
		this.theBiomeDecorator.waterlilyPerChunk = 1;
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.reedsPerChunk = 1;
		this.theBiomeDecorator.generateLakes = true;
		this.topBlock = Blocks.obsidian;
		this.enableRain = false;
		this.enableSnow = false;
	}

	@Override
	public int getBiomeGrassColor(int x, int y, int z) {
		return 2166090;
	}

	@Override
	public int getBiomeFoliageColor(int x, int y, int z) {
		return 2166090;
	}
	@Override
	public int getSkyColorByTemp(float color1) {
		return 0;
	}

}
