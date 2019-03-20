package com.sinc.project.ctrl;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.project.model.vo.MailVO;
import com.sinc.project.model.vo.MemberVO;
import com.sinc.project.service.MailService;
import com.sinc.project.service.MeetingRoomInfoService;
import com.sinc.project.service.ToiletInfoService;

@Controller
public class MainController {

	@Resource(name="toiletInfoService")
	private ToiletInfoService toiletInfoService;

	@Resource(name="meetingRoomInfoService")
	private MeetingRoomInfoService meetingRoomInfoService;
	
	@Resource(name="mailService")
	private MailService mailService;
	
	@RequestMapping(value = "/mailWriter.do", method = RequestMethod.GET)
	public String mailWriter(Model model) {
		return "mailWriter";
	}
	
	/**
	 * 전체 화장실 사용여부 조회
	 * @return
	 */
	@RequestMapping(value="/getTotalToiletUseInfo.do", method=RequestMethod.POST)
	@ResponseBody
	public List<Object> getTotalToiletUseInfo () {
		
		System.out.println("getTotalToiletUseInfo Controller");
		List<Object> result = toiletInfoService.getTotalToiletUseInfo();	// 화장실 사용정보 전체 조회
  		System.out.println(result);
  		
		return result;
	}
	
	/**
	 * 특정 성별 화장실 사용여부 조회
	 * @param gender
	 * @return
	 */
	@RequestMapping(value="/getToiletUseInfoByGender.do", method=RequestMethod.POST)
	@ResponseBody
	public List<Object> getToiletUseInfoByGender (String gender) {
		
		System.out.println("getToiletUseInfoByGender Controller");
		System.out.println("gender : " + gender); 
		List<Object> result = toiletInfoService.getToiletUseInfoByGender(gender);	// 화장실 사용정보 전체 조회
  		System.out.println(result);
  		
		return result;
	}
	
	/**
	 * 특정 층의 화장실 사용여부 조회
	 * @param floor
	 * @param gender
	 * @return
	 */
	
	@RequestMapping(value="/getToiletUseInfo.do")
	@ResponseBody
	public List<Object> getToiletUseInfo (int floor, String gender) {
		
		System.out.println("getToiletUseInfo Controller");
		System.out.println("floor : "+ floor+ ", gender : " + gender); 

		
		//JSONArray result = toiletInfoService.getToiletUseInfo(floor, gender) ;	// 특정 층 화장실 사용정보 조회
		return toiletInfoService.getToiletUseInfo(floor, gender); 
	}
	
	/**
	 * 화장실 사용여부 수정
	 * @param code
	 * @param useyn
	 * @return
	 */
	@RequestMapping(value="/updateToiletUseInfo.do")
	@ResponseBody
	public int updateToiletUseInfo (int code, String useyn) {
		
		System.out.println("updateToiletUseInfo Controller");
		System.out.println("code "+ code);
		System.out.println("useyn "+ useyn);
		
		return toiletInfoService.updateToiletUseInfo(code, useyn);			// 화장실 사용정보 수정
	}
	/**
	 * 전체 회의실 사용여부 조회
	 * @return
	 */
	@RequestMapping(value="/getTotalMeetingRoomUseInfo.do", method=RequestMethod.POST)
	@ResponseBody
	public List<Object> getTotalMeetingRoomUseInfo () {
		
		System.out.println("getTotalMeetingRoomUseInfo Controller");
		List<Object> result = meetingRoomInfoService.getTotalMeetingRoomUseInfo();	// 회의실 사용정보 전체 조회
		System.out.println(result);
		
		return result;
	}
	
	/**
	 * 특정 층의 회의실 사용여부 조회
	 * @param floor
	 * @return
	 */
	@RequestMapping(value="/getMeetingRoomUseInfo.do", method=RequestMethod.POST)
	@ResponseBody
	public List<Object> getMeetingRoomUseInfo (int floor) {
		
		System.out.println("getMeetingRoomUseInfo Controller");
		System.out.println("floor "+ floor);
		List<Object> result = meetingRoomInfoService.getMeetingRoomUseInfo(floor);	// 특정 층 회의실 사용정보 조회
		System.out.println(result);
		return result;
	}
	
	/**
	 * 회의실 사용여부 수정
	 * @param code
	 * @param useyn
	 * @return
	 */
	@RequestMapping(value="/updateMeetingRoomUseInfo.do")
	@ResponseBody
	public int updateMeetingRoomUseInfo (int code, String useyn) {
		
		System.out.println("updateMeetingRoomUseInfo Controller");
		System.out.println("code "+ code);
		System.out.println("useyn "+ useyn);
		
		return meetingRoomInfoService.updateMeetingRoomUseInfo(code, useyn);			// 회의실 사용정보 수정
	}
	
	/**
	 * 멤버의 토큰 정보 입력
	 * @param memberSeq
	 * @param token
	 * @return
	 */
	@RequestMapping(value="/putTokenInfo.do", method=RequestMethod.POST)
	@ResponseBody
	public int mergeToken (String Memberseq, String Token) {
		
		System.out.println("mergeToken Controller");
		System.out.println("memberseq "+ Memberseq);
		System.out.println("token "+ Token);
		
		return mailService.mergeToken(Memberseq, Token);	// 멤버의 토큰 정보 입력
	}
	
	/**
	 * 메일 보내기
	 * @param sender
	 * @param recipient
	 * @param title
	 * @param contents
	 * @return
	 */
	@RequestMapping(value="/sendMail.do", method=RequestMethod.POST)
	@ResponseBody
	public int sendMail (String sender, String recipient, String title, String contents) {
		System.out.println("mergeToken Controller");
		
		MailVO senderMail = new MailVO();
		senderMail.setSender(sender);
		senderMail.setRecipient(recipient);
		senderMail.setTitle(title);
		senderMail.setContents(contents);
		senderMail.setSmode("SEND");
		mailService.addMail(senderMail);	// 보내는 메일 정보 입력
		
		MailVO recipientMail = new MailVO();
		recipientMail.setSender(recipient);
		recipientMail.setRecipient(sender);
		recipientMail.setTitle(title);
		recipientMail.setContents(contents);
		recipientMail.setSmode("RECEIVE");
		int mailSeq = mailService.addMail(recipientMail);	// 받는 메일 정보 입력
		
		if (mailService.compareKeyword(recipient, title)) {	// 키워드와 메일 제목을 비교한 후 일치하는 경우 알람
			MemberVO senderInfo = (MemberVO)mailService.getMemberInfo(sender);
			mailService.sendFCM(senderInfo, recipient, title, mailSeq);
		}
		return 0;	
	}
	
	/**
	 * 키워드 추가
	 * @param memberseq
	 * @param keyword
	 * @return
	 */
	@RequestMapping(value="/addKeyword.do", method=RequestMethod.POST)
	@ResponseBody
	public int addKeyword (String memberseq, String keyword) {
		
		System.out.println("addKeyword Controller");
		System.out.println("memberseq "+ memberseq);
		System.out.println("keyword "+ keyword);
		
		return mailService.addKeyword(memberseq, keyword);	// 키워드 추가
	}
	
	/**
	 * 키워드 삭제 후 조회
	 * @param memberseq
	 * @param keyword
	 * @return
	 */
	@RequestMapping(value="/deleteKeywordAndGet.do", method=RequestMethod.POST)
	@ResponseBody
	public List<Object> deleteKeywordAndGet (String memberseq, String keyword) {
		
		System.out.println("deleteKeywordAndGet Controller");
		System.out.println("memberseq "+ memberseq);
		System.out.println("keyword "+ keyword);
		
		return mailService.deleteKeyword(memberseq, keyword);	// 키워드 삭제 후 조회
	}
}
