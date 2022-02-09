


public class StackOfIntegers {
    private int[] elements;
    private int size;

    // This ideally, should be used as default value in constructor. 
    // Assignment requires 16, so we don't use that in this submission.
    // Can be set when stack is constructed so it resizes to given value dynamically.
    private int resizeValue = 4;


    public StackOfIntegers() {
        this.size = 0;
        this.elements = new int[16];
    }
    
    public StackOfIntegers(int capacity) {
        this.size = 0;
        this.elements = new int[capacity];
    }
    

    // // For myself. This constructor uses resizeValue so the stack can be set to resize at multiples of resizeValue.
    // // Imo, defaulting to 4 or smth is best. Not good to let user set this.
    // // Check APIs and documentation for best practices. I think I'm right in thinking 4 is best (multiple of 4 for data type size, byte size, bla...), but I need to research.
    // public StackOfIntegers(int capacity, int resizeValue) {
    //     this.size = 0;
    //     this.elements = new int[capacity];
    //     this.resizeValue = resizeValue;
    // }


    public boolean empty() {
        return (this.getSize() == 0);
    }

    public int peek() {
        return this.elements[this.getSize() - 1];
    }

    // Pushes a value to the stack.
    // Resizes the array whenever pre push size is a multiple of resizeValue (default of 4). 
    // Resize array to be size + resizeValue to allocate more space for the internal array.
    public void push(int value) {
        // If pre push the size is a multiple of resizeValue, resize to be size + resizeValue.
        if((this.getSize() % resizeValue) == 0) {
            // Increment elements[] size by resizeValue
            int[] temp = new int[this.getSize() + resizeValue];
            
            // Rebuild the elements in the new array
            for (int i = 0; i < this.getSize(); i++) {
                temp[i] = this.elements[i];
            }
            temp[this.getSize()] = value;
            
            // Assign new array.
            this.elements = temp;
        }
        // If pre push the size is not a multiple of resizeValue, simply push to stack.
        else {
            // Add new value to top of stack.
            this.elements[this.getSize()] = value;
        }

        // Update size.
        this.size++;
    }

    // Pops the last in value from the stack. LIFO
    // Resizes the internal array whenever post pop size would become a multiple of resizeValue (default of 4)
    public int pop() {
        if(empty()) throw new ArrayIndexOutOfBoundsException("Array is empty!");

        // Cache element in list to be popped
        int popData = this.elements[this.getSize() - 1];
        // Clear space with ? (zero is not a good value, some MAX_VALUE thing might be ok but gross)
        this.elements[this.getSize() - 1] = 0;
        
        // If post pop the size is a multiple of resizeValue, resize to be size - 1.
        if(((this.getSize() - 1) % resizeValue) == 0) {
            // Increment elements[] size by resizeValue.
            int[] temp = new int[this.getSize() - 1];
            
            // Rebuild the elements in the new array
            for (int i = 0; i < this.getSize() - 1; i++) {
                temp[i] = this.elements[i];
            }
            
            // Assign new array.
            this.elements = temp;
        }

        // Reduce size
        this.size--;

        return popData;
    }
    
    // Return the size of the stack.
    public int getSize() {
        return size;
    }


    
    public static void main(String[] args) {
        
        StackOfIntegers stack = new StackOfIntegers();
        
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        
        while(!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}
