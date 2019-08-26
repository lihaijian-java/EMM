 package com.oracle.sy;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/**
 * Bookdao.java
 * @author Administrator
 *
 */
public class BookDao {
	public static final String PATH="E:\\eclipse-workspace\\book1\\src\\com\\oracle\\sy\\book.xml";	
	/*
	 * 获得xml中的Document
	 */
	public  Document getDocument(String path){
		//创建一个Reader(字符输入流)
				SAXReader reader = new SAXReader();		
				//从流当中获取Document
				Document document = null;		
				try {
					document = reader.read(path);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				return document;	
	}
	/*
	 * 获得根节点
	 */
	public Element getRoot(String path){
		Document document=getDocument(path);	
		//获取Document当中的根节点元素(books元素)
				Element booksElement = document.getRootElement();
			
				return booksElement;
	}
	public void write(String path,Document document){

		try {
			// 设置保存的格式化器  1. \t，使用什么来完成缩进 2. true, 是否要添加换行  
			OutputFormat format = new OutputFormat("\t", true);  
			format.setTrimText(true); //去掉空白  
			XMLWriter writer = new XMLWriter(new FileWriter(new File(path)),format);

			writer.write(document);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
public List<Book> list(){	
		List<Book> list = new ArrayList<Book>();		
		try {
			//获得xml文档的根节点
			Element booksElement = getRoot(PATH);			
			//获取根节点元素下面的所有的子节点元素(book元素)
			List<Element>  childrenElements = booksElement.elements();			
			for(Element book : childrenElements){				
				//获取book元素的属性:id
				String id = book.attribute("id").getValue();
				
				//获取book元素的属性:name
				String name = book.attribute("name").getText();
				
				//获取book元素的属性:author
				String author = book.attribute("author").getText();
				
				//获取book元素的属性:press
				String press = book.attribute("press").getText();
				
				Book newBook = new Book();
				newBook.setId(Integer.parseInt(id));
				newBook.setName(name);
				newBook.setAuthor(author);
				newBook.setPress(press);				
				list.add(newBook);				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return list;
	}
public List<Book> searchByName(String bookName){	
	List<Book> list = new ArrayList<Book>();
	/*
	 * 使用xpath查找元素
	 */
	//获取document
	Document document = this.getDocument(PATH);	
	//使用xpath定位	
	//用以保存搜索结果的book	
	List<Node> nodeList = document.selectNodes("/books/book[@name='" + bookName +  "']");	
	for(Node node : nodeList){	
		Element book = (Element)node;
		//获取book元素的属性:id
		String id = book.attribute("id").getValue();
		
		//获取book元素的属性:name
		String name = book.attribute("name").getText();
		
		//获取book元素的属性:author
		String author= book.attribute("author").getText();
		
		//获取book元素的属性:press
		String press = book.attribute("press").getText();		
		Book newBook = new Book();
		newBook.setId(Integer.parseInt(id));
		newBook.setName(name);
		newBook.setAuthor(author);
		newBook.setPress(press);		
		list.add(newBook);		
	}
	return list;
}
public Book get(int id){	
	Book book = null;	
	/*
	 * 使用xpath查找元素
	 */
	//获取document
	Document document = this.getDocument(PATH);	
	//使用xpath定位	
	Element bookElement = (Element)document.selectSingleNode("/books/book[@id=" + id +  "]");	
	if(bookElement != null){
		
		//获取book元素的属性:name
		String name = bookElement.attribute("name").getText();
		
		//获取book元素的属性:author
		String author = bookElement.attribute("author").getText();
		
		//获取book元素的属性:press
		String press = bookElement.attribute("press").getText();
		
		book = new Book();		
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);;
		book.setPress(press);	
	}	
	return book;
}
/**
 *    添加图书
 * @param book
 */
public void add(Book book){
	//获取document
	Document document = getDocument(PATH);	
	//获得xml文档的根节点
	Element booksElement = document.getRootElement();
	//取根节点下面所有的节点
	 List<Element> list =  booksElement.elements();	 
	 int id = 0;
	 
	 if(list.size() > 0){
		 //最后一项(书藉)
		 Element lastBook = list.get(list.size() - 1);
         //新添加的图书id加1
		id =  Integer.parseInt(lastBook.attributeValue("id")) + 1;
	 }else{		 
		 id = 1;	 
	 }
	Element bookElement = booksElement.addElement("book");
	bookElement.addAttribute("id", String.valueOf(id));
	bookElement.addAttribute("name",book.getName());
	bookElement.addAttribute("author",book.getAuthor());
	bookElement.addAttribute("press",book.getPress());
	
	//写入文件
	write(PATH, document);
}
public void update(Book book){	
	//获取document
	Document document = getDocument(PATH);
	/*
	 * 使用xpath定位欲修改的元素
	 */
	Element bookElement = (Element)document.selectSingleNode("/books/book[@id=" + book.getId() + "]");
	
	//修改book元素当中的name，author,press
	bookElement.attribute("name").setValue(book.getName());
	bookElement.attribute("author").setValue(book.getAuthor());
	bookElement.attribute("press").setValue(book.getPress());
	
	//写入文件
	write(PATH, document);
	
}
/**
 * 删除元素
 */
public void delete(int id){	
	//获取document
	Document document = getDocument(PATH);	
	/*
	 * 使用xpath定位欲删除的元素
	 */
	Element deleteElement = (Element)document.selectSingleNode("/books/book[@id=" + id + "]");	
	//获取父元素
	Element parentElement = deleteElement.getParent();
	
	//删除子节点的元素
	parentElement.remove(deleteElement);	
	//写入文件
	write(PATH, document);	
}
}
