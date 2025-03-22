import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CareerPathData {
    // Career Options & Resources
    private final String[] interests = {"Technology", "Business", "Healthcare", "Arts and Media", "Education"};
    private final String[] skills = {"Problem-solving", "Communication", "Analytical thinking", "Creativity", "Leadership"};

    // Getter methods for arrays
    public String[] getInterests() {
        return interests;
    }

    public String[] getSkills() {
        return skills;
    }

    // Suggest career paths based on interest and skill
    public String getCareerSuggestions(String interest, String skill) {
        if (interest == null || skill == null) {
            return "⚠️ Interest and skill cannot be null.";
        }
        
        return switch (interest.trim().toLowerCase()) {
            case "technology" -> {
                if ("problem-solving".equalsIgnoreCase(skill)) {
                    yield "✅ Cybersecurity Analyst\n✅ Software Developer\n✅ Systems Architect";
                } else if ("analytical thinking".equalsIgnoreCase(skill)) {
                    yield "✅ Data Scientist\n✅ AI Engineer\n✅ Network Administrator";
                } else {
                    yield "✅ IT Support Specialist\n✅ Web Developer\n✅ Technical Writer";
                }
            }
            case "business" -> {
                if ("communication".equalsIgnoreCase(skill)) {
                    yield "✅ Marketing Manager\n✅ Public Relations Specialist\n✅ Business Analyst";
                } else if ("leadership".equalsIgnoreCase(skill)) {
                    yield "✅ Project Manager\n✅ HR Specialist\n✅ Entrepreneur";
                } else {
                    yield "✅ Financial Analyst\n✅ Operations Manager\n✅ Consultant";
                }
            }
            case "healthcare" -> {
                if ("analytical thinking".equalsIgnoreCase(skill)) {
                    yield "✅ Medical Researcher\n✅ Pharmacist\n✅ Geneticist";
                } else if ("problem-solving".equalsIgnoreCase(skill)) {
                    yield "✅ Doctor\n✅ Nurse\n✅ Emergency Medical Technician (EMT)";
                } else {
                    yield "✅ Therapist\n✅ Counselor\n✅ Nutritionist";
                }
            }
            case "arts and media" -> {
                if ("creativity".equalsIgnoreCase(skill)) {
                    yield "✅ Graphic Designer\n✅ Video Editor\n✅ Animator";
                } else {
                    yield "✅ Writer\n✅ Journalist\n✅ Social Media Manager";
                }
            }
            case "education" -> {
                if ("leadership".equalsIgnoreCase(skill)) {
                    yield "✅ School Principal\n✅ Academic Advisor\n✅ College Dean";
                } else {
                    yield "✅ Teacher\n✅ Curriculum Developer\n✅ Special Education Instructor";
                }
            }
            default -> "⚠️ No suggestions available. Please select valid options.";
        };
    }

    // Recommend resources based on selected interest
    public String getLearningResources(String interest) {
        return switch (interest) {
            case "Technology" -> "📚 Coursera, Udemy, and Codecademy for technology-related courses.";
            case "Business" -> "📚 LinkedIn Learning, HubSpot Academy, and Harvard Business Review.";
            case "Healthcare" -> "📚 Khan Academy, Coursera (Health), and PubMed for medical knowledge.";
            case "Arts and Media" -> "📚 Skillshare, MasterClass, and Adobe Creative Cloud Tutorials.";
            case "Education" -> "📚 EdX, FutureLearn, and Khan Academy for education development.";
            default -> "⚠️ No resources available.";
        };
    }

    // Setup modern look and feel
    public static void setupModernStyle() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | 
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Failed to set Nimbus look and feel: " + e.getMessage());
        }
    }
} 