package sg.edu.nus.iss;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Random;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.ServerSocket;
import java.util.List;
import java.util.ArrayList;




public final class server {
    private server(){

    }
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        //Initiate  to store keyboard input, and socket return value
        String keyInput = "", listRecv = "";


        //Open the Socket Server to listen on Port 5000 for any inputs and wait for client to connect */ 
        System.out.println("Server is listening successfully on Port 5000");
        ServerSocket ss = new ServerSocket(5000);
        //Wait for the client to connect
        Socket cs = ss.accept();
        
        // Random Class to carry out randomized operation
        Random random = new Random();

        // Generate a list of random numbers from 0 to 99
        Integer randomNumber = random.nextInt(100);
        List<Double> randomNumberss = new ArrayList<>();

        try (//Prepare to send data out to client via socket (Outbound)
        OutputStream os = cs.ObjectOutputStream()) {
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            try (// Send the generated list to the client
            OutputStream out = cs.ObjectOutputStream()) {
                out.write(Arrays.ToString(randomNumber).getBytes());
            }
            //Prepare to receive input from client via socket (Inbound)
             InputStream is = cs.getInputStream();
             BufferedInputStream bis = new BufferedInputStream(is);
             DataInputStream dis = new DataInputStream(bis);

            //Client receives list of random numbers
            listRecv = dis.readUTF();
            System.out.println("From server: " + listRecv);

            //Mean(average) & Standard Deviation calculations
            Float mean = (float) 0;
            for (Double d : randomNumberss) {
                mean += d;
            }
            mean /= randomNumberss.size();

            float stDev = 0;
            for (Double d : randomNumberss) {
                stDev += (d - mean) * (d - mean);
            }
            stDev = (float) Math.sqrt(stDev / randomNumberss.size());


            // Send the calculations to server
            if (randomNumber!=0) {

                dos.writeUTF("Received Name: Ravishankar Rajagopal.");
                dos.writeUTF("Received Email: ravishankar_rajagopal@outlook.com");
                dos.writeUTF("Received Mean:" + mean);
                dos.writeUTF("Received Standard Deviation:" + stDev);
            
            
            
            
            
            // close the socket input and output stream
            
            dos.close();
            bos.close();
            os.close();

            dis.close();
            is.close();
            bis.close();
            
            cs.close();
            ss.close();
            }
        }
    }
}