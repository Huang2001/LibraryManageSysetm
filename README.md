# 任务书

## 目前有疑问的页面



## TODO

把所有在jsp中的后端接口调用改成微服务形式：
总共有三个微服务名称如下 ：

- BooksManageService
- BookLendService
- SystemManage

然后找出需要更改的前端jsp接口，然后和后端3个微服务接口对应上，最后将jsp的请求接口改成右边的形式：
http://101.34.207.32:8081/对应的服务名/该服务上的接口


### example：

```java
@Controller
public class BookInfoController {

    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private TypeInfoService typeInfoService;

    /**
     * 图书管理首页
     * @return
     */
    @GetMapping("/bookIndex")
    public String bookIndex(){
        return "book/bookIndex";
    }

    /**
     * 获取book信息，封装成json
     * @param bookInfo
     * @param pageNum
     * @param limit
     * @return
     */
    @RequestMapping("/bookAll")
    @ResponseBody       
    //@ResponseBody将java对象转为json格式的数据，表示该方法的返回结果直接写入 HTTP response body 中，一般在异步ajax获取数据时使用
    public DataInfo bookAll(BookInfo bookInfo, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<BookInfo> pageInfo = bookInfoService.queryBookInfoAll(bookInfo,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
    }

    /**
     * 添加页面的跳转
     */
    @GetMapping("/bookAdd")
    public String bookAdd(){
        return "book/bookAdd";
    }

    /**
     * 类型添加提交
     */
    @RequestMapping("/addBookSubmit")
    @ResponseBody
    public DataInfo addBook(BookInfo info){
        bookInfoService.addBookSubmit(info);
        return DataInfo.ok();
    }

    /**
     * 类型根据id查询(修改)
     */
    @GetMapping("/queryBookInfoById")
    public String queryTypeInfoById(Integer id, Model model){
        BookInfo bookInfo= bookInfoService.queryBookInfoById(id);
        model.addAttribute("info",bookInfo);
        return "book/updateBook";
    }

    /**
     * 修改提交功能
     */

    @RequestMapping("/updateBookSubmit")
    @ResponseBody
    public DataInfo updateBookSubmit(@RequestBody BookInfo info){
        bookInfoService.updateBookSubmit(info);
        return DataInfo.ok();
    }
    /**
     * 类型删除
     */

    @RequestMapping("/deleteBook")
    @ResponseBody
    public DataInfo deleteBook(String ids){
        List<String> list= Arrays.asList(ids.split(","));
        bookInfoService.deleteBookByIds(list);
        return DataInfo.ok();
    }

    @RequestMapping("/findAllList")
    @ResponseBody
    public List<TypeInfo> findAll(){
        PageInfo<TypeInfo> pageInfo = typeInfoService.queryTypeInfoAll(null,1,100);
        List<TypeInfo> lists = pageInfo.getList();
        return lists;
    }
}
```

这个`controller`是在`BooksManageService`微服务中，

```java
@RequestMapping("/bookAll")
@ResponseBody       //@ResponseBody将java对象转为json格式的数据，表示该方法的返回结果直接写入 HTTP response body 中，一般在异步ajax获取数据时使用
public DataInfo bookAll(BookInfo bookInfo, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<BookInfo> pageInfo = bookInfoService.queryBookInfoAll(bookInfo,pageNum,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());//总条数getTotal，数据封装成list,以便加载分页显示,由于加了ResponseBody,就会返回一个字符串
        }
```

比如这个接口在该服务中本是/bookAll 需要在jsp中改成http://101.34.207.32:8081/BooksManageService/bookAll
