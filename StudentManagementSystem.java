import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentManagementSystem {
    private JFrame frame;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField idField;
    private DefaultListModel<Student> studentListModel;
    private JList<Student> studentList;

    public StudentManagementSystem() {
        frame = new JFrame("Student Management System");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout setup
        frame.setLayout(new BorderLayout());

        // Top panel for input
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        JButton addButton = new JButton("Add Student");
        inputPanel.add(addButton);

        // List model and list for displaying students
        studentListModel = new DefaultListModel<>();
        studentList = new JList<>(studentListModel);
        JScrollPane scrollPane = new JScrollPane(studentList);

        // Delete button
        JButton deleteButton = new JButton("Delete Selected Student");

        // Adding components to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(deleteButton, BorderLayout.SOUTH);

        // Add student button action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String id = idField.getText();
                Student student = new Student(name, age, id);
                studentListModel.addElement(student);

                // Clear fields
                nameField.setText("");
                ageField.setText("");
                idField.setText("");
            }
        });

        // Delete student button action
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = studentList.getSelectedIndex();
                if (selectedIndex != -1) {
                    studentListModel.remove(selectedIndex);
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentManagementSystem();
    }
}
