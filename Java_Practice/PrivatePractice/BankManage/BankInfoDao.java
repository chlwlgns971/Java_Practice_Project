package BankManage;

import java.util.List;

public interface BankInfoDao {
	
	/**
	 * 계좌번호, 은행명, 사용자이름을 입력받아 계좌생성
	 * @param bankVo
	 * @return 성공: 1 실패: 0
	 */
	public int insert(BankVO bankVo);
	
	/**
	 * 계좌번호를 입력받아 계좌정보 삭제
	 * @param bank_no
	 * @return 성공: 1 실패: 0
	 */
	public int delete(String bank_no);
	
	/**
	 * 해당 계좌번호의 사용자명, 은행명 수정
	 * @param bankVo
	 * @return 성공: 1 실패: 0
	 */
	public int update(BankVO bankVo);
	
	/**
	 * 전체 계좌번호 출력
	 * @return
	 */
	public List<BankVO> getAll();
	
	/**
	 * 계좌번호를 입력받아 중복체크
	 * @param bank_no
	 * @return 중복: 1 중복x: 0
	 */
	public int checkNo(String bank_no);
}
