package com.sktelecom.jse.service;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.PhoneBean;

public interface SktelecomService {


	String showMessage(MemberBean member, PhoneBean phone);
	String makeNumber();
	

}
