
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainCalc implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] operationButtons = new JButton[12];
    JButton addButton, subButton, multiplyButton, divButton, modButton, expButton, sqrtButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font font = new Font("Dialog", Font.PLAIN, 30);

    double num1 = 0, num2 = 0, result = 0;
    char arithmeticOp;

    MainCalc() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(40, 30, 400, 60);
        textField.setFont(font);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multiplyButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        expButton = new JButton("^");
        sqrtButton = new JButton("π");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");


        operationButtons[0] = addButton;
        operationButtons[1] = subButton;
        operationButtons[2] = multiplyButton;
        operationButtons[3] = divButton;
        operationButtons[4] = modButton;
        operationButtons[5] = expButton;
        operationButtons[6] = sqrtButton;
        operationButtons[7] = decButton;
        operationButtons[8] = equButton;
        operationButtons[9] = delButton;
        operationButtons[10] = clrButton;
        operationButtons[11] = negButton;

        for (int i = 0; i < 12; i++) {
            operationButtons[i].addActionListener(this);
            operationButtons[i].setFont(font);
            operationButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);

        }
        delButton.setBounds(40, 110, 125, 35);
        clrButton.setBounds(315, 110, 125, 35);


        panel = new JPanel();
        panel.setBounds(40, 200, 400, 300);
        panel.setLayout(new GridLayout(5, 4, 12, 12));

        panel.add(sqrtButton);
        panel.add(expButton);
        panel.add(modButton);
        panel.add(divButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(negButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);


        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MainCalc calculator = new MainCalc();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            arithmeticOp = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            arithmeticOp = '-';
            textField.setText("");
        }

        if (e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(textField.getText());
            arithmeticOp = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            arithmeticOp = '/';
            textField.setText("");
        }

        if (e.getSource() == modButton) {
            num1 = Double.parseDouble(textField.getText());
            arithmeticOp = '%';
            textField.setText("");
        }

        if (e.getSource() == expButton) {
            num1 = Double.parseDouble(textField.getText());
            arithmeticOp = '^';
            textField.setText("");
        }

        if (e.getSource() == sqrtButton) {
            num1 = Double.parseDouble(textField.getText());
            arithmeticOp = 'π';
            textField.setText(String.valueOf(Math.sqrt(num1)));
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (arithmeticOp) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '%':
                    result = num1 % num2;
                    break;
                case '^':
                    result = Math.pow(num1, num2);
                    break;

            }

            textField.setText(String.valueOf(result));
            num1 = result;

        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }

    }
}
