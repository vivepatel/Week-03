package singlylinkedlist.socialmediafriendconnections;

import java.util.ArrayList;
import java.util.List;

public class SocialMediaConnections {
    User head;

    SocialMediaConnections() {
        head = null;
    }

    void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    void addFriendConnection(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 != null && user2 != null) {
            user1.friendIds.add(userId2);
            user2.friendIds.add(userId1); // Assuming connection is bidirectional
        }
    }

    void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(userId2)); // Use Integer.valueOf to remove by value
            user2.friendIds.remove(Integer.valueOf(userId1));
        }
    }

    List<Integer> findMutualFriends(int userId1, int userId2) {
        List<Integer> mutualFriends = new ArrayList<>();
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 != null && user2 != null) {
            for (int friendId1 : user1.friendIds) {
                for (int friendId2 : user2.friendIds) {
                    if (friendId1 == friendId2) {
                        mutualFriends.add(friendId1);
                    }
                }
            }
        }
        return mutualFriends;
    }


    void displayFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.print("Friends of " + user.name + " (ID: " + user.userId + "): ");
            if (user.friendIds.isEmpty()) {
                System.out.println("No friends.");
            } else {
                for (int friendId : user.friendIds) {
                    User friend = findUser(friendId);
                    if (friend != null) {
                        System.out.print(friend.name + " ");
                    } else {
                        System.out.print(friendId + " "); // Print ID if user not found.
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("User not found.");
        }
    }

    User findUser(int userId) {
        User current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    User findUserByName(String name) {
        User current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    int countFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            return user.friendIds.size();
        }
        return 0;
    }

    void displayAllUsers() {
        User current = head;
        while (current != null) {
            System.out.println("User ID: " + current.userId + ", Name: " + current.name + ", Age: " + current.age);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaConnections sm = new SocialMediaConnections();

        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 22);
        sm.addUser(4, "David", 28);

        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);
        sm.addFriendConnection(2, 4);

        System.out.println("All users:");
        sm.displayAllUsers();
        System.out.println();

        sm.displayFriends(1);
        sm.displayFriends(2);
        System.out.println();

        System.out.println("Mutual friends of Alice and Bob: " + sm.findMutualFriends(1, 2));
        System.out.println();


        System.out.println("Number of friends of Alice: " + sm.countFriends(1));
        System.out.println("Number of friends of Bob: " + sm.countFriends(2));
        System.out.println();

        sm.removeFriendConnection(1, 2);
        sm.displayFriends(1);
        System.out.println();

        User foundUser = sm.findUserByName("Bob");
        if (foundUser != null) {
            System.out.println("Found user by name: " + foundUser.name + " (ID: " + foundUser.userId + ")");
        }
    }
}