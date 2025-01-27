import java.util.*;
public class Grafo<TipoVertice,TipoAresta> implements IGrafo<TipoVertice, TipoAresta>{
  private Map<TipoVertice, Set<Aresta<TipoVertice, TipoAresta>>> adjacencias;
  
  public Grafo(){
     this.adjacencias = new HashMap<>();
     }
  @Override
  public TipoVertice[] finalVertices(Aresta<TipoVertice, TipoAresta> aresta){
    return aresta.getVertices();
   }
   
  @Override
  public tipoVertice oposto(TipoVertice vertice, Aresta<TipoVertice, tipoAresta> aresta) throws VerticeInvalidoExcecao{
    if(aresta.getVertice1().equals(vertice)){
      return aresta.getVertice2();
    }
    if(aresta.getVertice2().equals(vertice)){
      return aresta.getVertice1();
   }
    throw new VerticeInvalidoExcecao("Vértice informado não foi encontrado ou não está em uma aresta");
   }
   
  @Override
  public boolean ehAdjacente(TipoVertice vertice1, TipoVertice vertice2) throws VerticeInvalidoExcecao{
    if(!adjacencias.containsKey(vertice)){
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
    adjacencias.put(novoVertice,arestas);
    for(Aresta<TipoVertice, TipoAresta> aresta : arestas){
      aresta.substituirVertice(verticeAntigo, novoVertice);
      }
    }
  @Override
  public void substituirAresta(Aresta <TipoVertice, TipoAresta> aresta, TipoAresta novoElemento){
    aresta.setElemento(novoElemento);
  }
  @Override
  public void TipoVertice inserirVertice(TipoVertice vertice){
    adjacencias.putIfAbsent(vertice, new HashSet<>());
    return vertice;
   }
  @Override
  public Aresta<TipoVertice, TipoAresta> inserirAresta(TipoVertice, vertice1, TipoVertice vertice2, elemento) throws VerticeInvalidoExcecao{
    if(!adjacencias.containsKey(vertice1) || !adjacencias.containsKey(vertice2){
      throw new VerticeInvalidoExcecao("Algum dos vértices passados não existe");
    }
    Aresta<TipoVertice, TipoAresta> aresta = new Aresta<>(vertice1, vertice2, elemento);
    adjacencias.get(vertice1).add(aresta);
    adjacencias.get(vertice2).add(aresta);
    }
  @Override
  public TIpoVertice removerVertice(TipoVertice vertice) throws VerticeInvalidoExcecao{
    if(!adjacencias.containsKey(vertice){
      throw new VerticeInvalidoExcecao("Vértice inexistente, não é possível remover");
      }
    for(Aresta<TipoVertice, TipoAresta> aresta : adjacencias.get(vertice)){
      TipoVertice oposto = oposto(vertice, aresta);
      adjacencias.get(oposto).remove(aresta);
     }
    adjacencias.remove(vertice);
    return vertice;
    }
  @Override
  public TipoAresta removeAresta(Aresta<TipoVertice, TipoAresta aresta> aresta) throws ArestaInvalidaExcecao{
    if(!adjacencias.containsKey(aresta.getVertice(1)){
      throw new ArestaInvalidaExcecao("Aresta não existe no Grafo");
      }
    adjacencias.get(aresta.getVertice1().remove(aresta);
    adjacencias.get(aresta.getVertice2().remove(aresta);
    return aresta.getElemento();
   }
  @Override
  public Set<Aresta<TipoVertice, TipoAresta>> arestasIncidentes(TipoVertice vertice){
    return adjacencias.getORDefault(vertice, Collections.emptySet());
  }
  
  @Override
  public Set<TipoVertice> vertices(){
    return adjacencias.keySet();
  }
  @Override
  public Set<Aresta<TipoVertice, TipoAresta>> arestas(){
    Set<Aresta<TipoVertice, TipoAresta>> todasArestas = new HashSet<>();
    for(Set<Aresta<TipoVertice, TipoAresta> arestas : adjacencias.values()){
      todasArestas.addAll(arestas);
      }
    return todasArestas;
    }
    
    }
    
    
    
      
     

    
      
   
   
    
