package egov.border.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egov.border.dao.PointDAO;
import egov.border.domain.PointVO;
import egov.border.service.PointService;

@Service("pointService")
public class PointServiceImpl implements PointService {

	@Resource(name = "pointDAO")
	PointDAO pointDAO;
	
	@Override
	public String proctest(PointVO vo) throws Exception {
		return pointDAO.proctest(vo);
	}
	
}
