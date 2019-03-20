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
		recipientMail.setRecipient("p90jx1"); 
		recipientMail.setSender("p90jxi");
		recipientMail.setSmode("SEND");
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
		String recipient = "p90jxi";
		String title = "물류 프로젝트 테스트 결과 공유드립니다.";
		int mailSeq = 45;
		mailService.sendFCM(senderInfo, recipient, title, mailSeq);
	}
	
	@Test
	public void compareKeywordTest() {
		System.out.println(mailService.compareKeyword("p90jxi", "물류 프로젝트 테스트 결과 공유드립니다.")) ;
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
}
