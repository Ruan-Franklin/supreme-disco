import java.util.*;

public class AEstrela<TipoVertice> {
    private Grafo<TipoVertice, Integer> grafo;

    public AEstrela(Grafo<TipoVertice, Integer> grafo) {
        this.grafo = grafo;
    }

    public List<TipoVertice> encontrarCaminho(TipoVertice inicio, TipoVertice destino, Map<TipoVertice, int[]> coordenadas) {
        PriorityQueue<Par<TipoVertice>> filaPrioridade = new PriorityQueue<>();
        Map<TipoVertice, Double> gScore = new HashMap<>();
        Map<TipoVertice, Double> fScore = new HashMap<>();
        Map<TipoVertice, TipoVertice> veioDe = new HashMap<>();

        for (TipoVertice v : grafo.vertices()) {
            gScore.put(v, Double.MAX_VALUE);
            fScore.put(v, Double.MAX_VALUE);
        }
        gScore.put(inicio, 0.0);
        fScore.put(inicio, heuristicaManhattan(inicio, destino, coordenadas));

        filaPrioridade.add(new Par<>(inicio, fScore.get(inicio)));

        while (!filaPrioridade.isEmpty()) {
            TipoVertice atual = filaPrioridade.poll().vertice;

            if (atual.equals(destino)) {
                return reconstruirCaminho(veioDe, atual);
            }

            for (Aresta<TipoVertice, Integer> aresta : grafo.arestasIncidentes(atual)) {
                TipoVertice vizinho;
                try {
                    vizinho = grafo.oposto(atual, aresta);
                } catch (Exception e) {
                    continue;
                }

                double tentativeGScore = gScore.get(atual) + aresta.getElemento();
                if (tentativeGScore < gScore.get(vizinho)) {
                    veioDe.put(vizinho, atual);
                    gScore.put(vizinho, tentativeGScore);
                    fScore.put(vizinho, gScore.get(vizinho) + heuristicaManhattan(vizinho, destino, coordenadas));

                    filaPrioridade.add(new Par<>(vizinho, fScore.get(vizinho)));
                }
            }
        }

        return new ArrayList<>(); 
    }

    private double heuristicaManhattan(TipoVertice v1, TipoVertice v2, Map<TipoVertice, int[]> coordenadas) {
        int[] coord1 = coordenadas.get(v1);
        int[] coord2 = coordenadas.get(v2);

        return Math.abs(coord1[0] - coord2[0]) + Math.abs(coord1[1] - coord2[1]);
    }

    private List<TipoVertice> reconstruirCaminho(Map<TipoVertice, TipoVertice> veioDe, TipoVertice atual) {
        List<TipoVertice> caminho = new ArrayList<>();
        while (atual != null) {
            caminho.add(atual);
            atual = veioDe.get(atual);
        }
        Collections.reverse(caminho);
        return caminho;
    }

    private static class Par<TipoVertice> implements Comparable<Par<TipoVertice>> {
        TipoVertice vertice;
        double prioridade;

        Par(TipoVertice vertice, double prioridade) {
            this.vertice = vertice;
            this.prioridade = prioridade;
        }

        @Override
        public int compareTo(Par<TipoVertice> outro) {
            return Double.compare(this.prioridade, outro.prioridade);
        }
    }
}

