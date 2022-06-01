public class ShortestPath {


    //method jarak minimal
    public int minDistance(int dist[], Boolean b[]) {

        // inisialisai variabel min = infinity (tak terhingga)
        int min = Integer.MAX_VALUE, index = -1;

        //perulangan cek perbandingan nilai
        for (int x = 0; x < 5; x++){
            if (b[x] == false && dist[x] <= min) {
                min = dist[x]; // maka nilai min = nilai jarak index ke x
                index = x; // index diubah menjadi nilai x
            }
        }
        return index;
    }

    //method cetak graph (cetak lintasan terpendeknya)
    public void cetakGraph(int dist[], int x) {  // x = banyak node
        System.out.println("lintasan terpendek : ");

        for (int i = 0; i < 5; i++){
            System.out.println(i + " = " + dist[i]);
        }
    }


    //method dijkstra Algoritma
    public void dijkstra(int graph[][], int src) {
        
        int dist[] = new int[5]; // menampung jarak yang telah dikunjungi ( 5 buah node = a,b,c,d,e)

        Boolean b[] = new Boolean[5]; // menampung node sudah dikunjungi atau belum

        //inisialisasi node infinity
        for (int i = 0; i < 5; i++){
            dist[i] = Integer.MAX_VALUE;
            b[i] = false; //angka yang sudah dikunjungi = false
        }

        dist[0] = 0; //inisialisasi jarak awal = 0
        //menemukan shortest path
        for (int count = 0; count < 5; count++) {

            //panggil method minDistance dan masukan ke variabel baru
            int u = minDistance(dist, b);
            b[u] = true; 


            //melakukan penjumlahan nilai lintasan yang dilalui
            for (int x = 0; x < 5; x++) {
                if (!b[x] && graph[u][x] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][x] < dist[x]) {
                    dist[x] = dist[u] + graph[u][x];
                }
            }
            //panggil method untuk mencetak hasil pencarian lintasan terpendek 
            cetakGraph(dist, 5);

        }
        

    }


    public static void main(String[] args) throws Exception {
        //buat graph
        int graph [][] = new int[][] 
        {{0,7,0,0,10},{7,0,4,5,0},{0,4,0,9,0},{0,5,9,0,0},{10,0,0,0,0}};

        ShortestPath hasil = new ShortestPath();
        //panggil method dijkstra (menampilkan hasil algoritma dijkstra)
        hasil.dijkstra(graph,0); //0 = source(sumber node)




    }
}
