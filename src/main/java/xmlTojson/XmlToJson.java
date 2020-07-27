package xmlTojson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;



public class XmlToJson {
	public static String xml2jsonString() throws JSONException, IOException {
        InputStream in = XmlToJson.class.getResourceAsStream("nodes.xml");
        String xml = IOUtils.toString(in);
        JSONObject xmlJSONObj = XML.toJSONObject(xml);
        return xmlJSONObj.toString();
    }

    public static void main(String[] args) throws JSONException, IOException {

        String string = xml2jsonString();
      //  System.out.println(string);
        try {
            File file = new File("D:\\nodes.txt");
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.println(string);// ���ļ���д���ַ���
            System.out.println("qq");
           
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 	
    }
}
