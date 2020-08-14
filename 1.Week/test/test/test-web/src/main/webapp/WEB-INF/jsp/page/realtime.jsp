<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://com.yuantiao.webplatform.ui/taglib/pf"
	prefix="pf"%>
<%@ taglib uri="http://com.yuantiao.webplatform.gis/taglib/gis"
	prefix="gis"%>

<pf:head title="${title}">
	<gis:head></gis:head>
</pf:head>

<style>
	#gis-pop-stand2-search-combox input{
		height: 38px;
		line-height:38px;
	}
</style>
<pf:body>
	<div style="width: 100%; height: 100%; overflow: auto;">
		<div style="width: 100%; height: 100%;">
			<div class=""
				style="position: relative; float: left; overflow: hidden; width: 1920px; height: 1080px; display: block; background: transparent;">
				<div class=""
					style="position: relative; float: left; width: 100%; height: 100%; overflow-y: hidden;">
					<div class=""
						style="position: relative; float: left; overflow: hidden auto; width: 200px; height: 100%; display: block;">
						<pf:dataGrid id="datagrid" url="/dataengine/api/getGridData?interfaceCode=road" style="width: 100%; height: 100%" initLoad="true" pageSize="50" onrowclick="datagridClick">
							<pf:column field="road_code">路段编码</pf:column>
							<pf:column field="road_name">路段名称</pf:column>
						</pf:dataGrid>
					</div>
					<div class=""
						style="position: relative; float: left; overflow: hidden auto; width: 1720px; height: 100%; display: block;">
						
						<!-- put the map here -->
						<gis:map id="map" mapCode="barrett" onload="mapload" />
						<gis:pop skin="stand2" id="pop">
						</gis:pop>

						<div class=""
							style="position: absolute; z-index: 99; top: 759px; left: 1025px; width: 200px; height: 100px;">
							<div class="yt-dataView-content"
								style="position: relative; width: 100%; height: 100%; overflow: hidden;">
								D</div>
						</div>
						<div class=""
							style="position: absolute; z-index: 99; top: 19px; left: 986px; width: 200px; height: 100px;">
							<div class="yt-dataView-content"
								style="position: relative; width: 100%; height: 100%; overflow: hidden;">
								E</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<gis:script>
		function mapload(){
			YTMapUtil.showLayer("crossLayer",null);
			YTMapUtil.showLayer("areaLayer",null);	
			YTMapUtil.showLayer("roadLayer",null);	
		}
		YTMapUtil.setCustomPopwinShow(function(code,pop,clickData,popModule){
				$(".gis-pop-stand2-detail").css("display","block");
				pf.get("gis-pop-stand2-detail-panel").setUrl(pop.url);
				pf.get("gis-pop-stand2-search-combox").setShowClose(true)
		})
	</gis:script>

	<pf:script>
	function datagridClick(e){
		YTMapUtil.triggerEvent("click","roadLayer","ROAD_CODE",e.rocord.road_code);
		YTMapUtil.setCenter(e.record.lng, e.record.lat);
	}
	
	var combox = pf.get("gis-pop-stand2-search-combox");
	combox.load("/dataengine/api/getGridData?interfaceCode=road");
	combox.setValueField("road_code");
	combox.setTextField("road_name");
	combox.on("itemClick", function(e){
		YTMapUtil.triggerEvent("click","roadLayer","ROAD_CODE",e.item.road_code);
		YTMapUtil.setCenter(e.item.lng, e.item.lat);
	});
	</pf:script>
</pf:body>

