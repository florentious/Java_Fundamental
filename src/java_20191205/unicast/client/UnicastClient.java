package java_20191205.unicast.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UnicastClient implements ActionListener {
	private JFrame jframe;
	private JTextArea jta;
	private JButton jbtn;
	private JTextField jtf;
	private String id;
	private String ip;
	private int port;
	
	private BufferedReader br;
	private BufferedWriter bw;
	private Socket socket;
	
	public UnicastClient(String id, String ip, int port) {
		this.id = id;
		this.ip = ip;
		this.port = port;
		
		br = null;
		bw = null;
		socket = null;
		
		jframe = new JFrame("Unicast Chatting");			// frame 생성
		
		/** North Start */
		// 프레임 구역 당 1개이므로 패널이라는 컨테이너를 만들어서 컨테이너안에 다른걸 넣어 프레임에 넣는다.
		JPanel j1 = new JPanel();
		JLabel jl1 = new JLabel("user ID : ["+id+"]");
		JLabel jl2 = new JLabel("Server IP : "+ip);
		
		j1.setLayout(new BorderLayout());
		j1.add(jl1,BorderLayout.CENTER);
		j1.add(jl2,BorderLayout.EAST);
		// North End
		
		/** Center Start */
		jta = new JTextArea("",30,30);
		jta.setBackground(new Color(220,220,255));
		jta.setEditable(false);
		
		// JScrollPane 스크롤 넣을 대상, 수직, 수평
		JScrollPane jsp = new JScrollPane(jta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setBackground(new Color(220,220,255));
		
		// Center end
		
		/** South start */
		
		JPanel j2 = new JPanel();
		jtf = new JTextField(30);
		jbtn = new JButton("Send");
		j2.setLayout(new BorderLayout());
		j2.add(jtf,BorderLayout.CENTER);
		j2.add(jbtn,BorderLayout.EAST);
		// South End
		
		// frame 에 layout 붙이기
		jframe.add(j1,BorderLayout.NORTH);
		jframe.add(jsp,BorderLayout.CENTER);		// BodrerLayout.CENTER
		jframe.add(j2,BorderLayout.SOUTH);
		
		
		jframe.pack();
		jframe.setResizable(false);
		jframe.setVisible(true);
		// 꺼도 직접 죽여야됨
		
		jbtn.addActionListener(this);
		jtf.addActionListener(this);
		
		jframe.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				
				try {
					bw.write("exit");
					bw.newLine();
					bw.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					if(bw!=null) bw.close();
					if(br!=null) br.close();
					if(socket!=null) socket.close();
					
					
				} catch (Exception exception) {
					// TODO: handle exception
					exception.printStackTrace();
				}	
				System.exit(0);
			}
			
			public void windowOpened(WindowEvent e) {
				jtf.requestFocus();
			}
		});
		
		// socket
		
		
	}
	
	
	// Event Listener
	@Override 
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String message = jtf.getText();
		if(obj == jbtn) {
			try {
				bw.write(id + " : " + message);
				bw.newLine();
				bw.flush();
								
				jta.append( br.readLine() + "\n");			// 텍스트 필드에 있는거보내고 개행
				jtf.setText("");									// 보내면 초기화
				
			} catch (IOException exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			
			
		} else if(obj ==jtf) {									// enter 치면 jtf로 리턴됨
			
			try {
				bw.write(id + " : " + message);
				bw.newLine();
				bw.flush();
				
				jta.append( br.readLine() + "\n");			// 텍스트 필드에 있는거보내고 개행
				jtf.setText("");	
				
			} catch (IOException exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			
		}
	}
	
	
	public void connect() {
		
		try {
			socket = new Socket(ip,port);
			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	
	// main
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new UnicastClient("Florentious","192.168.0.226",3000).connect();
		
		
	}
}
