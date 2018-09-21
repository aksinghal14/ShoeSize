/* ShoeSize - Eric McCreath 2015 - GPL
 * This class stores a persons shoe size.
 */
import java.io.*;


public class ShoeSize2 {
    private static final String SHOESIZEENAME = "SHOESIZE";
    public static final int SHOESIZEMAX = 15;
    public static final int SHOESIZEMIN = 3;
    private static final String FILENAME = "data2";

    private Integer shoesize;

    public ShoeSize2() {
        shoesize = null;
    }

    public String show() {
        return (shoesize == null ? "" : shoesize.toString());
    }

    public boolean set(Integer v) {
        if (v == null || v >= ShoeSize.SHOESIZEMIN && v <= ShoeSize.SHOESIZEMAX) {
            shoesize = v;
            save();
            return true;
        } else {
            shoesize = null;
            return false;
        }
    }

    static ShoeSize2 load() {
        ShoeSize2 shoeSize = new ShoeSize2();
        // add code here that will load shoe size from a file called "FILENAME"
        if((new File(FILENAME)).exists()) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));

                shoeSize.set((Integer) ois.readObject());
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        // return new ShoeSize();
        return shoeSize;
    }

    void save() {

            try {
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream(FILENAME));
                oos.writeObject(this.shoesize);
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        // add code here that will save shoe size into a file called "FILENAME"
    }
}