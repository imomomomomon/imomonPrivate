package SiegeTank;

import java.awt.*;
import java.awt.event.*;

public class Main extends Frame implements Runnable {
	
	final String path = "D:/자료/image/tank1.png";
	Image tank;
	Thread th;
	Image offImg;
	Graphics offScreen;
	
	public Main() {
		
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
						System.out.println(e.getKeyCode());
						if(e.getKeyCode() == 27)
							System.exit(0);
					}
					
				});
	
		tank = Toolkit.getDefaultToolkit().getImage("D:/자료/image/siege01.png");
		
		th = new Thread(this);
        th.start();
	}
	
	public void run() {
        while (th != null) {
            repaint();
            try {
                th.sleep(40);
            } catch (InterruptedException e) {}
        }
    }
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		int w = this.getSize().width;
        int h = this.getSize().height;
        
        if (offScreen == null) {
            try {
            	offImg = createImage(w, h);
                offScreen = offImg.getGraphics();
            } catch (Exception e) {
                offScreen = null;
            }
        }
        if (offScreen != null) {
        	drawImg(offScreen,w,h);
            g.drawImage(offImg, 0, 0, this);
        }
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	private void drawImg(Graphics g,int w, int h) {
		g.clearRect(0, 0, w, h);
		g.drawImage(tank,100,100,null);
		g.drawString("Normal Mode", w / 2, 50);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.setSize(500,500);
		main.setResizable(false);
		main.setVisible(true);
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
