function getImage()
{
      $(function()
      {
	var randNum=new Array
   (0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 'S','T','U','V','W','X','Y','Z');
	var randomN="";
	 for(var i=0;i<4;i++)
	 {
		 var index=Math.floor(Math.random()*36);
		 randomN=randomN+" "+randNum[index];
	 }
	  $(".yzm-img").html("<span>"+randomN+"</span>");
     });
}

$(function(){
	
	getImage();
	
	$(".yzm-sr").keyup(function(){
		
		checkYzm($(".yzm-sr"));
		
	});
	
	$("#tijiao").click(function(){
		var username=$("#username").val();
		var password=$("#password").val();
		if(username.length<=0){
			alert("用户名不能为空");
			return false;
		}
		else if(password.length<=0)
			{
				alert("密码不能为空");
				return false;
			}
		else if(!checkYzm($(".yzm-sr")))
			{
			  alert("验证码错误");
			  return false;
			}
			
		else
			{
			 $("#loginForm").submit();
			}
		
	})
	
		
})


function checkYzm(obj)
{
	var bo=false;
	$(function(){
		
	var str1=obj.val().toLowerCase();
	var str2= $(".yzm-img").text().replace(/\s/g, "").toLowerCase();
	//alert(str1+" "+str2);
	if(str1.length==0)
	{
		//alert("dddd");
		 //obj.parent().siblings(".error").html("<span style='color:#FF2424'>不能为空</span>");
		 bo=false;
	}
	else if(str1==str2)
    {
      obj.css({"border":"1px solid #E0EBF4"});
	  //obj.parent().siblings(".error").html("");
	  bo=true;
     }
   else
    {
      obj.css({"border":"1px solid #FF2424"});
     // obj.parent().siblings(".error").html("<span style='color:#FF2424'>验证码错误</span>");
      bo=false;
     }
	  
	});
	return bo;
}