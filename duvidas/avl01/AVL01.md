# Dúvidas AVL01


## Slide 1

- Em que local a árvore AVL foi criada?
- Qual o principal objetivo das árvores AVL em relação às operações de inserção e remoção?
- O que significa dizer que uma árvore AVL é balanceada?
Por que o balanceamento é importante em uma árvore binária de pesquisa?
- Como o balanceamento é mantido em uma árvore AVL durante as operações de inserção e remoção?
- Por que a AVL precisa ser baseada em árvore binária de pesquisa?

## Slide 2

- Por que o balanceamento das subárvores em uma árvore AVL é importante para o desempenho das operações?
- O que acontece se a diferença de altura entre as subárvores de um nó AVL exceder o valor de 1?
- Como é definida a altura de uma subárvore em uma árvore AVL?

## Slide 3

- Por que todas as subárvores de uma árvore AVL também devem ser AVL?
- Como garantir que todas as subárvores de uma árvore AVL permaneçam balanceadas após operações de modificação?


## Slide 4

- O que representa he(v) no cálculo do fator de balanceamento de um nó?
- Qual é o significado de um fator de balanceamento igual a 0 na árvore?
- Qual é o significado de um fator de balanceamento igual 1 na árvore?
- Qual é o significado de um fator de balanceamento igual a -1 na árvore?
- Como o fator de balanceamento influencia o balanceamento geral de uma árvore AVL?
- O que deve ser feito se o fator de balanceamento de um nó estiver fora do intervalo permitido?

## Slide 5
- Por que nós com valores de FB entre -1 e +1 são considerados balanceados em uma árvore AVL?

## Slide 6
- Como o desbalanceamento de um nó afeta a estrutura geral de uma árvore AVL?


## Slide 19

- O que acontece com o fator de balanceamento  de um nó quando ele é igual a 0 e ocorre uma inserção no lado direito?
- Quais são as possíveis mudanças no fator de balanceamento quando se remove um nó em uma árvore AVL?
- Como o fator de balanceamento é afetado em uma remoção, em comparação com uma inserção?

## Slide 20

- Como a inserção no lado esquerdo de um nó com FB=0 afeta o balanceamento da árvore AVL?
- Como o balanceamento é corrigido após uma inserção que resulta em FB=1 em uma árvore AVL?

## Slide 22
- Qual seria a condição no código Java para interromper a atualização do FB dos antecessores após uma inserção, se o FB do antecessor for igual a 0?
- Como o fator de balanceamento de um antecessor deve ser ajustado no código Java após uma inserção na subárvore esquerda ou direita?
- Qual seria a lógica no código Java para parar a atualização do FB após uma remoção, se o FB do antecessor for diferente de 0?
- Como o código Java lidaria com o cenário em que o FB do antecessor precisa ser atualizado, mas não há necessidade de aplicar rotações?

## Slide 23

- Quais tipos de transformações podem ser aplicadas para rebalancear uma árvore AVL?
- Que métodos em Java precisariam ser aplicados para garantir que a árvore seja AVL?


## Slide 24

- Como as rotações alteram o balanceamento de uma árvore T?
- De que maneira as rotações garantem que a sequência de percurso em ordem permaneça inalterada?
- Quais são os diferentes tipos de rotações que podem ser aplicadas em árvores AVL?
- Qual é o impacto das rotações na complexidade temporal das operações de inserção e remoção em árvores AVL?
- Quais condições levam à necessidade de realizar uma rotação em uma árvore AVL?
- Como a operação de rotação pode ser implementada em código Java para uma árvore AVL?


## Slide 25

- Quando uma rotação esquerda simples é utilizada em uma árvore AVL?
- Quando uma rotação direita simples é utilizada em uma árvore AVL?
- Qual é o efeito de uma rotação direita simples na estrutura de uma árvore AVL?
- Em que situações é necessário realizar uma rotação esquerda dupla?
- Como uma rotação direita dupla difere de uma rotação direita simples?
- Como cada tipo de rotação (simples ou dupla) afeta o fator de balanceamento (FB) dos nós
- Quais são os efeitos de uma rotação esquerda simples na estrutura da árvore?
- Quais são as vantagens de usar a rotação esquerda simples em comparação com outros tipos de rotações?


## Slide 28

- Por que é importante guardar a subárvore direita antes de realizar a rotação esquerda simples?
- Quais seriam os possíveis efeitos colaterais se os passos da rotação esquerda simples não forem seguidos corretamente?
- Como o armazenamento da subárvore direita pode afetar a integridade da árvore após a rotação?
- O que acontece se o nó que será o pai já tiver um filho esquerdo?

## Slide 29

- O que significa "colocar a árvore restante na subárvore esquerda da subárvore guardada"?
- Como a modificação da subárvore esquerda afeta o fator de balanceamento dos nós envolvidos?


## Slide 31
- Quais são os  passos principais envolvidos na realização de uma rotação dupla à esquerda?
- Por que é importante entender a simetria entre as rotações esquerda e direita ao trabalhar com árvores AVL?
- Em que situações uma rotação dupla à esquerda é preferida em comparação com rotações simples?
- Como é implentada a rotação dupla à esquerda em código Java?

## Slide 35
- Por que a rotação dupla à direita é simétrica à rotação dupla à esquerda?
- Em que situações a rotação dupla à direita é aplicada em comparação com outras rotações?

## Slide 37

- Existem casos em que um fator de balanceamento de 2 não exigiria uma rotação à direita? Se sim, quais seriam?
- Como é implementar lógica para detectar um FB igual a 2 e realizar uma rotação à direita em código Java?


## Slide 38

- Existem situações em que um fator de balanceamento de -2 não exigiria uma rotação à esquerda? Se sim, quais seriam?
- Árvores AVL
## Slide 39
- Quando fazer Rotações
- Quando uma árvore ou subárvore tem
um fator de balanceamento FB=2 e
sua subárvore esquerda tem um
FB>=0, faz-se uma rotação direita
simples. 
- Como implementaria a lógica para verificar os fatores de balanceamento e decidir entre uma rotação direita simples e uma rotação dupla à direita em código Java?

## Slide 40

- Quais passos devem ser seguidos ao identificar que uma rotação dupla à esquerda é necessária?

## Slide 41
- Como a atualização dos fatores de balanceamento ajuda a garantir que a árvore permaneça balanceada?

## Slide 42

- Por que o valor min(FB_A, 0) é subtraído na fórmula de FB_B_novo?
- Como o novo fator de balanceamento de A (FB_A_novo) é calculado após a rotação à esquerda?
- Por que é importante entender o impacto das rotações nos fatores de balanceamento ao trabalhar com árvores AVL?


## Slide 44
- Quais diferenças notáveis existem entre as fórmulas usadas para atualizar FB após rotações à esquerda e à direita?
- O que acontece se a árvore não for balanceada após a inserção de um novo elemento?

