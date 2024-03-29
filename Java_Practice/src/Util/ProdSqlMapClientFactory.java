package Util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class ProdSqlMapClientFactory {
   private static SqlMapClient smc;
   
   static {
      
	   Charset charset = Charset.forName("utf-8");
	   Resources.setCharset(charset);
      
	   Reader rd =null;
      
	   try {
		   rd = Resources.getResourceAsReader("config/sqlMapConfig.xml");
		   smc=(SqlMapClientBuilder.buildSqlMapClient(rd));
         
	   } catch (IOException e) {
		   e.printStackTrace();
	   }finally {
		   if(rd!=null) try { rd.close(); } catch ( IOException e) {}
	   }
      
   	}

	public static SqlMapClient getSmc() {
		return smc;
	}
}
