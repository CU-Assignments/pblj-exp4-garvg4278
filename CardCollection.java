import java.util.*;

class Card {
    String rank;
    String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public void displayCard() {
        System.out.println(rank + " of " + suit);
    }
}

public class CardCollection {

    private static List<Card> deck = new ArrayList<>();

    public static void initializeDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    public static void findCardsBySuit(String suit) {
        boolean found = false;
        for (Card card : deck) {
            if (card.suit.equalsIgnoreCase(suit)) {
                card.displayCard();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cards found for the suit: " + suit);
        }
    }

    public static void displayAllCards() {
        if (deck.isEmpty()) {
            System.out.println("The deck is empty.");
        } else {
            for (Card card : deck) {
                card.displayCard();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initializeDeck();

        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Display All Cards");
            System.out.println("2. Find Cards by Suit");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    displayAllCards();
                    break;

                case 2:
                    System.out.print("Enter the suit (Hearts, Diamonds, Clubs, Spades) to find: ");
                    String suit = scanner.nextLine();
                    findCardsBySuit(suit);
                    break;

                case 3:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}