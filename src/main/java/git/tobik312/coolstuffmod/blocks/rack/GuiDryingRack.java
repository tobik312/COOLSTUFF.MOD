package git.tobik312.coolstuffmod.blocks.rack;

import git.tobik312.coolstuffmod.utils.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;


public class GuiDryingRack extends GuiContainer {
	
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/container/drying_rack.png");
	private final InventoryPlayer player;
	private final TileEntityDryingRack tileentity;
	
	public GuiDryingRack(InventoryPlayer player, TileEntityDryingRack tileentity) {
		
		super(new ContainerDryingRack(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
		
	}
	
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
		String tileName = this.tileentity.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2), 8, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 8, 73, 4210752);
		
	}
	
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		if(TileEntityDryingRack.isBurning(tileentity)) {
			
			int k = this.getBurnLeftScaled(13);
			this.drawTexturedModalRect(this.guiLeft + 56, this.guiTop + 56 + 12 - k, 176, 12 - k, 14, k + 1);
			
		}
		
		int l = this.getCookProgressScaled(24);
		this.drawTexturedModalRect(this.guiLeft + 79, this.guiTop + 35, 176, 14, l + 1, 16);
		
	}
	
	private int getBurnLeftScaled(int pixels) {
		
		int i = this.tileentity.getField(1);
		if(i == 0) i = 400;
		return this.tileentity.getField(0) * pixels / i;
		
	}
	
	private int getCookProgressScaled(int pixels) {
		
		int i = this.tileentity.getField(2);
		int j = this.tileentity.getField(3);
		return j != 0 && i != 0 ? i * pixels / j : 0;
		
	}

}
