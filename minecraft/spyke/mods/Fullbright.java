package spyke.mods;

import org.lwjgl.input.Keyboard;

import spyke.main.Category;

public class Fullbright extends Module{

	public Fullbright() {
		super("Fullbright", Keyboard.KEY_C, Category.RENDER);
	}
	
	@Override
	public void onUpdate() {
		if(isToggled()){
			mc.gameSettings.gammaSetting = 100f;
		}else{
			mc.gameSettings.gammaSetting = 0f;
		}
	}

}
