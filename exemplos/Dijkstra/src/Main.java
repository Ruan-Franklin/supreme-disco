public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        int v1 = grafo.inserirVertice("A");
        int v2 = grafo.inserirVertice("B");
        int v3 = grafo.inserirVertice("C");
        int v4 = grafo.inserirVertice("D");
        grafo.inserirAresta(grafo.vertices(v1), grafo.vertices(v2), "Aresta AB", false, 4.0);
        grafo.inserirAresta(grafo.vertices(v3), grafo.vertices(v4), "ARESTA CD", false, 3.0);
        grafo.inserirAresta(grafo.vertices(v1), grafo.vertices(v3), "ARESTA AC", false, 2.0);
        grafo.mostrarLista();

    }
}

