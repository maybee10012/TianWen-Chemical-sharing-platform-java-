<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <%@include file="/common/header.jsp"%>
    <script type="text/javascript">
      
      	function doEdit(id){
      		document.forms[0].action = "${basePath}system/student_editUI.action?student.id=" + id;
      		document.forms[0].submit();
      	}
      	//删除
      	function doDelete(id){
      		document.forms[0].action = "${basePath}nsfw/user_delete.action?user.id=" + id;
      		document.forms[0].submit();
      	}
      
      
      	var list_url = "${basePath}nsfw/user_listUI.action";
      	

    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>个人信息</strong></div> </div>
                <div class="search_art">
                    <li>
                        姓名：<s:textfield name="student.name" cssClass="s_text" id="name"  cssStyle="width:160px;"/>
                    </li>
                   
               

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                           
                            <td width="140" align="center">用户ID</td>
                            <td width="140" align="center">姓名</td>
                            <td width="160" align="center">性别</td>
                            <td width="80" align="center">密码</td>
                            <td width="80" align="center">图片</td>
                            <td width="80" align="center">电话</td>
                            <td width="80" align="center">状态</td>
                            <td width="80" align="center">办公室</td>
                            <td width="80" align="center">邮箱</td>
                            <td width="80" align="center">专业</td>
                            <td width="80" align="center">注册时间</td>  
                            <td width="80" align="center">导师</td>
                            <td width="80" align="center">学院</td>
                            
                        
                        </tr>
                        <s:iterator value="pageResult.items" status="st">
                            <tr 
                            <s:if test="#st.odd"> bgcolor="#f8f8f8" </s:if> >
                                <td align="center"><s:property value="id"/></td>
                                <td align="center"><s:property value="name"/></td>
                                <td align="center"><s:property value="gender"/></td>
                                <td align="center"><s:property value="password"/></td>
                                <td align="center"><s:property value="headImg"/></td>
                                <td align="center"><s:property value="phone"/></td>
                                <td align="center"><s:property value="state"/></td>
                                <td align="center"><s:property value="workhouse"/></td>
                                <td align="center"><s:property value="email"/></td>
                                <td align="center"><s:property value="profession"/></td>
                                <td align="center"><s:property value="registdate"/></td>
                                <td align="center"><s:property value="teacher"/></td>
                                <td align="center"><s:property value="college"/></td>
                               
                               <td align="center">
                                    <a href="javascript:doEdit('<s:property value='id'/>')">编辑</a>
                                    <a href="javascript:doDelete('<s:property value='id'/>')">删除</a>
                                </td>
                            </tr>
                       </s:iterator>
                    </table>
                </div>
            </div>
    
        </div>
         
    </div>
</form>

</body>
</html>