package ui.swing;

import domain.needForSpear.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class KeyboardController implements KeyListener {
    Controller controller = Controller.getInstance();
    Scanner scanner = new Scanner(System.in);

    public KeyboardController() { this.controller = controller; }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {  // ESC KEY

        }

        if(e.getKeyCode() == 39) controller.updateMovementNP("HeldRight");
        if(e.getKeyCode() == 37) controller.updateMovementNP("HeldLeft");

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Reserved for future use
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 39) controller.updateMovementNP("PressedRight");
        if(e.getKeyCode() == 37) controller.updateMovementNP("PressedLeft");
    }
}
