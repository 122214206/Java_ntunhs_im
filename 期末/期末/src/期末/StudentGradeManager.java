package 期末;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StudentGradeManager extends JFrame {
    private JButton addButton, listButton;
    private JTextField nameField, heightField, weightField;
    private JTextArea textArea;
    private Map<String, Student> students;
    private File file;

    public StudentGradeManager() {
        super("Student BMI Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new FlowLayout());

        students = new HashMap<>();
        file = new File("students_bmi.csv");

        nameField = new JTextField(10);
        heightField = new JTextField(10);
        weightField = new JTextField(10);

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Height (m):"));
        add(heightField);
        add(new JLabel("Weight (kg):"));
        add(weightField);

        addButton = new JButton("Add");
        addButton.addActionListener(this::addStudent);
        add(addButton);

        listButton = new JButton("List Students");
        listButton.addActionListener(this::listStudents);
        add(listButton);

        textArea = new JTextArea(15, 50);
        add(new JScrollPane(textArea));

        setVisible(true);

        // Initialize the CSV file with headers if it doesn't exist
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.append("Name,Height,Weight,BMI\n");
            } catch (IOException e) {
                textArea.setText("Error initializing file: " + e.getMessage());
            }
        } else {
            loadFromFile();
        }
    }

    private void addStudent(ActionEvent e) {
        try {
            String name = nameField.getText();
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());

            Student student = new Student(name, height, weight);
            students.put(name, student);
            textArea.setText("Student added: " + student);

            saveToCSV(student);
        } catch (NumberFormatException ex) {
            textArea.setText("Invalid input. Please enter numerical values for height and weight.");
        } catch (IOException ex) {
            textArea.setText("Error saving to file: " + ex.getMessage());
        }
    }

    private void saveToCSV(Student student) throws IOException {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.append(student.getName()).append(",")
                  .append(String.valueOf(student.getHeight())).append(",")
                  .append(String.valueOf(student.getWeight())).append(",")
                  .append(String.format("%.2f", student.getBmi())).append("\n");
        }
    }

    private void listStudents(ActionEvent e) {
        StringBuilder builder = new StringBuilder("All Students:\n");
        for (Student student : students.values()) {
            builder.append(student).append("\n");
        }
        textArea.setText(builder.toString());
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    double height = Double.parseDouble(parts[1]);
                    double weight = Double.parseDouble(parts[2]);
                    double bmi = Double.parseDouble(parts[3]);
                    Student student = new Student(name, height, weight);
                    students.put(name, student);
                }
            }
        } catch (IOException e) {
            textArea.setText("Error loading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentGradeManager::new);
    }
}