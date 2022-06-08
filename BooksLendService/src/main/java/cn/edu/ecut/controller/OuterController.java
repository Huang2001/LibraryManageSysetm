package cn.edu.ecut.controller;

import cn.edu.ecut.pojo.ReaderInfo;
import cn.edu.ecut.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.swing.StringUIClientPropertyKey;

@Controller
@RequestMapping("/feign")
public class OuterController
{
    @Autowired
   private ReaderInfoService readerInfoService;

    @RequestMapping("queryUserInfo")
   public ReaderInfo queryUserInfoByNameAndPassword(String username, String password)
    {
        if(StringUtils.hasLength(username)&&StringUtils.hasLength(password))
        {
          return  readerInfoService.queryUserInfoByNameAndPassword(username,password);
        }
        else
        {
            return null;
        }
    }
}
