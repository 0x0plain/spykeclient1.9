package spyke.tabgui;

import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.input.Keyboard;

import spyke.main.Spyke;
import spyke.mods.*;

public class TabManager {

	private ArrayList<Tab> tabs;
	private int currentTab;

	private HashMap<Integer, Module> renderMods, movementMods;
	private int currentRenderMod, currentMovementMod;

	public TabManager() {
		tabs = new ArrayList();
		currentTab = 0;
		renderMods = new HashMap();
		movementMods = new HashMap();
		currentRenderMod = 0;
		currentMovementMod = 0;
		tabs.add(new TabOne());
		tabs.add(new TabTwo());
		
		renderMods.put(0, new ChestESP());
		renderMods.put(1, new MobESP());
		renderMods.put(2, new Xray());
		
		movementMods.put(0, new Flight());
		movementMods.put(1, new Glide());
		movementMods.put(2, new Nofall());
		movementMods.put(3, new WaterWalk());
		
	}
	
	public ArrayList<Tab> getTabs(){
		return tabs;
	}
	
	public int getCurrentMovementMod(){
		return currentMovementMod;
	}
	
	public int getCurrentRenderMod(){
		return currentRenderMod;
	}
	
	public int getCurrentTab(){
		return currentTab;
	}

	public void keyPressed(int k) {
		switch (k) {
		case Keyboard.KEY_UP:
			if(tabs.get(currentTab).isExpanded()){
				switch(currentTab){
				case 0:
					if(currentRenderMod != 0){
						currentRenderMod--;
					}
					break;
				case 1:
					if(currentMovementMod != 0){
						currentMovementMod--;
					}
					break;
				}
			}else{
				if(currentTab != 0){
					currentTab--;
				}
			}
			break;
		case Keyboard.KEY_DOWN:
			if(tabs.get(currentTab).isExpanded()){
				switch(currentTab){
				case 0:
					if(currentRenderMod != renderMods.size()-1){
						currentRenderMod++;
					}
					break;
				case 1:
					if(currentMovementMod != movementMods.size()-1){
						currentMovementMod++;
					}
					break;
				}
			}else{
				if(currentTab != 1){
					currentTab++;
				}
			}
			break;
		case Keyboard.KEY_RIGHT:
			if(tabs.get(currentTab).isExpanded()){
				switch(currentTab){
				case 0:
					toggleMod(renderMods.get(currentRenderMod).getName());
					break;
				case 1:
					toggleMod(movementMods.get(currentMovementMod).getName());
					break;
				}
			}else{
				tabs.get(currentTab).setExpanded(true);
			}
			break;
		case Keyboard.KEY_LEFT:
			if(tabs.get(currentTab).isExpanded()){
				tabs.get(currentTab).setExpanded(false);
			}
			break;
		}
	}
	
	private void toggleMod(String n){
		for(Module m: Spyke.getModules()){
			if(m.getName().equalsIgnoreCase(n)){
				m.toggle();
				break;
			}
		}
	}

}
