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

    static Random random = new Random();

    static Obstaculo[] obstaculosLista;

    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";

    public static void main() {
        criarPersonagens();
        exibirMenuInicial();
        iniciarObstaculos();
        iniciarManobras();
        comecarJogo();
    }

    static private void print(String message) {
        System.out.println("\n" + message);
    }

    static private void print(String message, String color) {
        System.out.println(color + "\n" + message + RESET);
    }

    static private void printSeparador() {
        print("------------------------------");
    }

    static private void criarPersonagens() {
        String nome;
        String skatistaEstilo = null;
        int idade;
        int opcaoEstilo = 0;

        printSeparador();
        print("Informe o nome do seu personagem skatista:", GREEN);
        nome = scanner.nextLine();

        do {
            print("Informe o estilo (1: Regular; 2: Goofy):");
            opcaoEstilo = scanner.nextInt();
            if (opcaoEstilo == 1) {
                skatistaEstilo = "Regular";
            } else if (opcaoEstilo == 2) {
                skatistaEstilo = "Goofy";
            }
        } while (opcaoEstilo < 1 || opcaoEstilo > 2);

        print("Informe a idade:");
        idade = scanner.nextInt();

        skatista = new Skatista(nome, skatistaEstilo, idade);
        oponenteA = new Skatista();
        oponenteB = new Skatista();

        print("Boas-vindas ao Skate Competition, " + skatista.getNome(), GREEN);
        printSeparador();
    }

    static private void exibirMenuInicial() {
        int opcao;
        do {
            print("Informe a opção");
            print("1: Editar personagem");
            print("2: Mostrar competidores");
            print("3: Iniciar jogo");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    String novoNome;

                    print("Editar personagem", GREEN);
                    print("Informe o novo nome do personagem:");
                    novoNome = scanner.nextLine();
                    skatista.setNome(novoNome);

                    int novoEstiloOpcao = scanner.nextInt();
                    do {
                        print("Informe o novo estilo (1: Regular; 2: Goofy):");
                        novoEstiloOpcao = scanner.nextInt();
                        if (novoEstiloOpcao == 1) {
                            skatista.setEstilo("Regular");
                        } else if (novoEstiloOpcao == 2) {
                            skatista.setEstilo("Goofy");
                        }
                    } while (novoEstiloOpcao < 1 || novoEstiloOpcao > 2);

                    print("Informe a nova idade do personagem:");
                    int novaIdade = scanner.nextInt();
                    skatista.setIdade(novaIdade);

                    print("Personagem atualizado!");
                    print(skatista.toString());
                    printSeparador();
                    break;
                case 2:
                    print(skatista.toString());
                    print(oponenteA.toString());
                    print(oponenteB.toString());
                    break;
                case 3:
                    print("O jogo vai começar...");
                    break;
                default:
                    print("Opção inválida, escolha uma nova opção");
            }
        } while (opcao != 3);
    }

    // construtor dos obstáculos
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

    // construtor das manobras
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
        obstaculosLista = escolherObstaculos(5);

        Etapa linha = new Etapa(EtapaNome.LINHA, obstaculosLista);
        print("ETAPA: " + linha.getNome(), GREEN);

        skatista.adicionarNota(calcularNota());
        oponenteA.adicionarNota(calcularNota());
        oponenteB.adicionarNota(calcularNota());

        //

        obstaculosLista = escolherObstaculos(1);

        Etapa impacto = new Etapa(EtapaNome.IMPACTO, obstaculosLista);
        print("Etapa: " + impacto.getNome(), GREEN);

        skatista.adicionarNota(calcularNota());
        oponenteA.adicionarNota(calcularNota());
        oponenteB.adicionarNota(calcularNota());
    }

    static private Obstaculo[] escolherObstaculos(int quantidadeObstaculos) {
        int opcaoObstaculo = 0;
        Obstaculo[] obstaculosLista = new Obstaculo[quantidadeObstaculos];

        print("Vai começar a primeira etapa chamada Linha!");
        print("Escolha " + quantidadeObstaculos
                + " obstáculos da lista abaixo para começar (digite um número de cada vez):");
        print("1: " + caixote);
        print("2: " + hidrante);
        print("3: " + gapComRampa);
        print("4: " + piramide);
        print("5: " + rampa);
        print("6: " + mesa);
        print("7: " + corrimao);
        print("8: " + corrimaoCurvado);
        print("9: " + escada);

        int i;
        for (i = 0; i < quantidadeObstaculos; i++) {
            do {
                print("Escolha obstáculo de número " + (i + 1));
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
                print("Você escolheu o obstáculo " + obstaculosLista[i]);
            } while (opcaoObstaculo < 1 || opcaoObstaculo > 9);
        }

        print("Obstáculos escolhidos: ");

        for (i = 0; i < obstaculosLista.length; i++) {
            print("- " + obstaculosLista[i]);
        }

        return obstaculosLista;
    }

    static private Manobra[] escolherManobras() {
        int opcaoManobra = 0;
        Manobra[] manobrasLista = new Manobra[5];

        print("Escolha 5 manobras da lista abaixo para começar (digite um número de cada vez):");
        print("1: Front Ollie");
        print("2: Kickflip");
        print("3: Heelflip");
        print("4: Fakie flip");
        print("5: Board Slide");
        print("6: Late Flip");
        print("7: Frontside Flip");
        print("8: Backside Flip");
        print("9: Hard Flip");
        print("10: Kickflip 360");
        print("11: Cabalerial Flip");
        print("12: Nollie Bigspin Heelflip");
        print("13: Blunt Slide");
        print("14: Board Slide Flip Out");
        print("15: Switch Kickflip 720");

        int i;
        for (i = 0; i < 5; i++) {
            do {
                print("Escolha a manobra para executar no obstáculo " + obstaculosLista[i].getNome());

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
                print(
                        "Você escolheu a manobra: " + manobrasLista[i] + " para o obstáculo: " + obstaculosLista[i]);
            } while (opcaoManobra < 1 || opcaoManobra > 15);
        }

        print("Manobras escolhidas:");

        for (i = 0; i < manobrasLista.length; i++) {
            print("- " + manobrasLista[i]);
        }

        return manobrasLista;
    }

    static private double calcularNota() {
        double notaLinha = 0.0;
        double numeroAleatorio;
        Manobra[] manobrasLista = escolherManobras();

        int i;
        for (i = 0; i < 5; i++) {
            numeroAleatorio = random.nextDouble(9) + 1;

            if (numeroAleatorio >= manobrasLista[i].getDificuldade()) {
                double pontos = manobrasLista[i].getDificuldade() * obstaculosLista[i].getPontos();

                notaLinha = notaLinha + pontos;

                print("Parabéns! Você acertou a manobra e ganhou " + pontos + " pontos no obstáculo "
                        + obstaculosLista[i].getNome() + " realizando a manobra " + manobrasLista[i].getManobraNome(),
                        GREEN);
            } else {
                print("Que pena! Você errou a manobra no obstáculo " + obstaculosLista[i].getNome()
                        + " realizando a manobra " + manobrasLista[i].getManobraNome(), RED);
            }
        }

        return notaLinha;
    }
}
