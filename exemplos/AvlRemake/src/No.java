public class No {
    private No pai;
    private No filhoEsquerdo;
    private No filhoDireito;
    private Object elemento;
    private int fatorBalanceamento;

    public No(Object elemento, No pai){
        this.elemento = elemento;
        this.pai = pai;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.fatorBalanceamento = 0;
    }

    public Object getElemento(){
        return this.elemento;
    }
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }

    public No getPai(){
        return this.pai;
    }
    public void setPai(No pai){
        this.pai = pai;
    }

    public No getFilhoEsquerdo(){
        return this.filhoEsquerdo;
    }
    public void setFilhoEsquerdo(No filhoEsquerdo){
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public No getFilhoDireito(){
        return this.filhoDireito;
    }
    public void setFilhoDireito(No filhoDireito){
        this.filhoDireito = filhoDireito;
    }

    public int getFatorBalanceamento(){
        return this.fatorBalanceamento;
    }

    public void setFatorBalanceamento(int fatorBalanceamento){
        this.fatorBalanceamento = fatorBalanceamento;
    }

    public boolean temFilhoEsquerdo(){
        return this.filhoEsquerdo != null;
    }

    public boolean temFilhoDireito(){
        return this.filhoDireito != null;
    }

    public boolean ehFilhoDireito(){
        if(pai.getFilhoDireito() == this){
            return true;
        }
        return false;
    }
    public boolean ehFilhoEsquerdo(){
        if(pai.getFilhoEsquerdo() == this){
            return true;
        }
        return false;
    }
}
