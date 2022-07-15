package MVC;

import java.util.List;

public class MemberServiceImpl implements IMemberService {
	
	private IMemberDao dao; // DAO 객체가 저장될 변수 선언
	   
	// 생성자   
   public MemberServiceImpl() {
      dao = new MemberDaoImpl(); // DAO 객체 생성
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

}
