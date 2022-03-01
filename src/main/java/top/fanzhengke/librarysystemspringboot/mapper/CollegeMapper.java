package top.fanzhengke.librarysystemspringboot.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.fanzhengke.librarysystemspringboot.domain.College;

import java.util.List;

@Mapper
@Repository
public interface CollegeMapper {

    @Select("select * from college")
    public List<College> findAll();

    @Select("select * from college where id = #{id}")
    public College findById(Integer id);

    @Delete("delete from college where id = #{id}")
    public Boolean delete(Integer id);

    @Insert("insert into college (college) values (#{college})")
    public Boolean addCollege(College college);

    @Update("<script>"
            + "update college set"
            +   "<if test = 'college != null'>"
            +       "college = #{college}"
            +   "</if>"
            + "where id = #{id}"
            + "</script>")
    public Boolean updateCollege(College college);
}
