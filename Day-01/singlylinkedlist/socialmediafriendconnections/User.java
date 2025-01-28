package singlylinkedlist.socialmediafriendconnections;

import java.util.ArrayList;
import java.util.List;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; // List to store friend IDs
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>(); // Initialize the friend list
        this.next = null;
    }
}

