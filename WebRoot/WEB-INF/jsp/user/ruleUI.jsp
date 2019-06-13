<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    application.setAttribute("basePath",basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>实验室规章制度须知</title>
   
</head>
<div class="tableH2">实验室规章制度须知</div></br>
<body>

<br style="font-variant-caps: normal;">实验室管理规章制度有以下： </br>
1、非实验室工作人员进入实验室未经许可，谢绝入内。 </br>
2、进出实验室需要严格登记。如有不符合实验室工作和生物安全要求的，不予进入 。 </tr>
3、使用人员需参加专门的实验室使用规范培训并通过考核后，方可获准进入进行实验。严禁未经许可擅自进入实验室或使用相关设备。  </br>
4、实验人员应爱护实验室各类仪器，按照规则使用并保持设备清洁。实验中的昂贵设备，未经许可不得擅自开关。精密仪器需经专门培训方能操作未经许可不得改变设备仪器的预设参数。设备仪器出现故障或发生事故，应及时向实验室负责人报告，安排专业人员进行检修。   </br>
5、工作时间不得在实验室内聊天、会客、吃东西、带小孩。 </br> 
6、 严格遵守各种仪器的操作规程和等级制度。发现故障者，有义务立即向实验室管理人员报告，以便及时维修。 </br> 
7、不随便带外来人员到实验室，等不得私自用实验室仪器设备和药品为外人做实验。  </br>
8、实验室钥匙持有人对实验室的安全负责。  </br>
9、各种财产包括仪器、设备工具等严禁带出实验室。如有特殊需要（诸如去别的公司作分析），应取得周总同意后方可带出，并负责带回。各种设施一律不借给私用。实验室工作人员必须尽职尽责，保证实验室的正常运转。 </br> 
10、人存放于冰箱内的培养液要注明姓名、配置日期，不得随便使用他人的培养液和翻看其他实验者的细胞，以免交叉污染。 </br>

</body>
</html>