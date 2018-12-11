import Tcp.TcpServer;

public class ServerApp {

    public static void main(String[] args) {

        TcpServer tcpServer=new TcpServer();

        tcpServer.startServer();

    }
}
