package bit.app.obj1;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;



public class WindowFrame extends Frame{
	
	Rectangle rect = new Rectangle(20,40,50,50);
	Color color = new Color(255,0,0);
	
	Image img;
	Graphics img_g;
	boolean isBuffer = false;
	
	final int speed = 5;
	int width = 500;
	int height = 500;
	
	public WindowFrame() {
		this.addWindowListener(
				new WindowListenerAdapter() {
					
					@Override
					public void windowClosing(WindowEvent e) {
						// TODO Auto-generated method stub
						System.exit(0);
					}
				});
		this.addMouseListener(
				new MouseListenerAdapter() {
				});
		this.addKeyListener(new KeyListenerAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						super.keyPressed(e);
						moveRect(e.getKeyCode());
					}
					
				});
		
		this.setBounds(100,100,width,height);
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		if(isBuffer) {
			img = createImage(width,height);
			img_g = img.getGraphics();
			paintComponents(g);
			drawRect(g);
			g.drawImage(img,0,0,null);
			
		} else {
			paintComponents(g);
			drawRect(g);
		}

		isBuffer = !isBuffer;
		repaint();
	}
	
	private void drawRect(Graphics g) {
		g.setColor(color);
		g.fillRect(rect.x,rect.y,rect.width,rect.height);
	}
	
	private void moveRect(int ketValue) {
		switch (ketValue) {
			case 38://up
				rect.y -= speed;
				break;
			case 40://down
				rect.y += speed;
				break;
			case 37://left
				rect.x -= speed;
				break;
			case 39://right
				rect.x += speed;
				break;
		}
	}
	
	public static void main(String[] args) {
		WindowFrame wf = new WindowFrame();
	}
}

abstract class KeyListenerAdapter implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

abstract class MouseListenerAdapter implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

abstract class WindowListenerAdapter implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}
	
}