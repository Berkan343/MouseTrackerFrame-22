package MouseTrackerFrame;
//MouseTrackerFrame
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MouseTrackerFrame extends JFrame implements ActionListener {
    private JTextField textField;
    private char currentChar;

    public MouseTrackerFrame() {
        super("Ekran Klavyesi");

        // Ana panel
        JPanel panel = new JPanel(new BorderLayout());
        // Tuşlar için alt panel
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));

        // Tuşlar için etiketler
        String[] labels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "A", "B", "C", "D",
            "E", "F", "G", "H",
            "I", "J", "K", "L",
            "M", "N", "O", "P",
            "Q", "R", "S", "T",
            "U", "V", "W", "X",
            "Y", "Z"
        };

        // Tuşları oluştur
        for (int i = 0; i < labels.length; i++) {
            JButton button = new JButton(labels[i]);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        // Metin alanı
        textField = new JTextField(20);
        textField.setEditable(false);
        panel.add(textField, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Tuşa basıldığında çağrılan metot
    public void actionPerformed(ActionEvent e) {
        String buttonLabel = e.getActionCommand();
        if (buttonLabel.length() == 1) {
            currentChar = buttonLabel.charAt(0);
            textField.setText(textField.getText() + currentChar);
        } else {
            switch (buttonLabel) {
                case "+":
                    currentChar = '+';
                    textField.setText(textField.getText() + currentChar);
                    break;
                case "-":
                    currentChar = '-';
                    textField.setText(textField.getText() + currentChar);
                    break;
                case "*":
                    currentChar = '*';
                    textField.setText(textField.getText() + currentChar);
                    break;
                case "/":
                    currentChar = '/';
                    textField.setText(textField.getText() + currentChar);
                    break;
                case "=":
                    // Do nothing
                    break;
            }
        }
    }

    public static void main(String[] args) {
    	new MouseTrackerFrame();
    }
}