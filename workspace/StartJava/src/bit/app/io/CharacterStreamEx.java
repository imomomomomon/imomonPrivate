package bit.app.io;

import java.io.*;
import java.util.Scanner;

public class CharacterStreamEx {
	
	public void fileCopy() {
		Scanner scanner = null;
		BufferedOutputStream bos = null;
		try {
			scanner = new Scanner(new File("D:/자료/230321 문제.txt"));
			bos = new BufferedOutputStream(
					new PrintStream("D:/자료/Copyfolder/Copytext2.txt"));
			while (scanner.hasNext()) {
				bos.write(scanner.nextLine().concat("\r\n").getBytes());
				bos.flush();
				//concat->문자열 결합 
				//flush->buffer에 다차지 않아도 내보내기(15byte가 넘어야 내보냄)
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
//		finally {
//			try {
//				if(scanner != null) scanner.close();
//				if(bos != null) bos.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//		}
		
	}
	public void fileScanner() {
		Scanner scanner = new Scanner(System.in);
		BufferedReader br = null;
		BufferedWriter bw = null;
		String temp = "";
		try {
			System.out.println("Origin:");
			br = new BufferedReader(new FileReader(new File(
					scanner.nextLine().trim())));
			System.out.println("Change:");
			bw = new BufferedWriter(new FileWriter(new File(
					scanner.nextLine().trim())));
			
			while((temp = br.readLine()) != null) {
				temp += "\r\n";
				bw.write(temp);
				bw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) br.close();
				if(bw!=null) bw.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		CharacterStreamEx c = new CharacterStreamEx();
//		c.fileCopy();
		c.fileScanner();
	}
}
