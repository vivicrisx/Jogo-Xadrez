
/**
 * Representa uma Pe�a do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public abstract class Peca {
    
    public static final int BISPO_BRANCO = 0;
    public static final int BISPO_PRETO = 1;
    public static final int CAVALO_BRANCO = 2;
    public static final int CAVALO_PRETO = 3;
    public static final int PEAO_BRANCO = 4;
    public static final int PEAO_PRETO = 5;
    public static final int RAINHA_BRANCA = 6;
    public static final int RAINHA_PRETA = 7;
    public static final int REI_BRANCO = 8;
    public static final int REI_PRETO = 9;
    public static final int TORRE_BRANCA = 10; 
    public static final int TORRE_PRETA = 11;
    
    
    int turno = 0;
    
    protected  Casa casa;
    private  int tipo;


    public Peca(Casa casa, int tipo) {
        this.casa = casa;
        this.tipo = tipo;
        casa.colocarPeca(this);
    }
    
    /**
     * Movimenta a peca para uma nova casa.
     * @param destino nova casa que ira conter esta peca.
     */
    public void mover(Casa destino) {
        casa.removerPeca();
        destino.colocarPeca(this);
        casa = destino;
        
    }
    
    public abstract boolean podeMover(int origemX, int origemY, int destinoX, int destinoY, Jogo jogo);
    
    public int getTipo() {
        return tipo;
    }
    
}
