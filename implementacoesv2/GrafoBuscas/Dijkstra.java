import java.util.*;

public class Dijkstra<TipoVertice> {
    private Grafo<TipoVertice, Integer> grafo;

    public Dijkstra(Grafo<TipoVertice, Integer> grafo) {
        this.grafo = grafo;
    }

    public Map<TipoVertice, Double> encontrarMenoresCaminhos(TipoVertice origem) {
        Map<TipoVertice, Double> distancias = new HashMap<>();
        Map<TipoVertice, TipoVertice> antecessores = new HashMap<>();
        PriorityQueue<Par<TipoVertice>> filaPrioridade = new PriorityQueue<>();

        // Inicializa as distâncias
        for (TipoVertice v : grafo.vertices()) {
            distancias.put(v, Double.MAX_VALUE);
        }
        distancias.put(origem, 0.0);
        filaPrioridade.add(new Par<>(origem, 0.0));

        while (!filaPrioridade.isEmpty()) {
            Par<TipoVertice> atual = filaPrioridade.poll();
            TipoVertice verticeAtual = atual.vertice;
            double distanciaAtual = atual.distancia;

            // Percorre os vizinhos
            for (Aresta<TipoVertice, Integer> aresta : grafo.arestasIncidentes(verticeAtual)) {
                TipoVertice vizinho;
                try {
                    vizinho = grafo.oposto(verticeAtual, aresta);
                } catch (Exception e) {
                    continue;
                }

                double peso = aresta.getElemento().doubleValue();
                double novaDistancia = distanciaAtual + peso;

                if (novaDistancia < distancias.get(vizinho)) {
                    distancias.put(vizinho, novaDistancia);
                    antecessores.put(vizinho, verticeAtual);
                    filaPrioridade.add(new Par<>(vizinho, novaDistancia));
                }
            }
        }

        return distancias;
    }

    private static class Par<TipoVertice> implements Comparable<Par<TipoVertice>> {
        TipoVertice vertice;
        double distancia;

        Par(TipoVertice vertice, double distancia) {
            this.vertice = vertice;
            this.distancia = distancia;
        }

        @Override
        public int compareTo(Par<TipoVertice> outro) {
            return Double.compare(this.distancia, outro.distancia);
        }
    }
}

