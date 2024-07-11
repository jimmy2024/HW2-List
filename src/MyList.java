import java.util.Collection;
import java.util.Objects;

public class MyList<T extends Comparable<T>> {
    private final int INITIAL_CAPACITY = 2;
    private T[] internalArray;
    private int count;

    public MyList() {
        internalArray = (T[]) new Comparable[INITIAL_CAPACITY];
        count = 0;
    }

    public void add(T elem) {
        Objects.requireNonNull(elem);
        if (count >= internalArray.length) {
            extendInternalArray();
        }
        internalArray[count] = elem;
        count++;
    }

    public T get(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException(String.format("there is no element in list size %d", count));
        }
        return internalArray[index];
    }

    // Сортировка по возрастанию
    // Про флаг не очень понятно, можно просто не вызывать метод, если сортировка не нужна
    public void sort() {
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (internalArray[i].compareTo(internalArray[j]) > 0) {
                    T temp = internalArray[i];
                    internalArray[i] = internalArray[j];
                    internalArray[j] = temp;
                }
            }
        }
    }

    public boolean remove(T elem) {
        int index = indexOf(elem);
        return removeAt(index);
    }

    public int indexOf(T elem) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (internalArray[i].equals(elem)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean removeAt(int index) {
        if (index >= count || index < 0) {
            return false;
        }
        System.arraycopy(internalArray, index + 1, internalArray, index, internalArray.length - index - 1);
        count--;
        return true;
    }

    public void addAll(Collection<T> collection) {
        for (var item : collection) {
            add(item);
        }
    }

    private void extendInternalArray() {
        T[] newArray = (T[]) new Comparable[count * 2];
        System.arraycopy(internalArray, 0, newArray, 0, internalArray.length);
        internalArray = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < count; i++) {
            sb.append(internalArray[i]);
            if (i != count - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}