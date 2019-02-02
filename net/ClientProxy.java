package com.codycornell82.minecraftPlus.net;

import model.AngelModel;
import model.BeastModel;
import model.CreepPig;
import model.DemonModel;
import model.FireMageModel;
import model.GreenMob;
import model.MagicModel;
import model.ModelCaller;
import model.ModelHuman;
import model.ModelRobot;
import model.ModelSnail;
import model.ModelSpawn;
import model.NewEnderModel;
import model.NewWolfModel;
import model.NightStalkerModel;
import model.OddModel;
import model.TameMonster;
import model.TheInvisModel;
import model.TheSilverModel;
import model.ToxicMobModel;
import model.VillagerMobModel;
import model.ZombieModel;

import com.codycornell82.minecraftPlus.Bows.Arrow.CallArrow;
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
import com.codycornell82.minecraftPlus.render.HellhoundRender;
import com.codycornell82.minecraftPlus.render.OddRender;
import com.codycornell82.minecraftPlus.render.RenderAngel;
import com.codycornell82.minecraftPlus.render.RenderBeast;
import com.codycornell82.minecraftPlus.render.RenderCaller;
import com.codycornell82.minecraftPlus.render.RenderDemon;
import com.codycornell82.minecraftPlus.render.RenderFeral;
import com.codycornell82.minecraftPlus.render.RenderFireMage;
import com.codycornell82.minecraftPlus.render.RenderFireZombie;
import com.codycornell82.minecraftPlus.render.RenderGreen;
import com.codycornell82.minecraftPlus.render.RenderHuman;
import com.codycornell82.minecraftPlus.render.RenderMagic;
import com.codycornell82.minecraftPlus.render.RenderNewEnder;
import com.codycornell82.minecraftPlus.render.RenderNightStalker;
import com.codycornell82.minecraftPlus.render.RenderPigCreeper;
import com.codycornell82.minecraftPlus.render.RenderPoisonSnail;
import com.codycornell82.minecraftPlus.render.RenderRobot;
import com.codycornell82.minecraftPlus.render.RenderSilver;
import com.codycornell82.minecraftPlus.render.RenderSnail;
import com.codycornell82.minecraftPlus.render.RenderTameMonster;
import com.codycornell82.minecraftPlus.render.RenderToxicMob;
import com.codycornell82.minecraftPlus.render.RenderVisArrow;
import com.codycornell82.minecraftPlus.render.SpawnRender;
import com.codycornell82.minecraftPlus.render.TheInvisRender;
import com.codycornell82.minecraftPlus.render.TheVillagerRender;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	public void registerRenderThings() {
		RenderingRegistry.registerEntityRenderingHandler(Snail.class,
				new RenderSnail(new ModelSnail(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(Robot.class,
				new RenderRobot(new ModelRobot(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(FireZombie.class,
				new RenderFireZombie(new ZombieModel(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(ToxicMob.class,
				new RenderToxicMob(new ToxicMobModel(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(NewEnder.class,
				new RenderNewEnder(new NewEnderModel(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(
				TameMonsterClass.class, new RenderTameMonster(
						new TameMonster(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(CallerBoss.class,
				new RenderCaller(new ModelCaller(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(CallArrow.class,
				new RenderVisArrow());
		RenderingRegistry.registerEntityRenderingHandler(GreenMobAI.class,
				new RenderGreen(new GreenMob(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(FireMage.class,
				new RenderFireMage(new FireMageModel(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(Tusk.class,
				new OddRender(new OddModel(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(TNTPig.class,
				new RenderPigCreeper(new CreepPig(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(BeastAI.class,
				new RenderBeast(new BeastModel(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(Silver.class,
				new RenderSilver(new TheSilverModel(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(Demon.class,
				new RenderDemon(new DemonModel(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(Angel.class,
				new RenderAngel(new AngelModel(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(NightStalker.class,
				new RenderNightStalker(new NightStalkerModel(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(MagicAI.class,
				new RenderMagic(new MagicModel(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(hellhound.class,
				new HellhoundRender(new NewWolfModel(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(SpawnBoss.class,
				new SpawnRender(new ModelSpawn(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(InvisMobAi.class,
				new TheInvisRender(new TheInvisModel(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(VillagerMob.class,
				new TheVillagerRender(new VillagerMobModel(0), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(HumanEntity.class,
				new RenderHuman(new ModelHuman(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(
				FeralMonster.class, new RenderFeral(
						new TameMonster(), 0.3f));
		RenderingRegistry.registerEntityRenderingHandler(
				PoisonSnail.class, new RenderPoisonSnail(
						new ModelSnail(), 0.3f));
		}

	public void registerTileEntitySpecialRenderer() {

	}

}
