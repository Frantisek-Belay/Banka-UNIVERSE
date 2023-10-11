package org.example;

import java.util.Scanner;

/** Toto je deklarace balíčku, ve kterém je třída `Transakce` uložena. Balíček slouží k organizaci tříd v rámci projektu. */

class Transakce {   /** Začátek definice třídy `Transakce`. Třída obsahuje atributy a metody pro reprezentaci a manipulaci s jednou transakcí. */
Scanner scanner = new Scanner(System.in, "Windows-1250");  /** Definuje znakovou sadu */
private String typ;     /** Deklarace privátního atributu `typ`, který reprezentuje typ transakce (např. "vklad", "výběr" apod).
 Tento atribut je viditelný pouze v rámci třídy `Transakce`. */
    private double castka;  /** Deklarace privátního atributu `castka`, který reprezentuje částku transakce.
 Tento atribut je také viditelný pouze v rámci třídy `Transakce`. */

    public Transakce(String typ, double castka) {   /** Definice konstruktoru třídy `Transakce`,
     který umožňuje vytvářet instance této třídy s konkrétními hodnotami pro atributy `typ` a `castka`.
     Konstruktor je veřejný (`public`), což znamená, že je dostupný i mimo třídu. */
        this.typ = typ;         /** V konstruktoru se přiřazují hodnoty parametrů `typ` a `castka` do odpovídajících atributů třídy. */
        this.castka = castka;
    }

    @Override   /**  Toto je anotace, která označuje přepsání metody z nadřazené třídy (v tomto případě metody `toString`).
     Tato anotace informuje kompilátor o záměru přepsání metody. */
    public String toString() {  /** Definice metody `toString`, která je přepsána z nadřazené třídy. Tato metoda vrací textovou reprezentaci objektu třídy `Transakce`. */
        return typ + ": " + castka; /** Tato část kódu vrací textový řetězec, který obsahuje hodnoty atributů `typ` a `castka`.
         Tento řetězec bude použit při konverzi objektu `Transakce` na textový řetězec. */
    }
}   /** Konec definice třídy `Transakce` pomocí závorky `}`. */
