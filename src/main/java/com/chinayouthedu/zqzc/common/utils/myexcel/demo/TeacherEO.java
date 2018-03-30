package com.chinayouthedu.zqzc.common.utils.myexcel.demo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.chinayouthedu.zqzc.common.utils.myexcel.ExportExcel;
import com.chinayouthedu.zqzc.common.utils.myexcel.ImportExcel;

/**
 * 导出-测试对象
 * @author 张超群
 * @time   2018年3月14日下午2:17:00
 */
public class TeacherEO implements Serializable {

	private static final long serialVersionUID = 1L;

	/** @desc 姓名(必填项) (无默认值) */
	@ExportExcel(column = "A", name = "姓名",width=6)
	@ImportExcel(rule="[\u4e00-\u9fa5]{0,6}",ruleExplain="请输入2个汉字", column = "A")
	private String A;

	@ExportExcel(column = "B", name = "性别",condition = {"男","女"},width=6,combo={"男","女"})
	@ImportExcel(column = "B",rule="[\u4e00-\u9fa5]{0,1}",ruleExplain="请输入男或者女",condition = {"男","女"})
	private Boolean B;
	
	@ExportExcel(column = "C", name = "年龄",combo={"21","22","23","24"},width=6)
	@ImportExcel(column = "C")
	private Integer C;

	@ExportExcel(column = "D", name = "手机号",width=11)
	@ImportExcel(column = "D")
	private Long D;
	
	@ExportExcel(column = "E", name = "工资",width=25)
	@ImportExcel(column = "E")
	private BigDecimal E;
	
	@ExportExcel(column = "F", name = "司领",width=6)
	@ImportExcel(column = "F")
	private Double F;
	
	@ExportExcel(column = "G", name = "工龄",width=6)
	@ImportExcel(column = "G")
	private Float G;
	
	@ExportExcel(column = "H", name = "出生日期",width=22)
	@ImportExcel(column = "H",rule="\\d{4}(\\-)\\d{1,2}\\1\\d{1,2}",ruleExplain="请输入yyyy-MM-dd格式的日期")
	private Date H;

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public Boolean getB() {
		return B;
	}

	public void setB(Boolean b) {
		B = b;
	}

	public Integer getC() {
		return C;
	}

	public void setC(Integer c) {
		C = c;
	}

	public Long getD() {
		return D;
	}

	public void setD(Long d) {
		D = d;
	}

	public BigDecimal getE() {
		return E;
	}

	public void setE(BigDecimal e) {
		E = e;
	}

	public Double getF() {
		return F;
	}

	public void setF(Double f) {
		F = f;
	}

	public Float getG() {
		return G;
	}

	public void setG(Float g) {
		G = g;
	}

	public Date getH() {
		return H;
	}

	public void setH(Date h) {
		H = h;
	}
	
}