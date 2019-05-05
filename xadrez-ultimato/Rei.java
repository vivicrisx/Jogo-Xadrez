                
/**
 * Classe rei e seus movimentos específicos 
 * 
 *  @author Viviane Cristine 
 *  @author Matheus Leite
 */
public class Rei extends Peca{
    private int tipo;
    private Casa casa;    
    private int primeiraJogada = 0;
    
    private Peca peca;
    /**
     * COnstrutor para objetos da classe Rei
     */
    public Rei(Casa casa, int tipo){
        super(casa, tipo);
    }
   
    /** 
       método de movimento normal do rei
    **/
    public boolean podeMover(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo) {
        boolean moverRei = false;
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        
        //diagonal
        if((destinoX == origemX + 1) && (destinoY == origemY + 1) || (destinoX == origemX - 1) && (destinoY == origemY + 1)){
            moverRei = true;
            peca.mover(destino);
            primeiraJogada++;
        }
        //diagonal
        if((destinoX == origemX + 1) && (destinoY == origemY - 1) || (destinoX == origemX - 1) && (destinoY == origemY - 1)){
            moverRei = true;
            peca.mover(destino);
            primeiraJogada++;
        }
        
        if((origemX == destinoX) && (origemY + 1 == destinoY)){
            moverRei = true;
            peca.mover(destino);
            primeiraJogada++;
        }
        
        if((origemX == destinoX) && (origemY - 1 == destinoY)){
            moverRei = true;
            peca.mover(destino);
            primeiraJogada++;
        }
        
        if((origemY == destinoY) && (origemX + 1 == destinoX)){
            moverRei = true;
            peca.mover(destino);
            primeiraJogada++;
        }
        
        if((origemY == destinoY) && (origemX - 1 == destinoX)){
            moverRei = true;
            peca.mover(destino);
            primeiraJogada++;
        }
       
        return moverRei;
    }
        
    /**
       método do roque menor do rei
       o rei anda duas casas e o rei e a torre trocam de lugar (lado direito)
       jogadas para cada tipo de peça rei (preto e branco)
     **/   
    public boolean roqueMenor(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo, Torre torre){
        boolean moverRei = false;
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        int pedraTipo = origem.getPeca().getTipo();
        Peca pedraDest = destino.getPeca();
        
        if(pedraTipo == REI_BRANCO){
            if(torre.getPrimeiraJogada() == 0 && (primeiraJogada == 0)){
                //avalia a primeira jogada da torre e do rei e avalia 
                if((origemY == destinoY) && (origemX + 2 == destinoX)){
                    Casa casaGarantida = null;
                    for(int x = origemX + 1; x < destinoX; x++ ){
                        Casa casaChecar = tabuleiro.getCasa(x,origemY);
                        if(casaChecar.possuiPeca() == true){
                            
                            casaGarantida = casaChecar;
                            
                        }
                    }
                    if(casaGarantida == null){
                        moverRei = true;
                        peca.mover(destino);
                        Casa pecaTorre1 = tabuleiro.getCasa(7,0);
                        pecaTorre1.removerPeca();
                        Casa casa4 = tabuleiro.getCasa(5,0);
                        peca = new Torre(casa4, Peca.TORRE_BRANCA);
                        primeiraJogada++;
                    }
                }
            }
        }
        
        if(pedraTipo == REI_PRETO){
            if(torre.getPrimeiraJogada() == 0 && (primeiraJogada == 0)){
                if((origemY == destinoY) && (origemX + 2 == destinoX)){
                    Casa casaGarantida = null;
                    for(int x = origemX + 1; x < destinoX; x++ ){
                        Casa casaChecar = tabuleiro.getCasa(x,origemY);
                        if(casaChecar.possuiPeca() == true){
                            
                            casaGarantida = casaChecar;
                            
                        }
                    }
                    if(casaGarantida == null){
                        moverRei = true;
                        peca.mover(destino);
                        Casa pecaTorre1 = tabuleiro.getCasa(7,7);
                        pecaTorre1.removerPeca();
                        Casa casa4 = tabuleiro.getCasa(5,7);
                        peca = new Torre(casa4, Peca.TORRE_PRETA);
                        primeiraJogada++;
                    }
                }
            }
        }
        
        return moverRei;
    }
    
     /**
       método do roque maior do rei
       o rei anda duas casas e o rei e a torre trocam de lugar (lado esquerdo)
       jogadas para cada tipo de peça rei (preto e branco)
      **/ 
    public boolean roqueMaior(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo, Torre torre){
        boolean moverRei = false;
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        int pedraTipo = origem.getPeca().getTipo();
        
        if(pedraTipo == REI_BRANCO){
            if(torre.getPrimeiraJogada() == 0 && (primeiraJogada == 0)){
                if((origemY == destinoY) && (origemX - 2 == destinoX)){
                    Casa casaGarantida = null;
                    Casa casaGarantida2 = null;
                    for(int x = origemX - 1; x > destinoX; x-- ){
                        Casa casaChecar = tabuleiro.getCasa(x,origemY);
                        Casa casaCavalo = tabuleiro.getCasa(1,0);
                        if(casaChecar.possuiPeca() == true || casaCavalo.possuiPeca() == true){
                            casaGarantida = casaChecar;
                            casaGarantida2 = casaCavalo;
                        }
                    }
                    if(casaGarantida == null && casaGarantida2 == null){
                        moverRei = true;
                        peca.mover(destino);
                        Casa pecaTorre1 = tabuleiro.getCasa(0,0);
                        pecaTorre1.removerPeca();
                        Casa casa4 = tabuleiro.getCasa(3,0);
                        peca = new Torre(casa4, Peca.TORRE_BRANCA);
                        primeiraJogada++;
                    }
                }
            }
        }
        
        if(pedraTipo == REI_PRETO){
            if(torre.getPrimeiraJogada() == 0 && (primeiraJogada == 0)){
                Casa casaGarantida = null;
                Casa casaGarantida2 = null;
                for(int x = origemX - 1; x > destinoX; x-- ){
                    Casa casaChecar = tabuleiro.getCasa(x,origemY);
                    Casa casaCavalo = tabuleiro.getCasa(1,7);
                    if(casaChecar.possuiPeca() == true || casaCavalo.possuiPeca() == true){
                        casaGarantida = casaChecar;
                        casaGarantida2 = casaCavalo;
                    }
                }
                if(casaGarantida == null && casaGarantida2 == null){
                    if((origemY == destinoY) && (origemX - 2 == destinoX)){
                        moverRei = true;
                        peca.mover(destino);
                        Casa pecaTorre1 = tabuleiro.getCasa(0,7);
                        pecaTorre1.removerPeca();
                        Casa casa4 = tabuleiro.getCasa(3,7);
                        peca = new Torre(casa4, Peca.TORRE_PRETA);
                        primeiraJogada++;
                    }
                }
            }
        }
        return moverRei;
    }
}
 