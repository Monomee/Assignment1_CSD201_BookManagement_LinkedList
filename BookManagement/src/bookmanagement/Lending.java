/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookmanagement;

/**
 *
 * @author PC
 */
public class Lending {
    private String bCode;
    private String rCode;
    private int state;

    public Lending() {
    }

    public Lending(String bCode, String rCode, int state) {
        this.bCode = bCode;
        this.rCode = rCode;
        this.state = state;
    }

    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    public String getrCode() {
        return rCode;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state)  throws IllegalArgumentException{
        if (state < 0 || state > 2){
            throw new IllegalArgumentException("Invalid state (must be from 0 to 2)");
        }else{
            this.state = state;
        }
    }

    @Override
    public String toString() {
        String output = String.format("%-15s|%-15s|%-15d", bCode, rCode, state);
        return output;
    }
}
