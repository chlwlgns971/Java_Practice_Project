package Log4j;

import org.apache.log4j.Logger;
public class Log4jTest {
	//Logger클래스의 인스턴스를 받아온다.
	static Logger logger=Logger.getLogger(Log4jTest.class);
	public static void main(String[] args) {
		//log기록을 남기는 방법
		//형식1) Logger객체변수.로그레벨명("출력할 메세지");
		//형식2) Logger객체변수.log(level.로그레벨명,"출력할 메세지");
		logger.trace("이것은 Trace 로그레벨입니다.");
		logger.debug("이것은 debug 로그레벨입니다.");
		logger.info("이것은 Info 로그레벨입니다.");
		logger.warn("이것은 warn 로그레벨입니다.");
		logger.error("이것은 error 로그레벨입니다.");
		logger.fatal("이것은 fatal 로그레벨입니다.");
	}

}
