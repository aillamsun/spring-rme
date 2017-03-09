var connectNum=0;//初始化重连次数
var RE_CONNECT_TIME=5000;//重连时间间隔
var RE_CONNECT_NUM=3;//设置重连次数
var finishState=0;//完成状态

/**
 * 重复连接
 */
function reConnect(){
	 if(connectNum==0)
	        setMessageInnerHTML("您的网络不稳定正在努力连接中.....");
	        messageGoDown();
	 		  connectNum++;//每次连接，次数加1
		     initWebSocket(); 
}

//初始化websocket
initWebSocket();

//websocket回调方法
function initWebSocket()
{

	//判断当前浏览器是否支持WebSocket
    if('WebSocket' in window){
       websocket = new WebSocket(connectUrl);
    }
    else{
        alert('您的浏览器版本过低')
    }
	//连接发生错误的回调方法
    websocket.onerror = function(){
    	 isOpening=0;
    	 setMessageInnerHTML("您的网络不稳定正在努力连接中.....");
        if(connectNum>=RE_CONNECT_NUM)//如果连接次数大于3
      	  return ;
        else{//否则10秒后发起下一次连接
        	
        	 setTimeout("reConnect()",RE_CONNECT_TIME);
        }
        	
        //alert("错误"+websocket.readyState);
    };
     
    //连接成功建立的回调方法
    websocket.onopen = function(event){
  	    connectNum=0;//连接上后，把连接次数置0
        listenPageClose();//监听页面关闭
        isOpening=1;//在连接状态
        cleanMessageInnerHTML();
    }
     
     //连接关闭回调函数
     websocket.onclose=function(){//当自己断网时，并不会激发onerror方法，而是直接onclose
    		  isOpening=0;
          //alert("onclose");
          if(finishState==1)//如果是完成状态 关闭
        	  {
        	  	hasComplete();
        	  }
           if(finishState==2)//节假日及休息时间主动关闭
        	   {
        	    var msg="工作日作息时间 早上9点-12点，下午1点-5点，周末及节假日客服休息，请在工作时间联系客服，见谅！";
        	    showReceiveMessage(msg,"",0,"");
        	   }
          else if(connectNum>=RE_CONNECT_NUM)//如果重连3次
          	{
          	 
          	   setMessageInnerHTML("由于您的网络不稳定，连接失败，请检查网络配置。<a href='"+reChatUrl+"' >再次咨询</a>");
               messageGoDown();
          	   return ;
          	}
          else if(isOpening==1) 
        	  {
        	    setTimeout("reConnect()",RE_CONNECT_TIME);
        	  }
        	  
          
          //alert("关闭"+websocket.readyState);
     }
    
    
    //接收到消息的回调方法
    websocket.onmessage = function(event){
    
    	eval("var result="+event.data);
    	 //alert(result.type);
					switch(result.type)
					{
					   case 1://上线消息，当玩家上线且有可分分配，启动定时器
					   cleanMessageInnerHTML();
					   cur_ser_id=result.id;
      			       cur_ser_name=result.userName;
					   msg_1(result);				  
					   break;
					   
					   case 2://下线消息
					    msg_2(result);
					    break;
					   
					   case 3://真正消息
					   cur_ser_id=result.id;
      			       cur_ser_name=result.userName;
					    msg_3(result);
					   break;
					   
					   case 4://客服正忙时，机器人聊天
						 cleanMessageInnerHTML();
						 cur_ser_id=result.id;
	        			 cur_ser_name=result.userName;
					     msg_4(result);
					    break;
					    
					    case 5://已经打开聊天页面消息
					    msg_5(result);
					    break;
					    
					    case 6://服务器立即关闭连接消息
						  msg_6(result);
						  break;
					    case 7://服务器30s后关闭连接消息
							msg_7(result);
							break;
					    case 8://未读消息
						    msg_8(result);
						   break;
					    case 9://工作日消息
						    msg_9(result);
						   break;
					    case 10:
					    	msg_10(result);
					}
					  
					
			
    }
    


}
//关闭连接
function closeWebSocket(){
    websocket.close();
}
      function msg_1(result)//上线且能分配客服
      {
            
         $(function(){
					if(result.id!=undefined){
						var csmName=result.userName;
						var message=result.message;
						if(message.length==0)
							message="您好，有什么能够帮助您的";
						showReceiveMessage(message,result.imgUrl,0,csmName);
						serviceId=result.id;
					}
					showCurrentService(serviceId,result.userName)
					//$("#service").html("与客服"+result.userName+"聊天中");
	         })
       }
       
       
        function msg_2(result){//下线消息
       
       		$(function(){

						if(result.id!=undefined){
							setMessageInnerHTML("客服"+result.userName+"已经下线，正在为您转接其他客服。。。。。");
							//$("#message").append();
						}
		         })
       
       } 
       
       function msg_3(result){//接收真正的消息

	        $(function(){
						if(result.id!=undefined){
							var csmName=result.userName;
								//alert("*****"+result.imgUrl);
							showReceiveMessage(result.message,result.imgUrl,result.dataType,csmName);
						}
		         })
       
       }
       
       
       function msg_4(result){//客服繁忙消息
	        $(function(){
						if(result.message!=undefined){
							var html;
						   if(result.message!="")
							  html=result.message;
							 else
							    html="欢迎您咨询";
							showCurrentService(result.id,result.userName)
							showReceiveMessage(html,result.imgUrl,0,"");
						}
		         })
       }

      function msg_5(result){//已经打开聊天页面

						if(result.type!=undefined){
							var r="系统检测到您已经打开聊天页面，已经断开原来连接";
							alert(r)
								
						}

       }
      
      function msg_6(result){//服务器立即关闭连接消息
    	  finishState=1;
    	  closeWebSocket();

      }
      function msg_7(result){//服务器30s后关闭连接消息
    	  
    	  waitClose();

      }
	  function msg_8(result){//未读消息
		    	  
		  $(function(){
				if(result.id!=undefined){
					var csmName=result.userName;
					showReceiveMessage(result.message,result.imgUrl,result.dataType,csmName);
				}
            })
		
		}
	  
	  
	  function msg_9(result){//工作日消息
		  finishState=2;
		  closeWebSocket();
	  }
	  
	  
	  function msg_10(result)//通知公告消息。
	  {
		  if(result.message!=undefined&&result.message.length>0)
		  showReceiveMessage(result.message,"",0,"");
	  }
      
       
      //已经完成本次咨询
      function hasComplete(){
         setMessageInnerHTML("连接已关闭,再次咨询请点击<a href='"+reChatUrl+"' >再次咨询</a>");
         if(serviceId!=null)
         {
          /*   setMessageInnerHTML("请为客服打分:<form action=''  id='judge'>5分：<input type='radio' name='judge'> 4分：<input type='radio' name='judge'>"+
            "  3分：<input type='radio' name='judge'>2分：<input type='radio' name='judge'> 1分：<input type='radio' name='judge'> </form>"
            +" <input type='submit' value='提交'/>"); */
         }
         
         dontListenPageClose();
      }
       
   
      //将消息显示在网页上
      function setMessageInnerHTML(innerHTML){
    	  $(function(){
    		  $("#connect_state").css({"display":"block"});
    		  $("#connect_state").html(innerHTML);
    		  messageGoDown();
    		  
    		  
    	  })
     
      }
      
      //清除页面上的消息并隐藏
      function cleanMessageInnerHTML(){
    	  $(function(){
    		  clearInterval(checkState);//发送消息时，清空关闭定时器
        	  closeLeaveNum=CLOSE_LEAVE_TIME/1000;//重置倒计时
    		  $("#connect_state").css({"display":"none"});
    		  $("#connect_state").html("");
    		  messageGoDown();
    		  
    		  
    	  })
     
      }
       
     
      
      //超过多长时间无操作，关闭连接并提示
      function closeWebSocketByTimeOut(){
      		  setMessageInnerHTML("由于您长时间没有发送消息，连接已关闭");
      		  finishState=1;
      		  closeWebSocket();
      }
      /**
       * 发送文字消息
       */
      function send()
      {
    	  
      	
    	     var message = $('#send_msg_text').text();
		          //document.getElementById('send_msg_text').value="";
		    	  sendMessage(message, 0);
    		
      }
      /**
       * 发送各种消息
       * @param message
       * @param data_type  消息类型
       */
      function sendMessage(message,data_type){//发送消息
    	  
    	  clearInterval(checkState);//发送消息时，清空关闭定时器
    	  closeLeaveNum=CLOSE_LEAVE_TIME/1000;//重置倒计时
    	  cleanMessageInnerHTML();//清空设置状框
          message=$.trim(message);
          message=message.replace(/\r\n/g,"<BR>")  
          message=message.replace(/\n/g,"<BR>");  
          var msg_text=message.toLowerCase();
     	  var reg=/.*<script.*>.*/;
    	 if(message.length<=0)
    		 {
    		  // alert("请输入");
    		   return ;
    		 }
    	 else if(reg.test(msg_text))
    		 {
       	    	   alert("请不要输入非法字符");
       	    	   return ;
    		 }
    	 $("#send_msg_text").text("");
    	if(isOpening==1)
         {
    		//alert(isOpening);
    	//	$("#send_msg_text").text("");
          if(cur_win_type==1)//如果是在线聊天
		  {  
        	  showSendMessage(message,data_type);
        	  var serviceId=document.getElementById('service_id').value;
        	  var news="{jtype:'"+SEND_NEWS_MSG+"',to_id:'"+cur_ser_id+"',to_name:'"+cur_ser_name+"',message:'"+message+"',data_type:'"+data_type+"'}";//发送信息
		  }
          else if(cur_win_type==2)
        	  {
        	      hf_showSendMessage(message,data_type);
	        	  var news="{jtype:'"+SEND_NEWS_OUTLINE+"',to_id:'"+hf_ser_id+"',to_name:'"+hf_ser_name+"',message:'"+message+"',data_type:'"+data_type+"'}";//发送信息
        	  }
           websocket.send(news);
          lastChatTime=new Date().getTime();
         
         }
       else if(finishState==2)//如果不在工作时间
        	 {
    	      showSendMessage(message,data_type);
    	   	var msg="工作日作息时间 早上9点-12点，下午1点-5点，周末及节假日客服休息，请在工作时间联系客服，见谅！";
    	   	showReceiveMessage(msg,"",0,""); 
    	   	$("#send_msg_text").val("");
        	 
        	 }
       else//如果已经完成并关闭
             alert("您的连接已经关闭，如需咨询请点击再次咨询");
         // $("#message").append("我说："+message+"");
      }
      
      
      
      
      
      
      
      
      function closeWebPage(){//关闭页面的函数
				
			 if (navigator.userAgent.indexOf("MSIE") > 0) {
			  if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
			   window.opener = null;
			   window.close();
			  } else {
			   window.open('', '_top');
			   window.top.close();
			  }
			 }
			 else if (navigator.userAgent.indexOf("Firefox") > 0) {
			  window.location.href = 'about:blank ';
			 } else {
			  window.opener = null;
			  window.open('', '_self', '');
			  window.close();
			 }
			}
   
   
          //不监听页面关闭
           function dontListenPageClose()
           {
           		window.onbeforeunload=null;
				window.onunload=null;
           }   
           
            //监听页面关闭
           function listenPageClose(){
	   			window.onbeforeunload = onbeforeunload_handler; 
				window.onunload = onunload_handler; 
			} 
			
			
			
			 
			
			//关闭页面提示
			 function onbeforeunload_handler(){
			 
				   return "确定离开？？";     
				} 
				   
		
			function onunload_handler(){        
				 //var warning="欢迎您下次咨询";   
				 closeWebSocket();   
				 //alert(warning);    
				 } 
				 
	
	  /**
	   * 启动关闭连接倒计时；30s
	   */
	   function waitClose()
	   {
		   var html="您还有什么问题吗? 30s后即将关闭！！！";
		   setMessageInnerHTML(html);
		   lastChatTime=new Date().getTime();
		   checkState=setInterval("check()",CHECK_TIME);//连接成功打开计时器
	   }
	   
	   /**
	    * 检查关闭连接剩余时间
	    */
	   function check()//每隔1s检查一下，如果1秒没有发送消息主动关闭连接
	      {
	    	  var nowTime=new Date().getTime();
	    	  var tTt=nowTime-lastChatTime;//间隔时间
	    	  var html=closeLeaveNum+"s后即将关闭！！！";
	 		  setMessageInnerHTML(html);
	     if(tTt>CLOSE_LEAVE_TIME)
	         {
	           finishState=1;
	           closeType=1;
	           closeWebSocket();
	           clearInterval(checkState);
	        }

	        closeLeaveNum--;
	        
	      }
		
		//让消息界面的滚动条显示在底部
	   function  messageGoDown()
	   {
	   		document.getElementById("message").scrollTop=document.getElementById("message").scrollHeight+10;
	   }


		/*//按下回车键
		 document.onkeydown=function(event){
            var e = event || window.event || arguments.callee.caller.arguments[0];
    
             if(e && e.keyCode==13){ // enter 键
                 send();
            }
        }*/
        
        function showCurrentService(serviceId,serviceName){
           $(function(){
           		
           	/*	$("#current_service").text("与客服"+serviceName+"聊天中");*/
           	    $("#service_id").val(serviceId);
           
           })
        }
