package cn.juke.util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.struts2.ServletActionContext;

import cn.juke.admin.action.BaseAction;
/**
 * ��֤����
 * @author Administrator
 *
 */
public class AuthCodeAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private HttpServletResponse response = ServletActionContext.getResponse();
	private HttpServletRequest request = ServletActionContext.getRequest(); 
	private String msg;//���ؽ��
	private String coderegPersonal;//����ע����֤����ܱ���   
	private String autoCode;	//����֤���ַ�
	public String autoCode() {
		try {
			int width = 70;
			int height = 28;
			// ȡ��һ��4λ�����ĸ�����ַ�
			String s = RandomStringUtils.random(4, true, true);
			// ������session,�������û���������бȽ�.
			// ע��Ƚ���֮�����session. 
			HttpSession session = request.getSession(true);
			session.setAttribute("authCode", s);  
			response.setContentType("images/jpeg");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0); 
			ServletOutputStream out = response.getOutputStream();
			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = image.getGraphics();
			// �趨����ɫ
			g.setColor(getRandColor(200, 250));
			g.fillRect(0, 0, width, height);
			// �趨����
			Font mFont = new Font("Times New Roman", Font.BOLD, 20);// ��������
			g.setFont(mFont);
			// ���߿�
			// g.setColor(Color.BLACK);
			// g.drawRect(0, 0, width - 1, height - 1);
			// ����������ߣ�ʹͼ���е���֤�벻�ױ��������̽�⵽
			g.setColor(getRandColor(160, 200));
			// ��������
			Random random = new Random();
			for (int i = 0; i < 155; i++) {
				int x2 = random.nextInt(width);
				int y2 = random.nextInt(height);
				int x3 = random.nextInt(12);
				int y3 = random.nextInt(12);
				g.drawLine(x2, y2, x2 + x3, y2 + y3);
			}
			// ����֤����ʾ��ͼ����
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(s, 2, 16);
			// ͼ����Ч
			g.dispose();
			// ���ͼ��ҳ��
			ImageIO.write((BufferedImage) image, "JPEG", out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private Color getRandColor(int fc, int bc) { // ��Χ��������ɫ
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	/**
	 * �����֤��
	 */
	public String checkCode(){
		String code=(String) super.getSession().get("authCode");
		if(code.equalsIgnoreCase(autoCode)){
			msg = "true";
		}else{
			msg = "false";
		}  
		return "isName";
	}
	/**
	 * ����ע����֤����֤
	**/
	 public String  regPersonal(){
		 String rp=(String) super.getSession().get("authCode"); 
		 if(rp.equalsIgnoreCase(coderegPersonal)){
				msg = "true";
		 }else{
				msg = "false";
		 }  
		return "isName";
	 }

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCoderegPersonal() {
		return coderegPersonal;
	}
	public void setCoderegPersonal(String coderegPersonal) {
		this.coderegPersonal = coderegPersonal;
	}
	public String getAutoCode() {
		return autoCode;
	}
	public void setAutoCode(String autoCode) {
		this.autoCode = autoCode;
	} 
}