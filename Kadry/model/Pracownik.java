package Kadra.Model;
//Kadra.Kadry z metodą main oraz klasę Pracownik z następującymi polami:
//        imię – typu String;
//        nazwisko – typu String;
//        placa – typu int;
//        plec – typu char;
//        dzial – typu int;
//        1. Klasę Pracownik wyposażyć w konstruktor, którego parametry umożliwią przypisanie wartości
//        wszystkim polom klasy.

public class Pracownik {
private String name;
private String surname;
private int placa;
private char plec;
private int dzial;



    public Pracownik(String name, String surname, int placa, char plec, int dzial) {
        this.name = name;
        this.surname = surname;
        this.placa = placa;
        this.plec = plec;
        this.dzial = dzial;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPlaca() {
        return placa;
    }

    public char getPlec() {
        return plec;
    }

    public int getDzial() {
        return dzial;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", placa=" + placa +
                ", plec=" + plec +
                ", dzial=" + dzial +
                '}';
    }
}

