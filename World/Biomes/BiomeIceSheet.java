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

public class BiomeIceSheet extends BiomeGenBase {
	public static final Height biomeHeight = new Height(0.1f, 0.02f);

	public BiomeIceSheet(int id) {
		super(id);
		this.setHeight(biomeHeight);
		this.setColor(13431036);
		this.setTemperatureRainfall(0.0f, 0.5f);
		this.waterColorMultiplier = 13431036;
		this.flowers.clear();
		this.theBiomeDecorator.treesPerChunk = 0;
		this.theBiomeDecorator.mushroomsPerChunk = 3;
		this.theBiomeDecorator.grassPerChunk = 0;
		this.theBiomeDecorator.waterlilyPerChunk = 0;
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.generateLakes = true;
		this.enableRain = false;
		this.enableSnow = true;
		this.topBlock = Blocks.packed_ice;
	}

	@Override
	public int getBiomeGrassColor(int x, int y, int z) {
		return 13431036;
	}

	@Override
	public int getBiomeFoliageColor(int x, int y, int z) {
		return 13431036;
	}
}
