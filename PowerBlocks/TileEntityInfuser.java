package com.codycornell82.minecraftPlus.PowerBlocks;

import com.codycornell82.minecraftPlus.MinecraftPlus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityInfuser extends TileEntity implements ISidedInventory {
	private ItemStack slots[];
	public int dualCookTime;
	public int dualPower;
	public static final int maxPower = 10000;
	public static final int infuserSpeed = 100;

	public static final int[] slots_top = new int[] { 0, 1 };
	public static final int[] slots_bottom = new int[] { 3 };
	public static final int[] slots_side = new int[] { 2 };

	public String customName;

	public TileEntityInfuser() {

		slots = new ItemStack[4];

	}

	@Override
	public int getSizeInventory() {

		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return slots[i];
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (slots[i] != null) {
			ItemStack stack = slots[i];
			slots[i] = null;
			return stack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack stack) {

		slots[i] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.customName
				: "container.infuser";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.customName != null && this.customName.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {

		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this) {
			return false;
		} else {
			return player.getDistanceSq((double) xCoord + 0.5D,
					(double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64;
		}
	}

	public void openInventory() {
	}

	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack stack) {
		return i == 2 ? false : (i == 1 ? hasItemPower(stack) : true);
	}

	public boolean hasItemPower(ItemStack stack) {
		return getItemPower(stack) > 0;
	}

	private static int getItemPower(ItemStack stack) {
		if (stack == null) {
			return 0;
		} else {
			Item item = stack.getItem();
			if (item == MinecraftPlus.fuelCan) {
				return 100;
			}
			return 0;
		}

	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (slots[i] != null) {
			if (slots[i].stackSize <= j) {
				ItemStack stack = slots[i];
				slots[i] = null;
				return stack;
			}
			ItemStack stack1 = slots[i].splitStack(j);

			if (slots[i].stackSize == 0) {
				slots[i] = null;
			}
			return stack1;
		} else {
			return null;
		}
	}

	public void readFromNBT(NBTTagCompound p_145839_1_) {
		super.readFromNBT(p_145839_1_);
		NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < slots.length) {
				this.slots[b0] = ItemStack
						.loadItemStackFromNBT(nbttagcompound1);
			}
		}

		this.dualPower = p_145839_1_.getShort("BurnTime");
		this.dualCookTime = p_145839_1_.getShort("CookTime");

		if (p_145839_1_.hasKey("CustomName", 8)) {
			this.customName = p_145839_1_.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound p_145841_1_) {
		super.writeToNBT(p_145841_1_);
		p_145841_1_.setShort("BurnTime", (short) this.dualPower);
		p_145841_1_.setShort("CookTime", (short) this.dualCookTime);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.slots.length; ++i) {
			if (this.slots[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		p_145841_1_.setTag("Items", nbttaglist);

		if (this.hasCustomInventoryName()) {
			p_145841_1_.setString("CustomName", this.customName);
		}
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int i) {
		return i == 0 ? slots_bottom : (i == 1 ? slots_top : slots_side);
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_,
			int p_102007_3_) {

		return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack stack, int j) {

		return j != 0 || i != 1 || stack.getItem() == Items.bucket;
	}

	public int getInfuserProgressScale(int i) {

		return (dualCookTime * i) / this.infuserSpeed;

	}

	public int getFuelScale(int i) {

		return (dualPower * i) / maxPower;
	}

	private boolean canInfuse() {
		if (slots[0] == null || slots[1] == null) {
			return false;
		}
		ItemStack stack = InfuserRecipes.getInfuserRusult(slots[0].getItem(),
				slots[1].getItem());
		if (stack == null) {
			return false;
		}

		if (slots[3] == null) {
			return true;
		}
		if (!slots[3].isItemEqual(stack)) {
			return false;
		}
		if (slots[3].stackSize < getInventoryStackLimit()
				&& slots[3].stackSize < slots[3].getMaxStackSize()) {
			return true;
		} else {
			return slots[3].stackSize < stack.getMaxStackSize();
		}
	}

	private void InfuseItem() {
		if (canInfuse()) {
			ItemStack stack = InfuserRecipes.getInfuserRusult(
					slots[0].getItem(), slots[1].getItem());

			if (slots[3] == null) {
				slots[3] = stack.copy();
			} else if (slots[3].isItemEqual(stack)) {
				slots[3].stackSize += stack.stackSize;
			}
			for (int i = 0; i < 2; i++) {
				if (slots[i].stackSize <= 0) {
					slots[i] = new ItemStack(slots[i].getItem().setFull3D());
				} else {
					slots[i].stackSize--;
				}
				if (slots[i].stackSize <= 0) {
					slots[i] = null;
				}
			}
		}
	}

	public boolean hasPower() {
		return dualPower > 0;
	}

	public boolean IsInfusing() {
		return this.dualCookTime > 0;
	}

	public void updateEntity() {
		boolean flag = this.hasPower();
		boolean flag1 = false;
		if (hasPower() && this.IsInfusing()) {
			this.dualPower--;
		}
		if (!worldObj.isRemote) {
			if (this.hasItemPower(this.slots[2])
					&& this.dualPower < (this.maxPower - this
							.getItemPower(this.slots[2]))) {
				this.dualPower += getItemPower(this.slots[2]);
				if (this.slots[2] != null) {
					flag1 = true;
					this.slots[2].stackSize--;
					if (this.slots[2].stackSize == 0) {
						this.slots[2] = this.slots[2].getItem()
								.getContainerItem(this.slots[2]);
					}
				}
			}
			if (hasPower() && canInfuse()) {
				dualCookTime++;
				if (dualCookTime == this.infuserSpeed) {
					this.dualCookTime = 0;
					this.InfuseItem();
					flag1 = true;
				}
			} else {
				dualCookTime = 0;
			}
			if (flag != this.IsInfusing()) {
				flag1 = true;
				infuser.updateBlockState(this.IsInfusing(), this.worldObj,
						this.xCoord, this.yCoord, this.zCoord);
			}
		}
		if (flag1) {
			this.markDirty();
		}
	}
}
