public class Aresta<TipoVertice, TipoAresta>{
  private TipoVertice vertice1;
  private TipoVertice vertice2;
  private TipoAresta elemento;
  private boolean direcionada;
  
  public Aresta(TipoVertice vertice1, TipoVertice vertice2, TipoAresta elemento, boolean direcionada){
    this.vertice1 = vertice1;
    this.vertice2 = vertice2;
    this.elemento = elemento;
    this.direcionada = direcionada;
    }
  public TipoVertice getVertice1(){
    return this.vertice1;
  }
  public TipoVertice getVertice2(){
    return this.vertice2;
  }
  public TipoAresta getElemento(){
    return this.elemento;
  }
  public void setElemento(TipoAresta elemento){
    this.elemento = elemento;
  }
  public boolean conecta(TipoVertice v1, TipoVertice v2){
    if(direcionada){
      return vertice1.equals(v1) && vertice2.equals(v2);
    }
    return(vertice1.equals(v1) && vertice2.equals(v2) || vertice1.equals(v2) && vertice2.equals(v1));
   }
  public void substituirVertice(TipoVertice verticeAntigo, TipoVertice novoVertice){
    if(vertice1.equals(verticeAntigo)){
     vertice1 = novoVertice;
    }
    else if(vertice2.equals(verticeAntigo)){
      vertice2 = novoVertice;
    }
   }
  public TipoVertice[] getVertices(){
    return (TipoVertice[]) new Object[]{vertice1, vertice2};
  }
  }  
  
