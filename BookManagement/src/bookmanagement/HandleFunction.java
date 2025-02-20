/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookmanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.List;

/**
 *
 * @author PC
 */
public class HandleFunction {

    static Scanner sc = new Scanner(System.in);
    static HandleChoice c = new HandleChoice();
    public static LinkedList bookList = new LinkedList();
    public static LinkedList readerList = new LinkedList();
    public static LinkedList lendingList = new LinkedList();

    static void readBookFile(String fileName) {
        BufferedReader reader;
        String[] field;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine().trim();

            while (line != null) {
                field = line.split("\\|");
                String bCode = field[0].trim();
                String title = field[1].trim();
                int quanlity = Integer.parseInt(field[2].trim());
                int lended = Integer.parseInt(field[3].trim());
                double price = Double.parseDouble(field[4].trim());
                bookList.addLast(new Book(bCode, title, quanlity, lended, price));
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readReaderFile(String fileName) {
        BufferedReader reader;
        String[] field;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine().trim();

            while (line != null) {
                field = line.split("\\|");
                String rCode = field[0].trim();
                String name = field[1].trim();
                int byear = Integer.parseInt(field[2].trim());
                readerList.addLast(new Reader(rCode, name, byear));
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     About Book
     */
    //1
    void loadBookDataFromFile() {
        String fileName;
        System.out.print("Enter file name (Recommend: \"book.txt\"): ");
        fileName = sc.nextLine();
        readBookFile(fileName.trim());
        System.out.println("Done!");
    }

    //2
    void inputBookAddLast() {
        String bCode;
        String title;
        int quanlity;
        int lended = 0;
        double price;
        int count = 0;
        System.out.print("Enter bCode: ");
        do {
            if (count == 3) {
                System.out.println("Wrong more than 3 times");
                return;
            }
            bCode = sc.nextLine();
            count++;
            if (bookList.searchBybCode(bCode.trim()) != null) {
                System.out.println(bCode.trim() + " existed!");
            }
        } while (bookList.searchBybCode(bCode.trim()) != null);
        System.out.print("Enter title: ");
        title = sc.nextLine().trim();
        System.out.println("Enter quanlity: ");
        quanlity = c.handleInputInt();
        System.out.println("Enter price: ");
        price = c.handleInputDouble();
        bookList.addLast(new Book(bCode, title, quanlity, lended, price));
        System.out.println("Done!");
    }

    //3
    void displayBookData() {
        System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n", "BCode", "Title", "Quanlity", "Lended", "Price", "Value");
        bookList.traverse();
    }

    //4
    void saveBookListToFile() {
        String path;
        System.out.println("Enter file name (Recommend: \"BookList.txt\"): ");
        path = sc.nextLine();
        Node p = bookList.head;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.trim()))) {
            while (p != null) {
                // Ghi thông tin sách vào file với định dạng đúng
                writer.write(bookList.indexOf(p) + "; " + p.bookInfo.infoBook());
                writer.newLine();

                p = p.next;
            }
            System.out.println("Done!");
        } catch (IOException e) {
            System.err.println("Error while saving book list to file: " + e.getMessage());
        }
    }

    //5
    void searchBybCode() {
        String bCode;
        System.out.print("Enter bCode to search: ");
        bCode = sc.nextLine();
        Node p = bookList.searchBybCode(bCode);
        if (p != null) {
            bookList.visit(p);
        } else {
            System.out.println(bCode + " does not existed!");
        }
        System.out.println();
    }

    //6
    void deleteBybCode() {
        String bCode;
        System.out.print("Enter bCode to delete: ");
        bCode = sc.nextLine();
        Node p = bookList.searchBybCode(bCode);
        if (p != null) {
            bookList.remove(p);
            System.out.println("Done!");
        } else {
            System.out.println(bCode + " does not existed!");
        }
    }

    //7
    void sortBybCode() {
        bookList.sortBybCode();
        System.out.println("Done!");
    }

    //8
    void inputBookAddFirst() {
        String bCode;
        String title;
        int quanlity;
        int lended = 0;
        double price;
        int count = 0;
        System.out.print("Enter bCode: ");
        do {
            if (count == 3) {
                System.out.println("Wrong more than 3 times");
                return;
            }
            bCode = sc.nextLine();
            count++;
            if (bookList.searchBybCode(bCode.trim()) != null) {
                System.out.println(bCode.trim() + " existed!");
            }
        } while (bookList.searchBybCode(bCode.trim()) != null);
        System.out.print("Enter title: ");
        title = sc.nextLine().trim();
        System.out.println("Enter quanlity: ");
        quanlity = c.handleInputInt();
        System.out.println("Enter price: ");
        price = c.handleInputDouble();
        bookList.addFirst(new Book(bCode, title, quanlity, lended, price));
        System.out.println("Done!");
    }

    //9
    void addBookAfter() {
        String bCode;
        String title;
        int quanlity;
        int lended = 0;
        double price;
        int pos;
        int count = 0;
        System.out.print("Enter bCode: ");
        do {
            if (count == 3) {
                System.out.println("Wrong more than 3 times");
                return;
            }
            bCode = sc.nextLine();
            count++;
            if (bookList.searchBybCode(bCode.trim()) != null) {
                System.out.println(bCode.trim() + " existed!");
            }
        } while (bookList.searchBybCode(bCode.trim()) != null);
        System.out.print("Enter title: ");
        title = sc.nextLine().trim();
        System.out.println("Enter quanlity: ");
        quanlity = c.handleInputInt();
        System.out.println("Enter price: ");
        price = c.handleInputDouble();
        System.out.println("Enter position to add after: ");
        pos = c.handleChoice(bookList.size() - 1);
        bookList.insertAfter(pos, new Book(bCode, title, quanlity, lended, price));
        System.out.println("Done!");
    }

    //10
    void deleteBookPos() {
        int pos;
        System.out.println("Enter position to delete: ");
        pos = c.handleChoice(bookList.size() - 1);
        bookList.remove(pos);
        System.out.println("Done!");
    }

    /*
    About Reader
     */
    //1
    void loadReaderDataFromFile() {
        String fileName;
        System.out.print("Enter file name (Recommend: \"reader.txt\"): ");
        fileName = sc.nextLine();
        readReaderFile(fileName.trim());
        System.out.println("Done!");
    }

    //2
    void inputReaderAddLast() {
        String rCode;
        String name;
        int byear;
        int count = 0;
        System.out.print("Enter rCode: ");
        do {
            if (count == 3) {
                System.out.println("Wrong more than 3 times");
                return;
            }
            rCode = sc.nextLine();
            count++;
            if (readerList.searchByrCode(rCode.trim()) != null) {
                System.out.println(rCode.trim() + "existed!");
            }
        } while (readerList.searchByrCode(rCode.trim()) != null);
        System.out.print("Enter name: ");
        name = sc.nextLine().trim();
        System.out.println("Enter byear: ");
        byear = c.handleInputInt();
        readerList.addLast(new Reader(rCode, name, byear));
        System.out.println("Done!");
    }

    //3
    void displayReaderData() {
        System.out.printf("%-15s|%-15s|%-15s\n", "RCode", "Name", "Byear");
        readerList.traverse();
    }

    //4
    void saveReaderListToFile() {
        String path;
        System.out.println("Enter file name (Recommend: \"ReaderList.txt\"): ");
        path = sc.nextLine();
        Node p = readerList.head;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.trim()))) {
            while (p != null) {
                // Ghi thông tin sách vào file với định dạng đúng
                writer.write(readerList.indexOf(p) + "; " + p.readerInfo.infoReader());
                writer.newLine();

                p = p.next;
            }
            System.out.println("Done!");
        } catch (IOException e) {
            System.err.println("Error while saving reader list to file: " + e.getMessage());
        }
    }

    //5
    void searchByrCode() {
        String rCode;
        System.out.print("Enter rCode to search: ");
        rCode = sc.nextLine();
        Node p = readerList.searchByrCode(rCode);
        if (p != null) {
            readerList.visit(p);
        } else {
            System.out.println(rCode + " does not existed!");
        }
        System.out.println();
    }

    //6
    void deleteByrCode() {
        String rCode;
        System.out.print("Enter rCode to delete: ");
        rCode = sc.nextLine();
        Node p = readerList.searchByrCode(rCode);
        if (p != null) {
            readerList.remove(p);
            System.out.println("Done!");
        } else {
            System.out.println(rCode + " does not existed!");
        }
    }

    /*
    About Lending
     */
    //1
    void inputLendingData() {
        String bCode;
        String rCode;
        int state = 2;

        System.out.print("Enter bCode: ");
        bCode = sc.nextLine();
        if (bookList.searchBybCode(bCode.trim()) == null) {
            System.out.println(bCode + " does not existed!");
            return;
        }

        System.out.print("Enter rCode: ");
        rCode = sc.nextLine();
        if (readerList.searchByrCode(rCode.trim()) == null) {
            System.out.println(rCode + " does not existed!");
            return;
        }

        Book checkBook = bookList.searchBybCode(bCode).bookInfo;
        if (checkBook.getLended() == checkBook.getQuanlity()) {
            state = 0;
        } else if (checkBook.getLended() < checkBook.getQuanlity()) {
            state = 1;
            checkBook.setLended(checkBook.getLended() + 1);
        }

        List<Node> lendingListForBook = lendingList.searchLendingBybCode(bCode);
        boolean isAlreadyLent = false;
        for (Node checkLending : lendingListForBook) {
            // Nếu người đọc đã mượn sách này và trạng thái là 1 (đang mượn)
            if (checkLending.lendingInfo.getrCode().equals(rCode) && checkLending.lendingInfo.getState() == 1) {
                isAlreadyLent = true;
                break;
            }
        }

        // Nếu sách đã được mượn bởi người đọc này, không cho phép mượn lại
        if (isAlreadyLent) {
            System.out.println("Data not accepted!");  // Người đọc đã mượn sách này rồi
            return;
        }

        lendingList.addLast(new Lending(bCode, rCode, state));
        System.out.println("Done!");
    }

    //2
    void displayLendingData() {
        System.out.printf("%-15s|%-15s|%-15s\n", "BCode", "RCode", "State");
        lendingList.traverse();
    }

    //3
    void sortLendingBybCode() {
        Node pi, pj;
        Lending temp;
        for (pi = lendingList.head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pj.lendingInfo.getbCode().compareTo(pi.lendingInfo.getbCode()) < 0) {
                    temp = pi.lendingInfo;
                    pi.lendingInfo = pj.lendingInfo;
                    pj.lendingInfo = temp;
                }
            }
        }
        System.out.println("Done!");
    }

    //4
    void sortLendingByrCode() {
        Node pi, pj;
        Lending temp;
        for (pi = lendingList.head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pj.lendingInfo.getrCode().compareTo(pi.lendingInfo.getrCode()) < 0) {
                    temp = pi.lendingInfo;
                    pi.lendingInfo = pj.lendingInfo;
                    pj.lendingInfo = temp;
                }
            }
        }
        System.out.println("Done!");
    }
//    
//    //assignment modify 1
//    void f1(){
//        bookList.clear();
//        readBookFile("book1.txt");
//        bookList.traverse();
//    }
//    
//    void f2(){
//        bookList.clear();
//        readBookFile("book1.txt");
//        bookList.removeBybCode("3");
//        bookList.traverse();
//    }
//    
//    void f3(){
//        bookList.clear();
//        readBookFile("book1.txt");
//        bookList.sortByLended();
//        bookList.traverse();
//    }
//    
//    void f4(){
//         bookList.clear();
//        readBookFile("book1.txt");
//        bookList.searchBybCode("2").bookInfo.setTitle("U");
//        bookList.traverse();
//    }
//    
//    void f5(){
//         bookList.clear();
//        readBookFile("book1.txt");
//        bookList.addLast(new Book("6", "V", 4, 2, 2));
//        bookList.traverse();
//    }
//    
//   //assignment modify 2
//    void loadFile(String fileBook, String fileReader){
//        readBookFile(fileBook);
//        readReaderFile(fileReader);
//    }
//   void lend(String bCode, String rCode){
//       int state = 2;
//
//        if (bookList.searchBybCode(bCode.trim()) == null) {
//            System.out.println(bCode + " does not existed!");
//            return;
//        }
//
//        if (readerList.searchByrCode(rCode.trim()) == null) {
//            System.out.println(rCode + " does not existed!");
//            return;
//        }
//
//        Book checkBook = bookList.searchBybCode(bCode).bookInfo;
//        if (checkBook.getLended() == checkBook.getQuanlity()) {
//            System.out.println("Not successfull");
//            return;
//        } else if (checkBook.getLended() < checkBook.getQuanlity()) {
//            state = 1;
//            checkBook.setLended(checkBook.getLended() + 1);
//        }
//
//        List<Node> lendingListForBook = lendingList.searchLendingBybCode(bCode);
//        boolean isAlreadyLent = false;
//        for (Node checkLending : lendingListForBook) {
//            // Nếu người đọc đã mượn sách này và trạng thái là 1 (đang mượn)
//            if (checkLending.lendingInfo.getrCode().equals(rCode) && checkLending.lendingInfo.getState() == 1) {
//                isAlreadyLent = true;
//                break;
//            }
//        }
//
//        // Nếu sách đã được mượn bởi người đọc này, không cho phép mượn lại
//        if (isAlreadyLent) {
//            System.out.println("Data not accepted!");  // Người đọc đã mượn sách này rồi
//            return;
//        }
//
//        lendingList.addLast(new Lending(bCode, rCode, state));
//        lendingList.visit(bookList.searchBybCode(bCode));
//        System.out.println("Successful!");
//   }
}
