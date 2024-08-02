package com.board.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	
	private Long idx;
	private String title;
	private String content;
	private String writer;
	private int viewCnt;
	private String noticeYn;
	private String secretYn;
	private String deleteYn;
	private LocalDateTime inserTime;
	private LocalDateTime updateTime;
	private LocalDateTime deleteTime;
//	public Long getIdx() {
//		return idx;
//	}
//	public void setIdx(Long idx) {
//		this.idx = idx;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public String getWriter() {
//		return writer;
//	}
//	public void setWriter(String writer) {
//		this.writer = writer;
//	}
//	public int getViewCnt() {
//		return viewCnt;
//	}
//	public void setViewCnt(int viewCnt) {
//		this.viewCnt = viewCnt;
//	}
//	public String getNoticeYn() {
//		return noticeYn;
//	}
//	public void setNoticeYn(String noticeYn) {
//		this.noticeYn = noticeYn;
//	}
//	public String getSecretYn() {
//		return secretYn;
//	}
//	public void setSecretYn(String secretYn) {
//		this.secretYn = secretYn;
//	}
//	public String getDeleteYn() {
//		return deleteYn;
//	}
//	public void setDeleteYn(String deleteYn) {
//		this.deleteYn = deleteYn;
//	}
//	public LocalDateTime getInserTime() {
//		return inserTime;
//	}
//	public void setInserTime(LocalDateTime inserTime) {
//		this.inserTime = inserTime;
//	}
//	public LocalDateTime getUpdateTime() {
//		return updateTime;
//	}
//	public void setUpdateTime(LocalDateTime updateTime) {
//		this.updateTime = updateTime;
//	}
//	public LocalDateTime getDeleteTime() {
//		return deleteTime;
//	}
//	public void setDeleteTime(LocalDateTime deleteTime) {
//		this.deleteTime = deleteTime;
//	}

}
