package com.chinayouthedu.zqzc.plugin.mybatis;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * 描述:扩展插件:
 * 生成limit分页属性 page跟pageSize
 * 修改分页属性page的get方法生成方为 (page-1)*pageSize
 * 同时继承指定父类
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2017年12月5日 上午10:53:35
 * @version 1.0
 */
public class PaginationPlugin extends PluginAdapter{
	
	@Override  
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,IntrospectedTable introspectedTable) {  
        addLimit(topLevelClass, introspectedTable, "page");  
        addLimit(topLevelClass, introspectedTable, "pageSize");  
        addSuperClass(topLevelClass,introspectedTable);
        return super.modelExampleClassGenerated(topLevelClass,  introspectedTable);  
    }  

	@Override  
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(  
        XmlElement element, IntrospectedTable introspectedTable) {  
        XmlElement isNotNullElement = new XmlElement("if");
        isNotNullElement.addAttribute(new Attribute("test", "null != page  and pageSize>=0"));
        isNotNullElement.addElement(new TextElement("limit #{page} , #{pageSize}"));  
        element.addElement(isNotNullElement);  
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element,introspectedTable);  
    }  
    
    private void addLimit(TopLevelClass topLevelClass,IntrospectedTable introspectedTable, String name) {  
        CommentGenerator commentGenerator = context.getCommentGenerator();  
        Field field = new Field();  
        field.setVisibility(JavaVisibility.PROTECTED);  
        field.setType(PrimitiveTypeWrapper.getIntegerInstance());  
        field.setName(name);  
        commentGenerator.addFieldComment(field, introspectedTable);  
        topLevelClass.addField(field);  
        char c = name.charAt(0);  
        String camel = Character.toUpperCase(c) + name.substring(1);  
        Method method = new Method();  
        method.setVisibility(JavaVisibility.PUBLIC);  
        method.setName("set" + camel);  
        method.addParameter(new Parameter(PrimitiveTypeWrapper.getIntegerInstance(), name));  
        if(name.equals("page")){ 
        	 method.addBodyLine("this." + name + "= (page-1) * pageSize;");
        }else{
        	method.addBodyLine("this." + name + "=" + name + ";");  
        }
        commentGenerator.addGeneralMethodComment(method, introspectedTable);  
        topLevelClass.addMethod(method);  
        method = new Method();  
        method.setVisibility(JavaVisibility.PUBLIC);  
        method.setReturnType(PrimitiveTypeWrapper.getIntegerInstance());  
        method.setName("get" + camel);  
        method.addBodyLine("return " + name + ";");  
        commentGenerator.addGeneralMethodComment(method, introspectedTable);  
        topLevelClass.addMethod(method);  
    }  
    
    //xxxExample类全部继承WebBasicExample
    public void addSuperClass(TopLevelClass topLevelClass,IntrospectedTable introspectedTable) {
		topLevelClass.setSuperClass("WebBasicExample");
        topLevelClass.addImportedType("music.struts2.webBasic.WebBasicExample");  
	}

    public boolean validate(List<String> warnings) {  
        return true;  
    }  
}
