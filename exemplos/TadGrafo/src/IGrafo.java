import java.util.Vector;

/**
 * Interface que define os métodos que um grafo deve implementar.
 */
public interface IGrafo {
    /**
     * Retorna um array armazenando os vértices finais da aresta e
     * @param e aresta
     * @return array com os vértices finais da aresta
     */
    public int[] finalVertices(int e);
    /**
     * Retorna o vértice oposto de v em e, ou seja, o vértice final da aresta e separado do vértice v.
     * Um erro ocorre se não é incidente a v
     */
    public int oposto(int v, int e);
    /**
     * Retorna verdadeiro se os vértices v e w são adjacentes
     * @param v vértice
     * @param w vértice
     * @return verdadeiro se os vértices v e w são adjacentes
     */
    public boolean ehAdjacente(int v, int w);
    /**
     * Substitui o elemento de vértice v por x
     * @param v vértice
     * @param x elemento
     */
    public void substituir(Vertice v, Object x);
    /**
     * Substitui o elemento armazenado na aresta e por x
     * @param e aresta
     * @param x elemento
     */
    public void substituirAresta(Aresta e, Object x);
    /**
     * Insere e retorna um novo vértice, armazenando um elemento o
     * @param o elemento
     * @return vértice
     */
    public int inserirVertice(Object o);
    /**
     * Insere e retorna uma nova aresta não-dirigida (v,w), armazenando o elemento o
     * @param v vértice
     * @param w vértice
     * @param o elemento
     * @return aresta
     */
    public int inserirAresta(int v, int w, Object o);

    /**
     * Remove o vértice v e todas as arestas incidentes e retorna o elemento
     * @param v vértice
     * @return elemento
     */
    public Object removerVertice(int v);
    /**
     * Remove a aresta e e retorna o elemento armazenado
     * @param e aresta
     * return elemento
     */
    public Object removerAresta(int e);
    /**
     * Retorna uma coleção de todas as arestas incidentes sob o vértice V
     * @param v vértice
     * @return coleção de arestas incidentes
     */
    public Object arestasIncidentes(int v);
    /**
     * Retorna uma coleção de todos os vértices no grafo
     * @return coleção de vértices
     */
    public Vector <Vertice> vertices();
    /**
     * Retorna uma coleção de todas as arestas no grafo
     * @return coleção de arestas
     */
    public Vector <Vector <Vector <Aresta>>> arestas();
    /**
     * Testa se a aresta é direcionada
     * @param e aresta
     * @return verdadeiro se a aresta é direcionada
     */
    public boolean ehDirecionado(int e);
    /**
     * Insere uma nova aresta dirigida com origem em v, destino em w e armazenando o elemento o
     * @param v vértice
     * @param w vértice
     * @param o elemento
     */
    public void inserirArestaDirecionada(Aresta v, int w, Object o);


}
