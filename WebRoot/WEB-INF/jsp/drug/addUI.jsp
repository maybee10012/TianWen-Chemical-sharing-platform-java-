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
<form id="form" name="form" action="${basePath }drug/drug_add.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>化学品添加</strong>&nbsp;-&nbsp;化学品编辑</div></div>
    <div class="tableH2">添加化学品</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td  width="200">ID：</td>
            <td><s:textfield id="id" name="drug.id"/></td>
        </tr>
        <tr>
            <td width="200">中文名：</td>
            <td><s:textfield id="chinesename" name="drug.chinesename"/></td>
        </tr>
         <tr>
            <td width="200">英文名：</td>
            <td><s:textfield id="englishname" name="drug.englishname"/></td>
        </tr>
        <tr>
            <td width="200">分子式：</td>
            <td><s:textfield id="molecular" name="drug.molecular"/></td>
        </tr>
        <tr>
            <td  width="200">厂家：</td>
            <td><s:textfield id="factory" name="drug.factory"/></td>
        </tr>
        
        <tr>
            <td width="200" >纯度：</td>
            <td><s:textfield id="purity" name="drug.purity"/> </td>
        </tr>
        <tr>
        <tr>
            <td  width="200">性状：</td>
            <td><s:textfield id="traits" name="drug.traits"/></td>
        </tr>
            <tr>
            <td  width="200">重量：</td>
            <td><s:textfield id="height" name="drug.height"/>g</td>
        </tr>
        <tr>
            <td  width="200">负责人：</td>
            <td><s:textfield id="principal" name="drug.principal"/></td>
        </tr>
         <tr>
            <td  width="200">入库时间：</td>
            <td><s:textfield id="usedate" name="drug.usedate" readonly="true" 
            onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});" >
            	<s:param name="value">
            		<s:date name="drug.usedate" format="yyyy-MM-dd"/>
            	</s:param>
            </s:textfield></td>
        </tr>
        <tr>
            <td  width="200">标签：</td>
            <td><s:textfield id="lable" name="drug.lable"/></td>
        </tr>
        <tr>
            <td  width="200">存储位置：</td>
            <td><s:textfield id="position" name="drug.position"/></td>
        </tr>
        
       </table>         
       
		

    <s:hidden name="drug.id"/>
    
    <div class="tc mt20">
        <input type="button" class="btnB2" value="保存" onclick="doSubmit()"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" "/>
    </div>
    </div></div></div>
</form>
</body>
</html>