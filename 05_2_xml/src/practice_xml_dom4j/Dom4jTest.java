package practice_xml_dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import java.util.List;

public class Dom4jTest {
    @Test
    public void test() {
        //创建一个SAXReader输入流，取读取xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();

        Document document = null;
        try {
            document = saxReader.read("src/books.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        System.out.println(document);
    }

    /*
    读取books.xml文件生成books类
     */
    @Test
    public void test2() throws Exception {
        //1.读取books.xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");

        //2.通过Document对象获取根元素
        Element rootElement = document.getRootElement();
        //System.out.println(rootElement.asXML());
        //3.通过根元素获取book标签对象
        //element()通过标签查询子元素 book元素
        List<Element> books = rootElement.elements("book");
        //4.遍历。处理每个book标签转化为Book类对象
        for (Element book:books){
            //asXML() 把标签对象转换成，标签字符串
            Element nameElement = book.element("name");
            //getText()  可以获取标签中的文本内容
            String nameText = nameElement.getText();
            //直接获取指定标签名的文本内容
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");
            //获取属性值
            String snValue = book.attributeValue("sn");
            Book book1 = new Book(snValue,nameText,Double.parseDouble(priceText),authorText);
            System.out.println(book1);
        }
    }
}
