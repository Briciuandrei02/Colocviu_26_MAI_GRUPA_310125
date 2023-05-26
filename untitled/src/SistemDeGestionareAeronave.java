import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;

// Clasa pentru sistemul de gestionare a dronei
public class SistemDeGestionareAeronave {
    private JTextField campIdentificatorUnic;
    private JTextField campRazaDeZbor;
    private JTextField campTipUnic;
    private JTextArea zonaAfisareInformatii;
    private ArrayList<ZborDrone> colectieDrona;

    // Constructorul clasei
    public SistemDeGestionareAeronave() {
        // Inițializăm ArrayList-ul și interfața grafică
        colectieDrona = new ArrayList<>();
        creeazaInterfataGrafica();
    }

    // Metoda pentru a crea interfața grafică
    private void creeazaInterfataGrafica() {
        // Inițializăm componentele interfeței grafice
        // Declaram componentele interfeței grafice și ArrayList-ul pentru stocarea dronelor
        JFrame cadruPrincipal = new JFrame("Sistem de Gestionare Aeronave");
        cadruPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cadruPrincipal.setLayout(new FlowLayout());

        campIdentificatorUnic = new JTextField(20);
        campRazaDeZbor = new JTextField(20);
        campTipUnic = new JTextField(20);
        zonaAfisareInformatii = new JTextArea(10, 30);

        // Creăm butoanele și adăugăm ActionListener pentru fiecare buton
        JButton butonAdauga = new JButton("Adaugă aeronava");
        butonAdauga.addActionListener(new ActiuneAdauga1());

        JButton butonCauta = new JButton("Caută");
        butonCauta.addActionListener(new ActiuneCauta());

        JButton butonAfisare = new JButton("Afișează toate aeronavele");
        butonAfisare.addActionListener(new ActiuneAfisare());

        JButton butonSalveaza = new JButton("Salvează");
        butonSalveaza.addActionListener(new ActiuneSalveaza());

        JButton butonIncarca = new JButton("Încarcă");
        butonIncarca.addActionListener(new ActiuneIncarca());

        // Adăugăm componentele în cadru
        cadruPrincipal.add(new JLabel("Model: "));
        cadruPrincipal.add(campIdentificatorUnic);
        cadruPrincipal.add(new JLabel("Raza maxima de zbor (km): "));
        cadruPrincipal.add(campRazaDeZbor);
        cadruPrincipal.add(new JLabel("Tip: "));
        cadruPrincipal.add(campTipUnic);
        cadruPrincipal.add(butonAdauga);
        cadruPrincipal.add(butonCauta);
        cadruPrincipal.add(butonAfisare);
        cadruPrincipal.add(butonSalveaza);
        cadruPrincipal.add(butonIncarca);
        cadruPrincipal.add(new JScrollPane(zonaAfisareInformatii));

        // Ambalăm fereastra pentru a se potrivi cu dimensiunea preferată a tuturor componentelor și o facem vizibilă
        cadruPrincipal.pack();
        cadruPrincipal.setVisible(true);
    }

    // Acțiunea pentru butonul de adăugare
    class ActiuneAdauga1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Creăm o nouă dronă și o adăugăm în ArrayList
            String identificatorUnic = campIdentificatorUnic.getText();
            double razaMaximaDeZbor = Double.parseDouble(campRazaDeZbor.getText());
            String tipUnic = campTipUnic.getText();

            colectieDrona.add(new ZborDrone(identificatorUnic, razaMaximaDeZbor, tipUnic));

            // Resetăm câmpurile de text
            campIdentificatorUnic.setText("");
            campRazaDeZbor.setText("");
            campTipUnic.setText("");
        }
    }

    // Acțiunea pentru butonul de căutare
    class ActiuneCauta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Căutăm o dronă după model
            String identificatorUnic = campIdentificatorUnic.getText();
            for (ZborDrone drona : colectieDrona) {
                if (drona.getIdentificatorUnic().equalsIgnoreCase(identificatorUnic)) {
                    zonaAfisareInformatii.setText(drona.toString());
                    return;
                }
            }
            zonaAfisareInformatii.setText("Drona cu modelul " + identificatorUnic + " nu a fost găsită.");
        }
    }

    // Acțiunea pentru butonul de afișare
    class ActiuneAfisare implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Afișăm toate dronele
            StringBuilder sb = new StringBuilder();
            for (ZborDrone drona : colectieDrona) {
                sb.append(drona.toString()).append("\n");
            }
            zonaAfisareInformatii.setText(sb.toString());
        }
    }

    // Acțiunea pentru butonul de salvare
    class ActiuneSalveaza implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Salvăm lista de drone într-un fișier
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dronedata.bin"))) {
                oos.writeObject(colectieDrona);
                zonaAfisareInformatii.setText("Datele au fost salvate cu succes.");
            } catch (IOException ex) {
                ex.printStackTrace();
                zonaAfisareInformatii.setText("A apărut o eroare la salvarea datelor.");
            }
        }
    }

    // Acțiunea pentru butonul de încărcare
    class ActiuneIncarca implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Încărcăm lista de drone dintr-un fișier
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dronedata.bin"))) {
                colectieDrona = (ArrayList<ZborDrone>) ois.readObject();
                zonaAfisareInformatii.setText("Datele au fost încărcate cu succes.");
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
                zonaAfisareInformatii.setText("A apărut o eroare la încărcarea datelor.");
            }
        }
    }
    // Metoda main care pornește aplicația
    public static void main(String[] args) {
        // Se creează și se execută interfața grafică în firul de execuție al interfeței grafice (EDT)
        SwingUtilities.invokeLater(() -> new SistemDeGestionareAeronave());
    }
}



