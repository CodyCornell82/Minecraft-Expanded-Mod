package com.codycornell82.minecraftPlus.PowerBlocks;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerWorkBench extends Container {

	public InventoryCrafting CraftMatrix;

	public IInventory CraftResult;

	private World worldObj;

	private int posx;

	private int posy;

	private int posz;

	public ContainerWorkBench(InventoryPlayer playerInv, World world, int x,
			int y, int z) {

		CraftMatrix = new InventoryCrafting(this, 4, 4);
		CraftResult = new InventoryCraftResult();
		worldObj = world;
		posx = x;
		posy = y;
		posz = z;

		this.addSlotToContainer(new SlotCrafting(playerInv.player, CraftMatrix,
				CraftResult, 0, 131, 36));

		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 4; k++) {
				this.addSlotToContainer(new Slot(CraftMatrix, k + i * 4,
						4 + k * 18, 3 + i * 18));
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(playerInv, k + i * 9 + 9,
						8 + k * 18, 84 + i * 18));
			}
		}
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 142));
		}
		onCraftMatrixChanged(CraftMatrix);
	}

	public void onCraftMatrixChanged(IInventory inventory) {
		CraftResult.setInventorySlotContents(0, WorkBenchCraftingManager
				.getInstance().findMatchingRecipe(CraftMatrix, worldObj));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {

		if (worldObj.getBlock(posx, posy, posz) != MinecraftPlus.WorkBench) {
			return false;
		} else {
			return player.getDistanceSq((double) posx + 0.5D,
					(double) posy + 0.5D, (double) posz + 0.5D) <= 64.0D;
		}
	}

	public void onContainerClosed(EntityPlayer p_75134_1_) {
		super.onContainerClosed(p_75134_1_);

		if (!this.worldObj.isRemote) {
			for (int i = 0; i < 16; ++i) {
				ItemStack itemstack = this.CraftMatrix
						.getStackInSlotOnClosing(i);

				if (itemstack != null) {
					p_75134_1_.dropPlayerItemWithRandomChoice(itemstack, false);
				}
			}
		}
	}

	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(p_82846_2_);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (p_82846_2_ == 0) {
				if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (p_82846_2_ >= 10 && p_82846_2_ < 37) {
				if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
					return null;
				}
			} else if (p_82846_2_ >= 37 && p_82846_2_ < 46) {
				if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(p_82846_1_, itemstack1);
		}

		return itemstack;
	}

}
