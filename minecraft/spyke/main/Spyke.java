package spyke.main;

import java.util.ArrayList;

import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.util.ChatComponentText;
import spyke.command.CommandManager;
import spyke.gui.SpykeGuiManager;
import spyke.mods.*;
import spyke.tabgui.TabManager;
import spyke.utils.XrayUtils;

public class Spyke {
	
	private static ArrayList<Module> mods;
	private static CommandManager cmdManager;
	public static SpykeGuiManager guiManager;
	public static TabManager tabManager;
	
	public Spyke(){
		mods = new ArrayList<Module>();
		cmdManager = new CommandManager();
		tabManager = new TabManager();
		XrayUtils.initXRayBlocks();
		addMod(new Flight());
		addMod(new Nofall());
		addMod(new Fullbright());
		addMod(new ClickGui());
		addMod(new Glide());
		addMod(new MobESP());
		addMod(new ChestESP());
		addMod(new Xray());
		addMod(new ChestStealer());
		addMod(new WaterWalk());
		addMod(new Sprint());
		addMod(new Step());
		guiManager = new SpykeGuiManager();
		guiManager.setTheme(new SimpleTheme());
		guiManager.setup();
	}
	
	public static void addMod(Module m){
		mods.add(m);
	}
	
	public static ArrayList<Module> getModules(){
		return mods;
	}
	
	public static void onUpdate(){
		for(Module m: mods){
			m.onUpdate();
		}
	}
	
	public static void onRender(){
		for(Module m: mods){
			m.onRender();
		}
	}
	
	public static void onKeyPressed(int k){
		for(Module m: mods){
			if(m.getKey() == k){
				m.toggle();
			}
		}
	}

	public static void addChatMessage(String s){
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Spyke: " + s));
	}
	
	public static boolean onSendChatMessage(String s){//EntityPlayerSP
		if(s.startsWith(".")){
			cmdManager.callCommand(s.substring(1));
			return false;
		}
		for(Module m: getModules()){
			if(m.isToggled()){
				return m.onSendChatMessage(s);
			}
		}
		return true;
	}
	
	public static boolean onRecieveChatMessage(S02PacketChat packet){
		for(Module m: getModules()){
			if(m.isToggled()){
				return m.onRecieveChatMessage(packet);
			}
		}
		return true;
	}
	
	

}
