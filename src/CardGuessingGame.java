import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CardGuessingGame extends JFrame {
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JButton b1;
    JButton b2;

    ArrayList<Integer> cards = new ArrayList<Integer>();
    int a = 0;
    int b = 0;
    int c = 0;

    public CardGuessingGame() {
        this.setTitle("Card Game");
        this.setSize(400, 400);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel("Card: ?");
        label1.setBounds(150, 20, 200, 30);
        this.add(label1);

        label2 = new JLabel("Guess higher or lower.");
        label2.setBounds(100, 50, 300, 30);
        this.add(label2);

        label3 = new JLabel("Score: 0");
        label3.setBounds(150, 80, 200, 30);
        this.add(label3);

        b1 = new JButton("Higher");
        b1.setBounds(80, 120, 100, 30);
        this.add(b1);

        b2 = new JButton("Lower");
        b2.setBounds(200, 120, 100, 30);
        this.add(b2);

        for (int i = 0; i < 13; i++) {
            cards.add(i + 1);
        }
        Collections.shuffle(cards);

        a = cards.get(0);
        cards.remove(0);
        label1.setText("Card: " + a);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cards.size() == 0) {
                    for (int i = 1; i <= 13; i++) {
                        cards.add(i);
                    }
                    Collections.shuffle(cards);
                }

                b = cards.get(0);
                cards.remove(0);

                if (b > a) {
                    c = c + 1;
                    label2.setText("Correct! Card was: " + b);
                    label3.setText("Score: " + c);
                    a = b;
                    label1.setText("Card: " + a);
                } else {
                    label2.setText("Wrong! Card was: " + b);
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    label1.setText("Card: " + a);
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cards.size() == 0) {
                    for (int i = 1; i <= 13; i++) {
                        cards.add(i);
                    }
                    Collections.shuffle(cards);
                }

                b = cards.get(0);
                cards.remove(0);

                if (b < a) {
                    c = c + 1;
                    label2.setText("Correct! Card was: " + b);
                    label3.setText("Score: " + c);
                    a = b;
                    label1.setText("Card: " + a);
                } else {
                    label2.setText("Wrong! Card was: " + b);
                    b1.setEnabled(false);
                    b2.setEnabled(false);
                    label1.setText("Card: " + a);
                }
            }
        });
    }

    public static void main(String[] args) {
        CardGuessingGame g = new CardGuessingGame();
        g.setVisible(true);
    }
}
