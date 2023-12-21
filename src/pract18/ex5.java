package pract18;

class ThrowsDemo {
    public void getDetails(String key) {
        try {
            if(key == null) {
                throw new NullPointerException("null key in getDetails" );
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class ex5 {
    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();
        demo.getDetails(null);
    }
}
