import java.util.Scanner;

public class Main {
    public static void Main() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        System.out.println("Informe a opção");
        opcao = scanner.nextInt();
        
        while (opcao != 9) {
            switch (opcao) {
                case 1:
                    System.out.println("opcao 1");
                    break;
                case 2:
                    System.out.println("opcao 2");
                    break;
                case 9:
                    System.out.println("opcao 9 finalizou");
                    break;
                default:
                    System.out.println("Opção inválida, escolha uma nova opção");
            }
            
            opcao = scanner.nextInt();
        }
    }
}
