public class Manobra {
    ManobraNome nome;
    double dificuldade;

    public Manobra(ManobraNome nome, double dificuldade) {
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

    public ManobraNome getManobraNome() {
        return this.nome;
    }

    public double getDificuldade() {
        return this.dificuldade;
    }

    public void setNome(ManobraNome nome) {
        this.nome = nome;
    }

    public void setDificuldade(double dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String toString() {
        return this.nome.toString().toLowerCase().substring(0, 1).toUpperCase()
                + this.nome.toString().toLowerCase().substring(1) + " (pontos: " + this.dificuldade + ")";
    }
}

enum ManobraNome {
    FRONTSIDE_OLLIE,
    KICKFLIP,
    HEELFLIP,
    FAKIE_FLIP,
    BOARD_SLIDE,
    DOUBLE_FLIP,
    LATE_FLIP,
    FRONTSIDE_FLIP,
    BACKSIDE_FLIP,
    HARD_FLIP,
    KICKFLIP_360,
    CABALERIAL_FLIP,
    NOLLIE_BIGSPIN_HEELFLIP,
    BLUNT_SLIDE,
    BOARD_SLIDE_FLIP_OUT,
    SWITCH_KICKFLIP_720,
}
