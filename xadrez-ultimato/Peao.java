import javax.swing.JOptionPane;
/**
 * Escreva a descrição da classe Peão aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Peao extends Peca{

    private Casa casa;
    private int tipo;
    private Jogo jogo;
    private Peao peao;
    
    /**
     * COnstrutor para objetos da classe Peão
     */
    public Peao(Casa casa, int tipo)
    {
        super(casa, tipo);
    }
    
    public boolean podeMover(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo) {
        boolean moverPeao = false;
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        int pedraTipo = origem.getPeca().getTipo();
        Peca pedraDest = destino.getPeca();
        
        if(pedraDest == null){
            if(pedraTipo == Peca.PEAO_BRANCO){
                if(origemY == 1){
                    if((origemX == destinoX) && (origemY + 1 == destinoY || origemY + 2 == destinoY)){
                        Casa casaGarantida = null;
                        for(int y = origemY + 1; y < destinoY; y++ ){
                            Casa casaChecar = tabuleiro.getCasa(origemX,y);
                            if(casaChecar.possuiPeca() == true){
                                
                                casaGarantida = casaChecar;
                                
                            }
                        }
                        if(casaGarantida == null){
                            moverPeao = true;
                            peca.mover(destino);
                        }
                    }
                }
            
                else if(origemX == destinoX && origemY + 1 == destinoY){
                    Casa casaGarantida = null;
                    for(int y = origemY + 1; y < destinoY; y++ ){
                        Casa casaChecar = tabuleiro.getCasa(origemX,y);
                        if(casaChecar.possuiPeca() == true){
                            
                            casaGarantida = casaChecar;
                            
                        }
                    }
                    if(casaGarantida == null){
                        moverPeao = true;
                        peca.mover(destino);
                    }
                }
            }
            
            if(pedraTipo == Peca.PEAO_PRETO){
                if(origemY == 6){
                    if((origemX == destinoX) && (origemY - 1 == destinoY || origemY - 2 == destinoY)){
                        Casa casaGarantida = null;
                        for(int y = origemY - 1; y > destinoY; y-- ){
                            Casa casaChecar = tabuleiro.getCasa(origemX,y);
                            if(casaChecar.possuiPeca() == true){
                                
                                casaGarantida = casaChecar;
                                
                            }
                        }
                        if(casaGarantida == null){
                            moverPeao = true;
                            peca.mover(destino);
                        }
                    }
                }
                else if(origemX == destinoX && origemY - 1 == destinoY){
                    Casa casaGarantida = null;
                    for(int y = origemY - 1; y > destinoY; y-- ){
                        Casa casaChecar = tabuleiro.getCasa(origemX,y);
                        if(casaChecar.possuiPeca() == true){
                            
                            casaGarantida = casaChecar;
                            
                        }
                    }
                    if(casaGarantida == null){
                        moverPeao = true;
                        peca.mover(destino);
                    }
                }
            }
        }
        
        if(pedraDest != null){
            if(pedraTipo == PEAO_BRANCO){
                if((destinoX == origemX + 1) && (destinoY == origemY + 1)){
                    Casa casaProxima = tabuleiro.getCasa(origemX + 1, origemY + 1);
                    casaProxima.removerPeca();
                    peca.mover(destino);
                    moverPeao = true;
                }
                
                if((destinoX == origemX - 1) && (destinoY == origemY + 1)){
                    Casa casaProxima = tabuleiro.getCasa(origemX - 1, origemY + 1);
                    casaProxima.removerPeca();
                    peca.mover(destino);
                    moverPeao = true;
                }
            }
            
            if(pedraTipo == PEAO_PRETO){
                if((destinoX == origemX - 1) && (destinoY == origemY - 1)){
                    Casa casaProxima = tabuleiro.getCasa(origemX - 1, origemY - 1);
                    casaProxima.removerPeca();
                    peca.mover(destino);
                    moverPeao = true;
                }
            
                if((destinoX == origemX + 1) && (destinoY == origemY - 1)){
                    Casa casaProxima = tabuleiro.getCasa(origemX + 1, origemY - 1);
                    casaProxima.removerPeca();
                    peca.mover(destino);
                    moverPeao = true;
                }
            }
        }
        return moverPeao;
    }
    
    public boolean promocaoPeao(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo){
        boolean moverPeao = false;
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        int pedraTipo = origem.getPeca().getTipo();
        Peca pedraDest = destino.getPeca();
                      
        if(pedraTipo == PEAO_BRANCO){
            if(pedraDest == null){
                if((origemX == destinoX && origemY + 1 == destinoY)){
                    if(destinoY == 7 ) { 
                        int promocaoPeao1 = 0;
                        while(promocaoPeao1 == 0){
                            String promocaoPeao = JOptionPane.showInputDialog("Seu peao foi promovido! Escolha uma peça:  (Torre, Rainha, Bispo ou Cavalo)");
                            if(promocaoPeao.equals("Rainha")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Rainha(casa15, Peca.RAINHA_BRANCA);
                                moverPeao = true;
                                promocaoPeao1++;
                            }
                            else if(promocaoPeao.equals("Torre")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Torre(casa15, Peca.TORRE_BRANCA);
                                moverPeao = true;
                                promocaoPeao1++;
                            }
                            else if(promocaoPeao.equals("Bispo")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Bispo(casa15, Peca.BISPO_BRANCO);
                                moverPeao = true;
                                promocaoPeao1++;
                            }   
                            else if(promocaoPeao.equals("Cavalo")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Cavalo(casa15, Peca.CAVALO_BRANCO);
                                moverPeao = true;
                                promocaoPeao1++;
                            }
                        }
                    }            
                }
            }
         
            if(pedraDest != null){
                if((origemX + 1 == destinoX) && (origemY + 1 == destinoY) || (origemX - 1 == destinoX) && (origemY + 1 == destinoY)){
                    if(destinoY == 7 ) {
                         int promocaoPeao1 = 0;
                         while(promocaoPeao1 == 0){
                             String promocaoPeao = JOptionPane.showInputDialog("Seu peao foi promovido! Escolha uma peça:  (Torre, Rainha, Bispo ou Cavalo)");
                             if(promocaoPeao.equals("Rainha")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Rainha(casa15, Peca.RAINHA_BRANCA);
                                moverPeao = true;
                                promocaoPeao1++;
                             }
                             else if(promocaoPeao.equals("Torre")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Torre(casa15, Peca.TORRE_BRANCA);
                                moverPeao = true;
                                promocaoPeao1++;
                             }
                             else if(promocaoPeao.equals("Bispo")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Bispo(casa15, Peca.BISPO_BRANCO);
                                moverPeao = true;
                                promocaoPeao1++;
                             }   
                             else if(promocaoPeao.equals("Cavalo")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Cavalo(casa15, Peca.CAVALO_BRANCO);
                                moverPeao = true;
                                promocaoPeao1++;
                             }
                         }  
                    }
                }
            }
        }    
        
        if(pedraTipo == PEAO_PRETO){
            if(pedraDest == null){
                if((origemX == destinoX && origemY - 1 == destinoY)){
                    if(destinoY == 0 ) { 
                        int promocaoPeao1 = 0;
                        while(promocaoPeao1 == 0){
                            String promocaoPeao = JOptionPane.showInputDialog("Seu peao foi promovido! Escolha uma peça:  (Torre, Rainha, Bispo ou Cavalo)");
                            if(promocaoPeao.equals("Rainha")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Rainha(casa15, Peca.RAINHA_PRETA);
                                moverPeao = true;
                                promocaoPeao1++;
                            }
                            else if(promocaoPeao.equals("Torre")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Torre(casa15, Peca.TORRE_PRETA);
                                moverPeao = true;
                                promocaoPeao1++;
                            }
                            else if(promocaoPeao.equals("Bispo")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Bispo(casa15, Peca.BISPO_PRETO);
                                moverPeao = true;
                                promocaoPeao1++;
                            }   
                            else if(promocaoPeao.equals("Cavalo")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Cavalo(casa15, Peca.CAVALO_PRETO);
                                moverPeao = true;
                                promocaoPeao1++;
                            }
                        }
                    }            
                }
            }
         
            if(pedraDest != null){
                if((origemX + 1 == destinoX) && (origemY - 1 == destinoY) || (origemX - 1 == destinoX) && (origemY - 1 == destinoY)){
                    if(destinoY == 0 ) {
                         int promocaoPeao1 = 0;
                         while(promocaoPeao1 == 0){
                             String promocaoPeao = JOptionPane.showInputDialog("Seu peao foi promovido! Escolha uma peça:  (Torre, Rainha, Bispo ou Cavalo)");
                             if(promocaoPeao.equals("Rainha")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Rainha(casa15, Peca.RAINHA_PRETA);
                                moverPeao = true;
                                promocaoPeao1++;
                             }
                             else if(promocaoPeao.equals("Torre")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Torre(casa15, Peca.TORRE_PRETA);
                                moverPeao = true;
                                promocaoPeao1++;
                             }
                             else if(promocaoPeao.equals("Bispo")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Bispo(casa15, Peca.BISPO_PRETO);
                                moverPeao = true;
                                promocaoPeao1++;
                             }   
                             else if(promocaoPeao.equals("Cavalo")){
                                Casa casaProxima = tabuleiro.getCasa(origemX, origemY);
                                casaProxima.removerPeca();
                                Casa casa15 = tabuleiro.getCasa(destinoX, destinoY);
                                peca = new Cavalo(casa15, Peca.CAVALO_PRETO);
                                moverPeao = true;
                                promocaoPeao1++;
                             }
                         }  
                    }
                }
            }
        }    
        return moverPeao;
    }
    
    public boolean enPassant(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo){
        boolean moverPeao = false;
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        int pedraTipo = origem.getPeca().getTipo();
        Peca pedraDest = destino.getPeca();
        
        if(pedraDest == null){
            if(pedraTipo == PEAO_BRANCO && origemY == 4){
                if((destinoX == origemX + 1) && (destinoY == origemY + 1)){
                    if(tabuleiro.getCasa(origemX + 1, destinoY - 1).getTipoPeca() == PEAO_PRETO){
                        Casa enPassantBranco = tabuleiro.getCasa(origemX + 1, destinoY - 1);
                        enPassantBranco.removerPeca();
                        peca.mover(destino);
                        moverPeao = true;
                    }
                }
                if((destinoX == origemX - 1) && (destinoY == origemY + 1)){
                    if(tabuleiro.getCasa(origemX - 1, destinoY - 1).getTipoPeca() == PEAO_PRETO){
                        Casa enPassantBranco = tabuleiro.getCasa(origemX - 1, destinoY - 1);
                        enPassantBranco.removerPeca();
                        peca.mover(destino);
                        moverPeao = true;
                    }
                }
            }
            
            if(pedraTipo == PEAO_PRETO && origemY == 3){
                if((destinoX == origemX + 1) && (destinoY == origemY - 1)){
                    if(tabuleiro.getCasa(origemX + 1, destinoY + 1).getTipoPeca() == PEAO_BRANCO){
                        Casa enPassantPreto = tabuleiro.getCasa(origemX + 1, destinoY + 1);
                        enPassantPreto.removerPeca();
                        peca.mover(destino);
                        moverPeao = true;
                    }
                }
                if((destinoX == origemX - 1) && (destinoY == origemY - 1)){
                    if(tabuleiro.getCasa(origemX - 1, destinoY + 1).getTipoPeca() == PEAO_BRANCO){
                        Casa enPassantPreto = tabuleiro.getCasa(origemX - 1, destinoY + 1);
                        enPassantPreto.removerPeca();
                        peca.mover(destino);
                        moverPeao = true;
                    }
                }
            }
        }
        return moverPeao;
    }
}
