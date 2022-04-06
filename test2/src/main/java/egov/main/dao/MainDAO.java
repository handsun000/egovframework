package egov.main.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egov.main.domain.MainVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("mainDAO")
public class MainDAO extends EgovAbstractDAO{
	
	public List<?> selectListMain(MainVO vo) {
		return list("mainDAO.selectListMain", vo);
	}

	public int selectLoginMain(MainVO vo) {
		return (int) select("mainDAO.selectLoginMain", vo);
	}

}
