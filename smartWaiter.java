import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class smartWaiter {

    static double total = 0;
    static double t1=0;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Kamarieret");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6,3 ));

        String[] kamarieret = {"Ardi", "Bledi", "Erisa", "Sara"};

        for (int i = 0; i < kamarieret.length; i++) {

            String emri = kamarieret[i];

            JButton btn = new JButton(emri);


            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    hapMenu(emri);
                }
            });

            frame.add(btn);
        }

        frame.setVisible(true);
    }

    public static void hapMenu(String kamarieri) {

        JFrame menu = new JFrame("Menu - " + kamarieri);
        menu.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        String[] produkte = {
                "Kafe", "Caj", "Uje", "Birre",
                "Coca Cola", "Fanta", "Red Bull","Golden EAGLE",
                "Sanduic", "Pice", "Hamburger"
        };

        int[] cmime = {
                100, 80, 50, 200,
                150, 150, 120,
                250, 500, 400,600,400
        };

        JLabel totalLabel = new JLabel("Totali: 0 Lek");

        for (int i = 0; i < produkte.length; i++) {

            String produkt = produkte[i];

            int cmimi = cmime[i];

            JPanel p2 = new JPanel();

            JLabel label = new JLabel(produkt + "  " + cmimi + "Lek");

            JTextField sasia= new JTextField(5);

            JButton add = new JButton("Add");
            JLabel l1= new JLabel("");

            add.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    try {
                        int nr = Integer.parseInt(sasia.getText());

                        t1=t1+nr*cmimi;
                        l1.setText(produkt +""+ t1 +"Lek");

                        total = total + nr * cmimi;

                        totalLabel.setText("Totali: " + total + " Lek");

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(menu, "Vendos sasine (numer)!");
                    }
                }
            });

            p2.add(label);
            p2.add(new JLabel("Sasia:"));
            p2.add(sasia);
            p2.add(add);
            p2.add(l1);

            panel.add(p2);
        }

        JScrollPane scroll = new JScrollPane(panel);

        menu.add(scroll, BorderLayout.CENTER);
        menu.add(totalLabel, BorderLayout.SOUTH);

        menu.setVisible(true);
    }
}