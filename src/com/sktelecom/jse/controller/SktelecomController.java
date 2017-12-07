package com.sktelecom.jse.controller;

import javax.swing.JOptionPane;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.PhoneBean;
import com.sktelecom.jse.service.SktelecomService;
import com.sktelecom.jse.serviceImpl.SktelecomServiceImpl;

public class SktelecomController {

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
//	
	public static void main(String[] args) {
		SktelecomService service = new SktelecomServiceImpl();
		PhoneBean phone = null;
		MemberBean member = null;
		while(true) {
			switch(JOptionPane.showInputDialog("[MENU]?\n"
					                          +"0. 정지\n"
											  +"1. 개통\n"
					                          +"2. 요금정보")) {
				  case "0":
					  JOptionPane.showMessageDialog(null, "개통이 취소되었습니다.");
					  
					  return;
			      case "1":
			    	  phone = new PhoneBean();
			    	  member = new MemberBean();
			    	  phone.setName(JOptionPane.showInputDialog("1.갤럭시폰 2.아이폰"));
			    	  member.setName(JOptionPane.showInputDialog("who?"));
			    		JOptionPane.showMessageDialog(null, 
			    				service.showMessage(member,phone));
			    	  break;
			      case "2":
			    	  phone = new PhoneBean();
			    	  member = new MemberBean();
			    	  member.setName(JOptionPane.showInputDialog("who?"));
			    	  
			    	  JOptionPane.showMessageDialog(null, 
			    				service.showMessage(member,phone));
			    	  break;
			
			
			}
			
		}
		
		
	}
}
