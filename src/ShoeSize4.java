/* ShoeSize - Eric McCreath 2015 - GPL
 * This class stores a persons shoe size.
 */


import java.util.prefs.Preferences;

public class ShoeSize4 {
    private static final String SHOESIZEENAME = "SHOESIZE";
    public static final int SHOESIZEMAX = 15;
    public static final int SHOESIZEMIN = 3;

    static final String FILENAME = "shoesize.xml";

    private Integer shoesize;

    public ShoeSize4() {
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

    //static  Preferences prefs;

    static ShoeSize4 load() {

        Preferences prefs= Preferences.userRoot().node(ShoeSize4.class.getName());
        ShoeSize4 shoeSize = new ShoeSize4();
        //prefs = Preferences.userNodeForPackage(ShoeSize.class);
        shoeSize.shoesize = prefs.getInt("ShoeSize",3);

        return shoeSize;
        // add code here that will load shoe size from a file called "FILENAME"

    }

    void save() {
        //ShoeSize4 shoeSize = new ShoeSize4();
        if(this.shoesize != null) {
            Preferences prefs = Preferences.userRoot().node(ShoeSize4.class.getName());
            prefs.putInt("ShoeSize", this.shoesize);
        }


        // add code here that will save shoe size into a file called "FILENAME"
    }
}