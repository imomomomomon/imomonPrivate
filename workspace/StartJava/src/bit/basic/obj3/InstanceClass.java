package bit.basic.obj3;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class InstanceClass {
	public static void main(String[] args) {
		InstanceTemp it = new InstanceTemp();
		it.showDefault();
		it.showInterEx1();
		it.InterfaceEx2Method();
		
		InterfaceEx1 ifex = new InstanceTemp();
		ifex.showDefault();
		((InterfaceEx2)(ifex)).InterfaceEx2Method();
		((InstanceTemp)(ifex)).InstanceTempMethod();
	}
}

class InstanceTemp implements InterfaceEx3 {

	@Override
	public void showInterEx1() {
		// TODO Auto-generated method stub
		System.out.println("InterfaceEx1의 showInterEx1");
	}

	@Override
	public void InterfaceEx2Method() {
		// TODO Auto-generated method stub
		System.out.println("InterfaceEx2의 InterfaceEx2Method");
		
	}
	
	public void InstanceTempMethod() {
		System.out.println("InstanceTemp의 InstanceTempMethod");
	}
}

class ActionInterFace {
	public ActionInterFace() {
		new AbstractWdAdapter() {
			
		};
	}
}

class AbstractWdAdapter implements WindowListener {

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

