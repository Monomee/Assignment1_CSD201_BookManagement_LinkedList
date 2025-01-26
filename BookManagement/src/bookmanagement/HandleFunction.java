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
            String line = reader.readLine();

            while (line != null) {
                field = line.split(";");
                String bCode = field[1].trim();
                String title = field[2].trim();
                int quanlity = Integer.parseInt(field[3].trim());
                double price = Double.parseDouble(field[4].trim());
                bookList.addLast(new Book(bCode, title, quanlity, 0, price));
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
            String line = reader.readLine();

            while (line != null) {
                field = line.split(";");
                String rCode = field[1].trim();
                String name = field[2].trim();
                int byear = Integer.parseInt(field[3].trim());
                readerList.addLast(new Reader(rCode, name, byear));
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void loadBookDataFromFile() {
        String fileName;
        System.out.print("Enter file name (Recommend: \"BookInput.txt\"): ");
        fileName = sc.nextLine();
        readBookFile(fileName.trim());
        System.out.println("Done!");
    }

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

    void displayBookData() {
        System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n", "BCode", "Title", "Quanlity", "Lended", "Price", "Value");
        bookList.traverse();
    }

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
//       String path = "BookList.txt";
//        Node p = bookList.head;
//        try {
//            FileWriter fWriter = new FileWriter(path);
//            while (p != null) {
//                String info = p.bookInfo.toString();
//                // Writing into file
//                fWriter.write(info);
//
//                // Printing the contents of a file
//                System.out.println(info);
//
//                p = p.next;
//            }
//            // Closing the file writing connection
//            fWriter.close();
//            
//            System.out.println("Done!");
//        } // Catch block to handle if exception occurs
//        catch (IOException e) {
//            // Print the exception
//            System.out.print(e.getMessage());
//        }

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
    }

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

    void sortBybCode() {
        bookList.sortBybCode();
        System.out.println("Done!");
    }

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

    void deleteBookPos() {
        int pos;
        System.out.println("Enter position to delete: ");
        pos = c.handleChoice(bookList.size() - 1);
        bookList.remove(pos);
        System.out.println("Done!");
    }

    void loadReaderDataFromFile() {
        String fileName;
        System.out.print("Enter file name (Recommend: \"ReaderInput.txt\"): ");
        fileName = sc.nextLine();
        readReaderFile(fileName.trim());
        System.out.println("Done!");
    }

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

    void displayReaderData() {
        System.out.printf("%-15s|%-15s|%-15s\n", "RCode", "Name", "Byear");
        readerList.traverse();
    }

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
    }

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

    void inputLendingData() {
        String bCode;
        String rCode;
        int state = 2;

        System.out.print("Enter bCode: ");
        bCode = sc.nextLine();
        if (bookList.searchBybCode(bCode) == null) {
            System.out.println(bCode + " does not existed!");
            return;
        }

        System.out.print("Enter rCode: ");
        rCode = sc.nextLine();
        if (readerList.searchByrCode(rCode) == null) {
            System.out.println(rCode + " does not existed!");
            return;
        }

//        System.out.println("Enter state: ");
//        state = c.handleChoice(2);
//        
        Lending checkLending = lendingList.searchBybCode(bCode).lendingInfo;
        if (checkLending.getrCode().equals(rCode.trim()) && checkLending.getState() == 1) {
            System.out.println("Data not accepted!");
            return;
        }
        Book checkBook = bookList.searchBybCode(bCode).bookInfo;
        if (checkBook.getLended() == checkBook.getQuanlity()) {
            state = 0;
        } else if (checkBook.getLended() < checkBook.getQuanlity()) {
            state = 1;
            checkBook.setLended(checkBook.getLended() + 1);
        }

        lendingList.addLast(new Lending(bCode, rCode, state));

    }

    void displayLendingData() {
        System.out.printf("%-15s|%-15s|%-15s\n", "BCode", "RCode", "State");
        lendingList.traverse();
    }

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
    }
    
    void sortLendingByrCode(){
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
    }

}
