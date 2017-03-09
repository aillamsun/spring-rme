
      
      $(function(){
    	  
    
      
    	  var WS_MSG_CLOSE=0;//小车关闭信息
    	  var WS_MSG_ON=1;//小车在线信息
    	  /**
    	   * 方向列表
    	   */
    	  var directionList=new Array();
    	  directionList[0]="忽略";
    	  directionList[1]="停止";
    	  directionList[2]="直行";
    	  directionList[3]="左";
    	  directionList[4]="右";
    	  directionList[5]="前行";
    	  directionList[6]="倒退";
    	  
    	  var carStateList=new Array();
    	  carStateList[0]="断电";
    	  carStateList[1]="任务";
    	  carStateList[2]="空闲";
    	  carStateList[3]="充电";
    	  carStateList[4]="故障";
 
    	  
    	  /*public static final int CAR_STATE_CLOSE=0;//小车断电
    		public static final int CAR_STATE_TASK=1;//任务状态
    		public static final int CAR_STATE_FREE=2;//空闲状态
    		public static final int CAR_STATE_CHARGE=3;//充电状态
    		public static final int CAR_STATE_BAD=4;//故障状态
*/    	
    	 
    	  /*************************************************************************
    	   * websocket操作
    	   */
    	  var websocket = null;// websocket对象

          // 判断当前浏览器是否支持WebSocket
          if('WebSocket' in window){
              websocket = new WebSocket("ws://localhost:8090/senyuan/updateMapServer");
          }
          else{
              alert('Not support websocket')
          }
           
          // 连接发生错误的回调方法
          websocket.onerror = function(){
              alert("error");
          };
           
          // 连接成功建立的回调方法
          websocket.onopen = function(event){
              alert("已经连接到服务器");
          }
           
           // 连接关闭回调函数
           websocket.onclose=function(){
                
               alert("连接已经关闭");
           }
           
           // 接收到消息的回调方法
           websocket.onmessage=function(){
        	   
        	   doByMessageType();
           }
      
           
            // 关闭连接
          function closeWebSocket(){
              websocket.close();
          }
          
          
          
          // 判断消息类型,并根据类型执行某些方法
          function  doByMessageType(){
          
        	  var data=event.data;
          	 eval("var result="+data);
          	 var carNum=result.id;
          	 if(result.msg_type==WS_MSG_CLOSE)//如果关闭消息
          		 {
          		// alert(carNum);
          		    $("#car"+carNum).find(".workFlag").text("关闭");
          		 }
          	 else if(result.msg_type==WS_MSG_ON)//如果在线消息
          		 {
	        	 
	        	  carStateMap[carNum]=result;//把小车当前状态保存起来
        		  carAlarmNode(result)
          		 }
        	  
          }
          
          
        
          
    	  
          /********************************************************
           * 以下为对地图接点操作
           */
          
    	  
			var xiaoche_nodetype = 1;
			var zhandian_nodetype = 2;
			var chakou_nodetype = 3;
			var kongzhi_nodetype = 4;
			var wandian_nodetype = 5;
			var shanshuo_nodetype = 6;
			
			var nodeImg=new Array();
			nodeImg[xiaoche_nodetype]="xiaoche.png";
			nodeImg[zhandian_nodetype]="zhandian.png";
			nodeImg[chakou_nodetype]="chakou.png";
			nodeImg[kongzhi_nodetype]="kongzhi.png";
			nodeImg[wandian_nodetype]="wandian.png";
			nodeImg[shanshuo_nodetype]="shanshuo.png";

			var newNode = new Array();//新节点,不包括小车
			var xiaocheNodes={};//小车节点对象，数据库不存
			var oldNode = new Array();//老节点

			var linkFlag = false;//是否是连线状态
			var onnToOnd = {};//node的num所对应node节点对象数组的下标，用于link生成
			var newLink = new Array();//新连线
			var oldLink = new Array();//老连线
			
			var xiaocheTimer={};//小车闪烁定时器
			

			var selectNode;//选择的节点
			var selectLink;//选择的连线va

			//从数据库中查出来的数据
			/*  	oldNodeData[0] = {
					num : "node1",
					x : 111,
					y : 133,
					img : "house1.png",
					detail : "1号站点",
					nodetype : 2,
				
				};
				oldNodeData[1] = {
					num : "node2",
					x : 333,
					y : 500,
					img : "house1.png",
					detail : "2号站点",
					nodetype : 2,
					
				};  */
			// oldNodeData[2]={num:3,x:431,y:211,img:"house1.png",detail:"3号站点"};
			//  oldNodeData[3]={num:4,x:298,y:365,img:"house1.png",detail:"4号站点"};
			// oldNodeData[4]={num:5,x:123,y:34,img:"house1.png",detail:"5号站点"};
			//  oldNodeData[5]={num:6,x:156,y:224,img:"house1.png",detail:"6号站点"};
			//从后台查出来的数据，对应num
			 /* 	oldLinkData[0] = {
					from : "node1",
					to : "node2",
					linkcolor : "22,124,255",
					linkname : "好久"
				};  */

			var linkFromNode = "";//连线时鼠标点击起点
			var linkEndNode = "";//连线时鼠标点击终点

			$("canvas").attr("width", $("#map_show").width());
			$("canvas").attr("height",$("#map_show").height());
			var canvas = document.getElementById('canvas');
			var stage = new JTopo.Stage(canvas);
			//显示工具栏
			//                                showJTopoToobar(stage);
			//场景对象
			var scene = new JTopo.Scene();
			//创建node节点
			function node(x, y, img, name, nodetype,nodenum) {//nodetype,节点类型，小车1，站点2，岔口3，控制4
				var node = new JTopo.Node(name);
				node.setImage('resource/senyuan/img/'+ img, true);
				node.setLocation(x, y);// 设置节点坐标         
				node.shadow = "true";
				node.font = "12px Consolas";
				node.fontColor = "black";
				node.nodeNum = nodenum;
				node.nodeType = nodetype;
				if(nodetype==xiaoche_nodetype)
					{
						node.font = "14px Consolas";
						node.fontColor = "green";
						node.dragable=false
					}
				scene.add(node);// 放入到场景中
				return node;
			}
			//创建link
			function linkNode(nodeA, nodeZ, color, text) {
				var link = new JTopo.Link(nodeA, nodeZ,text);//设置相连的节点
				link.lineWidth = 5;
				link.strokeColor = color;//连线的颜色
				link.fontColor = "0,0,0";
				link.textOffsetY = 20; // 文本偏移量（向下3个像素）
				//alert(nodeA.x+" "+nodeZ.y+" "+color+" "+text)
				scene.add(link);
				return link;
			}

			for (var i = 0; i < oldNodeData.length; i++) {
				oldNode[i] = node(oldNodeData[i].x,
						oldNodeData[i].y,
						nodeImg[oldNodeData[i].nodetype],
						oldNodeData[i].detail,
						oldNodeData[i].nodetype,
						oldNodeData[i].num
						);
				var ond = oldNodeData[i].num
				onnToOnd[ond] = i;//
			}
			for (var i = 0; i < oldLinkData.length; i++) {
				var fromIndex = onnToOnd[oldLinkData[i].from];
				var toIndex = onnToOnd[oldLinkData[i].to];
				oldLink[i] = linkNode(oldNode[fromIndex],
						oldNode[toIndex],
						oldLinkData[i].linkcolor,
						oldLinkData[i].linkname);
			}

			// var n1 = node(349,41,"house.png","1号楼");
			// var n2 = node(549,41,"house.png","2号楼");
			// var n3 = node(749,41,"house.png","3号楼");
			// var n4 = node(949,41,"house.png","4号楼");
			//  var n5 = node(349,241,"house.png","5号楼");
			//  var n6 = node(749,241,"house.png","6号楼");
			//  var n7 = node(949,241,"house.png","7号楼");
			//  var n8 = node(349,441,"house.png","8号楼");
			//  var n9 = node(549,441,"house.png","9号楼");
			//  var n10 = node(749,441,"house.png","10号楼");
			//  var n11 = node(949,441,"house.png","11号楼");
			//                n11.alarm = "进水和回水管道";
			//  var nh = node(549,241,"heat.png","换热站");

			// linkNode(n1, n2,"244,164,96");
			// linkNode(n2, n3,"244,164,96");
			// linkNode(n3, n4,"244,164,96");
			//  linkNode(nh, n2,"244,164,96","进水回水管道线");
			//  linkNode(nh, n5,"255,99,71");
			//  linkNode(nh, n6,"162,205,90");
			//  linkNode(nh, n9,"22,124,255","进(回)水温度60℃/45℃，流量120K/Wh");
			//  linkNode(n6, n7,"162,205,90");
			//  linkNode(n8, n9,"22,124,255");
			//  linkNode(n9, n10,"22,124,255");
			// linkNode(n10, n11,"22,124,255");
			// alert(oldNode[0].text)
			stage.add(scene);
			for (var i = 0; i < oldLink.length; i++) {

				listenLink(oldLink[i]);
			}

			function listenLink(oldLinkObj)//监听新连线
			{
				oldLinkObj.mousedown(function(event) {
					selectNode = null
					//selectLink=null
					//alert(i)
					selectLink = this;
				})
			}

			for (var i = 0; i < oldNode.length; i++) {

				listenNode(oldNode[i])
			}

			function listenNode(oldNodeObj)//监听新节点
			{
				oldNodeObj.mousedown(function(event) {
					selectLink = null
					selectNode = this;
					/*if(this.nodeType==xiaoche_nodetype)
						{
						  
						   showSelectCarState(selectNode);
						}*/
					$("#selectNodeNum").val(this.nodeNum);
					if (event.button == 0 && linkFlag) {//如果按下左键且连线标志为true
						if (linkFromNode == "") { //alert("1111");
							linkFromNode = oldNodeObj
						} else if (linkEndNode == "") {
							//alert("2222");
							linkEndNode = this
							var newLinkObj = linkNode(linkFromNode,linkEndNode,"22,124,255","");
							listenLink(newLinkObj)
							clearSelectLinkNode();
							stage.add(scene);
						}
						//this.text = '按下左键';    
					}
				})
			}
			
			/**
			 * 显示小车当前状态
			 */
		/*	function showSelectCarState(carNode)
			{
				var carName=carNode.text;
				var stateJson=carStateMap[carName]
				$("#stateCarId").text(stateJson.id);
				$("#stateDes").text(stateJson.station_des);
				$("#stateNow").text(stateJson.station_now);
				$("#stateNext").text(stateJson.station_next);
				$("#stateDirection").text(directionList[stateJson.direction]);
				
			}*/

			//双击修改节点名称
			var textfield = $("#jtopo_textfield");
			scene.dbclick(function(event) {
				if (event.target == null)
					return;
				var e = event.target;
				textfield.css({
					top : event.pageY,
					left : event.pageX - e.width / 2
				}).show().attr('value', e.text).focus()
						.select();
				e.text = "";
				textfield[0].JTopoNode = e;
			});

			$("#jtopo_textfield").blur(function() {textfield[0].JTopoNode.text = textfield.hide().val();
							});

			$("#add").click(function() {//添加新节点
				                //alert("ggggggggggggg");
								var now_time = new Date().getTime();
								//var node_num = "node"+ now_time;//节点编号
								var newNode_index = newNode.length
								var nodetype = $("#nodetypeselect").val();
								var node_num=$("#nodeNum").val();
								var detail = $("#detail").val();
							//	alert(nodeImg[nodetype])
								newNode[newNode_index] = node(
											50,
											50,
											nodeImg[nodetype],
											detail,
											nodetype,
											node_num);
								
								listenNode(newNode[newNode_index])
							})

			$("#save").click(function() {//保存按钮
								var allNode = scene.getDisplayedNodes();
								var allLink = scene.getDisplayedElements();
								var allNodeJson = [];
								var allLinkJson = [];
								for (var i = 0; i < allNode.length; i++) {
									if(allNode[i].nodeType==xiaoche_nodetype)
										continue;
									var px = allNode[i].x;
									var py = allNode[i].y;
									var node_name = allNode[i].text;
									var node_num = allNode[i].nodeNum;
									var node_type = allNode[i].nodeType;
									var nodeJson = {
										"px" : px,
										"py" : py,
										"node_name" : node_name,
										"node_num" : node_num,
										"node_type" : node_type,
									}
									allNodeJson.push(nodeJson);

								}

								for (var i = 0; i < allLink.length; i++) {
									if (typeof (allLink[i].nodeA) != "undefined") {
										var from_num = allLink[i].nodeA.nodeNum;
										var to_num = allLink[i].nodeZ.nodeNum;
										var link_name = allLink[i].text;
										var link_color = "";
										var linkJson = {
											"from_num" : from_num,
											"to_num" : to_num,
											"link_name" : link_name,
											"link_color" : link_color
										};
										allLinkJson.push(linkJson);
									}

								}

								var allNodeStr = JSON.stringify(allNodeJson);
								var allLinkStr = JSON.stringify(allLinkJson);
								sendUpdate(allLinkStr,allNodeStr)

							})
			$("#tolink").click(function() {
				if (linkFlag) {
					linkFlag = false
					clearSelectLinkNode();
				} else
					linkFlag = true
				$("#tolink").toggleClass("active");

			})

			function sendUpdate(allLinkStr, allNodeStr) {

				$.ajax({
							type : "POST",
							//dataType:"json",//指定返回的数据类型，自动解析，当不匹配时不会执行succes:function(data)，json数据
							url : "senyuan/linkNodeInfo/updateLinkNode.shtm",
							data : {
								"linkJson" : allLinkStr,
								"nodeJson" : allNodeStr
							},
							success : function(data) {
								if (data == "success")
									alert("保存成功")
								else
									alert("保存失败");
							}
						});
			}

			/**
			 * 修改当前节点的在本类型的编号
			 */
			$("#updateNodeNum").click(function(){
				
				var value=$("#selectNodeNum").val();
				selectNode.nodeNum=value;
				alert("修改成功");
				
			})
			
			
			/**
			 * 清空重做
			 */
			$("#clearAll").click(function(){
				alert("清空");
				scene.clear()
				
			})
			$("#remove").click(function() {//删除元素
				if (selectLink != null)
					scene.remove(selectLink);
				else if (selectNode != null)
					scene.remove(selectNode);
				clearSelectLinkNode();

			})
			function clearSelectLinkNode() {//清空选择连线存储点
				linkFromNode = ""
				linkEndNode = ""
			}
			
		
			
		/**
		 * 当小车换位置时重新设置小车闪烁
		 * car_name  小车编号 即界面上显示的小车名字
		 * node_name 节点名字即编号
		 * node_type  节点类型
		 */
			
			function carAlarmNode(carStateJson)
			{
				 updateCarInfo(carStateJson);//更新小车信息
				  var result=carStateJson;
				  var car_name=result.id;
	    	      //var direction=result.direction;
	        	 // var head_direction=result.head_direction;
	        	 // var station_des=result.station_des;
	        	  var node_next=result.station_next;
	        	  var node_now=result.station_now;
	        	 // var detail=result.detail;
	        	  //alert(JSON.stringify(carStateJson))
				var allNode=scene.getDisplayedNodes();
				var siteNode="";
				
				if(node_next==node_now||node_next==null||node_next=="")//如果站点相同
				{
					for(var i=0;i<allNode.length;i++)//闪烁
					{
					  var thisNode=allNode[i];
					   if(thisNode.nodeNum==node_now)
					   {   
						   siteNode=thisNode;
						   
							
			            }
					}
				}
				else
					{
					   var ss=node_now+node_next;
		    		   var ss2=node_next+node_now;
						for(var i=0;i<allNode.length;i++)//闪烁
						{
							 var thisNode=allNode[i];
							//alert(thisNode.text);
						  var thisNode=allNode[i];
						  if(thisNode.nodeNum==ss||thisNode.nodeNum==ss2) 
						  {   
							   siteNode=thisNode;
							   
								
				            }
						}
					
					}
			
					removeBeforeCarNode(car_name);
					addNewCarNode(car_name,siteNode);
			
			}
		
		
		/**
		 * 添加小车节点
		 */
		function addNewCarNode(car_name,siteNode)
		{
			var now_time = new Date().getTime();
			var node_num = "node"+ now_time;//节点编号
			var x=siteNode.x;
			var y=siteNode.y;
			xiaocheNodes[node_num] = node(//小车节点数组
					x,
					y,
					nodeImg[xiaoche_nodetype],
					car_name,
					xiaoche_nodetype,
					node_num);
			
		//	listenNode(xiaocheNodes[node_num]);//监听小车
			if(carStateMap[car_name].station_des!=carStateMap[car_name].station_now)
				{
					xiaocheTimer[node_num]=setInterval(function(){//小车定时器数组
		                if(xiaocheNodes[node_num].alarm == '小车'+car_name){
		                	xiaocheNodes[node_num].alarm = null;
		                }else{
		                	xiaocheNodes[node_num].alarm = '小车'+car_name
		                }
		            }, 600);
				}
		return xiaocheNodes[node_num];
		//listenNode(newNode[newNode_index])
			
		}
		
		/**
		 * 定时刷新session
		 */
		setInterval(function(){//小车定时器数组
			refresshSession();
        }, 60000);
		function refresshSession()
		{
			$.ajax({
				type : "POST",
				//dataType:"json",//指定返回的数据类型，自动解析，当不匹配时不会执行succes:function(data)，json数据
				url : "senyuan/linkNodeInfo/refresshSession.shtm",
				data : {

				},
				success : function(data) {
					
				}
			});
		}
		/**
		 * 删除小车节点
		 */
			function removeBeforeCarNode(car_name)
			{
				//removeCarInfo(car_name);
				var allNode=scene.getDisplayedNodes();
				for(var i=0;i<allNode.length;i++)//闪烁
				{
					var thisNode=allNode[i];
					///alert(thisNode.nodeNum)
					// if(thisNode.nodeNum==car_name&&thisNode.nodeType==xiaoche_nodetype)
					if(thisNode.text==car_name&&thisNode.nodeType==xiaoche_nodetype)
						 {
						
						    var node_num=thisNode.nodeNum;
						    delete xiaocheNodes[node_num];//从数组中删除小车
						    clearInterval(xiaocheTimer[node_num]);//清除小车闪烁定时器
						    delete xiaocheTimer[node_num];//删除数组中定时器
						 	scene.remove(thisNode);
						 	break;
						 }
				}
				
				
			}
			
	/**
	 * 更新或添加小车状态
	 */
	   function updateCarInfo(cartateJson)
	   {
		   var cartate=cartateJson;
		    var carId="car"+cartate.id;
		    var direction=cartate.direction;
		    var head_direction=cartate.head_direction;
     	    var station_des=cartate.station_des;
     	    var station_next=cartate.station_next;
     	    var station_now=cartate.station_now;
     	    var work_state=carStateList[cartate.work_flag];
     	    var  thisCarDom=$("#"+carId);
     	 //  alert(thisCarDom.html()==null);
     	    if(thisCarDom.html() ==null )
     	    {
     	    	//alert("ddd");
     	    	var html="<tr id="+carId+"><td class='stateCarId'>"+cartate.id+"</td><td class='stateDes'>"+station_des+"</td>" +
		    		"<td class='stateNow'>"+station_now+"</td><td class='stateNext'>"+station_next+"</td><td class='headDirection'>"+directionList[head_direction]+"</td>" +
		    				"<td class='workFlag'>"+work_state+"</td><td ><input type='button' class='detail' onclick='showCarDetail("+cartate.id+")' value='详细'/></td></tr>";
		    	$("#carStateTable").append(html);
		    //	alert($("#carStateTable").html())
     	    }
     	    else
     	    	{
     	    	//alert("ccc");
     	    		thisCarDom.find(".stateDes").text(station_des);
     	    		thisCarDom.find(".stateNow").text(station_now);
     	    		thisCarDom.find(".stateNext").text(station_next);
     	    		thisCarDom.find(".workFlag").text(work_state);
     	    		thisCarDom.find(".headDirection").text(directionList[head_direction]);
     	    	}
	   }
	   
	
	   /**
	    * 删除小车信息dam
	    */
	   function removeCarInfo(carid)
	   {
		   $("#car"+carid).remove();
	   }
			
			/**
			 * 遍历生成小车信息
			 */
			  for(var v in carStateMap)
	    	  {
				  //alert(v)
	    	      var result=carStateMap[v]
	        	
	        	  carAlarmNode(result)
	    	  }
			
		});
      
      /**
	    * 显示小车详细信息
	    */
	   function showCarDetail(carid){
		   
		   
		   alert(carStateMap[carid].detail);
	   }