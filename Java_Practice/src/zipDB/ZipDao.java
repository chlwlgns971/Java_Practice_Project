package zipDB;

import java.util.List;

public interface ZipDao {
	
	public List<ZipVO> selectByDong(String dong);
}
