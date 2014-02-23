package evanq.game.client.widget;

import de.matthiasmann.twl.BoxLayout;
import de.matthiasmann.twl.Button;
import de.matthiasmann.twl.GUI;
import de.matthiasmann.twl.Widget;

public class LoginWidget extends Widget  {
	
	
	protected BoxLayout boxLayout;
	
	public LoginWidget(){
		boxLayout = new BoxLayout(BoxLayout.Direction.HORIZONTAL);
		
		
		add(boxLayout);
		
		addButton("Haha",new Runnable() {
			
			@Override
			public void run() {
				System.out.println("u click!!!");
			}
		});
	}	
	

    public Button addButton(String text, Runnable cb) {
        Button btn = new Button(text);
        btn.addCallback(cb);
        boxLayout.add(btn);
        invalidateLayout();
        return btn;
    }

    public Button addButton(String text, String ttolTip, Runnable cb) {
        Button btn = addButton(text, cb);
        btn.setTooltipContent(ttolTip);
        return btn;
    }
    

	@Override
	protected void layout() {
		
		boxLayout.adjustSize();
		boxLayout.setPosition(0, getParent().getHeight() - boxLayout.getHeight());
		
	}



	@Override
	protected void afterAddToGUI(GUI gui) {
		super.afterAddToGUI(gui);
		
		validateLayout();
	}
	
	
}
