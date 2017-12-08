package com.sktelecom.jse.service;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.PhoneBean;

public interface SktelecomService {


	public String showMessage(MemberBean member, PhoneBean phone);
	public String makelist();
	public void addUser(MemberBean member, PhoneBean phone);
	public String createPhoneNum();
	public String createCustomNum();
	public String findByKey(String key);    //키는 커스터넘버를 의미한다.
	public String findByName(String name);
	public void updatePhoneNumber(String key);
	public void deleteMember(String key);
	
	
}
