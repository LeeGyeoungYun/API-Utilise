package net.daum.vo;

import lombok.Data;

@Data
public class ReplyVO {
	
	private int rno;				//댓글번호
	private int pno;				//게시판 번호
	private String replyId;		    //댓글 아이디
	private String replyPwd;        //댓글 패스워드
	private String replyComment;    //댓글 내용
	private int replyClass;		    //댓글과 대댓글을 구별하기 위함 댓글이면 0, 대댓글이면 1로 표시 
	private int replyOrder;			//댓글과 대댓글 관계에 맞게 정렬되어 페이지에 정렬된 상태로 전달하기 위해서 추가
	private int replyGroupNum;	    //대댓글이 특정 댓글에 종속되어있다는 것을 표시하기 위한 수단
	private String create_date;     //생성일
	private String update_date;		//수정일
	private String delete_date;	    //삭제일

}
