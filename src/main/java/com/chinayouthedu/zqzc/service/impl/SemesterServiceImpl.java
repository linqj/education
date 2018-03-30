package com.chinayouthedu.zqzc.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinayouthedu.zqzc.common.utils.DateUtils;
import com.chinayouthedu.zqzc.entity.paike.Semester;
import com.chinayouthedu.zqzc.entity.paike.SemesterExample;
import com.chinayouthedu.zqzc.entity.vo.SchoolYearVo;
import com.chinayouthedu.zqzc.mapper.paike.SemesterMapper;
import com.chinayouthedu.zqzc.service.SemesterService;

@Service
public class SemesterServiceImpl implements SemesterService {

	@Autowired
	private SemesterMapper mapper;
	
	@Override
	public long countByExample(SemesterExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SemesterExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Semester record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(Semester record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<Semester> selectByExample(SemesterExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public Semester selectByPrimaryKey(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Semester record, SemesterExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Semester record, SemesterExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Semester record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Semester record) {
		return mapper.updateByPrimaryKey(record);
	}

	/***
	 * 学期学年中添加第一学期数据
	 * Long syId : 父级中的学年Id
	 * SchoolYearVo vo : 前台传递的业务对象
	 */
	@Override
	public int insertFirst(Long syId, SchoolYearVo vo) {
		//创建学期对象
		Semester semester = new Semester();
		//从业务对象vo中获取编号和名称
		semester.setSemesterCode(vo.getFirstSemesterCode());
		semester.setSemesterName(vo.getFirstSemesterName());
		if (syId != null) {
			semester.setSchoolYearId(syId);
		}
		semester.setStartTime(DateUtils.toDate(vo.getFirstStartTime(), "yyyy-MM-dd"));
		semester.setEndTime(DateUtils.toDate(vo.getFirstEndTime(), "yyyy-MM-dd"));
		semester.setSemesterType("0");
		semester.setCreateTime(new Date());
		//返回执行条数
		int i = mapper.insert(semester);
		return i;
	}
	
	/***
	 * 学期学年中添加第二学期数据
	 * Long syId : 父级中的学年Id
	 * SchoolYearVo vo : 前台传递的业务对象
	 */
	@Override
	public int insertLast(Long syId, SchoolYearVo vo) {
		//创建学期对象
		Semester semester = new Semester();
		//从业务对象vo中获取编号和名称
		semester.setSemesterCode(vo.getLastSemesterCode());
		semester.setSemesterName(vo.getLastSemesterName());
		if (syId != null) {
			semester.setSchoolYearId(syId);
		}
		semester.setStartTime(DateUtils.toDate(vo.getLastStartTime(), "yyyy-MM-dd"));
		semester.setEndTime(DateUtils.toDate(vo.getLastEndTime(), "yyyy-MM-dd"));
		semester.setSemesterType("1");
		semester.setCreateTime(new Date());
		//返回执行条数
		int i = mapper.insert(semester);
		return i;
	}

	/***
	 * 添加学年后再添加两个学期 ,加入事物
	 * Long syId : 父级中的学年Id
	 * SchoolYearVo vo : 前台传递的业务对象
	 */
	@Override
	@Transactional("paikeTransactionManager")
	public int insertAll(Long syId, SchoolYearVo vo) {
		
		int i = insertFirst(syId, vo);
		
		int j = insertLast(syId, vo);
		
		return (i + j);
	}

	/***
     * 删除学期表中同一学年id下的所有学期
     * @author  梁建
     * @Time   2018年3月8日下午2:15:00
     * @param xnId 学年id
     * @return
     */
	@Override
	@Transactional("paikeTransactionManager")
	public int deleteFirstAndLast(Long xnId) {
		SemesterExample example = new SemesterExample();
		example.createCriteria().andSchoolYearIdEqualTo(xnId);
		List<Semester> list = mapper.selectByExample(example);
		int i = mapper.deleteByExample(example);
		return i;
	}

	
	
	@Override
	@Transactional("paikeTransactionManager")
	public int updateFirstAndLast(Long syId, SchoolYearVo vo) {
//		int i = deleteFirstAndLast(syId);
//		if (i > 1) {
//			int j = insertFirst(syId, vo);
//			int k = insertLast(syId, vo);
//			return (j + k); 
//		}
		
		SemesterExample example = new SemesterExample();
		example.createCriteria().andSchoolYearIdEqualTo(syId);
		List<Semester> list = mapper.selectByExample(example);
		int i = 0;
		for (Semester semester : list) {
			if (semester.getSemesterType().equals("0")) {    //上学期
				semester.setSemesterName(vo.getFirstSemesterName());
				semester.setSemesterCode(vo.getFirstSemesterCode());
				semester.setStartTime(DateUtils.toDate(vo.getFirstStartTime(), "yyyy-MM-dd"));
				semester.setEndTime(DateUtils.toDate(vo.getFirstEndTime(), "yyyy-MM-dd"));
				semester.setUpdateTime(new Date());
				i += mapper.updateByPrimaryKey(semester);
			}
			if (semester.getSemesterType().equals("1")) {    //下学期
				semester.setSemesterName(vo.getLastSemesterName());
				semester.setSemesterCode(vo.getLastSemesterCode());
				semester.setStartTime(DateUtils.toDate(vo.getLastStartTime(), "yyyy-MM-dd"));
				semester.setEndTime(DateUtils.toDate(vo.getLastEndTime(), "yyyy-MM-dd"));
				semester.setUpdateTime(new Date());
				i += mapper.updateByPrimaryKey(semester);
			}
		}
		
		
		return i;
	}
	

}
