public class No {
    private int fatorBalanceamento;
    private Object elemento;
    private No pai;
    private No filhoDireito;
    private No filhoEsquerdo;

    public No(Object elemento, No pai){
        this.elemento = elemento;
        this.pai = pai;
        this.filhoDireito = null;
        this.filhoEsquerdo = null;
        this.fatorBalanceamento = 0;
    }
    public Object getElemento() {
        return this.elemento;
    }
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }

    public int getFatorBalanceamento(){
        return this.fatorBalanceamento;
    }
    public void setFatorBalanceamento(int fatorBalanceamento){
        this.fatorBalanceamento = fatorBalanceamento;
    }
    public No getFilhoDireito(){
        return this.filhoDireito;
    }
    public void setFilhoDireito(No filhoDireito){
        this.filhoDireito = filhoDireito;
    }
    public No getFilhoEsquerdo(){
        return this.filhoEsquerdo;

    }
    public void setFilhoEsquerdo(No filhoEsquerdo){
        this.filhoEsquerdo = filhoEsquerdo;
    }
    public No getPai(){
        return this.pai;
    }
    public void setPai(No pai){
        this.pai = pai;
    }

    public boolean temFilhoEsquerdo(){
        return this.filhoEsquerdo != null);
    }
    public boolean temFilhoDireito(){
        return this.filhoDireito != null;
    }
    public boolean ehFilhoEsquerdo(){
        return this.pai != null && this.pai.getFilhoEsquerdo() == this;
    }
    public boolean ehFilhoDireito(){
        return this.pai != null && this.pai.getFilhoDireito() == this;
    }

}
