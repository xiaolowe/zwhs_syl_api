package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chat_log database table.
 * 
 */
@Entity
@Table(name="chat_log")
@NamedQuery(name="ChatLog.findAll", query="SELECT c FROM ChatLog c")
public class ChatLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="add_time")
	private int addTime;

	@Column(name="f_id")
	private int fId;

	@Column(name="f_ip")
	private String fIp;

	@Column(name="f_name")
	private String fName;

	@Column(name="t_id")
	private int tId;

	@Column(name="t_msg")
	private String tMsg;

	@Column(name="t_name")
	private String tName;

	public ChatLog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAddTime() {
		return this.addTime;
	}

	public void setAddTime(int addTime) {
		this.addTime = addTime;
	}

	public int getFId() {
		return this.fId;
	}

	public void setFId(int fId) {
		this.fId = fId;
	}

	public String getFIp() {
		return this.fIp;
	}

	public void setFIp(String fIp) {
		this.fIp = fIp;
	}

	public String getFName() {
		return this.fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public int getTId() {
		return this.tId;
	}

	public void setTId(int tId) {
		this.tId = tId;
	}

	public String getTMsg() {
		return this.tMsg;
	}

	public void setTMsg(String tMsg) {
		this.tMsg = tMsg;
	}

	public String getTName() {
		return this.tName;
	}

	public void setTName(String tName) {
		this.tName = tName;
	}

}