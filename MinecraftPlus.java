package com.codycornell82.minecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.potion.Potion;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.codycornell82.minecraftPlus.Bows.CallBow.callBow;
import com.codycornell82.minecraftPlus.Event.Achievements2;
import com.codycornell82.minecraftPlus.Event.CookSnailEvent;
import com.codycornell82.minecraftPlus.Event.EndEffect;
import com.codycornell82.minecraftPlus.Event.FindBerryEvent;
import com.codycornell82.minecraftPlus.Event.FindSeedsEvent;
import com.codycornell82.minecraftPlus.Event.FruityEvent;
import com.codycornell82.minecraftPlus.Event.JumpEffect;
import com.codycornell82.minecraftPlus.Event.PotionEvent;
import com.codycornell82.minecraftPlus.Magic.Calling;
import com.codycornell82.minecraftPlus.Magic.EldersVoid;
import com.codycornell82.minecraftPlus.Magic.HopMagic;
import com.codycornell82.minecraftPlus.Magic.NullFire;
import com.codycornell82.minecraftPlus.Magic.SpeedMagic;
import com.codycornell82.minecraftPlus.Magic.ToxicMagic;
import com.codycornell82.minecraftPlus.Magic.Withering;
import com.codycornell82.minecraftPlus.MobHandler.Angel;
import com.codycornell82.minecraftPlus.MobHandler.BeastAI;
import com.codycornell82.minecraftPlus.MobHandler.CallerBoss;
import com.codycornell82.minecraftPlus.MobHandler.Demon;
import com.codycornell82.minecraftPlus.MobHandler.FeralMonster;
import com.codycornell82.minecraftPlus.MobHandler.FireMage;
import com.codycornell82.minecraftPlus.MobHandler.FireZombie;
import com.codycornell82.minecraftPlus.MobHandler.GreenMobAI;
import com.codycornell82.minecraftPlus.MobHandler.HumanEntity;
import com.codycornell82.minecraftPlus.MobHandler.InvisMobAi;
import com.codycornell82.minecraftPlus.MobHandler.MagicAI;
import com.codycornell82.minecraftPlus.MobHandler.MobHandler;
import com.codycornell82.minecraftPlus.MobHandler.NewEnder;
import com.codycornell82.minecraftPlus.MobHandler.NightStalker;
import com.codycornell82.minecraftPlus.MobHandler.PoisonSnail;
import com.codycornell82.minecraftPlus.MobHandler.Robot;
import com.codycornell82.minecraftPlus.MobHandler.Silver;
import com.codycornell82.minecraftPlus.MobHandler.Snail;
import com.codycornell82.minecraftPlus.MobHandler.SpawnBoss;
import com.codycornell82.minecraftPlus.MobHandler.TNTPig;
import com.codycornell82.minecraftPlus.MobHandler.TameMonsterClass;
import com.codycornell82.minecraftPlus.MobHandler.ToxicMob;
import com.codycornell82.minecraftPlus.MobHandler.Tusk;
import com.codycornell82.minecraftPlus.MobHandler.VillagerMob;
import com.codycornell82.minecraftPlus.MobHandler.hellhound;
import com.codycornell82.minecraftPlus.PowerBlocks.TileEntityInfuser;
import com.codycornell82.minecraftPlus.PowerBlocks.WorkBench;
import com.codycornell82.minecraftPlus.PowerBlocks.infuser;
import com.codycornell82.minecraftPlus.World.Biomes.biomesMP;
import com.codycornell82.minecraftPlus.World.Biomes.feature.MPLeaves;
import com.codycornell82.minecraftPlus.World.Biomes.feature.MPLogs;
import com.codycornell82.minecraftPlus.World.Biomes.feature.MPSapling;
import com.codycornell82.minecraftPlus.net.CommonProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "mp", name = "Minecraft Expanded", version = "2.5")
public class MinecraftPlus {

	public static Item itemGreyGem;
	public static Item fuelCan;
	public static Item steel;
	public static Item fuelTank;
	public static Item grayPower;
	public static Item CobaltBar;
	public static Item ToxicGem;
	public static Item FarBar;
	public static Item FarNug;
	public static Item Visber;
	public static Item VisberArrow;
	public static Item CallerSkin;
	public static Item Powder;
	public static Item RedQuartz;
	public static Item SilverIngot;
	public static Item TransformationWand;
	public static Item CureStone;
	public static Item VoidPowder;
	public static Item BloodEye;
	public static Item CopperIngot;
	public static Item TinIngot;

	public static Block blockGreyGem;
	public static Block bush;
	public static Block woodrootPlant;
	public static Block CobaltOre;
	public static Block SteelBlock;
	public static Block CobaltBlock;
	public static Block Log;
	public static Block leaf;
	public static Block Sapling;
	public static Block SilverPlank;
	public static Block ToxicBlock;
	public static Block FarlandOre;
	public static Block FarlandBlock;
	public static Block WorkBench;
	public static Block boss;
	public static Block RedOre;
	public static Block SilverOre;
	public static Block SilverSpawn;
	public static Block SilverBlock;
	public static Block DustBlock;
	public static Block LampUnlit;
	public static Block LampLit;
	public static Block berryPlant;
	public static Block MakeSpawn;
	public static Block XrayGlass;
	public static Block CopperOre;
	public static Block TinOre;
	public static Block CopperBlock;
	public static Block TinBlock;

	public static Block infuserOff;
	public static Block infuserOn;
	public static final int guiIDInfuser = 1;
	public static final int guiIDWorkBench = 2;

	public static Item GrayAxe;
	public static Item GrayPick;
	public static Item GrayHoe;
	public static Item GrayShovel;
	public static Item GraySword;
	public static Item SteelAxe;
	public static Item SteelPick;
	public static Item SteelHoe;
	public static Item SteelShovel;
	public static Item SteelSword;
	public static Item CobaltAxe;
	public static Item CobaltPick;
	public static Item CobaltHoe;
	public static Item CobaltShovel;
	public static Item CobaltSword;
	public static Item CallBow;
	public static Item SwordNew;
	public static Item ToxicSword;
	public static Item FireSword;
	public static Item SilverAxe;
	public static Item SilverPick;
	public static Item SilverHoe;
	public static Item SilverShovel;
	public static Item SilverSword;
	public static Item VisberSword;
	public static Item CopperAxe;
	public static Item CopperPick;
	public static Item CopperHoe;
	public static Item CopperShovel;
	public static Item CopperSword;
	public static Item TinAxe;
	public static Item TinPick;
	public static Item TinHoe;
	public static Item TinShovel;
	public static Item TinSword;

	public static Item GrayHelmet;
	public static Item GrayChestplate;
	public static Item GrayLeggings;
	public static Item GrayBoots;
	public static Item SteelHelmet;
	public static Item SteelChestplate;
	public static Item SteelLeggings;
	public static Item SteelBoots;
	public static Item CobaltHelmet;
	public static Item CobaltChestplate;
	public static Item CobaltLeggings;
	public static Item CobaltBoots;
	public static Item NewHead;
	public static Item NewChest;
	public static Item NewLegs;
	public static Item NewBoot;
	public static Item SilverHelm;
	public static Item SilverChest;
	public static Item SilverLegs;
	public static Item SilverBoots;
	public static Item BoneHelmet;
	public static Item BoneChestplate;
	public static Item BoneLeggings;
	public static Item BoneBoots;
	public static Item ZombieHelmet;
	public static Item ZombieChestplate;
	public static Item ZombieLeggings;
	public static Item ZombieBoots;
	public static Item CopperHelmet;
	public static Item CopperChestplate;
	public static Item CopperLeggings;
	public static Item CopperBoots;
	public static Item TinHelmet;
	public static Item TinChestplate;
	public static Item TinLeggings;
	public static Item TinBoots;

	public static Item berry;
	public static Item woodroot;
	public static Item snail;
	public static Item snailCooked;
	public static Item woodrootSoup;
	public static Item FruitJuice;
	public static Item FruitCake;

	public static Item woodrootSeed;
	public static Item berrySeed;

	public static Potion Toxic;
	public static Potion Jump;
	public static Potion End;

	public static final Item.ToolMaterial Gray = EnumHelper.addToolMaterial(
			"Gray", 3, 1561, 6.0f, 2.0f, 30);
	public static final ItemArmor.ArmorMaterial GrayArmor = EnumHelper
			.addArmorMaterial("GrayArmor", 1561, new int[] { 2, 7, 5, 3 }, 30);
	public static final Item.ToolMaterial Steel = EnumHelper.addToolMaterial(
			"Steel", 3, 1561, 6.5f, 3.0f, 30);
	public static final ItemArmor.ArmorMaterial SteelArmor = EnumHelper
			.addArmorMaterial("SteelArmor", 1561, new int[] { 3, 8, 6, 4 }, 30);
	public static final Item.ToolMaterial Cobalt = EnumHelper.addToolMaterial(
			"Cobalt", 3, 1600, 6.5f, 3.0f, 30);
	public static final ItemArmor.ArmorMaterial CobaltArmor = EnumHelper
			.addArmorMaterial("CobaltArmor", 1600, new int[] { 3, 8, 6, 4 }, 30);
	public static final Item.ToolMaterial Destroyer = EnumHelper
			.addToolMaterial("Destroyer", 3, 2000, 7.5f, 56.0f, 30);
	public static final ItemArmor.ArmorMaterial DestroyerArmor = EnumHelper
			.addArmorMaterial("DestroyerArmor", 1600, new int[] { 30, 35, 33,
					31 }, 30);
	public static final Item.ToolMaterial ToxicTool = EnumHelper
			.addToolMaterial("ToxicTool", 1, 200, 7.5f, -2.0f, 30);
	public static final Item.ToolMaterial Wand = EnumHelper.addToolMaterial(
			"Wand", 1, 1000, 0.5f, 0.5f, 0);
	public static final Item.ToolMaterial FireTool = EnumHelper
			.addToolMaterial("FireTool", 1, 200, 7.5f, 26.0f, 30);
	public static final ItemArmor.ArmorMaterial SilverArmor = EnumHelper
			.addArmorMaterial("SilverArmor", 15, new int[] { 2, 6, 5, 2 }, 30);
	public static final Item.ToolMaterial Silver = EnumHelper.addToolMaterial(
			"Silver", 2, 250, 6.0F, 2.0F, 30);
	public static final Item.ToolMaterial VisberTool = EnumHelper
			.addToolMaterial("VisberTool", 3, 1000, 6.0f, 36.0f, 30);
	public static final ItemArmor.ArmorMaterial BoneArmor = EnumHelper
			.addArmorMaterial("BoneArmor", 10, new int[] { 1, 3, 2, 1 }, 30);

	@Instance("mp")
	public static MinecraftPlus instance;

	@SidedProxy(clientSide = "com.codycornell82.minecraftPlus.net.ClientProxy", serverSide = "com.codycornell82.minecraftPlus.net.CommonProxy")
	public static CommonProxy plusProxy;

	// Enchanting
	public static final Enchantment nullFire = new NullFire(100, 5);
	public static final Enchantment hopMagic = new HopMagic(101, 5);
	public static final Enchantment speedMagic = new SpeedMagic(102, 5);
	public static final Enchantment withering = new Withering(99, 5);
	public static final Enchantment calling = new Calling(98, 5);
	public static final Enchantment eldersvoid = new EldersVoid(97, 5);
	public static final Enchantment toxicMagic = new ToxicMagic(96, 5);

	// Achievements
	public static Achievement DemonHunter;
	public static Achievement FallenAngel;
	public static Achievement BarryAllen;
	public static Achievement Fruity;
	public static Achievement JustAddSalt;
	public static Achievement Escargot;
	public static Achievement ThatsAStart;
	public static Achievement Harvest;
	public static Achievement Dinner;
	public static Achievement ToxicFumes;
	public static Achievement ToxicAttack;
	public static Achievement ItJustChanged;
	public static Achievement EvenMoreToxic;
	public static Achievement FuelTheFire;
	public static Achievement ItsTheEnd;
	public static Achievement Red;
	public static Achievement Shiny;
	public static Achievement Village;
	public static Achievement OP;
	public static Achievement Firewatch;
	public static Achievement IWasPeaceful;
	public static Achievement MotherNaturesSon;
	public static Achievement Lie2;
	public static Achievement Inferno;
	public static Achievement BiggerDemons;
	public static Achievement Cure;
	public static Achievement HeavyMetal;
	public static Achievement WhatKindOfBlackMagicIsThis;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Item/Block init and register
		// Config Handling
		biomesMP.init();

		itemGreyGem = new ItemGreyGem().setUnlocalizedName("ItemGrayGem")
				.setTextureName("mp:itemgreygem").setCreativeTab(ModItems);
		fuelCan = new fuelCan().setUnlocalizedName("FuelCan")
				.setTextureName("mp:fuelCan").setCreativeTab(ModItems);
		steel = new steel().setUnlocalizedName("Steel")
				.setTextureName("mp:steelBar").setCreativeTab(ModItems);
		grayPower = new grayPower().setUnlocalizedName("GrayPower")
				.setTextureName("mp:GrayPower").setCreativeTab(ModItems);
		fuelTank = new fuelTank().setUnlocalizedName("FuelTank")
				.setTextureName("mp:fuelTank").setCreativeTab(ModItems);
		CobaltBar = new CobaltBar().setUnlocalizedName("CobaltBar")
				.setTextureName("mp:CobaltBar").setCreativeTab(ModItems);
		ToxicGem = new ToxicGem().setUnlocalizedName("ToxicGem")
				.setTextureName("mp:ToxicGem").setCreativeTab(ModItems);
		FarBar = new FarIngot().setUnlocalizedName("FarBar")
				.setTextureName("mp:FarBar").setCreativeTab(ModItems);
		FarNug = new FarNugget().setUnlocalizedName("FarNug")
				.setTextureName("mp:farNug").setCreativeTab(ModItems);
		Visber = new Visber().setUnlocalizedName("Visber")
				.setTextureName("mp:Visber").setCreativeTab(ModItems);
		VisberArrow = new VisberArrow().setUnlocalizedName("VisberArrow")
				.setTextureName("mp:VisberArrow").setCreativeTab(ModItems);
		CallerSkin = new CallerSkin().setUnlocalizedName("CallerSkin")
				.setTextureName("mp:CallerSkin").setCreativeTab(ModItems);
		Powder = new Powder().setUnlocalizedName("Powder")
				.setTextureName("mp:Powder").setCreativeTab(ModMisc);
		RedQuartz = new RedQ().setUnlocalizedName("RedQuartz")
				.setTextureName("mp:RedQuartz").setCreativeTab(ModItems);
		SilverIngot = new SilverBarItem().setUnlocalizedName("SilverBar")
				.setTextureName("mp:SilverBar").setCreativeTab(ModItems);
		CopperIngot = new SilverBarItem().setUnlocalizedName("CopperIngot")
				.setTextureName("mp:CopperIngot").setCreativeTab(ModItems);
		TinIngot = new SilverBarItem().setUnlocalizedName("TinIngot")
				.setTextureName("mp:TinIngot").setCreativeTab(ModItems);
		TransformationWand = new TransformationWand(Wand)
				.setUnlocalizedName("TransformationWand")
				.setTextureName("mp:Transformation Wand")
				.setCreativeTab(ModMisc);
		CureStone = new CureStone().setUnlocalizedName("CureStone")
				.setTextureName("mp:CureStone").setCreativeTab(ModItems);
		VoidPowder = new VoidPowder().setUnlocalizedName("VoidPowder")
				.setTextureName("mp:VoidPowder").setCreativeTab(ModItems);

		blockGreyGem = new BlockGreyGem(Material.rock)
				.setBlockName("BlockGrayGem")
				.setBlockTextureName("mp:greystonegemblock")
				.setCreativeTab(ModBlocks);
		bush = new Bush(Material.grass).setBlockName("Bush")
				.setBlockTextureName("mp:plant").setCreativeTab(ModBlocks);
		woodrootPlant = new MPCrop().setBlockName("WoodRootPlant");
		CobaltOre = new CobaltOre(Material.rock).setBlockName("OreCobalt")
				.setBlockTextureName("mp:Cobalt").setCreativeTab(ModBlocks);
		SteelBlock = new BlockGreyGem(Material.rock).setBlockName("SteelBlock")
				.setBlockTextureName("mp:SteelBlock").setCreativeTab(ModBlocks);
		CobaltBlock = new BlockGreyGem(Material.rock)
				.setBlockName("CobaltBlock")
				.setBlockTextureName("mp:CobaltBlock")
				.setCreativeTab(ModBlocks);
		CopperBlock = new BlockGreyGem(Material.rock)
				.setBlockName("CopperBlock")
				.setBlockTextureName("mp:CopperBlock")
				.setCreativeTab(ModBlocks);
		TinBlock = new BlockGreyGem(Material.rock).setBlockName("TinBlock")
				.setBlockTextureName("mp:TinBlock").setCreativeTab(ModBlocks);
		Log = new MPLogs().setBlockName("Log").setCreativeTab(ModBlocks);
		leaf = new MPLeaves().setBlockName("Leaf").setCreativeTab(ModBlocks);
		Sapling = new MPSapling().setBlockName("Sapling").setCreativeTab(
				ModMisc);
		SilverPlank = new MPPlank().setBlockName("SilverPlank")
				.setBlockTextureName("mp:SilverPlank")
				.setCreativeTab(ModBlocks);
		ToxicBlock = new ToxicBlock(Material.rock).setBlockName("ToxicBlock")
				.setBlockTextureName("mp:ToxicBlock").setCreativeTab(ModBlocks);
		FarlandOre = new FarlandOre(Material.rock).setBlockName("FarlandOre")
				.setBlockTextureName("mp:FarlandOre").setCreativeTab(ModBlocks);
		FarlandBlock = new BlockGreyGem(Material.rock)
				.setBlockName("FarlandBlock")
				.setBlockTextureName("mp:farBlock").setCreativeTab(ModBlocks);
		boss = new bossBlock(Material.anvil).setBlockName("boss")
				.setBlockTextureName("mp:boss").setCreativeTab(ModMisc);
		RedOre = new RedOre(Material.rock).setBlockName("RedQuartzOre")
				.setBlockTextureName("mp:RedQuartzOre")
				.setCreativeTab(ModBlocks);
		SilverOre = new SilverOre(Material.rock).setBlockName("SilverOre")
				.setBlockTextureName("mp:SilverOre").setCreativeTab(ModBlocks);
		SilverSpawn = new SilverSpawn(Material.anvil)
				.setBlockName("SilverSpawn")
				.setBlockTextureName("mp:SilverGuardSpawner")
				.setCreativeTab(ModMisc);
		SilverBlock = new SilverBlock(Material.rock)
				.setBlockName("SilverBlock")
				.setBlockTextureName("mp:SilverBlock")
				.setCreativeTab(ModBlocks);
		DustBlock = new Dust(Material.sand).setBlockName("Dust")
				.setBlockTextureName("mp:Dust").setCreativeTab(ModBlocks);
		LampUnlit = new lampUnlit(Material.cloth).setBlockName("LampUnlit")
				.setBlockTextureName("mp:LampUnlit").setCreativeTab(ModBlocks);
		LampLit = new lampLit(Material.cloth).setBlockName("LampLit")
				.setBlockTextureName("mp:LampLit").setCreativeTab(ModBlocks);
		berryPlant = new BerryCrop().setBlockName("BerryPlant");
		MakeSpawn = new MakeSpawn(Material.rock).setBlockName("MakeSpawn")
				.setBlockTextureName("mp:SpawnSpawn").setCreativeTab(ModMisc);
		XrayGlass = new XrayGlass(Material.sand).setBlockName("XrayGlass")
				.setBlockTextureName("mp:XRAY").setCreativeTab(ModBlocks);
		CopperOre = new SilverOre(Material.rock).setBlockName("CopperOre")
				.setBlockTextureName("mp:CopperOre").setCreativeTab(ModBlocks);
		TinOre = new SilverOre(Material.rock).setBlockName("TinOre")
				.setBlockTextureName("mp:TinOre").setCreativeTab(ModBlocks);

		GraySword = new Graysword(Gray).setUnlocalizedName("Graysword")
				.setTextureName("mp:GraySword").setCreativeTab(ModItems);
		GrayPick = new GrayPick(Gray).setUnlocalizedName("Graypick")
				.setTextureName("mp:GrayPick").setCreativeTab(ModItems);
		GrayAxe = new Grayaxe(Gray).setUnlocalizedName("Grayaxe")
				.setTextureName("mp:GrayAxe").setCreativeTab(ModItems);
		GrayHoe = new Grayhoe(Gray).setUnlocalizedName("Grayhoe")
				.setTextureName("mp:GrayHoe").setCreativeTab(ModItems);
		GrayShovel = new Grayshovel(Gray).setUnlocalizedName("Grayshovel")
				.setTextureName("mp:GrayShovel").setCreativeTab(ModItems);
		SteelSword = new Steelsword(Steel).setUnlocalizedName("Steelsword")
				.setTextureName("mp:dark_sword").setCreativeTab(ModItems);
		SteelPick = new SteelPick(Steel).setUnlocalizedName("Steelpick")
				.setTextureName("mp:dark_pickaxe").setCreativeTab(ModItems);
		SteelAxe = new Steelaxe(Steel).setUnlocalizedName("Steelaxe")
				.setTextureName("mp:dark_axe").setCreativeTab(ModItems);
		SteelHoe = new Steelhoe(Steel).setUnlocalizedName("Steelhoe")
				.setTextureName("mp:dark_hoe").setCreativeTab(ModItems);
		SteelShovel = new Steelshovel(Steel).setUnlocalizedName("Steelshovel")
				.setTextureName("mp:dark_shovel").setCreativeTab(ModItems);
		CobaltShovel = new cobaltShovel(Cobalt)
				.setUnlocalizedName("Cobaltshovel")
				.setTextureName("mp:cobalt_shovel").setCreativeTab(ModItems);
		CobaltPick = new cobaltPickaxe(Cobalt).setUnlocalizedName("Cobaltpick")
				.setTextureName("mp:cobalt_pickaxe").setCreativeTab(ModItems);
		CobaltSword = new cobaltSword(Cobalt).setUnlocalizedName("Cobaltsword")
				.setTextureName("mp:cobalt_sword").setCreativeTab(ModItems);
		CobaltHoe = new cobaltHoe(Cobalt).setUnlocalizedName("Cobalthoe")
				.setTextureName("mp:cobalt_hoe").setCreativeTab(ModItems);
		CobaltAxe = new cobaltAxe(Cobalt).setUnlocalizedName("Cobaltaxe")
				.setTextureName("mp:cobalt_axe").setCreativeTab(ModItems);
		CallBow = new callBow().setUnlocalizedName("CallBow").setCreativeTab(
				ModItems);
		SwordNew = new Destroyer(Destroyer).setUnlocalizedName("Destroyer")
				.setTextureName("mp:SwordNew").setCreativeTab(ModItems);
		ToxicSword = new ToxicSword(ToxicTool).setUnlocalizedName("ToxicSword")
				.setTextureName("mp:ToxicSword").setCreativeTab(ModItems);
		FireSword = new FireBlade(FireTool).setUnlocalizedName("FireSword")
				.setTextureName("mp:FireSword").setCreativeTab(ModItems);
		SilverShovel = new cobaltShovel(Silver)
				.setUnlocalizedName("Silvershovel")
				.setTextureName("mp:silver_shovel").setCreativeTab(ModItems);
		SilverPick = new cobaltPickaxe(Silver).setUnlocalizedName("Silverpick")
				.setTextureName("mp:silver_pickaxe").setCreativeTab(ModItems);
		SilverSword = new cobaltSword(Silver).setUnlocalizedName("Silversword")
				.setTextureName("mp:silver_sword").setCreativeTab(ModItems);
		SilverHoe = new cobaltHoe(Silver).setUnlocalizedName("Silverhoe")
				.setTextureName("mp:silver_hoe").setCreativeTab(ModItems);
		SilverAxe = new cobaltAxe(Silver).setUnlocalizedName("Silveraxe")
				.setTextureName("mp:silver_axe").setCreativeTab(ModItems);
		VisberSword = new visberSword(VisberTool)
				.setUnlocalizedName("VisberSword")
				.setTextureName("mp:VisberSword").setCreativeTab(ModItems);
		CopperSword = new cobaltSword(Item.ToolMaterial.GOLD)
				.setUnlocalizedName("Coppersword")
				.setTextureName("mp:CopperSword").setCreativeTab(ModItems);
		CopperPick = new cobaltPickaxe(Item.ToolMaterial.GOLD)
				.setUnlocalizedName("Copperpick")
				.setTextureName("mp:CopperPick").setCreativeTab(ModItems);
		CopperAxe = new cobaltAxe(Item.ToolMaterial.GOLD)
				.setUnlocalizedName("Copperaxe").setTextureName("mp:CopperAxe")
				.setCreativeTab(ModItems);
		CopperHoe = new cobaltHoe(Item.ToolMaterial.GOLD)
				.setUnlocalizedName("Copperhoe").setTextureName("mp:CopperHoe")
				.setCreativeTab(ModItems);
		CopperShovel = new cobaltShovel(Item.ToolMaterial.GOLD)
				.setUnlocalizedName("Coppershovel")
				.setTextureName("mp:CopperShovel").setCreativeTab(ModItems);
		TinSword = new cobaltSword(Item.ToolMaterial.IRON)
				.setUnlocalizedName("Tinsword").setTextureName("mp:TinSword")
				.setCreativeTab(ModItems);
		TinPick = new cobaltPickaxe(Item.ToolMaterial.IRON)
				.setUnlocalizedName("Tinpick").setTextureName("mp:TinPick")
				.setCreativeTab(ModItems);
		TinAxe = new cobaltAxe(Item.ToolMaterial.IRON)
				.setUnlocalizedName("Tinaxe").setTextureName("mp:TinAxe")
				.setCreativeTab(ModItems);
		TinHoe = new cobaltHoe(Item.ToolMaterial.IRON)
				.setUnlocalizedName("Tinhoe").setTextureName("mp:TinHoe")
				.setCreativeTab(ModItems);
		TinShovel = new cobaltShovel(Item.ToolMaterial.IRON)
				.setUnlocalizedName("Tinshovel").setTextureName("mp:TinShovel")
				.setCreativeTab(ModItems);

		GrayHelmet = new grayHelmet(GrayArmor, 0, 0)
				.setUnlocalizedName("grayHelmet")
				.setTextureName("mp:GrayHelmet").setCreativeTab(ModItems);
		GrayChestplate = new grayChestplate(GrayArmor, 0, 1)
				.setUnlocalizedName("grayChestplate")
				.setTextureName("mp:GrayChestplate").setCreativeTab(ModItems);
		GrayLeggings = new grayLeggings(GrayArmor, 0, 2)
				.setUnlocalizedName("grayLeggings")
				.setTextureName("mp:GrayLeggings").setCreativeTab(ModItems);
		GrayBoots = new grayBoots(GrayArmor, 0, 3)
				.setUnlocalizedName("grayBoots").setTextureName("mp:GrayBoots")
				.setCreativeTab(ModItems);
		SteelHelmet = new SteelArmor(SteelArmor, 0, 0)
				.setUnlocalizedName("steelHelmet")
				.setTextureName("mp:dark_helmet").setCreativeTab(ModItems);
		SteelChestplate = new SteelArmor(SteelArmor, 0, 1)
				.setUnlocalizedName("steelChestplate")
				.setTextureName("mp:dark_chestplate").setCreativeTab(ModItems);
		SteelLeggings = new SteelArmor(SteelArmor, 0, 2)
				.setUnlocalizedName("steelLeggings")
				.setTextureName("mp:dark_leggings").setCreativeTab(ModItems);
		SteelBoots = new SteelArmor(SteelArmor, 0, 3)
				.setUnlocalizedName("steelBoots")
				.setTextureName("mp:dark_boots").setCreativeTab(ModItems);
		CobaltHelmet = new CobaltArmor(CobaltArmor, 0, 0)
				.setUnlocalizedName("CobaltHelmet")
				.setTextureName("mp:cobalt_helmet").setCreativeTab(ModItems);
		CobaltChestplate = new CobaltArmor(CobaltArmor, 0, 1)
				.setUnlocalizedName("CobaltChestplate")
				.setTextureName("mp:cobalt_chestplate")
				.setCreativeTab(ModItems);
		CobaltLeggings = new CobaltArmor(CobaltArmor, 0, 2)
				.setUnlocalizedName("CobaltLeggings")
				.setTextureName("mp:cobalt_leggings").setCreativeTab(ModItems);
		CobaltBoots = new CobaltArmor(CobaltArmor, 0, 3)
				.setUnlocalizedName("CobaltBoots")
				.setTextureName("mp:cobalt_boots").setCreativeTab(ModItems);
		NewHead = new DestroyerArmor(DestroyerArmor, 0, 0)
				.setUnlocalizedName("DestroyerHead")
				.setTextureName("mp:New_Head").setCreativeTab(ModItems);
		NewChest = new DestroyerArmor(DestroyerArmor, 0, 1)
				.setUnlocalizedName("DestroyerChest")
				.setTextureName("mp:New_Chest").setCreativeTab(ModItems);
		NewLegs = new DestroyerArmor(DestroyerArmor, 0, 2)
				.setUnlocalizedName("DestroyerLegs")
				.setTextureName("mp:New_Legs").setCreativeTab(ModItems);
		NewBoot = new DestroyerArmor(DestroyerArmor, 0, 3)
				.setUnlocalizedName("DestroyerBoots")
				.setTextureName("mp:New_Boot").setCreativeTab(ModItems);
		SilverHelm = new SilverArmor(SilverArmor, 0, 0)
				.setUnlocalizedName("SilverHelm")
				.setTextureName("mp:silver_helmet").setCreativeTab(ModItems);
		SilverChest = new SilverArmor(SilverArmor, 0, 1)
				.setUnlocalizedName("SilverChest")
				.setTextureName("mp:silver_chestplate")
				.setCreativeTab(ModItems);
		SilverLegs = new SilverArmor(SilverArmor, 0, 2)
				.setUnlocalizedName("SilverLegs")
				.setTextureName("mp:silver_leggings").setCreativeTab(ModItems);
		SilverBoots = new SilverArmor(SilverArmor, 0, 3)
				.setUnlocalizedName("SilverBoots")
				.setTextureName("mp:silver_boots").setCreativeTab(ModItems);
		BoneHelmet = new BoneArmor(BoneArmor, 0, 0)
				.setUnlocalizedName("BoneHelm")
				.setTextureName("mp:bone_helmet").setCreativeTab(ModItems);
		BoneChestplate = new BoneArmor(BoneArmor, 0, 1)
				.setUnlocalizedName("BoneChest")
				.setTextureName("mp:bone_chestplate").setCreativeTab(ModItems);
		BoneLeggings = new BoneArmor(BoneArmor, 0, 2)
				.setUnlocalizedName("BoneLegs")
				.setTextureName("mp:bone_leggings").setCreativeTab(ModItems);
		BoneBoots = new BoneArmor(BoneArmor, 0, 3)
				.setUnlocalizedName("BoneBoots")
				.setTextureName("mp:bone_boots").setCreativeTab(ModItems);
		ZombieHelmet = new ZombieArmor(BoneArmor, 0, 0)
				.setUnlocalizedName("ZombieHelm")
				.setTextureName("mp:zombie_helmet").setCreativeTab(ModItems);
		ZombieChestplate = new ZombieArmor(BoneArmor, 0, 1)
				.setUnlocalizedName("ZombieChest")
				.setTextureName("mp:zombie_chestplate")
				.setCreativeTab(ModItems);
		ZombieLeggings = new ZombieArmor(BoneArmor, 0, 2)
				.setUnlocalizedName("ZombieLegs")
				.setTextureName("mp:zombie_leggings").setCreativeTab(ModItems);
		ZombieBoots = new ZombieArmor(BoneArmor, 0, 3)
				.setUnlocalizedName("ZombieBoots")
				.setTextureName("mp:zombie_boots").setCreativeTab(ModItems);
		CopperHelmet = new CopperArmor(ItemArmor.ArmorMaterial.GOLD, 0, 0)
				.setUnlocalizedName("CopperHelm")
				.setTextureName("mp:copper_helmet").setCreativeTab(ModItems);
		CopperChestplate = new CopperArmor(ItemArmor.ArmorMaterial.GOLD, 0, 1)
				.setUnlocalizedName("CopperChest")
				.setTextureName("mp:copper_chestplate")
				.setCreativeTab(ModItems);
		CopperLeggings = new CopperArmor(ItemArmor.ArmorMaterial.GOLD, 0, 2)
				.setUnlocalizedName("CopperLegs")
				.setTextureName("mp:copper_leggings").setCreativeTab(ModItems);
		CopperBoots = new CopperArmor(ItemArmor.ArmorMaterial.GOLD, 0, 3)
				.setUnlocalizedName("CopperBoots")
				.setTextureName("mp:copper_boots").setCreativeTab(ModItems);
		TinHelmet = new TinArmor(ItemArmor.ArmorMaterial.IRON, 0, 0)
				.setUnlocalizedName("TinHelm").setTextureName("mp:tin_helmet")
				.setCreativeTab(ModItems);
		TinChestplate = new TinArmor(ItemArmor.ArmorMaterial.IRON, 0, 1)
				.setUnlocalizedName("TinChest")
				.setTextureName("mp:tin_chestplate").setCreativeTab(ModItems);
		TinLeggings = new TinArmor(ItemArmor.ArmorMaterial.IRON, 0, 2)
				.setUnlocalizedName("TinLegs")
				.setTextureName("mp:tin_leggings").setCreativeTab(ModItems);
		TinBoots = new TinArmor(ItemArmor.ArmorMaterial.IRON, 0, 3)
				.setUnlocalizedName("TinBoots").setTextureName("mp:tin_boots")
				.setCreativeTab(ModItems);

		berry = new ItemFood(1, 0.5f, true).setUnlocalizedName("Berry")
				.setTextureName("mp:berry").setCreativeTab(ModItems);
		woodroot = new ItemFood(6, 1.0f, false).setUnlocalizedName("WoodRoot")
				.setTextureName("mp:WoodRootFood").setCreativeTab(ModItems);
		snail = new ItemFood(1, 0.2f, true).setUnlocalizedName("RawSnail")
				.setTextureName("mp:RawSnail").setCreativeTab(ModItems);
		snailCooked = new ItemFood(4, 0.5f, true)
				.setUnlocalizedName("CookedSnail")
				.setTextureName("mp:CookedSnail").setCreativeTab(ModItems);
		woodrootSoup = new ItemFood(10, 1.0f, true)
				.setUnlocalizedName("WoodrootSoup")
				.setTextureName("mp:WoodrootSoup").setCreativeTab(ModItems)
				.setMaxStackSize(1);
		FruitJuice = new ItemFood(5, 1.0f, true)
				.setUnlocalizedName("FruitJuice")
				.setTextureName("mp:FruitJuice").setCreativeTab(ModItems);
		FruitCake = new ItemFood(20, 1.0f, true)
				.setUnlocalizedName("FruitCake").setTextureName("mp:BerryCake")
				.setCreativeTab(ModItems);
		BloodEye = new BloodEye().setUnlocalizedName("BloodEye")
				.setTextureName("mp:RedEye").setCreativeTab(ModItems);

		woodrootSeed = new ItemSeeds(woodrootPlant, Blocks.farmland)
				.setUnlocalizedName("WoodRootSeed")
				.setTextureName("mp:seed_new").setCreativeTab(ModMisc);
		berrySeed = new ItemSeeds(berryPlant, Blocks.farmland)
				.setUnlocalizedName("BerrySeed").setTextureName("mp:berrySeed")
				.setCreativeTab(ModMisc);

		infuserOff = new infuser(false).setBlockName("infuseroff")
				.setCreativeTab(ModBlocks).setHardness(2.0f)
				.setResistance(15.0f);
		infuserOn = new infuser(true).setBlockName("infuseron")
				.setHardness(2.0f).setResistance(15.0f).setLightLevel(0.625f);
		WorkBench = new WorkBench().setBlockName("WorkBench").setCreativeTab(
				ModBlocks);

		Toxic = new ToxicEffect(30, true, 0).setIconIndex(0, 0).setPotionName(
				"potion.Toxic");
		Jump = new Jumpy(31, true, 0).setIconIndex(0, 1).setPotionName(
				"potion.Jump");
		End = new End(29, true, 0).setIconIndex(0, 2).setPotionName(
				"potion.End");

		// Main Registry

		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		GameRegistry.registerItem(itemGreyGem, itemGreyGem.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(blockGreyGem, blockGreyGem
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(GrayAxe, GrayAxe.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(GrayPick, GrayPick.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(GrayHoe, GrayHoe.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(GrayShovel, GrayShovel.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(GraySword, GraySword.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(GrayHelmet, GrayHelmet.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(GrayChestplate, GrayChestplate
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(GrayLeggings, GrayLeggings
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(GrayBoots, GrayBoots.getUnlocalizedName()
				.substring(5));
		GameRegistry
				.registerBlock(bush, bush.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(berry, berry.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(woodroot, woodroot.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(woodrootSeed, woodrootSeed
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(woodrootPlant, woodrootPlant
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(infuserOff, infuserOff.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(infuserOn, infuserOn.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(fuelCan, fuelCan.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(steel, steel.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(fuelTank, fuelTank.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(grayPower, grayPower.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(snail, snail.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(snailCooked, snailCooked.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerWorldGenerator(new BushPlacer(), 0);
		MinecraftForge.addGrassSeed(new ItemStack(woodrootSeed), 5);
		GameRegistry.addSmelting(snail, new ItemStack(snailCooked), 0.0f);
		GameRegistry.registerItem(SteelAxe, SteelAxe.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SteelSword, SteelSword.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SteelPick, SteelPick.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SteelHoe, SteelHoe.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SteelShovel, SteelShovel.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SteelBoots, SteelBoots.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SteelLeggings, SteelLeggings
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(SteelChestplate, SteelChestplate
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(SteelHelmet, SteelHelmet.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(CobaltOre, CobaltOre.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(CobaltBar, CobaltBar.getUnlocalizedName()
				.substring(5));
		GameRegistry.addSmelting(CobaltOre, new ItemStack(CobaltBar), 3.0f);
		GameRegistry.registerBlock(SteelBlock, SteelBlock.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(CobaltBlock, CobaltBlock
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(CopperBlock, CopperBlock
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(TinBlock, TinBlock.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(CobaltAxe, CobaltAxe.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(CobaltSword, CobaltSword.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(CobaltPick, CobaltPick.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(CobaltHoe, CobaltHoe.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(CobaltShovel, CobaltShovel
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(CobaltBoots, CobaltBoots.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(CobaltLeggings, CobaltLeggings
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(CobaltChestplate, CobaltChestplate
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(CobaltHelmet, CobaltHelmet
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(Log, ItemBlockLogs.class, Log
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(leaf, ItemLeafBlocks.class, leaf
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(Sapling, ItemSaplingBlock.class, Sapling
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(SilverPlank, SilverPlank
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(CopperIngot, CopperIngot.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(TinIngot, TinIngot.getUnlocalizedName()
				.substring(5));
		MinecraftForge.EVENT_BUS.register(new PotionEvent());
		GameRegistry.registerItem(ToxicGem, ToxicGem.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(ToxicBlock, ToxicBlock.getUnlocalizedName()
				.substring(5));
		MinecraftForge.EVENT_BUS.register(new JumpEffect());
		GameRegistry.registerBlock(FarlandOre, FarlandOre.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(FarBar, FarBar.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(FarNug, FarNug.getUnlocalizedName()
				.substring(5));
		GameRegistry.addSmelting(FarlandOre, new ItemStack(FarBar), 3.0f);
		GameRegistry.registerBlock(FarlandBlock, FarlandBlock
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Visber, Visber.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(WorkBench, WorkBench.getUnlocalizedName()
				.substring(5));
		GameRegistry
				.registerBlock(boss, boss.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(CallBow, CallBow.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(VisberArrow, VisberArrow.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(CallerSkin, CallerSkin.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(Powder, Powder.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(RedQuartz, RedQuartz.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(RedOre, RedOre.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SwordNew, SwordNew.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(NewBoot, NewBoot.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(NewLegs, NewLegs.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(NewChest, NewChest.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(NewHead, NewHead.getUnlocalizedName()
				.substring(5));
		MinecraftForge.EVENT_BUS.register(new EndEffect());
		GameRegistry.registerItem(ToxicSword, ToxicSword.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SilverIngot, SilverIngot.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(SilverOre, SilverOre.getUnlocalizedName()
				.substring(5));
		GameRegistry.addSmelting(Log, new ItemStack(SilverIngot), 0.0f);
		GameRegistry.addSmelting(SilverOre, new ItemStack(SilverIngot), 1.5f);
		GameRegistry.registerBlock(SilverSpawn, SilverSpawn
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(SilverBlock, SilverBlock
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(DustBlock, DustBlock.getUnlocalizedName()
				.substring(5));
		GameRegistry.addSmelting(DustBlock, new ItemStack(Blocks.sandstone),
				1.5f);
		GameRegistry.registerItem(TransformationWand, TransformationWand
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(woodrootSoup, woodrootSoup
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(FruitJuice, FruitJuice.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(LampUnlit, LampUnlit.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(LampLit, LampLit.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(CopperOre, CopperOre.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(TinOre, TinOre.getUnlocalizedName()
				.substring(5));
		FMLCommonHandler.instance().bus().register(new FindBerryEvent());
		FMLCommonHandler.instance().bus().register(new FruityEvent());
		FMLCommonHandler.instance().bus().register(new CookSnailEvent());
		FMLCommonHandler.instance().bus().register(new FindSeedsEvent());
		FMLCommonHandler.instance().bus().register(new Achievements2());
		GameRegistry.registerItem(FruitCake, FruitCake.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(berryPlant, berryPlant.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(berrySeed, berrySeed.getUnlocalizedName()
				.substring(5));
		MinecraftForge.addGrassSeed(new ItemStack(berrySeed), 5);
		GameRegistry.registerItem(CureStone, CureStone.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(MakeSpawn, MakeSpawn.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(FireSword, FireSword.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(VoidPowder, VoidPowder.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SilverBoots, SilverBoots.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SilverLegs, SilverLegs.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SilverChest, SilverChest.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SilverHelm, SilverHelm.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SilverAxe, SilverAxe.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SilverSword, SilverSword.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SilverPick, SilverPick.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SilverHoe, SilverHoe.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(SilverShovel, SilverShovel
				.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(XrayGlass, XrayGlass.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(BloodEye, BloodEye.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(VisberSword, VisberSword.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(BoneBoots, BoneBoots.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(BoneLeggings, BoneLeggings
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(BoneChestplate, BoneChestplate
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(BoneHelmet, BoneHelmet.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(ZombieBoots, ZombieBoots.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(ZombieLeggings, ZombieLeggings
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ZombieChestplate, ZombieChestplate
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ZombieHelmet, ZombieHelmet
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(CopperAxe, CopperAxe.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(CopperSword, CopperSword.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(CopperPick, CopperPick.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(CopperHoe, CopperHoe.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(CopperShovel, CopperShovel
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(CopperBoots, CopperBoots.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(CopperLeggings, CopperLeggings
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(CopperChestplate, CopperChestplate
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(CopperHelmet, CopperHelmet
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(TinAxe, TinAxe.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(TinSword, TinSword.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(TinPick, TinPick.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(TinHoe, TinHoe.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(TinShovel, TinShovel.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(TinBoots, TinBoots.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(TinLeggings, TinLeggings.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(TinChestplate, TinChestplate
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(TinHelmet, TinHelmet.getUnlocalizedName()
				.substring(5));
		GameRegistry.addSmelting(CopperOre, new ItemStack(CopperIngot), 3.0f);
		GameRegistry.addSmelting(TinOre, new ItemStack(TinIngot), 3.0f);

		// Ore Dictionary Register

		OreDictionary.registerOre("ingotCobalt", MinecraftPlus.CobaltBar);
		OreDictionary.registerOre("oreCobalt", MinecraftPlus.CobaltOre);
		OreDictionary.registerOre("cropBerryBush", MinecraftPlus.bush);
		OreDictionary.registerOre("ingotSteel", MinecraftPlus.steel);
		OreDictionary.registerOre("cropWoodroot", MinecraftPlus.woodrootPlant);
		OreDictionary.registerOre("seedWoodroot", MinecraftPlus.woodrootSeed);
		OreDictionary.registerOre("cropWoodroot", MinecraftPlus.woodroot);
		OreDictionary.registerOre("fuelFuelCan", MinecraftPlus.fuelCan);
		OreDictionary.registerOre("gemGrayStone", MinecraftPlus.itemGreyGem);
		OreDictionary.registerOre("blockGrayStone", MinecraftPlus.blockGreyGem);
		OreDictionary.registerOre("blockCobalt", MinecraftPlus.CobaltBlock);
		OreDictionary.registerOre("blockSteel", MinecraftPlus.SteelBlock);
		OreDictionary.registerOre("craftingInfuser", MinecraftPlus.infuserOn);
		OreDictionary.registerOre("craftingInfuser", MinecraftPlus.infuserOff);
		OreDictionary.registerOre("cropBerry", MinecraftPlus.berry);
		OreDictionary.registerOre("listAllFruit", MinecraftPlus.berry);
		OreDictionary.registerOre("allFruit", MinecraftPlus.berry);
		OreDictionary.registerOre("AllFruit", MinecraftPlus.berry);
		OreDictionary.registerOre("Fruit", MinecraftPlus.berry);
		OreDictionary.registerOre("fruit", MinecraftPlus.berry);
		OreDictionary.registerOre("logWood", MinecraftPlus.Log);
		OreDictionary.registerOre("logsWood", MinecraftPlus.Log);
		OreDictionary.registerOre("leaveLeaf", MinecraftPlus.leaf);
		OreDictionary.registerOre("leafLeaf", MinecraftPlus.leaf);
		OreDictionary.registerOre("leavesLeaf", MinecraftPlus.leaf);
		OreDictionary.registerOre("cropLeaf", MinecraftPlus.leaf);
		OreDictionary.registerOre("cropSapling", MinecraftPlus.Sapling);
		OreDictionary.registerOre("treeSapling", MinecraftPlus.Sapling);
		OreDictionary.registerOre("planksSilver", MinecraftPlus.SilverPlank);
		OreDictionary.registerOre("plankSilver", MinecraftPlus.SilverPlank);
		OreDictionary.registerOre("gemToxic", MinecraftPlus.ToxicGem);
		OreDictionary.registerOre("blockToxic", MinecraftPlus.ToxicBlock);
		OreDictionary.registerOre("oreFarland", MinecraftPlus.FarlandOre);
		OreDictionary.registerOre("ingotFarland", MinecraftPlus.FarBar);
		OreDictionary.registerOre("nuggetFarland", MinecraftPlus.FarNug);
		OreDictionary.registerOre("blockFarland", MinecraftPlus.FarlandBlock);
		OreDictionary.registerOre("ingotVisber", MinecraftPlus.Visber);
		OreDictionary.registerOre("craftingWorkBench", MinecraftPlus.WorkBench);
		OreDictionary.registerOre("dustPowder", MinecraftPlus.Powder);
		OreDictionary.registerOre("powderPowder", MinecraftPlus.Powder);
		OreDictionary.registerOre("Powder", MinecraftPlus.Powder);
		OreDictionary.registerOre("powder", MinecraftPlus.Powder);
		OreDictionary.registerOre("Dust", MinecraftPlus.Powder);
		OreDictionary.registerOre("dust", MinecraftPlus.Powder);
		OreDictionary.registerOre("RedQuartz", MinecraftPlus.RedQuartz);
		OreDictionary.registerOre("redQuartz", MinecraftPlus.RedQuartz);
		OreDictionary.registerOre("Redquartz", MinecraftPlus.RedQuartz);
		OreDictionary.registerOre("QuartzRed", MinecraftPlus.RedQuartz);
		OreDictionary.registerOre("Quartzred", MinecraftPlus.RedQuartz);
		OreDictionary.registerOre("quartzRed", MinecraftPlus.RedQuartz);
		OreDictionary.registerOre("oreRedQuartz", MinecraftPlus.RedOre);
		OreDictionary.registerOre("ingotSilver", MinecraftPlus.SilverIngot);
		OreDictionary.registerOre("oreSilver", MinecraftPlus.SilverOre);
		OreDictionary.registerOre("blockSilver", MinecraftPlus.SilverBlock);
		OreDictionary.registerOre("blockDust", MinecraftPlus.DustBlock);
		OreDictionary.registerOre("Dust", MinecraftPlus.DustBlock);
		OreDictionary.registerOre("dust", MinecraftPlus.DustBlock);
		OreDictionary.registerOre("BlockDust", MinecraftPlus.DustBlock);
		OreDictionary.registerOre("soupWoodroot", MinecraftPlus.woodrootSoup);
		OreDictionary.registerOre("stewWoodroot", MinecraftPlus.woodrootSoup);
		OreDictionary.registerOre("soup", MinecraftPlus.woodrootSoup);
		OreDictionary.registerOre("stew", MinecraftPlus.woodrootSoup);
		OreDictionary.registerOre("Soup", MinecraftPlus.woodrootSoup);
		OreDictionary.registerOre("Stew", MinecraftPlus.woodrootSoup);
		OreDictionary.registerOre("Juice", MinecraftPlus.FruitJuice);
		OreDictionary.registerOre("juice", MinecraftPlus.FruitJuice);
		OreDictionary.registerOre("fruitJuice", MinecraftPlus.FruitJuice);
		OreDictionary.registerOre("FruitJuice", MinecraftPlus.FruitJuice);
		OreDictionary.registerOre("Cake", MinecraftPlus.FruitCake);
		OreDictionary.registerOre("cake", MinecraftPlus.FruitCake);
		OreDictionary.registerOre("seedBerry", MinecraftPlus.berrySeed);
		OreDictionary.registerOre("listAllFruit", Items.apple);
		OreDictionary.registerOre("listAllFruit", Items.melon);
		OreDictionary.registerOre("listAllfruit", Items.melon);
		OreDictionary.registerOre("listAllfruit", Items.apple);
		OreDictionary.registerOre("listAllFruit", MinecraftPlus.berry);
		OreDictionary.registerOre("listAllfruit", MinecraftPlus.berry);
		OreDictionary.registerOre("listAllseed", MinecraftPlus.berrySeed);
		OreDictionary.registerOre("listAllseed", MinecraftPlus.woodrootSeed);
		OreDictionary.registerOre("listAllSeed", MinecraftPlus.berrySeed);
		OreDictionary.registerOre("listAllSeed", MinecraftPlus.woodrootSeed);
		OreDictionary.registerOre("listAllveggie", MinecraftPlus.woodroot);
		OreDictionary.registerOre("listAllVeggie", MinecraftPlus.woodroot);
		OreDictionary.registerOre("oreCopper", MinecraftPlus.CopperOre);
		OreDictionary.registerOre("oreTin", MinecraftPlus.TinOre);
		OreDictionary.registerOre("ingotCopper", MinecraftPlus.CopperIngot);
		OreDictionary.registerOre("ingotTin", MinecraftPlus.TinIngot);
		OreDictionary.registerOre("blockCopper", MinecraftPlus.CopperBlock);
		OreDictionary.registerOre("blockTin", MinecraftPlus.TinBlock);
		plusProxy.registerRenderThings();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Proxy Tile Entity, Entity, GUI And Packet Register
		GameRegistry.registerTileEntity(TileEntityInfuser.class, "infuser");

		// Recipe Registry

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(
						new ItemStack(blockGreyGem, 1),
						new Object[] { "GGG", "GGG", "GGG", 'G', "gemGrayStone" }));

		GameRegistry.addRecipe(new ItemStack(itemGreyGem, 1), new Object[] {
				"RRR", "RSR", "RCR", 'R', Items.redstone, 'S', Blocks.stone,
				'C', CopperIngot });

		GameRegistry.addShapelessRecipe(new ItemStack(itemGreyGem, 9),
				MinecraftPlus.blockGreyGem);

		GameRegistry.addRecipe(new ItemStack(GrayAxe), new Object[] { "GG",
				"GS", " S", 'G', MinecraftPlus.itemGreyGem, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(GraySword), new Object[] { "G",
				"G", "S", 'G', MinecraftPlus.itemGreyGem, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(GrayPick),
				new Object[] { "GGG", " S ", " S ", 'G',
						MinecraftPlus.itemGreyGem, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(GrayHoe), new Object[] { "GG",
				" S", " S", 'G', MinecraftPlus.itemGreyGem, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(GrayShovel), new Object[] { "G",
				"S", "S", 'G', MinecraftPlus.itemGreyGem, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(GrayHelmet), new Object[] { "GGG",
				"G G", 'G', MinecraftPlus.itemGreyGem });

		GameRegistry.addRecipe(new ItemStack(GrayChestplate), new Object[] {
				"G G", "GGG", "GGG", 'G', MinecraftPlus.itemGreyGem });

		GameRegistry.addRecipe(new ItemStack(GrayLeggings), new Object[] {
				"GGG", "G G", "G G", 'G', MinecraftPlus.itemGreyGem });

		GameRegistry.addRecipe(new ItemStack(GrayBoots), new Object[] { "G G",
				"G G", 'G', MinecraftPlus.itemGreyGem });

		GameRegistry.addRecipe(new ItemStack(fuelCan, 1), new Object[] { " II",
				"CCC", "CCC", 'I', Items.iron_ingot, 'C', Items.coal });

		GameRegistry
				.addRecipe(new ItemStack(fuelTank, 1),
						new Object[] { "III", "IGI", "III", 'I',
								Items.iron_ingot, 'G', Blocks.glass });

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(grayPower, 1),
						new Object[] { "IGI", "ISI", 'I', Items.iron_ingot,
								'G', MinecraftPlus.itemGreyGem, 'S',
								"ingotSilver" }));

		GameRegistry.addRecipe(new ItemStack(infuserOff, 1), new Object[] {
				"TPT", "ICI", "TFT", 'I', Items.iron_ingot, 'P',
				MinecraftPlus.grayPower, 'F', MinecraftPlus.fuelTank, 'T',
				TinIngot, 'C', Blocks.furnace });

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SteelAxe, 1),
						new Object[] { "II", "IS", " S", 'I', "ingotSteel",
								'S', Items.stick }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SteelHoe, 1),
						new Object[] { "II", " S", " S", 'I', "ingotSteel",
								'S', Items.stick }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SteelPick, 1),
						new Object[] { "III", " S ", " S ", 'I', "ingotSteel",
								'S', Items.stick }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SteelSword, 1),
						new Object[] { "I", "I", "S", 'I', "ingotSteel", 'S',
								Items.stick }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SteelShovel, 1),
						new Object[] { "I", "S", "S", 'I', "ingotSteel", 'S',
								Items.stick }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SteelChestplate, 1),
						new Object[] { "I I", "III", "III", 'I', "ingotSteel" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SteelBoots, 1),
						new Object[] { "I I", "I I", 'I', "ingotSteel" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SteelLeggings, 1),
						new Object[] { "III", "I I", "I I", 'I', "ingotSteel" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SteelHelmet, 1),
						new Object[] { "III", "I I", 'I', "ingotSteel" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SteelBlock, 1),
						new Object[] { "III", "III", "III", 'I', "ingotSteel" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(steel, 9),
						"blockSteel"));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(
						new ItemStack(CobaltBlock, 1),
						new Object[] { "III", "III", "III", 'I', "ingotCobalt" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(CobaltBar, 9),
						"blockCobalt"));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(CobaltHelmet, 1),
						new Object[] { "III", "I I", 'I', "ingotCobalt" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(
						new ItemStack(CobaltChestplate, 1),
						new Object[] { "I I", "III", "III", 'I', "ingotCobalt" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(
						new ItemStack(CobaltLeggings, 1),
						new Object[] { "III", "I I", "I I", 'I', "ingotCobalt" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(CobaltBoots, 1),
						new Object[] { "I I", "I I", 'I', "ingotCobalt" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(CobaltShovel, 1),
						new Object[] { "I", "S", "S", 'I', "ingotCobalt", 'S',
								Items.stick }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(CobaltAxe, 1),
						new Object[] { "II", "IS", " S", 'I', "ingotCobalt",
								'S', Items.stick }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(CobaltSword, 1),
						new Object[] { "I", "I", "S", 'I', "ingotCobalt", 'S',
								Items.stick }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(CobaltHoe, 1),
						new Object[] { "II", " S", " S", 'I', "ingotCobalt",
								'S', Items.stick }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(CobaltPick, 1),
						new Object[] { "III", " S ", " S ", 'I', "ingotCobalt",
								'S', Items.stick }));

		GameRegistry.addShapelessRecipe(new ItemStack(SilverPlank, 4),
				MinecraftPlus.Log);

		GameRegistry.addShapelessRecipe(new ItemStack(Sapling, 1),
				MinecraftPlus.Log, MinecraftPlus.leaf);

		GameRegistry.addShapelessRecipe(new ItemStack(ToxicGem, 9),
				MinecraftPlus.ToxicBlock);

		GameRegistry.addRecipe(new ItemStack(ToxicBlock, 1), new Object[] {
				"III", "III", "III", 'I', MinecraftPlus.ToxicGem });

		GameRegistry.addRecipe(new ItemStack(FarBar, 1), new Object[] { "III",
				"III", "III", 'I', MinecraftPlus.FarNug });

		GameRegistry.addShapelessRecipe(new ItemStack(FarNug, 9),
				MinecraftPlus.FarBar);

		GameRegistry.addShapelessRecipe(new ItemStack(FarBar, 9),
				MinecraftPlus.FarlandBlock);

		GameRegistry.addRecipe(new ItemStack(FarlandBlock, 1), new Object[] {
				"III", "III", "III", 'I', MinecraftPlus.FarBar });

		GameRegistry.addRecipe(new ItemStack(WorkBench, 1), new Object[] {
				"SSS", "PCP", "SSS", 'P', Blocks.planks, 'C',
				Blocks.crafting_table, 'S', Blocks.cobblestone });

		GameRegistry.addRecipe(new ItemStack(VisberArrow, 1), new Object[] {
				"V", "S", "F", 'S', Items.stick, 'V', MinecraftPlus.Visber,
				'F', Items.feather });

		GameRegistry.addShapelessRecipe(new ItemStack(Powder, 4),
				Items.glowstone_dust, Items.redstone, Items.blaze_powder,
				VoidPowder);

		GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald, 1),
				Powder, ToxicGem);

		GameRegistry.addShapelessRecipe(new ItemStack(ToxicGem, 1),
				Items.slime_ball, Items.emerald, Powder);

		GameRegistry.addShapelessRecipe(new ItemStack(Items.lava_bucket, 1),
				Items.water_bucket, Powder, Items.bucket);

		GameRegistry.addShapelessRecipe(new ItemStack(Items.water_bucket, 1),
				Items.lava_bucket, Powder, Items.bucket);

		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 1),
				itemGreyGem, Powder);

		GameRegistry.addShapelessRecipe(new ItemStack(itemGreyGem, 1),
				Items.diamond, Powder);

		GameRegistry.addRecipe(new ItemStack(ToxicSword, 1), new Object[] {
				"I", "G", "S", 'I', MinecraftPlus.ToxicGem, 'S', Items.stick,
				'G', Items.gold_nugget });

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SilverSpawn, 1),
						new Object[] { "III", "IGI", "ISI", 'S',
								MinecraftPlus.Log, 'G', Blocks.iron_bars, 'I',
								"ingotSilver" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(SilverIngot, 9),
						"blockSilver"));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(
						new ItemStack(SilverBlock, 1),
						new Object[] { "III", "III", "III", 'I', "ingotSilver" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(CopperIngot, 9),
						"blockCopper"));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(
						new ItemStack(CopperBlock, 1),
						new Object[] { "III", "III", "III", 'I', "ingotCopper" }));
		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(TinIngot, 9),
						"blockTin"));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(TinBlock, 1),
						new Object[] { "III", "III", "III", 'I', "ingotTin" }));

		GameRegistry.addShapelessRecipe(new ItemStack(DustBlock, 2),
				Blocks.sand, Blocks.dirt);

		GameRegistry.addRecipe(new ItemStack(TransformationWand, 1),
				new Object[] { " GI", " SG", "S  ", 'I', MinecraftPlus.Powder,
						'S', Items.stick, 'G', MinecraftPlus.FarNug });

		GameRegistry.addShapelessRecipe(new ItemStack(woodrootSoup, 1),
				Items.bowl, Items.baked_potato, MinecraftPlus.woodroot,
				Items.cooked_beef);

		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 1),
				MinecraftPlus.Powder, MinecraftPlus.SilverIngot);

		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 1),
				MinecraftPlus.Powder, Items.iron_ingot);

		GameRegistry.addShapelessRecipe(new ItemStack(SilverIngot, 1),
				MinecraftPlus.Powder, Items.gold_ingot);

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(FruitJuice, 3),
						new Object[] { "AAA", "GAG", " G ", 'G', Blocks.glass,
								'A', "listAllfruit" }));

		GameRegistry.addShapelessRecipe(new ItemStack(bush, 1), Blocks.leaves,
				Items.apple, MinecraftPlus.Powder);

		GameRegistry.addShapelessRecipe(new ItemStack(bush, 1), Blocks.leaves2,
				Items.apple, MinecraftPlus.Powder);

		GameRegistry.addShapelessRecipe(new ItemStack(bush, 1),
				MinecraftPlus.leaf, Items.apple, MinecraftPlus.Powder);

		GameRegistry.addShapelessRecipe(new ItemStack(bush, 1), Blocks.leaves,
				MinecraftPlus.berry, MinecraftPlus.Powder);

		GameRegistry.addShapelessRecipe(new ItemStack(bush, 1), Blocks.leaves2,
				MinecraftPlus.berry, MinecraftPlus.Powder);

		GameRegistry.addShapelessRecipe(new ItemStack(bush, 1),
				MinecraftPlus.leaf, MinecraftPlus.berry, MinecraftPlus.Powder);

		GameRegistry.addShapelessRecipe(new ItemStack(Items.apple, 1),
				MinecraftPlus.berry, MinecraftPlus.Powder);

		GameRegistry.addShapelessRecipe(new ItemStack(berry, 1), Items.apple,
				MinecraftPlus.Powder);

		GameRegistry.addRecipe(new ItemStack(LampUnlit, 1), new Object[] {
				"SSS", "SPS", "SSS", 'S', Items.stick, 'P', Items.paper });

		GameRegistry.addShapelessRecipe(new ItemStack(LampLit, 1),
				Blocks.torch, MinecraftPlus.LampUnlit);

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(FruitCake, 1),
						Items.wheat, "listAllfruit", Items.egg,
						Items.milk_bucket, "listAllfruit", "listAllfruit"));

		GameRegistry.addShapelessRecipe(new ItemStack(CureStone, 1),
				Items.milk_bucket, MinecraftPlus.itemGreyGem,
				MinecraftPlus.VoidPowder);

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.clay, 1),
				Items.water_bucket, MinecraftPlus.DustBlock);

		GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_pearl, 1),
				Blocks.glass, MinecraftPlus.VoidPowder);

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SilverHelm, 1),
						new Object[] { "III", "I I", 'I', "ingotSilver" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(
						new ItemStack(SilverChest, 1),
						new Object[] { "I I", "III", "III", 'I', "ingotSilver" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(
						new ItemStack(SilverLegs, 1),
						new Object[] { "III", "I I", "I I", 'I', "ingotSilver" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SilverBoots, 1),
						new Object[] { "I I", "I I", 'I', "ingotSilver" }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SilverShovel, 1),
						new Object[] { "I", "S", "S", 'I', "ingotSilver", 'S',
								Items.stick }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SilverAxe, 1),
						new Object[] { "II", "IS", " S", 'I', "ingotSilver",
								'S', Items.stick }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SilverSword, 1),
						new Object[] { "I", "I", "S", 'I', "ingotSilver", 'S',
								Items.stick }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SilverHoe, 1),
						new Object[] { "II", " S", " S", 'I', "ingotSilver",
								'S', Items.stick }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(SilverPick, 1),
						new Object[] { "III", " S ", " S ", 'I', "ingotSilver",
								'S', Items.stick }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(XrayGlass, 1),
						new Object[] { "FGO", "GEG", "OGF", 'F',
								"ingotFarland", 'E', BloodEye, 'G',
								Blocks.glass, 'O', Blocks.obsidian }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(BloodEye, 1),
						new Object[] { " R ", "RER", " R ", 'R', "quartzRed",
								'E', Items.ender_eye }));

		CraftingManager
				.getInstance()
				.getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(VisberSword, 1),
						new Object[] { "V", "E", "S", 'V', "ingotVisber", 'E',
								BloodEye, 'S', Items.stick }));

		GameRegistry.addRecipe(new ItemStack(BoneHelmet), new Object[] { "GGG",
				"G G", 'G', Items.bone });

		GameRegistry.addRecipe(new ItemStack(BoneChestplate), new Object[] {
				"G G", "GGG", "GGG", 'G', Items.bone });

		GameRegistry.addRecipe(new ItemStack(BoneLeggings), new Object[] {
				"GGG", "G G", "G G", 'G', Items.bone });

		GameRegistry.addRecipe(new ItemStack(BoneBoots), new Object[] { "G G",
				"G G", 'G', Items.bone });

		GameRegistry.addRecipe(new ItemStack(ZombieHelmet), new Object[] {
				"GGG", "G G", 'G', Items.rotten_flesh });

		GameRegistry.addRecipe(new ItemStack(ZombieChestplate), new Object[] {
				"G G", "GGG", "GGG", 'G', Items.rotten_flesh });

		GameRegistry.addRecipe(new ItemStack(ZombieLeggings), new Object[] {
				"GGG", "G G", "G G", 'G', Items.rotten_flesh });

		GameRegistry.addRecipe(new ItemStack(ZombieBoots), new Object[] {
				"G G", "G G", 'G', Items.rotten_flesh });

		GameRegistry.addRecipe(new ItemStack(CopperAxe), new Object[] { "GG",
				"GS", " S", 'G', MinecraftPlus.CopperIngot, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(CopperSword), new Object[] { "G",
				"G", "S", 'G', MinecraftPlus.CopperIngot, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(CopperPick),
				new Object[] { "GGG", " S ", " S ", 'G',
						MinecraftPlus.CopperIngot, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(CopperHoe), new Object[] { "GG",
				" S", " S", 'G', MinecraftPlus.CopperIngot, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(CopperShovel), new Object[] { "G",
				"S", "S", 'G', MinecraftPlus.CopperIngot, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(CopperHelmet), new Object[] {
				"GGG", "G G", 'G', MinecraftPlus.CopperIngot });

		GameRegistry.addRecipe(new ItemStack(CopperChestplate), new Object[] {
				"G G", "GGG", "GGG", 'G', MinecraftPlus.CopperIngot });

		GameRegistry.addRecipe(new ItemStack(CopperLeggings), new Object[] {
				"GGG", "G G", "G G", 'G', MinecraftPlus.CopperIngot });

		GameRegistry.addRecipe(new ItemStack(CopperBoots), new Object[] {
				"G G", "G G", 'G', MinecraftPlus.CopperIngot });

		GameRegistry.addRecipe(new ItemStack(TinAxe), new Object[] { "GG",
				"GS", " S", 'G', MinecraftPlus.TinIngot, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(TinSword), new Object[] { "G",
				"G", "S", 'G', MinecraftPlus.TinIngot, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(TinPick), new Object[] { "GGG",
				" S ", " S ", 'G', MinecraftPlus.TinIngot, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(TinHoe), new Object[] { "GG",
				" S", " S", 'G', MinecraftPlus.TinIngot, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(TinShovel), new Object[] { "G",
				"S", "S", 'G', MinecraftPlus.TinIngot, 'S', Items.stick });

		GameRegistry.addRecipe(new ItemStack(TinHelmet), new Object[] { "GGG",
				"G G", 'G', MinecraftPlus.TinIngot });

		GameRegistry.addRecipe(new ItemStack(TinChestplate), new Object[] {
				"G G", "GGG", "GGG", 'G', MinecraftPlus.TinIngot });

		GameRegistry.addRecipe(new ItemStack(TinLeggings), new Object[] {
				"GGG", "G G", "G G", 'G', MinecraftPlus.TinIngot });

		GameRegistry.addRecipe(new ItemStack(TinBoots), new Object[] { "G G",
				"G G", 'G', MinecraftPlus.TinIngot });
		// Mobs
		MobHandler.registerPeaceful(Snail.class, "Snail", 0x967147, 0x6B4B25);
		MobHandler.registerMonster(Robot.class, "Robot", 0x25C4C2, 0xD1D1D1);
		MobHandler.registerMonsterOverworldAndNether(FireZombie.class,
				"FireZombie", 0x37914C, 0xDE9440);
		MobHandler.registerMonsterOverworld(ToxicMob.class, "ToxicMob",
				0x40DB4D, 0x36A83D);
		MobHandler.registerMonsterOverworldAndEnd(NewEnder.class, "NewEnder",
				0x161A16, 0x872D96);
		MobHandler.registerPeaceful(TameMonsterClass.class, "TameMonster",
				0xFA1414, 0xA31212);
		MobHandler.registerBoss(CallerBoss.class, "CallerOfMobs", 0x121112,
				0x450D4F);
		MobHandler.registerMonsterJungle(GreenMobAI.class, "GreenMob",
				0x187807, 0x258C12);
		MobHandler.registerMonsterOverworldAndNether(FireMage.class,
				"FireMage", 0xC92724, 0x363535);
		MobHandler.registerMonsterOverworld(Tusk.class, "Tusk", 0x4F3403,
				0x573D0E);
		MobHandler.registerPeaceful(TNTPig.class, "CreepPig", 0x0B850F,
				0xFFA8FC);
		MobHandler.registerMonsterOverworld(BeastAI.class, "Beast", 0x96681E,
				0xC49B62);
		MobHandler
				.registerBoss(Silver.class, "SilverGuard", 0xF2F2F2, 0xC5D4D9);
		MobHandler.registerMonsterNether(Demon.class, "Demon", 0xF23D3D,
				0xF2673D);
		MobHandler
				.registerPeacefulEnd(Angel.class, "Angel", 0xFFFFFF, 0xFFF700);
		MobHandler.registerMonsterOverworld(NightStalker.class, "NightStalker",
				0x1F1F1F, 0xC73030);
		MobHandler.registerMonsterOverworldAndEnd(MagicAI.class, "VoidMage",
				0xC32FF5, 0x363535);
		MobHandler.registerMonsterNether(hellhound.class, "Hellhound",
				0xA68383, 0xA34949);
		MobHandler.registerBoss(SpawnBoss.class, "HellsSpawn", 0x1C1C1C,
				0x750002);
		MobHandler.registerMonsterOverworld(InvisMobAi.class, "InvisMob",
				0x525252, 0x292929);
		MobHandler.registerMonsterOverworld(VillagerMob.class, "VillagerMob",
				0x6798A8, 0xBD8B72);
		MobHandler.registerPeaceful(HumanEntity.class, "Human", 0x00CCCC,
				0xC69680);
		MobHandler.registerMonsterOverworld(FeralMonster.class, "FeralMonster",
				0x495376, 0xA31212);
		MobHandler.registerMonsterJungle(PoisonSnail.class, "PoisonSnail",
				0x968447, 0x6B5D25);

		// Achievements
		DemonHunter = new Achievement("achievement.KillDemon", "KillDemon", 2,
				0, new ItemStack(Items.blaze_powder), (Achievement) null)
				.initIndependentStat().registerStat();
		FallenAngel = new Achievement("achievement.KillAngel", "KillAngel", 2,
				2, new ItemStack(Items.glowstone_dust), (Achievement) null)
				.initIndependentStat().registerStat();
		BarryAllen = new Achievement("achievement.FindBerry", "FindBerry", 0,
				0, new ItemStack(this.berry), (Achievement) null)
				.initIndependentStat().registerStat();
		Fruity = new Achievement("achievement.FruitDrink", "Fruity", 0, 2,
				new ItemStack(this.FruitJuice), (this.BarryAllen))
				.registerStat();
		JustAddSalt = new Achievement("achievement.KillSnail", "KillSnail", 0,
				4, new ItemStack(this.snail), (Achievement) null)
				.initIndependentStat().registerStat();
		Escargot = new Achievement("achievement.CookSnail", "CookSnail", 0, 6,
				new ItemStack(this.snailCooked), (this.JustAddSalt))
				.registerStat();
		ThatsAStart = new Achievement("achievement.FindSeeds", "FindSeeds", -2,
				0, new ItemStack(this.woodrootSeed), (Achievement) null)
				.initIndependentStat().registerStat();
		Harvest = new Achievement("achievement.GrowPlant", "GrowPlant", -2, 2,
				new ItemStack(this.woodroot), this.ThatsAStart).registerStat();
		Dinner = new Achievement("achievement.MakeDinner", "MakeDinner", -2, 4,
				new ItemStack(this.woodrootSoup), this.Harvest).registerStat();
		ToxicFumes = new Achievement("achievement.ToxicEffect", "ToxicEffect",
				0, -4, new ItemStack(this.ToxicGem), (Achievement) null)
				.initIndependentStat().registerStat();
		ToxicAttack = new Achievement("achievement.ToxicSword", "ToxicSword",
				0, -6, new ItemStack(this.ToxicSword), this.ToxicFumes)
				.registerStat();
		ItJustChanged = new Achievement("achievement.Change", "Change", 2, 4,
				new ItemStack(this.TransformationWand), (Achievement) null)
				.initIndependentStat().registerStat();
		EvenMoreToxic = new Achievement("achievement.KillToxic", "KillToxic",
				0, -2, new ItemStack(Items.slime_ball), this.ToxicFumes)
				.registerStat();
		FuelTheFire = new Achievement("achievement.Fuel", "Fuel", 2, -2,
				new ItemStack(this.fuelCan), (Achievement) null)
				.initIndependentStat().registerStat();
		ItsTheEnd = new Achievement("achievement.end", "end", 2, 6,
				new ItemStack(this.boss), (Achievement) null)
				.initIndependentStat().registerStat();
		Red = new Achievement("achievement.Red", "Red", -2, 6, new ItemStack(
				Items.gold_nugget), (Achievement) null).initIndependentStat()
				.registerStat();
		Shiny = new Achievement("achievement.Silver", "Silver", -2, -4,
				new ItemStack(this.SilverIngot), (Achievement) null)
				.initIndependentStat().registerStat();
		Village = new Achievement("achievement.Village", "Village", 2, -4,
				new ItemStack(Items.emerald), (Achievement) null)
				.initIndependentStat().registerStat();
		OP = new Achievement("achievement.OP", "OP", 2, -6, new ItemStack(
				this.SwordNew), (Achievement) null).initIndependentStat()
				.registerStat();
		Firewatch = new Achievement("achievement.Fire", "Fire", -2, -6,
				new ItemStack(Blocks.fire), (Achievement) null)
				.initIndependentStat().registerStat();
		IWasPeaceful = new Achievement("achievement.Pig", "Pig", -2, -2,
				new ItemStack(Blocks.tnt), (Achievement) null)
				.initIndependentStat().registerStat();
		MotherNaturesSon = new Achievement("achievement.MotherNaturesSon",
				"MotherNaturesSon", 4, -6, new ItemStack(this.berrySeed),
				(Achievement) null).initIndependentStat().registerStat();
		Lie2 = new Achievement("achievement.Lie2", "Lie2", 4, -4,
				new ItemStack(this.FruitCake), (Achievement) null)
				.initIndependentStat().registerStat();
		BiggerDemons = new Achievement("achievement.BiggerDemons",
				"BiggerDemons", 4, 0, new ItemStack(this.MakeSpawn),
				(Achievement) null).initIndependentStat().registerStat();
		Inferno = new Achievement("achievement.Inferno", "Inferno", 4, -2,
				new ItemStack(this.FireSword), this.BiggerDemons)
				.registerStat();
		Cure = new Achievement("achievement.Cure", "Cure", 4, 2, new ItemStack(
				this.CureStone), (Achievement) null).initIndependentStat()
				.registerStat();
		HeavyMetal = new Achievement("achievement.HeavyMetal", "HeavyMetal", 4,
				4, new ItemStack(this.steel), (Achievement) null)
				.initIndependentStat().registerStat();
		WhatKindOfBlackMagicIsThis = new Achievement(
				"achievement.WhatKindOfBlackMagicIsThis",
				"WhatKindOfBlackMagicIsThis", 4, 6, new ItemStack(this.Powder),
				(Achievement) null).initIndependentStat().registerStat();

		AchievementPage.registerAchievementPage(new AchievementPage(
				"Minecraft Expanded", new Achievement[] { DemonHunter,
						FallenAngel, BarryAllen, Fruity, JustAddSalt, Escargot,
						ThatsAStart, Harvest, Dinner, ToxicFumes, ToxicAttack,
						ItJustChanged, EvenMoreToxic, FuelTheFire, ItsTheEnd,
						Red, Shiny, Village, OP, Firewatch, IWasPeaceful,
						MotherNaturesSon, Lie2, Inferno, BiggerDemons, Cure,
						HeavyMetal, WhatKindOfBlackMagicIsThis }));
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	public static CreativeTabs ModBlocks = new CreativeTabs("ModBlocks") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(WorkBench).getItem();
		}
	};
	public static CreativeTabs ModItems = new CreativeTabs("ModItems") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(itemGreyGem).getItem();
		}
	};
	public static CreativeTabs ModMisc = new CreativeTabs("ModMisc") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(TransformationWand).getItem();
		}
	};
}
