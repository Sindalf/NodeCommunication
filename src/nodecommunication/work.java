package nodecommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class work {

    public void getInfo() throws IOException {


        

        try ( 
            ServerSocket serverSocket = new ServerSocket(4444);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
        
            String inputLine, outputLine;
            

            System.out.println("test");
            while ((inputLine = in.readLine()) != null) {
                outputLine = inputLine;
                out.println(outputLine);
                if (outputLine.equals("Bye."))
                    break;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
