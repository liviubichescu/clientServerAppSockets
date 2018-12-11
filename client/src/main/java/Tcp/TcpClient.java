package Tcp;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class TcpClient {

    private ExecutorService executorService;

    public TcpClient(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void sumElementsList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        executorService.submit(() -> {

            try (Socket socket = new Socket("localhost", 1234);
                 InputStream is = socket.getInputStream();
                 OutputStream os = socket.getOutputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                String request = "sumElementsList" + "\n" + list.toString().substring(1, list.toString().length() -1) + "\n";
                System.out.println("client - sending request: " + request);
                os.write(request.getBytes());

                String result = br.readLine();
                System.out.println("client - sumElementsList() - result: " + result);

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }


    public void productElementsList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        executorService.submit(() -> {

            try (Socket socket = new Socket("localhost", 1234);
                 InputStream is = socket.getInputStream();
                 OutputStream os = socket.getOutputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                String request = "productElementsList" + "\n" + list.toString().substring(1, list.toString().length() -1) + "\n";
                System.out.println("client - sending request: " + request);
                os.write(request.getBytes());

                String result = br.readLine();
                System.out.println("client - productElementsList() - result: " + result);

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

}
