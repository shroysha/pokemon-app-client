package dev.shroysha.pokemon.app.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class PokemonBattleFrame extends JFrame {

    private final JPanel battlePanel = new JPanel();
    private final JPanel buttonBar = new JPanel(new GridLayout(1, 4, 10, 10));
    private final JButton attackButton = new JButton("Attack");
    private final JButton itemButton = new JButton("Items");
    private final JButton pokemonButton = new JButton("Pokemon");
    private final JButton escapeButton = new JButton("Escape");

    public PokemonBattleFrame() {
        super("Pokemon");
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 200, 0, 0);
        this.setSize(400, 350);
        this.setResizable(false);

        attackButton.setMnemonic(KeyEvent.VK_A);
        pokemonButton.setMnemonic(KeyEvent.VK_P);
        itemButton.setMnemonic(KeyEvent.VK_I);
        escapeButton.setMnemonic(KeyEvent.VK_E);

        buttonBar.add(attackButton);
        buttonBar.add(itemButton);
        buttonBar.add(pokemonButton);
        buttonBar.add(escapeButton);

        this.setLayout(new BorderLayout());
        this.add(battlePanel, BorderLayout.CENTER);
        this.add(buttonBar, BorderLayout.SOUTH);
    }
}
