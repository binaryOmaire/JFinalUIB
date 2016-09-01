package com.platform.mvc.group;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.mvc.base.BaseModelCache;
import com.platform.plugin.ParamInitPlugin;
import com.platform.tools.ToolCache;

/**
 * 人员分组model
 * @author 董华健
 */
@SuppressWarnings("unused")
@Table(tableName = Group.table_name)
public class Group extends BaseModelCache<Group> {

	private static final long serialVersionUID = 6761767368352810428L;

	private static Logger log = Logger.getLogger(Group.class);
	
	public static final Group dao = new Group();

	/**
	 * 表名称
	 */
	public static final String table_name = "pt_group";
	
	/**
	 * 字段描述：主键 
	 * 字段类型：character varying  长度：32
	 */
	public static final String column_ids = "ids";
	
	/**
	 * 字段描述：版本号 
	 * 字段类型：bigint  长度：null
	 */
	public static final String column_version = "version";
	
	/**
	 * 字段描述：描述 
	 * 字段类型：character varying  长度：2000
	 */
	public static final String column_description = "description";
	
	/**
	 * 字段描述：名称 
	 * 字段类型：character varying  长度：50
	 */
	public static final String column_names = "names";
	
	/**
	 * 字段描述：编号 
	 * 字段类型：character varying  长度：50
	 */
	public static final String column_numbers = "numbers";
	
	/**
	 * sqlId : platform.group.splitPage
	 * 描述：分页from
	 */
	public static final String sqlId_splitPageFrom = "platform.group.splitPageFrom";

	/**
	 * sqlId : platform.group.paging
	 * 描述：查询所有分组 
	 */
	public static final String sqlId_paging = "platform.group.paging";

	private String ids;
	private Long version;
	private String description;
	private String names;
	private String numbers;
	
	public void setIds(String ids){
		set(column_ids, ids);
	}
	public String getIds() {
		return get(column_ids);
	}
	public void setVersion(Long version){
		set(column_version, version);
	}
	public Long getVersion() {
		return get(column_version);
	}
	public void setDescription(String description){
		set(column_description, description);
	}
	public String getDescription() {
		return get(column_description);
	}
	public void setNames(String names){
		set(column_names, names);
	}
	public String getNames() {
		return get(column_names);
	}
	public void setNumbers(String numbers){
		set(column_numbers, numbers);
	}
	public String getNumbers() {
		return get(column_numbers);
	}
	
	/**
	 * 添加或者更新缓存
	 */
	public void cacheAdd(String ids){
		ToolCache.set(ParamInitPlugin.cacheStart_group + ids, Group.dao.findById(ids));
	}

	/**
	 * 删除缓存
	 */
	public void cacheRemove(String ids){
		ToolCache.remove(ParamInitPlugin.cacheStart_group + ids);
	}

	/**
	 * 获取缓存
	 * @param ids
	 * @return
	 */
	public Group cacheGet(String ids){
		Group group = ToolCache.get(ParamInitPlugin.cacheStart_group + ids);
		if(group == null){
			group = Group.dao.findById(ids);
		}
		return group;
	}
	
}
