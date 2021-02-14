package cn.until.dataSource;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesUtil {
//	public static void updateProperties (String fileName,Map<String, String> keyValueMap) {  
//        //getResource方法使用了utf-8对路径信息进行了编码，当路径中存在中文和空格时，他会对这些字符进行转换，这样，  
//        //得到的往往不是我们想要的真实路径，在此，调用了URLDecoder的decode方法进行解码，以便得到原始的中文及空格路径。  
//        String filePath = PropertiesUtil.class.getClassLoader().getResource(fileName).getFile();  
//        Properties props = null;  
//        BufferedWriter bw = null;  
//  
//        try {  
//            filePath = URLDecoder.decode(filePath,"utf-8");      
//            //log.debug("updateProperties propertiesPath:" + filePath); 
//            System.out.println(filePath);
//            props = PropertiesLoaderUtils.loadProperties(new ClassPathResource(fileName)); //加载配置文件 
//            //log.debug("updateProperties old:"+props);  
//            System.out.println(props);
//           
//            // 写入属性文件  
//            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));  
//              
//            //props.clear();// 清空旧的文件  
//              
//            for (String key : keyValueMap.keySet()) { 
//            	System.out.println(key+" = "+keyValueMap.get(key));
//                props.setProperty(key, keyValueMap.get(key));  
//            }
//           // log.debug("updateProperties new:"+props);  
//            props.store(bw, "");  
//        } catch (IOException e) {  
//            //log.error(e.getMessage());  
//        } finally {  
//            try {  
//            	PropertiesLoaderUtils.loadProperties(new ClassPathResource(fileName));
//                bw.close();  
//            } catch (IOException e) {  
//                e.printStackTrace();  
//            }  
//        }  
//    }  
}
