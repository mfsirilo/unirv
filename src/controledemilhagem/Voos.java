package controledemilhagem;

public class Voos {

    private int codigoVoo;
    private String origem;
    private String destino;
    private float distancia;

    public int getCodigoVoo() {
        return codigoVoo;
    }

    public void setCodigoVoo(int codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
        }
    
    public Voos(int codigoVoo, String origem, String destino, float distancia){
        setCodigoVoo(codigoVoo);
        setOrigem(origem);
        setDestino(destino);
        setDistancia(distancia);
    }
}
