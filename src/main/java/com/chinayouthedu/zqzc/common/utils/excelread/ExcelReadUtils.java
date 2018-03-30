package com.chinayouthedu.zqzc.common.utils.excelread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

public class ExcelReadUtils {

	private static final Gson gson = new Gson();

	private static final String DATE_FORMART = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 将一个Excel文件解析成Excel表的集合,方便进行解析等处理
	 * @param excelFile Excel文件
	 * @return Excel表的集合
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static List<HSSFSheet> getAllSheet(File excelFile) throws FileNotFoundException, IOException {
		List<HSSFSheet> sheetList = new ArrayList<HSSFSheet>();
		FileInputStream fileInputStream = new FileInputStream(excelFile);
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet sheet = null;
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			sheet = workbook.getSheetAt(i);
			if (sheet != null) {
				sheetList.add(sheet);
			}
		}
		// 关闭IO流
		fileInputStream.close();
		return sheetList;
	}

	/**
	 * 将一张Excel表的Excel转成行的集合
	 * @param sheet 一张Excel表
	 * @return Excel行的集合
	 */
	public static List<HSSFRow> getAllRow(HSSFSheet sheet) {
		List<HSSFRow> rowList = new ArrayList<HSSFRow>();
		for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
			HSSFRow row = sheet.getRow(j);
			if (row != null) {
				rowList.add(row);
			}
		}
		return rowList;
	}

	/**
	 * 将Excel中的一行数据转成JSON串
	 * @param properties Map格式的配置项,key表示解析的列号(从0开始),value表示将该列的数据解析到的字段的name,可以为null,为null时自动解析成{"0":___,"1":___...的形式}
	 * @param row Excel中的行
	 * @return
	 */
	public static JSONObject toJSON(Map<Integer, String> properties, HSSFRow row) {

		JSONObject json = null;
		try {
			json = new JSONObject();
			// 遍历Excel行的每一列,依次解析单元格内容
			for (int index = 0; index < row.getLastCellNum(); index++) {
				
				HSSFCell cell = row.getCell(index);
				/*
				 *  1.如果不存在Excel->JSON的转换关系的话,默认使用列号做name
				 *  2.当存在转换关系properties的并且不包含当前列的解析规则时，跳过该列的解析
				 *  3.当存在转换关系properties的并且包含当前列的解析规则时，使用转换关系中的value做JSON的name
				 */
				String key = null;
				if(properties!=null&&properties.size()>0){
					key = properties.get(index);
				}else{
					key = ""+index;
				}
				
				if (StringUtils.isNotBlank(key)) {
					
					// cellType：{_NONE(-1), NUMERIC(0), STRING(1), FORMULA(2), BLANK(3), BOOLEAN(4), ERROR(5);}
					
					// 优先解析日期格式的单元格
					if (isDateCell(cell)) {
						Date date = cell.getDateCellValue();
						json.put(key, new SimpleDateFormat(DATE_FORMART).format(date));
					}
					
					// 解析数字格式的单元格
					else if (cell.getCellType() == 0) {
						double number = cell.getNumericCellValue();
						json.put(key, number);
					}
					
					// 解析布尔型
					else if(cell.getCellType() == 4 ){
						boolean booleanValue = cell.getBooleanCellValue();
						json.put(key, booleanValue);
					}

					// 解析字符形式的单元格
					else if (cell.getCellType() == 1) {
						String str = cell.getStringCellValue();
						json.put(key, str);
					}
					
					// Other:其他类型的单元格一般不使用,如果需要使用,可以自定义
					// 其他类型的单元格,不解析
					
				}
			}
			return json;
		} catch (Exception e) {

		} finally {
			return json;
		}
	}


	/**
	 * 读取Excel文件到JSON串的集合
	 * 使用JSON串的好处:方便解析,可以在获取到JSON串后做更多的自定义的操作
	 * @param file Excel文件
	 * @param properties Excel列->JSON的key的配置项(Map形式)
	 * @param booleanParse 自定义的String->Boolean类型的转换器
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return
	 */
	public static List<JSONObject> readExcelFile(File file, Map<Integer, String> properties, BooleanParse booleanParse)
			throws FileNotFoundException, IOException {

		List<JSONObject> list = new ArrayList<JSONObject>();

		getAllSheet(file).forEach(sheet -> {
			getAllRow(sheet).forEach(row -> {
				try {
					
					// 将Excel行数据转成JSON数据
					JSONObject json = toJSON(properties, row);
					System.out.println("json=" + json);
					
					// 如果有自定义的String->Boolean类型的转换器的话,需要进行转换操作
					if (booleanParse!=null&&booleanParse.getRules()!=null&&booleanParse.getRules().size()>0) {
						Map<String, String> rules = booleanParse.getRules();
						rules.entrySet().forEach(rule -> {
							String property = rule.getKey();
							String trueValue = rule.getValue();
							try {
								Object object = json.get(property);
								json.put(property, false);
								if (Objects.equals(object, trueValue)) {
									json.put(property, true);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						});
					}
					list.add(json);
					System.out.println("json=" + json.toString());
				} catch (Exception e) {
				}
			});
		});
		return list;
	}

	/**
	 * 判断单元格是否为日期/时间格式单元格
	 * @param cell
	 * @return 如果是日期格式单元格,返回true,否则返回false
	 */
	public static boolean isDateCell(HSSFCell cell) {
		boolean flag = false;
		try {
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				flag = true;
			}
		} finally {
			return flag;
		}
	}

}
