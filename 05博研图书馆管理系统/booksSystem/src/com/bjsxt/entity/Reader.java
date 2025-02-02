package com.bjsxt.entity;

import java.util.Date;

public class Reader {
	private int rid;
	private String name;
	private String sex;
	private int tid;// 类型
	private String barcode;
	private String vocation;
	private Date birthday;
	private String paperType;
	private String paperNo;
	private String tel;
	private String email;
	private Date createDate;
	private String operator;
	private String remark;
	private Date endDate;
	private ReaderType readerType;

	public Reader(int rid, String name) {
		super();
		this.rid = rid;
		this.name = name;
	}

	public ReaderType getReaderType() {
		return readerType;
	}

	public void setReaderType(ReaderType readerType) {
		this.readerType = readerType;
	}

	public Reader(int rid, String name, String sex, int tid, String barcode,
			String vocation, Date birthday, String paperType, String paperNo,
			String tel, String email, Date createDate, String operator,
			String remark, Date endDate, ReaderType readerType) {
		super();
		this.rid = rid;
		this.name = name;
		this.sex = sex;
		this.tid = tid;
		this.barcode = barcode;
		this.vocation = vocation;
		this.birthday = birthday;
		this.paperType = paperType;
		this.paperNo = paperNo;
		this.tel = tel;
		this.email = email;
		this.createDate = createDate;
		this.operator = operator;
		this.remark = remark;
		this.endDate = endDate;
		this.readerType = readerType;
	}

	public Reader(String name, String sex, int tid, String barcode,
			String vocation, Date birthday, String paperType, String paperNo,
			String tel, String email, Date createDate, String operator,
			String remark, Date endDate) {
		super();
		this.name = name;
		this.sex = sex;
		this.tid = tid;
		this.barcode = barcode;
		this.vocation = vocation;
		this.birthday = birthday;
		this.paperType = paperType;
		this.paperNo = paperNo;
		this.tel = tel;
		this.email = email;
		this.createDate = createDate;
		this.operator = operator;
		this.remark = remark;
		this.endDate = endDate;
	}

	public Reader(int rid, String name, String sex, int tid, String barcode,
			String vocation, Date birthday, String paperType, String paperNo,
			String tel, String email, Date createDate, String operator,
			String remark, Date endDate) {
		super();
		this.rid = rid;
		this.name = name;
		this.sex = sex;
		this.tid = tid;
		this.barcode = barcode;
		this.vocation = vocation;
		this.birthday = birthday;
		this.paperType = paperType;
		this.paperNo = paperNo;
		this.tel = tel;
		this.email = email;
		this.createDate = createDate;
		this.operator = operator;
		this.remark = remark;
		this.endDate = endDate;
	}

	public Reader(String name, int rid, String sex, String paperType,
			String paperNo, ReaderType readerType) {
		super();
		this.name = name;
		this.rid = rid;
		this.sex = sex;
		this.paperType = paperType;
		this.paperNo = paperNo;
		this.readerType = readerType;
	}

	public Reader() {
		super();
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public String getPaperNo() {
		return paperNo;
	}

	public void setPaperNo(String paperNo) {
		this.paperNo = paperNo;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((paperNo == null) ? 0 : paperNo.hashCode());
		result = prime * result
				+ ((paperType == null) ? 0 : paperType.hashCode());
		result = prime * result
				+ ((readerType == null) ? 0 : readerType.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + rid;
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + tid;
		result = prime * result
				+ ((vocation == null) ? 0 : vocation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reader other = (Reader) obj;
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (paperNo == null) {
			if (other.paperNo != null)
				return false;
		} else if (!paperNo.equals(other.paperNo))
			return false;
		if (paperType == null) {
			if (other.paperType != null)
				return false;
		} else if (!paperType.equals(other.paperType))
			return false;
		if (readerType == null) {
			if (other.readerType != null)
				return false;
		} else if (!readerType.equals(other.readerType))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (rid != other.rid)
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (tid != other.tid)
			return false;
		if (vocation == null) {
			if (other.vocation != null)
				return false;
		} else if (!vocation.equals(other.vocation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reader [rid=" + rid + ", name=" + name + ", sex=" + sex
				+ ", tid=" + tid + ", barcode=" + barcode + ", vocation="
				+ vocation + ", birthday=" + birthday + ", paperType="
				+ paperType + ", paperNo=" + paperNo + ", tel=" + tel
				+ ", email=" + email + ", createDate=" + createDate
				+ ", operator=" + operator + ", remark=" + remark
				+ ", endDate=" + endDate + ", readerType=" + readerType + "]";
	}

	
}	