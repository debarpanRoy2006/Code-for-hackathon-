import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecurityApp {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Security App");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel for the home screen
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new GridLayout(5, 1, 10, 10));
        homePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add a welcome label
        JLabel welcomeLabel = new JLabel("Welcome to Security App", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        homePanel.add(welcomeLabel);

        // Add a button for Login
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        homePanel.add(loginButton);

        // Add a button for SOS
        JButton sosButton = new JButton("SOS");
        sosButton.setFont(new Font("Arial", Font.PLAIN, 16));
        sosButton.setForeground(Color.WHITE);
        sosButton.setBackground(Color.RED);
        homePanel.add(sosButton);

        // Add a button for Settings
        JButton settingsButton = new JButton("Settings");
        settingsButton.setFont(new Font("Arial", Font.PLAIN, 16));
        homePanel.add(settingsButton);

        // Add an Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the application
            }
        });
        homePanel.add(exitButton);

        // Add action listeners for the buttons
        loginButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Login feature coming soon!"));
        sosButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "SOS Alert Sent!"));
        settingsButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Settings feature coming soon!"));

        // Add the panel to the frame
        frame.add(homePanel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
