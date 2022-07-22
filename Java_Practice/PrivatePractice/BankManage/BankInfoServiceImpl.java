package BankManage;

import java.util.List;

public class BankInfoServiceImpl implements BankInfoService {
	//singleton 1번
	private static BankInfoServiceImpl service;
	
	private BankInfoDaoImpl dao; // DAO 객체가 저장될 변수 선언
	   
	// 생성자 and Singleton 2번  
	private BankInfoServiceImpl() {
		dao=BankInfoDaoImpl.getInstance(); //DAO 객체 생성
	}
	//3번
	public static BankInfoServiceImpl getInstance() {
		if(service==null) service=new BankInfoServiceImpl();
		return service;
	}

	@Override
	public int insert(BankVO bankVo) {
		return dao.insert(bankVo);
	}

	@Override
	public int delete(String bank_no) {
		return dao.delete(bank_no);
	}

	@Override
	public int update(BankVO bankVo) {
		return dao.update(bankVo);
	}

	@Override
	public List<BankVO> getAll() {
		return dao.getAll();
	}
	@Override
	public int checkNo(String bank_no) {
		return dao.checkNo(bank_no);
	}

}
