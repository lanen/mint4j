package evanq.game.playbox;


/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class DisplayMode {
	
	private int width;
	
	private int hegith;
	
	private boolean showAsModel;
	
	private boolean isFullScreen;
	
	public DisplayMode(int width, int height) {
		
		this.width  = width;
		this.hegith = height;
		
	}

	public int getWidth() {
		return width;
	}

	public int getHegith() {
		return hegith;
	}

	public boolean isShowAsModel() {
		return showAsModel;
	}

	public void setShowAsModel(boolean showAsModel) {
		this.showAsModel = showAsModel;
	}

	public boolean isFullScreen() {
		return isFullScreen;
	}

	public void setFullScreen(boolean isFullScreen) {
		this.isFullScreen = isFullScreen;
	}
	
	public String toString(){
		
		StringBuilder b = new StringBuilder();
		
		b.append("[width=").append(width).append(", height=").append(hegith);
		b.append(", model=").append(showAsModel).append(", fullscreen=").append(isFullScreen).append("]");
		
		return b.toString();
	}
	
}
