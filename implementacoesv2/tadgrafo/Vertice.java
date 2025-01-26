public class Vertice<TipoElemento>{
  private TipoElemento elemento;
  public Vertice(TipoElemento elemento){
    this.elemento = elemento;
    }
    /**
     *Retorna o elemento armazenado no vértice.
     *@return o elemento do vértice
     */
     /**
     * Substitui o elemento armazenado no vértice por um novo elemento
     *@param elemento o novo elemento
     */
   public void setElemento(TipoElemento elemento){
     this.elemento = elemento;
       }
   public TipoElemento getElemento(){
     return this.elemento;
       }
       
   public String ToString(){
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
