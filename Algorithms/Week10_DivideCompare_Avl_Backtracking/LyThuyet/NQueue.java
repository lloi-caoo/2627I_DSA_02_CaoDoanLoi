package Week10_DivideCompare_Avl_Backtracking.LyThuyet;

public class NQueue {
    static int n;                         // kích cỡ bàn cờ
    static int[] X = new int[100];        // kich thuoc mảng
    static int count = 0;                 // đếm số cách xếp
    static int[] cot = new int[100];
    static int[] xuoi = new int[100];      // vị trí đường chéo xuôi tại hàng i cột j :i - j + n
    static int[] nguoc = new int[100];     // vị trí đường chéo xuôi tại hàng i cột j : i + j -1

    // X[i] = j : đặt con hậu ở hàng i vào cột j

    // xét hàng i
    static void Try(int r){
        // xét từng vị trí đặt các cột trong 1 hàng
        for(int c = 1; c <= n;c++){
            if(cot[c] == 0 && xuoi[r - c + n] == 0 && nguoc[r+c-1] == 0){
                X[r] = c;
                cot[c] = xuoi[r-c+n] = nguoc[r+c-1] =1;

                if(r == n){
                    count ++;

                    // in ra màn hình chi tiết cách xếp thứ count
                    System.out.println("Cách" + count +":");
                    for(int row = 1; row <= n; row ++){
                        System.out.println("(" + row +", "+X[row] +") ");
                    }

                }else{
                    Try(r+1);
                }

                // backtrack
                cot[c] = xuoi[r-c+n]= nguoc[r+c-1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        // gia su cho bai toan 8 con hau
        n = 8;
        Try(1);
        System.out.println("Có tổng cộng số     cach xep n quan hậu là "+ count);
    }

}
