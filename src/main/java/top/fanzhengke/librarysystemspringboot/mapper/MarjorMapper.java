package top.fanzhengke.librarysystemspringboot.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.fanzhengke.librarysystemspringboot.domain.Marjor;

import java.util.List;

@Mapper
@Repository
public interface MarjorMapper {
    @Select("<script>"
            + "select * from marjor"
            +   "<if test = 'cid != null'>"
            +       "where cid = #{cid}"
            +   "</if>"
            + "</script>")
    public Page<Marjor> findAll(Integer cid);

    @Select("select * from marjor where id = #{id}")
    public Marjor findById(Integer id);

    @Insert("insert into marjor (cid , marjor) values (#{cid},#{marjor})")
    public Boolean addMarjor(Marjor marjor);

    @Delete("delete from marjor where id = #{id}")
    public Boolean delete(Integer id);

    @Update("<script>"
            + "update marjor set"
            +   "<if test = 'cid != null'>"
            +       "cid = #{cid},"
            +   "</if>"
            +   "<if test = 'marjor != null'>"
            +       "marjor = #{marjor}"
            +   "</if>"
            + "where id = #{id}"
            + "</script>")
    public Boolean update(Marjor marjor);

    @Select("select * from marjor where cid = #{cid}")
    public List<Marjor> findByCid(Integer cid);
}
