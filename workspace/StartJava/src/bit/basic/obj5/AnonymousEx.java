package bit.basic.obj5;
//☆
public class AnonymousEx {
	public static void main(String[] args) {
		AnonymousEx ex = new AnonymousEx();
		ex.anonymousMethod1();
		
		ex.i.validate();
		ex.i.fileOpen();
		ex.i.fileCheck();
	}
	
	//Variable
	private int x,y;
	private AbleInterface i = new AbleInterface() {
		
		@Override
		public void validate() {
			// TODO Auto-generated method stub
			System.out.println("instance_fileCheck");
		}
		
		@Override
		public void fileOpen() {
			// TODO Auto-generated method stub
			System.out.println("instance_fileOpen");
		}
		
		@Override
		public void fileCheck() {
			// TODO Auto-generated method stub
			System.out.println("instance_validate");
		}
	};
	//Method
	public void anonymousMethod1() {
		AbleInterface anoy = new AbleInterface() {//익명클래스
			int yy;
			@Override
			public void fileCheck() {
				// TODO Auto-generated method stub
				System.out.println("loacl_fileCheck");
				x = 99;// == AnonymousEx.this.x = 99;
			}

			@Override
			public void fileOpen() {
				// TODO Auto-generated method stub
				System.out.println("loacl_fileOpen");
			}

			@Override
			public void validate() {
				// TODO Auto-generated method stub
				System.out.println("loacl_validate");
			}
	
		};
		
		anoy.fileCheck();
		anoy.fileOpen();
		anoy.validate();
	}
}
