public class Vertice<TipoElemento>{
  private TipoElemento elemento;
  public Vertice(TipoElemento elemento){
    this.elemento = elemento;
  }
  public void setElemento(TipoElemento elemento){
    this.elemento = elemento;
  }
  public TipoElemento getElemento(){
    return elemento;
  }
  public String toString(){
    return elemento.toString();
  }
  @Override
  public boolean equals(Object obj){
    if(this == obj){
      return true;
   }
   if(obj == null || getClass() != obj.getClass()){
     return false;
   }
   Vertice<?> vertice = (Vertice<?>) obj;
   return elemento.equals(vertice.elemento);
   }
  @Override
  public int hashCode(){
    return elemento.hashCode(); 
   }
   }
   


