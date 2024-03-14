import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] Example1 = {{0, 1}, {1, 2}, {1, 3}, {1, 4}, {4, 5}, {3, 5}, {5, 6}};
        int[] sol1 = findCutEdge(Example1);
        System.out.println("The first solution is");
        System.out.println(Arrays.toString(sol1));

        int[][] Example2 = {{0, 1}, {1, 2}, {1, 3}, {2, 3}, {4, 5}, {3, 5}, {5, 6}};
        int[] sol2 = findCutEdge(Example2);
        System.out.println("The second solution is");
        System.out.println(Arrays.toString(sol2));

        int[][] Example3 = {{0, 1}, {1, 2}, {1, 3}, {2, 6}, {4, 5}, {3, 5}, {5, 6}};
        int[] sol3 = findCutEdge(Example3);
        System.out.println("The third solution is");
        System.out.println(Arrays.toString(sol3));
    }


    /**
     * @param edges: the edges of graph in 2D array form
     * @return: an array representation of the cut edge
     *          if no cut edge found, return {-1, -1}
     */
    public static int[] findCutEdge(int[][] edges) {

        //number of vertices in the tree
        int n = edges.length + 1;
        DisjointSets disjointSets = new DisjointSets(n);

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = disjointSets.Find(u);
            int rootV = disjointSets.Find(v);

            //checks if both vertices have same root
            //this effectively finds which additional edge will form a cycle
            if(rootU == rootV) {
                return edge;
            }

            disjointSets.Union(rootU, rootV);
        }

        //no edge found 
        return new int[]{-1, -1};
    }
        

    private static class DisjointSets {

        public int n;
        private int[] setArr;

        /***
         * Constructor (required to create disjoint sets)
         * @param numElts initially sets are singletons: {0}, {1}, . . . {numElts-1}
         */
        public DisjointSets(int numElts){
            n = numElts;
            int[] tempArr = new int[n];
            for(int i=0; i<n; i++){
                tempArr[i] = -1;
            }
            setArr = tempArr;
        }


        /***
         * Finds which set int k is in
         * @param k int whose set we want to find
         * @return representative element (root of uptree)
         */
        public int Find(int k)
        {
            // if `k` is not the root
            if (setArr[k] >= 0)
            {
                // path compression
                setArr[k] =  Find(setArr[k]);
                return setArr[k];
            }
            else{
                return k;
            }
        }

        /***
         * remember rank is an upper bound on tree height
         * (or more precisely, rank <= -treeHeight -1)
         * @param k set element (int)
         * @return rank of set containing k
         */
        private int getRank(int k){
            return setArr[Find(k)];
        }


        /***
         * Take union of two sets.  Union by rank
         * @param a int in one set
         * @param b int in the other set
         */
        public void Union(int a, int b)
        {
            // find the root of the sets in which elements `x` and `y` belongs
            int x = Find(a);
            int y = Find(b);

            // if `x` and `y` are present in the same set
            if (x == y) {
                return;
            }

            // Always attach a smaller depth tree under the root of the deeper tree.
            if (getRank(x) > getRank(y)) { // remember ranks are negative
                setArr[x] = y;
            }
            else if (getRank(x) < getRank(y)) {
                setArr[y] = x;
            }
            else {
                setArr[x] = y;
                setArr[Find(y)] = setArr[Find(y)] -1;
            }
        }
    }
}