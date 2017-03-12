package ty.springboot.mybatis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ty.springboot.mybatis.domain.CityMapper;

/**
 * Created by epttwxz on 10/03/17.
 */
@RestController
@EnableAutoConfiguration
public class SimpleWebExample {
    @Autowired
    private CityMapper citymapper;

    @RequestMapping("/")
    String listCity() {
        if(citymapper!=null){
            return citymapper.findAllCity().toString();
        }
        return "null city mapper";
    }

}
