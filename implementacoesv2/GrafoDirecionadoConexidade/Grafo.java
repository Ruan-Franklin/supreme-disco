public class Grafo implements IGrafo <TipoVertice, TipoAresta>{
  private Map<TipoVertice, Set<Aresta<TipoVertice,TIpoAresta>>> adjacencias;
  private boolean direcionado;

  public Grafo(boolean direcionado){
    this.adjacencias = new HashMap<>();
    this.direcionado = direcionado;
  }

  @Override
  public Object[] finalVertices(Aresta<TipoVertice, TipoAresta> aresta){
    return new Object{aresta.getVertice1(), aresta.getVertice2()};
  }

  @Override
  public TipoVertice oposto(TipoVertice vertice, Aresta<TipoVertice, TipoAresta> aresta) throws VerticeInvalidoExcecao{
    if(vertice.equals(aresta.getVertice1()){
      return aresta.getVertice2();
    }
    else if(vertice.equals(aresta.getVertice2())){
     return aresta.getVertice1();
    }
    throw new VerticeInvalidoExcecao("Vértice não encontrado no Grafo!");
  }

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
      throw new VerticeInvalidoExcecao("Vértice Antigo não encontrado!");
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
  public TipoVertice inserirVertice(TipoVertice, novoVertice){
    adjacencias.putIfAbsent(vertice, newHashSet<>();
    return vertice;
  }
  @Override
  public Aresta inserirAresta(TipoVertice vertice1, TipoVertice vertice2, TipoAresta elemento) throws VerticeInvalidoExcecao{
    if(!adjacencias.containsKey(vertice1) || !adjacencias.containsKey(vertice2)){
      throw new VerticeInvalidoExcecao("Algum dos vértices não está presente no Grafo");
    }
    Aresta<TipoVertice, TipoAresta> = new Aresta<>(vertice1, vertice2, elemento, this.direcionado);
    if(this.direcionado){
      adjacencias.get(vertice1).add(aresta);
      adjacencias.get(vertice2).add(aresta);
    }
    return aresta;
  }

  public TipoVertice removerVertice(TipoVertice vertice) throws VerticeInvalidoExcecao{
    if(!adjacencias.containsKey(vertice){
     throw new VerticeInvalidoExcecao("Vértice não encontrado no Grafo");
    }
    for(Aresta<TIpoVertice, TIpoAresta> aresta : adjacencias.get(vertice)){
      TipoVertice oposto = oposto(vertice, aresta);
      adjacencias.get(oposto).remove(aresta);
    }
    adjacencias.remove(vertice);
    return vertice;
  }
  @Override
  public TipoAresta removerAresta(Aresta<TipoVertice, TipoAresta> aresta) throws ArestaInvalidaExcecao{ 
    if(!adjacencias.containsKey(aresta.getVertice1()) || !adjacencias.containsKey(aresta.getVertice2()){
      throw new ArestaInvalidaExcecao("Aresta não existe no Grafo");
    }
    adjacencias.get(aresta.getVertice1().remove(aresta);
    adjacencias.get(aresta.getVertice2().remove(aresta);
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
}
  

