package org.example;        /** Toto je deklarace balíčku, ve kterém je třída `Banka5` uložena. Balíček slouží k organizaci tříd v rámci projektu. */

import java.util.Scanner;   /** Importuje třídu `Scanner` z balíčku `java.util`, která umožňuje čtení vstupu od uživatele. */
import java.util.InputMismatchException;    /** Importuje třídu `InputMismatchException` z balíčku `java.util`,
                                            která reprezentuje výjimku při chybném vstupu od uživatele. */

public class Banka5 {   /** Začátek definice třídy `Banka5`. Třída obsahuje veškerý kód pro tuto bankovní aplikaci. */
    private static BankovyUcet[] ucty = new BankovyUcet[5]; /** Deklarace a inicializace pole `ucty`, které bude uchovávat bankovní účty.
                                                            V tomto případě je inicializováno pole s kapacitou 5 účtů. */

    public static void main(String[] args) {        /**  Začátek definice hlavní metody `main`. Tato metoda se spouští při spuštění programu */

    Scanner scanner = new Scanner(System.in, "Windows-1250");;   /**  Vytvoření instance třídy `Scanner` pro čtení vstupu od uživatele prostřednictvím standardního vstupu (`System.in`). */
/** Definuje znakovou sadu */
        System.out.println("**********************************");
        System.out.println("*    Vítejte v bance UNIVERSE    *");
        System.out.println("**********************************");

        for (int i = 0; i < ucty.length; i++) {     /** Zde začíná cyklus pro vytvoření bankovních účtů.
                                                    Procházíme pole `ucty` a pro každý účet se ptáme na jméno a vytváříme instanci třídy `BankovyUcet`,
                                                    kterou ukládáme do pole. */
            System.out.print("Zadejte jméno " + (i + 1) + ". účtu: ");
            String jmeno = scanner.next();
            ucty[i] = new BankovyUcet(jmeno);
        }

        while (true) {  /** Toto je nekonečný cyklus, který umožňuje uživatelům pracovat s účty, dokud nezvolí možnost ukončení programu. */
            System.out.println("**********************************");
            System.out.println("*          HLAVNÍ MENU:          *");
            System.out.println("**********************************");
            System.out.println("*       1 - Výběr účtu           *");
            System.out.println("*       2 - Konec programu       *");
            System.out.println("**********************************");
            System.out.print("Zadejte číslo vašeho požadavku: ");

            try {   /** Začátek bloku `try`, který obsahuje kód pro čtení volby od uživatele a zpracování chyb vstupu. */
                int volba = scanner.nextInt();  /** Čtení volby od uživatele jako celého čísla. */
                if (volba == 1) {   /** Větve `if` a `else if` reagují na volbu uživatele a volají příslušné metody pro práci s účty. */
                    int cisloUctu = vyberCisloUctu(ucty, scanner);
                    if (cisloUctu != -1) {
                        pracujSUctem(ucty[cisloUctu], scanner);
                    }
                } else if (volba == 2) {
                    break;
                } else {
                    System.out.println("Neplatná volba. Zkuste to znovu.");
                }
            } catch (InputMismatchException e) {    /** Začátek bloku `catch`, který zpracovává výjimku, která nastane, pokud uživatel zadá neplatný vstup (např. nečíselný znak). */
                System.out.println("Chyba: Musíte zadat číslo z menu.");    /** Výpis chybové zprávy, pokud uživatel zadá neplatný vstup. */
                scanner.next(); /** Vyčistí zbytek vstupu od neplatného vstupu od uživatele.*/
            }   /** Konec `catch` bloku a návrat na začátek hlavního nekonečného cyklu. */
        }
    }

    public static int vyberCisloUctu(BankovyUcet[] ucty, Scanner scanner) { /** Začátek definice metody `vyberCisloUctu`, která umožňuje uživateli vybrat účet pro práci. */
        System.out.println("**********************************");
        System.out.println("*         Seznam účtů:           *");
        System.out.println("**********************************");
        for (int i = 0; i < ucty.length; i++) {
            System.out.println((i + 1) + " - " + ucty[i].getJmeno());
        }
        System.out.println("**********************************");
        System.out.println("Zadejte pořadové číslo účtu:");
        System.out.println("**********************************");
        int cisloUctu = scanner.nextInt();  /** Čtení čísla účtu od uživatele. */

        if (cisloUctu >= 1 && cisloUctu <= ucty.length) {   /** Větve `if` a `else` kontrolují platnost vstupu od uživatele a vracejí index vybraného účtu. */
            System.out.println("Nyní pracujete s účtem č. " + cisloUctu + ". " + ucty[cisloUctu - 1].getJmeno());
            return cisloUctu - 1;
        } else {
            System.out.println("Neplatné číslo účtu.");
            return -1;
        }
    }

    public static void pracujSUctem(BankovyUcet ucet, Scanner scanner) {    /** Začátek definice metody `pracujSUctem`, která umožňuje uživateli provádět operace s bankovním účtem. */
        while (true) {
            System.out.println("**********************************");
            System.out.println("*        Podmenu účtu:           *");
            System.out.println("**********************************");
            System.out.println("* 1 - Vložit peníze              *");
            System.out.println("* 2 - Vybrat peníze              *");
            System.out.println("* 3 - Převod peněz na jiný účet  *");
            System.out.println("* 4 - Výpis transakcí            *");
            System.out.println("* 5 - Zobrazit zůstatek          *");
            System.out.println("* 6 - Konec podmenu              *");
            System.out.println("**********************************");

            System.out.print("Zadejte číslo vašeho požadavku: ");
            int volba = scanner.nextInt();  /** Čtení volby od uživatele v rámci podmenu. */

            switch (volba) {    /** Blok `switch` reaguje na volbu uživatele a provádí příslušné operace s bankovním účtem. */
                case 1:     /** Větve `case` odpovídají různým operacím, jako je vkládání peněz, výběr peněz, převod peněz a další. */
                    System.out.print("Zadejte částku k vložení: ");
                    double castkaVklad = scanner.nextDouble();
                    ucet.vlozPenize(castkaVklad);
                    break;
                case 2:
                    System.out.print("Zadejte částku k výběru: ");
                    double castkaVyber = scanner.nextDouble();
                    boolean uspesnyVyber = ucet.vyberPenize(castkaVyber);
                    if (!uspesnyVyber) {
                        System.out.println("Nedostatek prostředků na účtu.");
                    }
                    break;
                case 3:
                    int cilovyUcetIndex = vyberCisloUctu(ucty, scanner);
                    if (cilovyUcetIndex != -1) {
                        BankovyUcet cilovyUcet = ucty[cilovyUcetIndex];
                        System.out.print("Zadejte částku k převodu: ");
                        double castkaPrevod = scanner.nextDouble();
                        ucet.provedPrevod(cilovyUcet, castkaPrevod);
                        System.out.println("Nyní pracujete s účtem č. " + (cilovyUcetIndex + 1) + ". " + cilovyUcet.getJmeno());
                    }
                    break;

                case 4:
                    ucet.vypisTransakce();
                    break;
                case 5:
                    System.out.println("Zůstatek na účtu: " + ucet.getZustatek());
                    break;
                case 6:
                    return;
                default:    /** `default` větev reaguje na neplatnou volbu uživatele. */
                    System.out.println("Neplatná volba. Zkuste to znovu.");
            } /** Návrat na začátek podmenu a možnost opakovat operace s účtem. */
        }     /** Konec `while` smyčky pro podmenu. */
    }
}             /** Konec definice třídy `Banka5`. */

