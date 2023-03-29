package bit.app.obj1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowFrame2 {
	public static void main(String[] args) {
		new CustomFrame();
	}
}

class CustomFrame extends Frame {
	private Pan pan;
	public CustomFrame() {
		pan = new Pan();
		this.add(pan);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == 27)
					System.exit(0);
			}
		});
		this.setUndecorated(true);
		Dimension d = 
				Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, d.width, d.height);
		this.setVisible(true);
	}
	public class Pan extends Canvas {
		public Pan() {
			this.setBackground(Color.CYAN);
		}

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
		}

		@Override
		public void update(Graphics g) {
			// TODO Auto-generated method stub
			super.update(g);
		}
		
	}
}
