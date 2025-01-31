package stackandqueue.sortthestack;

import java.util.Stack;
//imported the stack package


public class SortedStack {

    public static void main(String[] args) {
        //created the stack
        Stack<Integer> newstack = new Stack<>();
        // add the elements in the stack using the push keyword
        newstack.push(5);
        newstack.push(20);
        newstack.push(-9);
        newstack.push(87);
        newstack.push(34);
        newstack.push(35);
        //calling the sortstack method
        SortedStack.sortstack(newstack);
        //printing the sorted stack
        while(!newstack.isEmpty())
        {
            System.out.println(newstack.peek());
            newstack.pop();
        }


    }
    // created the method to insert the sorted elements in stack
    static void sortInsert(Stack<Integer>newstack , int x)
    {
        if(newstack.isEmpty()|| x>newstack.peek())
        {
            newstack.push(x);
            return;
        }
        int temp = newstack.pop();
        sortInsert(newstack,x);
        newstack.push(temp);
    }

   // created the sort stack to pass the value to the above method
    public static void sortstack(Stack<Integer> newstack)
    {
        if(!newstack.isEmpty())
        {
            int X=newstack.pop();
            sortstack(newstack);
            sortInsert(newstack,X);


        }
    }
}
