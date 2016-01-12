/**
 * @Title: Atme8Plugin.java
 * @Package org.mybatis.generator.plugins
 * @Description: 
 * Copyright: Copyright (c) 2015 
 * Company: 真知行信息技术（大连）有限公司
 * 
 * @author JeremyWang
 * @date 2015年10月20日 下午4:08:15
 * @version V1.0
 */

package com.atme8.activity.extended.mbg;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;



/**
 * @ClassName: Atme8Plugin
 * @Description: 
 * @author JeremyWang
 * @date 2015年10月20日 下午4:08:15
 *
 */

public class Atme8MbgPlugin extends PluginAdapter {

	/*
	 * <p>Title: validate</p>
	 * <p>Description: </p>
	 * @param warnings
	 * @return
	 * @see org.mybatis.generator.api.Plugin#validate(java.util.List)
	 */
	public boolean validate(List<String> warnings) {
		// nothing to validate
		return true;
	}
	
	/*
	 * <p>Title: initialized</p>
	 * <p>Description: </p>
	 * @param introspectedTable
	 * @see org.mybatis.generator.api.PluginAdapter#initialized(org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public void initialized(IntrospectedTable introspectedTable) {
		super.initialized(introspectedTable);
		List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
		if (columns != null) {
			for (IntrospectedColumn introspectedColumn : columns) {
				String columnName = introspectedColumn.getActualColumnName();
				if (columnName.startsWith("is_")) {
					introspectedColumn.setFullyQualifiedJavaType(new FullyQualifiedJavaType(Boolean.class.getName()));
					continue;
				}
				if (columnName.endsWith("_id")
						|| columnName.equals("id")) {
					introspectedColumn.setFullyQualifiedJavaType(new FullyQualifiedJavaType(String.class.getName()));
					continue;
				}
			}
		}
	}

}
