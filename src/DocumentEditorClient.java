import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.List;


interface DocumentElement {
    public abstract String render();
}

class TextElement implements DocumentElement {
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}

class ImageElement implements DocumentElement {
    private String imagePath;

    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String render() {
        return "[Image: " + imagePath + "]";
    }
}

class NewLineElement implements DocumentElement {
    @Override
    public String render() {
        return "\n";
    }
}

class TabSpaceElement implements DocumentElement {
    @Override
    public String render() {
        return "\t";
    }
}
class  Document {
    private List<DocumentElement> documentElements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        documentElements.add(element);
    }

    public String render() {
        StringBuilder renderedContent = new StringBuilder();
        for (DocumentElement element : documentElements) {
            renderedContent.append(element.render());
        }
        return renderedContent.toString();
    }
}

interface Persistence {
    void save(String data);
}

class FilePersistence implements Persistence {
    private String filePath;

    public FilePersistence(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(String data) {
        // Simulate saving to a file
        System.out.println("Saving to file: " + filePath);
        System.out.println(data);
    }
}

class DocumentEditor {
    private Document document;
    private Persistence persistence;
    private String renderedContent;

    public DocumentEditor(Document document, Persistence persistence) {
        this.document = document;
        this.persistence = persistence;
    }

    public void addElement(DocumentElement element) {
        document.addElement(element);
    }

    public  void addNewLine() {
        document.addElement(new NewLineElement());
    }

    public void addTabSpace() {
        document.addElement(new TabSpaceElement());
    }

    public void addImage(String imagePath) {
        document.addElement(new ImageElement(imagePath));
    }

    public void renderDocument() {
        renderedContent = document.render();
        System.out.println("Rendered Document:");
        System.out.println(renderedContent);
    }

    public void saveDocument() {
        String renderedContent = document.render();
        persistence.save(renderedContent);
    }
}

public class DocumentEditorClient {
    public static void main(String[] args) {
        Document document = new Document();
        Persistence filePersistence = new FilePersistence("document.txt");
        DocumentEditor editor = new DocumentEditor(document, filePersistence);

        editor.addElement(new TextElement("Hello, World!"));
        editor.addNewLine();
        editor.addTabSpace();
        editor.addElement(new TextElement("This is a sample document."));
        editor.addNewLine();
        editor.addImage("image1.png");

        editor.renderDocument();
        editor.saveDocument();
    }
}