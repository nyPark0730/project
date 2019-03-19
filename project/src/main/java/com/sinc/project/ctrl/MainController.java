package com.sinc.project.ctrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.project.model.vo.MailVO;
import com.sinc.project.model.vo.TokenVO;
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
	@RequestMapping(value="/updateToiletUseInfo.do", method=RequestMethod.POST)
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
	@RequestMapping(value="/updateMeetingRoomUseInfo.do", method=RequestMethod.POST)
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
		mailService.addMail(recipientMail);	// 받는 메일 정보 입력
		
		// 키워드 비교
		mailService.compareKeyword(recipient, title);
		
		mailService.sendFCM(recipient);
		return 0;	
	}
}
