import java.io.File;
import java.util.Scanner;

public class Exam2 {
	static String absPath;
	
	public static void main(String[] args) {
		String path;
		String fileName;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("디렉토리 경로를 입력해주세요. (경로의 마지막은 '/' 로 닫아주세요)");
		path = sc.nextLine();
		
		System.out.println("파일의 이름을 입력해주세요.");
		fileName = sc.nextLine();
		
		if ( isFileExists(path, fileName) ) {
			absPath = path + fileName;
			printAbsolutePath();
		}
		else System.out.println("파일이 존재하지 않습니다.");
	}

	private static void printAbsolutePath() {
		System.out.println("파일의 전체 경로는");
		System.out.println(absPath);
		System.out.println("입니다.");		
	}

	private static boolean isFileExists(String path, String fileName) {
		absPath = path + fileName;
		
		File f1 = new File(absPath);
		if( f1.exists() )
			return true;
		else 
			return false;
		
	}

}
