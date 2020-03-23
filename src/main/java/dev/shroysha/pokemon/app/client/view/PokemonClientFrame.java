package dev.shroysha.pokemon.app.client.view;

import dev.shroysha.pokemon.app.client.controller.PokemonClientController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PokemonClientFrame extends JFrame {

    public static final Font LOGIN_BUTTON_FONT = new Font("Tahoma", Font.BOLD, 18);
    public static final Font NEW_USER_LABEL_FONT = new Font("Tahoma", Font.BOLD, 12);

    private final JPanel contentPanel = new JPanel();
    private final JLabel newUserLabel = new JLabel("New User");
    private final JTextField trainerNameField = new JTextField();
    private final JButton loginButton = new JButton("Login");
    private JLabel pokeballImageLabel = new JLabel(new ImageIcon(getClass().getResource("/pokemonclient/pokeball.gif")));

    public PokemonClientFrame() {
        super("Pokemon");
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton.setFont(LOGIN_BUTTON_FONT);
        newUserLabel.setFont(NEW_USER_LABEL_FONT);

        loginButton.setBackground(Color.black);
        contentPanel.setBackground(Color.black);
        newUserLabel.setForeground(Color.white);

        this.setLayout(new BorderLayout());
        this.add(contentPanel, BorderLayout.CENTER);

        int xBound = ((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - (this.getWidth() / 2);
        int yBound = ((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - (320 / 2);
        this.setBounds(new Rectangle(xBound, yBound, this.getWidth(), this.getHeight()));
        this.setResizable(false);
        this.getRootPane().setDefaultButton(loginButton);

        loginButton.addActionListener(this::loginButtonActionPerformed);
    }

    public void loginButtonActionPerformed(ActionEvent event) {

        SwingUtilities.invokeLater(() -> {
            String trainerName = trainerNameField.getText().trim();

            try {
                PokemonClientController.trainerCreate(trainerName);
                this.setVisible(false);
                new PokemonBattleFrame().setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

    }

}
