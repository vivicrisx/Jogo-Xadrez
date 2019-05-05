   

/**
 * Escreva a descrição da classe Bispo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Bispo extends Peca
{
     public Bispo(Casa casa, int tipo){
    
        super(casa, tipo);
    }
    
    public boolean podeMover(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo) {
        boolean moverBispo = false;
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        
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
                   moverBispo =  true;
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
                   moverBispo =  true;
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
                   moverBispo =  true;
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
                   moverBispo =  true;
                   peca.mover(destino);
                }
            }
        }
        
        return moverBispo;
    }
    
}


