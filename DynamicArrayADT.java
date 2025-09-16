public interface DynamicArrayADT<T> {

//Basic Array Behavior  

    /**
     * Updates the value at the given index and returns the previous value
     * @param element 
     * @param index 
     * @return previous value 
     * @throws IndexOutOfBoundsException 
     */
    public T set(T element, int index);
    
    /**
     * Returns the element stored at an index
     * @param index 
     * @return element of type T at given index 
     * @throws IndexOutOfBoundsException
     */
    public T get(int index);

    /**
     * Returns the number of elements stored in the DynamicArray 
     * @return size of the array 
     */
    public int size(); 

    //Adding and Removing Elements

    /**
     * 
     * @param element
     * @param index
     * @throws IndexOutOfBoundsException
     */
    public void add(T element, int index);

    /**
     * 
     * @param index
     * @throws IndexOutOfBoundsException
     */
    public void remove(int index);

    // Whole-Array Operations 

    /**
     * 
     * @param newArray
     * @return new Dynamic Array 
     */
    public DynamicArrayADT<T> append(DynamicArray<T> newArray);

    /**
     * 
     * @param newArray
     * @return new DynamicArray
     */
    public DynamicArrayADT<T> insert(DynamicArray<T> newArray, int index);

    /**
     * 
     * @param fromIndex
     * @param toIndex
     * @return copy of the current DynamicArray in the range specified by the parameters 
     */
    public DynamicArrayADT<T> sublist(int fromIndex, int toIndex);

    /**
     * 
     * @param fromIndex
     * @param toIndex
     * @return new DynamicArray, minus the elements specified by the parameters
     */
    public DynamicArrayADT<T> delete(int fromIndex, int toIndex);

    /**
     * 
     * @param fromIndex
     * @param toIndex
     * @return new DynamicArray containing the elements from the range specified in the parameters 
     */
    public DynamicArrayADT<T> extract(int fromIndex, int toIndex);
}

