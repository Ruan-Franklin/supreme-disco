import java.util.Arrays;

public class Teste {
    public static void main(String[] args) {
        try {
            // Cria um grafo com vértices do tipo String e arestas com elementos do tipo Integer
            Grafo<Object, Integer> grafo = new Grafo<>();

            // Inserir vértices no grafo
            Object verticeA = grafo.inserirVertice("A");
            Object verticeB = grafo.inserirVertice("B");
            Object verticeC = grafo.inserirVertice("C");

            // Inserir arestas
            Aresta<Object, Integer> arestaAB = grafo.inserirAresta(verticeA, verticeB, 10);
            Aresta<Object, Integer> arestaBC = grafo.inserirAresta(verticeB, verticeC, 20);

            // Exibir vértices e arestas do grafo
            System.out.println("Vértices do grafo: " + grafo.vertices());
            System.out.println("Arestas do grafo: " + grafo.arestas());

            // Testar o método finalVertices
            Object[] verticesArestaAB = grafo.finalVertices(arestaAB);
            System.out.println("Vértices finais da aresta AB: " + Arrays.toString(verticesArestaAB));

            // Testar o método oposto (obtendo o vértice oposto a A na aresta AB)
            Object opostoDeA = grafo.oposto(verticeA, arestaAB);
            System.out.println("Vértice oposto a 'A' na aresta AB: " + opostoDeA);

            // Testar se os vértices são adjacentes
            System.out.println("A e B são adjacentes? " + grafo.ehAdjacente(verticeA, verticeB));
            System.out.println("A e C são adjacentes? " + grafo.ehAdjacente(verticeA, verticeC));

            // Substituir o vértice "C" por "D"
            grafo.substituirVertice(verticeC, "D");
            System.out.println("Vértices após substituir 'C' por 'D': " + grafo.vertices());

            // Substituir o elemento da aresta AB
            grafo.substituirAresta(arestaAB, 15);
            System.out.println("Novo elemento da aresta AB: " + arestaAB.getElemento());

            // Remover a aresta BC
            Integer elementoRemovido = grafo.removeAresta(arestaBC);
            System.out.println("Elemento removido da aresta BC: " + elementoRemovido);
            System.out.println("Arestas do grafo após remoção da aresta BC: " + grafo.arestas());

            // Remover o vértice B (que também remove as arestas incidentes)
            Object verticeRemovido = grafo.removerVertice(verticeB);
            System.out.println("Vértice removido: " + verticeRemovido);
            System.out.println("Vértices do grafo após remoção: " + grafo.vertices());
            System.out.println("Arestas do grafo após remoção do vértice B: " + grafo.arestas());

        } catch (VerticeInvalidoExcecao | ArestaInvalidaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

