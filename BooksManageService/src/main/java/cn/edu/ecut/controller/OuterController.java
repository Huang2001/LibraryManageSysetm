package cn.edu.ecut.controller;

import cn.edu.ecut.pojo.BookInfo;
import cn.edu.ecut.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/feign")
public class OuterController
{
    @Autowired
    private BookInfoService bookInfoService;


    @RequestMapping("updateByPrimaryKey")
    @ResponseBody
    public String updateByPrimaryKey(@RequestBody BookInfo bookInfo)
    {
       int result= bookInfoService.updateByPrimaryKey(bookInfo);
       return String.valueOf(result);
    }

    @RequestMapping("selectByPrimaryKey/${id}")
    @ResponseBody
    public BookInfo selectByPrimaryKey(@PathVariable Integer id)
    {
        return bookInfoService.selectByPrimaryKey(id);
    }

    @GetMapping("queryBookInfoById/${id}")
    public BookInfo queryBookInfoById(@PathVariable Integer id)
    {
      return bookInfoService.queryBookInfoById(id);
    }

    @PostMapping("updateBookSubmit")
    public void updateBookSubmit(@RequestBody BookInfo info)
    {
        bookInfoService.updateBookSubmit(info);
    }



}
