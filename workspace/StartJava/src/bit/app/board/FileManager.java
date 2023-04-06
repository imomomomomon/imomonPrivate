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
	 
	 public void writeFile(Object obj, String path) {
			try(ObjectOutputStream oos = 
					new ObjectOutputStream(
					new BufferedOutputStream(
					new FileOutputStream(path)))) {
				oos.writeObject(obj);
			} catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
			}
	 }
	 
	 public Object readFile(String path) {
			try(ObjectInputStream ois = 
					new ObjectInputStream(
					new BufferedInputStream(
					new FileInputStream(path)))) {
				return ois.readObject();
			} catch (Exception e) {
				// TODO: handle exception
		        e.getStackTrace();
			}
			
		return null;
	 }
}
