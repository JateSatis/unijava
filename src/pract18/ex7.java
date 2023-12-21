package pract18;

import java.util.Objects;
import java.util.Scanner;

class ThrowsDemo3 {
    public void getKey() throws Exception {
        Scanner myScanner = new Scanner( System.in );
        String key = myScanner.next();
        printDetails( key );
    }
    public void printDetails(String key) throws Exception {
        try { String message = getDetails(key);
            System.out.println( message );
        } catch ( Exception e){
            throw e;
        }
    }
    private String getDetails(String key) throws Exception {
        if(Objects.equals(key, "k")) {
            throw new Exception( "Key set to empty string" );
        }
        return "data for " + key; }
}

public class ex7 {
    public static void main(String[] args) {
        ThrowsDemo3 demo = new ThrowsDemo3();
        try {
            demo.getKey();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
