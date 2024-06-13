package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	//전체조회 : URI - boardList / RETURN - board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.boardList();
		model.addAttribute("boards", list);
		
		return "board/boardList";
		//	classpath:/templates/ + board/boardList + .html
	}
	
	//단건조회 : URI - boardInfo / PARAMETER - boardVO(QueryString)
	//         RETURN - board/boardInfo
	@GetMapping("boardInfo")				//페이지 전달 Model...
	public String boardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.boardInfo(boardVO);
		model.addAttribute("board", findVO);
						  // ㄴ 이게 boardInfo.html에서 씀ㅇㅇ
		return "board/boardInfo";
	}

	//등록 - 페이지 : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm() {  //일반적인 <form/>활용
		return "board/boardInsert";
	}
	//등록 - 처리  : URI - bordInsert / PARAMETER - BoardVO(QueryString)
	// 			   RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
		boardService.insertBoard(boardVO);
		return "redirect:boardList";
	}

//=========================================================
	
	
	//수정 - 페이지 : URI - boardUpdate / PARAMETER - BoardVO(QueryString)
	//  		   RETURN - board/boardUpdate
	// => 사실상 단건조회
	@GetMapping("boardUpdate")
	public String boardUpdateForm(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.boardInfo(boardVO);
		model.addAttribute("board", findVO);
		
		return "board/boardUpdate";
	}
	
	//수정 - 처리   : URI - boardUpdate / PARAMETER - BoardVO(JSON)
	// 			   RETURN - 수정결과 데이터 (Map)
	// => 사실상 등록
	//무엇을 보고 AJAX인지 파악? => return...하는게 페이지가 아니라 데이터면 ajax.
	@PostMapping("boardUpdate")
	@ResponseBody //Ajax라는 의미임 ㅇㅇ
	public Map<String, Object> boardUpdateJson(@RequestBody BoardVO boardVO){
		return boardService.updateBoard(boardVO);
	}
	
	//삭제 - 처리   : URI - boardDelete / PARAMETER - Integer
	//				RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete") //쓸수도 있고 안쓸수도 있음. RequestParam을 명시하면 무조건 값을 입력해야함.
	public String boardDelete(Integer bno) {
		boardService.deleteBoard(bno);
		return "redirect:boardList";
	}
}
