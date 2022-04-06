package egov.main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egov.main.dao.MainDAO;
import egov.main.domain.MainVO;
import egov.main.service.MainService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("mainService")
public class MainServiceImpl extends EgovAbstractServiceImpl implements MainService {

	@Resource(name = "mainDAO")
	private MainDAO mainDAO;

	@Override
	public List<?> selectListMain(MainVO vo) throws Exception {
		return mainDAO.selectListMain(vo);
	}

	@Override
	public int selectLoginMain(MainVO vo) throws Exception {
		return mainDAO.selectLoginMain(vo);
	}

}
