// nếu là MinPriorityQueue thì chỉ cần đổi dấu cac ss ngược lại

package Week7_priorityQueue_binatyHeap.LyThuyet;

import java.util.ArrayList;

public class MaxPriorityQueue {

    // Khoi phuc tinh chat Max-Heap bang cach đẩy XUONG (Down-heapify)
    // Sink
    void heapifyDown(ArrayList<Integer> hT, int i) {
        int size = hT.size();
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < size && hT.get(l) > hT.get(largest)) {
            largest = l;
        }

        if (r < size && hT.get(r) > hT.get(largest)) {
            largest = r;
        }

        if (largest != i) {
            swap(hT, i, largest);
            heapifyDown(hT, largest);
        }
    }

    // Khoi phuc tinh chat Max-Heap bang cach đẩy LEN (Up-heapify)
    // Swim
    void heapifyUp(ArrayList<Integer> hT, int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (hT.get(i) <= hT.get(parent)) {
                break;
            }
            swap(hT, i, parent);
            i = parent;
        }
    }

    // Ham phu tro hoan doi 2 vi tri
    private void swap(ArrayList<Integer> hT, int i, int j) {
        int temp = hT.get(i);
        hT.set(i, hT.get(j));
        hT.set(j, temp);
    }

    // Chen phan tu vao Max-Heap - O(log n)
    void insert(ArrayList<Integer> hT, int newNum) {
        hT.add(newNum);
        heapifyUp(hT, hT.size() - 1);
    }

    // Xoa phan tu co gia tri num - O(log n) nếu đã biết chỉ số (hoặc O(n) do phải tìm vị trí)
    void deleteNode(ArrayList<Integer> hT, int num) {
        int size = hT.size();
        int i;

        for (i = 0; i < size; i++) {
            if (hT.get(i) == num) {
                break;
            }
        }

        // khi num ko co trong list
        if (i == size) {
            System.out.println("Khong tim thay phan tu " + num);
            return;
        }

        int last = size - 1;
        // đổi chổ với ptu cuối rồi xóa nó
        hT.set(i, hT.get(last));
        hT.remove(last);

        // khắc phục đc cà trg hơp xóa ptu cuoi
        if (i < hT.size()) {
            int parent = (i - 1) / 2;
            if (i > 0 && hT.get(i) > hT.get(parent)) {
                heapifyUp(hT, i);
            } else {
                heapifyDown(hT, i);
            }
        }
    }

    // Lay phan tu lon nhat ma khong xoa
    Integer peek(ArrayList<Integer> hT) {
        return hT.isEmpty() ? null : hT.get(0);
    }

    // In cac phan tu trong Heap
    void printArray(ArrayList<Integer> hT) {
        for (int x : hT) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        MaxPriorityQueue h = new MaxPriorityQueue();

        h.insert(array, 3);
        h.insert(array, 4);
        h.insert(array, 9);
        h.insert(array, 5);
        h.insert(array, 2);

        System.out.println("Max-Heap array:");
        h.printArray(array);

        System.out.println("Phan tu lon nhat: " + h.peek(array));

        h.deleteNode(array, 4);

        System.out.println("After deleting 4:");
        h.printArray(array);
    }
}