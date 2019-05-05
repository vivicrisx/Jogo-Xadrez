
/**
 * Escreva a descrição da classe Rainha aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Rainha extends Peca{

    /**
     * COnstrutor para objetos da classe Rainha
     */
    public Rainha(Casa casa, int tipo){
            super(casa, tipo);
    }
    
    
    public boolean podeMover(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo) {
        boolean moverRainha = false;
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
                    moverRainha =  true;
                    peca.mover(destino);
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
                    moverRainha =  true;
                    peca.mover(destino);
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
                    moverRainha =  true;
                    peca.mover(destino);
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
                    moverRainha =  true;
                    peca.mover(destino);
                }
            }
            
        }
        //diagonal
        for(int a = 1; a <= 8; a++){
            
            if((destinoX == origemX + a) && (destinoY == origemY - a)){
                
                Casa casaGarantida = null;
                int y = origemY - 1;
                int x = origemX + 1;
                for(; x < destinoX; x++, y-- ){
                    Casa casaChecar = tabuleiro.getCasa(x, y);
                    if((casaChecar.possuiPeca() == true) ){
                        casaGarantida = casaChecar;
                    }
                    
                }
                if((casaGarantida == null  )){
                   moverRainha =  true;
                   peca.mover(destino);
                }
            }
        }
        
        for(int a = 1; a <= 8; a++){
            
            if((destinoX == origemX - a) && (destinoY == origemY - a)){
                
                Casa casaGarantida = null;
                int y = origemY - 1;
                int x = origemX - 1;
                for(; x > destinoX; x--, y-- ){
                    Casa casaChecar = tabuleiro.getCasa(x, y);
                    if((casaChecar.possuiPeca() == true) ){
                        casaGarantida = casaChecar;
                    }
                    
                }
                if((casaGarantida == null  )){
                   moverRainha =  true;
                   peca.mover(destino);
                }
            }
        }
        
        
        for(int a = 1; a <= 8; a++){
            
            if((destinoX == origemX - a) && (destinoY == origemY + a)){
                
                Casa casaGarantida = null;
                int y = origemY + 1;
                int x = origemX - 1;
                for(; x > destinoX; x--, y++ ){
                    Casa casaChecar = tabuleiro.getCasa(x, y);
                    if((casaChecar.possuiPeca() == true) ){
                        casaGarantida = casaChecar;
                    }
                    
                }
                if((casaGarantida == null  )){
                   moverRainha =  true;
                   peca.mover(destino);
                }
            }
        }
        
        
        for(int a = 1; a <= 8; a++){
            
            if((destinoX == origemX + a) && (destinoY == origemY + a)){
                
                Casa casaGarantida = null;
                int y = origemY + 1;
                int x = origemX + 1;
                for(; x < destinoX; x++, y++ ){
                    Casa casaChecar = tabuleiro.getCasa(x, y);
                    if((casaChecar.possuiPeca() == true) ){
                        casaGarantida = casaChecar;
                    }
                
                }
                if((casaGarantida == null  )){
                   moverRainha =  true;
                   peca.mover(destino);
                }
            }
        }
        
        return moverRainha;
        
    }
    
}
