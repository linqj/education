package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.ProductFunction;
import com.chinayouthedu.zqzc.entity.paike.ProductFunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductFunctionMapper {
    long countByExample(ProductFunctionExample example);

    int deleteByExample(ProductFunctionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductFunction record);

    int insertSelective(ProductFunction record);

    List<ProductFunction> selectByExample(ProductFunctionExample example);

    ProductFunction selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductFunction record, @Param("example") ProductFunctionExample example);

    int updateByExample(@Param("record") ProductFunction record, @Param("example") ProductFunctionExample example);

    int updateByPrimaryKeySelective(ProductFunction record);

    int updateByPrimaryKey(ProductFunction record);
}