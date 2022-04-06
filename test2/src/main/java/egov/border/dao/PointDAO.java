package egov.border.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import egov.border.domain.PointVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("pointDAO")
public class PointDAO extends EgovAbstractDAO{

	@Transactional
	public String proctest(PointVO vo) {
		return (String) insert("pointDAO.proctest", vo);
	}

}
