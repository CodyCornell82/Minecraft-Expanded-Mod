package com.codycornell82.minecraftPlus.World.Biomes;

import java.util.Random;

import com.codycornell82.minecraftPlus.MinecraftPlus;
import com.codycornell82.minecraftPlus.World.Biomes.feature.WorldGenSilverWoodTree;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDesertWells;

public class BiomeWasteland extends BiomeGenBase {
	private static final String __OBFID = "CL_00000167";

	public BiomeWasteland(int p_i1977_1_) {
		super(p_i1977_1_);
		this.setColor(11049782);
		this.waterColorMultiplier = 7695131;
		this.spawnableCreatureList.clear();
		this.topBlock = Blocks.dirt;
		this.fillerBlock = Blocks.stone;
		this.enableRain = false;
		this.enableSnow = false;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.deadBushPerChunk = 2;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.cactiPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.spawnableCreatureList.clear();
	}

	@Override
	public int getBiomeGrassColor(int x, int y, int z) {
		return 11049782;
	}

	@Override
	public int getBiomeFoliageColor(int x, int y, int z) {
		return 11049782;
	}

}
