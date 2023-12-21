package pract18;

import java.util.Objects;
import java.util.Scanner;

class ThrowsDemo4 {
    public void getKey() {
        Scanner myScanner = new Scanner( System.in );
        while (true) {
            String key = myScanner.next();
            try {
                printDetails( key );
            } catch (Exception e) {
                System.out.println("Finally caught");
                continue;
            }
            break;
        }
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

public class ex8 {
    public static void main(String[] args) {
        ThrowsDemo4 demo = new ThrowsDemo4();
        demo.getKey();
    }
}
