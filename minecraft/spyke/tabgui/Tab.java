package spyke.tabgui;

public abstract class Tab {
	
	private boolean expanded;
	
	public void setExpanded(boolean b){
		expanded = b;
	}
	
	public boolean isExpanded(){
		return expanded;
	}
	
}
