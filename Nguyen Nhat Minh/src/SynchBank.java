/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ami
 */
public class SynchBank {
    public static void main(String[] args) {
        Bank bank = new Bank(100, 1000);
        for (int i = 0; i < 100; i++) {
            TransferMoney transferMoney = new TransferMoney(bank, i, 100);
            Thread thread = new Thread(transferMoney);
            thread.start();
        }
    }
}
