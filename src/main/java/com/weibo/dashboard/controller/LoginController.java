package com.weibo.dashboard.controller;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weibo.util.CaptchaUtil;

@RestController
@RequestMapping(value="/user")
public class LoginController {

	@RequestMapping("/check.jpg")  
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {  
        // 通知浏览器不要缓存  
        response.setHeader("Expires", "-1");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setHeader("Pragma", "-1");  
        CaptchaUtil util = CaptchaUtil.Instance();  
        // 将验证码输入到session中，用来验证  
        String code = util.getString();  
        request.getSession().setAttribute("code", code);  
        // 输出打web页面  
        ImageIO.write(util.getImage(), "jpg", response.getOutputStream());  
    }  
	
	
	/** 
     * 验证码验证 
     *  
     * @param session 
     * @param code 
     */  
    private void checkCode(HttpSession session, String code) {  
        String codeSession = (String) session.getAttribute("code");  
        if (StringUtils.isEmpty(codeSession)) {  
            /*log.error("没有生成验证码信息");  
            throw new IllegalStateException("ERR-01000");*/  
        }  
        if (StringUtils.isEmpty(code)) {  
            /*log.error("未填写验证码信息");  
            throw new BussinessException("ERR-06018");  */
        }  
        if (codeSession.equalsIgnoreCase(code)) {  
            // 验证码通过  
        } else {  
           /* log.error("验证码错误");  
            throw new BussinessException("ERR-06019");  */
        }  
    }  
}
