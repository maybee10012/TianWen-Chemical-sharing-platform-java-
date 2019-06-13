<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>化学品使用</title>
    <%@include file="/common/header.jsp"%>
    <script type="text/javascript">
  //新增
  	function doUse(id){
  		document.forms[0].action = "${basePath}drug/drug_recordUI.action?drug.id=" + id;
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
                <div class="c_crumbs"><div><b></b><strong>化学品使用</strong></div> </div>
                <div class="search_art">
                    <li>
                       中文名：<s:textfield name="drug.chinesename" cssClass="s_text" id="chinesename"  cssStyle="width:160px;"/>
                       英文名：<s:textfield name="drug.englishname" cssClass="s_text" id="englishname"  cssStyle="width:160px;"/> 
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    
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
                                <td align="center"><s:property value="lable"/></td>
                                <td align="center"><s:property value="position"/></td>
                                <td align="center">
                                    <a href="javascript:doUse('<s:property value='id'/>')">使用</a>  
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