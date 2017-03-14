package com.nomico.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1314773573451327876L;

	private String id;

 	private String username;

    private String password;

    private String truename;

    private String rolename;

    private String deptid;

    private String overip;

    private String createip;

    private String a3;

    private Integer state;

    private Integer b2;

    private Date overtime;
    private Date createtime;
    private Department department;
    
    
    
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }


    public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		 this.deptid = deptid == null ? null : deptid.trim();
	}

	public String getOverip() {
        return overip;
    }

    public void setOverip(String overip) {
        this.overip = overip == null ? null : overip.trim();
    }

    public String getCreateip() {
        return createip;
    }

    public void setCreateip(String createip) {
        this.createip = createip == null ? null : createip.trim();
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3 == null ? null : a3.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getB2() {
        return b2;
    }

    public void setB2(Integer b2) {
        this.b2 = b2;
    }

    public Date getOvertime() {
        return overtime;
    }

    public void setOvertime(Date overtime) {
        this.overtime = overtime;
    }
}