import java.util.*;

//�Ļ�޴� ���ϱ�
public class SelectMenu {

	public static void main(String[] args) {
		Menu mn=new Menu();
		ArrayList menu=new ArrayList<>();
		menu=mn.menuList();
		//���ɸ޴�
		double randomValue=Math.random();
		int index=(int)(randomValue*menu.size());
		//System.out.println(index);
		System.out.println("���ɸ޴��� "+menu.get(index));
		
		//����޴�
		menu.remove(index);
		double randomValue2=Math.random();
		int index2=(int)(randomValue2*menu.size());
		//System.out.println(index2);
		System.out.println("����޴��� "+menu.get(index2));
		
	}

}
class Menu{
	ArrayList menuList(){
		ArrayList<String> menu=new ArrayList<>(Arrays.asList("������ �������","�ٿ�«��(����«�� ����)","����ŷ","Į���� ����� �����","���", 
				"7930�մԽ�Ź(���,�Ľ�Ÿ)","�ݼ����","�κ�Į����","���ڻ� �����ؽ���(�߰���, ��Į����)","��������(�����)","3�� �Ұ�ⱹ��","¥����","���ϼ�(�߱���)",
				"����","��ġ�","�ݼ� Ħ�ø�","�Ŵ�Į����(����Į����)","Ȳ��(�����)","ȭ�򺻰�(��������, �쵿, �ø�)","��������","�溹�� �츮���(�ѽĺ���)","���ӽ������ص���",
				"�׾Ƹ�����","�ɴ��̳�(���)","���̸�������","�����","�̽����̰� ������","���","��������","����(�߱���)"));
		return menu;
	}
}