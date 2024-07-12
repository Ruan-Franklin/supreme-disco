public class No{
  private No pai;
  private No filhoEsquerdo;
  private No filhoDireito;
  private Object elemento;
  private Object cor;

  public No(Object elemento, No pai){
    this.elemento = elemento;
    this.pai = pai;
    filhoEsquerdo = null;
    filhoDireito = null;
    cor = "negro";
}
  public Object getElemento(){ 
    return elemento;
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
  public No getFilhoDireito(){
    return filhoDireito;
}
  public void setFilhoDireito(No filhoDireito){
    this.filhoDireito = filhoDireito;
  }
  public No  getFilhoEsquerdo(){
    return this.filhoEsquerdo;
  }
  public void setFilhoDireito(No filhoDireito){
   this.filhoDireito = filhoDireito;
  }
  public Object getCor(){
    return this.cor;
  }
  public void setCor(Object cor){
    this.cor = cor;
  }
  public boolean temFilhoEsquerdo(){
    return filhoEsquerdo != null;
  }
  public boolan temFilhoDireito(){
    return filhoDireito != null;
  }
}
