package pract24.Ex_3;

public class TextDocument implements IDocument {
    String name;
    private StringBuilder text;

    public String getName() {
        return name;
    }

    @Override
    public void onOpen(String fileName) {
        name = fileName;
    }

    public TextDocument() {
        text = new StringBuilder();
    }

    public void addLine(String line) {
        text.append(line).append("\n");
    }

    public StringBuilder getText() {
        return text;
    }
}
