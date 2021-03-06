package by.htp.example.view;

import by.htp.example.soap.ServiceException_Exception;
import by.htp.example.util.Util;

import javax.naming.NamingException;

public class ViewMenu {

    public void viewMenu() {
        int userChoose = 0;
        showMenu();
        userChoose = Util.scanInt();
        while (userChoose < 6) {
            try {
                ViewMenuConsole viewMenuConsole = new ViewMenuConsole();
                ViewMenuEjb viewMenuEjb = new ViewMenuEjb();
                ViewMenuRest viewMenuRest = new ViewMenuRest();
                ViewMenuSoap viewMenuSoap = new ViewMenuSoap();
                switch (userChoose) {
                    case 1:
                        viewMenuConsole.viewMenuConsole();
                        break;
                    case 2:
                        viewMenuEjb.viewMenuEjb();
                        break;
                    case 3:
                        viewMenuSoap.viewSoap();
                        break;
                    case 4:
                        viewMenuRest.viewRest();
                        break;
                    case 5:
                        System.out.println("Goodbye");
                        break;
                    default:
                        System.out.println(">>>[Info] Wrong choose");
                }
            } catch (IllegalArgumentException | NamingException | ServiceException_Exception ex) {
                System.out.println("[ERROR] Something wrong in viewMenu");
            }
        }
    }

    private void showMenu() {
        System.out.println("Choose your options : ");
        System.out.println("1. Запуск с помощью console");
        System.out.println("2. Запуск с помощью ejb");
        System.out.println("3. Запуск с помощью soap");
        System.out.println("4. Запуск с помощью rest");
        System.out.println("5. Выход");

    }
}

