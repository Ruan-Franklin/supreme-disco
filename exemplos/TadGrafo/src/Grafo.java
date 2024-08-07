import java.util.*;
public class Grafo implements IGrafo {
    private Map<Integer, Vertice> vertices;
    private Map<Integer, Aresta> arestas;
    private Map<Integer, List<Aresta>> adjList;
    private int proximoIdVertice;
    private int proximoIdAresta;

    public Grafo() {
        vertices = new HashMap<>();
        arestas = new HashMap<>();
        adjList = new HashMap<>();
        proximoIdVertice = 0;
        proximoIdAresta = 0;
    }

    @Override
    public int[] finalVertices(int e) throws ArestaNaoEncontradaExcecao{
        if(!arestas.containsKey(e)){
            throw new ArestaNaoEncontradaExcecao("Aresta não encontrada no grafo!");
        }
        Aresta aresta = arestas.get(e);
        return new int[]{aresta.v1(), aresta.v2()};
    }

    @Override
    public int oposto(Vertice v, int e) throws ArestaNaoEncontradaExcecao, VerticeNaoEncontradoExcecao{
        if(!arestas.containsKey(e)){
            throw new ArestaNaoEncontradaExcecao("Aresta não encontrada no grafo!");
        }
        Aresta aresta = arestas.get(e);
        if(aresta.v1() == v.getId()){
            return aresta.v2();
        }
        else if(aresta.v2() == v.getId()) {
            return aresta.v1();
        }
        else{
            throw new VerticeNaoEncontradoExcecao("Vértice não encontrado na aresta!");
        }
    }

    @Override
    public boolean ehAdjacente(int v, int w) {
        if(!adjList.containsKey(v)){
            return false;
        }
        for(Aresta aresta : adjList.get(v)){
            if((aresta.v1() == v && aresta.v2() == w || (aresta.v1() == w && aresta.v2() == v))){
                return true;
            }
        }
        return false;
    }

    @Override
    public void substituir(Vertice v, Object x) throws VerticeNaoEncontradoExcecao {
        if(!vertices.containsKey(v.getId())){
            throw new VerticeNaoEncontradoExcecao("Vértice não encontrado no grafo!");
        }
        v.setValor(x);

    }

    @Override
    public void substituirAresta(Aresta e, Object x) throws ArestaNaoEncontradaExcecao {
        if(!arestas.containsKey(e.getId())){
            throw new ArestaNaoEncontradaExcecao("Aresta não encontrada no grafo!");
        }
        e.setValor(x);
    }

    @Override
    public int inserirVertice(Object o) {
        Vertice vertice =  new Vertice(o);
        vertice.setId(proximoIdVertice);
        vertices.put(proximoIdVertice, vertice);
        adjList.put(proximoIdVertice, new ArrayList<>());
        return proximoIdVertice++;
    }

    @Override
    public int inserirAresta(Vertice v, Vertice w, Object o) throws VerticeNaoEncontradoExcecao {
        if(!vertices.containsValue(v) || !vertices.containsKey(w)){
            throw new VerticeNaoEncontradoExcecao("Vértice não encontrado no grafo!");
        }
        Aresta aresta = new Aresta(proximoIdAresta, v.getId(), w.getId(), o);
        arestas.put(proximoIdAresta, aresta);
        adjList.get(v).add(aresta);
        adjList.get(w).add(aresta);
        return proximoIdAresta++;
    }

    @Override
    public Object removerVertice(Vertice v) throws VerticeNaoEncontradoExcecao {
        if(!vertices.containsKey(v.getId())){
            throw new VerticeNaoEncontradoExcecao("Vértice não encontrado no grafo!");
        }
        for(Aresta aresta : new ArrayList<>(adjList.get(v))){
            removerAresta(aresta);
        }
        vertices.remove(v.getId());
        adjList.remove(v);
        return v.getValor();
    }

    @Override
    public Object removerAresta(Aresta e) throws ArestaNaoEncontradaExcecao {
        if(!arestas.containsKey(e.getId())){
            throw new ArestaNaoEncontradaExcecao("Aresta não encontrada no grafo!");
        }


    }

    @Override
    public Object arestasIncidentes(int v) {
        return null;
    }

    @Override
    public Vector<Vertice> vertices() {
        return null;
    }

    @Override
    public Vector<Vector<List<Aresta>>> arestas() {
        return null;
    }

    @Override
    public boolean ehDirecionado(int e) {
        return false;
    }

    @Override
    public void inserirArestaDirecionada(int v, int w, Object o) {

    }
}
