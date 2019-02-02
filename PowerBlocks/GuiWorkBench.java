package com.codycornell82.minecraftPlus.PowerBlocks;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiWorkBench extends GuiContainer {
	private static final ResourceLocation gui = new ResourceLocation(
			"mp:textures/gui/workbench.png");

	public GuiWorkBench(InventoryPlayer playerInv, World world, int x, int y,
			int z) {
		super(new ContainerWorkBench(playerInv, world, x, y, z));
		this.xSize = 176;
		this.ySize = 166;
	}

	public void onGuiClosed() {
		super.onGuiClosed();
	}

	protected void drawGuiContainerForegroundLayer(int i, int j) {
		this.fontRendererObj.drawString(
				StatCollector.translateToLocal("Workbench"), 100, 5, 0xFFFFFF);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1f, 1f, 1f, 1f);
		Minecraft.getMinecraft().getTextureManager().bindTexture(gui);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
