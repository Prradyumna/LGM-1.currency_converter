
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Currency_Converter implements ActionListener {

    JFrame j;
    JTextField amountTextField;
    JComboBox<String> fromComboBox, toComboBox;
    JButton convertButton;
    JLabel headingLabel, amountLabel, fromLabel, toLabel, resultLabel;
    String[] currencies = { "USD", "EUR", "GBP", "JPY", "CAD", "AUD", "INR" };
    double[][] rates = {
            { 1.0, 0.90, 0.80, 135.86, 1.36, 1.50, 81.83 },
            { 1.10, 1.0, 0.88, 149.95, 1.50, 1.65, 90.31 },
            { 1.25, 1.13, 1.0, 170.19, 1.70, 1.87, 102.45 },
            { 0.007, 0.06, 0.006, 1.0, 0.01, 0.011, 0.60 },
            { 0.73, 0.66, 0.59, 99.90, 1.0, 1.10, 60.14 },
            { 0.67, 0.60, 0.53, 80.60, 0.90, 1.0, 54.54 },
            { 0.012, 0.011, 0.009, 1.66, 0.016, 0.018, 1.0 }
    };

    public Currency_Converter() {

        j = new JFrame("Currency Converter");
        j.setSize(800, 400);
        j.setLayout(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);

        headingLabel = new JLabel("Currency Converter ");
        headingLabel.setBounds(160, 20, 280, 40);
        headingLabel.setFont(new Font("Helvetica", Font.BOLD, 26));
        j.add(headingLabel);

        amountLabel = new JLabel("Amount :");
        amountLabel.setBounds(50, 80, 60, 25);
        j.add(amountLabel);

        amountTextField = new JTextField(10);
        amountTextField.setBounds(150, 80, 120, 25);
        j.add(amountTextField);

        fromLabel = new JLabel("From :");
        fromLabel.setBounds(50, 120, 120, 25);
        j.add(fromLabel);

        fromComboBox = new JComboBox<>(currencies);
        fromComboBox.setBounds(150, 120, 120, 25);
        j.add(fromComboBox);

        toLabel = new JLabel("To :");
        toLabel.setBounds(260, 120, 120, 25);
        j.add(toLabel);

        toComboBox = new JComboBox<>(currencies);
        toComboBox.setBounds(350, 120, 120, 25);
        j.add(toComboBox);

        convertButton = new JButton("Convert");
        convertButton.setBounds(230, 170, 120, 25);
        convertButton.addActionListener(this);
        j.add(convertButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(250, 200, 120, 25);
        j.add(resultLabel);
        j.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amountString = amountTextField.getText();
            double amount = Double.parseDouble(amountString);

            int fromIndex = fromComboBox.getSelectedIndex();
            int toIndex = toComboBox.getSelectedIndex();

            double rate = rates[fromIndex][toIndex];
            double result = amount * rate;

            String resultString = String.format("%.2f %s", result, currencies[toIndex]);
            resultLabel.setText(resultString);
        } catch (NumberFormatException ex) {
            System.out.println("error");
        }
    }

    public static void main(String[] args) {
        new Currency_Converter();
    }
}
