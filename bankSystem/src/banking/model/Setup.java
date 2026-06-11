package banking.model;


// Det här en hjälpverktyg och ingen krav för den labben

import banking.model.UserDatabase;

public class Setup {
    public static void main(String[] args) {
        UserDatabase db = new UserDatabase();
        db.processUsersFromTxt(); // Läser users.txt, validerar, serialiserar
        System.out.println("users.txt har bearbetats och users.ser skapats.");
    }
}
