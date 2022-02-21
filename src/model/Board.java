package model;

import java.util.Date;

public class Board {
	private int num;
	private String writer;
	private String subject;
	private String content;
	private String pass;
	private String file1;
	private String boardid;
	private Date regdate;
	private String ip;
	private int readcnt;
	private int ref;
	private int reflevel1;
	private int refstep;
	public Board() {
		
	}
	
	public Board(int num, String writer, String subject, String content, String pass, String file1, String boardid,
			Date regdate, String ip, int readcnt, int ref, int reflevel1, int refstep) {
		super();
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.pass = pass;
		this.file1 = file1;
		this.boardid = boardid;
		this.regdate = regdate;
		this.ip = ip;
		this.readcnt = readcnt;
		this.ref = ref;
		this.reflevel1 = reflevel1;
		this.refstep = refstep;
	}
	
	
	@Override
	public String toString() {
		return "Board [num=" + num + ", writer=" + writer + ", subject=" + subject + ", content=" + content + ", pass="
				+ pass + ", file1=" + file1 + ", boardid=" + boardid + ", regdate=" + regdate + ", ip=" + ip
				+ ", readcnt=" + readcnt + ", ref=" + ref + ", reflevel1=" + reflevel1 + ", refstep=" + refstep + "]";
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	public String getBoardid() {
		return boardid;
	}
	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getReflevel1() {
		return reflevel1;
	}
	public void setReflevel1(int reflevel1) {
		this.reflevel1 = reflevel1;
	}
	public int getRefstep() {
		return refstep;
	}
	public void setRefstep(int refstep) {
		this.refstep = refstep;
	}
	
}