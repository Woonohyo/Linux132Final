import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;


public class Exam1 {
	public static void main(String[] args) throws Exception {
		String path1;
		String path2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("복사하고 싶은 원본 파일의 경로를 입력하세요.");
		path1 = sc.nextLine();		
		File f1 = new File(path1);
		
		System.out.println("파일을 복사할 경로를 입력해주세요.");
		path2 = sc.nextLine();
		File f2 = new File(path2);
	
		if ( !(f1.isDirectory()) ) {
			FileInputStream fis = new FileInputStream(path1);
			FileOutputStream fos = new FileOutputStream(path2);

			int data = 0;
			while((data=fis.read()) != -1)
				fos.write(data);	
		
			fis.close();
			fos.close();
		} else
			System.out.println("디렉토리는 복사할 수 없습니다.");
	}
}
