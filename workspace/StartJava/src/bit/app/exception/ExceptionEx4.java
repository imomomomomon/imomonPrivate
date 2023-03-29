package bit.app.exception;
import java.util.Scanner;

public class ExceptionEx4 {
	Scanner scanner = new Scanner(System.in);
	public void exceptionAction() {
		System.out.println("Data Input:");
		int value = scanner.nextInt();
		try {
			if (value < 0 || value >= 100) {
				throw new UserException("양수 0~100까지만..");
			}
			System.out.println(value+" 정상입력120");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ExceptionEx4 e = new ExceptionEx4();
		e.exceptionAction();
	}
}
