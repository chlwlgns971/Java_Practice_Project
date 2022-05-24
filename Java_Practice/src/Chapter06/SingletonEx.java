package Chapter06;

/*Singleton Class
 * 	-��ü ���α׷����� Ŭ���� ��ü�� �ϳ��� �����ǰ� �ش� ��ü�� �ʿ��� ������ �ش� ��ü�� �ּҰ��� ����
 * 	-������ �޼ҵ��� ���������ڷ� private�� ����Ͽ� �ܺο��� Ŭ���� ��ü�� ���� �������� ����
 * 	-Ŭ���� ���ο��� �ڽ��� Ÿ���� ��ü�� �����Ͽ� �ʱ�ȭ
 * 	-�ܺο��� ȣ�Ⱑ���� getInstance()���� ���
 * 	-Spring���� ���� ���
 * 	-Thread�� ����� ���� ����
 */

public class SingletonEx {

	public static void main(String[] args) {
		//s1�� static���� ����Ǿ��� ������ new�����ڸ� ���� ��ü������ ���� ����.
		//	->���� �׳� Ŭ���� �̸��� ���� ȣ���� �����ϵ�, �޼��忡�� static�� �ٿ��� �Ѵ�.
		//���� block�̿�: �ν��Ͻ��� ���� ������ �������� �ƴ϶� Ŭ���� �ε� ����
		Singleton s1=Singleton.getInstance();
		System.out.println(s1);
		
		Singleton s2=Singleton.getInstance();
		System.out.println(s2);
		System.out.println();
		
		//�ν��Ͻ��� �ʿ��� �������� ��ü ����
		Singleton01 st1=Singleton01.getInstance();
		System.out.println(st1);
		Singleton01 st2=Singleton01.getInstance();
		System.out.println(st2);
		
		//������ ó��
		Singleton02 sg1=Singleton02.getInstance();
		System.out.println(st1);
		Singleton02 sg2=Singleton02.getInstance();
		System.out.println(st2);
	}

}
//���� block�̿�: �ν��Ͻ��� ���� ������ �������� �ƴ϶� Ŭ���� �ε� ����(�� ������)
class Singleton{
	private static Singleton s1;
	private Singleton(){}
	static{
		try{
			s1=new Singleton();
		}
		catch(Exception e){
			throw new RuntimeException("Create Instance fail"+"msg="+e.getMessage());
		}
	}
	public static Singleton getInstance(){
		return s1;
	}
}
//�ν��Ͻ��� �ʿ��� �������� ��ü ���� (���ֻ��)
class Singleton01{
	private static Singleton01 s1;
	private Singleton01(){}
	public static Singleton01 getInstance(){
		if(s1==null) s1=new Singleton01();
		return s1;
	}
}
//������ ó�� ����
class Singleton02{
	private static Singleton02 s1;
	private Singleton02(){}
	public static synchronized Singleton02 getInstance(){
	//�����忡�� ���� ���ٹ��� �ذ�->but �ð��� ���� �ҿ�Ǿ� �������ϰ� �Ͼ
		if(s1==null) s1=new Singleton02();
		return s1;
	}
}
//������ ó�� ����+���ɰ���(�̳�Ŭ���� �̿�)
class Singleton03{
	private static Singleton03 s1;
	private Singleton03(){}
	private static class InnerInstance{
		final static Singleton03 s1=new Singleton03();
	}
	public static Singleton03 getInstance(){
		return InnerInstance.s1;
	}
}