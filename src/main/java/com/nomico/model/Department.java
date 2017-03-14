package com.nomico.model;

import java.io.Serializable;
import java.util.Date;

public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4390644487799098692L;

	private String id;

    private String deptname;

    private String remark;

    private Integer state;

    private Date createtime;

    private String createip;

    private Date overtime;

    private String overip;

    private String a1;

    private String a2;

    private Integer b1;

    private Date c1;

  

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateip() {
        return createip;
    }

    public void setCreateip(String createip) {
        this.createip = createip == null ? null : createip.trim();
    }

    public Date getOvertime() {
        return overtime;
    }

    public void setOvertime(Date overtime) {
        this.overtime = overtime;
    }

    public String getOverip() {
        return overip;
    }

    public void setOverip(String overip) {
        this.overip = overip == null ? null : overip.trim();
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1 == null ? null : a1.trim();
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2 == null ? null : a2.trim();
    }

    public Integer getB1() {
        return b1;
    }

    public void setB1(Integer b1) {
        this.b1 = b1;
    }

    public Date getC1() {
        return c1;
    }

    public void setC1(Date c1) {
        this.c1 = c1;
    }
}