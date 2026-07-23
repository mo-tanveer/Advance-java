/**
 * 
 *//**
 * 
 */

function makeRequestObject()
{
	var xmlHttp = false;
	
	try
	{
		//<=6
		xmlHttp = new ActiveXObject('Msxml2.XMLHTTP');
	}
	catch(e)
	{
		try{
			//>6
			
			xmlHttp = new ActiveXObject('Microsoft.XMLHTTP');
		}
		catch(E)
		{
			xmlHttp = false;
		}
	}
	
	//All other latest browser
	
	if(!xmlHttp && typeof(XMLHttpRequest) != 'undefined')
		{
			xmlHttp = new XMLHttpRequest();
		}
		return xmlHttp;
}


function sendData(val)
{
	var xmlHttp =  makeRequestObject();
	var url = 'output.jsp?value='+val;
	xmlHttp.open('GET',url,true) //true is indicate Auto postback
	xmlHttp.onreadystatechange = function()
										{
											if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
												{
													var content = xmlHttp.responseText;
													
													if(content)
														{
															document.getElementById("info").innerHTML=content;
														}
												}
										}
										xmlHttp.send(null);
}