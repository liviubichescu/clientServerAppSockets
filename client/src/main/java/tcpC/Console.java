package tcpC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class Console {

    private ExecutorService executorService;
    private TcpClient tcpClient;

    public Console(ExecutorService executorService, TcpClient tcpClient) {
        this.executorService = executorService;
        this.tcpClient = tcpClient;
    }

    public void menu() {
        System.out.println();
        System.out.println("1. Compute the sum of a given list of integers");
        System.out.println("2. Compute the product of a given list of integers");
        System.out.println("3. Given three natural numbers a, b, and d, return all numbers in the interval [a, b] that are divisible by d");
        System.out.println("4. Given three natural numbers a, b, and d, return all numbers in the interval [a, b] whose last two digits (considered as one number) are divisible by d");
        System.out.println("0. exit");
        System.out.println("Type your option: ");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            int opt = scanner.nextInt();
            if (opt == 0) {
                break;
            }
            switch (opt) {
                case 1:
                    sumElements();
//                executorService.wait();
                    break;
                case 2:
                    productElements();
                    break;
                case 3:
                    divisibleElements();
                    break;
                case 4:
                    divisibleLast2Elements();
                    break;
                default:
                    System.out.println("This option is not yet implemented!!!");
            }
        }
    }

    private void sumElements() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.println("Specify the size of the list elements: ");
        int size = scanner.nextInt();

        for (int i = 1; i <= size; i++) {
            System.out.println("Add element " + i + ": ");
            int nr = scanner.nextInt();
            list.add(nr);
        }
        tcpClient.sumElementsList(list);
    }

    private void productElements() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.println("Specify the size of the list elements: ");
        int size = scanner.nextInt();

        for (int i = 1; i <= size; i++) {
            System.out.println("Add element " + i + ": ");
            int nr = scanner.nextInt();
            list.add(nr);
        }
        tcpClient.productElementsList(list);
    }

    private void divisibleElements() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.println("Specify first natural number: ");
        int firstNr = scanner.nextInt();
        list.add(firstNr);
        System.out.println("Specify second natural number: ");
        int secondtNr = scanner.nextInt();
        list.add(secondtNr);
        System.out.println("Specify number for division: ");
        int thirdNr = scanner.nextInt();
        list.add(thirdNr);

        tcpClient.divisibleNumbersInNumberRange(list);
    }

    private void divisibleLast2Elements() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.println("Specify first natural number: ");
        int firstNr = scanner.nextInt();
        list.add(firstNr);
        System.out.println("Specify second natural number: ");
        int secondtNr = scanner.nextInt();
        list.add(secondtNr);
        System.out.println("Specify number for division: ");
        int thirdNr = scanner.nextInt();
        list.add(thirdNr);

        tcpClient.last2digitsDivisibility(list);
    }


}
