import java.util.*;
public class Grafo implements IGrafo{
    //private Map<Integer, Vertice> vertices;
    private Map<Integer, Vertice> vertices;
   // private Map<Integer, Aresta> arestas;
   private Map<Integer, Aresta> arestas;
   private Map<Integer, List<Aresta>> adjList;
   private int proximoIdVertice;
   private int proximoIdAresta;
   public Grafo(){
    vertices = new HashMap<>();
    arestas = new HashMap<>();
    adjList = new HashMap<>();
    proximoIdVertice = 0;
    proximoIdAresta = 0;
    }
    @Override
    public int[] finalVertices(int e){
        return null;
    }
    @Override
    public int oposto(Vertice v, int e){
        return null;
    }
    @Override
    public void substituirAresta(Aresta e, Object x){
        return null;
    }
    @Override
    public int inserirVertice(Object o){
        return null;
    }

}