package process;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exec {
	public static void main(String args[]) {
		
		try {
			String line;
			// /c : 내부 명령을 실행하고 명령창을 종료하는 옵션
			Process p = Runtime.getRuntime().exec("cmd /c dir");
			BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((line = bri.readLine()) != null) {
				System.out.println(line);
			}
			bri.close();
			
			while ((line = bre.readLine()) != null) {
				System.out.println(line);
			}
			bre.close();
			
			// 프로세스의 수행이 끝이 날때까지 기다린다.
			// waitFor() 함수를 호출하는 순간, Thread 는 process 가 종료될때까지 block 이 됩니다.
			
//			Runtime exec 실행시 waitFor 행 걸리는 문제 그리고 inputstream read 행걸리는 문제
//			해결: waitFor() 수행전에 Process 버퍼를 비워준다. 만약 process 수행결과를 얻어지는 출력이 필요하지 않다면 아래처럼 stream 을 close 해준다.
//			process.getErrorStream().close();
//			process.getInputStream().close();
//			process.getOutputStream().close();
//			process.waitFor(); 

			p.waitFor();
			System.out.println("Done.");
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}
