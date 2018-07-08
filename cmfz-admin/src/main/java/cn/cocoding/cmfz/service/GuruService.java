package cn.cocoding.cmfz.service;

import java.util.List;
import java.util.Map;

import cn.cocoding.cmfz.entity.Guru;
public interface GuruService{

    int insert(Guru guru);

    int insertSelective(Guru guru);

    int insertList(List<Guru> gurus);

    int update(Guru guru);

    //分页查询法师
    Map<String,Object> queryGurus(String name, String value, int page, int rows);

    List<Guru> queryAllGuru();
}
