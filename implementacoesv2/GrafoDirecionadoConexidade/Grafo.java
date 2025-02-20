import java.util.*;
public class Grafo<TipoVertice, TipoAresta> implements IGrafo<TipoVertice, TipoAresta>{
  private Map<TipoVertice, Set<Aresta<TipoVertice, TipoAresta>>> adjacencias;
  private boolean direcionado;
  
  public Grafo(boolean direcionado){
    this.adjacencias = new HashMap<>();
    this.direcionado = direcionado;
  }
  @Override
  public Object[] finalVertices(Aresta <TipoVertice, TipoAresta> aresta){
    return new Object[]{aresta.getVertice1(), aresta.getVertice2()};
  }
  
  @Override
  public TipoVertice oposto(TipoVertice vertice, Aresta<TipoVertice, TipoAresta> aresta) throws VerticeInvalidoExcecao{
    if(aresta.getVertice1().equals(vertice)){
     return aresta.getVertice2();
    }
   if(aresta.getVertice2().equals(vertice)){
     return aresta.getVertice1();
   }
   throw new VerticeInvalidoExcecao("Vértice informado não foi localizado");
   } 
  @Override
  public boolean ehAdjacente(TipoVertice vertice1, TipoVertice vertice2) throws VerticeInvalidoExcecao{
    if(!adjacencias.containsKey(vertice1)){
      return false;
    }
    for(Aresta<TipoVertice, TipoAresta> aresta: adjacencias.get(vertice1)){
      if(aresta.conecta(vertice1, vertice2)){
        return true;
      }
      }
    return false;
    }
    
  @Override
  public void substituirVertice(TipoVertice verticeAntigo, TipoVertice novoVertice) throws VerticeInvalidoExcecao{
    if(!adjacencias.containsKey(verticeAntigo)){
      throw new VerticeInvalidoExcecao("Vértice antigo não encontrado");
      }
    Set<Aresta<TipoVertice, TipoAresta>> arestas = adjacencias.remove(verticeAntigo);
    adjacencias.put(novoVertice, arestas);
    for(Aresta<TipoVertice, TipoAresta> aresta : arestas){
      aresta.substituirVertice(verticeAntigo, novoVertice);
      }
    }
  @Override
  public void substituirAresta(Aresta <TipoVertice, TipoAresta> aresta, TipoAresta novoElemento){
    aresta.setElemento(novoElemento);
   }
  @Override
  public TipoVertice inserirVertice(TipoVertice vertice){
    adjacencias.putIfAbsent(vertice, new HashSet<>());
    return vertice;
    }
  @Override
  public Aresta<TipoVertice, TipoAresta> inserirAresta(TipoVertice vertice1, TipoVertice vertice2, TipoAresta elemento) throws VerticeInvalidoExcecao{
    if(!adjacencias.containsKey(vertice1) || !adjacencias.containsKey(vertice2)){
      throw new VerticeInvalidoExcecao("Algum dos vértices passados não é válido");
      }
    Aresta<TipoVertice, TipoAresta> aresta = new Aresta<>(vertice1, vertice2, elemento, this.direcionado);
    if(this.direcionado){
     adjacencias.get(vertice1).add(aresta);
    }
    else{
      adjacencias.get(vertice1).add(aresta);
      adjacencias.get(vertice2).add(aresta);
     }
    return aresta;
   }

  public TipoVertice removerVertice(TipoVertice vertice) throws VerticeInvalidoExcecao{
    if(!adjacencias.containsKey(vertice)){
      throw new VerticeInvalidoExcecao("Vértice a ser removido não encontrado na lista de adjacências.");
    }
    for(Aresta<TipoVertice, TipoAresta> aresta : adjacencias.get(vertice)){
      TipoVertice oposto = oposto(vertice, aresta);
      adjacencias.get(oposto).remove(aresta);
    }
    adjacencias.remove(vertice);
    return vertice;
   }
   
   public boolean ehDirecionado(){
     if(this.direcionado == true){
       return true;
      }
     return false;
     }
  @Override
  public TipoAresta removeAresta(Aresta<TipoVertice, TipoAresta> aresta) throws ArestaInvalidaExcecao{
    if(!adjacencias.containsKey(aresta.getVertice1()) || !adjacencias.containsKey(aresta.getVertice2())){
      throw new ArestaInvalidaExcecao("Aresta não existe no grafo");
    }
    adjacencias.get(aresta.getVertice1()).remove(aresta);
    adjacencias.get(aresta.getVertice2()).remove(aresta);
    return aresta.getElemento();
    }
  public Set<Aresta<TipoVertice, TipoAresta>> arestasIncidentes(TipoVertice vertice){
    return adjacencias.getOrDefault(vertice, Collections.emptySet());
    }
  @Override
  public Set<TipoVertice> vertices(){
    return adjacencias.keySet();
  }
  @Override
  public Set<Aresta<TipoVertice, TipoAresta>> arestas(){
    Set<Aresta<TipoVertice, TipoAresta>> todasArestas = new HashSet<>();
    for(Set<Aresta<TipoVertice, TipoAresta>> arestas : adjacencias.values()){
      todasArestas.addAll(arestas);
    }
    return todasArestas;
    
    }
    
    
  public boolean conexo() {
    Set<TipoVertice> verticesNaoVisitados = new HashSet<>(this.vertices());
    int componentes = 0;
    
    // Enquanto H não estiver vazio
    while (!verticesNaoVisitados.isEmpty()) {

        TipoVertice verticeInicial = verticesNaoVisitados.iterator().next();
        

        Queue<TipoVertice> fila = new LinkedList<>();
        fila.add(verticeInicial);
        
        while (!fila.isEmpty()) {
            TipoVertice verticeAtual = fila.poll();
            if (verticesNaoVisitados.contains(verticeAtual)) {

                verticesNaoVisitados.remove(verticeAtual);

                for (Aresta<TipoVertice, TipoAresta> aresta : this.arestasIncidentes(verticeAtual)) {
                    try {

                        TipoVertice verticeAdjacente = this.oposto(verticeAtual, aresta);

                        if (verticesNaoVisitados.contains(verticeAdjacente)) {
                            fila.add(verticeAdjacente);
                        }
                    } catch (VerticeInvalidoExcecao e) {

                        e.printStackTrace();
                    }
                }
            }
        }

        componentes++;
    }
    

    return (componentes == 1);
}
    
       
    
    
           
    
    }
    
