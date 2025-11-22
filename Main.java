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
        String skatistaEstilo = null;
        int idade;
        int opcaoEstilo = 0;

        System.out.println("Informe o nome do seu personagem skatista:");
        nome = scanner.next();

        do {
            System.out.println("Informe o estilo (1: Regular; 2: Goofy):");
            opcaoEstilo = scanner.nextInt();

            if (opcaoEstilo == 1) {
                skatistaEstilo = "Regular";
            } else if (opcaoEstilo == 2) {
                skatistaEstilo = "Goofy";
            }
        } while (opcaoEstilo != 1 || opcaoEstilo != 2);

        System.out.println("Informe a idade:");
        idade = scanner.nextInt();
        
        skatista = new Skatista(nome, skatistaEstilo, idade);
        oponenteA = new Skatista();
        oponenteB = new Skatista();

        System.out.println("Boas-vindas ao Skate Competition, " + skatista.getNome());
    }

    static private void exibirMenuInicial() {
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
                    
                    /**
                     * Corrigir o scanner abaixo
                     * Tem que ser só goofy ou regular
                     */
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
        Obstaculo hidrante = new Obstaculo(ObstaculoNome.HIDRANTE, 2);
        Obstaculo rampa = new Obstaculo(ObstaculoNome.RAMPA, 4);
        Obstaculo mesa = new Obstaculo(ObstaculoNome.MESA, 5);
        Obstaculo corrimao = new Obstaculo(ObstaculoNome.CORRIMAO, 6);
        Obstaculo escada = new Obstaculo(ObstaculoNome.ESCADA, 8);
        
        Manobra frontsideOllie = new Manobra(ManobraNome.FRONTSIDE_OLLIE, 0.5);
        Manobra kickflip = new Manobra(ManobraNome.KICKFLIP, 1);
        Manobra heelflip = new Manobra(ManobraNome.HEELFLIP, 1);
        Manobra fakieFlip = new Manobra(ManobraNome.FAKIE_FLIP, 1);
        Manobra boardSlide= new Manobra(ManobraNome.BOARD_SLIDE, 1);
        Manobra doubleFlip = new Manobra(ManobraNome.DOUBLE_FLIP, 2.5);
        Manobra lateFlip = new Manobra(ManobraNome.LATE_FLIP, 3.5);
        Manobra frontsideFlip = new Manobra(ManobraNome.FRONTSIDE_FLIP, 4);
        Manobra backslideFlip = new Manobra(ManobraNome.BACKSIDE_FLIP, 5);
        Manobra hardFlip = new Manobra(ManobraNome.HARD_FLIP, 5.5);
        Manobra kickflip360 = new Manobra(ManobraNome.KICKFLIP_360, 6);
        Manobra cabalerialFlip= new Manobra(ManobraNome.CABALERIAL_FLIP, 7);
        Manobra nollieBigspinHeelflip = new Manobra(ManobraNome.NOLLIE_BIGSPIN_HEELFLIP, 7.5);
        Manobra bluntSlide = new Manobra(ManobraNome.BLUNT_SLIDE, 7.8);
        Manobra boardSlideFlipOut = new Manobra(ManobraNome.BOARD_SLIDE_FLIP_OUT, 8);
        Manobra switchKickflip720 = new Manobra(ManobraNome.SWITCH_KICKFLIP_720, 9.5);
        
        /**
         * Iniciar etapa Linha
         * - udcghshcbsd
         * Iniciar etapa Obstáculo (isso tem que mudar de nome)
         * - cjnsdcjnsd
         */
        
        // new Etapa(EtapaNome.LINHA);
        // new Etapa(EtapaNome.IMPACTO);
    }
}
