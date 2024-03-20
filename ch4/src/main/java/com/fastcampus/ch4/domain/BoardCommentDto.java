package com.fastcampus.ch4.domain;

import java.util.Date;
import java.util.Objects;

public class BoardCommentDto {
	private Integer cno;
	private Integer bno;
	private Integer pcno;
	private String boardcomment;
	private String commenter;
	private Date reg_date;
	private Date up_date;
	
	public BoardCommentDto() {}
	
	public BoardCommentDto(Integer bno, Integer pcno, String boardcomment, String commenter) {
		this.bno = bno;
		this.pcno = pcno;
		this.boardcomment = boardcomment;
		this.commenter = commenter;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bno, boardcomment, cno, commenter, pcno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardCommentDto other = (BoardCommentDto) obj;
		return bno == other.bno && Objects.equals(boardcomment, other.boardcomment) && cno == other.cno
				&& Objects.equals(commenter, other.commenter) && pcno == other.pcno;
	}

	public Integer getCno() {
		return cno;
	}
	
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	
	public Integer getBno() {
		return bno;
	}
	
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	
	public Integer getPcno() {
		return pcno;
	}
	
	public void setPcno(Integer pcno) {
		this.pcno = pcno;
	}
	
	public String getBoardcomment() {
		return boardcomment;
	}
	
	public void setBoardcomment(String boardcomment) {
		this.boardcomment = boardcomment;
	}
	
	public String getCommenter() {
		return commenter;
	}
	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}
	
	public Date getReg_date() {
		return reg_date;
	}
	
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	public Date getUp_date() {
		return up_date;
	}
	
	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}
	
	@Override
	public String toString() {
		return "BoardCommentDto [cno=" + cno + ", bno=" + bno + ", pcno=" + pcno + ", boardcomment=" + boardcomment
				+ ", commenter=" + commenter + ", reg_date=" + reg_date + ", up_date=" + up_date + "]";
	}
	
}

