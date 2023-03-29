package bit.app.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExceptionEx2 {
	public void interruptedException(){
		for (int i = 1; i <= 100; i++) {
			try {
				Thread.sleep(100);
				if(i%7==0) System.err.println();
				System.out.printf("%4d",i);
				if(i%5==0) {
					throw new InterruptedException();
				}
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.getStackTrace();
			}
		}
	}
	public void iOException() {
		FileInputStream fis = null;
		try {
			//System.out.println("Data:");
			fis = new FileInputStream(
					new File("C:\\Users\\금정산1_PC03\\Desktop\\youtube.txt"));
			int temp = 0;
			while((temp=fis.read()) != -1) {
				Thread.sleep(100);
				System.out.print((char)temp);
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace(); 
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace(); 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(fis != null)
				try {
					fis.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.getStackTrace();
				}
		}
	}
	public static void main(String[] args) {
		ExceptionEx2 e = new ExceptionEx2();
		e.iOException();
	}
}
