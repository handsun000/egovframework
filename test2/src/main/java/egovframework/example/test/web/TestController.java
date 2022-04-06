package egovframework.example.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.test.domain.TestVO;
import egovframework.example.test.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testServiceImpl;

	@RequestMapping(value = "/testList.do")
	public String testListDo(TestVO testVO, Model model) throws Exception {

		System.out.println("이거 맞냐 =============================================================================");
		model.addAttribute("list", testServiceImpl.selectTest(testVO));
		return "test/testList";
	}
}