package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.Role;
import com.chinayouthedu.zqzc.entity.paike.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
	 * 根据用户id获取该用户角色
	 * @author  张超群	2018年3月24日 下午11:51:15
	 * @param id	long	用户id
	 * @return
	 */
	List<Role> selectRolesByUserId(Long id);
}