package cn.edu.ecut.service.serviceimp;


import cn.edu.ecut.mapper.TypeInfoMapper;
import cn.edu.ecut.pojo.TypeInfo;
import cn.edu.ecut.service.TypeInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service("typeInfoService")
public class TypeInfoServiceImpl implements TypeInfoService {

    @Autowired
    private TypeInfoMapper typeInfoMapper;
    @Override
    public PageInfo<TypeInfo> queryTypeInfoAll(String name, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<TypeInfo> typeInfoList =  typeInfoMapper.queryTypeInfoAll(name);
        return new PageInfo<>(typeInfoList);
    }

    @Override
    public void addTypeSubmit(TypeInfo info) {
        typeInfoMapper.addTypeSubmit(info);
    }

    @Override
    public TypeInfo queryTypeInfoById(Integer id) {
        return typeInfoMapper.queryTypeInfoById(id);
    }

    @Override
    public void updateTypeSubmit(TypeInfo info) {
        typeInfoMapper.updateTypeSubmit(info);
    }

    @Override
    public void deleteTypeByIds(List<String> id) {
        List<Integer> list=new ArrayList<>();
        for(String cid:id){
            int id2= Integer.valueOf(cid);
            list.add(id2);
        }
        typeInfoMapper.deleteTypeByIds(list);
    }

}