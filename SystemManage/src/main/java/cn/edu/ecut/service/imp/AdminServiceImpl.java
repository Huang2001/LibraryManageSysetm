package cn.edu.ecut.service.imp;

import cn.edu.ecut.mapper.AdminMapper;
import cn.edu.ecut.pojo.Admin;
import cn.edu.ecut.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public PageInfo<Admin> queryAdminAll(Admin admin, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<Admin> adminList = adminMapper.queryAdminInfoAll(admin);
        return new PageInfo<>(adminList) ;
    }

    @Override
    public void addAdminSubmit(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public Admin queryAdminById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateAdminSubmit(Admin admin) {
        adminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public void deleteAdminByIds(List<String> ids) {
        for (String id : ids){
            adminMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }

    @Override
    public Admin queryUserByNameAndPassword(String username, String password) {
        return adminMapper.queryUserByNameAndPassword(username,password);
    }
}
