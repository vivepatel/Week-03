package doublylinkedlist.undoredofunctionality;



public class TextEditor {
    TextState currentState;
    TextState head;
    int historySize;
    int currentSize;

    TextEditor(int historySize) {
        this.historySize = historySize;
        this.currentSize = 0;
        this.currentState = new TextState(""); // Initial state
        this.head = currentState;
    }

    void addText(String text) {
        TextState newState = new TextState(text);
        currentState.next = newState;
        newState.prev = currentState;
        currentState = newState;

        currentSize++;
        if (currentSize > historySize) {
            removeOldestState();
        }
    }

    void removeOldestState() {
        if (head == currentState) return; // only one state, can't remove.

        TextState temp = head;
        head = head.next;
        head.prev = null;
        currentSize--;
    }

    void undo() {
        if (currentState.prev != null) {
            currentState = currentState.prev;
        }
    }

    void redo() {
        if (currentState.next != null) {
            currentState = currentState.next;
        }
    }

    void displayCurrentText() {
        System.out.println("Current Text: " + currentState.text);
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10); // History size of 10

        editor.addText("Hello");
        editor.addText(" World");
        editor.addText("!");
        editor.displayCurrentText(); // Output: Hello World!

        editor.undo();
        editor.displayCurrentText(); // Output: Hello World

        editor.undo();
        editor.displayCurrentText(); // Output: Hello

        editor.redo();
        editor.displayCurrentText(); // Output: Hello World

        editor.addText(" How are you?");
        editor.displayCurrentText(); // Output: Hello World How are you?

        // Simulate exceeding history size
        for (int i = 0; i < 15; i++) {
            editor.addText(" " + i);
        }
        editor.displayCurrentText(); // Should only show the last 10 entries.

        editor.undo();
        editor.displayCurrentText();// One step back.
    }
}