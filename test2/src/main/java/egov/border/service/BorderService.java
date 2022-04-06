package egov.border.service;

import java.util.List;

import egov.border.domain.BorderVO;
import egov.border.domain.PointVO;

public interface BorderService {

	public String insertBorder(BorderVO vo) throws Exception;
	public List<?> selectBorderList(BorderVO vo) throws Exception;
	public BorderVO selectBorderDetail(int borderid) throws Exception;
	public String insertBorderReply(BorderVO vo) throws Exception;
	public int updateBorderModify(BorderVO vo) throws Exception;
	public int updateBorderDelete(BorderVO vo) throws Exception;
	public int selectBorderTotal(BorderVO vo) throws Exception;
}
