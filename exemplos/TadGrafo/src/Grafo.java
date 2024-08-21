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
    public int[] finalVertices(int e) throws ArestaNaoEncontradaExcecao {
        if (!arestas.containsKey(e)) {
            throw new ArestaNaoEncontradaExcecao("Aresta não encontrada no grafo!");
        }
        Aresta aresta = arestas.get(e);
        return new int[]{aresta.v1(), aresta.v2()};
    }

    @Override
    public int oposto(Vertice v, int e) throws ArestaNaoEncontradaExcecao, VerticeNaoEncontradoExcecao {
        if (!arestas.containsKey(e)) {
            throw new ArestaNaoEncontradaExcecao("Aresta não encontrada no grafo!");
        }
        Aresta aresta = arestas.get(e);
        if (aresta.v1() == v.getId()) {
            return aresta.v2();
        } else if (aresta.v2() == v.getId()) {
            return aresta.v1();
        } else {
            throw new VerticeNaoEncontradoExcecao("Vértice não encontrado na aresta!");
        }
    }

    @Override
    public boolean ehAdjacente(int v, int w) {
        if (!adjList.containsKey(v)) {
            return false;
        }
        for (Aresta aresta : adjList.get(v)) {
            if (aresta.v1() == v && aresta.v2() == w || aresta.v1() == w && aresta.v2() == v) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void substituir(Vertice v, Object x) throws VerticeNaoEncontradoExcecao {
        if (!vertices.containsKey(v.getId())) {
            throw new VerticeNaoEncontradoExcecao("Vértice não encontrado no grafo!");
        }
        v.setValor(x);
    }

    @Override
    public void substituirAresta(Aresta e, Object x) throws ArestaNaoEncontradaExcecao {
        if (!arestas.containsKey(e.getId())) {
            throw new ArestaNaoEncontradaExcecao("Aresta não encontrada no grafo!");
        }
        e.setValor(x);
    }

    @Override
    public int inserirVertice(Object o) {
        Vertice vertice = new Vertice(o);
        vertice.setId(proximoIdVertice);
        vertices.put(proximoIdVertice, vertice);
        adjList.put(proximoIdVertice, new ArrayList<>());
        return proximoIdVertice++;
    }

    @Override
    public int inserirAresta(Vertice v, Vertice w, Object o, Boolean direcionada) throws VerticeNaoEncontradoExcecao {
        if (!vertices.containsKey(v.getId()) || !vertices.containsKey(w.getId())) {
            throw new VerticeNaoEncontradoExcecao("Vértice não encontrado no grafo!");
        }
        Aresta aresta = new Aresta(proximoIdAresta, v.getId(), w.getId(), o, direcionada);
        arestas.put(proximoIdAresta, aresta);
        adjList.get(v.getId()).add(aresta);

        if (!direcionada) {
            adjList.get(w.getId()).add(aresta);
        }
        return proximoIdAresta++;
    }

    @Override
    public Object removerVertice(Vertice v) throws VerticeNaoEncontradoExcecao {
        if (!vertices.containsKey(v.getId())) {
            throw new VerticeNaoEncontradoExcecao("Vértice não encontrado no grafo!");
        }
        List<Aresta> arestasParaRemover = new ArrayList<>(adjList.get(v.getId()));
        for (Aresta aresta : arestasParaRemover) {
            removerAresta(aresta);
        }
        vertices.remove(v.getId());
        adjList.remove(v.getId());
        return v.getValor();
    }

    @Override
    public Object removerAresta(Aresta e) throws ArestaNaoEncontradaExcecao {
        if (!arestas.containsKey(e.getId())) {
            throw new ArestaNaoEncontradaExcecao("Aresta não encontrada no grafo!");
        }
        arestas.remove(e.getId());
        Vertice v1 = vertices.get(e.v1());
        Vertice v2 = vertices.get(e.v2());
        adjList.get(v1.getId()).remove(e);
        if (!e.isDirecionada()) {
            adjList.get(v2.getId()).remove(e);
        }
        return e.getValor();
    }

    @Override
    public List<Aresta> arestasIncidentes(Vertice v) {
        if (!vertices.containsKey(v.getId())) {
            throw new VerticeNaoEncontradoExcecao("Vértice não encontrado no grafo!");
        }
        return new ArrayList<>(adjList.get(v.getId()));
    }

    @Override
    public Vertice vertices(int id) throws VerticeNaoEncontradoExcecao{
        if(!vertices.containsKey(id)){
            throw new VerticeNaoEncontradoExcecao("Vértice não encontrado no grafo!");
        }
        return vertices.get(id);

    }

    @Override
    public Vector<Vector<List<Aresta>>> arestas() {
        Vector<Vector<List<Aresta>>> matrizAdj = new Vector<>();
        for (int i = 0; i < vertices.size(); i++) {
            matrizAdj.add(new Vector<>());
            for (int j = 0; j < vertices.size(); j++) {
                matrizAdj.get(i).add(new ArrayList<>());
            }
        }
        for (Aresta aresta : arestas.values()) {
            int v1 = aresta.v1();
            int v2 = aresta.v2();
            matrizAdj.get(v1).get(v2).add(aresta);
            if (!aresta.isDirecionada()) {
                matrizAdj.get(v2).get(v1).add(aresta);
            }
        }
        return matrizAdj;
    }

    @Override
    public boolean ehDirecionado(Aresta e) throws ArestaNaoEncontradaExcecao {
        if (!arestas.containsKey(e.getId())) {
            throw new ArestaNaoEncontradaExcecao("Aresta não encontrada no grafo!");
        }
        return e.isDirecionada();
    }
    public void mostrarGrafo(){
        System.out.println("Vertices:");
        for(Vertice v: vertices.values()){
            System.out.println("Id do vértice: " + v.getId() + " Valor do vertice:" + v.getValor());
        }
        System.out.println("\nArestas:");
        for(Aresta e: arestas.values()){
            System.out.println("Aresta id: " + e.getId() + " Vértice 1: " + e.v1() + " Vértice 2: " + e.v2() + " valor: " +e.getValor() + " É direcionada? " + e.isDirecionada());
        }
    }

    @Override
    public void inserirArestaDirecionada(Vertice v, Vertice w, Object o) throws VerticeNaoEncontradoExcecao {
        inserirAresta(v, w, o, true);
    }
}
