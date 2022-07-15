package MVC;

import java.util.List;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성해서 Service에 전달하는 DAO의 Interface
 * 각 메서드 하나가 DB와 관련된 작업 1개를 수행하도록 작성한다.
 * @author PC-21
 *
 */
public interface IMemberDao {
	/**
	 * MemberCO에 담겨진 자료를 DB에 insert하는 메서드
	 * @param memVo
	 * @return insert성공: 1, insert실패:0
	 */
	public int insertMember(MemberVO memVo);
	
	/**
	 * 회원ID를 인수값으로 받아서 해당 회원 정보를 삭제하는 메서드
	 * @param id
	 * @return 삭제성공: 1, 삭제실패: 0
	 */
	public int deleteMember(String id);
	
	/**
	 * MemberVO자료를 이용하여 회원 정보를 수정하는 메서드
	 * @param memVo update할 회원정보가 저장된 MemberVO객체
	 * @return 수정성공:1, 수정실패:0
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * 전체 회원 정보를 가져와서 List에 담아서 반환하는 메서드
	 * @return MemberVO객체가 저장된 List객체
	 */
	public List<MemberVO>getAllMember();
	
	/**
	 * 회원ID를 인수값으로 받아서 해당 회원ID의 개수를 반환하는 메서드
	 * @param id 검색할 회원ID
	 * @return 검색된 회원 ID의 개수
	 */
	public int getMemberIdCount(String id);
}
