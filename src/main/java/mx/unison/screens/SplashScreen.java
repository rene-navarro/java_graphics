package mx.unison.screens;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {

    private JProgressBar progressBar;

    public SplashScreen() {
        super();

        JPanel content = new JPanel(new BorderLayout());
        content.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        JLabel title = new JLabel("Desarrollo de Sistemas III");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.LEFT);
        content.add(title, BorderLayout.NORTH);

        // Imagen que se mostrará en el splash screen
        JLabel imageLabel = new JLabel(new ImageIcon("img/LOGO-OJO-BUHO-AMARILLO.png"));
        content.add(imageLabel, BorderLayout.CENTER);

        // Barra de progreso que se mostrará en el splash screen
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(50, 150, 250));
        content.add(progressBar, BorderLayout.SOUTH);

        setContentPane(content);
        pack();

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }

    public void updateProgress(int progress, String message) {
        SwingUtilities.invokeLater(() -> {
            progressBar.setValue(progress);
            progressBar.setString(message);
        });
    }

    public static void main(String[] args) {
        // Mostrar el splash screen en el hilo de eventos de Swing
        SplashScreen splash = new SplashScreen();
        splash.setVisible(true);

        // Nada más para simular la carga de la aplicación, se puede usar un hilo
        // separado para actualizar la barra de progreso
        new Thread(() -> {
            try {
                for (int i = 0; i <= 100; i += 20) {
                    splash.updateProgress(i, "Cargando componentes... " + i + "%");
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Terminar
            SwingUtilities.invokeLater(() -> {
                JFrame mainFrame = new JFrame("Aplicación Principal");
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainFrame.setSize(800, 600);
                mainFrame.setLocationRelativeTo(null);

                // cerrrar el splash screen y abrir la ventana principal
                splash.setVisible(false);
                splash.dispose();

                // abrir la ventana principal
                mainFrame.setVisible(true);
            });
        }).start();
    }

}
