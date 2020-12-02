package com.briup.jz.dao;

import com.briup.jz.bean.RolePrivilege;
import com.briup.jz.bean.RolePrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePrivilegeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Wed Dec 02 20:04:38 CST 2020
     */
    long countByExample(RolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Wed Dec 02 20:04:38 CST 2020
     */
    int deleteByExample(RolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Wed Dec 02 20:04:38 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Wed Dec 02 20:04:38 CST 2020
     */
    int insert(RolePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Wed Dec 02 20:04:38 CST 2020
     */
    int insertSelective(RolePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Wed Dec 02 20:04:38 CST 2020
     */
    List<RolePrivilege> selectByExample(RolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Wed Dec 02 20:04:38 CST 2020
     */
    RolePrivilege selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Wed Dec 02 20:04:38 CST 2020
     */
    int updateByExampleSelective(@Param("record") RolePrivilege record, @Param("example") RolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Wed Dec 02 20:04:38 CST 2020
     */
    int updateByExample(@Param("record") RolePrivilege record, @Param("example") RolePrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Wed Dec 02 20:04:38 CST 2020
     */
    int updateByPrimaryKeySelective(RolePrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_privilege
     *
     * @mbg.generated Wed Dec 02 20:04:38 CST 2020
     */
    int updateByPrimaryKey(RolePrivilege record);
}