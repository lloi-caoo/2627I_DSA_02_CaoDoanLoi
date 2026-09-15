package Week1_unionfind;

// Bản hoàn chỉnh cho giải quyết lk động
// kết hợp Weighted Quick-Union và Path Compression

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class UnionFind {
    private int[] id;  // Lưu ID của nút cha
    private int[] size; // Lưu kích thước của cây

    // Khởi tạo
    public void WeightedQuickUnionPathCompressionUF(int N){
        id = new int[N];
        size = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;        // ban đầu mỗi nút tự là cha của chính nó
            size[i] = 1;      // ban đầu mỗi cây có size là 1
        }
    }

    // Tìm gốc kết hợp (Path Halving)
    public int find(int i){
        while(i != id[i]){
            id[i] = id[id[i]];   // nhảy 2 bâc
            i = id[i];    // đưa i lên bậc vừa nhảy
        }
        return i;
    }

    // Kiểm tra liên thông
    public boolean connected(int p, int q){
        return find(p) == find(q);  // so sánh 2 gốc
    }

    // Union, Weighting
    public void union(int p, int q){
        int i = find(p);
        int j = find(q);

        // nếu chung gốc rồi
        if(i == j) return;

        // luôn nối size root nhỏ vào size root to
        if(size[i] < size[j]){
            id[i] = j;         // cây i làm con
            size[j] += size[i]; // cập nhật lại kích thước j
        }else{
            id[j] = i;
            size[i] += size[j];
        }
    }
}
