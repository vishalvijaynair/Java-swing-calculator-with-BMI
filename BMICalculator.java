import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class BMICalculator extends JFrame implements ActionListener {
    static JFrame f;
    static JTextField l;
    String heightInput, weightInput;

    BMICalculator() {
        heightInput = weightInput = "";
    }

    public static void main(String args[]) {
        f = new JFrame("BMI Calculator");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        BMICalculator c = new BMICalculator();
        l = new JTextField(16);
        l.setEditable(false);

        JButton bCalculate, bClear;

        bCalculate = new JButton("Calculate BMI");
        bClear = new JButton("Clear");

        JPanel p = new JPanel();

        bCalculate.addActionListener(c);
        bClear.addActionListener(c);

        p.add(l);
        p.add(bCalculate);
        p.add(bClear);

        p.setBackground(Color.red);
        f.add(p);

        f.setSize(250, 120);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("Calculate BMI")) {
            String heightString = JOptionPane.showInputDialog(f, "Enter your height in centimeters:");
            String weightString = JOptionPane.showInputDialog(f, "Enter your weight in kilograms:");

            try {
                double height = Double.parseDouble(heightString);
                double weight = Double.parseDouble(weightString);

                if (height <= 0 || weight <= 0) {
                    l.setText("Invalid input");
                } else {
                    double bmi = weight / ((height / 100.0) * (height / 100.0));
                    l.setText("BMI: " + String.format("%.2f", bmi));
                }
            } catch (NumberFormatException ex) {
                l.setText("Invalid input");
            }
        } else if (s.equals("Clear")) {
            l.setText("");
        }
    }
}
