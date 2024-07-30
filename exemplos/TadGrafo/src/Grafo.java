import java.util.Vector;
public class Grafo implements IGrafo{
    private int numVertices;
    private int numArestas;
    private Vector<Vertice> vertices;
    private Vector<Vector<Aresta>> arestas;
    private Vector <Vector<Aresta>>[][] adj;
    public Grafo(int numVertices){
        this.numVertices = numVertices;
        this.numArestas = 0;
        vertices = new Vector<>(numVertices);
        arestas = new Vector<>(numVertices);
        this.adj = new Vector[numVertices][numVertices];
        for (int i = 0 ; i < numVertices ; i++){
            vertices.add(null);
            Vector<Vector<Aresta>> linha = new Vector<>(numVertices);
            for(int j = 0 ; j < numVertices ; j++) {
                linha.add(new Vector<Aresta>());
            }
            arestas.add(linha);
        }
    }
    public boolean ehAjacente(int v, int w){
        return adj[v][w];
    }
    public int[] finalVertices(int e) throws NaoIncidente{
        int [] v = new int[2];
        for (int i = 0 ; i < numVertices ; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (arestas.get(i).get(j).equals(e)) {
                    v[0] = i;
                    v[1] = j;
                    return v;
                }
            }
        }
        throw new NaoIncidente("Aresta não incidente");
    }
    public void substituir(Vertice v, Object x){
        vertices.set(v, x);
    }
    public void substituirAresta(Aresta e,  Object x){
        arestas.get(e).set(e, x);
    }
    public Vector <Vertice> vertices(){
        return vertices;
    }
    public Vector <Vector <Vector <arestas>>> arestas(){
        return arestas;
    }

   public int inserirAresta(int v, int w, Object o){
    arestas.get(v).set(w, o);
    arestas.get(w).set(v, o);
    adj[v][w] = true;
    adj[w][v] = true;
    numArestas++;
    return numArestas;
   }

    public int inserirVertice(Object o){
        for(int i = 0 ; i < numVertices ; i++){
            if(vertices.get(i) == null){
                vertices.set(i, o);
                return i;
            }
        }
        numVertices++;
        return numVertices;
    }

    public boolean ehDirecionado(int e){
        if(arestas.get(finalVertices(e)[0]).get(finalVertices(e)[1]).get(0).equals(e)){
            return true;
        }
        return false;
    }
    public int oposto(Vertice v, int e) throws NaoIncidente{
        if(finalVertices(e)[0] == v){
            return finalVertices(e)[1];
        }
        if(finalVertices(e)[1] == v){
            return finalVertices(e)[0];
        }
        throw new NaoIncidente("O vértice não é incidente");
    }
    public void inserirArestaDirecionada(int v, int w, Object o){
        arestas.get(v).set(w, o);
        adj [v][w] = true;
        numArestas++;
    }

}