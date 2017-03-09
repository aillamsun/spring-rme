
/**
 * 删除特殊字符  去除两端空格，去除回车换行符
 * @param str
 */
function rmSpStr(str)
{
	str=$.trim(str);
	str=str.replace(/\r\n/g,"")  
    str=str.replace(/\n/g,"");
	return str;
}