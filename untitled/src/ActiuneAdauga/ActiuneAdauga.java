package ActiuneAdauga;

import java.awt.event.ActionListener;

public class ActiuneAdauga implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        // Adăugăm o nouă dronă în ArrayList
        String identificatorUnic = campIdentificatorUnic.getText();
        double razaMaximaDeZbor = Double.parseDouble(campRazaDeZbor.getText());
        String tipUnic = campTipUnic.getText();

        colectieDrona.add(new ZborDrone(identificatorUnic, razaMaximaDeZbor, tipUnic));

        campIdentificatorUnic.setText("");
        campRazaDeZbor.setText("");
        campTipUnic.setText("");
    }
}
