import tcpC.Console;
import tcpC.TcpClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientApp {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        TcpClient tcpClient = new TcpClient(executorService);

        Console console = new Console(executorService,tcpClient);
        console.start();

        executorService.shutdownNow();
    }

}


