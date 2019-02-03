package com.codycornell82.minecraftPlus.World.Biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class biomesMP {

	public static BiomeGenBase SilverMT;
	public static BiomeGenBase SummerWood;
	public static BiomeGenBase Wasteland;
	public static BiomeGenBase Cherry;
	public static BiomeGenBase IceBiome;
	public static BiomeGenBase IceFlat;
	public static BiomeGenBase ObsidianPlace;

	public static void init() {
		registerBiomes();
	}

	private static void registerBiomes() {

		SilverMT = new BiomeSilverMT(200).setBiomeName("Silver Mountain");
		BiomeDictionary.registerBiomeType(SilverMT, Type.MOUNTAIN);
		BiomeManager.coolBiomes.add(new BiomeEntry(SilverMT, 15));

		SummerWood = new BiomeSummerWood(201).setBiomeName("Summer Woods");
		BiomeDictionary.registerBiomeType(SummerWood, Type.FOREST);
		BiomeManager.warmBiomes.add(new BiomeEntry(SummerWood, 15));

		Wasteland = new BiomeWasteland(202).setBiomeName("The Wasteland");
		BiomeDictionary.registerBiomeType(Wasteland, Type.DESERT);
		BiomeManager.desertBiomes.add(new BiomeEntry(Wasteland, 15));

		Cherry = new BiomeCherry(203).setBiomeName("Cherry Forest");
		BiomeDictionary.registerBiomeType(Cherry, Type.FOREST);
		BiomeManager.warmBiomes.add(new BiomeEntry(Cherry, 15));
		
		IceBiome = new BiomeIce(204).setBiomeName("Icy Forest");
		BiomeDictionary.registerBiomeType(IceBiome, Type.FOREST);
		BiomeManager.icyBiomes.add(new BiomeEntry(IceBiome, 15));
		
		IceFlat = new BiomeIceSheet(205).setBiomeName("Ice Sheet");
		BiomeDictionary.registerBiomeType(IceFlat, Type.PLAINS);
		BiomeManager.icyBiomes.add(new BiomeEntry(IceFlat, 15));
		
		ObsidianPlace = new BlackBiome(206).setBiomeName("Obsidian Plains");
		BiomeDictionary.registerBiomeType(ObsidianPlace, Type.PLAINS);
		BiomeManager.desertBiomes.add(new BiomeEntry(ObsidianPlace, 15));

		BiomeManager.addSpawnBiome(SilverMT);

		BiomeManager.addSpawnBiome(SummerWood);

		BiomeManager.addSpawnBiome(Wasteland);

		BiomeManager.addSpawnBiome(Cherry);
		
		BiomeManager.addSpawnBiome(IceBiome);
		
		BiomeManager.addSpawnBiome(IceFlat);
		
		BiomeManager.addSpawnBiome(ObsidianPlace);

	}
}
