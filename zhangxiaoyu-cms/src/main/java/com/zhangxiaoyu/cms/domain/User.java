/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: User.java 
 * @Prject: zhangxiaoyu-cms
 * @Package: com.zhangxiaoyu.cms.domain 
 * @Description: TODO
 * @author: Lenovo   
 * @date: 2019年8月13日 下午2:29:22 
 * @version: V1.0   
 */
package com.zhangxiaoyu.cms.domain;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
/**
 * 
 * @ClassName: User 
 * @Description: 用户
 * @author: charles
 * @date: 2019年7月17日 上午11:10:23
 */
public class User implements Serializable{
    /**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotBlank(message = "不能为空")
    private String username;

	@NotBlank(message = "不能为空")
	@Length(min = 2,max = 8,message = "长度必须6-10之间" )
    private String password;

    private String nickname;

    private Date birthday;

    private Integer gender;

    private Integer locked;

    private Date createTime;

    private Date updateTime;

    private String role;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}