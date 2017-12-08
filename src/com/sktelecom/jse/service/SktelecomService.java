package com.sktelecom.jse.service;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.PhoneBean;

public interface SktelecomService {


	public String showMessage(MemberBean member, PhoneBean phone);
	public String makelist();
	public void addUser(MemberBean member, PhoneBean phone);
	public String createPhoneNum();
	public String createCustomNum();

}
