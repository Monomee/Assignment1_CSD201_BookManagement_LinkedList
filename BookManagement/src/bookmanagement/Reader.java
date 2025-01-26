/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookmanagement;

/**
 *
 * @author PC
 */
public class Reader {
    private String rCode;
    private String name;
    private int byear;

    public Reader() {
    }

    public Reader(String rCode, String name, int byear) {
        this.rCode = rCode;
        this.name = name;
        this.byear = byear;
    }

    public String getrCode() {
        return rCode;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getByear() {
        return byear;
    }

    public void setByear(int byear) throws IllegalArgumentException{
        if (byear < 1900 || byear > 2010){
            throw new IllegalArgumentException("1900 <= BYear <= 2010");
        }else{
            this.byear = byear;
        }
    }
    
    @Override
    public String toString() {
        String output = String.format("%-15s|%-15s|%-15d", rCode, name, byear);
        return output;
    }
    
    public String infoReader(){
        String output = String.format("bCode: %s; name: %s; byear: %d", rCode, name, byear);
        return output;
    }
}
