/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookmanagement;

/**
 *
 * @author PC
 */
public class MenuScene {
    public static void menuMain(){
        System.out.println("1.      About Book.\n" +
        "2.      About Reader.\n" +
        "3.      About Lending.\n" +
        "0.      Exit.");
    }
    public static void menuBook(){
        System.out.println("1.      Load data from file.\n" +
        "2.      Input & add to the end.\n" +
        "3.      Display data.\n" +
        "4.      Save book list to file.\n" +
        "5.      Search by bcode.\n" +
        "6.      Delete by bcode.\n" +
        "7.      Sort by bcode.\n" +
        "8.      Input & add to beginning.\n" +
        "9.      Add after position k.\n" +
        "10.     Delete position k.\n" +
        "0.      Return.");
    }
    public static void menuReader(){
        System.out.println("1.      Load data from file.\n" +
        "2.      Input & add to the end.\n" +
        "3.      Display data.\n" +
        "4.      Save reader list to file.\n" +
        "5.      Search by rcode.\n" +
        "6.      Delete by rcode.\n" +
        "0.      Return.");
    }
    public static void menuLending(){
        System.out.println("1.      Input data.\n" +
        "2.      Display data.\n" +
        "3.      Sort  by bcode.\n" +
        "4.      Sort  by rcode.\n" +
        "0.      Return.");
    }
}
