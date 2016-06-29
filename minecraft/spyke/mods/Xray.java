package spyke.mods;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import spyke.main.Category;

public class Xray extends Module{
	
	public static ArrayList<Block> xrayBlocks = new ArrayList(); 
	
	public Xray() {
		super("Xray", Keyboard.KEY_X, Category.RENDER);
	}
	
	public void onEnable(){
		mc.renderGlobal.loadRenderers();
	}
	
	public void onDisable() {
		mc.renderGlobal.loadRenderers();
	}
	
}
