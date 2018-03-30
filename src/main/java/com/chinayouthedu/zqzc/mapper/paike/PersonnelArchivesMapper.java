package com.chinayouthedu.zqzc.mapper.paike;

import com.chinayouthedu.zqzc.entity.paike.PersonnelArchives;
import com.chinayouthedu.zqzc.entity.paike.PersonnelArchivesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonnelArchivesMapper {
    long countByExample(PersonnelArchivesExample example);

    int deleteByExample(PersonnelArchivesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PersonnelArchives record);

    int insertSelective(PersonnelArchives record);

    List<PersonnelArchives> selectByExample(PersonnelArchivesExample example);

    PersonnelArchives selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PersonnelArchives record, @Param("example") PersonnelArchivesExample example);

    int updateByExample(@Param("record") PersonnelArchives record, @Param("example") PersonnelArchivesExample example);

    int updateByPrimaryKeySelective(PersonnelArchives record);

    int updateByPrimaryKey(PersonnelArchives record);
}