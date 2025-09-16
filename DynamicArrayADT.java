public interface DynamicArrayADT<T> {

//Basic Array Behavior  

    /**
     * Updates the value at the given index and returns the previous value
     * @param element element to be inserted
     * @param index  specific index to set element to
     * @return previous value 
     * @throws IndexOutOfBoundsException 
     */
    public T set(T element, int index);
    
    /**
     * Returns the element stored at an index
     * @param index specific index to get element from
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
     * Inserts element at specified index and moves all elements to the right
     * @param element element to be inserted
     * @param index specific index where the element is inserted into 
     * @throws IndexOutOfBoundsException
     */
    public void add(T element, int index);

    /**
     * Removes an element at specified index and moves all elements to the left
     * @param index specific index where the element is removed from
     * @throws IndexOutOfBoundsException
     */
    public void remove(int index);

    // Whole-Array Operations 

    /**
     * Appends a new array at the end of the array
     * @param newArray array to be inserted at the end
     * @return new Dynamic Array 
     */
    public DynamicArrayADT<T> append(DynamicArray<T> newArray);

    /**
     * Inserts all the elements of the parameter array at the specified index
     * @param newArray array to be put at the specified index
     * @param index specific index to put the array at
     * @return new DynamicArray 
     */
    public DynamicArrayADT<T> insert(DynamicArray<T> newArray, int index);

    /**
     * Returns a subarray of the current DynamicArray from the range specified by the parameters
     * @param fromIndex start index
     * @param toIndex end index
     * @return copy of the current DynamicArray in the range specified by the parameters 
     */
    public DynamicArrayADT<T> sublist(int fromIndex, int toIndex);

    /**
     * Removes the elements of the array according to the range specified in the parameters
     * @param fromIndex start index
     * @param toIndex end index
     * @return new DynamicArray, minus the elements specified by the parameters
     */
    public DynamicArrayADT<T> delete(int fromIndex, int toIndex);

    /**
     * Returns a new DynamicArray containing the elements from the range specified by the parameters
     * @param fromIndex start index
     * @param toIndex end index
     * @return new DynamicArray containing the elements from the range specified in the parameters 
     */
    public DynamicArrayADT<T> extract(int fromIndex, int toIndex);
}

