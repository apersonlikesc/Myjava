
import java.io.*;
import java.net.*;

public class Sever {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(4444);
		Socket Client = null;
		BufferedReader inFromClient = null;
		PrintWriter out2Client = null;
		
		Client = serverSocket.accept();
		if(Client != null){
				System.out.println("���ӳɹ�!");
		}else{
				System.out.println("����ʧ��!");
				System.exit(1);
		}
		out2Client = new PrintWriter(Client.getOutputStream(),true);//��ȥ����
		inFromClient = new BufferedReader(new InputStreamReader(Client.getInputStream()));//��������
		
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
		boolean sinbye = false;
		boolean cinbye = false;
		String sinputLine = null;
		String cinputLine = null;
		while(true) {
			if(cinbye == false) {
				cinputLine = inFromClient.readLine();
				System.out.println("Clinet say:"+cinputLine);
				if(cinputLine.compareToIgnoreCase("bye") == 0) {
					cinbye = true;
				}
			}
			if(sinbye == false) {
				System.out.print("Server say:");
				sinputLine = sin.readLine();
				
			}
			
			if(sinbye == false) {
				out2Client.println(sinputLine);
				//out2Client.flush();
				//System.out.println("sinputline:"+sinputLine);
				if(sinputLine.compareToIgnoreCase("bye")== 0) {
				sinbye = true;
			}
			}
			
			if(sinbye == true && cinbye == true) {
				break;
			}
			
		}
			out2Client.close();
			inFromClient.close();
			sin.close();
			Client.close();
			serverSocket.close();
	}
}
