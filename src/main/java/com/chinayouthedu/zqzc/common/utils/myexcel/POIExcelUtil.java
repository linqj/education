package com.chinayouthedu.zqzc.common.utils.myexcel;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.chinayouthedu.zqzc.common.utils.DateUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * POI支持的Excel操作工具类
 * @author 张超群
 * @time   2018年3月15日下午4:05:04
 */
public class POIExcelUtil<T> {
	
	private List<String> error;//错误信息
	
	public List<String> getError() {
		return error;
	}

	Class<T> clazz;

	public POIExcelUtil(Class<T> clazz) {
		this.clazz = clazz;
	}

	public static Log log = LogFactory.getLog(POIExcelUtil.class);
	
	
	/**
	 * Excel读取为List(暂时只支持一个sheet页)
	 * @author 张超群 2017年9月13日下午5:45:34
	 * @param filePath
	 * @param isRelative	true相对路径	false绝对路径
	 * @return
	 * @throws Exception
	 */
	public List<T> importExcel(String filePath,MultipartFile file) throws Exception{
		List<String> errorList = new ArrayList<String>();
		List<T> list = new ArrayList<T>();
		String filetype = "";
		FileInputStream fi = null;
		if(file != null){//文件流
			String originalFilename = file.getOriginalFilename();
			filetype = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();//后缀
		}else{//路径
			filetype = filePath.substring(filePath.lastIndexOf(".") + 1);
			try {
				fi = new FileInputStream(filePath);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			if(fi == null)
				throw new Exception("文件不存在");
		}
		//xls文件
		if(".xls".equals(filetype.toLowerCase())){
			try {
				HSSFWorkbook wookbook = null;
				if(file != null){
					wookbook = new HSSFWorkbook(file.getInputStream());
				}else{
					wookbook = new HSSFWorkbook(fi);
				}
//				HSSFSheet sheet = wookbook.getSheet("Sheet1");
				HSSFSheet sheet = wookbook.getSheetAt(0);
				int rows = sheet.getPhysicalNumberOfRows();
				if(rows > 0){//存在数据
					Field[] allFields = clazz.getDeclaredFields();// 得到类的所有field.
					Map<Integer, Field> fieldsMap = new HashMap<Integer, Field>();// 定义一个map用于存放列的序号和field.
					for (Field field : allFields) {
						// 将有注解的field存放到map中.
						if (field.isAnnotationPresent(ImportExcel.class)) {
							ImportExcel attr = field
									.getAnnotation(ImportExcel.class);
							int col = getExcelCol(attr.column());// 获得列号
							field.setAccessible(true);// 设置类的私有字段属性可访问.
							fieldsMap.put(col, field);
						}
					}
					
					//获取标题行
					HSSFRow title = sheet.getRow(0);
					int index = title.getFirstCellNum();
					int rowcount = title.getLastCellNum();
					for (int i = 1; i < rows; i++){//从第二行开始读取,默认第一行为表头
						T entity = null;
						HSSFRow row = sheet.getRow(i);
						if(isBlankRow(row, index, rowcount))
							continue;
						if (row != null){
							int cells = title.getPhysicalNumberOfCells();
							for (int j = 0; j < cells; j++){
								HSSFCell cell = row.getCell(j);//获取一行
								entity = (entity == null ? clazz.newInstance() : entity);// 如果不存在实例则新建.
								Field field = fieldsMap.get(j);// 从map中得到对应列的field.
								// 取得类型,并根据对象类型设置值.
								Class<?> fieldType = field.getType();
								ImportExcel annotation = field.getAnnotation(ImportExcel.class);
								if (cell != null){
									boolean checkCellContent = true;
									if(!"".equals(annotation.rule())){//有规则
										checkCellContent = HSSFCheckCellContent(field,cell, annotation.rule().toString());
									}
									if(checkCellContent){//数据格式正确
										//非空判断
										if(!annotation.setNull()){
											if("".equals(cell.getDateCellValue()) || cell.getDateCellValue() == null){
												String errorInfo = "第"+i+"行,第"+j+"列存在错误,该单元格数据不能为空!";
												errorList.add(errorInfo);
												continue;
											}
										}
										if (Date.class == fieldType) {
											Date dateCellValue = cell.getDateCellValue();
											field.set(entity, dateCellValue);
										}else{
											cell.setCellType(HSSFCell.CELL_TYPE_STRING);
											if ((Integer.TYPE == fieldType)
													|| (Integer.class == fieldType)) {
												field.set(entity, Integer.parseInt(cell.getStringCellValue()));
											} else if ((Long.TYPE == fieldType)
													|| (Long.class == fieldType)) {
												field.set(entity, Long.valueOf(cell.getStringCellValue()));
											} else if ((Float.TYPE == fieldType)
													|| (Float.class == fieldType)) {
												field.set(entity, Float.valueOf(cell.getStringCellValue()));
											} else if ((Short.TYPE == fieldType)
													|| (Short.class == fieldType)) {
												field.set(entity, Short.valueOf(cell.getStringCellValue()));
											} else if ((Double.TYPE == fieldType)
													|| (Double.class == fieldType)) {
												field.set(entity, Double.valueOf(cell.getStringCellValue()));
											} else if (BigDecimal.class == fieldType) {
												field.set(entity, new BigDecimal(cell.getStringCellValue()));
											}else if (String.class == fieldType) {
												field.set(entity, String.valueOf(cell.getStringCellValue()));
											} else if (Character.TYPE == fieldType) {
												if ((cell.getStringCellValue() != null) && (cell.getStringCellValue().length() > 0)) {
													field.set(entity, Character.valueOf(cell.getStringCellValue().charAt(0)));
												}
											}else if(Boolean.TYPE == fieldType || Boolean.class == fieldType){
												String[] condition = annotation.condition();
												if(condition.length > 0){
													if(cell.getStringCellValue().trim().equals(condition[0].trim().toString())){//true
														field.set(entity, true);
													}else{//false
														field.set(entity, false);
													}
												}
											}else{
												field.set(entity, "");
											}
										}
									}else{//数据格式错误
										String errorInfo = "第"+i+"行,第"+j+"列存在错误,该单元格格式以及数据不符合规则!说明:  "+annotation.ruleExplain();
										errorList.add(errorInfo);
									}
								}
							}
							if (entity != null) {
								list.add(entity);
							}
							
						}
					}
					this.error = errorList;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch(Exception e){
				e.printStackTrace();
			}
		}else if(".xlsx".equals(filetype.toLowerCase())){
			//xlsx文件
			try {
				XSSFWorkbook wookbook = null;
				if(file != null){
					wookbook = new XSSFWorkbook(file.getInputStream());
				}else{
					wookbook = new XSSFWorkbook(fi);
				}
//				XSSFSheet sheet = wookbook.getSheet("Sheet1");
				XSSFSheet sheet = wookbook.getSheetAt(0);
				int rows = sheet.getPhysicalNumberOfRows();
				if(rows > 0){
					Field[] allFields = clazz.getDeclaredFields();// 得到类的所有field.
					Map<Integer, Field> fieldsMap = new HashMap<Integer, Field>();// 定义一个map用于存放列的序号和field.
					for (Field field : allFields) {
						// 将有注解的field存放到map中.
						if (field.isAnnotationPresent(ImportExcel.class)) {
							ImportExcel attr = field
									.getAnnotation(ImportExcel.class);
							int col = getExcelCol(attr.column());// 获得列号
							field.setAccessible(true);// 设置类的私有字段属性可访问.
							fieldsMap.put(col, field);
						}
					}
					
					//获取标题行
					XSSFRow title = sheet.getRow(0);
					int index = title.getFirstCellNum();
					int rowcount = title.getLastCellNum();
					for (int i = 1; i < rows; i++){
						T entity = null;
						XSSFRow row = sheet.getRow(i);
						if(isBlankRow(row, index, rowcount))
							continue;
						if (row != null){
							int cells = title.getPhysicalNumberOfCells();
							
							for (int j = 0; j < cells; j++){
								XSSFCell cell = row.getCell(j);
								entity = (entity == null ? clazz.newInstance() : entity);// 如果不存在实例则新建.
								Field field = fieldsMap.get(j);// 从map中得到对应列的field.
								// 取得类型,并根据对象类型设置值.
								Class<?> fieldType = field.getType();
								//Boolean类型判断
								ImportExcel annotation = field.getAnnotation(ImportExcel.class);
								if (cell != null){
									boolean checkCellContent = true;
									if(!"".equals(annotation.rule())){//有规则
										checkCellContent = XSSFCheckCellContent(field,cell, annotation.rule().toString());
									}
									if(checkCellContent){//数据格式正确
										if (Date.class == fieldType) {
											Date dateCellValue = cell.getDateCellValue();
											field.set(entity, dateCellValue);
										}else{
											cell.setCellType(HSSFCell.CELL_TYPE_STRING);
											if ((Integer.TYPE == fieldType)
													|| (Integer.class == fieldType)) {
												field.set(entity, Integer.parseInt(cell.getStringCellValue()));
											} else if ((Long.TYPE == fieldType)
													|| (Long.class == fieldType)) {
												field.set(entity, Long.valueOf(cell.getStringCellValue()));
											} else if ((Float.TYPE == fieldType)
													|| (Float.class == fieldType)) {
												field.set(entity, Float.valueOf(cell.getStringCellValue()));
											} else if ((Short.TYPE == fieldType)
													|| (Short.class == fieldType)) {
												field.set(entity, Short.valueOf(cell.getStringCellValue()));
											} else if ((Double.TYPE == fieldType)
													|| (Double.class == fieldType)) {
												field.set(entity, Double.valueOf(cell.getStringCellValue()));
											} else if (BigDecimal.class == fieldType) {
												field.set(entity, new BigDecimal(cell.getStringCellValue()));
											}else if (String.class == fieldType) {
												field.set(entity, String.valueOf(cell.getStringCellValue()));
											} else if (Character.TYPE == fieldType) {
												if ((cell.getStringCellValue() != null) && (cell.getStringCellValue().length() > 0)) {
													field.set(entity, Character.valueOf(cell.getStringCellValue().charAt(0)));
												}
											}else if(Boolean.TYPE == fieldType || Boolean.class == fieldType){
												String[] condition = annotation.condition();
												if(condition.length > 0){
													if(cell.getStringCellValue().trim().equals(condition[0].trim().toString())){//true
														field.set(entity, true);
													}else{//false
														field.set(entity, false);
													}
												}
											}else{
												field.set(entity, "");
											}
										}
									}else{//数据格式错误
										String errorInfo = "第"+i+"行,第"+j+"列存在错误,该单元格格式以及数据不符合规则!说明:  "+annotation.ruleExplain();
										errorList.add(errorInfo);
									}
								}
							}
							if (entity != null) {
								list.add(entity);
							}
							
						}
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(fi != null)
			fi.close();
		
		return list;
	}

	/**
	 * 对list数据源将其里面的数据导入到excel表单
	 * 
	 * @param sheetName
	 *            工作表的名称
	 * @param sheetSize
	 *            每个sheet中数据的行数,此数值必须小于65536
	 * @param output
	 *            java输出流
	 */
	public boolean exportExcel(List<T> list, String sheetName, int sheetSize,
			OutputStream output) {

		Field[] allFields = clazz.getDeclaredFields();// 得到所有定义字段
		List<Field> fields = new ArrayList<Field>();
		// 得到所有field并存放到一个list中.
		for (Field field : allFields) {
			if (field.isAnnotationPresent(ExportExcel.class)) {
				fields.add(field);
			}
		}

		HSSFWorkbook workbook = new HSSFWorkbook();// 产生工作薄对象

		// excel2003中每个sheet中最多有65536行,为避免产生错误所以加这个逻辑.
		if (sheetSize > 65536 || sheetSize < 1) {
			sheetSize = 65536;
		}
		double sheetNo = Math.ceil(list.size() / sheetSize);// 取出一共有多少个sheet.
		for (int index = 0; index <= sheetNo; index++) {
			HSSFSheet sheet = workbook.createSheet();// 产生工作表对象
			if(index == 0){
				workbook.setSheetName(index, sheetName);// 设置工作表的名称.
			}else{
				workbook.setSheetName(index, sheetName + index);// 设置工作表的名称.
			}
//			sheet.setDefaultColumnWidth(22);//设置整个sheet默认列宽为22
//			sheet.setDefaultRowHeight((short) 1.60);//设置默认高度为1.6
			HSSFRow row;
			HSSFCell cell;// 产生单元格

			row = sheet.createRow(0);// 产生一行
			// 写入各个字段的列头名称
			for (int i = 0; i < fields.size(); i++) {
				Field field = fields.get(i);
				ExportExcel attr = field.getAnnotation(ExportExcel.class);
				int col = getExcelCol(attr.column());// 获得列号
				//设置列宽
				if(attr.width() > 0){
					sheet.setColumnWidth(col, (attr.width()+1)*256);
				}
				if(attr.hight() > 0){
					row.setHeight((short) (attr.hight() * 20));
				}
				cell = row.createCell(col);// 创建列
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);// 设置列中写入内容为String类型
				cell.setCellValue(attr.name());// 写入列名

				// 如果设置了提示信息则鼠标放上去提示.
				if (!attr.prompt().trim().equals("")) {
					setHSSFPrompt(sheet, "", attr.prompt(), 1, 100, col, col);// 这里默认设了2-101列提示.
				}
				// 如果设置了combo属性则本列只能选择不能输入
				if (attr.combo().length > 0) {
					setHSSFValidation(sheet, attr.combo(), 1, 100, col, col);// 这里默认设了2-101列只能选择不能输入.
				}
			}

			int startNo = index * sheetSize;
			int endNo = Math.min(startNo + sheetSize, list.size());
			// 写入各条记录,每条记录对应excel表中的一行
			for (int i = startNo; i < endNo; i++) {
				row = sheet.createRow(i + 1 - startNo);
				T vo = (T) list.get(i); // 得到导出对象.
				for (int j = 0; j < fields.size(); j++) {
					Field field = fields.get(j);// 获得field.
					field.setAccessible(true);// 设置实体类私有属性可访问
					ExportExcel attr = field.getAnnotation(ExportExcel.class);
					try {
						// 根据ExcelVOAttribute中设置情况决定是否导出,有些情况需要保持为空,希望用户填写这一列.
						if (attr.isExport()) {
							//设置列宽
							if(attr.width() > 0){
								sheet.setColumnWidth(getExcelCol(attr.column()), (attr.width()+1)*256);
							}
							cell = row.createCell(getExcelCol(attr.column()));// 创建cell
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							String[] condition = attr.condition();
							if(condition.length > 0){//存在boolean类型,需转换
								cell.setCellValue(field.get(vo) == null ? "": changeType(field.get(vo),condition));// 如果数据存在就填入,不存在填入空格.
							}else{
								cell.setCellValue(field.get(vo) == null ? "": changeType(field.get(vo),null));// 如果数据存在就填入,不存在填入空格.
							}
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}

		}
		try {
			output.flush();
			workbook.write(output);
			output.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Output is closed ");
			return false;
		}

	}

	/**
	 * 直接导出下载
	 * @param list
	 * @param sheetName
	 * @param sheetSize
	 * @param response
	 * @return
	 */
	public boolean exportExcelToDownload(List<T> list, String sheetName, int sheetSize, HttpServletResponse response) throws Exception {

		Field[] allFields = clazz.getDeclaredFields();// 得到所有定义字段
		List<Field> fields = new ArrayList<Field>();
		// 得到所有field并存放到一个list中.
		for (Field field : allFields) {
			if (field.isAnnotationPresent(ExportExcel.class)) {
				fields.add(field);
			}
		}

		HSSFWorkbook workbook = new HSSFWorkbook();// 产生工作薄对象

		// excel2003中每个sheet中最多有65536行,为避免产生错误所以加这个逻辑.
		if (sheetSize > 65536 || sheetSize < 1) {
			sheetSize = 65536;
		}
		double sheetNo = Math.ceil(list.size() / sheetSize);// 取出一共有多少个sheet.
		for (int index = 0; index <= sheetNo; index++) {
			HSSFSheet sheet = workbook.createSheet();// 产生工作表对象
			if(index == 0){
				workbook.setSheetName(index, sheetName);// 设置工作表的名称.
			}else{
				workbook.setSheetName(index, sheetName + index);// 设置工作表的名称.
			}
//			sheet.setDefaultColumnWidth(22);//设置整个sheet默认列宽为22
//			sheet.setDefaultRowHeight((short) 1.60);//设置默认高度为1.6
			HSSFRow row;
			HSSFCell cell;// 产生单元格

			row = sheet.createRow(0);// 产生一行
			// 写入各个字段的列头名称
			for (int i = 0; i < fields.size(); i++) {
				Field field = fields.get(i);
				ExportExcel attr = field.getAnnotation(ExportExcel.class);
				int col = getExcelCol(attr.column());// 获得列号
				//设置列宽
				if(attr.width() > 0){
					sheet.setColumnWidth(col, (attr.width()+1)*256);
				}
				if(attr.hight() > 0){
					row.setHeight((short) (attr.hight() * 20));
				}
				cell = row.createCell(col);// 创建列
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);// 设置列中写入内容为String类型
				cell.setCellValue(attr.name());// 写入列名

				// 如果设置了提示信息则鼠标放上去提示.
				if (!attr.prompt().trim().equals("")) {
					setHSSFPrompt(sheet, "", attr.prompt(), 1, 65536, col, col);// 这里默认设了2-65536列提示.
				}
				// 如果设置了combo属性则本列只能选择不能输入
				if (attr.combo().length > 0) {
					setHSSFValidation(sheet, attr.combo(), 1, 65536, col, col);// 这里默认设了2-65536列只能选择不能输入.
				}
			}

			int startNo = index * sheetSize;
			int endNo = Math.min(startNo + sheetSize, list.size());
			// 写入各条记录,每条记录对应excel表中的一行
			for (int i = startNo; i < endNo; i++) {
				row = sheet.createRow(i + 1 - startNo);
				T vo = (T) list.get(i); // 得到导出对象.
				for (int j = 0; j < fields.size(); j++) {
					Field field = fields.get(j);// 获得field.
					field.setAccessible(true);// 设置实体类私有属性可访问
					ExportExcel attr = field.getAnnotation(ExportExcel.class);
					try {
						// 根据ExcelVOAttribute中设置情况决定是否导出,有些情况需要保持为空,希望用户填写这一列.
						if (attr.isExport()) {
							//设置列宽
							if(attr.width() > 0){
								sheet.setColumnWidth(getExcelCol(attr.column()), (attr.width()+1)*256);
							}
							cell = row.createCell(getExcelCol(attr.column()));// 创建cell
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							String[] condition = attr.condition();
							if(condition.length > 0){//存在boolean类型,需转换
								cell.setCellValue(field.get(vo) == null ? "": changeType(field.get(vo),condition));// 如果数据存在就填入,不存在填入空格.
							}else{
								cell.setCellValue(field.get(vo) == null ? "": changeType(field.get(vo),null));// 如果数据存在就填入,不存在填入空格.
							}
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}

		}
        response.reset();
        response.setContentType("application/octet-stream;charset=UTF-8");
//        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        String fileName = "";
        if("".equals(sheetName) || sheetName == null){
            fileName = (DateUtils.toString(new Date(),"yyyy-MM-dd")+".xls");
        }else{
            fileName = (sheetName+".xls");
        }
        ;
        response.setHeader("Content-Disposition","attachment;filename="+new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
        byte[] bytes = workbook.getBytes();
//        response.addHeader("Content-Length", ""+bytes.length);
        response.addHeader("Content-Length", "");
        OutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(response.getOutputStream());
            outputStream.flush();
            workbook.write(outputStream);
            outputStream.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Output is closed ");
			return false;
		}

	}

	
	
	/**
	 * 判断属性类型,导出时转换为String
	 * @author 张超群 
	 * @Time   2018年3月14日下午3:41:01
	 * @param vo
	 * @return
	 */
	public static String changeType(Object vo,String[] condition){
		String result = "";
		String typeName = vo.getClass().getTypeName();
		switch (typeName) {
		case "java.util.Date":
			result = DateUtils.toString((Date)vo, "yyyy-MM-dd");
			break;
		case "java.lang.Boolean":
			if(Boolean.parseBoolean(vo.toString())){//true
				result = condition[0];
			}else{
				result = condition[1];
			}
			break;
		default:
			result = vo.toString();
			break;
		}
		
		return result;
	}


	/**
	 * 合并单元格
	 * @param sheet
	 * 			要设置的sheet
	 * @param firstRow
	 * 			起始行
	 * @param endRow
	 * 			终止行
	 * @param firstCol
	 * 			起始列
	 * @param endCol
	 * 			终止列
	 */
	public static void mergeRegion(HSSFSheet sheet, int firstRow, int endRow, int firstCol,int endCol){
		// 合并单元格
		CellRangeAddress cra =new CellRangeAddress(firstRow, endRow, firstCol, endCol);
		sheet.addMergedRegion(cra);
	}
	
	/**
	 * 设置单元格上提示
	 * 
	 * @param sheet
	 *            要设置的sheet.
	 * @param promptTitle
	 *            标题
	 * @param promptContent
	 *            内容
	 * @param firstRow
	 *            开始行
	 * @param endRow
	 *            结束行
	 * @param firstCol
	 *            开始列
	 * @param endCol
	 *            结束列
	 * @return 设置好的sheet.
	 */
	public static HSSFSheet setHSSFPrompt(HSSFSheet sheet, String promptTitle,
			String promptContent, int firstRow, int endRow, int firstCol,
			int endCol) {
		// 构造constraint对象
		DVConstraint constraint = DVConstraint
				.createCustomFormulaConstraint("DD1");
		// 四个参数分别是：起始行、终止行、起始列、终止列
		CellRangeAddressList regions = new CellRangeAddressList(firstRow,
				endRow, firstCol, endCol);
		// 数据有效性对象
		HSSFDataValidation data_validation_view = new HSSFDataValidation(
				regions, constraint);
		data_validation_view.createPromptBox(promptTitle, promptContent);
		sheet.addValidationData(data_validation_view);
		return sheet;
	}

	/**
	 * 设置某些列的值只能输入预制的数据,显示下拉框.
	 * 
	 * @param sheet
	 *            要设置的sheet.
	 * @param textlist
	 *            下拉框显示的内容
	 * @param firstRow
	 *            开始行
	 * @param endRow
	 *            结束行
	 * @param firstCol
	 *            开始列
	 * @param endCol
	 *            结束列
	 * @return 设置好的sheet.
	 */
	public static HSSFSheet setHSSFValidation(HSSFSheet sheet,
			String[] textlist, int firstRow, int endRow, int firstCol,
			int endCol) {
		// 加载下拉列表内容
		DVConstraint constraint = DVConstraint
				.createExplicitListConstraint(textlist);
		// 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
		CellRangeAddressList regions = new CellRangeAddressList(firstRow,
				endRow, firstCol, endCol);
		// 数据有效性对象
		HSSFDataValidation data_validation_list = new HSSFDataValidation(
				regions, constraint);
		sheet.addValidationData(data_validation_list);
		return sheet;
	}
	
	public static boolean isBlankRow(HSSFRow row, int index, int rowCount){
		if(row == null)
			return true;
		for(int i=index; i < rowCount; i++){
			if(row.getCell(i) != null && 
					!"".equals(row.getCell(i).getStringCellValue().trim())){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isBlankRow(XSSFRow row, int index, int rowCount){
		if(row == null)
			return true;
		for(int i=index; i < rowCount; i++){
			if(row.getCell(i) != null || 
					!"".equals(row.getCell(i).getStringCellValue().trim())){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * 将EXCEL中A,B,C,D,E列映射成0,1,2,3
	 * 
	 * @param col
	 */
	public static int getExcelCol(String col) {
		col = col.toUpperCase();
		// 从-1开始计算,字母重1开始运算。这种总数下来算数正好相同。
		int count = -1;
		char[] cs = col.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			count += (cs[i] - 64) * Math.pow(26, cs.length - 1 - i);
		}
		return count;
	}
	
	
	public static String vaildDateType(HSSFCell cell){
		if ("yyyy/mm;@".equals(cell.getCellStyle().getDataFormatString())
				|| "m/d/yy".equals(cell.getCellStyle().getDataFormatString())
				|| "yy/m/d".equals(cell.getCellStyle().getDataFormatString())
				|| "mm/dd/yy".equals(cell.getCellStyle().getDataFormatString())
				|| "dd-mmm-yy".equals(cell.getCellStyle().getDataFormatString())
				|| "yyyy/m/d".equals(cell.getCellStyle().getDataFormatString())) {
			return new SimpleDateFormat("yyyy/MM/dd").format(cell.getDateCellValue());
		}else{
			return "";
		}
	}
	
	
	/**
	 * 验证xls文件的单元格内容是否符合标准
	 * @Time   2018年3月26日下午5:41:55
	 * @param field
	 * @param cell
	 * @param pattern
	 * @return
	 */
	public static boolean HSSFCheckCellContent(Field field,HSSFCell cell,String pattern) {
		Pattern r = Pattern.compile(pattern);
		boolean flag = false;
		if (Date.class == field.getType()) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				sdf.format(dateCellValue);
			} catch (Exception var5) {
				return false;
			}
			flag = true;
		}else{
			Matcher m = r.matcher(cell.getStringCellValue());
			flag = m.matches();
		}
		return flag;
	}
	
	/**
	 * 验证xlsx文件的单元格内容是否符合标准
	 * @Time   2018年3月26日下午5:41:55
	 * @param field
	 * @param cell
	 * @param pattern
	 * @return
	 */
	public static boolean XSSFCheckCellContent(Field field,XSSFCell cell,String pattern) {
		Pattern r = Pattern.compile(pattern);
		boolean flag = false;
		if (Date.class == field.getType()) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				sdf.format(dateCellValue);
			} catch (Exception var5) {
				return false;
			}
			flag = true;
		}else{
			Matcher m = r.matcher(cell.getStringCellValue());
			flag = m.matches();
		}
		return flag;
	}
	
}
