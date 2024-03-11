package com.fastcampus.ch4.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.domain.PageHandler;
import com.fastcampus.ch4.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@PostMapping("/remove")
	public String remove(Integer bno, Model m, Integer page, Integer pageSize, HttpSession session, RedirectAttributes rattr) {
		String writer = (String)session.getAttribute("id");
		try {
			// 모델에 추가하면 redirect시 uri = /board/list?page=x&pageSize=x 자동추가
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			
			int rowCnt = boardService.remove(bno, writer);
			
			if(rowCnt!=1) {
				throw new Exception("board remove error");
			}
			//m.addAttribute("msg", "DEL_OK"); 모델에 담을시 리다이렉트 된 페이지에서 새로고침시 파라미터에 남아있어서 동작이 매끄럽지 않음
			// RedirectAttributes rattr 사용
			// addFlashAttribute 세션에 잠깐 이용
			rattr.addFlashAttribute("msg", "DEL_OK");
			
		} catch(Exception e) {
			e.printStackTrace();
			//m.addAttribute("msg", "DEL_ERR");
			rattr.addFlashAttribute("msg", "DEL_ERR");
		}
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/read")
	public String read(Integer bno, Model m, Integer page, Integer pageSize) {
		try {
			BoardDto boardDto = boardService.read(bno);
//			m.addAttribute("boardDto", boardDto); 아래와 동일
			m.addAttribute(boardDto);
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "board";
	}

	@GetMapping("/list")
	//public String list(int page, int pageSize, Model m, HttpServletRequest request) { int page, int pageSize 일 경우 page, pageSize가 null인 경우 에러 
	public String list(Integer page, Integer pageSize, Model m, HttpServletRequest request) {
		if(!loginCheck(request)) {
			return "redirect:/login/login?toURL="+request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동
		}

		if(page == null) page = 1;
		if(pageSize == null) pageSize = 10;
		
		try {
			int totalCnt = boardService.getCount();
			PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize); 
			
			Map map = new HashMap();
			map.put("offset", (page-1)*10);
			map.put("pageSize", pageSize);
			
			List<BoardDto> list = boardService.getPage(map);
			m.addAttribute("list", list);
			m.addAttribute("ph", pageHandler);
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "boardList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
	}

	private boolean loginCheck(HttpServletRequest request) {
		// 1. 세션을 얻어서
		HttpSession session = request.getSession();
		// 2. 세션에 id가 있는지 확인, 있으면 true를 반환
		return session.getAttribute("id")!=null;
	}
}