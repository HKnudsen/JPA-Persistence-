package org.example;

import org.example.DAO.AnsattDAO;
import org.example.DAO.AvdelingDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner s               = new Scanner(System.in);
        AnsattDAO ansattDAO     = new AnsattDAO();
        AvdelingDAO avdelingDAO = new AvdelingDAO();

        boolean run = true;
        while (run) {
            System.out.println("1 - Søk etter ansatt med ID76");
            System.out.println("2 - Søk etter ansatt med Brukernavn");
            System.out.println("3 - Søk etter ansatt med Etternavn");
            System.out.println("4 - Skriv ut alle ansatte");
            System.out.println("5 - Oppdater ansatt sin lønn");
            System.out.println("6 - Legg til ny ansatt");
            System.out.println("7 - Hent ansatte fra avdeling");
            System.out.println("8 - Oppdater ansatt sin avdeling");

            int valg = s.nextInt();
            s.nextLine();

            switch (valg) {
                case 1:
                    System.out.println("Skriv inn ID: ");
                    System.out.println(ansattDAO.findAnsattWithPk(s.nextInt()));
                    s.nextLine();
                    break;
                case 2:
                    System.out.println("Skriv inn brukernavn: ");
                    System.out.println(ansattDAO.findAnsattWithUsername(s.nextLine()));
                    break;
                case 3:
                    System.out.println("Skriv inn etternavn: ");
                    List<Ansatt> ansatte = ansattDAO.findAnsattWithSurname(s.nextLine());
                    for (Ansatt a : ansatte) System.out.println(a);
                    break;
                case 4:
                    List<Ansatt> alleAnsatte = ansattDAO.fetchAllAnsatt();
                    for (Ansatt a : alleAnsatte) System.out.println(a);
                    break;
                case 5:
                    System.out.println("Ansatt ID å redigere: ");
                    int id = s.nextInt();
                    s.nextLine(); // Fjerne nextline
                    System.out.println("Ny lønn: ");
                    int lonn = s.nextInt();
                    ansattDAO.setAnsattLonn(id, lonn);
                    break;
                case 6:
                    System.out.println("Brukernavn: ");
                    String brukernavn = s.nextLine();
                    System.out.println("Fornavn: ");
                    String fornavn = s.nextLine();
                    System.out.println("Etternavn: ");
                    String etternavn = s.nextLine();
                    System.out.println("Ansatt dato");
                    String ansattDato = s.nextLine();
                    System.out.println("Stilling: ");
                    String stilling = s.nextLine();
                    System.out.println("Lønn: ");
                    int lønn = s.nextInt();
                    s.nextLine();
                    System.out.println("Avdeling: ");
                    int avdeling = s.nextInt();
                    s.nextLine();
                    Ansatt ny = new Ansatt(brukernavn, fornavn, etternavn, ansattDato, stilling, lønn);
                    ansattDAO.createAnsatt(ny, avdeling);
                    break;
                case 7:
                    System.out.println("Enter avd ID: ");
                    int avdId = s.nextInt();
                    s.nextLine();
                    avdelingDAO.hentAnsatteIAvdeling(avdId);
                    break;
                case 8:
                    System.out.println("Ansatt ID: ");
                    id = s.nextInt();
                    s.nextLine();
                    System.out.println("Set til avdeling ID: ");
                    int depIp = s.nextInt();
                    s.nextLine();
                    ansattDAO.UpdateDepartmentForUser(id, depIp);
                    System.out.println(ansattDAO.findAnsattWithPk(id));
                    break;
            }
        }
    }
}
