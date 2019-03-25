package com.sinc.project;

import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinc.project.model.vo.MailVO;
import com.sinc.project.model.vo.MemberVO;
import com.sinc.project.model.vo.TokenVO;
import com.sinc.project.service.MailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MailServiceTest {
	
	@Resource(name="mailService") 
	private MailService mailService;
	  
	@Test
	public void addKeywordTest() {
		mailService.addKeyword("p90jxi", "물류");
	};
	
	@Test
	public void getKeywordTest() {
		mailService.getKeyword("p90jxi");
	}
	
	@Test
	public void deleteKeywordTest() {
		mailService.deleteKeyword("p90jxi", "물류");
	}
	
	@Test
	public void addMailTest() {
		MailVO senderMail = new MailVO();
		senderMail.setContents("안뇽~~~");
		senderMail.setRecipient("p90jxi");
		senderMail.setSender("p90jx1");
		senderMail.setSmode("SEND");
		senderMail.setTitle("물류 프로젝트 테스트 결과 공유드립니다.");
		mailService.addMail(senderMail);
		
		MailVO recipientMail = new MailVO(); 
		recipientMail.setContents("안뇽~~~");
		recipientMail.setRecipient("p90jxi"); 
		recipientMail.setSender("p90jx1");
		recipientMail.setSmode("RECEIVE");
		recipientMail.setTitle("물류 프로젝트 테스트 결과 공유드립니다.");
		mailService.addMail(recipientMail);
		 
	}
	
	@Test
	public void mergeTokenTest() {
		mailService.mergeToken("p90jxi", "e2I-qtZ-NZo:APA91bGpRpZmN1AHrJ7jrDLF715hDxbW4EcNaS1vS2zv5gU7MctFsDCy7w9ga-c24_cn-9XUK_Q3DrP3lFTFhk9O_RipkAOcjQd9Au6RDTsYJAID-1TgjLQrmmDlJwz69s6lbwfKKQWz");
	}
		
	@Test
	public void getTokenInfoTest() {
		TokenVO mamberToken = mailService.getTokenInfo("p90jxi");
	}
	
	@Test
	public void sendFCMTest() {
		
		MemberVO senderInfo = new MemberVO();
		senderInfo.setMembername("박나영");
		senderInfo.setTeam("에브리데이");
		String recipient = "p90jx1";
		String title = "물류 프로젝트 테스트 결과 공유드립니다.";
		int mailSeq = 82;
		mailService.sendFCM(senderInfo, recipient, title, mailSeq);
	}
	
	@Test
	public void compareKeywordTest() {
		System.out.println(mailService.compareKeyword("p90jxi", "물류 프로젝트 테스트 결과 공유드립니다.", "안뇽~")) ;
	}
	
	@Test
	public void getMemberInfoTest() {
		System.out.println(mailService.getMemberInfo("p90jx1")) ;
	}
	
	@Test
	public void getMailTest() {
		HashMap<String, Object> mailInfo = (HashMap<String, Object>) mailService.getMail(47);
		System.out.println(mailInfo.get("SENDERNAME"));
		System.out.println(mailInfo);
	}
	
	@Test
	public void setMemberTest() {
		MemberVO mv = new MemberVO();
//		mv.setMemberseq("p90jxi");
//		mv.setMembername("최필성");
//		mv.setDepartment("ITO2");
//		mv.setTeam("면세점팀");
//		mv.setPhone("010-9347-9656");
//		mv.setEmail("p90jxi@shinsegae.com");
		
//		mv.setMemberseq("p90jx1");
//		mv.setMembername("박나영");
//		mv.setDepartment("ITO2");
//		mv.setTeam("에브리데이팀");
//		mv.setPhone("010-4736-0417");
//		mv.setEmail("p90jx1@shinsegae.com");
		
		mv.setMemberseq("p90jwv");
		mv.setMembername("김지영");
		mv.setDepartment("ITO2");
		mv.setTeam("프로퍼티팀");
		mv.setPhone("010-5955-6689");
		mv.setEmail("p90jwv@shinsegae.com");
		mailService.addMember(mv);
	}
}
