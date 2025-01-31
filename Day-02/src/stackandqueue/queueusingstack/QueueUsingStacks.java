package stackandqueue.queueusingstack;

import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public QueueUsingStacks() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int value) {
        enqueueStack.push(value);
    }

    // Dequeue operation
    public int dequeue() {
        if (dequeueStack.isEmpty()) {
            if (enqueueStack.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            // Transfer elements from enqueueStack to dequeueStack
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }

    // Peek operation (Get the front element)
    public int peek() {
        if (dequeueStack.isEmpty()) {
            if (enqueueStack.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            // Transfer elements from enqueueStack to dequeueStack
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }
}


