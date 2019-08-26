package com.oracle.sy;
import java.util.List;
import java.util.Scanner;
public class UI {	
	//接收键盘输入的信息
	static Scanner scanner = new Scanner(System.in);
	public static int mainMenu(){
		
		String uiStr = "|--------------------------------------------|\n";
		uiStr += "|          图书管理系统                                         |\n";
		uiStr += "|                                            |\n";
		uiStr += "|   1.查询图书列表                                                  |\n";
		uiStr += "|   2.搜索图书                                                         |\n";
		uiStr += "|   3.添加图书                                                         |\n";
		uiStr += "|                                            |\n";
		uiStr += "|--------------------------------------------|\n";
		uiStr += "\n";
		uiStr += "请输入您要进行的操作代码:";
		
		System.out.println(uiStr);
		
		int num = scanner.nextInt();
		
		return num;
	}
	
	public static int list(){
		
		BookDao bookDao = new BookDao();
		
		List<Book> list = bookDao.list();
		
		/*
		 * 遍历xml文件当中所有的书藉
		 */
		
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < list.size(); i++){
			
			Book book = list.get(i);
			
			builder.append(book.getId()).append(".");
			builder.append(book.getName()).append("\t");
			builder.append("作者：").append(book.getAuthor()).append("\t");
			builder.append("出版社：").append(book.getPress()).append("\n");
		}
		
		builder.append("\n").append("请输入您要进行的操作的书藉代码:     0.返回主菜单 ");
		
		System.out.println(builder);
		
		int num = scanner.nextInt();
		
		return num;
	}
	
	public static void add(){
		
		System.out.println("----------------------------请填写图书信息:-------------------------------------\n");
		System.out.println("图书名称:\n");
		
		String name = scanner.next();
		
		System.out.println("\n作者:\n");
		
		String author = scanner.next();
		
		System.out.println("\n出版社:\n");
		
		String press = scanner.next();
		
		System.out.println("请输入您要进行的操作代码:  1.保存   2.放弃并返回主菜单");
		
		int num = scanner.nextInt();
		
		if(num == 1){
			
			//保存
			Book book = new Book();
			
			book.setName(name);
			book.setAuthor(author);
			book.setPress(press);
			
			BookDao bookDao = new BookDao();
			//执行修改
			bookDao.add(book);
			
		}
			
		BookProgram.start();
	
	}
	
	public static int detail(int id){
		
		BookDao bookDao = new BookDao();
		
		//根据书藉的id查找书藉
		Book book = bookDao.get(id);
		
		StringBuilder builder  = new StringBuilder();
		
		builder.append("----------------------------图书信息:-------------------------------------\n");
		builder.append("图书名称:").append(book.getName()).append("\n").append("\n");
		builder.append("作者:").append(book.getAuthor()).append("\n").append("\n");
		builder.append("出版社:").append(book.getPress()).append("\n").append("\n");
		
		builder.append("请输入您要进行的操作代码:  1.修改   2.删除  0.返回主菜单");
		
		System.out.println(builder);
		
		int num = scanner.nextInt();
		
		return num;
	}
	
	public static void update(int id){
		
		BookDao bookDao = new BookDao();
		
		//根据书藉的id查找书藉
		Book book = bookDao.get(id);
		
		StringBuilder builder  = new StringBuilder("----------------------------图书信息:-------------------------------------\n");
		
		builder.append("图书名称:").append(book.getName()).append("\n");
		builder.append("作者:").append(book.getAuthor()).append("\n");
		builder.append("出版社:").append(book.getPress()).append("\n");
		
		builder.append("新图书名称:").append("\n");
		
		System.out.println(builder);
		
		//读取用户输入的新的图书的名称
		String name = scanner.next();
		
	    System.out.println("新的作者:\n");
		
		//读取用户输入的新的作者的名字
		String author = scanner.next();
		
		 System.out.println("新的出版社:\n");
		
		//读取用户输入的新的出版社的名字
		String press = scanner.next();
		
		System.out.println("请输入您要进行的操作代码:  1.保存   2.放弃并返回主菜单");
		
		int num = scanner.nextInt();
		
		if(num == 1){
		
			book.setName(name);
			book.setAuthor(author);
			book.setPress(press);
			//执行修改
			bookDao.update(book);
		}else{
			
			BookProgram.start();
			
		}
		
	}
	
	public static int search(){
		
		String uiStr = "-------------------------图书信息搜索:-------------------------------------\n";
		uiStr += "图书名称:\n";
		
		System.out.println(uiStr);
		
		//保存图书名称
		String bookName = scanner.next();
	
		BookDao bookDao = new BookDao();
		
		List<Book> list = bookDao.searchByName(bookName);
		/*
		 * 遍历xml文件当中所有的书藉
		 */
	
		
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < list.size(); i++){
			
			Book book = list.get(i);
			
			builder.append(book.getId()).append(".");
			builder.append(book.getName()).append("\t");
			builder.append("作者：").append(book.getAuthor()).append("\t");
			builder.append("出版社：").append(book.getPress()).append("\n");
			
		}
		
	
		builder.append("\n").append("请输入您要进行的操作的书藉代码:  0.返回主菜单 ");
		
		System.out.println(builder);
		
		int num = scanner.nextInt();
		
		return num;
		
	}
	
	
	public static void main(String[] args) {
		mainMenu();
	}
}
