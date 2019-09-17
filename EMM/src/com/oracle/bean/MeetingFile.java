package com.oracle.bean;
public class MeetingFile {
private int fileId;      //文件id
private String filename;   //文件名 
private String filedesc;    //描述
private String filepath;    //路径
private String uploader;      //上传人
public String getUploader() {
    return uploader;
}
public void setUploader(String uploader) {
    this.uploader = uploader;
}
public String getFilepath() {
    return filepath;
}
public void setFilepath(String filepath) {
    this.filepath = filepath;
}
public int getFileId() {
    return fileId;
}
public void setFileId(int fileId) {
    this.fileId = fileId;
}
public String getFilename() {
    return filename;
}
public void setFilename(String filename) {
    this.filename = filename;
}
public String getFiledesc() {
    return filedesc;
}
public void setFiledesc(String filedesc) {
    this.filedesc = filedesc;
}
public MeetingFile(int fileId, String filename, String filedesc, String filepath, String uploader) {
    super();
    this.fileId = fileId;
    this.filename = filename;
    this.filedesc = filedesc;
    this.filepath = filepath;
    this.uploader = uploader;
}
public MeetingFile(String filename, String filedesc, String filepath, String uploader) {
    super();
    this.filename = filename;
    this.filedesc = filedesc;
    this.filepath = filepath;
    this.uploader = uploader;
}
public MeetingFile(String filename) {
    super();
    this.filename = filename;
}
public MeetingFile() {
    super();
}

}
