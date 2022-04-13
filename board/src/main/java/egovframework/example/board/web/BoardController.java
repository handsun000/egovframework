package egovframework.example.board.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.board.service.BoardService;
import egovframework.example.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Resource(name = "boardService")
	private BoardService boardservice;
	
	@RequestMapping("/list.do")
	public String list(ModelMap model) throws Exception {
		System.out.println("리스트이다.");
		return "board/list";
	}
	
	@RequestMapping("/mgmt.do")
	public String test(ModelMap model) throws Exception {
		
		return "board/mgmt";
	}
	
	@RequestMapping("/view.do")
	public String view(ModelMap model) throws Exception {
		System.out.println("상세보기다");
		return "board/view";
	}
	
	@RequestMapping("/login.do")
	public String login(@RequestParam(value = "userid")String userid, @RequestParam(value = "password")String password, HttpServletRequest request, BoardVO vo, ModelMap model) throws Exception {
		
		vo.setUserid(userid);
		vo.setPassword(password);
		
		String username = boardservice.selectLoginCheck(vo);
		
		
		if(username != null && !"".equals(username)) {
			request.getSession().setAttribute("userid", userid);
			request.getSession().setAttribute("username", username);
		} else {
			request.getSession().setAttribute("userid", "");
			request.getSession().setAttribute("username", "");
			model.addAttribute("msg", "사용자 정보가 올바르지 않습니다.");
		}
		
		return"redirect:/list.do";
	}
}
