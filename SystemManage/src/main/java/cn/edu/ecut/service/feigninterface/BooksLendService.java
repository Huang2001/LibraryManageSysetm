package cn.edu.ecut.service.feigninterface;

import cn.edu.ecut.pojo.ReaderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("bookslendservice")
public interface BooksLendService
{
    @RequestMapping("/feign/queryUserInfo")
    public ReaderInfo queryUserInfoByNameAndPassword(String username, String password);
}
