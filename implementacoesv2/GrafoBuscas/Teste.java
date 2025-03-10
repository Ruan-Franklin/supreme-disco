import java.util.*;
public class Teste {
    public static void main(String[] args) {
        try {
            Grafo<Vertice<String>, Integer> grafo = new Grafo<>(true);

            Vertice<String> v1 = new Vertice<>("V1");
            Vertice<String> v2 = new Vertice<>("V2");
            Vertice<String> v3 = new Vertice<>("V3");
            Vertice<String> v4 = new Vertice<>("V4");

            grafo.inserirVertice(v1);
            grafo.inserirVertice(v2);
            grafo.inserirVertice(v3);
            grafo.inserirVertice(v4);

            grafo.inserirAresta(v1, v2, 5);
            grafo.inserirAresta(v2, v3, 3);
            grafo.inserirAresta(v3, v1, 7);
            grafo.inserirAresta(v1, v4, 2);
            grafo.inserirAresta(v4, v3, 1);

            // Criar o algoritmo de Dijkstra
            Dijkstra<Vertice<String>> dijkstra = new Dijkstra<>(grafo);

            // Executar o Dijkstra a partir do vértice V1
            Map<Vertice<String>, Double> menoresCaminhos = dijkstra.encontrarMenoresCaminhos(v1);

            System.out.println("\nMenores distâncias a partir de " + v1 + ":");
            for (Map.Entry<Vertice<String>, Double> entrada : menoresCaminhos.entrySet()) {
                System.out.println("Até " + entrada.getKey() + " -> " + entrada.getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

