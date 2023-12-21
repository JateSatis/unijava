package pract18;

class ThrowsDemo2 {
    public void printMessage(String key) {
        String message = getDetails(key);
        System.out.println( message );
    }
    public String getDetails(String key) {
        try {
            if(key == null) {
                throw new NullPointerException( "null key in getDetails");
            }
        } catch (NullPointerException e) {
            return e.getMessage();
        }
        return "data for " + key;
    }
}

public class ex6 {
    public static void main(String[] args) {
        ThrowsDemo2 demo = new ThrowsDemo2();
        demo.printMessage(null);
    }
}
