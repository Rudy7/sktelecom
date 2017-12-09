package com.sktelecom.jse.serviceImpl;

import javax.swing.JOptionPane;
import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.PhoneBean;
import com.sktelecom.jse.service.SktelecomService;

public class SktelecomServiceImpl implements SktelecomService {
	// sktelecom 대리점 만들기
	// 폰 : galaxy 하고 iphone 2개만 취급한다. 이 2개는 상수처리 해줘라.
	// 번호 : 랜덤생성 010 - 0000 - 0000 8자리 랜덤생성
	// 이름 : 가입자 이름
	//
	// 어떤폰 하시겠습니다. 1번은 갤럭시 2번은 아이폰
	// 1을 누르면 갤럭시 픽스,
	// 이름 물어보고,
	// 주민번호 생략
	// 전화번호는 랜덤으로 ~~입니다. 전화번호 몇번입니까? 안 물어본다.
	//
	// 알려줘요 마지막에.
	// 홍길동님 이름으로 010-0000-0000 갤럭시 폰이 개통되었습니다.
	// 투스트링은 서비스에 하자 . 빈에서 네임과 넘버를 게터세터한다.
	MemberBean[] members;
	PhoneBean[] phones;
	PhoneBean phone;
	private int memberCount, phoneCount, customNum;

	public SktelecomServiceImpl() {
		memberCount = phoneCount = 0;
		customNum = 1000;
		members = new MemberBean[10];
		phones = new PhoneBean[10];
	}

	@Override
	public String showMessage(MemberBean member, PhoneBean phone) {
		addUser(member, phone);
		String message = String.format("[%s]님 이름으로\n " + "[%s]  [%s]이\n  " + "개통되었습니다.  ", member.getName(),
				phone.getName(), phone.getNumber());
		return message;
	}

	@Override
	public void addUser(MemberBean member, PhoneBean phone) {
		// 커스텀넘버는 무조건 4자리로...1000 부터 1씩 증가. 1번고객이 1000 이다.
		String customNum = createCustomNum();
		System.out.println("생성된 커스텀 넘버 : " + customNum);
		member.setCustomNum(customNum);
		phone.setCustomNum(customNum);
		phone.setNumber(createPhoneNum());
		System.out.println("가입자이름 :" + member.getName());
		System.out.println("가입번호 :" + phone.getNumber());

		this.members[memberCount++] = member;
		this.phones[phoneCount++] = phone;
	}

	@Override
	public String createCustomNum() {
		return String.valueOf(customNum++);
	}

	@Override
	public String makelist() { // 리스트,목록
		String r = "";
		for (int i = 0; i < memberCount; i++) {
			String m1 = "[고객번호]" + members[i].getCustomNum();
			String m2 = "[이름]" + members[i].getName();
			String p1 = "[고객번호]" + phones[i].getCustomNum();
			String p2 = "[폰명]" + phones[i].getName();
			String p3 = "[폰번호]" + phones[i].getNumber() + "\n";
			String m = m1 + m2;
			String p = p2 + p3;
			if (m1.equalsIgnoreCase(p1)) {
				r += m + p + "\n";
			}
		}
		return r;
	}

	@Override
	public String createPhoneNum() { // 랜덤 전화번호
		int c1 = (int) (Math.random() * 10);
		int c2 = (int) (Math.random() * 10);
		int c3 = (int) (Math.random() * 10);
		int c4 = (int) (Math.random() * 10);
		int c5 = (int) (Math.random() * 10);
		int c6 = (int) (Math.random() * 10);
		int c7 = (int) (Math.random() * 10);
		int c8 = (int) (Math.random() * 10);
		String res = ("010-" + c1 + c2 + c3 + c4 + "-" + c5 + c6 + c7 + c8);
		return res;
	}

	@Override // 고객번호로 고객정보 알아내기
	public String findByKey(String key) {
		String res = "";
		for (int i = 0; i < memberCount; i++) {
			if (key.equalsIgnoreCase(members[i].getCustomNum())) {
				String m1 = "[고객번호]" + members[i].getCustomNum();
				String m2 = "[이름]" + members[i].getName();
				String p2 = "[폰명]" + phones[i].getName();
				String p3 = "[폰번호]" + phones[i].getNumber() + "\n";
				res = m1.concat(m2 + p2 + p3);
			}
		}
		return res;
	}

	@Override
	public String findByName(String name) {
		// 동명이인 입력해서 2명이상 나오나 확인하기
		String res = "";
		for (int i = 0; i < memberCount; i++) {
			if (name.equals(members[i].getName())) {
				String m1 = "[고객번호]" + members[i].getCustomNum();
				String m2 = "[이름]" + members[i].getName();
				String p2 = "[폰명]" + phones[i].getName();
				String p3 = "[폰번호]" + phones[i].getNumber() + "\n";
				res += m1.concat(m2 + p2 + p3);
			}
		}
		return res;
	}

	@Override // 번호 변경
	public void updatePhoneNumber(String key) {
		String res = "", changeNum = "";
		boolean flag = true;
		for (int i = 0; i < memberCount; i++) {
			if (key.equals(members[i].getCustomNum())) {
				JOptionPane.showMessageDialog(null, members[i].getName() + " 고객님 정말 번호를 변경하시겠습니까?");
				int c1 = (int) (Math.random() * 10);
				int c2 = (int) (Math.random() * 10);
				int c3 = (int) (Math.random() * 10);
				int c4 = (int) (Math.random() * 10);
				int c5 = (int) (Math.random() * 10);
				int c6 = (int) (Math.random() * 10);
				int c7 = (int) (Math.random() * 10);
				int c8 = (int) (Math.random() * 10);
				res = ("010-" + c1 + c2 + c3 + c4 + "-" + c5 + c6 + c7 + c8);
				if (res.equals(phones[i].getNumber())) {
					while (flag) {
						if (res.equals(phones[i].getNumber())) {
							c1 = (int) (Math.random() * 10);
							c2 = (int) (Math.random() * 10);
							c3 = (int) (Math.random() * 10);
							c4 = (int) (Math.random() * 10);
							c5 = (int) (Math.random() * 10);
							c6 = (int) (Math.random() * 10);
							c7 = (int) (Math.random() * 10);
							c8 = (int) (Math.random() * 10);
							res = ("010-" + c1 + c2 + c3 + c4 + "-" + c5 + c6 + c7 + c8);
							flag = true;
						} else {
							changeNum = res;
							phones[i].setNumber(changeNum);
							String m1 = "[고객번호]" + members[i].getCustomNum();
							String m2 = "[이름]" + members[i].getName();
							String p3 = "[폰번호]" + phones[i].getNumber();
							JOptionPane.showMessageDialog(null, m1 + m2 + "님의 번호가  " + changeNum + "으로 변경되었습니다.");
							flag = false;
						}
					}
				} else {
					changeNum = res;
					phones[i].setNumber(changeNum);
					String m1 = "[고객번호]" + members[i].getCustomNum();
					String m2 = "[이름]" + members[i].getName();
					String p3 = "[폰번호]" + phones[i].getNumber();
					JOptionPane.showMessageDialog(null, m1 + m2 + "님의 번호가  " + changeNum + "으로 변경되었습니다.");

				}

			}
		}
	}

	@Override // 회원 탈퇴
	public void deleteMember(String key) {
		String res = "";
		for (int i = 0; i < memberCount; i++) {
			if (key.equals(members[i].getCustomNum())) {
				JOptionPane.showMessageDialog(null, members[i].getName() + " 고객님 정말 탈퇴를 하시겠습니까?");
				this.members[i] = null;
				this.phones[i] = null;
				members[i] = members[memberCount - 1];
				phones[i] = phones[memberCount - 1];
				members[memberCount - 1] = null;
				phones[memberCount - 1] = null;
				memberCount--;
				// 일단 킵한다.
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다.");
	}
}
