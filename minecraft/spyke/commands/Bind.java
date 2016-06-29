package spyke.commands;

import org.lwjgl.input.Keyboard;

import spyke.command.Command;
import spyke.main.Spyke;
import spyke.mods.Module;

public class Bind extends Command{

	@Override
	public String getAlias() {
		return "bind";
	}

	@Override
	public String getDescription() {
		return "Allows user to change keybind of module";
	}

	@Override
	public String getSyntax() {
		return ".bind set [MOD] [Key] | .bind del [MOD] | .bind clear";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		if(args[0].equalsIgnoreCase("set")){
			args[2] = args[2].toUpperCase();
			int key = Keyboard.getKeyIndex(args[2]);
			
			for(Module m: Spyke.getModules()){
				if(args[1].equalsIgnoreCase(m.getName())){
					m.setKey(Keyboard.getKeyIndex(Keyboard.getKeyName(key)));
					Spyke.addChatMessage(args[1] + " has been binded to " + args[2]);
				}
			}
			
		}else if(args[0].equalsIgnoreCase("del")){
			for(Module m: Spyke.getModules()){
				if(m.getName().equalsIgnoreCase(args[1])){
					m.setKey(0);
					Spyke.addChatMessage(args[1] + " has been unbinded");
				}
			}
		}else if(args[0].equalsIgnoreCase("clear")){
			for(Module m: Spyke.getModules()){
				m.setKey(0);
			}
			Spyke.addChatMessage("All keys cleared");
		}
	}

}
