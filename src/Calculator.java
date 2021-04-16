import component.RoundJTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class Calculator extends JFrame {
    private final JPanel contentPanel;
    private final Calculation calculation;
    private RoundJTextField textField;
    private String operation;
    private Double ans;
    private boolean isError;

    public Calculator() {
        this.calculation = new Calculation();
        this.ans = 0.0;
        this.isError = false;

        this.setType(Type.UTILITY);
        this.setResizable(false);
        this.setSize(500, 600);
        this.setUndecorated(true);
        this.setShape(new RoundRectangle2D.Double(0, 0, 350, 500, 50, 50));
        this.setVisible(true);

        this.contentPanel = new JPanel();
        this.contentPanel.setLayout(null);
        this.contentPanel.setBackground(Color.decode("#38373A"));
        this.contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        this.setContentPane(this.contentPanel);
        this.setLocationRelativeTo(null);

        createTextPane();
        createButtons();
    }

    private void createTextPane() {
        this.operation = "";
        this.textField = new RoundJTextField();
        this.textField.setEditable(false);
        this.textField.setSize(300, 50);
        this.textField.setLocation(25, 25);
        this.textField.setHorizontalAlignment(SwingConstants.LEFT);
        this.textField.setBackground(Color.decode("#A2AF77"));
        this.textField.setForeground(Color.black);
        this.textField.setFont(new Font("Andale Mono", Font.BOLD, 25));
        this.textField.setBorder(new EmptyBorder(5, 10, 5,10));
        this.textField.setCaretColor(Color.black);
        this.textField.setText(operation);
        this.textField.getCaret().setVisible(true);
        this.contentPanel.add(textField);

    }

    private void createButtons(){
        ArrayList<JButton> buttons = new ArrayList<>();
        int width = 70;
        int height = 50;

        JButton onOff = new JButton("O/F");
        onOff.setBounds(25, 105, width,height);
        onOff.setBackground(Color.red);
        onOff.addActionListener(e -> System.exit(0));
        buttons.add(onOff);

        JButton del = new JButton("DEL");
        del.setBounds(175, 105, width,height);
        del.setBackground(Color.orange);
        del.addActionListener(e -> {
            isError = false;
            if (operation.length() > 0){
                operation = operation.substring(0, operation.length()-1);
            }
            setText();
        });
        buttons.add(del);

        JButton clear = new JButton("AC");
        clear.setBounds(250, 105, width,height);
        clear.setBackground(Color.orange);
        clear.addActionListener(e -> {
            isError = false;
            operation = "";
            setText();
        });
        buttons.add(clear);

        JButton openBracket = new JButton("(");
        openBracket.setBounds(25, 170, width,height);
        openBracket.setBackground(Color.black);
        openBracket.addActionListener(e -> {
            if(isError) return;

            operation += "(";
            setText();
        });
        buttons.add(openBracket);

        JButton closeBracket = new JButton(")");
        closeBracket.setBounds(100, 170, width,height);
        closeBracket.setBackground(Color.black);
        closeBracket.addActionListener(e -> {
            if(isError) return;

            operation += ")";
            setText();
        });
        buttons.add(closeBracket);

        JButton division = new JButton("÷");
        division.setBounds(175, 170, width,height);
        division.setBackground(Color.black);
        division.addActionListener(e -> {
            if(isError) return;

            operation += "÷";
            setText();
        });
        buttons.add(division);

        JButton multiply = new JButton("x");
        multiply.setBounds(250, 170, width,height);
        multiply.setBackground(Color.black);
        multiply.addActionListener(e -> {
            if(isError) return;

            operation += "x";
            setText();
        });
        buttons.add(multiply);

        JButton seven = new JButton("7");
        seven.setBounds(25, 235, width,height);
        seven.setBackground(Color.black);
        seven.addActionListener(e -> {
            if(isError) return;

            operation += "7";
            setText();
        });
        buttons.add(seven);

        JButton eight = new JButton("8");
        eight.setBounds(100, 235, width,height);
        eight.setBackground(Color.black);
        eight.addActionListener(e -> {
            if(isError) return;

            operation += "8";
            setText();
        });
        buttons.add(eight);

        JButton nine = new JButton("9");
        nine.setBounds(175, 235, width,height);
        nine.setBackground(Color.black);
        nine.addActionListener(e -> {
            if(isError) return;

            operation += "9";
            setText();
        });
        buttons.add(nine);

        JButton minus = new JButton("-");
        minus.setBounds(250, 235, width,height);
        minus.setBackground(Color.black);
        minus.addActionListener(e -> {
            if(isError) return;

            operation += "-";
            setText();
        });
        buttons.add(minus);

        JButton four = new JButton("4");
        four.setBounds(25, 300, width,height);
        four.setBackground(Color.black);
        four.addActionListener(e -> {
            if(isError) return;

            operation += "4";
            setText();
        });
        buttons.add(four);

        JButton five = new JButton("5");
        five.setBounds(100, 300, width,height);
        five.setBackground(Color.black);
        five.addActionListener(e -> {
            if(isError) return;

            operation += "5";
            setText();
        });
        buttons.add(five);

        JButton six = new JButton("6");
        six.setBounds(175, 300, width,height);
        six.setBackground(Color.black);
        six.addActionListener(e -> {
            if(isError) return;

            operation += "6";
            setText();
        });
        buttons.add(six);

        JButton plus = new JButton("+");
        plus.setBounds(250, 300, width,height);
        plus.setBackground(Color.black);
        plus.addActionListener(e -> {
            if(isError) return;

            operation += "+";
            setText();
        });
        buttons.add(plus);

        JButton one = new JButton("1");
        one.setBounds(25, 365, width,height);
        one.setBackground(Color.black);
        one.addActionListener(e -> {
            if(isError) return;

            operation += "1";
            setText();
        });
        buttons.add(one);

        JButton two = new JButton("2");
        two.setBounds(100, 365, width,height);
        two.setBackground(Color.black);
        two.addActionListener(e -> {
            if(isError) return;

            operation += "2";
            setText();
        });
        buttons.add(two);

        JButton three = new JButton("3");
        three.setBounds(175, 365, width,height);
        three.setBackground(Color.black);
        three.addActionListener(e -> {
            if(isError) return;

            operation += "3";
            setText();
        });
        buttons.add(three);

        JButton equal = new JButton("=");
        equal.setBounds(250, 365, width,height*2+15);
        equal.setBackground(Color.decode("#F15A2A"));
        equal.addActionListener(e -> {
            operation = operation.replace("Ans", ans.toString());
            calculate();
            if(isError) return;
            setText();
        });
        buttons.add(equal);

        JButton zero = new JButton("0");
        zero.setBounds(25, 430, width,height);
        zero.setBackground(Color.black);
        zero.addActionListener(e -> {
            if(isError) return;

            operation += "0";
            setText();
        });
        buttons.add(zero);

        JButton dot = new JButton(".");
        dot.setBounds(100, 430, width,height);
        dot.setBackground(Color.black);
        dot.addActionListener(e -> {
            if(isError) return;

            operation += ".";
            setText();
        });
        buttons.add(dot);

        JButton ans = new JButton("Ans");
        ans.setBounds(175, 430, width,height);
        ans.setBackground(Color.black);
        ans.addActionListener(e -> {
            if(isError) return;

            operation += "Ans";
            setText();
        });
        buttons.add(ans);


        for(JButton button : buttons) {
            button.setFont(new Font("DejaVu Sans", Font.BOLD, 20));
            button.setBorder(new EmptyBorder(5, 5, 5, 5));
            button.setForeground(Color.white);
            button.setHorizontalAlignment(SwingConstants.CENTER);
            button.setVerticalAlignment(SwingConstants.CENTER);
            this.contentPanel.add(button);
        }
    }

    private void calculate() {
        Double output = this.calculation.calculate(operation);
        if (output == null) {
            this.isError = true;
            setText("SYNTAX ERROR");
        } else {
            ans = output;
            this.operation = (output % 1 == 0) ? String.valueOf(output.longValue()) : output.toString();
        }
    }

    private void setText() {
        this.textField.setText(this.operation);
        this.textField.getCaret().setVisible(!isError);
    }

    private void setText(String s) {
        this.textField.setText(s);
        this.textField.getCaret().setVisible(!isError);
    }
}
