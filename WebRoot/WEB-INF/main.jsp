<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
	<title>main page</title>
	<style type="text/css">
.topright1{width:5%;position:absolute;height:40px; top:2px;left:90%}
a.exit{
margin-top:100px;
color:white;
hover:white;}
.topleft{color:white;background-color:#222222;height:50px;margin-top:-25px;font-family:calibri;font-size:30;}
.left{background-color:#f5f3f4; width:20%;float:left;height:600px;}
.right{width:75%;float:right;height:100px;}
.right1{margin:30px;font-family:"YouYuan"}
.submit1{
background:none;font-size:15px;opacity:1;padding:5px;
width:150px;-moz-border-radius:5px;-webkit--border-radius:5px;border-radius:5px;
cursor:pointer;margin-bottom:-10px;margin-left:13px;margin-top:0;
border-style: solid;
text-shadow:1px 1px 0 #FFFFFF;border-color:#DDDDDD #DDDDDD #CCCCCC;color: #333;
}
</style>
    <link href="zTreeStyle/metro.css" rel="Stylesheet" type="text/css" /> 
    <link href="js/bootstrap.css" rel="Stylesheet" type="text/css" /> 
    <link rel="stylesheet" type="text/css" href="js/jquery.dataTables.css"> 
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>  
    <script type="text/javascript" src="zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
    <script type="text/javascript" src="js/jquery.dataTables.js"></script>
     <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" >
         var code;
        function zTreeOnClick(event, treeId, treeNode) {
     var treeId = treeNode.id;
    $.ajax({
        url:"showemployees.action",
        type: "post",
        async: false,  
        data: {"treeId":treeId},
        success: function(ajson) {
				 apps = JSON.parse(ajson);
					$("#table_id").DataTable( {
					destroy: true,
       data: apps,
    columns: [
        { data: 'id' },
        { data: 'firstname' },
        { data: 'lastname' },
        { data: 'gender' },
        { data: 'age'},
        { data: null},
        { data: null}
    ],
    "fnRowCallback": function( nRow, aData, iDisplayIndex ) {
				$('td:eq(5)', nRow).html("<button class='btn btn-primary' onclick='deleteRoleSpecSer(\""+ aData.id+"\")'>Delete</button>");
				$('td:eq(6)', nRow).html("<button class='btn btn-primary' onclick='editRoleSpecSer(\""+ aData.id+"\")'>Edit</button>");
			return nRow;
		}, 
    });
    }
    
        }); 
};
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                 onClick: zTreeOnClick 
            }
            };
           
		function filter(treeId,parentNode,childNodes){
			var str="["+childNodes+"]";
			var obj=eval(str);
			return obj;
		}
        var treeNodes=new Array();
         function node (){ 
    $.ajax({  
    	url:"getOrgTree.action",
        type: "post",  
        async: false,  
        cache: false,   
        error: function () {//请求失败处理函数  
            alert('请求失败');  
        },  
        success:function(data){ //请求成功后处理函数。    
         var test=eval("("+data+")");
         console.log(test);
         
     	  var obj=new Object();
        $.each(test,function(idx,item){
        	obj.id=item.id;
        	obj.pId=item.pId;
        	obj.name=item.name;
        });
        	treeNodes.push(obj);
        	
        	console.log(treeNodes);
         $.fn.zTree.init($("#tree"), setting, test);
            zTreeObj = $.fn.zTree.getZTreeObj("tree");
        }  
    });  
}; 
    window.onload=function(){
	node();
	var treeId = 0;
    $.ajax({
        url:"showemployees.action",
        type: "post",
        async: false,  
        data: {"treeId":treeId},
        success: function(ajson) {
				 apps = JSON.parse(ajson);
					$("#table_id").DataTable( {
					destroy: true,
       data: apps,
    columns: [
        { data: 'id' },
        { data: 'firstname' },
        { data: 'lastname' },
        { data: 'gender' },
        { data: 'age'},
        { data: null},
        { data: null}
    ],
    "fnRowCallback": function( nRow, aData, iDisplayIndex ) {
				$('td:eq(5)', nRow).html("<button class='btn btn-primary' onclick='deleteRoleSpecSer(\""+ aData.id+"\")'>Delete</button>");
				$('td:eq(6)', nRow).html("<button class='btn btn-primary' onclick='editRoleSpecSer(\""+ aData.id+"\")'>Edit</button>");
			return nRow;
		}, 
    });
    }
    
        }); 
};  
function deleteRoleSpecSer(id){
		$.ajax({
			    url: "deleteEmployee.action",
			    type: "post",
			    async: false,
			    data: {"id":id},
			    dataType: "json",
			    success: function(){
			    	location.reload(true);
			    }
			    
		});
		location.reload(true);
};
function editRoleSpecSer(id){
var ids = id;
window.location.href = "editEmployee.action?key="+id;
}
</script> 
  </head>
  <body> 
<br>
<div class=topleft>
<br>
	organization system 
	
	</div>
   <div class=topright1>
   <p> </p>
	<a class="btn btn-default" href="logout.action">Logout</a>      
	</div>
	<div class=left>
	<div id="content">
    <div class="menu">
    <br>
    <ul id="tree" class="ztree"></ul>
    </div>
	</div>
	</div>
	<div class=right><p>  </p>
    <br>
	<table id="table_id" class="display">
    <thead>
        <tr>
            <th>id</th>
            <th>firstname</th>
             <th>lastname</th>
              <th>gender</th>
              <th>age</th>
              <th>delete</th>
              <th>edit</th>
        </tr>
    </thead>
    <tbody>
      
    </tbody>
</table>
	<br/>
		 <s:form   action="findClient" namespace="/client" theme="simple">
   <table> 
   <tr>
   <td><s:submit cssClass="submit1" value="添加" method="exploreAddClient"></s:submit></td>
    </tr>
    </table>
    </s:form>
	</div>
	
</body>
</html>
