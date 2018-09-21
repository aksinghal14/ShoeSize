/* ShoeSize - Eric McCreath 2015 - GPL
 * This class stores a persons shoe size.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class ShoeSize2 {
    private static final String SHOESIZEENAME = "SHOESIZE";
    public static final int SHOESIZEMAX = 15;
    public static final int SHOESIZEMIN = 3;
    private static final String FILENAME = "data";

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

    static ShoeSize load() {
        ShoeSize shoeSize = new ShoeSize();
        // add code here that will load shoe size from a file called "FILENAME"
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));

            shoeSize.set((Integer) ois.readObject());
            ois.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        // return new ShoeSize();
        return shoeSize;
    }

    void save() {
        try{
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(FILENAME));
            oos.writeObject(this.shoesize);
            oos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        // add code here that will save shoe size into a file called "FILENAME"
    }
}