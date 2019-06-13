<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>化学品管理</title>
    <%@include file="/common/header.jsp"%>
    <script type="text/javascript">
      	//全选、全反选
		function doSelectAll(){
			$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
		}
      	//新增
      	function doAdd(){
      		document.forms[0].action = "${basePath}drug/drug_addUI.action";
      		document.forms[0].submit();
      	}
      	//编辑
      	function doEdit(id){
      		document.forms[0].action = "${basePath}drug/drug_editUI.action?drug.id=" + id;
      		document.forms[0].submit();
      	}
      	//删除
      	function doDelete(id){
      		document.forms[0].action = "${basePath}drug/drug_delete.action?drug.id=" + id;
      		document.forms[0].submit();
      	}
      	//批量删除
      	function doDeleteAll(){
      		document.forms[0].action = "${basePath}drug/drug_deleteSelected.action";
      		document.forms[0].submit();
      	}
      	//导出
      	function doExportExcel(){
      		window.open("${basePath}drug/drug_exportExcel.action");
      	}
      	//导入
      	function doImportExcel(){
      		document.forms[0].action = "${basePath}drug/drug_importExcel.action";
      		document.forms[0].submit();
      	}
      	var list_url = "${basePath}drug/drug_listUI.action";
      	//搜索
      	function doSearch(){
      		$("#pageNo").val(1);
      		document.forms[0].action = list_url;
      		document.forms[0].submit();
      	}

    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>化学品管理</strong></div> </div>
                <div class="search_art">
                    <li>
                       中文名：<s:textfield name="drug.chinesename" cssClass="s_text" id="chinesename"  cssStyle="width:160px;"/>
                       英文名：<s:textfield name="drug.englishname" cssClass="s_text" id="englishname"  cssStyle="width:160px;"/> 
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd()"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll()"/>&nbsp;
                        <input type="button" value="导出" class="s_button" onclick="doExportExcel()"/>&nbsp;
                    	<input name="userExcel" type="file"/>
                        <input type="button" value="导入" class="s_button" onclick="doImportExcel()"/>&nbsp;

                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" /></td>
                            <td width="140" align="center">中文名</td>
                            <td width="140" align="center">英文名</td>
                            <td width="160" align="center">分子式</td>
                            <td width="80" align="center">厂家</td>
                            <td width="80" align="center">纯度(%)</td>
                            <td width="80" align="center">性状</td>
                            <td width="80" align="center">重量(/g)</td>
                            <td width="80" align="center">负责人</td>
                            <td width="80" align="center">最新入库时间</td>
                            <td width="80" align="center">标签</td>
                            <td width="80" align="center">存放位置</td>
                           
                           <td width="100" align="center">操作</td> 
                        </tr>
                        <s:iterator value="pageResult.items" status="st">
                            <tr <s:if test="#st.odd"> bgcolor="#f8f8f8" </s:if> >
                                <td align="center"><input type="checkbox" name="selectedRow" value="<s:property value='id'/>"/></td>
                                <td align="center"><s:property value="chinesename"/></td>
                                <td align="center"><s:property value="englishname"/></td>
                                <td align="center"><s:property value="molecular"/></td>
                                <td align="center"><s:property value="factory"/></td>
                                <td align="center"><s:property value="purity"/></td>
                                <td align="center"><s:property value="traits"/></td>
                                <td align="center"><s:property value="height"/></td>
                                <td align="center"><s:property value="principal"/></td>
                                <td align="center"><s:property value="usedate"/></td>
                                <td align="center"><s:property value="lable"/></td>
                                <td align="center"><s:property value="position"/></td>
                                <td align="center">
                                    <a href="javascript:doEdit('<s:property value='id'/>')">编辑</a>
                                    <a href="javascript:doDelete('<s:property value='id'/>')">删除</a>
                                </td> 
                            </tr>
                        </s:iterator>
                    </table>
                </div>
            </div>
        <jsp:include page="/common/pageNavigator.jsp"></jsp:include>
        </div>
    </div>
</form>

</body>
</html>