package com.sinc.project;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinc.project.model.vo.MailVO;
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
		mailService.mergeToken("p90jxi", "testing");
	}
		
	@Test
	public void getTokenInfoTest() {
		TokenVO mamberToken = mailService.getTokenInfo("p90jxi");
	}
	
	@Test
	public void sendFCMTest() {
		mailService.sendFCM("p90jxi");
	}
	
	@Test
	public void compareKeywordTest() {
		mailService.compareKeyword("p90jxi", "물류");
	}
}
