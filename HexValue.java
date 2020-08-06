import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class HexValue {
    Random r = new Random();
    int number;
    String fileName = "./HexValues.txt";
    BufferedWriter bw = null;
    FileWriter fw = null;
    String hex;

    public HexValue() {}

    public static void main(String[] args) {
        HexValue hv = new HexValue();
        hv.writeFile(6, 444);
    }

    public void writeFile(int hexValueLength, int rowLength) {
        openFile();

        boolean check = false;

        for (int i = 1; i <= rowLength; i++) {
            number = r.nextInt(16);
            if (check) {
                check = false;
            }
            switch (number) {
                case 0: hex =  "0"; break;
                case 1: hex =  "1"; break;
                case 2: hex =  "2"; break;
                case 3: hex =  "3"; break;
                case 4: hex =  "4"; break;
                case 5: hex =  "5"; break;
                case 6: hex =  "6"; break;
                case 7: hex =  "7"; break;
                case 8: hex =  "8"; break;
                case 9: hex =  "9"; break;
                case 10: hex = "A"; break;
                case 11: hex = "B"; break;
                case 12: hex = "C"; break;
                case 13: hex = "D"; break;
                case 14: hex = "E"; break;
                case 15: hex = "F"; break;
            }
            try {
                if (i % hexValueLength == 0) {
                    bw.append(String.valueOf(hex) + "\n");
                    check = true;
                } else { bw.append(String.valueOf(hex)); }
            } catch (IOException e) { e.printStackTrace(); }
        }
        closeFile();
    }

    private void openFile() {
        try {
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void closeFile() {
        try {
            if (bw != null) { bw.close(); }
            if (fw != null) { fw.close(); }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
