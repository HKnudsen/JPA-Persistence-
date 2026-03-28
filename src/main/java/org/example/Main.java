package org.example;

import org.example.DAO.AnsattDAO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        AnsattDAO ansattDAO = new AnsattDAO();
        System.out.println(ansattDAO.finnAnsattMedPk(1));
    }
}
