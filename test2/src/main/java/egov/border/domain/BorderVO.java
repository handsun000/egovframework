package egov.border.domain;

import java.util.Date;

public class BorderVO {

	public int borderid;
	public String bordertype;
	public int group_num;
	public int parentid;
	public int group_order;
	public int group_tab;
	public String userid;
	public String nickname;
	public Date writeday;
	public String writerip;
	public String editid;
	public String editip;
	public String title;
	public String bordertext;
	public int seecount;
	public String filename;
	public String filetype;
	public String fileurl;
	public int replycount;
	
	public int currentPageNo;
	public int recordCountPerPage;
	
	public int list_count;
	
	public int getList_count() {
		return list_count;
	}
	public void setList_count(int list_count) {
		this.list_count = list_count;
	}
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}
	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}
	public int getBorderid() {
		return borderid;
	}
	public void setBorderid(int borderid) {
		this.borderid = borderid;
	}
	public String getBordertype() {
		return bordertype;
	}
	public void setBordertype(String bordertype) {
		this.bordertype = bordertype;
	}
	public int getGroup_num() {
		return group_num;
	}
	public void setGroup_num(int group_num) {
		this.group_num = group_num;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public int getGroup_order() {
		return group_order;
	}
	public void setGroup_order(int group_order) {
		this.group_order = group_order;
	}
	public int getGroup_tab() {
		return group_tab;
	}
	public void setGroup_tab(int group_tab) {
		this.group_tab = group_tab;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getWriteday() {
		return writeday;
	}
	public void setWriteday(Date writeday) {
		this.writeday = writeday;
	}
	public String getWriterip() {
		return writerip;
	}
	public void setWriterip(String writerip) {
		this.writerip = writerip;
	}
	public String getEditid() {
		return editid;
	}
	public void setEditid(String editid) {
		this.editid = editid;
	}
	public String getEditip() {
		return editip;
	}
	public void setEditip(String editip) {
		this.editip = editip;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBordertext() {
		return bordertext;
	}
	public void setBordertext(String bordertext) {
		this.bordertext = bordertext;
	}
	public int getSeecount() {
		return seecount;
	}
	public void setSeecount(int seecount) {
		this.seecount = seecount;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	public int getReplycount() {
		return replycount;
	}
	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}
	
	
}
