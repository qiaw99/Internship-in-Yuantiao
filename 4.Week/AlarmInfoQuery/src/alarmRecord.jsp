<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://com.yuantiao.webplatform.ui/taglib/pf"
	prefix="pf"%>

<%@page import="java.util.Date"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.*"%>
<%@page import="java.sql.*"%>

<link href="../sysConf/css/style.css" rel="stylesheet" type="text/css">

<style>
.search_button {
	padding-right: 20px;
}

.layer1 {
	display: flex;
	/* flex-direction: column; */
	padding-bottom: 10px;
}

.layer2 {
	display: flex;
	/* flex-direction: column; */
}
</style>

<pf:body>

	<%-- <%
		long current = System.currentTimeMillis();
		long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String defaultTime = df.format(new java.util.Date());
		String now = df.format(new java.sql.TimeStamp(current));
	%> --%>

	<pf:box addClass="card-box">
		<pf:form id="ConfOperationForm">
			<pf:support name="search" style="background:transparent">
				<div class="layer1">
					<div class="search_content">
						<pf:textBox id="userName" name="userName" labelField="true"
							label="路段名称" />
					</div>

					<div class="startTime">
						<pf:datePicker id="startTime" name="startTime" showTime="true"
							format="yyyy-MM-dd HH:mm" width="300" label="开始时间"
							value="${startTime}" />
					</div>

					<div class="endTime">
						<pf:datePicker id="endTime" name="endTime" showTime="true"
							format="yyyy-MM-dd HH:mm" width="300" label="结束时间"
							value="new Date()" />
					</div>
				</div>

				<div class="layer2">
					<pf:comboBox id="callType" name="callType"
						style="width:300; text-align:right;" label="报警类型"
						allowInput="true"
						data="[{'name':'拥堵报警','value':'yongdu'},{'name':'位置报警','value':'weizhi'},
								{'name':'区域报警','value':'quyu'},{'name':'预测报警','value':'yuce'},
								{'name':'设备报警','value':'shebei'},{'name':'全部','value':'allCall'}]"
						value="allCall" textField="name" valueField="value" />

					<div id="teamType">
						<pf:comboBox id="teamType" name="teamType"
							style="width:300; text-align:right;" label="所属部门"
							allowInput="true"
							data="[{'name':'芙蓉大队','value':'furong'},{'name':'开福大队','value':'kaifu'},
									{'name':'天心大队','value':'tianxin'},{'name':'雨花大队','value':'yuhua'},
									{'name':'岳麓大队','value':'yuelu'},{'name':'全部','value':'all'}]"
							value="all" textField="name" valueField="value" />
					</div>
					<div class="layer2" style="flex: 1; justify-content: flex-end;">
						<div class="search_button" style="width: 60px;">
							<pf:button iconCls="fa-search" text="查询" id="search"
								name="search" onclick="search" />
						</div>

						<div class="save_button" style="width: 60px;">
							<pf:button visible="true" id="exportDeviceResult" name="export"
								text="导出" onclick="exportResult" style="text-align:right;" />
						</div>
					</div>
				</div>
			</pf:support>
		</pf:form>
	</pf:box>
	<pf:support name="fit">
		<pf:dataGrid id="Conf_Operation_Grid" pageSize="20"
			allowCellEdit="true" allowAlternating="false" allowCellSelect="true"
			onload="onLoad" url="../alarmCall/query" name="Conf_Operation_Grid"
			idField="appId" initLoad="true" multiSelect="true"
			style="width:100%;height:100%;">
			<pf:column text="序号" type="indexcolumn"/>
			<pf:column text="报警时间" field="callTime" />
			<pf:column text="所属部门" field="department" />
			<pf:column text="地点" field="location" />
			<pf:column text="报警类型" field="callType" />
		</pf:dataGrid>
		
		<form id="excelForm"  action="../alarmCall/excelMyExport" method="post" target="excelIFrame">
    		<input hidden="true" id="userName1" name="userName"/>
	   		<input hidden="true" id="startTime1" name="startTime"/>
	   		<input hidden="true" id="endTime1" name="endTime"/>
	   		<input hidden="true" id="callType1" name="callType"/>
	   		<input hidden="true" id="teamType1" name="teamType"/>
    	</form>  

	</pf:support>
	<pf:script>

function exportResult(e){
	var data = ConfOperationForm.getData();
	console.log(data);
	
	document.getElementById("userName1").value = data.userName;
	document.getElementById("startTime1").value = data.startTime;
	document.getElementById("endTime1").value = data.endTime;
	document.getElementById("callType1").value = data.callType;
	document.getElementById("teamType1").value = data.teamType;

	var excelForm = document.getElementById("excelForm");
	excelForm.submit();
}


function onLoad(e) {
	var Conf_Operation_Grid = e.sender;
	var count=e.data.length;
	var marges=[];
	for(var i=0; i < (count); i += 3){
		var marge = { rowIndex: i, columnIndex: 1, rowSpan: 1, colSpan: 1 };
		marges.push(marge);
	}
	Conf_Operation_Grid.mergeCells(marges);
} 

function search(){
	var data = ConfOperationForm.getData();
	Conf_Operation_Grid.load({
		filter:JSON.stringify(data)
	});
}

</pf:script>
</pf:body>