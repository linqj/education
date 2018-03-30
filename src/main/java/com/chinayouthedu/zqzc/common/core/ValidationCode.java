package com.chinayouthedu.zqzc.common.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chinayouthedu.zqzc.common.utils.ToolDateTime;
import com.chinayouthedu.zqzc.config.constants.Constants;

/**
 * 验证码
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年2月1日 下午12:55:54
 * @version 1.0
 */
public class ValidationCode {
	
	private static Logger log = LoggerFactory.getLogger(ValidationCode.class);
	
	private static int w = 70;
	private static int h = 26;
	
	/**
	 * 效验登录验证码
	 * @param session	session对象
	 * @param validateCode	表单传输进来的验证码
	 * @return
	 */
	public static boolean validSessionCode(HttpSession session,String validateCode){
		String vCodeFromSession = session.getAttribute(Constants.VALIDATE_CODE).toString();
		if(StringUtils.isBlank(validateCode)||StringUtils.isBlank(vCodeFromSession)){
			return false;
		}
		return Objects.equals(validateCode.toLowerCase().trim(), vCodeFromSession.toLowerCase().trim());
	
	}

	/**
	 * 创建图片验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public static void createImage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		
		/*
		 * 得到参数高，宽，都为数字时，则使用设置高宽，否则使用默认值
		 */
		String width = request.getParameter("width");
		String height = request.getParameter("height");
		if (StringUtils.isNumeric(width) && StringUtils.isNumeric(height)) {
			w = NumberUtils.toInt(width);
			h = NumberUtils.toInt(height);
		}
		
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();

		/*
		 * 生成背景
		 */
		createBackground(g);

		/*
		 * 生成字符
		 */
		String s = createCharacter(g);
		g.dispose();
	
		OutputStream out = response.getOutputStream();
		try {
			log.info("本次生成的验证码为["+s+"],当前时间["+ToolDateTime.dateToDateString(new Date())+"]");
			boolean write = ImageIO.write(image, "JPEG", out);
			if(write){
				// 添加到session
				request.getSession().setAttribute(Constants.VALIDATE_CODE, s);
//				log.info("验证码图片流传输成功！");
			}else{
				log.info("验证码图片流传输失败！");
			}
		} catch (Exception e) {
			log.info("验证码流传输发生异常！");
			e.printStackTrace();
		} finally {
			out.close();
		}
		
		
		
		
	}
	
	/**
	 * 获取随机的颜色
	 * @param fc
	 * @param bc
	 * @return
	 */
	public static Color getRandColor(int fc,int bc) { 
		int f = fc;
		int b = bc;
		Random random=new Random();
        if(f>255) {
        	f=255; 
        }
        if(b>255) {
        	b=255; 
        }
        return new Color(f+random.nextInt(b-f),f+random.nextInt(b-f),f+random.nextInt(b-f)); 
	}
	
	public static void createBackground(Graphics g) {
		// 填充背景
		g.setColor(getRandColor(220,250)); 
		g.fillRect(0, 0, w, h);
		// 加入干扰线条
		for (int i = 0; i < 8; i++) {
			g.setColor(getRandColor(40,150));
			Random random = new Random();
			int x = random.nextInt(w);
			int y = random.nextInt(h);
			int x1 = random.nextInt(w);
			int y1 = random.nextInt(h);
			g.drawLine(x, y, x1, y1);
		}
	}

	public static String createCharacter(Graphics g) {
		char[] codeSeq = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
				'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };
		String[] fontTypes = {"Arial","Arial Black","AvantGarde Bk BT","Calibri"}; 
		Random random = new Random();
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			String r = String.valueOf(codeSeq[random.nextInt(codeSeq.length)]);//random.nextInt(10));
			g.setColor(new Color(50 + random.nextInt(100), 50 + random.nextInt(100), 50 + random.nextInt(100)));
			g.setFont(new Font(fontTypes[random.nextInt(fontTypes.length)],Font.BOLD,26)); 
			g.drawString(r, 15 * i + 5, 19 + random.nextInt(8));
//			g.drawString(r, i*w/4, h-5);
			s.append(r);
		}
		return s.toString();
	}

}
