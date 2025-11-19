public class Etapa {
    private EtapaNome nome;
    private Obstaculo[] obstaculos;

    public Etapa(EtapaNome nome, Obstaculo[] obstaculos) {
        this.nome = nome;
        this.obstaculos = obstaculos;
    }

    public EtapaNome getNome() {
        return this.nome;
    }

    public Obstaculo[] getObstaculos() {
        return this.obstaculos;
    }

    public void setNome(EtapaNome nome) {
        this.nome = nome;
    }

    public void setObstaculos(Obstaculo[] obstaculos) {
        this.obstaculos = obstaculos;
    }
}

enum EtapaNome {
    LINHA,
    OBSTACULO
}
