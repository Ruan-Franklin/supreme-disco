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
GrafoA = Grafo(4)
GrafoA.adicionaAresta(1, 2, 5)
GrafoA.adicionaAresta(4,1, 7)
GrafoA.mostrarMatriz()
