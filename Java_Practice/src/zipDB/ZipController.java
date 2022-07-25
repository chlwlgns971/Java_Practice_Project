package zipDB;

import java.util.List;
import java.util.Scanner;

public class ZipController {
	private ZipService service;
	Scanner sc=new Scanner(System.in);
	
	private ZipController() {
		service=new ZipServiceImpl().getInstance();
	}

	public static void main(String[] args) {
		new ZipController().selectByDong();
	}
	public void selectByDong() {
		List<ZipVO> list=null;
		System.out.print("검색할 동 이름을 입력해주세요>>");
		String str=sc.next();
		list=service.selectByDong(str);
		if(list==null) System.out.println("검색하신 이름의 동 이름은 존재하지 않습니다.");
		else {
			for(ZipVO vo : list) {
				String zipcode=vo.getZipcode();
				String sido=vo.getSido();
				String gugun=vo.getGugun();
				String dong=vo.getDong();
				String ri=vo.getRi();
				String bldg=vo.getBldg();
				String bunji=vo.getBunji();
				int seq=vo.getSeq();
				
				System.out.println(zipcode+"\t"+sido+"\t"+gugun+"\t"+dong+"\t"+ri+"\t"+bldg+"\t"+bunji+"\t"+seq+"\t");
			}
		}
	}

}
