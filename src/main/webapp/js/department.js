$(function() {
	var table = $("#example").DataTable({
		"aLengthMenu":[10,20,40,60],
		"searching":false,//禁用搜索
		"lengthChange":true,
		"paging": true,//开启表格分页
		"bProcessing" : true,
		"bServerSide" : true,
		"bAutoWidth" : false,
		"sort" : "position",
		"deferRender":true,//延迟渲染
		"bStateSave" : false, //在第三页刷新页面，会自动到第一页
		"iDisplayLength" : 10,
		"iDisplayStart" : 0,
		"dom": '<l<\'#topPlugin\'>f>rt<ip><"clear">',
		 // "dom": 'T<"clear">lfrtip',
	    // "dom": 'iCflrtp',
//	     "tableTools": {
//	            "sSwfPath": contextPath +"/js/copy_csv_xls_pdf.swf",
//	            "sRowSelector": "td:not(:first-child)"
//	           ,
////	            "aButtons": [
////	                 {sExtends: "csv", oSelectorOpts: {page: "current" }},
////	                 "print"],
//	            "sRowSelect": "os",
//	        },
		"ordering": false,//全局禁用排序
		"ajax": {
                "type": "POST",
                "url":contextPath + "/dept/list.do",
                "data":function(d){
                	d.state=$("#state").val();
                	d.deptname=$("#deptname").val().trim();
                  	d.startTime=$("#startTime").val();
                	d.endTime=$("#endTime").val();
                }
        },
		"aoColumns" : [{
			"mData" : "id",
			"orderable": false , // 禁用排序
			"sDefaultContent" : "",
			"sWidth" : "2%"
		        },{
					"mData" : "id",
					"orderable" : false, // 禁用排序
					"sDefaultContent" : "",
					"sWidth" : "6%",
					
				}, {
					"mData" : "deptname",
					"orderable" : false, // 禁用排序
					"sDefaultContent" : "",
					"sWidth" : "10%"
				}, {
					"mData" : "remark",
					"orderable" : false, // 禁用排序
					"sDefaultContent" : "",
					"sWidth" : "10%"
				},{
					"mData" : "state",
					"orderable" : false, // 禁用排序
					"sDefaultContent" : "",
					"sWidth" : "3%",
					"render" : function(data, type, full, meta) {
//						if(data==1){
//							return data ='有效';
//						}else{
//							return data ='无效';
//						}
						//return data == 1 ? '有效' : '<font color="red">无效</font>';
						if(data==1){
							 data ="<a href='#' class='upOrderStatus' data-id="+full.id+">有效</a>";
						}else{
							 data ="<a href='#' class='upOrderStatus' data-id="+full.id+"><font color='red'>无效</font></a>";
						}
					return	 data;
					}
				},
				{
					"mData" : "createtime",
					"orderable" : false, // 禁用排序
					"sDefaultContent" : "",
					"sWidth" : "10%",
					"render" : function(data, type, full, meta) {
						//时间格式化
						return  moment(data).format("YYYY-MM-DD HH:mm:ss");
					}
				},
				{
					"mData" : "id",
					"orderable" : false, // 禁用排序
					"sDefaultContent" : '',
					"sWidth" : "10%",
				    "render":function(data, type, full, meta){
				    return	data='<button id="deleteOne" class="btn btn-danger btn-sm" data-id='+data+'>删 除</button>';
				    	
				    }	
				}],
		"columnDefs" : 
		[{
			"orderable" : false, // 禁用排序
			"targets" : [0], // 指定的列
			"data" : "id",
			"render" : function(data, type, full, meta) {
				return '<input type="checkbox" value="'+ data + '" name="id"/>';
			}
		}],
		"oLanguage" : { // 国际化配置
			"sProcessing" : "正在获取数据，请稍后...",
			"sLengthMenu" : "显示 _MENU_ 条",
			"sZeroRecords" : "没有找到数据",
			"sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
			"sInfoEmpty" : "记录数为0",
			"sInfoFiltered" : "(全部记录数 _MAX_ 条)",
			"sInfoPostFix" : "",
			"sSearch" : "搜索",
			"sUrl" : "",
			"oPaginate" : {
				"sFirst" : "第一页",
				"sPrevious" : "上一页",
				"sNext" : "下一页",
				"sLast" : "最后一页"
			}
		},
		initComplete:initComplete,
		drawCallback: function( settings ) {
	        $('input[name=allChecked]')[0].checked=false;//取消全选状态
//	        function initComplete(data){
//	        	//上方topPlugin DIV中追加HTML
//	        	var topPlugin='<button id="addButton" class="btn btn-success btn-sm" data-toggle="modal" data-target="#addUser" style="display:block;">' +
//	        				  '<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>批量删除</button>';
//	        	
//	        	//删除用户按钮的HTMLDOM
//	            var deleteHtml='<button id="deleteButton" class="btn btn-danger btn-sm" style="flot:left;margin-right:10px;">批量删除用户</button>' +
//	    					       '<span name="deleteTips" style="flot:left;margin-right:10px;color:green;"></span><div style="clear:left;"></div>';
//	    					       
//	    		$("#topPlugin").append(topPlugin);//在表格上方topPlugin DIV中追加HTML
//	           // $("#deleteDep").append(deleteHtml);//表格下方的按钮操作区
//	           // $("#deleteButton").on("click", deleteUser);//给下方按钮绑定事件
//	    		
//	        }
	    }
		
	});
	
	/**
     * 表格加载渲染完毕后执行的方法
     * @param data
     */
    function initComplete(data){
    	//上方topPlugin DIV中追加HTML
    	//var topPlugin='<button id="addButton" class="btn btn-success btn-sm" data-toggle="modal" data-target="#addUser" style="display:block;">' +
    				 // '<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加用户</button>';
    	
    	//删除用户按钮的HTMLDOM
        var topPlugin='<button   class="btn btn-danger btn-sm" id="deleteAll">批量删除</button> <button   class="btn btn-primary btn-sm addBtn" >新 增</button>             <iframe id="exp" style="display:none;"></iframe><button  class="btn btn-info btn-sm" id="expCsv">导 出全部</button>             <button  class="btn btn-warning btn-sm" id="reset">重置搜索条件</button>' ;
					       
		$("#topPlugin").append(topPlugin);//在表格上方topPlugin DIV中追加HTML
		  
		     //$("#expCsv").on("click", exp1);//给下方按钮绑定事件
    
    }
   
    /**
	 * 单行删除按钮点击事件响应
	 */
//	$('#example tbody').on('click', '#deleteOne', function() {
//		 $("input[name=id]").val(table.row($(this).closest('tr')).data().id);//将用户id赋给隐藏的文本框
//		 setTimeout(function(){deleteBatch();},20);//调用批量删除的方法(延迟20毫秒是为了能够显示出现选中的操作)
//	});
	
    $(document).delegate('#deleteOne','click',function() {
    	var id=$(this).data("id");
    	$("#delSubmit").val(id);
    	$("#deleteOneModal").modal('show');
 	   });
    /**
     * 点击确认删除按钮
     */
    $(document).delegate('#delSubmit','click',function(){
        var id=$(this).val();
        $('#deleteOneModal').modal('hide');
        $.ajax({
        	url:contextPath+"/department/delete.do?id="+id,
            async:true,
            type:"GET",
            dataType:"json",
            cache:false,    //不允许缓存
            success: function(data){
                var obj = eval(data);
                if(obj.code==1)
                {
                 
                    window.location.reload();
                }
                else
                {
                    alert("删除失败");
                }

            },
            error:function(data){
                alert("请求异常");
            }
        });
    });

	/**
	 * 多选选中和取消选中,同时选中第一个单元格单选框,并联动全选单选框
	 */
	$('#example tbody').on('click', 'tr', function(event) {
		var allChecked=$('input[name=allChecked]')[0];//关联全选单选框
		$($(this).children()[0]).children().each(function(){
			if(this.type=="checkbox" && (!$(event.target).is(":checkbox") && $(":checkbox",this).trigger("click"))){
				if(!this.checked){
					this.checked = true;
					addValue(this);
					var selected=table.rows('.selected').data().length;//被选中的行数
					//全选单选框的状态处理
					var recordsDisplay=table.page.info().recordsDisplay;//搜索条件过滤后的总行数
					var iDisplayStart=table.page.info().start;// 起始行数
					if(selected === table.page.len()||selected === recordsDisplay||selected === (recordsDisplay - iDisplayStart)){
						allChecked.checked = true;
					}
				}else{
					this.checked = false;
					cancelValue(this);
					allChecked.checked = false;
				}
			}
		});
		$(this).toggleClass('selected');//放在最后处理，以便给checkbox做检测
	});
	
	

	/**
	 * 全选按钮被点击事件
	 */
	$('input[name=allChecked]').click(function(){
		if(this.checked){
			$('#example tbody tr').each(function(){
				if(!$(this).hasClass('selected')){
					$(this).click();
				}
			});
		}else{
			$('#example tbody tr').click();
		}
	});
    
	/**
	 * 单选框被选中时将它的value放入隐藏域
	 */
	function addValue(para) {
		var userIds = $("input[name=userIds]");
		if(userIds.val() === ""){
			userIds.val($(para).val());
		}else{
			userIds.val(userIds.val()+","+$(para).val());
		}
	}
	
	/**
	 * 单选框取消选中时将它的value移除隐藏域
	 */
	function cancelValue(para){
		//取消选中checkbox要做的操作
		var userIds = $("input[name=allChecked]");
		var array = userIds.val().split(",");
		userIds.val("");
		for (var i = 0; i < array.length; i++) {
			if (array[i] === $(para).val()) {
				continue;
			}
			if (userIds.val() === "") {
				userIds.val(array[i]);
			} else {
				userIds.val(userIds.val() + "," + array[i]);
			}
		}
	}

	
//   function exp1(){
//	   $("#exp").attr("src",contextPath+"/department/export.do?t=" + new Date().getTime());
//   }
   $(document).delegate('#expCsv','click',function() {
		  
	   $("#exp").attr("src",contextPath+"/department/export.do?t=" + new Date().getTime());
	   });
   
   $(document).delegate('.addBtn','click',function() {
		  
		$('#myModal-add-info').modal('show');
	   });
   $(document).delegate('#deleteAll','click',function() {
	   var theArray=[];
	   $("input[name=id]:checked").each(function() { 
		      theArray.push($(this).val());
		    });
	   if(theArray.length<1){
		   alert("请至少选择一个"); 
	   }else{
		   alert(theArray);
	   }
		 
	   });
   $(document).delegate('.upOrderStatus','click',function() {
		var id=$(this).data("id");
		//alert(id);
		$("#titleId").html(id);
		$('#editOrderStatus').modal("show");
	});
   $(document).delegate('#reset','click',function() {
	   $("#state").val("");
	   $("#deptname").val("");
	  $("#startTime").val("");
    $("#endTime").val("");
	   });
   $(document).delegate('.search','click',function() {
	   table.ajax.reload();	
		  // $("#example").dataTable().api().ajax.reload();	
//		   table.search(
//				   "state="+$('#state').val()
//			    ).draw();
//		  var 	    state=$("#state").val();
//		   table.column(1).search(state, false, false).draw();
	   });
});