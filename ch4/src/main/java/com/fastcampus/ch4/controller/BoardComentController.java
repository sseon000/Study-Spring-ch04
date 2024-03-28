package com.fastcampus.ch4.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.ch4.domain.BoardCommentDto;
import com.fastcampus.ch4.service.BoardCommentService;

//@Controller
@RestController
public class BoardComentController {
	@Autowired
	BoardCommentService boardCommentService;
	
	//  {
	//  "pcno":0,
	//      "comment" : "hihihi",
	//      "commenter" : "asdf"
	//}
	// 댓글을 수정하는 메서드
	@PatchMapping("/comments/{cno}")   // /ch4/comments/26  PATCH
	public ResponseEntity<String> modify(@PathVariable Integer cno, @RequestBody BoardCommentDto dto) {
	//  String commenter = (String)session.getAttribute("id");
	  String commenter = "asdf";
	  dto.setCommenter(commenter);
	  dto.setCno(cno);
	  System.out.println("dto = " + dto);
	
	  try {
	      if(boardCommentService.modify(dto)!=1)
	          throw new Exception("Write failed.");
	
	      return new ResponseEntity<>("MOD_OK", HttpStatus.OK);
	  } catch (Exception e) {
	      e.printStackTrace();
	      return new ResponseEntity<String>("MOD_ERR", HttpStatus.BAD_REQUEST);
	  }
	}
	
	//{
	//  "pcno":0,
	//      "comment" : "hi"
	//}
	// 댓글을 등록하는 메서드
	@PostMapping("/comments")   // /ch4/comments?bno=1085  POST
	public ResponseEntity<String> write(@RequestBody BoardCommentDto dto, Integer bno, HttpSession session) {
	//  String commenter = (String)session.getAttribute("id");
	  String commenter = "asdf";
	  dto.setCommenter(commenter);
	  dto.setBno(bno);
	  System.out.println("dto = " + dto);
	
	  try {
	      if(boardCommentService.write(dto)!=1)
	          throw new Exception("Write failed.");
	
	      return new ResponseEntity<>("WRT_OK", HttpStatus.OK);
	  } catch (Exception e) {
	      e.printStackTrace();
	      return new ResponseEntity<String>("WRT_ERR", HttpStatus.BAD_REQUEST);
	  }
	}
	
	// 지정된 댓글을 삭제하는 메서드
	@DeleteMapping("/comments/{cnt}") // comments/1?bno=1085 -> 삭제할 댓글 번호 & 글번호 (url에 매핑은 @PathVarialbe 사용, 쿼리스트링 ?뒤에 는 파라미터로 받음)
	//@ResponseBody Controller + ResponseBody -> RestController
	public ResponseEntity<String> remove(@PathVariable Integer cno, Integer bno, HttpSession session) {
//	String commenter = (String)session.getAttribute("id"); 로그인 안한 상태로 테스트
		String commenter = "asdf";
		try {
			int rowCnt = boardCommentService.remove(cno, bno, commenter);
			
			if(rowCnt != -1) {
				throw new Exception("delete failed");
			}
			
			return new ResponseEntity<>("DEL_OK", HttpStatus.OK); // 200
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("DEL_ERR", HttpStatus.BAD_REQUEST); // 400
		}
	}
	
	// 지정된 게시물의 모든 댓글을 가져오는 메서드
	@RequestMapping("/comments") // comments?bno=1080 GET
	//@ResponseBody Controller + ResponseBody -> RestController
	public ResponseEntity<List<BoardCommentDto>> list(Integer bno) {
		System.out.println(bno);
		List<BoardCommentDto> list = null;
		try {
			list = boardCommentService.getList(bno);
			return new ResponseEntity<List<BoardCommentDto>>(list, HttpStatus.OK); // 200
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<BoardCommentDto>>(HttpStatus.BAD_REQUEST); // 400
		}
	}
}
