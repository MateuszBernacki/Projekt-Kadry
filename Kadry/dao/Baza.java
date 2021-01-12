package Kadra.dao;
import Kadra.Model.Pracownik;
import java.util.ArrayList;
import java.util.List;

public class Baza {
    List<Pracownik> pracownicy = new ArrayList<>();

    public void dodajPracownika(Pracownik pracownik) {
        pracownicy.add(pracownik);
    }
    public void usunPracownika(Pracownik pracownik) {
        pracownicy.remove(pracownik);
    }

    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(List<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }
}


