package doublylinkedlist.undoredofunctionality;

public class TextState {
    String text;
    TextState prev;
    TextState next;

    TextState(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}
