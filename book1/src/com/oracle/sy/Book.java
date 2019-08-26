package com.oracle.sy;
/**
 *    图书类
 * @author luomo
 *
 */
public class Book {
private Integer id;
private String name;    //图书名
private String author;  //作者
private String press;    //出版社
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPress() {
	return press;
}
public void setPress(String press) {
	this.press = press;
}
@Override
public String toString() {
	return "Book [id=" + id + ", name=" + name + ", author=" + author + ", press=" + press + "]";
}

}
