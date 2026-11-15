package footballmanagementsystem;

public class MaxHeap {
    final int maxSize;
    private final Team[] heap;
    private int currentSize;

    public MaxHeap(int maxSize) {
        this.heap = new Team[maxSize];
        this.currentSize = -1;
        this.maxSize = maxSize;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        return 2 * i + 2;
    }

    public void insert(Team data) {
        if (currentSize == maxSize - 1) {
            System.out.println("The heap is full. Cannot insert");
            return;
        }

        currentSize++;
        this.heap[currentSize] = data;
        int currentIndex = currentSize;

        while (currentIndex > 0 && compareTeams(this.heap[this.parent(currentIndex)], this.heap[currentIndex]) < 0) {
            Team temp = heap[currentIndex];
            heap[currentIndex] = heap[parent(currentIndex)];
            heap[parent(currentIndex)] = temp;
            currentIndex = this.parent(currentIndex);
        }
    }
    

    public void maxHeapify(int i) {
        int left = this.leftChild(i);
        int right = this.rightChild(i);
        int largest = i;

        if (left <= currentSize && compareTeams(heap[left], heap[largest]) > 0) {
            largest = left;
        }

        if (right <= currentSize && compareTeams(heap[right], heap[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            Team temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }
    }

    public Team extractMax() {
        if (currentSize < 0) {
            System.out.println("The heap is empty.");
            return null;
        }

        Team maxItem = this.heap[0];
        this.heap[0] = this.heap[currentSize];
        currentSize--;

        maxHeapify(0);
        return maxItem;
    }

    public void printHeap() {
        for (int i = 0; i <= currentSize; i++) {
            System.out.println(heap[i].getTeamName() + " - Points: " + heap[i].getTotalPoints() + ", Goal Difference: " + heap[i].getGoalDifference());
        }
    }

   private int compareTeams(Team t1, Team t2) {
        if (t1.getTotalPoints() != t2.getTotalPoints()) {
            return Integer.compare(t1.getTotalPoints(), t2.getTotalPoints());
        } else {
            return Integer.compare(t1.getGoalDifference(), t2.getGoalDifference());
        }
    }
  
}
