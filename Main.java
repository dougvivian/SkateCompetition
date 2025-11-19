import java.util.Scanner;

/*
 * Colocar os fluxos do que está acontecendo na tela
 * Pro usuário não se perder
 */

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Skatista skatista;
    static Skatista oponenteA;
    static Skatista oponenteB;

    public static void Main() {
        criarPersonagens();
        exibirMenuInicial();
        comecarJogo();
    }
    
    static private void criarPersonagens() {
        String nome;
        String skatistaEstilo;
        int idade;
        int opcaoEstilo = 0;

        System.out.println("Informe o nome do seu personagem skatista:");
        nome = scanner.next();

        do {
            System.out.println("Informe o estilo (1: Regular; 2: Goofy):");
            opcaoEstilo = scanner.nextInt();

            if (opcaoEstilo  == 1) {
                skatistaEstilo = "Regular";
            } else if (opcaoEstilo  == 2) {
                skatistaEstilo = "Goofy";
            }
        } while (opcaoEstilo != 0 || opcaoEstilo != 1)

        System.out.println("Informe a idade:");
        idade = scanner.nextInt();
        
        skatista = new Skatista(nome, skatistaEstilo, idade);
        oponenteA = new Skatista();
        oponenteB = new Skatista();

        System.out.println("Boas-vindas ao Skate Competition, " + skatista.getNome());
    }

    static private exibirMenuInicial() {
        int opcao;
        
        do {
            System.out.println("Informe a opção");
            System.out.println("1: Editar personagem");
            System.out.println("2: Mostrar competidores");
            System.out.println("3: Iniciar jogo");
            opcao = scanner.nextInt();
        
            switch (opcao) {
                case 1:
                    System.out.println("Editar personagem");
                    System.out.println("Informe o novo nome do personagem:");
                    skatista.setNome(scanner.next());
                    System.out.println("Informe o novo estilo do personagem:");
                    skatista.setEstilo(scanner.next());
                    System.out.println("Informe a nova idade do personagem:");
                    skatista.setIdade(scanner.nextInt());
                    System.out.println("Personagem atualizado!");
                    System.out.println(skatista);
                    break;
                case 2:
                    System.out.println(skatista);
                    System.out.println(oponenteA);
                    System.out.println(oponenteB);
                    break;
                case 3:
                    System.out.println("O jogo vai começar...");
                    break;
                default:
                    System.out.println("Opção inválida, escolha uma nova opção");
            }
        } while (opcao != 3);
    }
    
    static private void comecarJogo() {
        /**
         * Iniciar obstáculos
         * Iniciar manobras
         * Iniciar etapa Linha
         * Iniciar etapa Obstáculo (isso tem que mudar de nome)
         */
    }
}
