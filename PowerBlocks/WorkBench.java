package com.codycornell82.minecraftPlus.PowerBlocks;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorkBench extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon WorkBenchTop;

	public WorkBench() {
		super(Material.wood);
		this.setHardness(3.5F);
		this.setResistance(5.0F);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return side == 1 ? this.WorkBenchTop : this.blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		this.blockIcon = register.registerIcon("mp" + ":" + "WorkBenchSide");
		this.WorkBenchTop = register.registerIcon("mp" + ":" + "WorkBenchTop");
	}

	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitx, float hity, float hitz) {
		if (!player.isSneaking()) {
			player.openGui(MinecraftPlus.instance,
					MinecraftPlus.guiIDWorkBench, world, x, y, z);
			return true;
		} else {
			return false;
		}
	}
}
