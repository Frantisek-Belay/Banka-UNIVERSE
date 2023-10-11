package org.example;    /** Toto je deklarace balíčku, ve kterém je třída `BankovyUcet` uložena.
 Balíček slouží k organizaci tříd v rámci projektu.
 */

import java.util.ArrayList;
import java.util.Scanner;

/** Importuje třídu `ArrayList` z balíčku `java.util`.
 `ArrayList` je používán k ukládání seznamu transakcí spojených s bankovním účtem.
 */

class BankovyUcet { /** Začátek definice třídy `BankovyUcet`. Třída `BankovyUcet` reprezentuje bankovní účet a obsahuje atributy a metody pro práci s ním.*/
 Scanner scanner = new Scanner(System.in, "Windows-1250");  /** Definuje znakovou sadu */

    private String jmeno;   /** Deklarace privátního atributu `jmeno`, který reprezentuje jméno majitele účtu.  */
    private double zustatek;    /** Deklarace privátního atributu `zustatek`, který reprezentuje aktuální zůstatek na účtu.  */
    private ArrayList<Transakce> transakce; /** Deklarace privátního atributu `transakce`, který je typu `ArrayList<Transakce>`.
 Tento seznam bude sloužit k ukládání transakcí spojených s účtem.
 */

    public BankovyUcet(String jmeno) {  /** Definice konstruktoru třídy `BankovyUcet`.
     Konstruktor umožňuje vytvářet instance třídy `BankovyUcet` s konkrétním jménem.
     Při vytváření nového účtu se nastaví jméno, zůstatek na nule a vytvoří se prázdný seznam transakcí. */
        this.jmeno = jmeno;
        this.zustatek = 0.0;
        this.transakce = new ArrayList<>();
    }

    public String getJmeno() {  /** Definice veřejné metody `getJmeno()`, která umožňuje získat jméno majitele účtu. */
        return jmeno;
    }

    public double getZustatek() {   /** Definice veřejné metody `getZustatek()`, která umožňuje získat aktuální zůstatek na účtu. */
        return zustatek;
    }

    public void vlozPenize(double castka) { /** Definice veřejné metody `vlozPenize()`, která slouží k vkládání peněz na účet.
     Metoda zvyšuje zůstatek na účtu o zadanou částku a zaznamenává tuto transakci jako "Vklad" v seznamu transakcí. */
        zustatek += castka;
        transakce.add(new Transakce("Vklad", castka));
    }

    public boolean vyberPenize(double castka) { /** Definice veřejné metody `vyberPenize()`, která slouží k výběru peněz z účtu.
     Metoda ověřuje, zda je na účtu dostatek prostředků pro provedení výběru.
     Pokud ano, snižuje zůstatek na účtu a zaznamenává tuto transakci jako "Výběr" v seznamu transakcí.
     Pokud není dostatek prostředků, metoda vrátí `false`. */
        if (castka <= zustatek) {
            zustatek -= castka;
            transakce.add(new Transakce("Výběr", -castka));
            return true;
        }
        return false;
    }

    public void provedPrevod(BankovyUcet cilovyUcet, double castka) {   /** Definice veřejné metody `provedPřevod()`,
     která slouží k provádění převodu peněz z tohoto účtu na jiný účet.
     Metoda nejprve volá `vyberPenize()` pro snížení zůstatku na tomto účtu a poté volá `vlozPenize()` na cílovém účtu pro připsání peněz.
     Obě transakce jsou zaznamenány v seznamu transakcí. */

    if (vyberPenize(castka)) {
            cilovyUcet.vlozPenize(castka);
            transakce.add(new Transakce("Převod", -castka));
            cilovyUcet.transakce.add(new Transakce("Převod", castka));
        }
    }

    public void vypisTransakce() {  /** Definice veřejné metody `vypisTransakce()`, která slouží k výpisu seznamu transakcí spojených s tímto účtem.
     Metoda projde seznam transakcí a vypíše je na výstup. */
        System.out.println("Transakce pro účet " + jmeno + ":");
        for (Transakce t : transakce) {
            System.out.println(t);
        }
    }
}   /** Konec definice třídy `BankovyUcet` pomocí závorky `}` */

