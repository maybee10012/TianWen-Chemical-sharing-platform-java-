package cn.sys.chemical.entity;

import java.io.Serializable;
import java.util.Date;

public class Drug implements Serializable {
  private String id;
  private String chinesename;
  private String englishname;
  private String molecular;
  private String factory;
  private String purity;
  private String traits;
  private double height;
  private String principal;
  private Date usedate;
  private String lable;
  private String position;
  
  public Drug(){
	  super();
	  
  }

public Drug(String id, String chinesename, String englishname, String molecular, String factory, String purity,
		String traits, double height, String principal, Date usedate, String lable, String position) {
	super();
	this.id = id;
	this.chinesename = chinesename;
	this.englishname = englishname;
	this.molecular = molecular;
	this.factory = factory;
	this.purity = purity;
	this.traits = traits;
	this.height = height;
	this.principal = principal;
	this.usedate = usedate;
	this.lable = lable;
	this.position = position;
}

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getChinesename() {
	return chinesename;
}
public void setChinesename(String chinesename) {
	this.chinesename = chinesename;
}
public String getEnglishname() {
	return englishname;
}
public void setEnglishname(String englishname) {
	this.englishname = englishname;
}
public String getMolecular() {
	return molecular;
}
public void setMolecular(String molecular) {
	this.molecular = molecular;
}
public String getFactory() {
	return factory;
}
public void setFactory(String factory) {
	this.factory = factory;
}
public String getPurity() {
	return purity;
}
public void setPurity(String purity) {
	this.purity = purity;
}
public String getTraits() {
	return traits;
}
public void setTraits(String traits) {
	this.traits = traits;
}
public double getHeight() {
	return height;
}
public void setHeight(Double height) {
	this.height = height;
}
public String getPrincipal() {
	return principal;
}
public void setPrincipal(String principal) {
	this.principal = principal;
}
public String getLable() {
	return lable;
}
public void setLable(String lable) {
	this.lable = lable;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}

public Date getUsedate() {
	return usedate;
}

public void setUsedate(Date usedate) {
	this.usedate = usedate;
}

@Override
public String toString() {
	return "Drug [id=" + id + ", chinesename=" + chinesename + ", englishname=" + englishname + ", molecular="
			+ molecular + ", factory=" + factory + ", purity=" + purity + ", traits=" + traits + ", height=" + height
			+ ", principal=" + principal + ", usedate=" + usedate + ", lable=" + lable + ", position=" + position + "]";
}


	
	
}
