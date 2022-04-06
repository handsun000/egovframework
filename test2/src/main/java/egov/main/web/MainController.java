package egov.main.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.stringtemplate.v4.compiler.STParser.mapExpr_return;

import egov.main.domain.MainVO;
import egov.main.service.MainService;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Resource(name = "mainService")
	private MainService mainService;

	@RequestMapping("/mainTest")
	public String mainTest() {
		return "main/mainTest";
	}
	
	@RequestMapping("/main2.do")
	public String main2() {
		
		return "main/main2";
	}
	
	@RequestMapping("/main3.do")
	public String main3(@RequestParam("userNo")int userNo, @RequestParam("id")String userId, @RequestParam("pw")String userPw, HttpServletRequest request, ModelMap model) {
		
//		int userNo = Integer.parseInt(request.getParameter("userNo"));
//		String userId = request.getParameter("id");
//		String userPw = request.getParameter("pw");
		
		if(userId.equals("aaa")) {
			model.addAttribute("userId", "aaa");
		} else {
			model.addAttribute("userId", "다시 시도");
		}
		
		userNo = userNo + 5;
		model.addAttribute("userNo", userNo);
		model.addAttribute("userPw", userPw);
		
		return "main/main3";
	}
	
	@RequestMapping("/main4/{userNo}.do")
	public String main4(@PathVariable String userNo, HttpServletRequest request, ModelMap model) {
		
		model.addAttribute("userNo", userNo);
		return "main/main3";
	}
	
	@RequestMapping("/main5.do")
	public String main5(ModelMap model, MainVO vo) throws Exception {
		
		System.out.println("==========================================================");
		List<?> result = mainService.selectListMain(vo);
		System.out.println("==========================================="+result+"======================================================");
		model.addAttribute("resultList", result);
		System.out.println("==========================================================");
		return "main/main3";
	}
	
	@RequestMapping("/login.do")
	public String login() {
		
		return "login/login";
	}
	
	@RequestMapping("/loginSubmission.do")
	public String loginSession(HttpServletRequest request, ModelMap model, MainVO vo) throws Exception {
		
		int count = mainService.selectLoginMain(vo);
		
		if(vo.getUser_id().length()>10) {
			return "redirect:/login.do";
		}
		
		if(count == 0) {
			return "redirect:/login.do";
		}
		
		request.getSession().setAttribute("user_id", vo.getUser_id());
		
		model.addAttribute("userid", vo.getUser_id());
		model.addAttribute("userpw", vo.getUser_pw());
		
		System.out.println(count);
		logger.info("ST접속정보 기록===============");
		logger.info("유저아이디:"+vo.getUser_id()+", 접속날짜:");
		logger.info("ED접속정보 기록===============");
		
		return "main/main4";
	}
	
	@RequestMapping("/main4.do")
	public String main4() {
		
		
		return "main/main4";
	}
	
	@RequestMapping(value = "/exception.do")
	public String exception(HttpServletRequest request, ModelMap model) throws Exception {
		
		throw new Exception("사용자 임의의 에러 발생");
	}
	
}
