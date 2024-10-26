
public class HW3_3 {

    private int[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 8;

    public HW3_3() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void enqueue(int v) {
        if (size >= elements.length) {
            int[] newElements = new int[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = v;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("隊列已空");
        }
        int removedElement = elements[0];
        for (int i = 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return removedElement;
    }

    public boolean empty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        HW3_3 queue = new HW3_3();

        for (int i = 1; i <= 20; i++) {
            queue.enqueue(i);
        }

        while (!queue.empty()) {
            System.out.println("移除的元素: " + queue.dequeue());
        }
    }
}
