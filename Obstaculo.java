enum ObstaculoNome {
    ESCADA,
    CORRIMAO,
    RAMP,
    MESA,
    HIDRANTE
}

public class Obstaculo {
    ObstaculoNome nome;
    double pontos;
    double dificuldade;
    
    public Obstaculo(ObstaculoNome nome, double pontos, double dificuldade) {
        this.nome = nome;
        this.pontos = pontos;
        this.dificuldade = dificuldade;
    }
    
    public ObstaculoNome getNome() {
        return this.nome;
    }
    
    public double getPontos() {
        return this.pontos;
    }
    
    public double getDificuldade() {
        return this.dificuldade;
    }
    
    public void setNome(ObstaculoNome nome) {
        this.nome = nome;
    }
    
    public void setPontos(double pontos) {
        this.pontos = pontos;
    }
    
    public void setDificuldade(double dificuldade) {
        this.dificuldade = dificuldade;
    }
}
