
//注：pageUrl需要在其他js文件中定义

function zcTzClick(totalPage,pageUrl)
{
	$(function(){
		
		var reqPage=$("#zc_tz_text").val();
		if(reqPage>totalPage||reqPage<=0)
			{
			  alert("没有该页");
			}
		else
			{
				window.location.href=pageUrl+"?pageNo="+reqPage;
			
			}
			
		    
	})
}


/**
 * 每页显示记录设置
 * @param pageUrl
 */
function pageSizeClick(pageUrl)
{  $(function(){
		var pageSize=$("#page_size_text").val();
		
		if(isNaN(pageSize))
			{
			  alert("请输入数字！");
			}
		else
		  window.location.href="wx/status/resetPageSize.shtm?pageUrl="+pageUrl+"&pageSize="+pageSize;
	})
}
/**
 * ajax请求重写分页的js
 * @param totalPage
 * @param totalRecord
 * @param pageNo
 * @returns
 */
function appendAjaxFenYeHtml(totalPage,totalRecord,pageNo){
	
	//alert(totalPage+"  "+"  "+totalRecord+"  "+pageNo);
	if(totalRecord<=0)
		return false;
	var prePage=pageNo-1;
	var nextPage=pageNo+1;
    var prePageHtml="";
    var nextPageHtml="";
    
    if(pageNo-1>0)
    	prePageHtml="<td><a href='javascript:void(0);' onclick='ajaxPrePage("+prePage+")'>上一页</a>  |</td>";
    if(pageNo+1<=totalPage)
    	nextPageHtml="<td><a href='javascript:void(0);' onclick='ajaxNextPage("+nextPage+","+totalPage+")'>下一页</a>  |</td>";
	var pageNohtml="<td>第"+(pageNo)+"页  |</td>";
	var totalPageHtml="<td>共"+totalPage+"页  |</td>";
	var totalRecordHtml="<td>共"+totalRecord+"条记录  |</td>";
	var tzHtml="<td style='padding-left:10px' >跳转到&nbsp;</td><td><input type='text' value=''"+
	"id='ajax_tz_text' style='width:30px;height:30px' /></td><td ><input type='button' value='跳转' "+
	"id='ajax_tz_button'  onclick='ajaxTzClick("+totalPage+")'  ></td>";
	
	var html="<table style='margin:0 auto'><tr>"+prePageHtml+pageNohtml+nextPageHtml+totalPageHtml+totalRecordHtml+tzHtml+"<tr></table>"

     $("#fenye").empty();
	//alert("dddddddddddddddddddd");
	 $("#fenye").append(html);
	
}


/**
 * ajax请求点击跳转前的判断，正确返回请求页码
 * @param totalPage
 * @returns
 */
function ajaxTzClick(totalPage){
	
    var reqPage=$("#ajax_tz_text").val();
    if(reqPage>totalPage||reqPage<=0)
    	{
    		alert("没有此页");
    		return false;
    	}
    else
    	{
    	
    		reqUrl=getUrlAndPageNo(sendUrl,reqPage);
    		showAjaxList(reqUrl,sendData)
    	}
   
	
}

/**
 * ajax上一页的判断，正确返回请求页码
 * @param pageNo
 * @returns
 */
function ajaxPrePage(prePage)
{
	 /*var pageNo=$("#ajax_page_no").val();*/
	 //var prePage=pageNo-1;
	    if(prePage>0)
	    	{
	    	  reqUrl=getUrlAndPageNo(sendUrl,prePage);
	    	  showAjaxList(reqUrl,sendData)
	    	}
	    		
	    else
	    	{
	    	  alert("没有此页")
	    	  return false;
	    	
	    	}
	   
}

/**
 * ajax下一页的判断，正确返回请求页码
 * @param pageNo
 * @param totalPage
 * @returns
 */
function ajaxNextPage(nextPage,totalPage){
	/*var pageNo=$("#ajax_page_no").val();
	var totalPage=$("#ajax_total_page").val();*/
	    //var nextPage=pageNo+1;
       // alert(nextPage+"  "+totalPage);
	    //下一页
	    if(nextPage<=totalPage)
	    	{
	    	  reqUrl=getUrlAndPageNo(sendUrl,nextPage);
	    	  showAjaxList(reqUrl,sendData)
	    	}
	    		
	    else{
	    		alert("没有此页");
	    		return false;
	   }
}



/**
 * 获得带上pageNO的url
 * @param sendUrl
 * @param PageNo
 * @returns
 */
function getUrlAndPageNo(sendUrl,pageNo){
	// alert("ggggggggggggggg"+pageNo);
	return sendUrl+"?pageNo="+pageNo;
	
}