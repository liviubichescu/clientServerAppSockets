package tcpC;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class TcpClient {

    private ExecutorService executorService;

    public TcpClient(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void sumElementsList(List<Integer> list) {

        executorService.submit(() -> {

            try (Socket socket = new Socket("localhost", 1234);
                 InputStream is = socket.getInputStream();
                 OutputStream os = socket.getOutputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                String request = "sumElementsList" + "\n" + list.toString().substring(1, list.toString().length() -1) + "\n";
//                System.out.println("client - sending request: " + request);
                os.write(request.getBytes());

                String result = br.readLine();
                System.out.println(result);

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }


    public void productElementsList(List<Integer> list) {

        executorService.submit(() -> {

            try (Socket socket = new Socket("localhost", 1234);
                 InputStream is = socket.getInputStream();
                 OutputStream os = socket.getOutputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                String request = "productElementsList" + "\n" + list.toString().substring(1, list.toString().length() -1) + "\n";
//                System.out.println("client - sending request: " + request);
                os.write(request.getBytes());

                String result = br.readLine();
                System.out.println(result);

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    public void divisibleNumbersInNumberRange(List<Integer> list) {

        executorService.submit(() -> {

            try (Socket socket = new Socket("localhost", 1234);
                 InputStream is = socket.getInputStream();
                 OutputStream os = socket.getOutputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                String request = "divisibleNumbersInNumberRange" + "\n" + list.toString().substring(1, list.toString().length() -1) + "\n";
//                System.out.println("client - sending request: " + request);
                os.write(request.getBytes());

                String result = br.readLine();
                System.out.println(result);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void last2digitsDivisibility(List<Integer> list) {

        executorService.submit(() -> {

            try (Socket socket = new Socket("localhost", 1234);
                 InputStream is = socket.getInputStream();
                 OutputStream os = socket.getOutputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                String request = "last2digitsDivisibility" + "\n" + list.toString().substring(1, list.toString().length() -1) + "\n";
//                System.out.println("client - sending request: " + request);
                os.write(request.getBytes());

                String result = br.readLine();
                System.out.println(result);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
