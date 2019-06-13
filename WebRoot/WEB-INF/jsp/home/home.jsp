﻿<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    pageContext.setAttribute("ctx", request.getContextPath()) ;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>天问实验室化学品共享平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${ctx}/css/home.css" rel="stylesheet" type="text/css" />

</head>

<body>
<!-- 头部{ -->
<table width="1222" border="0" align="center" cellpadding="0"
       cellspacing="0" background="${ctx}/images/home/top_bg.png" class="top">
    <tr>
        <td width="32" height="106">&nbsp;</td>
        <td width="418" height="106" align="left" valign="middle">
            <img class="zxx_test_png" src="${ctx}/images/home/form_03.png" width="470" height="90" alt="" />
        </td>
        <td width="211">&nbsp;</td>
        <td width="328">
            <object id="FlashID" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="450" height="86">
                <param name="movie" value="${ctx}/images/home/flash.swf" />
                <param name="quality" value="high" />
                <param name="wmode" value="transparent" />
                <param name="swfversion" value="6.0.65.0" />
                <!-- 此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
                <param name="expressinstall" value="Scripts/expressInstall.swf" />
                <!-- 下一个对象标签用于非 IE 浏览器。所以使用 IECC 将其从 IE 隐藏。 -->
                <!--[if !IE]>-->
                <object type="application/x-shockwave-flash" data="${ctx}/images/home/flash.swf"
                        width="380" height="86">
                    <!--<![endif]-->
                    <param name="quality" value="high" />
                    <param name="wmode" value="transparent" />
                    <param name="swfversion" value="6.0.65.0" />
                    <param name="expressinstall" value="Scripts/expressInstall.swf" />
                    <!-- 浏览器将以下替代内容显示给使用 Flash Player 6.0 和更低版本的用户。 -->
                    <div>
                        <h4>此页面上的内容需要较新版本的 Adobe Flash Player。</h4>
                        <p>
                            <a href="http://www.adobe.com/go/getflashplayer"><img
                                    src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif"
                                    alt="获取 Adobe Flash Player" width="112" height="33" />
                            </a>
                        </p>
                    </div>
                    <!--[if !IE]>-->
                </object>
                <!--<![endif]-->
            </object>
        </td>
        <td width="331" align="right" valign="top">
            <table width="350" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="64" height="4"></td>
                    <td width="25" height="5"></td>
                    <td width="120" height="4"></td>
                    <td width="25" height="4"></td>
                    <td width="40" height="4"></td>
                    <td width="25" height="4"></td>
                    <td width="50" height="4"></td>
                </tr>
                <tr>
                    <td align="center"></td>
                    <td align="left"></td>
                    <td align="right">
                        <a><b></b><font color="red">欢迎您，<s:property value="#session.SYS_STUDENT.name"/>&nbsp;</font></a>
                    </td>
                    <td align="center"><img src="${ctx}/images/home/help.png" width="12" height="17"  /></td>
                    <td align="left"><a href="javascript:void(0);">帮助</a></td>
                    <td align="center"><img src="${ctx}/images/home/exit.png" width="14" height="14"   /></td>
                    <td align="left" valign="middle" ><a href="${ctx }/system/login_logout.action">退出</a></td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<!-- }头部 -->
<!-- 导航{ -->
<div class="menu">
    <ul class="clearfix">
        <li class="hover"><a href="${ctx }/system/student_listUI.action">个人主页</a></li>
        <li><a href="${ctx }/system/student/student_ruleUI.action">规章制度</a></li>
          <li><a href="${ctx }/drug/drug_useUI.action">化学品使用</a> </li>
          <li><a href="${ctx }/">实验室预约</a> </li>
        <li><a href="${ctx }/yhgl/yhgl_listUI.action">用户管理</a></li> 
         <li><a href="${ctx }/role/role_listUI.action">角色管理</a></li> 
          <li><a href="${ctx }/drug/drug_listUI.action">化学品管理</a></li>   
        <li><a href="javascript:void(0);">教务通知</a></li>
    </ul>
</div>
<!-- }导航 -->
<!-- 左{ -->
<div class="content">
    <div class="left">
        <!-- 个人资料{ -->
        <div class="left_grzx1">
            <div class="left_grzxbt">
                <h1>个人资料</h1>
            </div>
            <table width="98%" border="0" align="center">
                <tr>
                    <td width="76" height="100" align="center" valign="middle">
                        <div class="left-tx">
                            <s:if test="%{#session.SYS_STUDENT.headImg != null && #session.SYS_STUDENT.headImg != ''}">
								<img src="${ctx}/upload/<s:property value='#session.SYS_STUDENT.headImg'/>" width="70" height="70" />
							</s:if><s:else>
								<img src="${ctx}/images/home/gs09.png" width="70" height="70" />
							</s:else>
                        </div>
                    </td>
                    <td width="5%"><img src="${ctx}/images/home/gs10.png" width="4" height="59" alt="" /></td>
                    <td width="60%"><table width="95%" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td colspan="2" style=" font-weight:bold; color:#3a7daa;"><s:property value="#session.SYS_STUDENT.name"/></td>
                        </tr>
                        <tr>
                            <td colspan="2">所属学院：<s:property value="#session.SYS_STUDENT.college"/></td>
                        </tr>
                    </table>
                    </td>
                </tr>
            </table>
        </div>
        <!-- }个人资料 -->
    </div>
<!-- }左 -->

    <!-- 右{ -->
    <div class="right">
        <div class="left_grzx1">
            <div class="left_grzxbt">
                <h1>试剂列表</h1>
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
                                
                            </tr>
                        </s:iterator>
                    </table>
                </div>
        </div>
    </div>
    <!-- }右-->
    <div class="clear"></div>

    <div class="layout_center">
        <div class="lc_grzx1">
            <div class="lc_grzxbt">
                <h1>我的预约</h1>
                <div style="float:right;padding-top:3px;padding-right:3px;">
                	<s:a action="home_complainAddUI" namespace="/sys" target="_blank">我要投诉</s:a>
                </div>
            </div>
            <table width="98%" border="0" align="center">
                <s:iterator value="complainList">
                <tr>
                    <td height="23">
	                   	<s:url var="viewComplainUrl" namespace="/sys" action="home_complainViewUI">
	                   	<s:param name="comp.compId">
	                   		<s:property value="compId"/>
	                   	</s:param>
	                    </s:url>
	                    <s:a href="%{#viewComplainUrl}" target="_blank">
	                    	<s:property value="compTitle"/>
	                    </s:a>
                    </td>
                    <td width="180px"><s:property value="#complainStateMap[state]"/></td>
                    <td width="180px"><s:property value="isNm?'匿名投诉':'非匿名投诉'"/></td>
                    <td width="180px"><s:date name="compTime" format="yyyy-MM-dd HH:mm"/></td>
                </tr>
                </s:iterator>
            </table>
        </div>

        <div class="lc_grzx1">
            <div class="lc_grzxbt">
                <h1>我的咨询</h1>
            </div>
            <table width="98%" border="0" align="center">
                <tr>
                    <td></td>
                    <td width="150px"></td>
                    <td width="150px"></td>
                </tr>
            </table>
        </div>
    </div>
</div>
<!-- 尾部{ -->
<div class="foot">版权所有©中国计量大学 2018</div>
<!-- }尾部 -->
</body>
</html>