enum SkatistaEstilo {
    REGULAR,
    GOOFY
}

public class Skatista {
    String nome;
    SkatistaEstilo skatistaEstilo;
    int idade;
    double nota[] = {0, 0};
    
    public Skatista(String nome, SkatistaEstilo skatistaEstilo, int idade) {
        this.nome = nome;
        this.skatistaEstilo = skatistaEstilo;
        this.idade = idade;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public SkatistaEstilo getSkatistaEstilo() {
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
    
    public void setEstilo(SkatistaEstilo skatistaEstilo) {
        this.skatistaEstilo = skatistaEstilo;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void addNota(int nota) {
        if (this.nota[0] > 0) {
            this.nota[1] = nota;
            return;
        }
        
        this.nota[0] = nota;
    }
}
