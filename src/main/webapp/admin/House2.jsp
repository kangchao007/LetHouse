<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/18
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<link href="../css/default.css" rel="stylesheet" type="text/css" />--%>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript">

        $(function(){
            //使用datagrid绑定数据展示
            $('#dg').datagrid({
                title:">>>>已审核出租房管理",
                url:'/admin/getHouseByYesPass',
                fitColumns: true,
                pagination: true,
                pageList: [5, 10, 15, 20],
                toolbar:"#ToolBar",
                //singleSelect:true,  //只能设置单选
                pageSize:5,
                columns: [[
                    {field:'ck',checkbox:true},  //复选框列
                    { field: 'id', title: '编号', width: 50, align: "center" },
                    { field: 'title', title: '标题', width: 50, align: "center" },
                    { field: 'price', title: '价格', width: 50, align: "center" },
                    { field: 'floorage', title: '面积', width: 50, align: "center" },
                    { field: 'dname', title: '区域', width: 50, align: "center" },
                    { field: 'sname', title: '街道', width: 50, align: "center" },
                    { field: 'tname', title: '类型', width: 50, align: "center" },
                    { field: 'ispass', title: '状态', width: 50, align: "center" ,
                        formatter:function(value,row,index){
                            return "已审核";
                        }
                    },
                    { field: 'opt', title: '操作', width: 50, align: "center",
                        formatter: function(value,row,index){
                            return "<a href='javascript:cancelPass("+row.id+")'>取消审核</a>";
                        }
                    }
                ]]
            });
        });


        //实现搜索
        function searchUser(){
            //datagrid控制重新加载的方法
            //$("#dg").datagrid("load",跟查询条件的参数);
            //取电话,开始年龄，结束年龄
            var $telephone=$("#tel").val();
            var $startAge=$("#startAge").val();
            var $endAge=$("#endAge").val();
            $("#dg").datagrid("load",{"telephone":$telephone,"startAge":$startAge,"endAge":$endAge});
        }

        //审核通过的方法
        function cancelPass(id){
            //发布异步请求
            $.post("cancelPassHouse",{"id":id},function(data){
                if(data.result>0){
                    $.messager.alert('提示框','恭喜取消审核成功!');
                    $("#dg").datagrid("reload");
                }else{
                    $.messager.alert('提示框','取消审核失败!');
                }
            },"json");

        }


    </script>

</head>
<body>
<!--展示数据-->
<table id="dg"></table>

<!--定义工具栏-->
<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a
                href="javascript:ModifyBySelect()" class="easyui-linkbutton"
                iconCls="icon-edit" plain="true">修改</a>
        <a
                href="javascript:DeleteMore()" class="easyui-linkbutton"
                iconCls="icon-remove" plain="true">删除选中项</a>
    </div>
    <!--搜索条件-->
    <div>
        区域:<select name=""></select>
        街道:<select name=""></select>
        类型:<select name=""></select>
        开始价格:<input type="text" name="startPrice" id="startAge"/>
        结束价格:<input type="text" name="endPrice" id="endAge"/>
        <a id="btn" href="javascript:searchUser();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>

    </div>
</div>


</body>
</html>
