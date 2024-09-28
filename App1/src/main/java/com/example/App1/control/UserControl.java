package com.example.App1.control;


import com.example.App1.model.UserLoginInfo;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * Control类文件
 */
@Controller
@RequestMapping(path = "app")
public class UserControl {
    private static final Logger LOG = LoggerFactory.getLogger(UserControl.class);

    @Value("${loginmock.userName}")
    private String userName;

    @Value("${loginmock.password}")
    private String password;

    @PostConstruct
    public void init() {
        LOG.info("UserControl 启动啦");
    }

    //支持登录页，通过POST提交表单数据到登录校验页
    @GetMapping("/login")
    public String login(Model model){
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        model.addAttribute("userLoginInfo",userLoginInfo);
        return "login";
    }

    //登录校验页
    @PostMapping("/authenticate")
    public String authenticate(@Valid UserLoginInfo userLoginInfo,BindingResult errors, HttpServletRequest request, HttpServletResponse response){
        if (errors.hasErrors()) {
            // 如果校验不通过，返回用户编辑页面
            return "login";
        }

        HttpSession session = request.getSession();
        String name = userLoginInfo.getUserName();
        String pwd = userLoginInfo.getUserPassword();
        if (name.equals(userName)&&pwd.equals(password)){
            LocalDateTime nowDate = LocalDateTime.now();
            userLoginInfo.setUserId(String.valueOf(nowDate));
            session.setAttribute("userLoginInfo",userLoginInfo);
        }else{
            return "error";
        }

        return "success";
    }

}

