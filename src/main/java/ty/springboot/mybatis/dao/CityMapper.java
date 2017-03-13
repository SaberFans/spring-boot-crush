package ty.springboot.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import ty.springboot.mybatis.domain.City;
import ty.springboot.mybatis.domain.CityExample;

@Mapper
public interface CityMapper {
    @SelectProvider(type=CitySqlProvider.class, method="countByExample")
    long countByExample(CityExample example);

    @DeleteProvider(type=CitySqlProvider.class, method="deleteByExample")
    int deleteByExample(CityExample example);

    @Delete({
        "delete from city",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into city (name, state, ",
        "country)",
        "values (#{name,jdbcType=VARCHAR}, #{state,jdbcType=VARCHAR}, ",
        "#{country,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(City record);

    @InsertProvider(type=CitySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(City record);

    @SelectProvider(type=CitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="country", property="country", jdbcType=JdbcType.VARCHAR)
    })
    List<City> selectByExample(CityExample example);

    @Select({
        "select",
        "id, name, state, country",
        "from city",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="country", property="country", jdbcType=JdbcType.VARCHAR)
    })
    City selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") City record, @Param("example") CityExample example);

    @UpdateProvider(type=CitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") City record, @Param("example") CityExample example);

    @UpdateProvider(type=CitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(City record);

    @Update({
        "update city",
        "set name = #{name,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=VARCHAR},",
          "country = #{country,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(City record);
}