package com.springtest.study.mboard.board.model;

import java.io.Serializable;

public class Board implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2090092382720504878L;
	// board sequence
	private int sequence =0;
	// board 제목
	private String subject ="";
	// board 내용
	private String content ="";
	// 등록자 ID
	private String registrationId ="";
	// 등록 일자
	private String registrationDateTime = "";
	// 변경자 ID
	private String modificationId = "";
	// 변경 일자
	private String modificationDateTime = "";
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
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
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public String getRegistrationDateTime() {
		return registrationDateTime;
	}
	public void setRegistrationDateTime(String registrationDateTime) {
		this.registrationDateTime = registrationDateTime;
	}
	public String getModificationId() {
		return modificationId;
	}
	public void setModificationId(String modificationId) {
		this.modificationId = modificationId;
	}
	public String getModificationDateTime() {
		return modificationDateTime;
	}
	public void setModificationDateTime(String modificationDateTime) {
		this.modificationDateTime = modificationDateTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
