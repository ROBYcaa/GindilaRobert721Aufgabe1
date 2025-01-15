import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class XMLReader {
    public static List<LogEntry> readLogsFromXML(String filePath) {
        List<LogEntry> logs = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("log");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    int id = Integer.parseInt(element.getElementsByTagName("Id").item(0).getTextContent());
                    String mitgliedsname = element.getElementsByTagName("Mitgliedsname").item(0).getTextContent();
                    String haus = element.getElementsByTagName("Haus").item(0).getTextContent();
                    String ereignis = element.getElementsByTagName("Ereignis").item(0).getTextContent();
                    LocalDate datum = LocalDate.parse(element.getElementsByTagName("Datum").item(0).getTextContent());

                    LogEntry logEntry = new LogEntry(id, mitgliedsname, haus, ereignis, datum);
                    logs.add(logEntry);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return logs;
    }
}
