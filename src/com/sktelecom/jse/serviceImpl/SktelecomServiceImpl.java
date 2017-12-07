package com.sktelecom.jse.serviceImpl;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.PhoneBean;
import com.sktelecom.jse.service.SktelecomService;

public class SktelecomServiceImpl implements SktelecomService {
	MemberBean[] members;
	PhoneBean[] phones;
	private int memberCount,phoneCount;
	public SktelecomServiceImpl() {
		memberCount = phoneCount = 0;
		members = new MemberBean[2];
		phones = new PhoneBean[2];
	}
		
	@Override
	public String showMessage(MemberBean member, PhoneBean phone) {
		phone.setNumber(makeNumber());
		addUser(member,phone);
		String message = 
				String.format("[%s]님 이름으로\n"
							+ "[%s]으로 [%s]폰이\n"
							+ "개통되었습니다." , member.getName(),
							phone.getNumber(),
							phone.getName()
							);
		return message;
	}
	private void addUser(MemberBean member, PhoneBean phone) {	
		//커스텀넘버는 무조건 4자리로...1000 부터 1씩 증가. 1번고객이 1000 이다. 
				for(int i=1000; i<2147483647; i++) {
					member.addUser[i];
	}
				this.members[memberCount++] = member;
				this.phones[phoneCount++] = phone; 
	}		
	@Override
	public String makeNumber() {
		//Math.random()
		int randomValue = (int) Math.random();
		int number1 = (int)(randomValue*9000)+0000;
		
		int randomValue2 = (int) Math.random();
		int number2 = (int)(randomValue*9000)+0000;
	
		return (number1+ "-" + number2);
	}



	}
