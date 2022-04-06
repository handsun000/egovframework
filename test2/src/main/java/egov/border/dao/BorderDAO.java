package egov.border.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egov.border.domain.BorderVO;
import egov.border.domain.PointVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("borderDAO")
public class BorderDAO extends EgovAbstractDAO{

	public String insertBorder(BorderVO vo) {
		return (String)insert("borderDAO.insertBorder", vo);
	}

	public List<?> selectBorderList(BorderVO vo) {
		return list("borderDAO.selectBorderList",vo);
	}

	public BorderVO selectBorderDetail(int borderid) {
		return (BorderVO) select("borderDAO.selectBorderDetail", borderid);
	}
	
	public String insertBorderReply(BorderVO vo) {
		return (String) insert("borderDAO.insertBorderReply", vo);
	}

	public int updateBorderModify(BorderVO vo) {
		return (int) update("borderDAO.updateBorderModify", vo);
	}

	public int updateBorderDelete(BorderVO vo) {
		return (int) update("borderDAO.updateBorderDelete", vo);
	}

	public int selectBorderTotal(BorderVO vo) {
		return (int) select("borderDAO.selectBorderTotal", vo);
	}



}
