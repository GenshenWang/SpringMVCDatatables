package com.nomico.util;

import com.github.pagehelper.PageInfo;

/**
 * 分页工具类
 * @author 男孩的天职
 * 2015-5-9
 */
public class PageUtil {
	/**
	 * 获取分页代码
	 * @param targetUrl 跳转地址
	 * @param pageinfo mybatis插件的分页信息
	 * @param id   0  返回文字分页  1  返回bootstrap按钮分页
	 * @return
	 */
	public static String getPage(String targetUrl,PageInfo pageinfo,int id){
		StringBuffer str=new StringBuffer();
		str.append("第&nbsp;");	
		str.append(pageinfo.getPageNum());
		str.append("&nbsp;页&nbsp;/&nbsp;共&nbsp;");
		str.append(pageinfo.getPages());
		str.append("&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;");	
			//返回文字分页
		if(id==0){			
			//如果当前页码不等于1就显示首页
			if(pageinfo.getPageNum()!=1){				
				str.append("<a href='");
				str.append(targetUrl);
				str.append(".do?page=1");
				str.append("'>首 页</a>&nbsp;&nbsp;");			
			}
			//如果当前页码大于1，就显示上一页
			if(pageinfo.getPageNum()>1){				
				str.append("<a href='");
				str.append(targetUrl);
				str.append(".do?page=");
				str.append(pageinfo.getPageNum()-1);
				str.append("'>上一页</a>&nbsp;&nbsp;");			
			}
			
			//如果当前页码小于总页码数，就显示下一页
			if(pageinfo.getPageNum()<pageinfo.getPages()){				
				str.append("<a href='");
				str.append(targetUrl);
				str.append(".do?page=");
				str.append(pageinfo.getPageNum()+1);
				str.append("'>下一页</a>&nbsp;&nbsp;");			
			}
			//如果当前页码小于总页码数，就显示下一页
			if(pageinfo.getPageNum()!=pageinfo.getPages()){				
				str.append("<a href='");
				str.append(targetUrl);
				str.append(".do?page=");
				str.append(pageinfo.getPages());
				str.append("'>尾 页</a>&nbsp;&nbsp;");			
			}
			
		}
		//返回bootstrap按钮分页
		else{
			//如果当前页码不等于1就显示首页
			if(pageinfo.getPageNum()!=1){				
				str.append("<a href='");
				str.append(targetUrl);
				str.append(".do?page=1");
				str.append("'><button type='button' class='btn btn-info'>首 页</button></a>&nbsp;&nbsp;");			
			}
			//如果当前页码大于1，就显示上一页
			if(pageinfo.getPageNum()>1){				
				str.append("<a href='");
				str.append(targetUrl);
				str.append(".do?page=");
				str.append(pageinfo.getPageNum()-1);
				str.append("'><button type='button' class='btn btn-info'>上一页</button></a>&nbsp;&nbsp;");			
			}
			
			//如果当前页码小于总页码数，就显示下一页
			if(pageinfo.getPageNum()<pageinfo.getPages()){				
				str.append("<a href='");
				str.append(targetUrl);
				str.append(".do?page=");
				str.append(pageinfo.getPageNum()+1);
				str.append("'><button type='button' class='btn btn-info'>下一页</button></a>&nbsp;&nbsp;");			
			}
			//如果当前页码小于总页码数，就显示下一页
			if(pageinfo.getPageNum()!=pageinfo.getPages()){				
				str.append("<a href='");
				str.append(targetUrl);
				str.append(".do?page=");
				str.append(pageinfo.getPages());
				str.append("'><button type='button' class='btn btn-info'>尾 页</button></a>&nbsp;&nbsp;");			
			}
		}
		return str.toString();
}
	
}
