package egov.border.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egov.border.dao.BorderDAO;
import egov.border.domain.BorderVO;
import egov.border.domain.PointVO;
import egov.border.service.BorderService;

@Service("borderService")
public class BorderServiceImpl implements BorderService{

	@Resource(name = "borderDAO")
	public BorderDAO borderDAO;
	
	@Override
	public String insertBorder(BorderVO vo) throws Exception {
		return borderDAO.insertBorder(vo);
	}

	@Override
	public List<?> selectBorderList(BorderVO vo) throws Exception {

		return borderDAO.selectBorderList(vo);
	}

	@Override
	public BorderVO selectBorderDetail(int borderid) throws Exception {
		return borderDAO.selectBorderDetail(borderid);
	}

	@Override
	public String insertBorderReply(BorderVO vo) throws Exception {
		return borderDAO.insertBorderReply(vo);
	}

	@Override
	public int updateBorderModify(BorderVO vo) throws Exception {
		return borderDAO.updateBorderModify(vo);
	}

	@Override
	public int updateBorderDelete(BorderVO vo) throws Exception {
		return borderDAO.updateBorderDelete(vo);
	}

	@Override
	public int selectBorderTotal(BorderVO vo) throws Exception {
		return borderDAO.selectBorderTotal(vo);
	}




}
