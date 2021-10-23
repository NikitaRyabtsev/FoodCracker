package by.htp.example.view;

import by.htp.example.ServiceException;
import by.htp.example.util.Util;

import javax.naming.NamingException;
import java.time.DateTimeException;
import java.util.InputMismatchException;

public class ViewMenu {

    public void viewMenu() {
        int userChoose = 0;
        while (userChoose != 3) {
            try {
                showMenu();
                ViewMenuConsole viewMenuConsole = new ViewMenuConsole();
                ViewMenuEjb viewMenuEjb = new ViewMenuEjb();
                userChoose = Util.scanInt();
                switch (userChoose) {
                    case 1:
                        viewMenuConsole.viewMenuConsole();
                        break;
                    case 2:
                        viewMenuEjb.viewMenuEjb();
                        break;
                    case 3:
                        System.out.println("Goodbye");
                        break;
                    default:
                        System.out.println(">>>[Info] Wrong choose");
                }
            } catch (IllegalArgumentException | NamingException ex) {
                System.out.println("[ERROR] Something wrong in viewMenu");
            }
        }
    }

    private void showMenu() {
        System.out.println("Choose your options : ");
        System.out.println("1. Запуск с помощью console");
        System.out.println("2. Запуск с помощью ejb");
        System.out.println("3. Выход");

    }
}

