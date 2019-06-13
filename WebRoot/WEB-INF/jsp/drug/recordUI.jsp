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
    		/* var $name = $("#name");
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
    		} */
    		document.forms[0].submit();
    	}
    </script>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath }drug/drug_edit.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>化学品信息编辑</strong>&nbsp;-&nbsp;编辑化学品</div></div>
    <div class="tableH2">编辑化学品</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td  width="300">化学ID：</td>
            <td><s:textfield name="drug.id" /></td>
        </tr>
        <tr>
            <td width="200">中文名：</td>
            <td><s:textfield name="drug.chinesename" /></td>
        </tr>
         <tr>
            <td width="200">英文名：</td>
            <td><s:textfield name="drug.englishname" /></td>
        </tr>
        <tr>
            <td width="200">分子式：</td>
            <td><s:textfield name="drug.molecular" /></td>
        </tr>
         <tr>
            <td width="200">厂家：</td>
            <td><s:textfield name="drug.factory" /></td>
        </tr>
         <tr>
            <td width="200">纯度：</td>
            <td><s:textfield name="drug.purity" /></td>
        </tr>
         <tr>
            <td width="200">性状：</td>
            <td><s:textfield name="drug.traits" /></td>
        </tr>
        <tr>
            <td  width="200">本次使用量：</td>
            <td><s:textfield name="drug.height" />请输入本次药品的使用量</td>
        </tr>
         <tr>
            <td  width="200">使用时间：</td>
            <td><s:textfield id="usedate" name="drug.usedate" readonly="true" 
            onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});" >
            	<s:param name="value">
            		<s:date name="drug.usedate" format="yyyy-MM-dd"/>
            	</s:param>
            </s:textfield>请填写使用时间</td>
        </tr>
            <tr>
            <td  width="200">负责人：</td>
            <td><s:textfield name="drug.principal" /></td>
        </tr>
        <tr>
            <td  width="200">标签：</td>
            <td><s:textfield name="drug.lable" /></td>
        </tr>
        <tr>
            <td  width="200">存放位置：</td>
            <td><s:textfield name="drug.position" /></td>
        </tr>
       </table>         
       
		

<%--   <s:hidden name="drug.id"/>  --%>
   <%--  <s:hidden name="strName"/> --%>
    <div class="tc mt20">
        <input type="button" class="btnB2" value="保存" onclick="doSubmit()"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>