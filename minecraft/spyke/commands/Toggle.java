package spyke.commands;

import spyke.command.Command;
import spyke.main.Spyke;
import spyke.mods.Module;

public class Toggle extends Command{

	@Override
	public String getAlias() {
		// TODO Auto-generated method stub
		return "toggle";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Toggles a mod though the console";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return ".toggle <Module>";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		boolean found = false;
		for(Module m: Spyke.getModules()){
			if(args[0].equalsIgnoreCase(m.getName())){
				m.toggle();
				found = true;
				Spyke.addChatMessage(m.getName() + " was toggled!");
			}
		}
		if(found == false){
			Spyke.addChatMessage("Targeted Module was not found!");
		}
	}

}
