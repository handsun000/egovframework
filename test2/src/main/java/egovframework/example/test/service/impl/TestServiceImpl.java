package egovframework.example.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.test.dao.TestDAO;
import egovframework.example.test.domain.TestVO;
import egovframework.example.test.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource(name = "testDAO")
	private TestDAO testDAO;

	@Override
	public List<?> selectTest(TestVO testVO) throws Exception {
		return testDAO.selectTest(testVO);
	}
}