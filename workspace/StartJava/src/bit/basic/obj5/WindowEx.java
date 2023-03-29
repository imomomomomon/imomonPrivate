package bit.basic.obj5;

import javax.swing.JFrame;

public class WindowEx extends JFrame{
	public static void main(String[] args) {
		
	}
	
	public WindowEx() {
		new MouseAdapterEx() {

			@Override
			public void mouseClick() {
				// TODO Auto-generated method stub
				super.mouseClick();
			}
			
		};
	}
	
}
