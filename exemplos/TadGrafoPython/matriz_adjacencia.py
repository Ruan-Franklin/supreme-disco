class Grafo:
    def __init__(self, vertices):
        self.vertices = vertices
        self.grafo = [[0] * self.vertices for i in range(self.vertices)]
    def adicionaAresta(self, verticeA, verticeB, valor):
      self.grafo[verticeA-1][verticeB-1] = valor

    def mostrarMatriz(self):
        print("Número de vértices" f' {self.vertices}')
        for i in range(self.vertices):
            print(self.grafo[i])
quantidade_vertices = int(input("Digite a quantidade de vértices do grafo: "))
GrafoA = Grafo(quantidade_vertices)
for i in range(quantidade_vertices):
    verticeA = int(input("Digite o vértice de origem: "))
    verticeB = int(input("Digite o vértice de destino: "))
    valor = int(input("Digite o valor da aresta: "))
    GrafoA.adicionaAresta(verticeA, verticeB, valor)
GrafoA.mostrarMatriz()
