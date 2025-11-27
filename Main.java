import java.util.Scanner;
import java.util.Random;
/*
 * Colocar os fluxos do que está acontecendo na tela
 * Pro usuário não se perder
 */

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static Skatista skatista;
    static Skatista oponenteA;
    static Skatista oponenteB;

    static Obstaculo caixote;
    static Obstaculo hidrante;
    static Obstaculo gapComRampa;
    static Obstaculo piramide;
    static Obstaculo rampa;
    static Obstaculo mesa;
    static Obstaculo corrimao;
    static Obstaculo corrimaoCurvado;
    static Obstaculo escada;

    static Manobra frontsideOllie;
    static Manobra kickflip;
    static Manobra heelflip;
    static Manobra fakieFlip;
    static Manobra boardSlide;
    static Manobra doubleFlip;
    static Manobra lateFlip;
    static Manobra frontsideFlip;
    static Manobra backsideFlip;
    static Manobra hardFlip;
    static Manobra kickflip360;
    static Manobra cabalerialFlip;
    static Manobra nollieBigspinHeelflip;
    static Manobra bluntSlide;
    static Manobra boardSlideFlipOut;
    static Manobra switchKickflip720;

    public static void main() {
        criarPersonagens();
        exibirMenuInicial();
        iniciarObstaculos();
        iniciarManobras();
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
        } while (opcaoEstilo < 1 || opcaoEstilo > 2);

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

    static private void iniciarObstaculos() {
        caixote = new Obstaculo(ObstaculoNome.CAIXOTE, 1.7);
        hidrante = new Obstaculo(ObstaculoNome.HIDRANTE, 2);
        gapComRampa = new Obstaculo(ObstaculoNome.GAP_COM_RAMPA, 2.5);
        piramide = new Obstaculo(ObstaculoNome.PIRAMIDE, 3.5);
        rampa = new Obstaculo(ObstaculoNome.RAMPA, 4.3);
        mesa = new Obstaculo(ObstaculoNome.MESA, 5);
        corrimao = new Obstaculo(ObstaculoNome.CORRIMAO, 6);
        corrimaoCurvado = new Obstaculo(ObstaculoNome.CORRIMAO_CURVADO, 7.4);
        escada = new Obstaculo(ObstaculoNome.ESCADA, 8);
    }

    static private void iniciarManobras() {
        frontsideOllie = new Manobra(ManobraNome.FRONTSIDE_OLLIE, 0.5);
        kickflip = new Manobra(ManobraNome.KICKFLIP, 1);
        heelflip = new Manobra(ManobraNome.HEELFLIP, 1);
        fakieFlip = new Manobra(ManobraNome.FAKIE_FLIP, 1);
        boardSlide = new Manobra(ManobraNome.BOARD_SLIDE, 1);
        doubleFlip = new Manobra(ManobraNome.DOUBLE_FLIP, 2.5);
        lateFlip = new Manobra(ManobraNome.LATE_FLIP, 3.5);
        frontsideFlip = new Manobra(ManobraNome.FRONTSIDE_FLIP, 4);
        backsideFlip = new Manobra(ManobraNome.BACKSIDE_FLIP, 5);
        hardFlip = new Manobra(ManobraNome.HARD_FLIP, 5.5);
        kickflip360 = new Manobra(ManobraNome.KICKFLIP_360, 6);
        cabalerialFlip = new Manobra(ManobraNome.CABALERIAL_FLIP, 7);
        nollieBigspinHeelflip = new Manobra(ManobraNome.NOLLIE_BIGSPIN_HEELFLIP, 7.5);
        bluntSlide = new Manobra(ManobraNome.BLUNT_SLIDE, 7.8);
        boardSlideFlipOut = new Manobra(ManobraNome.BOARD_SLIDE_FLIP_OUT, 8);
        switchKickflip720 = new Manobra(ManobraNome.SWITCH_KICKFLIP_720, 9.5);
    }


    
    static private void comecarJogo() {
        /**
         * Iniciar etapa Linha
         * Iniciar etapa Impacto (isso tem que mudar de nome)
         */

        int opcaoObstaculo = 0;
        Obstaculo[] obstaculosLista = new Obstaculo[5];

        System.out.println("Vai começar a primeira etapa chamada Linha!");
        System.out.println("Escolha 5 obstáculos da lista abaixo para começar (digite um número de cada vez):");
        System.out.println("1: " + caixote);
        System.out.println("2: " + hidrante);
        System.out.println("3: " + gapComRampa);
        System.out.println("4: " + piramide);
        System.out.println("5: " + rampa);
        System.out.println("6: " + mesa);
        System.out.println("7: " + corrimao);
        System.out.println("8: " + corrimaoCurvado);
        System.out.println("9: " + escada);

        int i;
        for (i = 0; i < 5; i++) {
            do {
                System.out.println("Escolha obstáculo de número " + (i + 1));
                opcaoObstaculo = scanner.nextInt();
                switch (opcaoObstaculo) {
                    case 1:
                        obstaculosLista[i] = caixote;
                        break;
                    case 2:
                        obstaculosLista[i] = hidrante;
                        break;
                    case 3:
                        obstaculosLista[i] = gapComRampa;
                        break;
                    case 4:
                        obstaculosLista[i] = piramide;
                        break;
                    case 5:
                        obstaculosLista[i] = rampa;
                        break;
                    case 6:
                        obstaculosLista[i] = mesa;
                        break;
                    case 7:
                        obstaculosLista[i] = corrimao;
                        break;
                    case 8:
                        obstaculosLista[i] = corrimaoCurvado;
                        break;
                    case 9:
                        obstaculosLista[i] = escada;
                        break;
                }
                System.out.println("Você escolheu o obstáculo " + obstaculosLista[i]);  
            } while (opcaoObstaculo < 1 || opcaoObstaculo > 9);
        }
        
        //criei o objeto Etapa linha
        Etapa linha = new Etapa(EtapaNome.LINHA, obstaculosLista);
        System.out.println("\nETAPA: " + linha.getNome());
        System.out.println("Obstáculos escolhidos: ");

        for (Obstaculo o : linha.getObstaculos()) {
            System.out.println("- " + o);
            }
        
        int opcaoManobra = 0;
        
        Manobra[] manobrasLista = new Manobra[5];

        System.out.println("Escolha 5 manobras da lista abaixo para começar (digite um número de cada vez):");
        System.out.println("1: Front Ollie");
        System.out.println("2: Kickflip");
        System.out.println("3: Heelflip");
        System.out.println("4: Fakie flip");
        System.out.println("5: Board Slide");
        System.out.println("6: Late Flip");
        System.out.println("7: Frontside Flip");
        System.out.println("8: Backside Flip");
        System.out.println("9: Hard Flip");
        System.out.println("10: Kickflip 360");
        System.out.println("11: Cabalerial Flip");
        System.out.println("12: Nollie Bigspin Heelflip");
        System.out.println("13: Blunt Slide");
        System.out.println("14: Board Slide Flip Out");
        System.out.println("15: Switch Kickflip 720");

        for (i = 0; i < 5; i++) {
            do {
                if (obstaculosLista[i] != null) {
                System.out.println("Escolha a manobra para executar no obstáculo " + obstaculosLista[i].getNome());
                }
                opcaoManobra = scanner.nextInt();
                switch (opcaoManobra) {
                    case 1:
                        manobrasLista[i] = frontsideOllie;
                        break;
                    case 2:
                        manobrasLista[i] = kickflip;
                        break;
                    case 3:
                        manobrasLista[i] = heelflip;
                        break;
                    case 4:
                        manobrasLista[i] = fakieFlip;
                        break;
                    case 5:
                        manobrasLista[i] = boardSlide;
                        break;
                    case 6:
                        manobrasLista[i] = lateFlip;
                        break;
                    case 7:
                        manobrasLista[i] = frontsideFlip;
                        break;
                    case 8:
                        manobrasLista[i] = backsideFlip;
                        break;
                    case 9:
                        manobrasLista[i] = hardFlip;
                        break;
                    case 10:
                        manobrasLista[i] = kickflip360;
                        break;
                    case 11:
                        manobrasLista[i] = cabalerialFlip;
                        break;
                    case 12:
                        manobrasLista[i] = nollieBigspinHeelflip;
                        break;
                    case 13:
                        manobrasLista[i] = bluntSlide;
                        break;
                    case 14:
                        manobrasLista[i] = boardSlideFlipOut;
                        break;
                    case 15:
                        manobrasLista[i] = switchKickflip720;
                        break;
                }
                System.out.println("Você escolheu a manobra: "+ manobrasLista[i]+ " para o obstáculo: " + obstaculosLista[i]); 
            } while (opcaoManobra < 1 || opcaoManobra > 15);
        }
        // Etapa linha = new Etapa(EtapaNome.LINHA);
        // Etapa impacto = new Etapa(EtapaNome.IMPACTO);
    }
}

