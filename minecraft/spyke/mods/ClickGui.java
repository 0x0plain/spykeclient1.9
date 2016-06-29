package spyke.mods;

import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;
import org.lwjgl.input.Keyboard;

import spyke.gui.UIRenderer;
import spyke.main.Category;
import spyke.main.Spyke;

public class ClickGui extends Module{

	public ClickGui() {
		super("Click Gui", Keyboard.KEY_GRAVE, Category.OTHER);
	}
	
	@Override
	public void onEnable(){
		if(!(mc.currentScreen instanceof GuiManagerDisplayScreen)){
			mc.displayGuiScreen(new GuiManagerDisplayScreen(Spyke.guiManager));
			UIRenderer.renderAndUpdateFrames();
		}
	}

}
