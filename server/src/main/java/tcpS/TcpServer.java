package tcpS;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpServer {

    public void startServer() {
        ExecutorService executorService =
                Executors.newFixedThreadPool(
                        Runtime.getRuntime().availableProcessors());

        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("server - STARTED -");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("server - CLIENT CONNECTED");

                executorService.submit(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(
                Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (InputStream is = clientSocket.getInputStream();
                 OutputStream os = clientSocket.getOutputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                String name = br.readLine();
                System.out.println("server - RECEIVED REQUEST: " + name);

                if (name.equals("sumElementsList")) {
                    sumOfListIntegers(is, os, br);
                }
                else if (name.equals("productElementsList")){
                    productOfListIntegers(is,os,br);
                }
                else if (name.equals("divisibleNumbersInNumberRange")){
                    returnNumbersInTheIntervalDivisibleByD(is,os,br);
                }
                else if (name.equals("last2digitsDivisibility")){
                    returnNumbersInTheIntervalDivisibleByD(is,os,br);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (clientSocket != null) {
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void sumOfListIntegers(InputStream is, OutputStream os, BufferedReader br ) throws IOException {
            String args = br.readLine();
            String[] arr = args.split(", ");

            int sum = 0;
            for (String nr : arr) {
                int number = Integer.parseInt(nr);
                sum = sum + number;
            }

            String response = sum + "\n";
            System.out.println("server => CALCULATED RESPONSE: "+response);
            os.write(response.getBytes());
        }

        private void productOfListIntegers(InputStream is, OutputStream os, BufferedReader br ) throws IOException {
            String args = br.readLine();
            String[] arr = args.split(", ");

            int product = 1;
            for (String nr : arr) {
                int number = Integer.parseInt(nr);
                product = product * number;
            }

            String response = product + "\n";
            System.out.println("server => CALCULATED RESPONSE: "+response);
            os.write(response.getBytes());
        }

        private void  returnNumbersInTheIntervalDivisibleByD(InputStream is, OutputStream os, BufferedReader br ) throws IOException {
            String args = br.readLine();
            String[] arr = args.split(", ");

            int firstNr = Integer.parseInt(arr[0]);
            int secondNr = Integer.parseInt(arr[1]);
            int thirdNr = Integer.parseInt(arr[2]);
            List<Integer> respList = new ArrayList<>();
            for (int i=firstNr; i<=secondNr; i++) {
                if (i%thirdNr==0){
                    respList.add(i);
                }
            }

            String response = respList + "\n";
            System.out.println("server => CALCULATED RESPONSE: "+response);
            os.write(response.getBytes());
        }

        private void  lastTwoNumbersDivisibility(InputStream is, OutputStream os, BufferedReader br ) throws IOException {
            String args = br.readLine();
            String[] arr = args.split(", ");

            int firstNr = Integer.parseInt(arr[0]);
            int secondNr = Integer.parseInt(arr[1]);
            String third = arr[2].substring(arr[2].length()-2);
            int thirdNr = Integer.parseInt(third);
            List<Integer> respList = new ArrayList<>();
            for (int i=firstNr; i<=secondNr; i++) {
                if (i%thirdNr==0){
                    respList.add(i);
                }
            }

            String response = respList + "\n";
            System.out.println("server => CALCULATED RESPONSE: "+response);
            os.write(response.getBytes());
        }


    }

}
