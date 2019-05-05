
public class Cavalo extends Peca{

    /**
     * Construtor para objetos da classe Cavalo
     */
    public Cavalo(Casa casa, int tipo)
    {
        super(casa, tipo);
    }

    public boolean podeMover(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo) {
        boolean moverCavalo = false;
        Tabuleiro tabuleiro = jogo.getTabuleiro();
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        
        
        if(origemX + 1 == destinoX && origemY + 2 == destinoY){
            moverCavalo = true;
            peca.mover(destino); 
        }
    
        if(origemX - 1 == destinoX && origemY + 2 == destinoY){
           moverCavalo = true;
           peca.mover(destino); 
        }
        
        if(origemX + 2 == destinoX && origemY + 1 == destinoY){
           moverCavalo = true;
           peca.mover(destino); 
        }
        
        if(origemX + 2 == destinoX && origemY - 1 == destinoY){
           moverCavalo = true;
           peca.mover(destino); 
        }
        
        if(origemX + 1 == destinoX && origemY - 2 == destinoY){
           moverCavalo = true;
           peca.mover(destino); 
        }
        
        if(origemX - 1 == destinoX && origemY - 2 == destinoY){
           moverCavalo = true;
           peca.mover(destino); 
        }
        
        if(origemX - 2 == destinoX && origemY - 1 == destinoY){
           moverCavalo = true;
           peca.mover(destino); 
        }
        
        if(origemX - 2 == destinoX && origemY + 1 == destinoY){
           moverCavalo = true;
           peca.mover(destino); 
        }
        
        if(origemX - 1 == destinoX && origemY + 2 == destinoY){
           moverCavalo = true;
           peca.mover(destino); 
        }
        return moverCavalo;
    }
    
}
