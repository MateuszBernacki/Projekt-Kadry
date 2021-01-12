package Kadra.service;
import Kadra.Kadry;
import Kadra.Model.Pracownik;
import Kadra.dao.Baza;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PracownicyService {
    Baza baza = Kadry.getBaza();

    public void dodajPracownika() {
        String name;
        String surname;
        int placa;
        char plec;
        int dzial;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imie pracownika: ");
        name = scanner.nextLine();
        System.out.println("Podaj nazwisko pracownika: ");
        surname = scanner.nextLine();
        System.out.println("Podaj Płace pracownika: ");
        placa = scanner.nextInt();
        System.out.println("Podaj plec M/K: ");
        plec = scanner.next().charAt(0);
        System.out.println("Podaj dział pracownika: ");
        dzial = scanner.nextInt();

        Pracownik pracownik = new Pracownik(name, surname, placa, plec, dzial);
        baza.dodajPracownika(pracownik);
    }

    public void wyszukiwaniePracDoUsuniecia() {
        String name;
        String surname;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aby usunąć pracownika podaj: \n  Imie pracownika: ");
        name = scanner.nextLine();
        System.out.println("Nazwisko pracownika: ");
        surname = scanner.nextLine();
        System.out.println("Płace pracownika: ");

        Pracownik pracownikDoUsuniecia = null;

        boolean jestPracownikDoUsuniecia = false;
        for (Pracownik pracownik : baza.getPracownicy()) {
            if ((pracownik.getName().equals(name) && pracownik.getSurname().equals(surname))) {
                System.out.println("Znalazlem Pracownika: " + pracownik.getName() + pracownik.getSurname() + pracownik.getPlaca() + pracownik.getPlec() + pracownik.getDzial());
                pracownikDoUsuniecia = pracownik;
                jestPracownikDoUsuniecia = true;
            }
        }
        if (jestPracownikDoUsuniecia) baza.usunPracownika(pracownikDoUsuniecia);
        else System.out.println("Nie ma takiego pracownika.");
    }

    public void pokazPracownikow(List<Pracownik> pracowniks) {
        String name;
        String surname;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aby znaleść pracownika podj: \n  Imie pracownika: ");
        name = scanner.nextLine();
        System.out.println("Nazwisko pracownika: ");
        surname = scanner.nextLine();

        for (Pracownik pracownik : pracowniks) {
            if (pracownik.getName().equals(name) && pracownik.getSurname().equals(surname))
                System.out.println(pracownik);
        }
    }
}

