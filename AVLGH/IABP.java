public interface IABP {

    /*
     * Permite a busca de um elemento na árvore
     * @param chave chave da busca
     * @param noAtual nó atual da busca
     * @return Nó encontrado
     */
    public No busca(Object chave, No noAtual);

    /*
     * Verifica se o elemento é uma folha
     * @param no nó a ser verificado
     * @return true se o nó for uma folha, false caso contrário
     */
    public boolean externo(No no);

    /*
     * Verifica se um elemento tem filho  esquerdo
     * @param no nó a ser verificado
     * @return true se o nó tiver filho esquerdo, false caso contrário
     */
    public boolean temEsquerdo(No no);
    /*
     * Verifica se um elemento tem filho direito
     * @param no nó a ser verificado
     * @return true se o nó tiver filho direito, false caso contrário
     */
    public boolean temDireito(No no);
    /*
     * Retorna o filho esquerdo
     * @param no nó a ser verificado
     * @return filho esquerdo
     */
    public No filhoEsquerdo(No no);
    /*
     * Retorna o filho direito
     * @param no nó a ser verificado
     * @return filho direito
     */
    public No filhoDireito(No no);

    /*
     * Retorna se a árvore está vazia
     * @return true se a árvore estiver vazia, false caso contrário
     */
    public boolean estaVazia();

    /*
     * Retorna a raiz da árvore
     * @return raiz da árvore
     */
    public No raiz();
    /*
     * Altera a raiz da árvore
     * @param no nó a ser definido como raiz

     */
    public void setRaiz(No no);
    /*
     * Verifica se o elemento é a raiz
     * @param no nó a ser verificado
     * @return true se o nó for a raiz, false caso contrário
     */
    public boolean estirpe(No no);
    /*
     * Verifica o pai de um nó
     * @param no nó a ser verificado
     * @return pai do nó
     */
    public No pai(No no);
    /*
     *Retorna o tamanho da árvore
     * @return tamanho da árvore
     */
    public int tamanho();
    /*
     *Retorna a profundidade de um nó
     * @param no nó a ser verificado
     * @return profundidade do nó
     */
    public int profundidade(No no);
    /*
     *Substitui o elemento de um nó
     * @param no nó a ser alterado
     * @param elemento elemento a ser inserido no nó
     * @return elemento substituído
     */
    public Object substitui(No no, Object elemento);
    /*
     * Retorna a altura de um nó
     * @param no nó a ser verificado
     * @return altura do nó
     */
    public int altura(No no);
    /* Retorna se um nó é interno
     * @param no nó a ser verificado
     * @return true se o nó for interno, false caso contrário
     */
    public boolean interno(No no);
    /* Insere um elemento na árvore
     * @param elemento elemento a ser inserido
     */
    public void inserir(Object elemento);
    /*
     * Remove um elemento da árvore
     * @param elemento elemento a ser removido
     */

    public void remover(Object chave);

    /*
     *Realiza a travessia em pré-ordem
     * @param no nó a ser verificado
     */
    public void preOrdem(No no);

    /*
     *Realiza a travessia em ordem
     * @param no nó a ser verificado
     */

    public void emOrdem(No no);

    /*
     *Realiza a travessia em pós-ordem
     * @param no nó a ser verificado
     */
    public void posOrdem(No no);

    /*
     * Mostra a árvore
     */
    public void imprimirArvore();
}