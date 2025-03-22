// Name: Orin Thomas, 
// Date: 03/22/2025
// Career Path Advisor GUI App

import java.awt.*;
import javax.swing.*;


public class CareerPathAdvisorGUI {

    // GUI Components
    private final JFrame frame;
    private final JTextField nameField;
    private final JComboBox<String> interestBox, skillBox;
    private final JTextArea resultArea;

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
        submitButton.addActionListener(e -> displayCareerSuggestions());

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
        return switch (interest) {
            case "Technology" -> switch (skill) {
                case "Problem-solving" -> "✅ Cybersecurity Analyst\n✅ Software Developer\n✅ Systems Architect";
                case "Analytical thinking" -> "✅ Data Scientist\n✅ AI Engineer\n✅ Network Administrator";
                case "Communication" -> "✅ Technical Writer\n✅ IT Consultant\n✅ Product Manager";
                case "Creativity" -> "✅ UX/UI Designer\n✅ Game Developer\n✅ Digital Artist";
                case "Leadership" -> "✅ IT Project Manager\n✅ CTO\n✅ Tech Team Lead";
                default -> "✅ IT Support Specialist\n✅ Web Developer\n✅ System Administrator";
            };

            case "Business" -> switch (skill) {
                case "Communication" -> "✅ Marketing Manager\n✅ Public Relations Specialist\n✅ Business Analyst";
                case "Leadership" -> "✅ Project Manager\n✅ HR Specialist\n✅ Entrepreneur";
                case "Analytical thinking" -> "✅ Financial Analyst\n✅ Business Intelligence Analyst\n✅ Risk Manager";
                case "Problem-solving" -> "✅ Management Consultant\n✅ Operations Manager\n✅ Strategy Analyst";
                case "Creativity" -> "✅ Brand Manager\n✅ Innovation Consultant\n✅ Product Developer";
                default -> "✅ Financial Analyst\n✅ Operations Manager\n✅ Consultant";
            };

            case "Healthcare" -> switch (skill) {
                case "Analytical thinking" -> "✅ Medical Researcher\n✅ Pharmacist\n✅ Geneticist";
                case "Problem-solving" -> "✅ Doctor\n✅ Nurse\n✅ Emergency Medical Technician (EMT)";
                case "Communication" -> "✅ Healthcare Administrator\n✅ Patient Advocate\n✅ Medical Liaison";
                case "Leadership" -> "✅ Hospital Administrator\n✅ Clinical Director\n✅ Healthcare Manager";
                case "Creativity" -> "✅ Art Therapist\n✅ Occupational Therapist\n✅ Health Education Specialist";
                default -> "✅ Therapist\n✅ Counselor\n✅ Nutritionist";
            };

            case "Arts and Media" -> switch (skill) {
                case "Creativity" -> "✅ Graphic Designer\n✅ Video Editor\n✅ Animator";
                case "Communication" -> "✅ Journalist\n✅ Content Creator\n✅ Public Speaker";
                case "Leadership" -> "✅ Creative Director\n✅ Production Manager\n✅ Studio Manager";
                case "Problem-solving" -> "✅ Film Editor\n✅ Technical Artist\n✅ Production Coordinator";
                case "Analytical thinking" -> "✅ Media Analyst\n✅ Art Director\n✅ Digital Marketing Analyst";
                default -> "✅ Writer\n✅ Journalist\n✅ Social Media Manager";
            };

            case "Education" -> switch (skill) {
                case "Leadership" -> "✅ School Principal\n✅ Academic Advisor\n✅ College Dean";
                case "Communication" -> "✅ Teacher\n✅ Educational Consultant\n✅ Corporate Trainer";
                case "Creativity" -> "✅ Art Teacher\n✅ Educational Content Creator\n✅ Instructional Designer";
                case "Problem-solving" -> "✅ Special Education Teacher\n✅ Educational Technologist\n✅ School Counselor";
                case "Analytical thinking" -> "✅ Educational Researcher\n✅ Curriculum Analyst\n✅ Assessment Specialist";
                default -> "✅ Teacher\n✅ Curriculum Developer\n✅ Special Education Instructor";
            };

            default -> "⚠️ No suggestions available. Please select valid options.";
        };
    }

    // Recommend resources based on selected interest
       private String getLearningResources(String interest) {
        return switch (interest) {
            case "Technology" -> "📚 Coursera, Udemy, and Codecademy for technology-related courses.";
            case "Business" -> "📚 LinkedIn Learning, HubSpot Academy, and Harvard Business Review.";
            case "Healthcare" -> "📚 Khan Academy, Coursera (Health), and PubMed for medical knowledge.";
            case "Arts and Media" -> "📚 Skillshare, MasterClass, and Adobe Creative Cloud Tutorials.";
            case "Education" -> "📚 EdX, FutureLearn, and Khan Academy for education development.";
            default -> "⚠️ No resources available.";
        };
    }

    // Main method to run the app
    // Main method to run the app
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CareerPathAdvisorGUI());
    }
}
