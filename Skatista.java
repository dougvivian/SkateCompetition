import java.util.Random;

public class Skatista {
    String nome;
    String skatistaEstilo;
    int idade;
    double nota[] = { 0, 0 };
    Random random = new Random();

    /**
     * Acrescentar nacionalidade aos oponentes
     * Transformar isso num vetor de objetos
     */
    String[] randomNomes = {
            "Axel Rodriguez",
            "Skyler Vance",
            "Dusty Callahan",
            "Blaze Sterling",
            "Jet McCoy",
            "Titus Thorne",
            "Zane Kincaid",
            "Maverick Quinn",
            "Viper Jensen",
            "Ryder Stone"
    };

    public Skatista() {
        this.nome = this.getNomeAleatorio();
        this.skatistaEstilo = this.getSkatistaEstiloAleatorio();
        this.idade = this.getIdadeAleatoria();
    }

    public Skatista(String nome, String skatistaEstilo, int idade) {
        this.nome = nome;
        this.skatistaEstilo = skatistaEstilo;
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSkatistaEstilo() {
        return this.skatistaEstilo;
    }

    public int getIdade() {
        return this.idade;
    }

    public double[] getNota() {
        return this.nota;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstilo(String skatistaEstilo) {
        this.skatistaEstilo = skatistaEstilo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void adicionarNota(double nota) {
        if (this.nota[0] > 0) {
            this.nota[1] = nota;
            return;
        }

        this.nota[0] = nota;
    }

    public void removerNotaPorIndex(int index) {
        if (index < 0 || index > 1) {
            return;
        }

        this.nota[index] = 0;
    }

    public void removerNotaPorValor(double valor) {
        if (this.nota[0] == valor) {
            this.nota[0] = 0;
        }

        if (this.nota[1] == valor) {
            this.nota[1] = 0;
        }
    }

    public String toString() {
        return "Nome: " + this.nome + "; Estilo: " + this.skatistaEstilo + "; Idade: " + this.idade;
    }

    private String getNomeAleatorio() {
        int numeroAleatorio = random.nextInt(10);
        return randomNomes[numeroAleatorio];
    }

    private String getSkatistaEstiloAleatorio() {
        int numeroAleatorio = random.nextInt(2);

        if (numeroAleatorio == 0) {
            return "Regular";
        }

        return "Goofy";
    }

    private int getIdadeAleatoria() {
        int min = 18;
        int max = 40;

        return random.nextInt((max - min) + 1) + min;
    }
}
