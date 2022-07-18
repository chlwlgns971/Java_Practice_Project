package MVC;

import java.util.List;
import java.util.Map;

public class MemberServiceImpl implements IMemberService {
	//singleton 1번
	private static MemberServiceImpl service;
	
	private IMemberDao dao; // DAO 객체가 저장될 변수 선언
	   
	// 생성자 and Singleton 2번  
	private MemberServiceImpl() {
		//dao = new MemberDaoImpl(); // DAO 객체 생성
		dao=MemberDaoImpl.getInstance(); //DAO 객체 생성
	}
	//3번
	public static MemberServiceImpl getInstance() {
		if(service==null) service=new MemberServiceImpl();
		return service;
	}
    
	@Override
	public int insertMember(MemberVO memVo) {
		return dao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String id) {
		return dao.deleteMember(id);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return dao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public int getMemberIdCount(String id) {
		return dao.getMemberIdCount(id);
	}
	@Override
	public int updateMember2(Map<String, String> paramMap) {
		return dao.updateMember2(paramMap);
	}

}
