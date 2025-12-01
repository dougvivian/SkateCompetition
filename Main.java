import java.util.Scanner;
import java.util.Random;

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

    static final String GREEN = "\u001B[32m";

    public static void main() {
        criarPersonagens();
        exibirMenuInicial();
        iniciarObstaculos();
        iniciarManobras();
        comecarEtapaLinha();
        comecarEtapaImpacto();
        mostrarPodio();
    }

    static private void print(String message) {
        System.out.println("\n" + message);
    }

    static private void print(String message, String color) {
        System.out.println(color + "\n" + message);
    }

    static private void printSeparador() {
        print("------------------------------");
    }

    static private void pausa() {
        int opcao;

        do {
            print("Envie \"0\" para continuar...");
            opcao = scanner.nextInt();
        } while (opcao != 0);
    }

    static private void criarPersonagens() {
        String nome;
        String skatistaEstilo = null;
        int idade;
        int opcaoEstilo = 0;

        printSeparador();
        print("Informe o nome:", GREEN);
        nome = scanner.nextLine();

        do {
            print("Existem dois estilos de skatistas: Regular e Goofy.\n" +
            "Regular é o skatista que usa o pé esquerdo na frente do skate e o pé direito atrás.\n" +
            "E goofy é o contrário, pé direito na frente e o esquerdo atrás.");

            print("Escolha seu estilo. Digite 1 para Regular ou 2 para Goofy:", GREEN);
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
        pausa();
        printSeparador();
    }

    static private void exibirMenuInicial() {
        int opcao;
        do {
            print("Informe a opção", GREEN);
            print("1: Editar personagem");
            print("2: Mostrar competidores");
            print("3: Iniciar jogo");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Bug do Java: Consumir a quebra de linha pendente

            switch (opcao) {
                case 1:
                    String novoNome;

                    print("Editar personagem", GREEN);
                    print("Informe o novo nome do personagem:");
                    novoNome = scanner.nextLine();
                    skatista.setNome(novoNome);

                    int novoEstiloOpcao;
                    do {
                        print("Informe o novo estilo (1: Regular; 2: Goofy):");
                        novoEstiloOpcao = scanner.nextInt();
                        scanner.nextLine(); // Bug do Java: Consumir a quebra de linha pendente
                        if (novoEstiloOpcao == 1) {
                            skatista.setEstilo("Regular");
                        } else if (novoEstiloOpcao == 2) {
                            skatista.setEstilo("Goofy");
                        }
                    } while (novoEstiloOpcao < 1 || novoEstiloOpcao > 2);

                    print("Informe a nova idade do personagem:");
                    int novaIdade = scanner.nextInt();
                    scanner.nextLine(); // Bug do Java: Consumir a quebra de linha pendente
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
                    print("O jogo vai começar...", GREEN);
                    printSeparador();
                    break;
                default:
                    print("Opção inválida, escolha uma nova opção");
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

    static private Obstaculo[] escolherObstaculos(int quantidadeObstaculos) {
        int opcaoObstaculo = 0;
        Obstaculo[] obstaculosLista = new Obstaculo[quantidadeObstaculos];

        print("Escolha " + quantidadeObstaculos
                + (quantidadeObstaculos == 1 ? " obstáculo " : " obstáculos ")
                + "da lista abaixo (digite um número de cada vez):");
        print("1: " + caixote + "\n" +
        "2: " + hidrante + "\n" +
        "3: " + gapComRampa + "\n" +
        "4: " + piramide + "\n" +
        "5: " + rampa + "\n" +
        "6: " + mesa + "\n" +
        "7: " + corrimao + "\n" +
        "8: " + corrimaoCurvado + "\n" +
        "9: " + escada);

        int i;
        for (i = 0; i < quantidadeObstaculos; i++) {
            do {
                print("Escolha obstáculo de número " + (i + 1), GREEN);
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
            } while (opcaoObstaculo < 1 || opcaoObstaculo > 9);
        }

        print("Obstáculos escolhidos: ");

        for (i = 0; i < obstaculosLista.length; i++) {
            print("- " + obstaculosLista[i]);
        }

        printSeparador();

        return obstaculosLista;
    }

    static private Manobra[] escolherManobras(Obstaculo[] obstaculosLista) {
        int opcaoManobra = 0;
        int quantidadeManobras = obstaculosLista.length;
        Manobra[] manobrasLista = new Manobra[quantidadeManobras];

        print("Escolha " + quantidadeManobras + (quantidadeManobras == 1 ? " manobra " : " manobras ") +
        "da lista abaixo (digite um número de cada vez):", GREEN);
                
        print("1: " + frontsideOllie + "\n" +
        "2: " + kickflip + "\n" +
        "3: " + heelflip + "\n" +
        "4: " + fakieFlip + "\n" +
        "5: " + boardSlide + "\n" +
        "6: " + lateFlip + "\n" +
        "7: " + frontsideFlip + "\n" +
        "8: " + backsideFlip + "\n" +
        "9: " + hardFlip + "\n" +
        "10: " + kickflip360 + "\n" +
        "11: " + cabalerialFlip + "\n" +
        "12: " + nollieBigspinHeelflip + "\n" +
        "13: " + bluntSlide + "\n" +
        "14: " + boardSlideFlipOut + "\n" +
        "15: " + switchKickflip720);

        int i;
        for (i = 0; i < quantidadeManobras; i++) {
            do {
                print("Escolha a manobra para executar no obstáculo " + obstaculosLista[i].getNome(), GREEN);

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
            } while (opcaoManobra < 1 || opcaoManobra > 15);
        }

        print("Manobras escolhidas:");

        for (i = 0; i < manobrasLista.length; i++) {
            print("- " + manobrasLista[i]);
        }

        printSeparador();

        return manobrasLista;
    }

    static private Obstaculo[] escolherObstaculosAleatorios(int quantidadeObstaculos) {
        int opcaoObstaculo = 0;
        Obstaculo[] obstaculosLista = new Obstaculo[quantidadeObstaculos];

        int i;
        for (i = 0; i < quantidadeObstaculos; i++) {
            opcaoObstaculo = random.nextInt(8) + 1;
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
        }

        return obstaculosLista;
    }

    static private Manobra[] escolherManobrasAleatorias(int quantidadeManobras) {
        int opcaoManobra = 0;
        Manobra[] manobrasLista = new Manobra[quantidadeManobras];

        int i;
        for (i = 0; i < quantidadeManobras; i++) {
            opcaoManobra = random.nextInt(14) + 1;
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
        }

        return manobrasLista;
    }

    static private double calcularNota(
        Obstaculo[] obstaculosLista,
        Manobra[] manobrasLista,
        String nome
    ) {
        double notaTotal = 0.0;
        double numeroAleatorio;

        for (int i = 0; i < manobrasLista.length; i++) {
            print("- " + manobrasLista[i]);
        }

        int i;
        for (i = 0; i < obstaculosLista.length; i++) {
            numeroAleatorio = random.nextDouble(9) + 1;

            if (numeroAleatorio >= manobrasLista[i].getDificuldade()) {
                double manobraPontos = manobrasLista[i].getDificuldade() * obstaculosLista[i].getPontos();

                notaTotal = notaTotal + manobraPontos;

                print("Parabéns! " + nome + " acertou a manobra " + manobrasLista[i].getManobraNome() + " no obstáculo "
                + obstaculosLista[i].getNome() + " e ganhou " + manobraPontos + " pontos.", GREEN);
            } else {
                print("Que pena! " + nome + " errou a manobra " + manobrasLista[i].getManobraNome() + " no obstáculo "
                + obstaculosLista[i].getNome());
            }
        }

        print("Total de pontos da etapa atual: " + notaTotal);

        return notaTotal;
    }

    static private void comecarEtapaLinha() {
        print("Vai começar a etapa Linha", GREEN);
        print("Nessa etapa, você e seus oponentes irão escolher 5 obstáculos, e depois 5 manobras para executar.\n" +
        "Cada manobra é executada em um obstáculo na mesma ordem em que foram escolhidas.\n" +
        "Se acertar a manobra no obstáculo, você ganha pontos.\n" +
        "Eles são a dificuldade da manobra multiplicada pela pontuação do obstáculo.\n" +
        "Se errar a manobra, não ganha nada.");

        Etapa linha = new Etapa(EtapaNome.LINHA);

        Obstaculo[] obstaculosLista = escolherObstaculos(5);
        Manobra[] manobrasLista = escolherManobras(obstaculosLista);
        linha.setObstaculos(obstaculosLista);
        linha.setManobras(manobrasLista);

        print("Vamos ver as suas notas", GREEN);
        pausa();
        double notaSkatista = calcularNota(
            linha.getObstaculos(),
            linha.getManobras(),
            skatista.getNome()
        );
        skatista.adicionarNota(notaSkatista);
        pausa();

        obstaculosLista = escolherObstaculosAleatorios(5);
        manobrasLista = escolherManobrasAleatorias(5);
        linha.setObstaculos(obstaculosLista);
        linha.setManobras(manobrasLista);

        print("Vamos ver as notas do " + oponenteA.getNome(), GREEN);
        pausa();
        double notaOponenteA = calcularNota(
            linha.getObstaculos(),
            linha.getManobras(),
            oponenteA.getNome()
        );
        oponenteA.adicionarNota(notaOponenteA);
        pausa();

        obstaculosLista = escolherObstaculosAleatorios(5);
        manobrasLista = escolherManobrasAleatorias(5);
        linha.setObstaculos(obstaculosLista);
        linha.setManobras(manobrasLista);

        print("Vamos ver as notas do " + oponenteB.getNome(), GREEN);
        pausa();
        double notaOponenteB = calcularNota(
            linha.getObstaculos(),
            linha.getManobras(),
            oponenteB.getNome()
        );
        oponenteB.adicionarNota(notaOponenteB);
        pausa();
    }

    static private void comecarEtapaImpacto() {
        print("Vai começar a etapa Impacto", GREEN);
        print("Essa etapa é igual à anterior, porém vocês escolhem apenas 1 obstáculo e 1 manobra.");

        Etapa impacto = new Etapa(EtapaNome.IMPACTO);

        Obstaculo[] obstaculosLista = escolherObstaculos(1);
        Manobra[] manobrasLista = escolherManobras(obstaculosLista);
        impacto.setObstaculos(obstaculosLista);
        impacto.setManobras(manobrasLista);

        print("Vamos ver as suas notas", GREEN);
        pausa();
        double notaSkatista = calcularNota(
            impacto.getObstaculos(),
            impacto.getManobras(),
            skatista.getNome()
        );
        skatista.adicionarNota(notaSkatista);
        pausa();

        obstaculosLista = escolherObstaculosAleatorios(1);
        manobrasLista = escolherManobrasAleatorias(1);
        impacto.setObstaculos(obstaculosLista);
        impacto.setManobras(manobrasLista);
        print("Vamos ver as notas do " + oponenteA.getNome(), GREEN);
        pausa();
        double notaOponenteA = calcularNota(
            impacto.getObstaculos(),
            impacto.getManobras(),
            oponenteA.getNome()
        );
        oponenteA.adicionarNota(notaOponenteA);
        pausa();

        obstaculosLista = escolherObstaculosAleatorios(1);
        manobrasLista = escolherManobrasAleatorias(1);
        impacto.setObstaculos(obstaculosLista);
        impacto.setManobras(manobrasLista);
        print("Vamos ver as notas do " + oponenteB.getNome(), GREEN);
        pausa();
        double notaOponenteB = calcularNota(
            impacto.getObstaculos(),
            impacto.getManobras(),
            oponenteB.getNome()
        );
        oponenteB.adicionarNota(notaOponenteB);
        pausa();
    }

    static private void mostrarPodio() {
        double notaFinalSkatista = skatista.getNotaFinal();
        double notaFinalOponenteA = oponenteA.getNotaFinal();
        double notaFinalOponenteB = oponenteB.getNotaFinal();

        print("----- Pódio Final -----", GREEN);

        if (notaFinalSkatista >= notaFinalOponenteA && notaFinalSkatista >= notaFinalOponenteB) {
            print("1º Lugar: " + skatista.getNome() + " - Nota Final: " + notaFinalSkatista, GREEN);
            if (notaFinalOponenteA >= notaFinalOponenteB) {
                print("2º Lugar: " + oponenteA.getNome() + " - Nota Final: " + notaFinalOponenteA);
                print("3º Lugar: " + oponenteB.getNome() + " - Nota Final: " + notaFinalOponenteB);
            } else {
                print("2º Lugar: " + oponenteB.getNome() + " - Nota Final: " + notaFinalOponenteB);
                print("3º Lugar: " + oponenteA.getNome() + " - Nota Final: " + notaFinalOponenteA);
            }
        } else if (notaFinalOponenteA >= notaFinalSkatista && notaFinalOponenteA >= notaFinalOponenteB) {
            print("1º Lugar: " + oponenteA.getNome() + " - Nota Final: " + notaFinalOponenteA);
            if (notaFinalSkatista >= notaFinalOponenteB) {
                print("2º Lugar: " + skatista.getNome() + " - Nota Final: " + notaFinalSkatista);
                print("3º Lugar: " + oponenteB.getNome() + " - Nota Final: " + notaFinalOponenteB);
            } else {
                print("2º Lugar: " + oponenteB.getNome() + " - Nota Final: " + notaFinalOponenteB);
                print("3º Lugar: " + skatista.getNome() + " - Nota Final: " + notaFinalSkatista);
            }
        } else {
            print("1º Lugar: " + oponenteB.getNome() + " - Nota Final: " + notaFinalOponenteB);
            if (notaFinalSkatista >= notaFinalOponenteA) {
                print("2º Lugar: " + skatista.getNome() + " - Nota Final: " + notaFinalSkatista);
                print("3º Lugar: " + oponenteA.getNome() + " - Nota Final: " + notaFinalOponenteA);
            } else {
                print("2º Lugar: " + oponenteA.getNome() + " - Nota Final: " + notaFinalOponenteA);
                print("3º Lugar: " + skatista.getNome() + " - Nota Final: " + notaFinalSkatista);
            }
        }
    }
}
