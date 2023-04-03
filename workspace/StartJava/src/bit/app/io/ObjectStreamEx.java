package bit.app.io;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class ObjectStreamEx {
	private final String PATH = "D:/자료/obj3.dat";
	public void writeMember() {
		try(ObjectOutputStream oos = new ObjectOutputStream(
				new PrintStream(new File(PATH)))) {
			oos.writeObject(new Member("BLUE","red",189.9));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void readMember() {
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(new File(PATH)))) {
			
			System.out.println(((Member)ois.readObject()).toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeObject(Object obj) {
		try(ObjectOutputStream oos = new ObjectOutputStream(
				new PrintStream(new File(PATH)))) {
			oos.writeObject(obj);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object readObject() {
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(new File(PATH)))) {
			return ois.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ObjectStreamEx ex = new ObjectStreamEx();
		
		if(false) {
			HashMap<String, Member> hm = new HashMap<String, Member>();
			{
				hm.put("00000B1", new Member("RED","Fire Fighter",189.0));
				hm.put("00000B2", new Member("BLUE","Police",178.9));
				hm.put("00000B3", new Member("YELLOW","Student",171.5));
				hm.put("00000B4", new Member("PURPLE","Teacher",165.1));
			}
			ex.writeObject(hm);
		}
		else {
				@SuppressWarnings("unchecked")
				HashMap<String, Member> result = (HashMap<String, Member>)(ex.readObject());
				for (@SuppressWarnings({ "rawtypes" })
				Iterator itor = result.entrySet().iterator(); itor.hasNext();) {
					Entry temp = (Entry)itor.next();
					System.out.println(temp.getKey() + ": "
							+ ((Member)(temp.getValue())).toString() );
				}
			}
		}
		
}
