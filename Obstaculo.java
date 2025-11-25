public class Obstaculo {
    ObstaculoNome nome;
    double pontos;
    
    public Obstaculo(ObstaculoNome nome, double pontos) {
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
    CAIXOTE,
    HIDRANTE,
    GAP_COM_RAMPA,
    PIRAMIDE,
    RAMPA,
    MESA,
    CORRIMAO,
    CORRIMAO_CURVADO,
    ESCADA,
}
