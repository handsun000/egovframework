package egov.main.service;

import java.util.List;

import egov.main.domain.MainVO;

public interface MainService {

	public List<?> selectListMain(MainVO vo) throws Exception;
	public int selectLoginMain(MainVO vo) throws Exception;
	
	
}
