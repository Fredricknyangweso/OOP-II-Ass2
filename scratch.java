

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RadioButtonDemo extends JFrame {

    private JLabel petImage;
    private JLabel petName;

    public RadioButtonDemo() {
        setTitle("RadioButtonDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 420);
        setMinimumSize(new Dimension(600, 360));
        setLocationRelativeTo(null);

        JPanel main = new JPanel(new BorderLayout(20, 10));
        main.setBorder(new EmptyBorder(18, 22, 18, 22));
        main.setBackground(new Color(245, 245, 245));
        setContentPane(main);

        JLabel heading = new JLabel(
                "Choose a pet", SwingConstants.CENTER
        );
        heading.setFont(new Font("SansSerif", Font.BOLD, 22));
        main.add(heading, BorderLayout.NORTH);

        JPanel choices = new JPanel(new GridLayout(5, 1, 8, 8));
        choices.setOpaque(false);
        choices.setBorder(new EmptyBorder(20, 10, 20, 10));

        JRadioButton bird = new JRadioButton("Bird");
        JRadioButton cat = new JRadioButton("Cat");
        JRadioButton dog = new JRadioButton("Dog");
        JRadioButton rabbit = new JRadioButton("Rabbit");
        JRadioButton pig = new JRadioButton("Pig");

        ButtonGroup group = new ButtonGroup();
        JRadioButton[] buttons = {bird, cat, dog, rabbit, pig};

        for (JRadioButton button : buttons) {
            button.setFont(new Font("SansSerif", Font.PLAIN, 18));
            button.setOpaque(false);
            group.add(button);
            choices.add(button);
        }

        petImage = new JLabel("🐷", SwingConstants.CENTER);
        petImage.setFont(
                new Font("Segoe UI Emoji", Font.PLAIN, 110)
        );

        petName = new JLabel("Pig", SwingConstants.CENTER);
        petName.setFont(new Font("SansSerif", Font.BOLD, 22));

        JPanel display = new JPanel(new BorderLayout(5, 10));
        display.setBackground(Color.WHITE);
        display.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.GRAY),
                        new EmptyBorder(15, 15, 15, 15)
                )
        );

        display.add(petImage, BorderLayout.CENTER);
        display.add(petName, BorderLayout.SOUTH);

        main.add(choices, BorderLayout.WEST);
        main.add(display, BorderLayout.CENTER);

        bird.addActionListener(e -> showPet("Bird", "🐦"));
        cat.addActionListener(e -> showPet("Cat", "🐱"));
        dog.addActionListener(e -> showPet("Dog", "🐶"));
        rabbit.addActionListener(e -> showPet("Rabbit", "🐰"));
        pig.addActionListener(e -> showPet("Pig", "🐷"));

        pig.setSelected(true);

        setVisible(true);
    }

    private void showPet(String name, String emoji) {
        petImage.setText(emoji);
        petName.setText(name);

        JOptionPane.showMessageDialog(
                this,
                "You selected: " + name,
                "Pet Selection",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RadioButtonDemo();
        });
    }
}
}
