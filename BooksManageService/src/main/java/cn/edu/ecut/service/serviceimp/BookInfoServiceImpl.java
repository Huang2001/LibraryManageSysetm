package cn.edu.ecut.service.serviceimp;


import cn.edu.ecut.mapper.BookInfoMapper;
import cn.edu.ecut.pojo.BookInfo;
import cn.edu.ecut.service.BookInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookInfoService")
public class BookInfoServiceImpl implements BookInfoService {

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Override
    public PageInfo<BookInfo> queryBookInfoAll(BookInfo bookInfo, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<BookInfo> bookInfoList = bookInfoMapper.queryBookInfoAll(bookInfo);
        return new PageInfo<>(bookInfoList);
    }

    @Override
    public void addBookSubmit(BookInfo bookInfo) {
        bookInfoMapper.insert(bookInfo);
    }

    @Override
    public BookInfo queryBookInfoById(Integer id) {
        return bookInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateBookSubmit(BookInfo info) {
        bookInfoMapper.updateByPrimaryKeySelective(info);
    }

    @Override
    public void deleteBookByIds(List<String> ids) {
        for (String id : ids){
            bookInfoMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }

    @Override
    public List<BookInfo> getBookCountByType() {
        return bookInfoMapper.getBookCountByType();
    }

    @Override
    public BookInfo selectByPrimaryKey(Integer id) {
        return bookInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(BookInfo record) {
        return bookInfoMapper.updateByPrimaryKey(record);
    }
}
