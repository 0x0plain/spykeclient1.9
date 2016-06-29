package spyke.mods;

import net.minecraft.tileentity.TileEntityChest;
import spyke.main.Category;
import spyke.utils.RenderUtils;

public class ChestESP extends Module{

	public ChestESP() {
		super("ChestESP", 0, Category.RENDER);
	}
	
	public void onRender() {
		if(this.isToggled()){
			for(Object o: mc.theWorld.loadedTileEntityList){
				if(o instanceof TileEntityChest){
					RenderUtils.blockESPBox(((TileEntityChest)o).getPos());
				}
			}
		}
	}

}
