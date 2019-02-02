package com.codycornell82.minecraftPlus;

import com.codycornell82.minecraftPlus.PowerBlocks.ContainerInfuser;
import com.codycornell82.minecraftPlus.PowerBlocks.ContainerWorkBench;
import com.codycornell82.minecraftPlus.PowerBlocks.GuiInfuser;
import com.codycornell82.minecraftPlus.PowerBlocks.GuiWorkBench;
import com.codycornell82.minecraftPlus.PowerBlocks.TileEntityInfuser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if (entity != null) {
			switch (ID) {
			case MinecraftPlus.guiIDInfuser:
				if (entity instanceof TileEntityInfuser) {
					return new ContainerInfuser(player.inventory,
							(TileEntityInfuser) entity);
				}
				return null;
			}
		}
		if (ID == MinecraftPlus.guiIDWorkBench) {
			return ID == MinecraftPlus.guiIDWorkBench
					&& world.getBlock(x, y, z) == MinecraftPlus.WorkBench ? new ContainerWorkBench(
					player.inventory, world, x, y, z) : null;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if (entity != null) {
			switch (ID) {
			case MinecraftPlus.guiIDInfuser:
				if (entity instanceof TileEntityInfuser) {
					return new GuiInfuser(player.inventory,
							(TileEntityInfuser) entity);
				}
				return null;
			}
		}

		if (ID == MinecraftPlus.guiIDWorkBench) {
			return ID == MinecraftPlus.guiIDWorkBench
					&& world.getBlock(x, y, z) == MinecraftPlus.WorkBench ? new GuiWorkBench(
					player.inventory, world, x, y, z) : null;
		}

		return null;
	}

}
