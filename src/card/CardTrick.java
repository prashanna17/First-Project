/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author prashanna thapa (991720494)
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

        // to fill the magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(generateRandomValue());
            c.setSuit(Card.SUITS[generateRandomSuitIndex()]);
            magicHand[i] = c;
        }

        // to display the initial magic hand
        System.out.println("Initial Magic Hand:");
        for (Card card : magicHand) {
            System.out.println(card.getSuit() + " " + card.getValue());
        }

        // Asking the user to pick a card
        Card userCard = new Card();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a card value (1-13): ");
        int userValue = getUserInput();
        System.out.print("Enter a suit (0-3 where 0-Hearts, 1-Diamonds, 2-Clubs, 3=Spades): ");
        String userSuit = Card.SUITS[getUserInput()];
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        // to search for the user's card in magicHand
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        // to report the result
        System.out.println("You picked: " + userCard.getSuit() + " " + userCard.getValue());
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }

    private static int generateRandomValue() {
        return (int) (Math.random() * 13) + 1; // Generating a random value between 1 and 13
    }

    private static int generateRandomSuitIndex() {
        return (int) (Math.random() * 4); // Generating random index between 0 and 3
    }

    // Helper methods to get user input
    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}
