package egovframework.example.test.service;


import java.util.List;

import egovframework.example.test.domain.TestVO;

public interface TestService {

	public List<?> selectTest(TestVO testVO) throws Exception;
    }