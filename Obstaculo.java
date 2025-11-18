public class Obstaculo {
    ObstaculoNome nome;
    double pontos;
    double dificuldade;
    
    public Obstaculo(ObstaculoNome nome, double pontos, double dificuldade) {
        this.nome = nome;
        this.pontos = pontos;
    }
    
    public ObstaculoNome getNome() {
        return this.nome;
    }
    
    public double getPontos() {
        return this.pontos;
    }
    
    public void setNome(ObstaculoNome nome) {
        this.nome = nome;
    }
    
    public void setPontos(double pontos) {
        this.pontos = pontos;
    }
}

enum ObstaculoNome {
    ESCADA,
    CORRIMAO,
    RAMP,
    MESA,
    HIDRANTE
}
