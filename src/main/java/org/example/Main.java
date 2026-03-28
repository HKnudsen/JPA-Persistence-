package org.example;

import org.example.DAO.AnsattDAO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        AnsattDAO ansattDAO = new AnsattDAO();
        System.out.println(ansattDAO.findAnsattWithPk(1));
        ansattDAO.setAnsattStilling(1, "Logistics Coordinator");
        System.out.println(ansattDAO.findAnsattWithPk(1));
        Ansatt ny = new Ansatt("csn", "Camilla", "Solheim", "2020-01-10", "Leder", 100000);
        ansattDAO.createAnsatt(ny);
        System.out.println(ansattDAO.fetchAllAnsatt());
    }
}
