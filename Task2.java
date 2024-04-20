import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;

public class Task2 extends JFrame {
    private JTextArea textArea;
    private JButton countButton;

    public Task2() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        countButton = new JButton("Count Words");
        countButton.addActionListener(new CountButtonListener());
        add(countButton, BorderLayout.SOUTH);
    }

    private class CountButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = textArea.getText();
            String[] words = text.split("[\\s\\p{Punct}]+");

            Map<String, Integer> wordFrequency = new HashMap<>();
            Set<String> uniqueWords = new HashSet<>();

            for (String word : words) {
                if (!isStopWord(word)) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    uniqueWords.add(word);
                }
            }

            StringBuilder output = new StringBuilder();
            output.append("Total number of words: ").append(words.length).append("\n");
            output.append("Number of unique words: ").append(uniqueWords.size()).append("\n");
            output.append("Word frequency:").append("\n");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                output.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }

            JOptionPane.showMessageDialog(null, output.toString(), "Word Count Results",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean isStopWord(String word) {
        String[] stopWords = { "the", "a", "an", "and", "or", "but", "is", "are", "was", "were", "to", "of", "in", "on",
                "for", "with", "at" };
        return Arrays.asList(stopWords).contains(word.toLowerCase());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Task2 gui = new Task2();
                gui.setVisible(true);
            }
        });
    }
}
