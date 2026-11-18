package Week10_DivideCompare_Avl_Backtracking.LyThuyet;



public class MaDiTuan {

    static final int M = 5;
    static int count = 0;

    // 8 huong di cua quan Ma
    static int[] I = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] J = {1, 2, 2, 1, -1, -2, -2, -1};

    // Khoi tao ban co
    static void Init(int[][] board) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = 0;
            }
        }
    }

    // Kiem tra toa do
    static boolean check(int i, int j) {
        return i >= 0 && i < M && j >= 0 && j < M;
    }

    // Hien thi ban co
    static void Show(int[][] board) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.printf("%3d", board[i][j]);
            }
            System.out.println();
        }
    }

    // Thuat toan quay lui
    static void Try(int step, int i, int j, int[][] board) {

        int inext, jnext;

        for (int m = 0; m < 8; m++) {

            inext = i + I[m];
            jnext = j + J[m];

            if (check(inext, jnext) && board[inext][jnext] == 0) {

                board[inext][jnext] = step + 1;

                if (step == M * M - 1) {
                    count++;

                    System.out.println("\nLoi giai thu " + count + ":");
                    Show(board);
                } else {
                    Try(step + 1, inext, jnext, board);
                }

                // Quay lui de tim loi giai tiep theo
                board[inext][jnext] = 0;
            }
        }
    }

    public static void main(String[] args) {

        int[][] board = new int[M][M];

        int i = 2, j = 0;

        Init(board);

        board[i][j] = 1;

        Try(1, i, j, board);

        System.out.println("\nTong so loi giai: " + count);
    }
}
