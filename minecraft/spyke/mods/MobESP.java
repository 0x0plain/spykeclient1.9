package spyke.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import spyke.main.Category;
import spyke.utils.RenderUtils;

public class MobESP extends Module{

	public MobESP() {
		super("MobESP", Keyboard.KEY_K, Category.RENDER);
	}
	
	@Override
	public void onRender() {
		if(this.isToggled()){
			for(Object e: mc.theWorld.loadedEntityList){
				if(e instanceof EntityLiving){
					RenderUtils.entityESPBox((Entity)e, 0);
				}
			}
		}
	}

}
