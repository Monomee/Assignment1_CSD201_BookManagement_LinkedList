/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bookmanagement;
import java.util.Scanner;
/**
 *
 * @author PC
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static HandleChoice c = new HandleChoice();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Lending t = new Lending();
        // f.loadfile("book1.txt", "reader1.txt");
        // f.lend("B1", "R1");
        // f.lend("B1", "R2");// không cho mượn
        // f.lend("B2", "R2");// cho mượn
        // 
        // f.displayLending(););
//        HandleFunction f= new HandleFunction();
//        System.out.printf("1. load file\n"
//        +"2. lend\n"
//        +"3. display book\n"
//        +"4. display lending\n");
////        int choice = c.handleChoice(5);
////        switch (choice) {
////            case 1:
////                f.loadFile("book.txt", "reader.txt");
////                break;
////            case 2:
////                f.lend("B1", "R1");
////                break;
////            case 3:
////                 f.lend("B1", "R2");
////                break;
////            case 4:
////                f.lend("B2", "R2");
////                break;
////            case 5:
////                f.displayBookData();
////                break;
////            case 6:
////                f.displayLendingData();
////                break;
////            default:
////                System.out.println("Bye!");
////        }
        menuOfMain();
        
    }
    
    public static void menuOfMain(){
        MenuScene.menuMain();
        int choice = c.handleChoice(3);
        switch (choice) {
            case 1:
                MenuScene.menuBook();
                int bookChoice;
                do{
                    bookChoice = c.handleChoice(15);
                } while(c.userBookChoice(bookChoice));
                menuOfMain();
                break;
            case 2:
                MenuScene.menuReader();
                int readerChoice;
                do{
                    readerChoice = c.handleChoice(6);
                } while(c.userReaderChoice(readerChoice));
                menuOfMain();
                break;
            case 3:
                MenuScene.menuLending();
                int lendingChoice;
                do{
                    lendingChoice = c.handleChoice(10);
                } while(c.userLendingChoice(lendingChoice));
                menuOfMain();
                break;
            case 0:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Wrong more than 3 times!");
        }
    }
}
