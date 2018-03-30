package com.chinayouthedu.zqzc.plugin.mybatis;

import org.mybatis.generator.api.IntrospectedTable;  
import org.mybatis.generator.api.PluginAdapter;  
import org.mybatis.generator.api.dom.java.*;  
  
import java.util.List;  
import java.util.Properties;  

/**
 * 用于生成*Model跟 *Example 类都实现序列化接口
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2017年12月5日 上午10:50:46
 * @version 1.0
 */
public class SerializablePlugin extends PluginAdapter {  
  
    private FullyQualifiedJavaType serializable;  
    private FullyQualifiedJavaType gwtSerializable;  
    private boolean addGWTInterface;  
    private boolean suppressJavaInterface;  
  
    public SerializablePlugin() {  
        super();  
        serializable = new FullyQualifiedJavaType("java.io.Serializable"); //$NON-NLS-1$  
        gwtSerializable = new FullyQualifiedJavaType("com.google.gwt.user.client.rpc.IsSerializable"); //$NON-NLS-1$  
    }  
  
    public boolean validate(List<String> warnings) {  
        // this plugin is always valid  
        return true;  
    }  
  
    @Override  
    public void setProperties(Properties properties) {  
        super.setProperties(properties);  
        addGWTInterface = Boolean.valueOf(properties.getProperty("addGWTInterface")); //$NON-NLS-1$  
        suppressJavaInterface = Boolean.valueOf(properties.getProperty("suppressJavaInterface")); //$NON-NLS-1$  
    }  
  
    @Override  
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,IntrospectedTable introspectedTable) {
        makeSerializable(topLevelClass, introspectedTable);  
        
        return true;  
    }  
  
    @Override  
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {  
        makeSerializable(topLevelClass, introspectedTable);  
        return true;  
    }  
  
    @Override  
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {  
        makeSerializable(topLevelClass, introspectedTable);  
        return true;  
    }  
  
    /**
     * 用于生成 *Example 类都实现序列化接口 
     */
    @Override  
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,IntrospectedTable introspectedTable){  
        makeSerializable(topLevelClass, introspectedTable);  
  
        for (InnerClass innerClass : topLevelClass.getInnerClasses()) {  
            if ("GeneratedCriteria".equals(innerClass.getType().getShortName())) { //$NON-NLS-1$  
                innerClass.addSuperInterface(serializable);  
            }  
            if ("Criteria".equals(innerClass.getType().getShortName())) { //$NON-NLS-1$  
                innerClass.addSuperInterface(serializable);  
            }  
            if ("Criterion".equals(innerClass.getType().getShortName())) { //$NON-NLS-1$  
                innerClass.addSuperInterface(serializable);
            }  
        }
        return true;  
    }  
  
    protected void makeSerializable(TopLevelClass topLevelClass,  
                                    IntrospectedTable introspectedTable) {  
        if (addGWTInterface) {  
            topLevelClass.addImportedType(gwtSerializable);  
            topLevelClass.addSuperInterface(gwtSerializable);  
        }  
  
        if (!suppressJavaInterface) {  
            topLevelClass.addImportedType(serializable);  
            topLevelClass.addSuperInterface(serializable);  
  
            Field field = new Field();  
            field.setFinal(true);  
            field.setInitializationString("1L"); //$NON-NLS-1$  
            field.setName("serialVersionUID"); //$NON-NLS-1$  
            field.setStatic(true);  
            field.setType(new FullyQualifiedJavaType("long")); //$NON-NLS-1$  
            field.setVisibility(JavaVisibility.PRIVATE);  
            context.getCommentGenerator().addFieldComment(field, introspectedTable);  
  
            topLevelClass.addField(field);  
        }  
    }  
}  