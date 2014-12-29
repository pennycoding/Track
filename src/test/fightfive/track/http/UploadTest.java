package test.fightfive.track.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.fightfive.track.http.HttpTools;

import android.test.AndroidTestCase;

public class UploadTest extends AndroidTestCase {

	public void testUploadJSON() {
		new Thread(new Server()).start();

		String url = "http://127.0.0.1:8080/";
		String json = "json\r\n";
		//Upload.uploadJSON(url, json);

	}

	class Server implements Runnable {

		@Override
		public void run() {
			ServerSocket ss;
			try {
				ss = new ServerSocket(8080);
				Socket s = ss.accept();
				InputStreamReader reader = new InputStreamReader(
						s.getInputStream());
				BufferedReader bufr = new BufferedReader(reader);
				String line = null;
				while ((line = bufr.readLine()) != null) {
					System.out.println("line: "+line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
