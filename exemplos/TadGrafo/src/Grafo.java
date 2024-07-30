import java.util.Vector;
public class Grafo implements IGrafo{
    private int numVertices;
    private int numArestas;
    private Vector<Vertice> vertices;
    private Vector<Vector<Aresta>> arestas;
    private boolean[][] adj;
    public Grafo(int numVertices){
        this.numVertices = numVertices;
        this.numArestas = 0;
        vertices = new Vector<>(numVertices);
        arestas = new Vector<>(numVertices);
        this.adj = new boolean[numVertices][numVertices];
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
    public void substituir(int v, Object x){
        vertices.set(v, x);
    }
    public void substituirAresta(int v, int w, Object x){
        arestas.get(v).set(w, x);
    }
    //public Vector <Vertice> vertices()
    public Vector <Vertice> vertices(){
        return vertices;
    }
    public Vector <Vector <Vector <arestas>>> arestas(){
        return arestas;
    }

    public boolean ehDirecionado(int e){
        return false;   
    }
    public void inserirArestaDirecionada(int v, int w, Object o){
        arestas.get(v).set(w, o);
        adj [v][w] = true;
        numArestas++;
    }

}