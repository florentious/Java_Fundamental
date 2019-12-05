package java_20191205.multicast.client;

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class MultiClientThread implements Runnable{
	BufferedReader br;
	JTextArea jta;
	
	public MultiClientThread(BufferedReader br, JTextArea jta) {
		this.br = br;
		this.jta = jta;
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				String readLine = br.readLine();
				
				if(readLine.equals("exit")) {					//message가 exit면 종료
					System.exit(0);
					//break;
				}
				
				jta.append(readLine+"\n");
				jta.setCaretPosition(jta.getDocument().getLength());
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}
}
