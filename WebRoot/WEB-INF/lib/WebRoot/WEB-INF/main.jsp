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
.role{position:absolute;top:15%;left:3%}
.acc{position:absolute;top:5px;left:83%}
.ree{position:absolute;top:20%;left:3%}
.logout{position:absolute;top:5px;left:90%}
.leftbutton{float:left;}
.rightbutton{float:right;}
a.exit{
margin-top:100px;
color:white;
hover:white;}
.topleft{color:white;background-color:#222222;height:50px;margin-top:-25px;font-family:calibri;font-size:30;}
.left{background-color:#f5f3f4; width:20%;float:left;height:600px;}
.right{position:absolute; top:7%;left:25%;width:100%}
.submit1{
background:none;font-size:15px;opacity:1;padding:5px;
width:150px;-moz-border-radius:5px;-webkit--border-radius:5px;border-radius:5px;
cursor:pointer;margin-bottom:-10px;margin-left:13px;margin-top:0;
border-style: solid;
text-shadow:1px 1px 0 #FFFFFF;border-color:#DDDDDD #DDDDDD #CCCCCC;color: #333;
}
.tabs {
  width: 650px;
  float: none;
  position: relative;
  margin: 30px 0 0 10px;
  
}
.tabs li {
  float: left;
  display: block;
}
.tabs input[type="radio"] {
  position: absolute;
  top: -9999px;
  left: -9999px;
}
.tabs1 label {
  display: block;
  padding: 14px 21px;
  border-radius: 2px 2px 0 0;
  font-size: 20px;
  font-weight: normal;
  text-transform: uppercase;
  background: #fa858d;
  cursor: pointer;
  position: relative;
  top: 4px;
  -webkit-transition: all 0.2s ease-in-out;
  -moz-transition: all 0.2s ease-in-out;
  -o-transition: all 0.2s ease-in-out;
  transition: all 0.2s ease-in-out;
}
/* .tabs label:hover {
  background: #f45551;
}  */
.tabs .tab-content {
  z-index: 2;
  display: none;
  padding: 25px;
  position: absolute;
  top: 53px;
  left: 0;
  background: #ffffff;
}
.tabs [id^="tab"]:checked + label {
  top: 0;
  //padding-top: 17px;
  background: #f45551;
}
.tabs [id^="tab"]:checked ~ [id^="tab-content"] {
  display: block;
}
</style>
    <link href="zTreeStyle/metro.css" rel="Stylesheet" type="text/css" /> 
    <link href="js/bootstrap.css" rel="Stylesheet" type="text/css" /> 
    <link rel="stylesheet" type="text/css" href="js/jquery.dataTables.css"> 
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>  
    <script type="text/javascript" src="zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
    <script type="text/javascript" src="js/jquery.dataTables.js"></script>
     <script type="text/javascript" src="js/bootstrap.js"></script>
 
  </head>
  <body> 
<br>
<div class=topleft>
<br>
	organization system 
	
	</div>
    <div class="acc" id="account"> <a class="btn btn-default" href="Accounts.action">Accounts</a>  </div>  
	<div class="logout"><a class="btn btn-default" href="logout.action">Logout</a>  </div>    
	
	<div class=left>
	<div id="content">
    <div class="menu">
   <br>
   <br> 
   <div class="role"><p><a class="btn btn-default" href="role33.action">角色管理</a><a class="btn btn-default" href="ability33.action">能力管理</a> </p> </div>    
	
   <div class="ree">
<ul id="tree" class="ztree"></ul>
<div class="leftbutton">
<s:form   action="findOrg" namespace="/org" theme="simple">
   <table> 
   <tr>
   <td><s:submit cssClass="submit1" value="添加" method="exploreAddClient"></s:submit></td>
    </tr>
    </table>
    </s:form>
 </div>   
 <div class="rightbutton">
    <s:form   action="deleteOrg" namespace="/org" theme="simple">
   <table> 
   <tr>
   <td><s:submit cssClass="submit1" value="删除" method="exploreAddClient"></s:submit></td>
    </tr>
    </table>
    </s:form>
    </div>
    </div>
    </div>
	</div>
	</div>
	<div class=right><p>  </p>
    <br>
    <ul class="tabs">
    <li>
<input type="radio" name="tabs" id="tab1" checked />
<label class="btn btn-primary" for="tab1">组织角色管理</label>
	<div id="tab-content1" class="tab-content">
		<table id="table_id1" class="display">
    <thead>
        <tr>
       		<th>职位id</th>
      	    <th>职位名称</th>
            <th>角色id</th>
            <th>角色名称</th>
              <th>删除</th>
              </tr>
    </thead>
    <tbody>
      
    </tbody>
</table>
 <s:form   action="findPos" namespace="/position" theme="simple">
   <table> 
   <tr>
   <td><s:submit cssClass="submit1" value="添加" method="exploreAddClient"></s:submit></td>
    </tr>
    </table>
    </s:form>
    
	</div>
</li>

<li>
<input type="radio" name="tabs" id="tab2" />
<label class="btn btn-primary" for="tab2">组织人员管理</label>
<div id="tab-content2" class="tab-content">
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
              <th>position</th>
              <th>ability</th>
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
</li>
</ul>
	</div>
	    <script type="text/javascript" >
         var code;
         var treid =  '<%=session.getAttribute("orgid")%>';         
          var treeId;
         if(treid!=0){treeId = treid;}
         else {treeId=0;}
          function hide(){
          var user =  '<%=session.getAttribute("user")%>';
          if(user!="admin"){
          document.getElementById("account").style.visibility="hidden";}
          }
        function zTreeOnClick(event, treeId, treeNode) {
         treeId= treeNode.id;
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
        { data: null},
        { data: null},
        { data: null}
    ],
    "fnRowCallback": function( nRow, aData, iDisplayIndex ) {
				$('td:eq(5)', nRow).html("<button class='btn btn-primary' onclick='deleteRoleSpecSer(\""+ aData.id+"\")'>Delete</button>");
				$('td:eq(6)', nRow).html("<button class='btn btn-primary' onclick='editRoleSpecSer(\""+ aData.id+"\")'>Edit</button>");
				$('td:eq(7)', nRow).html("<button class='btn btn-primary' onclick='editPosSpecSer(\""+ aData.id+"\")'>Edit</button>");			
				$('td:eq(8)', nRow).html("<button class='btn btn-primary' onclick='editAbiSpecSer(\""+ aData.id+"\")'>Edit</button>");			
			return nRow;
		}, 
    });
    }
    
        }); 
       // table2();
       $.ajax({
        url:"showroles.action",
        type: "post",
        async: false,  
        data: {"treeId":treeId},
        success: function(ajson) {
				 apps = JSON.parse(ajson);
					$("#table_id1").DataTable( {
					destroy: true,
       data: apps,
    columns: [
    	{ data: 'posid' },
    	{ data: 'posname' },
        { data: 'roleid' },
        { data: 'rolename' },
        { data: null}
    ],
    "fnRowCallback": function( nRow, aData, iDisplayIndex ) {
				$('td:eq(4)', nRow).html("<button class='btn btn-primary' onclick='deleteRole1SpecSer(\""+ aData.posid+"\")'>Delete</button>");
				return nRow;
		},
    });
    }
    
        }); 
        };
   //   document.getElementById("hdncount").value=treeId;
    function table1(){
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
		function table2(){
		
		}
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
	hide();
    $.ajax({
        url:"showemployees.action",
        type: "post",
        async: false,  
        data: {"treeId":0},
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
        { data: null},
        { data: null}
    ],
    "fnRowCallback": function( nRow, aData, iDisplayIndex ) {
				$('td:eq(5)', nRow).html("<button class='btn btn-primary' onclick='deleteRoleSpecSer(\""+ aData.id+"\")'>Delete</button>");
				$('td:eq(6)', nRow).html("<button class='btn btn-primary' onclick='editRoleSpecSer(\""+ aData.id+"\")'>Edit</button>");
				$('td:eq(7)', nRow).html("<button class='btn btn-primary' onclick='editPosSpecSer(\""+ aData.id+"\")'>Edit</button>");
				$('td:eq(8)', nRow).html("<button class='btn btn-primary' onclick='editAbiSpecSer(\""+ aData.id+"\")'>Edit</button>");
			return nRow;
		}, 
    });
     $("#table_id1").DataTable( {
					destroy: true,
       data: apps,
    columns: [
        { data: 'posid' },
    	{ data: 'posname' },
        { data: 'roleid' },
        { data: 'rolename' },
        { data: null}
    ],
    "fnRowCallback": function( nRow, aData, iDisplayIndex ) {
				$('td:eq(4)', nRow).html("<button class='btn btn-primary' onclick='deleteRoleSpecSer(\""+ aData.posid+"\")'>Delete</button>");
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
function deleteRole1SpecSer(posid){
		$.ajax({
			    url: "deleteRole.action",
			    type: "post",
			    async: false,
			    data: {"posid":posid},
			    dataType: "json",
			    success: function(){
			    	location.reload(true);
			    }
			    
		});
		location.reload(true);
};
function editRoleSpecSer(id){
window.location.href = "editEmployee.action?key="+id;
}
function editPosSpecSer(id){
window.location.href = "editPos.action?key="+id;
}
function editAbiSpecSer(id){
window.location.href = "editAbi.action?key="+id;
}
</script>
</body>
</html>
