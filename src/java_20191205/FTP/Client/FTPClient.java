package java_20191205.FTP.Client;

import java.io.BufferedWriter;
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

	public FTPClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
		this.fileName = null;
		this.abs = "c:\\dev\\io\\2019\\12\\";
	}

	public FTPClient(String ip, int port, String fileName) {
		this.ip = ip;
		this.port = port;
		this.fileName = fileName;
		this.abs = "c:\\dev\\io\\2019\\12\\";
	}

	public FTPClient(String ip, int port, String fileName, String abs) {
		this.ip = ip;
		this.port = port;
		this.fileName = fileName;
		this.abs = abs;
	}

	public void connect() {
		Socket socket = null;

		BufferedWriter bw = null;
		InputStream in = null;
		FileOutputStream fos = null;

		try {
			// connect by socket
			socket = new Socket(ip, port);

			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = socket.getInputStream();
			fos = new FileOutputStream(abs + fileName);

			// output fileName
			bw.write(fileName);
			bw.newLine();
			bw.flush();

			int readByteCount = 0;
			byte[] readBytes = new byte[1024 * 8];

			while ((readByteCount = in.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByteCount);
			}

			System.out.println("Download Done - " + abs + fileName);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.err.println("Unkown Host Address and Port");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Not Found file, Please Input Correct FileName");
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (in != null)
					in.close();
				if (fos != null)
					fos.close();
				if (socket != null)
					socket.close();

			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Can't DownLoad");
			}

		}

	}

	public static void main(String[] args) {
		new FTPClient("192.168.0.226", 3050).connect();
	}
}
