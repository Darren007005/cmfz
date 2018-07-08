package cn.cocoding.cmfz.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import cn.cocoding.cmfz.entity.Guru;
import org.springframework.stereotype.Repository;


public interface GuruDao {
    int insert(@Param("guru") Guru guru);

    int insertSelective(@Param("guru") Guru guru);

    int insertList(@Param("gurus") List<Guru> gurus);

    int update(@Param("guru") Guru guru);

    //分页查询法师
    List<Guru> selectGurus(@Param("paramName") String name,@Param("value") String value, @Param("begin") int begin, @Param("rows") int rows);

    //查询法师的总数量
    int count(@Param("paramName") String name, @Param("value") String value);

    //查询所有的法师
    List<Guru> selectAllGuru();
}
