package pract7;

public class ProccessStrings implements Proccessable {
    @Override
    public int charCount(String str) {
        return str.length();
    }

    @Override
    public String oddCharacters(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.charCount(str); i += 2) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    @Override
    public String invert(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = this.charCount(str) - 1; i >= 0; i--) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }
}
