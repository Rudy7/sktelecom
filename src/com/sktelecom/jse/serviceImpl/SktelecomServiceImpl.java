package com.sktelecom.jse.serviceImpl;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.PhoneBean;
import com.sktelecom.jse.service.SktelecomService;

public class SktelecomServiceImpl implements SktelecomService {
//	sktelecom 대리점 만들기
//	폰 : galaxy 하고 iphone  2개만 취급한다.   이 2개는 상수처리 해줘라.
//	번호 : 랜덤생성  010 - 0000 - 0000   8자리 랜덤생성
//	이름 :  가입자 이름
//
//	어떤폰 하시겠습니다.  1번은 갤럭시 2번은 아이폰
//	1을 누르면 갤럭시 픽스,  
//	이름 물어보고, 
//	주민번호 생략
//	전화번호는 랜덤으로 ~~입니다.  전화번호 몇번입니까? 안 물어본다. 
//
//	알려줘요 마지막에.  
//	홍길동님 이름으로 010-0000-0000 갤럭시 폰이 개통되었습니다.
//  투스트링은  서비스에 하자	. 빈에서 네임과 넘버를 게터세터한다.
	MemberBean[] members;
	PhoneBean[] phones;
	PhoneBean phone;
	private int memberCount,phoneCount,customNum;
	public SktelecomServiceImpl() {
		memberCount = phoneCount = 0;
		customNum = 1000;
		members = new MemberBean[3];
		phones = new PhoneBean[3];
	}
		
	@Override
	public String showMessage(MemberBean member, PhoneBean phone) {
		phone.setNumber(createPhoneNum());
		addUser(member,phone);
		String message = 
				String.format("[%s]님 이름으로\n"
							+ "[%s]으로 [%s]이\n"
							+ "개통되었습니다." , member.getName(),
							phone.getNumber(),
							phone.getName()
							);
		return message;
	}
	@Override
	public void addUser(MemberBean member, PhoneBean phone) {	
		//커스텀넘버는 무조건 4자리로...1000 부터 1씩 증가. 1번고객이 1000 이다. 
		String customNum = createCustomNum();
		System.out.println("생성된 커스텀 넘버 : " +customNum);
		member.setCustomNum(customNum);
		phone.setCustomNum(customNum);
				this.members[memberCount++] = member;
				this.phones[phoneCount++] = phone; 
	}
	@Override
	public String createCustomNum() {
		return String.valueOf(customNum++);
	}
	 
	@Override
	public String makelist() { // 이름, 커스텀넘버, 폰넘버, 
		    String r = "";
			for(int i=0; i<memberCount; i++){
				String m1 = "[고객번호]" + members[i].getCustomNum() + "\t";
				String m2 = "[이름]" + members[i].getName() + "\t";
				String p1 = "[고객번호]" + phones[i].getCustomNum() + "\t";
				String p2 = "[폰명]" + phones[i].getName() + "\t";
				String p3 = "[폰번호]" + phones[i].getNumber() + "\t";
				
				String m = m1 + m2;
				String p = p1 + p2 + p3;
				if(m1.equals(p1)){
					r += m + p + "\n";
		    }
		}
		   return r;
	}	   
	@Override
	public String createPhoneNum() {		
//		int r1 = (int)(Math.random()*9999+0000);
//		int r2 = (int)(Math.random()*9999+0000);
//		String res = (r1+ "-" +r2);
	
		  int c1 = (int)(Math.random()*10);
		  int c2 = (int)(Math.random()*10);
		  int c3 = (int)(Math.random()*10);
		  int c4 = (int)(Math.random()*10);
		  int c5 = (int)(Math.random()*10);
		  int c6 = (int)(Math.random()*10);
		  int c7 = (int)(Math.random()*10);
		  int c8 = (int)(Math.random()*10);
	String res = ("010-"+ c1+c2+c3+c4+"-"+c5+c6+c7+c8);
	System.out.println(res);
		
		return res;		
	}
}




	
