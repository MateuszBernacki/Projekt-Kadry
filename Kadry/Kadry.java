package Kadra;
import Kadra.Model.Pracownik;
import Kadra.dao.Baza;
import Kadra.service.PracownicyService;
import java.util.List;
import java.util.Scanner;
//Napisać program Kadra.Kadry do zarządzania danymi pracowników. W tym celu należy utworzyć klasę
//        Kadra.Kadry z metodą main oraz klasę Pracownik z następującymi polami:
//        imię – typu String;
//        nazwisko – typu String;
//        placa – typu int;
//        plec – typu char;
//        dzial – typu int;
//        1. Klasę Pracownik wyposażyć w konstruktor, którego parametry umożliwią przypisanie wartości
//        wszystkim polom klasy.
//        2. W klasie Kadra.Kadry napisać metodę statyczną o nazwie srednieZarobki, której parametrem jest tablica
//        pracowników, numer działu oraz płeć, a wynikiem średnia płaca osób pracujących w dziale
//        o podanym numerze oraz o podanej płci.
//        3. W klasie Kadra.Kadry napisz statyczną metodę pokazPracownikow, której zadaniem będzie wyświetlenie danych
//        wszystkich pracowników. Jako parametr metody ma być przekazywana lista pracowników.
//        Rozszerzenie funkcjonalności programu:
//        4. W klasie Kadra.Kadry dopisz metodę statyczną menu(), która będzie wyświetlać okno główne programu Kadra.Kadry
//        - 1 Lista wszystkich pracowników
//        - 2 Dodaj pracownika do bazy
//        - 3 Usuń pracownika z bazy
//        - 4 Znajdź pracownika po imieniu i nazwisku
//        - 5 Wyjście z programu
//        5. W klasie Kadra.Kadry dopisz brakujące statyczne metody realizujące wszystkie funkcjonalności
//        menu programu.
//        Pakiety:
//        - Kadra.service
//        - Kadra.dao
//        - model

public class Kadry {
    static Baza baza;
    static PracownicyService service;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //PracownicyService service = new PracownicyService();
        baza = new Baza();
        service = new PracownicyService();

        Pracownik pracownik1 = new Pracownik("Jan", "Kowalski", 3000, 'M', 2);
        Pracownik pracownik2 = new Pracownik("Piotr", "Nowak", 3500, 'M', 2);

        baza.dodajPracownika(pracownik1);
        baza.dodajPracownika(pracownik2);
        System.out.println("Srednie zarobki dzialu 2 wynosza: " + srednieZarobki(baza.getPracownicy(), 2, 'M'));
        pokazPracownikow(baza.getPracownicy());
        System.out.println();

        for (int i = 0; ; i++) {
            int h = 0;
            System.out.println();
            wyswietlMenu();
            int opcjaMenu;
            opcjaMenu = scanner.nextInt();
            switch (opcjaMenu) {
                case 1:
                    pokazPracownikow(baza.getPracownicy());
                    break;
                case 2:
                    service.dodajPracownika();
                    break;
                case 3:
                    service.wyszukiwaniePracDoUsuniecia();
                    break;
                case 4:
                    service.pokazPracownikow(baza.getPracownicy());
                    break;
                case 5:
                    h = 1;
                    System.out.println("Exit bye.");
                    break;
                default:
                    System.out.println("Taki wybór nie jstnieje.");
                    break;
            }
            if (h == 1) break;
        }
    }

    public static float srednieZarobki(List<Pracownik> pracownicy, int dziail, char plec) {
        int sumaZarobkow = 0;
        int iloscPracownikowDzialu = 0;
        for (Pracownik pracownik : pracownicy) {
            if ((pracownik.getDzial() == dziail) && (pracownik.getPlec() == plec)) {
                sumaZarobkow += pracownik.getPlaca();
                iloscPracownikowDzialu++;
            }
        }
        return sumaZarobkow / (float) iloscPracownikowDzialu;
    }

    public static void pokazPracownikow(List<Pracownik> pracowniks) {
        for (Pracownik pracownik : pracowniks) {
            System.out.println(pracownik);
        }
    }

    public static void wyswietlMenu() {
        System.out.println(
                "------------Kadra.Kadry---------------\n" +
                        "- 1 Lista wszystkich pracowników\n" +
                        "- 2 Dodaj pracownika do bazy\n" +
                        "- 3 Usuń pracownika z bazy\n" +
                        "- 4 Znajdź pracownika po imieniu i nazwisku\n" +
                        "- 5 Wyjście z programu");

    }

    public static Baza getBaza() {
        return baza;
    }
}

