package org.buildcode;

public class Main {
    public static void main(String[] args) {
        VendingMachine machine = VendingMachine.getINSTANCE();

        machine.insertMoney(100.0);
        machine.pressButton(1);
        machine.dispenseProduct(1);
    }
}