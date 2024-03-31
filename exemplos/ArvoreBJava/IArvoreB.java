public interface IArvoreB{
    
    // Insere um elemento na árvore
    public void inserir(Object elemento);
    
    /*
     * Remove um elemento da árvore
     * @param elemento o elemento a ser removido
     */
    public void remover(Object elemento);
    
    /*  Verifica se a árvore está vazia
        *  @return true se a árvore estiver vazia, false caso contrário
     */
    
   public boolean estaVazia();
    
    /*
     * @return a quantidade de elementos na árvore
     */
    public int tamanho();
    
    /*
     * Busca um elemento na árvore
     * @param chave o elemento a ser buscado
     * @return o elemento buscado, ou null se ele não estiver na árvore
     */
    public Pagina buscar(Object chave);

    /*
     *Percorre todos os nós em uma subárvore com raiz
    * em uma determinada página
     */
    public void percorrer();

}