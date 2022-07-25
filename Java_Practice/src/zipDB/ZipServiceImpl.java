package zipDB;

import java.util.List;

public class ZipServiceImpl implements ZipService {
	private ZipDao dao;
	private static ZipService service;
	
	public ZipServiceImpl() {
		dao=ZipDaoImpl.getInstance();
	}
	public static ZipService getInstance() {
		if(service==null) service=new ZipServiceImpl();
		return service;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		return dao.selectByDong(dong);
	}

}
