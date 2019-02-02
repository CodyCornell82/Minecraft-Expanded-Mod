package com.codycornell82.minecraftPlus.PowerBlocks;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiInfuser extends GuiContainer {
	private static final ResourceLocation gui = new ResourceLocation(
			"mp:textures/gui/infuser.png");
	private TileEntityInfuser infuser;

	public GuiInfuser(InventoryPlayer InvPlayer, TileEntityInfuser teInfuser) {
		super(new ContainerInfuser(InvPlayer, teInfuser));
		infuser = teInfuser;
		this.xSize = 176;
		this.ySize = 166;
	}

	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = this.infuser.hasCustomInventoryName() ? this.infuser
				.getInventoryName() : I18n.format(this.infuser
				.getInventoryName());

		this.fontRendererObj.drawString(name, this.xSize / 2
				- this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8,
				this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {

		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		mc.getMinecraft().getTextureManager().bindTexture(gui);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		if (infuser.hasPower()) {
			int i1 = infuser.getFuelScale(54);
			drawTexturedModalRect(guiLeft + 153, guiTop + 56 - i1, 242,
					53 - i1, 15, i1);
		}
		int j1 = infuser.getInfuserProgressScale(24);
		drawTexturedModalRect(guiLeft + 79, guiTop + 35, 200, 0, j1 + 1, 17);
	}

}
