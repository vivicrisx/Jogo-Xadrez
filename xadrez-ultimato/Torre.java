
/**
 * Escreva a descrição da classe Torre aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Torre extends Peca
{
    private int tipo;
    private Casa casa;  
    private int primeiraJogada = 0;
    /**
     * COnstrutor para objetos da classe Torre
     */
    public Torre(Casa casa, int tipo)
    {
        super(casa, tipo);
    }

    public boolean podeMover(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo) {
        boolean moverTorre = false;
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();

        //pra cima
        if(origemX == destinoX){
            if(origemY < destinoY){
                Casa casaGarantida = null;
                for(int y = origemY + 1; y < destinoY; y++ ){
                    Casa casaChecar = tabuleiro.getCasa(origemX,y);
                    if(casaChecar.possuiPeca() == true){
                        
                        casaGarantida = casaChecar;
                        
                    }
                }
                if(casaGarantida == null){
                    moverTorre = true;
                    peca.mover(destino);
                    primeiraJogada++;
                }
            }
        }
        //pra baixo
        if(origemX == destinoX){
            if(origemY > destinoY){
                Casa casaGarantida = null;
                for(int y = origemY - 1; y > destinoY; y-- ){
                    Casa casaChecar = tabuleiro.getCasa(origemX,y);
                    if(casaChecar.possuiPeca() == true){
                        
                        casaGarantida = casaChecar;
                        
                    }
                }
                if(casaGarantida == null){
                    moverTorre = true;
                    peca.mover(destino);
                    primeiraJogada++;
                }
            }
        }
        //pro lado direito
        if(origemY == destinoY){
            if(origemX < destinoX){
                Casa casaGarantida = null;
                for(int x = origemX + 1; x < destinoX; x++ ){
                    Casa casaChecar = tabuleiro.getCasa(x,origemY);
                    if(casaChecar.possuiPeca() == true){
                        
                        casaGarantida = casaChecar;
                        
                    }
                }
                if(casaGarantida == null){
                    moverTorre = true;
                    peca.mover(destino);
                    primeiraJogada++;
                }
            }
            
        }
        //lado esquerdo
        if(origemY == destinoY){
            if(origemX > destinoX){
                Casa casaGarantida = null;
                for(int x = origemX - 1; x > destinoX; x-- ){
                    Casa casaChecar = tabuleiro.getCasa(x,origemY);
                    if(casaChecar.possuiPeca() == true){
                        
                        casaGarantida = casaChecar;
                        
                    }
                }
                if(casaGarantida == null){
                    moverTorre = true;
                    peca.mover(destino);
                    primeiraJogada++;
                }
            }
            
        }
        

        return moverTorre;
    }   
    
    public int getPrimeiraJogada(){
    
        return primeiraJogada;
    }
   
}
