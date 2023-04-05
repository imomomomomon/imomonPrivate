package bit.app.board;

import java.io.*;

public class FileManager {
	 private FileManager() {}
	 private static FileManager inst = null;
	 public static FileManager getInst() {
		 if(inst == null)
			 inst = new FileManager();
		 return inst;
	 }
	 //private final String path = "D:/자료" + "/" +filename;
	 private final String filename = "test";
	 
	 public void writeFile(Object obj) {
		 FileOutputStream fos = null;
		 BufferedOutputStream bos = null;
		 ObjectOutputStream oos = null;
		 
			try {
				fos = new FileOutputStream(filename);
				bos = new BufferedOutputStream(fos);
				oos = new ObjectOutputStream(bos);
				
				oos.writeObject(obj);
				oos.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
			}
	 }
	 
	 public Object readFile() {
		 FileInputStream fis = null;
		 BufferedInputStream bis = null;
		 ObjectInputStream ois = null;
		 
		 Object result = null;
		 
			try {
				fis = new FileInputStream(filename);
				bis = new BufferedInputStream(fis);
				ois = new ObjectInputStream(bis);
				
				result = ois.readObject();

				ois.close();

			} catch (Exception e) {
				// TODO: handle exception
		        e.getStackTrace();
			}
			
		return result;
	 }
}
