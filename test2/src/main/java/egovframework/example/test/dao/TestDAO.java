package egovframework.example.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.test.domain.TestVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("testDAO")
public class TestDAO extends EgovAbstractDAO{

	public List<?> selectTest(TestVO testVO) {
		return list("testDAO.selectTest", testVO);
	}

}