<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>用户管理</title>
    <script type="text/javascript" src="${basePath }js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript">
    
    /* var res = false;
    	//校验帐号唯一性
    	function verifyAccount(asyncFlag){
    		if(asyncFlag != false) asyncFlag = true;
    		//1、获取帐号
    		var $account = $("#account");
    		if($account.val() != ""){
    			//2、根据帐号到数据库中查询用户记录并返回结果，提示用户该帐号是否可以
    			$.ajax({
    				url:"${basePath}nsfw/user_verifyAccount.action",
    				type:"get",
    				data:{"user.account":$account.val(),"user.id":"${user.id}"},
    				async:asyncFlag,//是否异步请求
    				success:function(msg){
    					if("true" != msg){//说明帐号已经存在
    						alert("该帐号已经被使用；请输入其它帐号！");
    						$account.focus();
    						res = false;
    					} else {
    						res = true;
    					}
    				}
    			});
    		}
    	} */
    	
    	//提交表单
    	function doSubmit(){
    		var $name = $("#name");
    		if($name.val() == ""){
    			alert("用户名不能为空");
    			$name.focus();
    			return false;
    		}
    		var $password = $("#password");
    		if($password.val() == ""){
    			alert("密码不能为空");
    			$password.focus();
    			return false;
    		}
    		document.forms[0].submit();
    	}
    </script>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath }system/student_edit.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>个人信息编辑</strong>&nbsp;-&nbsp;编辑用户</div></div>
    <div class="tableH2">编辑用户</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td  width="200">用户ID：</td>
            <td><s:textfield name="student.id" /></td>
        </tr>
        <tr>
            <td width="200">用户姓名：</td>
            <td><s:textfield name="student.name" /></td>
        </tr>
         <tr>
            <td width="200">用户账号：</td>
            <td><s:textfield name="student.username" /></td>
        </tr>
        <tr>
            <td width="200">用户性别：</td>
            <td><s:textfield name="student.gender" /></td>
        </tr>
        <tr>
            <td  width="200">用户密码：</td>
            <td><s:textfield name="student.password" /></td>
        </tr>
        <tr>
            <td width="200">用户头像：</td>
            <td>
                <s:if test="%{student.headImg != null && student.headImg != ''}">
                    <img src="${basePath }upload/<s:property value='student.headImg'/>" width="100" height="100"/>
                    <s:hidden name="student.headImg"/>
                </s:if>
                <input type="file" name="headImg"/>
            </td>
        </tr>
        <tr>
            <td width="200" >用户联系号码：</td>
            <td><s:textfield name="student.phone"/> </td>
        </tr>
        <tr>
        <tr>
            <td  width="200">用户状态：</td>
            <td><s:textfield name="student.state" /></td>
        </tr>
            <tr>
            <td  width="200">办公室：</td>
            <td><s:textfield name="student.workhouse" /></td>
        </tr>
        <tr>
            <td  width="200">E-mail：</td>
            <td><s:textfield name="student.email" /></td>
        </tr>
        <tr>
            <td  width="200">专业：</td>
            <td><s:textfield name="student.profession" /></td>
        </tr>
        <tr>
            <td  width="200">注册时间：</td>
            <td><s:textfield id="registedate" name="student.registdate" readonly="true" 
            onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});" >
            	<s:param name="value">
            		<s:date name="student.registdate" format="yyyy-MM-dd"/>
            	</s:param>
            </s:textfield></td>
        </tr>
        <tr>
            <td  width="200">导师：</td>
            <td><s:textfield name="student.teacher" /></td>
        </tr>
        <tr>
            <td  width="200">所属学院：</td>
            <td><s:textfield name="student.college" /></td>
        </tr>
       </table>         
       
		

    
    <s:hidden name="strName"/>
    <div class="tc mt20">
        <input type="button" class="btnB2" value="保存" onclick="doSubmit()"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>