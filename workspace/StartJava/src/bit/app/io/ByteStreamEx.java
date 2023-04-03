package bit.app.io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

//byteStream,CharacterStream,ObjectStream
//
public class ByteStreamEx {
	
	public void streamEx1() throws IOException {
		byte []contents = new byte[50];
		int rc = System.in.read(contents);
//		for (byte b : contents) {
//			System.out.print(b+" ");
//		}
		System.out.println(new String(contents).trim());
	}
	public void fileCopy() {
		BufferedReader br = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int size = 0;
		int temp = 0;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Origin :");
			fis = new FileInputStream(new File(br.readLine().trim()));
			System.out.println("Change :");
			fos = new FileOutputStream(new File(br.readLine().trim()));
			while ((temp = fis.read())!= -1) {
				fos.write(temp);
				size++;
			}
			System.out.println(size+"byte FileCopy Success!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(fis != null) fis.close();
				if(fos != null) fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	public void fileCopy(String origin, String change) {
		
		long start = System.currentTimeMillis();
		
		try(FileInputStream fis = new FileInputStream(origin);
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos = new FileOutputStream(change);
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			bos.write(bis.readAllBytes());
			System.out.println("FileCopy Success!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0);
	}
	public void fileBufferCopy(String origin, String change) {
		byte []cp = new byte[30000];
		try(BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(new File(origin)));
			BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(new File(change)))) {
//			bos.write(bis.readAllBytes());
			bis.read(cp);
			bos.write(new String(cp).trim().getBytes());
			//공백 자르고 다시 바이트로 바꾸기
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void fileCopy_char(String origin, String change) {
		try(BufferedReader br = new BufferedReader(new FileReader(origin));
			BufferedWriter bw = new BufferedWriter(new FileWriter(change))
				) {
			for(String str = br.readLine();str != null;) {
				str += "\n";
				bw.write(str);
				str = br.readLine();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_HHmmss");
		
		ByteStreamEx ex = new ByteStreamEx();
//		ex.fileBufferCopy("D:/자료/Heap_01.png",
//				"D:/자료/Copyfolder/Heap_01_"+ formatter.format(date) + 
//				".png");
		ex.fileCopy_char("D:/자료/230321 문제.txt",
				"D:/자료/Copyfolder/230321 문제_"+ formatter.format(date) + 
				".txt");
	}
}
