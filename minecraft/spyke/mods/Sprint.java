package spyke.mods;

import org.lwjgl.input.Keyboard;

import spyke.main.Category;

public class Sprint extends Module {

	public Sprint() {
		super("Sprint", Keyboard.KEY_M, Category.MOVEMENT);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()){
			mc.thePlayer.setSprinting(true);
		}else{
			mc.thePlayer.setSprinting(false);
		}
	}

}
