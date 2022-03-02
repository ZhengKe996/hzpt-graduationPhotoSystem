package top.fanzhengke.librarysystemspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.fanzhengke.librarysystemspringboot.domain.College;
import top.fanzhengke.librarysystemspringboot.domain.Infomation;
import top.fanzhengke.librarysystemspringboot.domain.Marjor;
import top.fanzhengke.librarysystemspringboot.mapper.CollegeMapper;
import top.fanzhengke.librarysystemspringboot.mapper.InfomationMapper;
import top.fanzhengke.librarysystemspringboot.mapper.MarjorMapper;

import java.util.List;

@SpringBootTest
class LibrarySystemSpringBootApplicationTests {

//    @Autowired
//    private CollegeMapper collegeMapper;
//
//    @Autowired
//    private MarjorMapper marjorMapper;
//
//    @Autowired
//    private InfomationMapper infomationMapper;
//
//    @Test
//    void collegeFindAll() {
//        List<College> list = collegeMapper.findAll();
//        for (College college : list) {
//            System.out.println(college);
//        }
//
//    }
//
//    @Test
//    void collegeFindById() {
//        College college = collegeMapper.findById(1);
//        System.out.println(college);
//    }
//
//    @Test
//    void collegeDelete() {
//        Boolean delete = collegeMapper.delete(16);
//        System.out.println(delete);
//    }
//
//    @Test
//    void collegeAdd() {
//        College college = new College();
//        college.setCollege("物联网技术学院");
//
//        Boolean aBoolean = collegeMapper.addCollege(college);
//        System.out.println(aBoolean);
//    }
//
//    @Test
//    void collegeUpdate() {
//        College college = new College();
//        college.setId(1);
//        college.setCollege("物联网技术学院");
//
//        Boolean aBoolean = collegeMapper.updateCollege(college);
//        System.out.println(aBoolean);
//
//
//    }
//
//    @Test
//    void marjorFindAll() {
//        List<Marjor> list = marjorMapper.findAll(1);
//        for (Marjor marjor : list) {
//            System.out.println(marjor);
//        }
//    }
//
//    @Test
//    void marjorFindById() {
//        Marjor mapper = marjorMapper.findById(3);
//        System.out.println(mapper.getMarjor());
//    }
//
//    @Test
//    void marjorSave() {
//        Marjor marjor = new Marjor();
//        marjor.setCid(1);
//        marjor.setMarjor("网站开发");
//
//        Boolean save = marjorMapper.addMarjor(marjor);
//        System.out.println(save);
//    }
//
//    @Test
//    void marjorUpdate() {
//        Marjor marjor = new Marjor();
//        marjor.setId(2);
//        marjor.setCid(1);
//        marjor.setMarjor("数字媒体");
//        Boolean update = marjorMapper.update(marjor);
//        System.out.println(update);
//    }
//
//    @Test
//    void marjorFindByCid() {
//        List<Marjor> list = marjorMapper.findByCid(1);
//        for (Marjor marjor : list) {
//            System.out.println(marjor.getMarjor());
//        }
//    }
//
//    @Test
//    void marjorDelete() {
//        Boolean delete = marjorMapper.delete(3);
//        System.out.println(delete);
//    }
//
//    @Test
//    void infoSave() {
//        Infomation infomation = new Infomation();
//        infomation.setYears("2022");
//        infomation.setCid(1);
//        infomation.setMid(1);
//        infomation.setCname("计应2002");
//        infomation.setImg("xxx");
//        Boolean aBoolean = infomationMapper.addInfomation(infomation);
//        System.out.println(aBoolean);
//    }
//
//    @Test
//    void infoUpdate() {
//        Infomation infomation = new Infomation();
//        infomation.setId(1);
//        infomation.setYears("2023");
//        infomation.setCid(1);
//        infomation.setMid(1);
//        infomation.setCname("计应2002");
//        infomation.setImg("xxxxxx");
//        Boolean aBoolean = infomationMapper.update(infomation);
//        System.out.println(aBoolean);
//    }
//
//    @Test
//    void infoDelete() {
//        Boolean delete = infomationMapper.delete(1);
//        System.out.println(delete);
//    }
//
//    @Test
//    void infoFindAll() {
//        List<Infomation> list = infomationMapper.findAll("2022",1);
//        for (Infomation infomation : list) {
//            System.out.println(infomation.getId());
//            System.out.println(infomation.getCname());
//        }
//    }
//
//    @Test
//    void infoFindById() {
//        Infomation infomation = infomationMapper.findById(1);
//        System.out.println(infomation.getCname());
//    }
//
//    @Test
//    void infoFindYears() {
//        List<String> list = infomationMapper.findYears(1);
//        for (String s : list) {
//            System.out.println(s);
//        }
//    }
//
//    @Test
//    void infoFindMarjor() {
//        List<String> list = infomationMapper.findMarjor(1, "2022");
//
//        for (String infomation : list) {
//            System.out.println(infomation);
//        }
//    }
//
//    @Test
//    void infoFindClassName() {
//        List<String> list = infomationMapper.findClassName(1, "2022", 1);
//        for (String s : list) {
//            System.out.println(s);
//        }
//    }
//
//    @Test
//    void infoFindMid(){
//        String mid = infomationMapper.findByMid(1);
//        System.out.println(mid);
//    }
}
