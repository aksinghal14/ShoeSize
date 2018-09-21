/* ShoeSize - Eric McCreath 2015 - GPL
 * This class stores a persons shoe size.
 */
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ShoeSize3 {
    private static final String SHOESIZEENAME = "SHOESIZE";
    public static final int SHOESIZEMAX = 15;
    public static final int SHOESIZEMIN = 3;

    static final String FILENAME = "shoesize.xml";

    private Integer shoesize;

    public ShoeSize3() {
        shoesize = null;
    }

    public String show() {
        return (shoesize == null ? "" : shoesize.toString());
    }

    public boolean set(Integer v) {
        if (v == null || v >= ShoeSize.SHOESIZEMIN && v <= ShoeSize.SHOESIZEMAX) {
            shoesize = v;
            save(FILENAME);
            return true;
        } else {
            shoesize = null;
            return false;
        }
    }

    static ShoeSize load(String FILENAME) {
        File f = new File(FILENAME);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        ShoeSize shoeSize = new ShoeSize();

        try{
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(f);

            Node shoesize = doc.getFirstChild();
            NodeList nodeList = shoesize.getChildNodes();
            for (int i = 0;i< nodeList.getLength();i++) {
                Node n = nodeList.item(i);
            }

            // add code here that will load shoe size from a file called "FILENAME"

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("problem loading"+ FILENAME);
        }
        return shoeSize;
    }

    void save(String FILENAME) {
        File f = new File(FILENAME);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try{
            db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element shoe = doc.createElement(SHOESIZEENAME );
            shoe.appendChild(doc.createTextNode(Integer.toString(this.shoesize)));
            doc.appendChild(shoe);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer tansformer = transformerFactory.newTransformer();

            tansformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(f);
            tansformer.transform(source,result);

        }catch(Exception e) {
            System.err.println("problem saving "+FILENAME);
        }


        // add code here that will save shoe size into a file called "FILENAME"
    }
}