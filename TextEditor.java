import java.util.ArrayList;
import java.util.Scanner;

public class TextEditor {
    private ArrayList<String> history;
    private int currentIndex;

    public TextEditor() {
        this.history = new ArrayList<>();
        this.currentIndex = -1;
    }

    public void write(String text) {
        // Hapus semua history setelah currentIndex jika ada
        if (currentIndex < history.size() - 1) {
            history.subList(currentIndex + 1, history.size()).clear();
        }

        // Tambahkan teks ke history
        history.add(text);
        currentIndex++;
    }

    public void undo() {
        if (currentIndex > 0) {
            currentIndex--;
        }
    }

    public void redo() {
        if (currentIndex < history.size() - 1) {
            currentIndex++;
        }
    }

    public void show() {
        if (currentIndex == -1) {
            System.out.println("Teks editor masih kosong.");
        } else {
            System.out.println(history.get(currentIndex));
        }
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Pilih fungsi:");
            System.out.println("1. Show");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Write");
            System.out.println("5. Keluar");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    textEditor.show();
                    break;
                case 2:
                    textEditor.undo();
                    break;
                case 3:
                    textEditor.redo();
                    break;
                case 4:
                    System.out.print("Tulis teks: ");
                    String text = scanner.nextLine();
                    textEditor.write(text);
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}