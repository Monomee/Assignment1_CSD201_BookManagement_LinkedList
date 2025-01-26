/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookmanagement;

/**
 *
 * @author PC
 */
public class Book {
    private String bCode;
    private String title;
    private int quanlity;
    private int lended;
    private double price;

    public Book() {
    }

    public Book(String bCode, String title, int quanlity, int lended, double price) {
        this.bCode = bCode;
        this.title = title;
        this.quanlity = quanlity;
        this.lended = lended;
        this.price = price;
    }

    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public int getLended() {
        return lended;
    }

    public void setLended(int lended) throws IllegalArgumentException {
        if (lended > this.quanlity){
            throw new IllegalArgumentException("Lended must be less than or equal to Quanlity, (Quanlity: " + this.quanlity + ")");
        }else{
            this.lended = lended;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IllegalArgumentException {
        if (price < 0){
            throw new IllegalArgumentException("Price must be more greater than or equal to 0");
        }else{
            this.price = price;
        }
    }

    @Override
    public String toString() {
        double value = quanlity * price;
        String output = String.format("%-15s|%-15s|%-15d|%-15d|%-15.3f|%-15.3f", bCode, title, quanlity, lended, price, value);
        return output;
    }
    
    public String infoBook(){
        double value = quanlity * price;
        String output = String.format("bCode: %s; title: %s; quanlity: %d; lended: %d; price: %.3f; value: %.3f", bCode, title, quanlity, lended, price, value);
        return output;
    }
}
