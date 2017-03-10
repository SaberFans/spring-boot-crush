package ty.springboot.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by epttwxz on 10/03/17.
 */
@Mapper
public interface CityMapper {
    @Select("SELECT * from city WHERE state= #{state}")
    City findState(@Param("state") String state);
}
