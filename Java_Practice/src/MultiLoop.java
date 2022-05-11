import java.util.Scanner;

public class MultiLoop {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		MultiLoop2 m2=new MultiLoop2();
//		System.out.print("���ڸ� �Է��ϼ���: ");
//		int num=sc.nextInt();
//		for(int i=1; i<=9; i++){
//			System.out.println(num+"*"+i+"="+num*i);
//		}
		System.out.print("for�� 2�� ����Ͽ� ���������");
		m2.doubleFor();
		System.out.println("--------------------");
		System.out.println("while�� 2�� ����Ͽ� ���������");
		m2.doubleWhile();
		//m2.insertnumForLoop(); //�Է¼��� ������ 3ȸ �ݺ�
		//m2.doubleForRandom(); // 3���� ū �����ȿ��� ������ 5�� ������Ű�� �� ���ϱ�
		//m2.insertnumWhileLoop(); //�Է¼��� ������ ���ѹݺ�(q������ ���ᰡ��)
		//m2.continueTest(); //1���� 100�߿��� ¦�� ���(continue �̿�)
		m2.continueTest2();
	}

}
class MultiLoop2{ //1
	public void doubleFor(){
		for (int i=1; i<=9; i++){
			for (int j=1; j<=9; j++){
				System.out.println(i+"*"+j+"="+i*j);
			}
		}
	}
	public void doubleWhile(){
		int i=1;
		while(i<10){
			int j=1;
			while(j<10){
				System.out.println(i+"*"+j+"="+i*j);
				j++;
			}
			i++;
		}
	}
	public void insertnumForLoop(){
		Scanner sc=new Scanner(System.in);
		for(int i=1; i<4; i++){
			System.out.println("���ڸ� �Է��ϼ���: ");
			int num=sc.nextInt();
			for (int j=1; j<10; j++){
				System.out.println(num+"*"+j+"="+num*j);
			}
		}	
	}
	public void doubleForRandom(){ //3
		String str="";
		int hap=0; //������ �ݺ��� �ۿ��� �ϰ� �ʱ�ȭ�� �ݺ��� �ȿ��� �ϴ� ���� ����.(��� ����Ǹ� �޸� ���ɿ� ������ ������ ��ħ)
		int rand=0;
		for(int i=0; i<3; i++){
			str="";
			hap=0;
			for(int j=0; j<5; j++){
				rand=(int)(Math.random()*100+1);
				str+=rand+" ";
				hap+=rand;
			}
			System.out.println(i+1+"��° ���� ������: "+str);
			System.out.println(i+1+"��° ���� �������� ��: "+hap);
		}
	}
	public void insertnumWhileLoop(){//4,���ѷ��� while(true) ���� for(int i=0; ;i++)���� ���ǽ� ���ֵ� ���ѷ��� ��������
		Scanner sc=new Scanner(System.in);
		String str="";
		while(true){
			System.out.print("���ϴ� ������ ���ڸ� �Է��ϼ���: ");
			str=sc.nextLine();
			if(str.equals("q")){
				System.out.println("������ �����մϴ�."); 
				break;
			}
			else{
				try {
					int num=Integer.parseInt(str);
					for (int j=1; j<10; j++){
						System.out.println(num+" * "+j+" = "+num*j);
					} 
				}
				catch (Exception e) {
					System.out.println("�߸��� �� �Է��Դϴ�.");
				}
				
			}
		}
	}
	public void continueTest(){ //continueTest1
		String str1="";
		String str2="";
		for(int i=1; i<=100; i++){
			if (i%2==0) str1+=i+" ";
		}
		System.out.println("¦��: "+str1);
		System.out.println("------------------------------------");
		for(int i=1; i<=100; i++){
			if (i%2!=0) continue;
			str2+=i+" ";
		}
		System.out.println("continue ¦���� "+str2+"�Դϴ�.");
	}
	public void continueTest2(){ //continueTest2
		String str1="";
		String str2="";
		for(int i=1; i<=100; i++){
			if (i%3==0) str1+=i+" ";
		}
		System.out.println("3�� ���: "+str1);
		System.out.println("------------------------------------");
		for(int i=1; i<=100; i++){
			if (i%3!=0) continue;
			str2+=i+" ";
		}
		System.out.println("3�� ����� "+str2+"�Դϴ�.");
	}
	
}