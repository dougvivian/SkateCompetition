import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void Main() {
        Skatista skatista = this.criarSkatista();

        System.out.println("Boas-vindas ao Skate Competition, " + skatista.getNome());

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

    private Skatista criarSkatista() {
        String nome;
        SkatistaEstilo skatistaEstilo;
        int idade;

        System.out.println("Informe o nome do seu personagem skatista:");
        nome = scanner.next();

        System.out.println("Informe o estilo ('REGULAR' ou 'GOOFY':");
        skatistaEstilo = scanner.next();

        System.out.println("Informe a idade:");
        idade = scanner.nextInt();
        
        Skatista skatista = new Skatista(nome, skatistaEstilo, idade);
        return skatista;
    }
}
