package com.codycornell82.minecraftPlus.PowerBlocks;

import java.util.Random;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class infuser extends BlockContainer {

	private Random rand;
	private final boolean isActive;
	private static boolean keepInventory = true;

	@SideOnly(Side.CLIENT)
	private IIcon iconFront;

	public infuser(boolean blockState) {
		super(Material.iron);
		this.setStepSound(soundTypeAnvil);
		rand = new Random();
		isActive = blockState;

	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister Iconregister) {
		this.blockIcon = Iconregister.registerIcon("mp:"
				+ (this.isActive ? "infuserOnSide" : "infuserOffSide"));
		this.iconFront = Iconregister.registerIcon("mp:"
				+ (this.isActive ? "InfuserFrontOn" : "InfuserFrontOff"));
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {

		return metadata == 0 && side == 3 ? this.iconFront
				: (side == metadata ? this.iconFront : this.blockIcon);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}

	private void setDefaultDirection(World world, int x, int y, int z) {

		if (!world.isRemote) {
			Block block1 = world.getBlock(x, y, z - 1);
			Block block2 = world.getBlock(x, y, z + 1);
			Block block3 = world.getBlock(x - 1, y, z);
			Block block4 = world.getBlock(x + 1, y, z);

			byte b0 = 3;

			if (block1.func_149730_j() && !block2.func_149730_j()) {
				b0 = 3;
			}
			if (block2.func_149730_j() && !block1.func_149730_j()) {
				b0 = 2;
			}
			if (block3.func_149730_j() && !block4.func_149730_j()) {
				b0 = 5;
			}
			if (block4.func_149730_j() && !block3.func_149730_j()) {
				b0 = 4;
			}
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}

	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase player, ItemStack stack) {
		int i = MathHelper
				.floor_double((double) (player.rotationYaw * 4.0f / 360f) + 0.5D) & 3;
		if (i == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if (i == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if (i == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if (i == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		if (stack.hasDisplayName()) {
			// ((TileEntityInfuser)world.getTileEntity(x, y,
			// z)).setCustomName(stack.getDisplayName());
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitx, float hity, float hitz) {
		if (world.isRemote) {
			return true;
		} else if (!player.isSneaking()) {
			TileEntityInfuser entity = (TileEntityInfuser) world.getTileEntity(
					x, y, z);
			if (entity != null) {
				FMLNetworkHandler.openGui(player, "mp",
						MinecraftPlus.guiIDInfuser, world, x, y, z);
			}
			return true;
		} else {
			return false;
		}

	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {

		return new TileEntityInfuser();
	}

	public static void updateBlockState(boolean isInfusing, World world,
			int xCoord, int yCoord, int zCoord) {
		int i = world.getBlockMetadata(xCoord, yCoord, zCoord);
		TileEntity tileEntity = world.getTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;

		if (isInfusing) {
			world.setBlock(xCoord, yCoord, zCoord, MinecraftPlus.infuserOn);
		} else {
			world.setBlock(xCoord, yCoord, zCoord, MinecraftPlus.infuserOff);
		}
		keepInventory = false;
		world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

		if (tileEntity != null) {
			tileEntity.validate();
			world.setTileEntity(xCoord, yCoord, zCoord, tileEntity);
		}
	}

}
