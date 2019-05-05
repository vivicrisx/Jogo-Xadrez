/**
 * Armazena o tabuleiro e responsavel por posicionar as pecas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Jogo {    
    private Tabuleiro tabuleiro;
    
    private Peca peca;
    private Casa casa;
    public int turno = 0;
    private int tipo;
    public Jogo() {
        tabuleiro = new Tabuleiro();
        criarPecas();
    }
    
    /**
     * Posiciona pe�as no tabuleiro.
     * Utilizado na inicializa�ao do jogo.
     */
    private void criarPecas() {
        
        //peao branco 
        for(int coluna = 0; coluna < 8; coluna++){
           Casa casa2 = tabuleiro.getCasa(coluna,6);
           peca = new Peao(casa2, Peca.PEAO_PRETO);
      
        
        }
        for(int coluna = 0; coluna < 8; coluna++){
           Casa casa2 = tabuleiro.getCasa(coluna,1);
           peca = new Peao(casa2, Peca.PEAO_BRANCO);
      
        
        }
        Casa casa2 = tabuleiro.getCasa(0,0);
        peca = new Torre(casa2, Peca.TORRE_BRANCA);

        Casa casa3 = tabuleiro.getCasa(7,0);
        peca = new Torre(casa3, Peca.TORRE_BRANCA);
        
        Casa casa4 = tabuleiro.getCasa(0,7);
        peca = new Torre(casa4, Peca.TORRE_PRETA);

        Casa casa5 = tabuleiro.getCasa(7,7);
        peca = new Torre(casa5, Peca.TORRE_PRETA);
        
        //cavalo branco
        Casa casa6 = tabuleiro.getCasa(1,0);
        peca =  new Cavalo(casa6, Peca.CAVALO_BRANCO);
        
        Casa casa7 = tabuleiro.getCasa(6,0);
        peca =  new Cavalo(casa7, Peca.CAVALO_BRANCO);
        
        //cavalo preto
        Casa casa8 = tabuleiro.getCasa(1,7);
        peca =  new Cavalo(casa8, Peca.CAVALO_PRETO);
        
        Casa casa9 = tabuleiro.getCasa(6,7);
        peca =  new Cavalo(casa9, Peca.CAVALO_PRETO);
        
        //bispo branco
        Casa casa10 = tabuleiro.getCasa(2,0);
        peca = new Bispo(casa10, Peca.BISPO_BRANCO);
        
        Casa casa11 = tabuleiro.getCasa(5,0);
        peca = new Bispo(casa11, Peca.BISPO_BRANCO);
        
        //bisco preto
        Casa casa12 = tabuleiro.getCasa(2,7);
        peca = new Bispo(casa12, Peca.BISPO_PRETO);
        
        Casa casa13 = tabuleiro.getCasa(5,7);
        peca = new Bispo(casa13, Peca.BISPO_PRETO);
        
        //rainha branca
        Casa casa14 = tabuleiro.getCasa(3,0);
        peca = new Rainha(casa14, Peca.RAINHA_BRANCA);
        
        //rainha preta
        Casa casa15 = tabuleiro.getCasa(3,7);
        peca = new Rainha(casa15, Peca.RAINHA_PRETA);
        
        //rei branco
        Casa casa16 = tabuleiro.getCasa(4,0);
        peca = new Rei(casa16, Peca.REI_BRANCO);
        
        //rei preto
        Casa casa17 = tabuleiro.getCasa(4,7);
        peca = new Rei(casa17, Peca.REI_PRETO);
            
    }
           
    /**
     * Comanda uma Pe�a na posicao (origemX, origemY) fazer um movimento 
     * para (destinoX, destinoY).
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino
     */

    public void moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        Peca pedraDest = destino.getPeca();
        int pedraTipo = origem.getPeca().getTipo();
        
        //chamadas dos métodos que faz as peças jogarem
        if(pedraDest ==  null){
            if(turno == 0){
                //movimento normal
                if(pedraTipo != 4 && pedraTipo != 8 && pedraTipo % 2 == 0){
                    if((peca.podeMover(origemX,origemY,destinoX, destinoY,this) == true)){
                        turno = 1;
                    }
                }
                if((pedraTipo == peca.PEAO_BRANCO)){
                    Peao pecaPeao = (Peao)peca;
                    //chamada da promoçao e en passant pro peao branco
                    if((pecaPeao.promocaoPeao(origemX,origemY,destinoX, destinoY,this) ==  true) ||
                    (peca.podeMover(origemX,origemY,destinoX, destinoY,this) == true) || 
                    pecaPeao.enPassant(origemX,origemY,destinoX, destinoY,this) ==  true)
                    {
                        turno = 1;
                    }
                }
                if((pedraTipo == peca.REI_BRANCO)){
                    Rei pecaRei = (Rei)peca;   
                    Torre pecaTorre = null;
                    boolean possuiTorre = false;
                    Torre pecaTorre2 = null;
                    boolean possuiTorre2 = false;
                    //checagem do roque menor
                    if(tabuleiro.getCasa(7,0).possuiPeca() && tabuleiro.getCasa(7,0).getTipoPeca() == peca.TORRE_BRANCA){
                        pecaTorre = (Torre)tabuleiro.getCasa(7,0).getPeca();
                        possuiTorre = true;
                    }
                    //checagem do roque maior
                    if(tabuleiro.getCasa(0,0).possuiPeca() && tabuleiro.getCasa(0,0).getTipoPeca() == peca.TORRE_BRANCA){
                        pecaTorre2 = (Torre)tabuleiro.getCasa(0,0).getPeca();
                        possuiTorre2 = true;
                    }
                    //chamada dos roques pro rei branco
                    if((possuiTorre && pecaRei.roqueMenor(origemX,origemY,destinoX, destinoY,this, pecaTorre) == true)
                    || ( possuiTorre2 && pecaRei.roqueMaior(origemX,origemY,destinoX, destinoY,this, pecaTorre2) == true) 
                    || (peca.podeMover(origemX,origemY,destinoX, destinoY,this) == true)){
                        turno = 1;
                        
                    }
                }
            }
            if(turno == 1){  
                 if(pedraTipo != 5 && pedraTipo != 9 && pedraTipo % 2 != 0){
                    if(peca.podeMover(origemX,origemY,destinoX, destinoY,this) == true){
                         turno = 0;
                    }
                }
                if((pedraTipo == peca.PEAO_PRETO)){
                    Peao pecaPeao = (Peao)peca;
                    //chamada da promoçao e en passant pro peao preto
                    if((pecaPeao.promocaoPeao(origemX,origemY,destinoX, destinoY,this) ==  true) || 
                    (peca.podeMover(origemX,origemY,destinoX, destinoY,this) == true) || 
                    (pecaPeao.enPassant(origemX,origemY,destinoX, destinoY,this) ==  true)){
                        turno = 0;
                    }
                }
                if((pedraTipo == peca.REI_PRETO)){
                    Rei pecaRei = (Rei)peca;   
                    Torre pecaTorre3 = null;
                    boolean possuiTorre3 = false;
                    Torre pecaTorre4 = null;
                    boolean possuiTorre4 = false;
                    //checagem do roque menor
                    if(tabuleiro.getCasa(7,7).possuiPeca() && tabuleiro.getCasa(7,7).getTipoPeca() == peca.TORRE_PRETA){
                        pecaTorre3 = (Torre)tabuleiro.getCasa(7,7).getPeca();
                        possuiTorre3 = true;
                    }
                    //checagem do roque maior
                    if(tabuleiro.getCasa(0,7).possuiPeca() && tabuleiro.getCasa(0,7).getTipoPeca() == peca.TORRE_PRETA){
                        pecaTorre4 = (Torre)tabuleiro.getCasa(0,7).getPeca();
                        possuiTorre4 = true;
                    }
                    //chamada dos roques pro rei preto
                    if((possuiTorre3 && pecaRei.roqueMenor(origemX,origemY,destinoX, destinoY,this, pecaTorre3) == true)
                    || (possuiTorre4 && pecaRei.roqueMaior(origemX,origemY,destinoX, destinoY,this, pecaTorre4) == true) 
                    || (peca.podeMover(origemX,origemY,destinoX, destinoY,this) == true)){
                        turno = 0;
                    }
                }
            }
        }
        
        //aqui faz as peças capturarem
        if(pedraDest != null ){
            if(turno == 0){
                //movimento captura do peao 
                if((pedraTipo == peca.PEAO_BRANCO && tabuleiro.getCasa(destinoX, destinoY).getTipoPeca() % 2 != 0)){
                    Peao pecaPeao = (Peao)peca;
                    if((pecaPeao.promocaoPeao(origemX,origemY,destinoX, destinoY,this) ==  true) ||
                    (peca.podeMover(origemX,origemY,destinoX, destinoY,this) == true)){
                        turno = 1;
                    }
                }
                //movimento captura das outras peças
                if(pedraTipo % 2 == 0){
                    if(destino.getTipoPeca() % 2 != 0){
                       if(peca.podeMover(origemX,origemY,destinoX, destinoY,this) == true){
                           turno = 1;
                       }
                    }
                }
            }     
            if(turno == 1){
                
                //movimento captura do peao 
                if((pedraTipo == peca.PEAO_PRETO && tabuleiro.getCasa(destinoX, destinoY).getTipoPeca() % 2 == 0)){
                    Peao pecaPeao = (Peao)peca;
                    if((pecaPeao.promocaoPeao(origemX,origemY,destinoX, destinoY,this) ==  true) || 
                    (peca.podeMover(origemX,origemY,destinoX, destinoY,this) == true)){
                        turno = 0;
                    }
                }
                //movimento captura das outras peças
                if(pedraTipo % 2 != 0){
                     if(destino.getTipoPeca() % 2 == 0){
                       if(peca.podeMover(origemX,origemY,destinoX, destinoY,this) == true){
                           turno = 0;
                       }
                    }
                }
            }
        }
        
    }
    
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}   
