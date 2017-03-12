package ty.springboot.mybatis.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by epttwxz on 10/03/17.
 */
@Mapper
public interface CityMapper {
    @Select("SELECT * from city WHERE state= #{state}")
    City findState(@Param("state") String state);

    @Select("SELECT * from city")
    List<City> findAllCity();


}
