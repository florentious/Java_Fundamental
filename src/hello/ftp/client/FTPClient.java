package hello.ftp.client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class FTPClient {
	private String ip;
	private int port;
	private String fileName;
	private String abs;

	public FTPClient() {
		this.ip = "222.112.96.177";
		this.port = 6060;
		this.fileName = "driver_booster_setup.exe";
		this.abs = "d:\\dev\\ioTest\\client\\";
	}

	public FTPClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
		this.fileName = "driver_booster_setup.exe";
		this.abs = "d:\\dev\\ioTest\\client\\";
	}

	public void connect() {
		Socket socket = null;

		BufferedWriter bw = null;
		InputStream in = null;
		FileOutputStream fos = null;
		
		new File(abs).mkdirs();

		try {
			socket = new Socket(ip, port);

			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = socket.getInputStream();

			fos = new FileOutputStream(abs + fileName);

			bw.write(fileName);
			bw.newLine();
			bw.flush();

			int readByteCount = 0;
			byte[] readByte = new byte[1024 * 8];

			while ((readByteCount = in.read(readByte)) != -1) {
				fos.write(readByte, 0, readByteCount);
			}

			System.out.printf("Download[%s] Done!%n", fileName);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)	bw.close();
				if (fos != null) fos.close();
				if (in != null) in.close();
				if (socket != null) socket.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new FTPClient("222.112.96.177", 6060).connect();
	}
}
