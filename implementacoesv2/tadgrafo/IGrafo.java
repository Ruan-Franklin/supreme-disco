import java.util.Set;
public interface IGrafo<TipoVertice, TipoAresta>{
   /**
     * Retorna os vértices finais de uma aresta.
     * @param aresta a aresta cujo os vértices finais devem ser retornados
     * @return um array contendo os dois vértices finais de uma aresta
     */
     public TipoVertice[] finalVertices(Aresta<TipoVertice, TipoAresta> aresta);
     
     /**
     
      *Retorna o vértice oposto ao vértice dado em uma aresta.
      *@param vertice o vértice inicial
      *@param aresta a aresta incidente ao vértice
      *return o vértice oposto
      *throws ArestaNaoIncidenteExcecao se o vértice não for incidente à aresta.
      */
      
      public TipoVertice oposto(TipoVertice vertice, Aresta<TipoVertice, TipoAresta> aresta);
      
      /**
       * Verifica se os dois vértices são adjacentes (conectados por uma aresta)
       * @param vertice1 o primeiro vértice
       * @param vertice2 o segundo vértice
       * @return true se forem adjacentes, false caso o contrário
      */
      
      public boolean ehAdjacente(TipoVertice vertice1, TipoVertice vertice2);
     /**
      *Substitui um vértice no grafo por outro
      *@param vertice o vértice a ser substituido
      *@param novoVertice o novo vértice
     */
     public void substituirVertice(TipoVertice vertice, TipoVertice novoVertice);
     /**
      * Substitui o elemento armazenado em uma aresta.
      * @param aresta a aresta a ser atualizada
      * @param novoElemento o novo elemento para substituir o anterior
    */
    public void substituirAresta(Aresta<TipoVertice, TipoAresta> aresta, TipoAresta novoElemento);
    /**
     *Insere um novo vértice no grafo.
     *@param elemento o elemento a ser armazenado no vértice
     *return o vértice recém-inserido
    */
    
    public TipoVertice inserirVertice(TipoVertice elemento);
    /**
     *Insere uma nova aresta não dirigida entre dois vértices.
     *@param vertice1 o primeiro vertice
     *@param vertice2 o segundo vértice
     *@param elemento o elemento armazenado na aresta
     *return a aresta recém-inserida
     */
    public Aresta<TipoVertice, TipoAresta> inserirAresta(TipoVertice vertice1, TipoVertice vertice2, TipoAresta elemento);
    
    /**
     *Remove uma aresta do grafo
     * @param aresta a aresta a ser removida
     * return o elemento armazenado na aresta removida
    */
    public TipoAresta removeAresta(Aresta<TipoVertice, TipoAresta> aresta);
    /**
     *Retorna todos os vértices do grafo
     * @return um conjunto de vértices do grafo
     */
    public Set <TipoVertice> vertices();
    /**
     * Retorna todas as arestas do grafo.
     * @return um conjunto de arestas do grafo.
    */
    public Set<Aresta<TipoVertice, TipoAresta>> arestas();
    
    }
      
