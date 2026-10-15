package mx.unison.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FullScreenMode {

    public static void main(String[] args) {
        // 1. Crear un JFrame y configurarlo para que no tenga bordes ni barra de título
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agregar un KeyListener para detectar la combinación de teclas Ctrl + Q
        frame.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_Q)   &&
                        ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)) {
                    System.exit(0);
                }
            }
        });

        // Remover los bordes y la barra de títuloq
        frame.setUndecorated(true);
        frame.setResizable(false);

        // 2. obtenemos el GraphicsDevice y configuramos el JFrame para que ocupe toda la pantalla
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = ge.getDefaultScreenDevice();

        try {
            // 3. Activamos el modo de pantalla completa
            if (device.isFullScreenSupported()) {
                device.setFullScreenWindow(frame);
            } else {
                // Si no se puede usar el modo de pantalla completa, simplemente maximizamos la ventana
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
