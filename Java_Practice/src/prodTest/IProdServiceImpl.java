package prodTest;

import java.util.List;

public class IProdServiceImpl implements IProdService {
	private IProdDao dao;
	private static IProdService service;
	
	//생성자
	public IProdServiceImpl() {
		dao=IProdDaoImpl.getInstance();
	}
	public static IProdService getInstance() {
		if(service==null) service=new IProdServiceImpl();
		return service;
	}

	@Override
	public List<ProdVO> selectAll() {
		return dao.selectAll();
	}
}
