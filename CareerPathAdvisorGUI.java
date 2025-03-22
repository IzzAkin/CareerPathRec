// Name: Orin Thomas
// Date: 03/22/2025
// Career Path Advisor GUI App

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CareerPathAdvisorGUI {

    // GUI Components
    private JFrame frame;
    private JTextField nameField;
    private JComboBox<String> interestBox, skillBox;
    private JTextArea resultArea;

    // Career Options & Resources
    private final String[] interests = {"Technology", "Business", "Healthcare", "Arts and Media", "Education"};
    private final String[] skills = {"Problem-solving", "Communication", "Analytical thinking", "Creativity", "Leadership"};

    // Constructor to initialize the GUI
    public CareerPathAdvisorGUI() {
        // Create JFrame
        frame = new JFrame("Career Path Advisor App");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create header panel
        JPanel headerPanel = new JPanel();
        JLabel titleLabel = new JLabel("🎓 Career Path Advisor");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(titleLabel);

        // Create input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel nameLabel = new JLabel("Enter your name:");
        nameField = new JTextField(15);

        JLabel interestLabel = new JLabel("Select your interest:");
        interestBox = new JComboBox<>(interests);

        JLabel skillLabel = new JLabel("Select your strongest skill:");
        skillBox = new JComboBox<>(skills);

        JButton submitButton = new JButton("Get Career Suggestions");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayCareerSuggestions();
            }
        });

        // Add inputs to the panel
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(interestLabel);
        inputPanel.add(interestBox);
        inputPanel.add(skillLabel);
        inputPanel.add(skillBox);
        inputPanel.add(submitButton);

        // Create result panel
        resultArea = new JTextArea(8, 40);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Add components to the frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Method to generate career suggestions
    private void displayCareerSuggestions() {
        String name = nameField.getText();
        String interest = (String) interestBox.getSelectedItem();
        String skill = (String) skillBox.getSelectedItem();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter your name.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Build the output message
        StringBuilder output = new StringBuilder("Hello, " + name + "!\n");
        output.append("Based on your interest in ").append(interest).append(" and your strength in ").append(skill).append(", here are some suggested career paths:\n\n");

        output.append(getCareerSuggestions(interest, skill));
        output.append("\n\n📚 Recommended Learning Resources:\n");
        output.append(getLearningResources(interest));

        // Display suggestions in result area
        resultArea.setText(output.toString());
    }

    // Suggest career paths based on interest and skill
    private String getCareerSuggestions(String interest, String skill) {
        switch (interest) {
            case "Technology":
                if (skill.equals("Problem-solving")) {
                    return "✅ Cybersecurity Analyst\n✅ Software Developer\n✅ Systems Architect";
                } else if (skill.equals("Analytical thinking")) {
                    return "✅ Data Scientist\n✅ AI Engineer\n✅ Network Administrator";
                } else {
                    return "✅ IT Support Specialist\n✅ Web Developer\n✅ Technical Writer";
                }

            case "Business":
                if (skill.equals("Communication")) {
                    return "✅ Marketing Manager\n✅ Public Relations Specialist\n✅ Business Analyst";
                } else if (skill.equals("Leadership")) {
                    return "✅ Project Manager\n✅ HR Specialist\n✅ Entrepreneur";
                } else {
                    return "✅ Financial Analyst\n✅ Operations Manager\n✅ Consultant";
                }

            case "Healthcare":
                if (skill.equals("Analytical thinking")) {
                    return "✅ Medical Researcher\n✅ Pharmacist\n✅ Geneticist";
                } else if (skill.equals("Problem-solving")) {
                    return "✅ Doctor\n✅ Nurse\n✅ Emergency Medical Technician (EMT)";
                } else {
                    return "✅ Therapist\n✅ Counselor\n✅ Nutritionist";
                }

            case "Arts and Media":
                if (skill.equals("Creativity")) {
                    return "✅ Graphic Designer\n✅ Video Editor\n✅ Animator";
                } else {
                    return "✅ Writer\n✅ Journalist\n✅ Social Media Manager";
                }

            case "Education":
                if (skill.equals("Leadership")) {
                    return "✅ School Principal\n✅ Academic Advisor\n✅ College Dean";
                } else {
                    return "✅ Teacher\n✅ Curriculum Developer\n✅ Special Education Instructor";
                }

            default:
                return "⚠️ No suggestions available. Please select valid options.";
        }
    }

    // Recommend resources based on selected interest
    private String getLearningResources(String interest) {
        switch (interest) {
            case "Technology":
                return "📚 Coursera, Udemy, and Codecademy for technology-related courses.";
            case "Business":
                return "📚 LinkedIn Learning, HubSpot Academy, and Harvard Business Review.";
            case "Healthcare":
                return "📚 Khan Academy, Coursera (Health), and PubMed for medical knowledge.";
            case "Arts and Media":
                return "📚 Skillshare, MasterClass, and Adobe Creative Cloud Tutorials.";
            case "Education":
                return "📚 EdX, FutureLearn, and Khan Academy for education development.";
            default:
                return "⚠️ No resources available.";
        }
    }

    // Main method to run the app
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CareerPathAdvisorGUI();
            }
        });
    }
}
