package top.fanzhengke.librarysystemspringboot.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.fanzhengke.librarysystemspringboot.domain.Infomation;

import java.util.List;

@Mapper
@Repository
public interface InfomationMapper {

    @Select("<script>"
            + "select * from infomation"
            + "<choose>"
            + "<when test = 'year != null and cid != null'>"
            + "where years = #{year} and cid = #{cid}"
            + "</when>"
            + "<otherwise>"
            + "<if test = 'year != null'>"
            + "where years = #{year}"
            + "</if>"
            + "<if test = 'cid != null'>"
            + "where cid = #{cid}"
            + "</if>"
            + "</otherwise>"
            + "</choose>"
            + "</script>")
    public Page<Infomation> findAll(String year, Integer cid);

    @Select("select * from infomation where id = #{id}")
    public Infomation findById(Integer id);

    @Select("select years from infomation where cid = #{cid} group by years")
    public List<String> findYears(Integer cid);

    @Select("select mid from infomation where cid = #{cid} and years = #{years} group by mid")
    public List<String> findMarjor(Integer cid, String years);

    @Select("select mid from infomation where mid = #{mid} group by mid")
    public String findByMid(Integer mid);

    @Select("select * from infomation where cid = #{cid} and years = #{years} and mid = #{mid}")
    public List<Infomation> findClassName(Integer cid, String years, Integer mid);

    @Delete("delete from infomation where id = #{id}")
    public Boolean delete(Integer id);

    @Insert("insert into infomation (years, cid, mid, cname, img) values (#{years}, #{cid}, #{mid}, #{cname}, #{img})")
    public Boolean addInfomation(Infomation infomation);

    @Update("<script>"
            + "update infomation set"
            + "<if test = 'years != null'>"
            + "years = #{years},"
            + "</if>"
            + "<if test = 'cid != null'>"
            + "cid = #{cid},"
            + "</if>"
            + "<if test = 'mid != null'>"
            + "mid = #{mid},"
            + "</if>"
            + "<if test = 'cname != null'>"
            + "cname = #{cname},"
            + "</if>"
            + "<if test = 'img != null'>"
            + "img = #{img}"
            + "</if>"
            + "where id = #{id}"
            + "</script>")
    public Boolean update(Infomation infomation);
}
