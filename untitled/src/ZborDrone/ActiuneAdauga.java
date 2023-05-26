import java.io.Serializable;

// Clasa ZborDrone care implementeaza interfata Serializable pentru a putea fi serializata
class ZborDrone implements Serializable {
    private String identificatorUnic;//modelul dronei
    private double razaMaximaDeZbor;//acel maximum_flight_range
    private String tipUnic;//tipul dronei

    public ZborDrone(String identificatorUnic, double razaMaximaDeZbor, String tipUnic) {
        this.identificatorUnic = identificatorUnic;
        this.razaMaximaDeZbor = razaMaximaDeZbor;
        this.tipUnic = tipUnic;
    }

    // getteri si setteri
    public String getIdentificatorUnic() {
        return identificatorUnic;
    }

    public double getRazaMaximaDeZbor() {
        return razaMaximaDeZbor;
    }

    public String getTipUnic() {
        return tipUnic;
    }

    @Override
    public String toString() {
        return "Model: " + identificatorUnic + ", Raza Maxima de Zbor: " + razaMaximaDeZbor + ", Tip: " + tipUnic;
    }
}
