package com.codycornell82.minecraftPlus.MobHandler;

import java.util.Random;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.codycornell82.minecraftPlus.MinecraftPlus;
import com.codycornell82.minecraftPlus.World.Biomes.biomesMP;

import cpw.mods.fml.common.registry.EntityRegistry;

public class MobHandler {
	public static void registerPeaceful(Class MobClass, String Name, int color,
			int subcolor) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = Name.hashCode();
		Random rand = new Random(x);
		int mainColor = rand.nextInt() * 16777215;
		int subColor = rand.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(MobClass, Name, entityId);
		EntityRegistry.addSpawn(MobClass, 100, 1, 10,
				EnumCreatureType.creature, BiomeGenBase.birchForest,
				BiomeGenBase.birchForestHills, BiomeGenBase.coldTaiga,
				BiomeGenBase.coldTaigaHills, BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus,
				BiomeGenBase.forest, BiomeGenBase.forestHills,
				BiomeGenBase.jungle, BiomeGenBase.jungleEdge,
				BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland,
				BiomeGenBase.mushroomIslandShore, BiomeGenBase.plains,
				BiomeGenBase.roofedForest, BiomeGenBase.swampland,
				BiomeGenBase.taiga, BiomeGenBase.taigaHills,
				BiomeGenBase.stoneBeach, BiomeGenBase.coldBeach,
				BiomeGenBase.desert, BiomeGenBase.desertHills,
				BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver,
				BiomeGenBase.iceMountains, BiomeGenBase.icePlains,
				BiomeGenBase.river, BiomeGenBase.savanna,
				BiomeGenBase.savannaPlateau, BiomeGenBase.deepOcean,
				BiomeGenBase.frozenOcean, BiomeGenBase.river,
				BiomeGenBase.frozenRiver, biomesMP.SilverMT,
				biomesMP.SummerWood, biomesMP.Wasteland
				,biomesMP.IceBiome, biomesMP.IceFlat, biomesMP.ObsidianPlace);
		EntityRegistry.registerModEntity(MobClass, Name, entityId,
				MinecraftPlus.instance, 24, 1, true);
		createEgg(entityId, color, subcolor);
	}

	public static void registerMonster(Class MobClass, String Name, int color,
			int subcolor) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = Name.hashCode();
		Random rand = new Random(x);
		int mainColor = rand.nextInt() * 16777215;
		int subColor = rand.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(MobClass, Name, entityId);
		EntityRegistry.addSpawn(MobClass, 100, 1, 2, EnumCreatureType.monster,
				BiomeGenBase.birchForest, BiomeGenBase.birchForestHills,
				BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills,
				BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge,
				BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest,
				BiomeGenBase.forestHills, BiomeGenBase.jungle,
				BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills,
				BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore,
				BiomeGenBase.plains, BiomeGenBase.roofedForest,
				BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.taigaHills, BiomeGenBase.stoneBeach,
				BiomeGenBase.coldBeach, BiomeGenBase.desert,
				BiomeGenBase.desertHills, BiomeGenBase.frozenOcean,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.river,
				BiomeGenBase.savanna, BiomeGenBase.savannaPlateau,
				BiomeGenBase.deepOcean, BiomeGenBase.frozenOcean,
				BiomeGenBase.river, BiomeGenBase.frozenRiver,
				BiomeGenBase.hell, BiomeGenBase.sky, biomesMP.SilverMT,
				biomesMP.SummerWood, biomesMP.Wasteland
				,biomesMP.IceBiome, biomesMP.IceFlat, biomesMP.ObsidianPlace);
		EntityRegistry.registerModEntity(MobClass, Name, entityId,
				MinecraftPlus.instance, 24, 1, true);
		createEgg(entityId, color, subcolor);
	}

	public static void registerMonsterOverworld(Class MobClass, String Name,
			int color, int subcolor) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = Name.hashCode();
		Random rand = new Random(x);
		int mainColor = rand.nextInt() * 16777215;
		int subColor = rand.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(MobClass, Name, entityId);
		EntityRegistry.addSpawn(MobClass, 100, 1, 2, EnumCreatureType.monster,
				BiomeGenBase.birchForest, BiomeGenBase.birchForestHills,
				BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills,
				BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge,
				BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest,
				BiomeGenBase.forestHills, BiomeGenBase.jungle,
				BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills,
				BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore,
				BiomeGenBase.plains, BiomeGenBase.roofedForest,
				BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.taigaHills, BiomeGenBase.stoneBeach,
				BiomeGenBase.coldBeach, BiomeGenBase.desert,
				BiomeGenBase.desertHills, BiomeGenBase.frozenOcean,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.river,
				BiomeGenBase.savanna, BiomeGenBase.savannaPlateau,
				BiomeGenBase.deepOcean, BiomeGenBase.frozenOcean,
				BiomeGenBase.river, BiomeGenBase.frozenRiver,
				biomesMP.SilverMT, biomesMP.SummerWood, biomesMP.Wasteland
				,biomesMP.IceBiome, biomesMP.IceFlat, biomesMP.ObsidianPlace);
		EntityRegistry.registerModEntity(MobClass, Name, entityId,
				MinecraftPlus.instance, 24, 1, true);
		createEgg(entityId, color, subcolor);
	}

	public static void registerMonsterOverworldAndEnd(Class MobClass,
			String Name, int color, int subcolor) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = Name.hashCode();
		Random rand = new Random(x);
		int mainColor = rand.nextInt() * 16777215;
		int subColor = rand.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(MobClass, Name, entityId);
		EntityRegistry.addSpawn(MobClass, 100, 1, 2, EnumCreatureType.monster,
				BiomeGenBase.birchForest, BiomeGenBase.birchForestHills,
				BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills,
				BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge,
				BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest,
				BiomeGenBase.forestHills, BiomeGenBase.jungle,
				BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills,
				BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore,
				BiomeGenBase.plains, BiomeGenBase.roofedForest,
				BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.taigaHills, BiomeGenBase.stoneBeach,
				BiomeGenBase.coldBeach, BiomeGenBase.desert,
				BiomeGenBase.desertHills, BiomeGenBase.frozenOcean,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.river,
				BiomeGenBase.savanna, BiomeGenBase.savannaPlateau,
				BiomeGenBase.deepOcean, BiomeGenBase.frozenOcean,
				BiomeGenBase.river, BiomeGenBase.frozenRiver,
				biomesMP.SilverMT, BiomeGenBase.sky, biomesMP.SummerWood,
				biomesMP.Wasteland, biomesMP.IceBiome, biomesMP.IceFlat, biomesMP.ObsidianPlace);
		EntityRegistry.registerModEntity(MobClass, Name, entityId,
				MinecraftPlus.instance, 24, 1, true);
		createEgg(entityId, color, subcolor);
	}

	public static void registerBoss(Class MobClass, String Name, int color,
			int subcolor) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = Name.hashCode();
		Random rand = new Random(x);
		int mainColor = rand.nextInt() * 16777215;
		int subColor = rand.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(MobClass, Name, entityId);
		EntityRegistry.registerModEntity(MobClass, Name, entityId,
				MinecraftPlus.instance, 24, 1, true);
		createEgg(entityId, color, subcolor);
	}

	public static void registerMonsterJungle(Class MobClass, String Name,
			int color, int subcolor) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = Name.hashCode();
		Random rand = new Random(x);
		int mainColor = rand.nextInt() * 16777215;
		int subColor = rand.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(MobClass, Name, entityId);
		EntityRegistry.addSpawn(MobClass, 100, 1, 2, EnumCreatureType.monster,
				BiomeGenBase.jungle, BiomeGenBase.jungleEdge,
				BiomeGenBase.jungleHills);
		EntityRegistry.registerModEntity(MobClass, Name, entityId,
				MinecraftPlus.instance, 24, 1, true);
		createEgg(entityId, color, subcolor);
	}

	public static void registerMonsterOverworldAndNether(Class MobClass,
			String Name, int color, int subcolor) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = Name.hashCode();
		Random rand = new Random(x);
		int mainColor = rand.nextInt() * 16777215;
		int subColor = rand.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(MobClass, Name, entityId);
		EntityRegistry.addSpawn(MobClass, 100, 1, 2, EnumCreatureType.monster,
				BiomeGenBase.birchForest, BiomeGenBase.birchForestHills,
				BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills,
				BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge,
				BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest,
				BiomeGenBase.forestHills, BiomeGenBase.jungle,
				BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills,
				BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore,
				BiomeGenBase.plains, BiomeGenBase.roofedForest,
				BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.taigaHills, BiomeGenBase.stoneBeach,
				BiomeGenBase.coldBeach, BiomeGenBase.desert,
				BiomeGenBase.desertHills, BiomeGenBase.frozenOcean,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.river,
				BiomeGenBase.savanna, BiomeGenBase.savannaPlateau,
				BiomeGenBase.deepOcean, BiomeGenBase.frozenOcean,
				BiomeGenBase.river, BiomeGenBase.frozenRiver,
				BiomeGenBase.hell, biomesMP.SilverMT, biomesMP.SummerWood,
				biomesMP.Wasteland, biomesMP.IceBiome, biomesMP.IceFlat, biomesMP.ObsidianPlace);
		EntityRegistry.registerModEntity(MobClass, Name, entityId,
				MinecraftPlus.instance, 24, 1, true);
		createEgg(entityId, color, subcolor);
	}

	public static void registerMonsterNether(Class MobClass, String Name,
			int color, int subcolor) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = Name.hashCode();
		Random rand = new Random(x);
		int mainColor = rand.nextInt() * 16777215;
		int subColor = rand.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(MobClass, Name, entityId);
		EntityRegistry.addSpawn(MobClass, 100, 1, 2, EnumCreatureType.monster,
				BiomeGenBase.hell);
		EntityRegistry.registerModEntity(MobClass, Name, entityId,
				MinecraftPlus.instance, 24, 1, true);
		createEgg(entityId, color, subcolor);
	}

	public static void registerPeacefulEnd(Class MobClass, String Name,
			int color, int subcolor) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = Name.hashCode();
		Random rand = new Random(x);
		int mainColor = rand.nextInt() * 16777215;
		int subColor = rand.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(MobClass, Name, entityId);
		EntityRegistry.addSpawn(MobClass, 100, 1, 10,
				EnumCreatureType.creature, BiomeGenBase.sky);
		EntityRegistry.registerModEntity(MobClass, Name, entityId,
				MinecraftPlus.instance, 24, 1, true);
		createEgg(entityId, color, subcolor);
	}

	private static void createEgg(int entityId, int color, int subcolor) {
		EntityList.entityEggs.put(Integer.valueOf(entityId),
				new EntityList.EntityEggInfo(entityId, color, subcolor));
	}
}
