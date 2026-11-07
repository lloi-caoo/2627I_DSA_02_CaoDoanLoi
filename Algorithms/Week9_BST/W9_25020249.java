// triển khai cây tổng quat theo danh sach con trưởng hoặc em liền kề , phép toán tìm bố
// id table , firstchild , nextSibling
package Week9_BST;

import java.util.ArrayList;
import java.util.List;

public class W9_25020249 {
    static class GeneralTree {
        // Lớp nội bộ đại diện cho một nút trong mảng
        static class TreeNode {
            char data;
            int firstChild;
            int nextSibling;

            public TreeNode(char data) {
                this.data = data;
                this.firstChild = -1;
                this.nextSibling = -1;
            }
        }

        private List<TreeNode> tree;
        private int root;

        public GeneralTree() {
            this.tree = new ArrayList<>();
            this.root = -1;
        }

        private int createNode(char data) {
            tree.add(new TreeNode(data));
            return tree.size() - 1;
        }

        // Đặt nút gốc
        public void setRoot(char data) {
            if (root == -1) {
                root = createNode(data);
            } else {
                tree.get(root).data = data;
            }
        }

        // Thêm một nút con mang giá trị 'childData' vào nút cha có chỉ số 'parentIndex'
        public int addChild(int parentIndex, char childData) {
            if (parentIndex < 0 || parentIndex >= tree.size()) return -1;

            // index của node trong List
            int childIndex = createNode(childData);

            // Nếu cha chưa có con trưởng, nút mới sẽ trở thành con trưởng
            if (tree.get(parentIndex).firstChild == -1) {
                tree.get(parentIndex).firstChild = childIndex;
            }
            // Nếu đã có con, duyệt tìm người anh em út (nút cuối cùng trong danh sách anh em)
            else {
                int current = tree.get(parentIndex).firstChild;
                while (tree.get(current).nextSibling != -1) {
                    current = tree.get(current).nextSibling;
                }
                // Gắn nút mới vào vị trí anh em liền kề của nút út
                tree.get(current).nextSibling = childIndex;
            }
            return childIndex;
        }


        public void preOrder(int nodeIndex) {
            if (nodeIndex == -1) return;

            System.out.print(tree.get(nodeIndex).data + " ");

            // Duyệt nhánh con trưởng (đi xuống sâu)
            preOrder(tree.get(nodeIndex).firstChild);

            // Duyệt nhánh anh em (đi ngang)
            preOrder(tree.get(nodeIndex).nextSibling);
        }

        public int getRoot() {
            return root;
        }
    }
    public static void main(String[] args) {
        GeneralTree t = new GeneralTree();

        // Khởi tạo cây với gốc là 'A'
        t.setRoot('A');
        int rootIdx = t.getRoot();

        // Thêm các con cho 'A'
        int b = t.addChild(rootIdx, 'B');
        int c = t.addChild(rootIdx, 'C');
        int d = t.addChild(rootIdx, 'D');

        // Thêm con cho 'B'
        t.addChild(b, 'E');
        t.addChild(b, 'F');

        // Thêm con cho 'D'
        int g = t.addChild(d, 'G');
        t.addChild(g, 'H'); // H là con của G

        System.out.print("Duyet tien thu tu (Pre-order): ");
        t.preOrder(rootIdx);
    }
}