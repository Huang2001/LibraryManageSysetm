package cn.edu.ecut.service.feigninterface;

import cn.edu.ecut.pojo.BookInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("booksmanageservice")
public interface BooksManageService
{
    @PostMapping("/feign/updateByPrimaryKey")
    public String updateByPrimaryKey(@SpringQueryMap BookInfo bookInfo);


    @GetMapping("/feign/selectByPrimaryKey/${id}")
    public BookInfo selectByPrimaryKey(Integer id);

    @PostMapping("/feign/updateBookSubmit")
    public void updateBookSubmit(@SpringQueryMap BookInfo info);

    @GetMapping("queryBookInfoById/${id}")
    public BookInfo queryBookInfoById(Integer id);
}
