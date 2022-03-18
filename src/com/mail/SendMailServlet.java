package com.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;


@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = (MemberDTO)request.getAttribute("member");
	    System.out.println(dto);
		String email1 = dto.getEmail1();
		String email2 = dto.getEmail2();
		String userid = dto.getUserid();
		String username = dto.getUsername();
		String passwd = dto.getPasswd();
		
		System.out.println(userid+"\t"+username);
		String host = "smtp.naver.com";
	    String subject = "아이디 찿기 결과";
	    String subject2 = "비밀번호 찿기 결과";
	    String subject3 = "회원탈퇴 안내";
	    String from = "sangwoo1245@naver.com"; //보내는 메일
	    String fromName = "SPOWEB";
	    String to = email1 + "@" + email2; //받는 메일
	    System.out.println(to);
	    String content = username + "님의 아이디는" + userid +"입니다";
	    String content2 = username + "님의 비밀번호는" + passwd +"입니다";
	    String content3 = username + "님 회원탈퇴 됬습니다.";
	    

	   try{
	     //프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
	     Properties props = new Properties();
	     //네이버 SMTP 사용시
	     props.put("mail.smtp.starttls.enable","true");
	     props.put("mail.transport.protocol","smtp");
	     props.put("mail.smtp.host", host);
	     
	     props.put("mail.smtp.port","465");  // 보내는 메일 포트 설정
	     props.put("mail.smtp.user", from);
	     props.put("mail.smtp.auth","true");
	     props.put("mail.smtp.debug", "true");
	     props.put("mail.smtp.socketFactory.port", "465");
	     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	     props.put("mail.smtp.socketFactory.fallback", "false");


	     Authenticator auth = new SendMail();
	     Session mailSession = Session.getDefaultInstance(props,auth);
	   
	     Message msg = new MimeMessage(mailSession);
	     msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName,"UTF-8","B"))); //보내는 사람 설정
	    InternetAddress[] address = {new InternetAddress(to)};
	    
	     msg.setRecipients(Message.RecipientType.TO, address); //받는 사람설정
	   
	     msg.setSubject(subject); //제목설정
	     msg.setSubject(subject2); //제목설정
	     msg.setSubject(subject3); //제목설정
	    msg.setSentDate(new java.util.Date()); //보내는 날짜 설정
	    msg.setContent(content,"text/html; charset=UTF-8"); //내용 설정(MIME 지정-HTML 형식)
	    msg.setContent(content2,"text/html; charset=UTF-8"); //내용 설정(MIME 지정-HTML 형식)
	    msg.setContent(content3,"text/html; charset=UTF-8"); //내용 설정(MIME 지정-HTML 형식)
	    
	     Transport.send(msg); //메일 보내기

	     }catch(MessagingException ex){
	      System.out.println("mail send error : "+ex.getMessage());
	       ex.printStackTrace();
	     }catch(Exception e){
	      System.out.println("error : "+e.getMessage());
	       e.printStackTrace();
	     }
	   
	     response.sendRedirect("LoginUIServlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
