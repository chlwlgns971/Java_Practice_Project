package IBatis;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
   //private static SqlMapClient smc;
   private static SqlMapClient smc2;
   
   static {
      
	   Charset charset = Charset.forName("utf-8");
	   Resources.setCharset(charset);
      
	   //Reader rd =null;
	   Reader rd2=null;
      
	   try {
		   //rd = Resources.getResourceAsReader("config/sqlMapConfig.xml");
		   //smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		   rd2 = Resources.getResourceAsReader("config/sqlMapConfig2.xml");
		   smc2=(SqlMapClientBuilder.buildSqlMapClient(rd2));
         
	   } catch (IOException e) {
		   e.printStackTrace();
	   }finally {
		   //if(rd!=null) try { rd.close();    } catch ( IOException e) {}
		   if(rd2!=null) try { rd2.close();    } catch ( IOException e) {}
	   }
      
   	}

	public static SqlMapClient getSmc2() {
		return smc2;
	}

//	public static SqlMapClient getSmc() {
//		return smc;
//	}

}
