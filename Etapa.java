public class Etapa {
    private EtapaNome nome;
    private Obstaculo[] obstaculos;
    private Manobra[] manobras;

    public Etapa(EtapaNome nome) {
        this.nome = nome;
    }

    public Etapa(EtapaNome nome, Obstaculo[] obstaculos, Manobra[] manobras) {
        this.nome = nome;
        this.obstaculos = obstaculos;
        this.manobras = manobras;
    }

    public EtapaNome getNome() {
        return this.nome;
    }

    public Obstaculo[] getObstaculos() {
        return this.obstaculos;
    }

    public Manobra[] getManobras() {
        return this.manobras;
    }

    public void setNome(EtapaNome nome) {
        this.nome = nome;
    }

    public void setObstaculos(Obstaculo[] obstaculos) {
        this.obstaculos = obstaculos;
    }

    public void setManobras(Manobra[] manobras) {
        this.manobras = manobras;
    }
}

enum EtapaNome {
    LINHA,
    IMPACTO
}
