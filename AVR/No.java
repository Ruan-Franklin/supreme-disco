public class No {
    private Object elemento;
    private No filhoEsquerdo;
    private No filhoDireito;
    private No pai;
    private int fatorBalanceamento;
    private Object cor;
    //Construtor da classe No
    public No(Object elemento){
        //Elemento do nó recebe  o elemento passado como parâmetro
        this.elemento = elemento;
        //Filhos do nó recebem null como padrão na criação do nó
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        //Pai do nó recebe null como padrão na criação do nó
        this.pai = null;
        //Fator de balanceamento do nó recebe 0 como padrão na criação do nó
        this.fatorBalanceamento = 0;
        this.cor = "Negro";
    }
    public Object getElemento(){
        return elemento;
    }
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
    public No getPai(){
        return pai;
    }
    public void setPai(No pai){
        this.pai = pai;
    }
    public No getFilhoDireito(){
        return filhoDireito;
    }
    public void setFilhoDireito(No filhoDireito){
        this.filhoDireito = filhoDireito;
    }
    public No getFilhoEsquerdo(){
        return filhoEsquerdo;
    }
    public void setFilhoEsquerdo(No filhoEsquerdo){
        this.filhoEsquerdo = filhoEsquerdo;
    }
    public int getFatorBalanceamento(){
        return fatorBalanceamento;
    }
    public void setFatorBalanceamento(int fatorBalanceamento){
        this.fatorBalanceamento = fatorBalanceamento;
    }

    public No getCor(No 

    public void setCor(Object cor){
        this.cor = cor;
    }
}