// Quick-Union: Java implementation

public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];                    // set id of each object to itself
        for (int i = 0; i < N; i++) id = i; // (N array accesses)
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];       // chase parent pointers until reach root
        return i;                           // (depth of i array accesses)
    }

    public boolean connected(int p, int q) {    // check if p and q have same root
        return root(p) == root(q);              // (depth of p and q array accesses)    
    }

    public void union(int p, int q) {       // change root of p to point to root of q
        int i = root(p);                    // (depth of p and q array accesses)
        int j = root(q);
        id[i] = j;
    }
}