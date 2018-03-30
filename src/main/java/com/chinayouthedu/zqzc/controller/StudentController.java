package com.chinayouthedu.zqzc.controller;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Student;
import com.chinayouthedu.zqzc.service.DictionaryService;
import com.chinayouthedu.zqzc.service.StudentService;
import com.chinayouthedu.zqzc.service.Transfer;
import com.github.pagehelper.PageInfo;
import com.google.common.primitives.Longs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@SuppressWarnings(value="all")
@RestController
@RequestMapping
@Api(value="学生管理接口API")
public class StudentController extends BaseController{

	@Autowired
	private StudentService studentService;
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private Transfer transfer;
	
	/**
	 * 保存学生/更新学生
	 * @HTTP请求方式:Post
	 * @param Student学生对象
	 * @param 学生所属班级的id
	 * @return
	 */
	@ApiOperation(value="保存学生/更新学生",notes="当参数中包含id数据,表示根据id进行更新,否则表示新建")
	@PostMapping(value="/student")
	public BaseResponse saveStudent(Student student){
		if(student!=null&&student.getId()!=null){
			return studentService.updateStudent(student);
		}else{
			return studentService.saveStudent(student);
		}
	}
	
	/**
	 * 根据学号查找一个学生
	 * @HTTP请求方式:Get
	 * @param Student学生对象
	 * @param 学生所属班级的id
	 * @return
	 */
	@ApiOperation(value="根据学生的ID查找一个学生的详细信息")
	@GetMapping(value="/student/{studentId}")
	public Student getOneStudent(@PathVariable(required=true)Long studentId){
		return studentService.selectByPrimaryKey(studentId );
	}


    /**
     *  批量调整班级
     */
    @ApiOperation(value = "批量调整班级")
    @PostMapping(value="student/adjustclass")
	public BaseResponse adjustClass(long[] studentId,Long classId){

        List<Long> studentIds = Longs.asList(studentId);
        return studentService.adjustToNewClass(studentIds,classId );

	}
	
	
	/**
	 * 删除一个学生
	 * @param studentId
	 * @return
	 */
	@ApiOperation(value="根据学生的ID删除一个学生对象")
	@DeleteMapping(value="/student/{studentId}")
	public BaseResponse deleteStudent(@PathVariable(required=true)Long studentId){
		return studentService.deleteStudent(studentId);
	}
	
	/**
	 * 批量删除学生
	 * @return
	 */
	@ApiOperation(value="根据学生的ID数组批量学生对象")
	@PostMapping(value="/student/delete")
	public BaseResponse batchDeleteStudents(long[] ids){
		
		List<Long> asList = Longs.asList(ids);
		asList.remove(0L);
		
		return studentService.batchDeleteStudents(asList );
	}
	
	/**
	 * 查询学生列表
	 * @param pageNum 页码
	 * @param pageSize 页面大小
	 * @param gradeId 年级ID
	 * @param claId 班级ID
	 * @param name 学生姓名模糊查询
	 * @return
	 */
	@ApiOperation(value="分页查询学生数据")
	@GetMapping(value="/student/list")
	public PageInfo<Student> getStudentList(
			@RequestParam(required=false,defaultValue="1")Integer pageNum,
			@RequestParam(required=false,defaultValue="10")Integer pageSize,
			@RequestParam(required=false,defaultValue="-1")Long gradeId,
			@RequestParam(required=false,defaultValue="-1")Long claId,
			@RequestParam(required=false,defaultValue="")String name
			){
		
		gradeId = gradeId==-1L?null:gradeId;
		claId = claId==-1L?null:claId;
		name = StringUtils.isNotBlank(name)?name.trim():"";

		// 班级ID优先级更高!
		if(claId!=null){
			gradeId = null;
		}
		
		PageInfo<Student> pageInfo= studentService.pageList(pageNum,pageSize,gradeId,claId,name);

        return this.transfer.transfer(pageInfo);
	
	}
	
}