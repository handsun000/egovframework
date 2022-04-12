package egovframework.example.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping("/list.do")
	public String list(ModelMap model) throws Exception {
		
		return "board/list";
	}
	
	@RequestMapping("/mgmt.do")
	public String test(ModelMap model) throws Exception {
		
		return "board/mgmt";
	}
	
	@RequestMapping("/view.do")
	public String view(ModelMap model) throws Exception {
		
		return "board/view";
	}
}
