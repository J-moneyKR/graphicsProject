import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

public class CardGuessingGame {


    public static class CardGuessingGames extends JFrame {
        private JLabel cardLabel, resultLabel, scoreLabel;
        private JButton higherButton, lowerButton, newGameButton;

        private List<Integer> deck;
        private int currentCard;
        private int score;

        public CardGuessingGames() {
            setTitle("Card Guessing Game");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());

            // UI Panels
            JPanel topPanel = new JPanel();
            JPanel centerPanel = new JPanel();
            JPanel bottomPanel = new JPanel();

            // Card display
            cardLabel = new JLabel("Card: ?");
            cardLabel.setFont(new Font("Arial", Font.BOLD, 24));
            topPanel.add(cardLabel);

            // Result & Score
            resultLabel = new JLabel("Guess if the next card is Higher or Lower.");
            scoreLabel = new JLabel("Score: 0");
            centerPanel.setLayout(new GridLayout(2, 1));
            centerPanel.add(resultLabel);
            centerPanel.add(scoreLabel);

            // Buttons
            higherButton = new JButton("Higher");
            lowerButton = new JButton("Lower");
            newGameButton = new JButton("New Game");

            bottomPanel.add(higherButton);
            bottomPanel.add(lowerButton);
            bottomPanel.add(newGameButton);

            // Add panels to frame
            add(topPanel, BorderLayout.NORTH);
            add(centerPanel, BorderLayout.CENTER);
            add(bottomPanel, BorderLayout.SOUTH);

            // Button Listeners
            higherButton.addActionListener(e -> guess(true));
            lowerButton.addActionListener(e -> guess(false));
            newGameButton.addActionListener(e -> startNewGame());

            startNewGame();
        }

        private void startNewGame() {
            deck = new ArrayList<>();
            for (int i = 1; i <= 13; i++) {
                // Only use numbers for simplicity (1 to 13)
                deck.add(i);
            }
            Collections.shuffle(deck);
            currentCard = drawCard();
            score = 0;
            updateUI("Game started! Make your guess.");
            enableButtons(true);
        }

        private int drawCard() {
            if (deck.isEmpty()) {
                // Reshuffle if out of cards
                for (int i = 1; i <= 13; i++) deck.add(i);
                Collections.shuffle(deck);
            }
            return deck.remove(0);
        }

        private void guess(boolean guessHigher) {
            int nextCard = drawCard();
            boolean correct = (guessHigher && nextCard > currentCard) || (!guessHigher && nextCard < currentCard);

            if (correct) {
                score++;
                resultLabel.setText("Correct! Next card was: " + nextCard);
                currentCard = nextCard;
            } else {
                resultLabel.setText("Wrong! Next card was: " + nextCard);
                enableButtons(false);
            }

            cardLabel.setText("Card: " + currentCard);
            scoreLabel.setText("Score: " + score);
        }

        private void updateUI(String message) {
            cardLabel.setText("Card: " + currentCard);
            resultLabel.setText(message);
            scoreLabel.setText("Score: " + score);
        }

        private void enableButtons(boolean enable) {
            higherButton.setEnabled(enable);
            lowerButton.setEnabled(enable);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new CardGuessingGames().setVisible(true));
        }
    }

}
