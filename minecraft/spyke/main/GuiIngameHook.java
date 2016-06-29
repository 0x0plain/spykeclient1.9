package spyke.main;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import spyke.gui.UIRenderer;
import spyke.mods.Module;

public class GuiIngameHook extends GuiIngame {

	public GuiIngameHook(Minecraft mcIn) {
		super(mcIn);
	}

	public void renderGameOverlay(float partialTicks) {
		super.renderGameOverlay(partialTicks);
		ScaledResolution scaledresolution = new ScaledResolution(this.mc);
		this.mc.entityRenderer.setupOverlayRendering();
		GlStateManager.enableBlend();

		int count = 0;

		for (Module m : Spyke.getModules()) {
			if (m.isToggled()) {
				mc.fontRendererObj.drawString(m.getName(), 2, 2 + (count * 10), 0x00ff00);
				count++;
			}
		}
		UIRenderer.renderAndUpdateFrames();
		drawTabGui();
	}
	
	public void drawTabGui(){
		drawRect(75, 20, 5, 40, Spyke.tabManager.getCurrentTab()==0 ? 0xff0d0d0d : 0xff676c6e);
		mc.fontRendererObj.drawString("Render", 9, 26, 0xffffff);
		
		drawRect(75, 40, 5, 60, Spyke.tabManager.getCurrentTab()==1 ? 0xff0d0d0d : 0xff676c6e);
		mc.fontRendererObj.drawString("Movement", 9, 46, 0xffffff);
		
		if(Spyke.tabManager.getTabs().get(0).isExpanded()){
			drawRect(145, 20, 75, 40, Spyke.tabManager.getCurrentRenderMod() == 0 ? 0xff0d0d0d:0xff676c6e);
			mc.fontRendererObj.drawString("ChestESP", 85, 26, 0xffffff);
			drawRect(145, 40, 75, 60, Spyke.tabManager.getCurrentRenderMod() == 1 ? 0xff0d0d0d:0xff676c6e);
			mc.fontRendererObj.drawString("MobESP", 85, 46, 0xffffff);
			drawRect(145, 60, 75, 80, Spyke.tabManager.getCurrentRenderMod() == 2 ? 0xff0d0d0d:0xff676c6e);
			mc.fontRendererObj.drawString("Xray", 85, 66, 0xffffff);
		}
		
		if(Spyke.tabManager.getTabs().get(1).isExpanded()){
			drawRect(145, 40, 75, 60, Spyke.tabManager.getCurrentMovementMod() == 0 ? 0xff0d0d0d:0xff676c6e);
			mc.fontRendererObj.drawString("Flight", 85,  46,  0xffffff);
			drawRect(145, 60, 75, 80, Spyke.tabManager.getCurrentMovementMod() == 1 ? 0xff0d0d0d:0xff676c6e);
			mc.fontRendererObj.drawString("Glide", 85,  66,  0xffffff);
			drawRect(145, 80, 75, 100, Spyke.tabManager.getCurrentMovementMod() == 2 ? 0xff0d0d0d:0xff676c6e);
			mc.fontRendererObj.drawString("Nofall", 85,  86,  0xffffff);
			drawRect(145, 100, 75, 120, Spyke.tabManager.getCurrentMovementMod() == 3 ? 0xff0d0d0d:0xff676c6e);
			mc.fontRendererObj.drawString("WaterWalk", 85,  106,  0xffffff);
		}
		
	}

}
