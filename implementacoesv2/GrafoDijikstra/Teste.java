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
            Vertice<String> v4 = new Vertice<>("V4");

            // Insere os vértices no grafo
            grafo.inserirVertice(v1);
            grafo.inserirVertice(v2);
            grafo.inserirVertice(v3);
            grafo.inserirVertice(v4);

            // Insere as arestas com pesos
            grafo.inserirAresta(v1, v2, 5);
            grafo.inserirAresta(v2, v3, 3);
            grafo.inserirAresta(v3, v1, 7);
            grafo.inserirAresta(v1, v4, 2);
            grafo.inserirAresta(v4, v3, 1);

            // Exibir o grafo antes de rodar o Dijkstra
            System.out.println("\nGrafo:");
            imprimirGrafo(grafo);

            // 1
            Map<Vertice<String>, Double> menoresCaminhos = grafo.dijkstra(v1);

            // Exibir os menores caminhos encontrados
            System.out.println("\nMenores distâncias a partir de " + v1 + ":");
            for (Map.Entry<Vertice<String>, Double> entrada : menoresCaminhos.entrySet()) {
                System.out.println("Até " + entrada.getKey() + " -> " + entrada.getValue());
            }

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
                   
                    Vertice<String> vizinho = grafo.oposto(v, aresta);
                    System.out.print("[" + vizinho + "/" + aresta.getElemento() + "] ");
                }
                System.out.println();
            }
        }
    }
}
