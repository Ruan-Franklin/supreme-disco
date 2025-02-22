import java.util.*;

public class Teste {
    public static void main(String[] args) {
        try {
            // Cria um grafo direcionado (true) ou não direcionado (false)
            Grafo<Vertice<String>, Integer> grafo = new Grafo<>(true);
            
            // Cria os vértices
            Vertice<String> v1 = new Vertice<>("V1");
            Vertice<String> v2 = new Vertice<>("V2");
            Vertice<String> v3 = new Vertice<>("V3");
            
            // Insere os vértices no grafo
            grafo.inserirVertice(v1);
            grafo.inserirVertice(v2);
            grafo.inserirVertice(v3);
            
            // Insere as arestas e armazena a referência da aresta entre v1 e v2
            Aresta<Vertice<String>, Integer> a1 = grafo.inserirAresta(v1, v2, 5);
            grafo.inserirAresta(v2, v3, 3);
            grafo.inserirAresta(v3, v1, 7);
            System.out.println("Tem caminho euleriano?" + grafo.temCaminhoEuleriano());
            
            // Exibe o grafo antes da remoção
            System.out.println("Grafo antes da remoção:");
            imprimirGrafo(grafo);
            
            // Remove a aresta que conecta v1 a v2
            Integer removido = grafo.removeAresta(a1);
            System.out.println("\nAresta removida com o elemento (peso): " + removido);
            
            // Exibe o grafo após a remoção
            System.out.println("\nGrafo após a remoção:");
            imprimirGrafo(grafo);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Método auxiliar para imprimir a lista de adjacências do grafo
    public static void imprimirGrafo(Grafo<Vertice<String>, Integer> grafo) throws Exception {
        for (Vertice<String> v : grafo.vertices()) {
            System.out.print("|" + v + "| -> ");
            Set<Aresta<Vertice<String>, Integer>> incidentes = grafo.arestasIncidentes(v);
            if (incidentes.isEmpty()) {
                System.out.println("[]");
            } else {
                for (Aresta<Vertice<String>, Integer> aresta : incidentes) {
                    // Usa o método oposto para obter o vizinho conectado por essa aresta
                    Vertice<String> vizinho = grafo.oposto(v, aresta);
                    System.out.print("[" + vizinho + "/" + aresta.getElemento() + "] ");
                }
                System.out.println();
            }
        }
    }
}

