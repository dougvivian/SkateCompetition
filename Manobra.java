enum ManobraNome {
    KICKFLIP,
    CABALERIAL_FLIP,
    NOLLIE_BIGSPIN_HEELFLIP,
    HEELFLIP,
    FRONTSIDE_OLLIE,
    KICKFLIP_360,
    BLUNT_SLIDE,
    BOARD_SLIDE,
    HARD_FLIP,
    BOARD_SLIDE_FLIP_OUT,
    LATE_FLIP,
    FAKIE_FLIP,
    BACKSIDE_FLIP,
    FRONTSIDE_FLIP,
    SWITCH_KICKFLIP_720,
    DOUBLE_FLIP
}

public class Manobra {
    ManobraNome nome;
    double pontos;
    double dificuldade;
    
    public Manobra(ManobraNome nome, double pontos, double dificuldade) {
        this.nome = nome;
        this.pontos = pontos;
        this.dificuldade = dificuldade;
    }
    
    public ManobraNome getManobraNome(){
        return this.nome = nome;
    }
    public double getPontos(){
        return this.pontos = pontos;
    }
    public double getDificuldade(){
        return this.dificuldade = dificuldade;    
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

    public void setDificuldade(double dificuldade) {
        this.dificuldade = dificuldade;
    }
}

