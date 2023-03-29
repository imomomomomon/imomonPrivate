package bit.basic.obj5;

import java.util.ArrayList;
import javax.swing.JFrame;

public class WindowEx3 extends JFrame {
	private ArrayList<String> list
		= new ArrayList<String>() {

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return super.toString() + " this ToString";
			}
		
	};
	public void actionString() {
		System.out.println(list.toString());
	}

	public static void main(String[] args) {
		WindowEx3 w = new WindowEx3();
		w.actionString();
	}
}
