package com.codycornell82.minecraftPlus.PowerBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerInfuser extends Container {
	private TileEntityInfuser TileInfuser;
	public int dualCookTime;
	public int dualPower;
	private int lastItemBurnTime;

	public ContainerInfuser(InventoryPlayer InvPlayer,
			TileEntityInfuser teInfuser) {
		dualCookTime = 0;
		dualPower = 0;
		lastItemBurnTime = 0;

		TileInfuser = teInfuser;

		this.addSlotToContainer(new Slot(teInfuser, 0, 56, 17));
		this.addSlotToContainer(new Slot(teInfuser, 1, 56, 53));
		this.addSlotToContainer(new Slot(teInfuser, 2, 153, 59));
		this.addSlotToContainer(new SlotInfuser(InvPlayer.player, teInfuser, 3,
				116, 34));

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(InvPlayer, j + i * 9 + 9,
						8 + j * 18, 84 + i * 18));
			}
		}
		for (int i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(InvPlayer, i, 8 + i * 18, 142));
		}
	}

	public void addcraftingToCrafters(ICrafting craft) {
		super.addCraftingToCrafters(craft);
		craft.sendProgressBarUpdate(this, 0, this.TileInfuser.dualCookTime);
		craft.sendProgressBarUpdate(this, 1, this.TileInfuser.dualPower);
	}

	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(p_82846_2_);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (p_82846_2_ == 2) {
				if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (p_82846_2_ != 1 && p_82846_2_ != 0) {
				if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null) {
					if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
						return null;
					}
				} else if (TileEntityFurnace.isItemFuel(itemstack1)) {
					if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
						return null;
					}
				} else if (p_82846_2_ >= 3 && p_82846_2_ < 30) {
					if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
						return null;
					}
				} else if (p_82846_2_ >= 30 && p_82846_2_ < 39
						&& !this.mergeItemStack(itemstack1, 3, 30, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
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

	@Override
	public boolean canInteractWith(EntityPlayer player) {

		return TileInfuser.isUseableByPlayer(player);
	}

	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for (int i = 0; i < this.crafters.size(); i++) {
			ICrafting k = (ICrafting) this.crafters.get(i);

			if (this.dualCookTime != this.TileInfuser.dualCookTime) {
				k.sendProgressBarUpdate(this, 0, this.TileInfuser.dualCookTime);
			}

			if (this.dualPower != this.TileInfuser.dualPower) {
				k.sendProgressBarUpdate(this, 1, this.TileInfuser.dualPower);
			}
		}

		this.dualCookTime = this.TileInfuser.dualCookTime;
		this.dualPower = this.TileInfuser.dualPower;

	}

	public void updateProgressBar(int i, int j) {
		if (i == 0) {
			TileInfuser.dualCookTime = j;
		}
		if (i == 1) {
			TileInfuser.dualPower = j;
		}
	}
}
