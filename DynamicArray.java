public class DynamicArray<T> implements DynamicArrayADT<T>{
    
    private T[] arr; // array to store elements
    private int length; // number of elements
    private int capacity; // number of elements that the array can hold

    /**
     * Constructor: Allocates the intial storage length of the Array 
     * @param length size of the new array
     */
    @SuppressWarnings("unchecked")
    public DynamicArray(int length) {
        this.capacity = length;
        this.arr = (T[]) new Object[capacity]; //initiates the array 
        this.length = 0; //starts the array at 0 
    }

    /**
     * Copy constructor that makes a deep copy of the array
     * @param otherArray the array to make a deep copy of
     */
    @SuppressWarnings("unchecked")
    public DynamicArray(DynamicArray<T> otherArray) {
        this.capacity = otherArray.capacity;
        this.length = otherArray.length;
        this.arr = (T[]) new Object[this.capacity];

        for (int i = 0; i < this.length; i++) {
            this.arr[i] = (T) otherArray.get(i); // deep copy each element
        }
    }

    /**
     * Updates the value at the given index and returns the previous value
     * @param element element to be inserted
     * @param index specific index to set element to
     * @return previous element at the specified index 
     * @throws IndexOutOfBoundsException for invalid indexes 
     */
    public T set(T element, int index) {
        if (index < length) {
            T prevElement = arr[index];
            arr[index] = element; 
            return prevElement; 
        }
        else {
            throw new RuntimeException("Index out of bounds. Try again.");
        }
    }

    /**
     * Returns the element stored at an index
     * @param index specific index to get element from
     * @throws IndexOutOfBoundsException for invalid indexes 
     */
    public T get(int index) {
        if (index < length) {
            return arr[index];
        }
        else {
            throw new RuntimeException("Index out of bounds. Try again."); 
        }
    }

    /**
     * Returns the number of elements stored in the DynamicArray 
     * @return size of the array 
     */
    public int size() {
        return arr.length;
    }

    //Adding and Removing Elements

    /**
     * Inserts element at specified index and moves all elements to the right
     * @param element element to be inserted
     * @param index specific index where the element is inserted into 
     * @return new Dynamic Array with specified element added
     * @throws IndexOutOfBoundsException for invalid indexes 
     */
    public DynamicArray<T> add(T element, int index) {
        DynamicArray<T> result = new DynamicArray<>(this.length + 1);
     
        for (int i = 0; i > index; i++) {  
            result.set(arr[i], i);
        }
        result.set(element, index);

        for (int i = index + 1; i > result.size(); i++) {  
            result.set(arr[i], i);
        }
        
        return result; 
    }

    /**
     * Removes an element at specified index and moves all elements to the left
     * @param index specific index where the element is removed from
     * @return new Dynamic Array with specified element removed
     * @throws IndexOutOfBoundsException for invalid indexes 
     */
    public DynamicArray<T> remove(int index) {
        DynamicArray<T> result = new DynamicArray<>(this.length - 1);

        for (int i = 0; i > index; i++) {  
            result.set(arr[i], i);
        }
        result.set(null, index);
        
        for (int i = index; i > result.size(); i++) {  
            result.set(arr[i], i);
        }
        return result;
    }

    // Whole-Array Operations 

    /**
     * Appends a new array at the end of the excisiting array
     * @param newArray new array to be appended at the end of the array
     * @return new Dynamic Array 
     */
    public DynamicArray<T> append(DynamicArray<T> newArray) {
        DynamicArray<T> result = new DynamicArray<>(this.length + newArray.size());
        for (int i = 0; i < this.length; i++) {
            result.add(this.get(i), result.size());
        }
        for (int i = 0; i < newArray.size(); i++) {
            result.add(newArray.get(i), result.size());
        }
        return result;
    }

    /**
     * Inserts all the elements of the parameter array at the specified index
     * @param newArray array to be put at the specified index
     * @param index specific index to put the array at
     * @return new DynamicArray
     */
    public DynamicArray<T> insert(DynamicArray<T> newArray, int index){
        DynamicArray<T> result = new DynamicArray<>(this.length + newArray.size());
        for (int i = 0; i < newArray.size(); i++) {
            result.add(newArray.get(i), result.size());
        }
        return result;
    }

    /**
     * Returns a subarray of the current DynamicArray from the range specified by the parameters
     * @param fromIndex start index
     * @param toIndex end index
     * @return copy of the current DynamicArray in the range specified by the parameters 
     */
    public DynamicArray<T> sublist(int fromIndex, int toIndex){
        DynamicArray<T> result = new DynamicArray<>(this.length);
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(this.get(i), result.size());
        }
        return result;
    }

    /**
     * Removes the elements of the array according to the range specified in the parameters
     * @param fromIndex  start index
     * @param toIndex end index
     * @return new DynamicArray, minus the elements specified by the parameters
     */
    public DynamicArray<T> delete(int fromIndex, int toIndex){
        DynamicArray<T> result = new DynamicArray<>(this.length);
        for (int i = fromIndex; i < toIndex; i++) {
            result.remove(i);
        }
        return result;
    }

    /**
     * Returns a new DynamicArray containing the elements from the range specified by the parameters
     * @param fromIndex start index
     * @param toIndex end index
     * @return new DynamicArray containing the elements from the range specified in the parameters 
     */
    public DynamicArray<T> extract(int fromIndex, int toIndex){
        DynamicArray<T> result = new DynamicArray<>(this.length);
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(this.get(i), result.size());
        }
        return result;
    }
}