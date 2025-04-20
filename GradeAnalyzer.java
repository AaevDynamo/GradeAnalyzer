import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeAnalyzer extends JFrame implements ActionListener {
  private JLabel nameLabel, dbmsLabel, daaLabel, javaLabel, dataScienceLabel, resultLabel, totalLabel, averageLabel, gradeLabel, schoolLabel;
    private JTextField nameField, dbmsField, daaField, javaField, dataScienceField;
    private JButton calculateButton, nextButton, exitButton;

    private JPanel inputPanel, resultPanel, reportPanel;


  public GradeAnalyzer(){
           setTitle("Student Grade Analyzer");
           setSize(800,650);
           setDefaultCloseOperation(EXIT_ON_CLOSE);

           inputPanel =new JPanel(new GridLayout(8,5)); 
            inputPanel.setBackground(Color.cyan); 
        schoolLabel = new JLabel("AAKASH PUBLIC SCHOOL, DELHI");
        schoolLabel.setHorizontalAlignment(SwingConstants.CENTER);
        schoolLabel.setFont(new Font("Arial", Font.BOLD, 20));

        nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.blue);
        dbmsLabel = new JLabel("DBMS:");
        dbmsLabel.setForeground(Color.blue);
        daaLabel = new JLabel("DAA:");
        daaLabel.setForeground(Color.blue);
        javaLabel = new JLabel("Java:");
        javaLabel.setForeground(Color.blue);
        dataScienceLabel = new JLabel("Data Science:");
        dataScienceLabel.setForeground(Color.blue);

        nameField = new JTextField(10);
        dbmsField = new JTextField(3);
        daaField = new JTextField(3);
        javaField = new JTextField(3);
        dataScienceField = new JTextField(3);

        inputPanel.add(schoolLabel);
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(new JLabel());
        inputPanel.add(dbmsLabel);
        inputPanel.add(dbmsField);
        inputPanel.add(new JLabel());
        inputPanel.add(daaLabel);
        inputPanel.add(daaField);
        inputPanel.add(new JLabel());
        inputPanel.add(javaLabel);
        inputPanel.add(javaField);
        inputPanel.add(new JLabel());
        inputPanel.add(dataScienceLabel);
        inputPanel.add(dataScienceField);
        inputPanel.add(new JLabel());

        // Result panel
        resultPanel = new JPanel(new GridLayout(4, 2));
        resultPanel.setBackground(Color.cyan); // Set background color
        totalLabel = new JLabel("Total:");
        totalLabel.setForeground(Color.red); // Set text color
        averageLabel = new JLabel("Average:");
        averageLabel.setForeground(Color.red);
        gradeLabel = new JLabel("Grade:");
        gradeLabel.setForeground(Color.red);
        resultLabel = new JLabel();

        resultPanel.add(totalLabel);
        resultPanel.add(new JLabel()); // Placeholder for total value
        resultPanel.add(averageLabel);
        resultPanel.add(new JLabel()); // Placeholder for average value
        resultPanel.add(gradeLabel);
        resultPanel.add(new JLabel()); // Placeholder for grade value
        resultPanel.add(new JLabel());
        resultPanel.add(resultLabel);

        // Report panel
        reportPanel = new JPanel();
        reportPanel.setLayout(new BorderLayout());
        reportPanel.setBackground(Color.cyan); // Set background color
        reportPanel.add(inputPanel, BorderLayout.NORTH);
        reportPanel.add(resultPanel, BorderLayout.CENTER);

        // Calculate button
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        calculateButton.setBackground(Color.green.darker()); // Set button color
        calculateButton.setForeground(Color.white); // Set text color

        // Next button
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        nextButton.setBackground(Color.green.darker()); // Set button color
        nextButton.setForeground(Color.white); // Set text color

        // Exit button
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        exitButton.setBackground(Color.red.darker()); // Set button color
        exitButton.setForeground(Color.white); // Set text color

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(calculateButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(exitButton);

        // Add components to the frame
        setLayout(new BorderLayout());
        add(reportPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            String name = nameField.getText();
            double dbms = Double.parseDouble(dbmsField.getText());
            double daa = Double.parseDouble(daaField.getText());
            double java = Double.parseDouble(javaField.getText());
            double dataScience = Double.parseDouble(dataScienceField.getText());

            double total = dbms + daa + java + dataScience;
            double average = total / 4;
            String grade = calculateGrade(average);

            // Update result panel
            ((JLabel) resultPanel.getComponent(1)).setText(Double.toString(total));
            ((JLabel) resultPanel.getComponent(3)).setText(String.format("%.2f", average));
            ((JLabel) resultPanel.getComponent(5)).setText(grade);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
        // Handle next button action if needed
    }

    private String calculateGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GradeAnalyzer calculator = new GradeAnalyzer();
            calculator.setVisible(true);
        });
    }
}
