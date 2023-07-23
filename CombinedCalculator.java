import javax.swing.*;

public class CombinedCalculator {
    public static void main(String[] args) {
        String[] options = { "Normal Calculator", "BMI Calculator" };

        int choice = JOptionPane.showOptionDialog(
                null,
                "Choose Calculator Type",
                "Calculator Selection",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            // Run Normal Calculator
            NormalCalculator.main(args);
        } else if (choice == 1) {
            // Run BMI Calculator
            BMICalculator.main(args);
        } else {
            // Invalid choice
            JOptionPane.showMessageDialog(null, "Invalid selection. Exiting...", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
