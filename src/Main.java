import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum Haus {
    Stark, Lannister, Targaryen, Baratheon, Greyjoy, Martell, Tyrell
}

class Ereignis {
    private int id;
    private String mitgliedsname;
    private Haus haus;
    private String ereignis;
    private Date datum;

    public Ereignis() {
    }

    public Ereignis(int id, String mitgliedsname, Haus haus, String ereignis, Date datum) {
        this.id = id;
        this.mitgliedsname = mitgliedsname;
        this.haus = haus;
        this.ereignis = ereignis;
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMitgliedsname() {
        return mitgliedsname;
    }

    public void setMitgliedsname(String mitgliedsname) {
        this.mitgliedsname = mitgliedsname;
    }

    public Haus getHaus() {
        return haus;
    }

    public void setHaus(Haus haus) {
        this.haus = haus;
    }

    public String getEreignis() {
        return ereignis;
    }

    public void setEreignis(String ereignis) {
        this.ereignis = ereignis;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Ereignis{" +
                "id=" + id +
                ", mitgliedsname='" + mitgliedsname + '\'' +
                ", haus=" + haus +
                ", ereignis='" + ereignis + '\'' +
                ", datum=" + datum +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        String filePath = "src/evenimente.xml";
        public static List<Ereignis> readXML(String filePath) {
            List<Ereignis> ereignisse = new ArrayList<>();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));

            NodeList logNodes = doc.getElementsByTagName("log");
            for (int i = 0; i < logNodes.getLength(); i++) {
                Element element = (Element) logNodes.item(i);

                int id = Integer.parseInt(element.getElementsByTagName("Id").item(0).getTextContent());
                String mitgliedsname = element.getElementsByTagName("Mitgliedsname").item(0).getTextContent();
                Haus haus = Haus.valueOf(element.getElementsByTagName("Haus").item(0).getTextContent());
                String ereignis = element.getElementsByTagName("Ereignis").item(0).getTextContent();
                Date datum = formatter.parse(element.getElementsByTagName("Datum").item(0).getTextContent());

                ereignisse.add(new Ereignis(id, mitgliedsname, haus, ereignis, datum));
            }
            return ereignisse;
        }
    }
}
