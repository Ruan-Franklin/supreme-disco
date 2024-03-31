class No:
    def __init__(self, folha=False):
        self.chaves = []
        self.filhos = []
        self.folha = folha
class ArvoreBinaria():
    def __init__(self, t):
        self.raiz = No(True)
        self.t = t
    
    def pesquisa(self, chave, no = None):
        no = self.raiz if no == None else no
        i = 0
        while i < len(no.chaves) and chave > no.chaves[i]:
            i += 1
        if i < len(no.chaves) and chave == no.chaves[i]:
            return (no, i)
        elif no.folha:
            return None
        else:
            return self.pesquisa(chave, no.filhos[i])