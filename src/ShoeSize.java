/* ShoeSize - Eric McCreath 2015 - GPL
 * This class stores a persons shoe size.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ShoeSize {
    private static final String SHOESIZEENAME = "SHOESIZE";
    public static final int SHOESIZEMAX = 15;
    public static final int SHOESIZEMIN = 3;

    static final String FILENAME = "shoesize.xml";

    private Integer shoesize;

    public ShoeSize() {
        shoesize = null;
    }

    public String show() {
        return (shoesize == null ? "" : shoesize.toString());
    }

    public boolean set(Integer v) {
        if (v == null || v >= ShoeSize.SHOESIZEMIN && v <= ShoeSize.SHOESIZEMAX) {
            shoesize = v;
            save("data");
            return true;
        } else {
            shoesize = null;
            return false;
        }
    }

    static String[] decode(String data){
        return data.split(",");
    }

    static ShoeSize load() {
        // add code here that will load shoe size from a file called "FILENAME"
        ShoeSize result = new ShoeSize();
        try {
            System.out.println("open file");
            FileReader fileReader = new FileReader("data");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println("read data");
            char[] buf = new char[1000];
            bufferedReader.read(buf, 0, 1000);
            String data = "";
            for (char c : buf){
                data += c;
            }
            System.out.println("data is " + data);
            System.out.println("close file");
            bufferedReader.close();
            Integer value = Integer.parseInt(ShoeSize.decode(data)[0]);
            result.set(value);
        }catch (IOException x){
            System.err.format("IOException: %s%n", x);
        }
        return result;
    }

    String encode(Integer data){
        return data+",";
    }
        void save(String filename) {
            // add code here that will save shoe size into a file called "FILENAME"
            try {
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println("save data: " + this.shoesize);
            bufferedWriter.write(this.encode(this.shoesize==null ? null : this.shoesize));
            bufferedWriter.close();
        }
        catch(IOException x){
            System.err.format("I0Exception: %s%n", x);
        }
    }
}