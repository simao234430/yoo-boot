package com.yoo.boot.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoo.boot.common.exception.YooBootException;
import com.yoo.boot.modules.system.entity.SysPermission;
import com.yoo.boot.modules.system.model.TreeModel;


import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @Author scott
 * @since 2018-12-21
 */
public interface ISysPermissionService extends IService<SysPermission> {

	public List<TreeModel> queryListByParentId(String parentId);

	/**真实删除*/
	public void deletePermission(String id) throws YooBootException;
	/**逻辑删除*/
	public void deletePermissionLogical(String id) throws YooBootException;

	public void addPermission(SysPermission sysPermission) throws YooBootException;

	public void editPermission(SysPermission sysPermission) throws YooBootException;

	public List<SysPermission> queryByUser(String username);

	/**
	 * 根据permissionId删除其关联的SysPermissionDataRule表中的数据
	 *
	 * @param id
	 * @return
	 */
	public void deletePermRuleByPermId(String id);

	/**
	  * 查询出带有特殊符号的菜单地址的集合
	 * @return
	 */
	public List<String> queryPermissionUrlWithStar();

	/**
	 * 判断用户否拥有权限
	 * @param username
	 * @param sysPermission
	 * @return
	 */
	public boolean hasPermission(String username, SysPermission sysPermission);

	/**
	 * 根据用户和请求地址判断是否有此权限
	 * @param username
	 * @param url
	 * @return
	 */
	public boolean hasPermission(String username, String url);
}
