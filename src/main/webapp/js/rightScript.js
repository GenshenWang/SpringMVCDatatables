$(function() {
	var table = $("#example").DataTable({
		"bProcessing" : true,
		"bServerSide" : true,
		"bAutoWidth" : false,
		"sort" : "position",
		"bStateSave" : false,
		"iDisplayLength" : 10,
		"iDisplayStart" : 0,
		"dom": '<l<\'#dataPlugin\'>f>rt<i<\'#deleteLog\'>p><"clear">',
		"ajax": {
                "type": "post",
                "data": function ( d ) {
				     return $.extend( {}, d, {
				     	//添加额外的参数传给服务器(可以多个)
				        "start_end_time": $('#reportrange span').html()
				     } );
				 },
                "url":contextPath + "/log/logList"
        },
		"aoColumns" : [{
					"mData" : "logid",
					"orderable" : false, // 禁用排序
					"sDefaultContent" : "",
					"sWidth" : "10%"
				}, {
					"mData" : "username",
					"sDefaultContent" : "",
					"sWidth" : "10%"
				}, {
					"mData" : "logtime",
					"sDefaultContent" : "",
					"sWidth" : "10%"
				}, {
					"mData" : "host",
					"sDefaultContent" : "",
					"sWidth" : "10%"
				}, {
					"mData" : "operation",
					"sDefaultContent" : "",
					"sWidth" : "15%"
				}, {
					"mData" : "doactionobj",
					"sDefaultContent" : "",
					"sWidth" : "10%"
				}, {
					"mData" : "",
					"orderable" : false, // 禁用排序
					"sDefaultContent" : '<button id="deleteOne" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash" aria-hidden="true"> 删除</button>',
					"sWidth" : "10%"
				}],
		"columnDefs" : [{
			"orderable" : false, // 禁用排序
			"targets" : [0], // 指定的列
			"data" : "logid",
			"render" : function(data, type, full, meta) {
				return '<input type="checkbox" value="'+ data + '" name="checkOne"/>';
			}
		}],
		"oLanguage" : { // 国际化配置
			"sProcessing" : "正在获取数据，请稍后...",
			"sLengthMenu" : "显示 _MENU_ 条",
			"sZeroRecords" : "<strong>没有您要的内容，输点别的试试！！</strong>",
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
	    }
	});
	
	/**
     * 表格加载渲染完毕后执行的方法
     * @param data
     */
    function initComplete(data){
        var dataPlugin ='<div id="reportrange" class="pull-left dateRange" style="width:400px;margin-left:50px"> '+
                '日志记录时间：<i class="glyphicon glyphicon-calendar fa fa-calendar"></i> '+
                '<span id="searchDateRange"></span>  '+
                '<b class="caret"></b></div> ';//时间选择器的HTML DOM
        
        var deleteLogHtml='<button id="deleteButton" type="button" class="btn btn-danger btn-sm" style="flot:left;margin-right:10px;">删除日志</button>' +
					'<span name="deleteTips" style="flot:left;margin-right:10px;color:green;"></span><div style="clear:left;"></div>';//删除按钮的HTML DOM
			
		$('#dataPlugin').append(dataPlugin);//表格上边的时间选择器
        $("#deleteLog").append(deleteLogHtml);//表格下方的按钮操作区
        $("#deleteButton").on("click", deleteLog);//给下方按钮绑定事件
        
        //时间插件
        $('#reportrange span').html(moment().subtract(1, "year").format('YYYY-MM-DD HH:mm:ss') + ' - ' + moment().format('YYYY-MM-DD HH:mm:ss'));
        $('#reportrange').daterangepicker({//初始化时间插件
        	maxDate : moment(), //最大时间（即现在的时间）
            dateLimit : {year : 2}, //起止时间的最大间隔2年
            showDropdowns : true,
            showWeekNumbers : false, //是否显示第几周
            timePicker : true, //是否显示小时和分钟
            timePickerIncrement : 60, //时间的增量，单位为分钟
            timePicker12Hour : false, //是否使用12小时制来显示时间
            ranges : {
                //'最近1小时': [moment().subtract('hours',1), moment()],
                '今日': [moment().startOf('day'), moment()],
                '昨日': [moment().subtract('days', 1).startOf('day'), moment().subtract('days', 1).endOf('day')],
                '最近一周': [moment().subtract('days', 6), moment()],
                '最近一月': [moment().subtract('days', 29), moment()]
            },
            opens : 'right', //日期选择框的弹出位置
            buttonClasses : [ 'btn btn-default' ],
            applyClass : 'btn-small btn-primary blue',
            cancelClass : 'btn-small',
            format : 'YYYY-MM-DD HH:mm:ss', //控件中from和to 显示的日期格式
            separator : ' to ',
            locale : {
                applyLabel : '确定',
                cancelLabel : '取消',
                fromLabel : '起始时间',
                toLabel : '结束时间',
                customRangeLabel : '自定义',
                daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],
                monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月' ],
                firstDay : 1
            }
        }, function(start, end, label) {//格式化日期显示框
      		 $('#reportrange span').html(start.format('YYYY-MM-DD HH:mm:ss') + ' - ' + end.format('YYYY-MM-DD HH:mm:ss'));
    	});
    	
    	//设置日期菜单被选项  --开始--
	    var dateOption ;
	    if("${riqi}"=='day') {
	        dateOption = "今日";
	    }else if("${riqi}"=='yday') {
	        dateOption = "昨日";
	    }else if("${riqi}"=='week'){
	        dateOption ="最近一周";
	    }else if("${riqi}"=='month'){
	        dateOption ="最近一月";
	    }else if("${riqi}"=='year'){
	        dateOption ="最近一年";
	    }else{
	        dateOption = "自定义";
	    }
	    $(".daterangepicker").find("li").each(function (){
	        if($(this).hasClass("active")){
	            $(this).removeClass("active");
	        }
	        if(dateOption==$(this).html()){
	            $(this).addClass("active");
	        }
	    });
	    //设置日期菜单被选项  --结束--
		
	    //选择时间后触发重新加载的方法
	   $("#reportrange").on('apply.daterangepicker',function(){
	       //当选择时间后，出发dt的重新加载数据的方法
	       table.ajax.reload();
	       $('input[name=allChecked]')[0].checked=false;//取消全选状态
	   });
    }
    
	/**
	 * 单行删除按钮点击事件响应
	 */
	$('#example tbody').on('click', '#deleteOne', function() {
		 $("input[name=logIds]").val(table.row($(this).closest('tr')).data().logid);//将日志id赋给隐藏的文本框
		 setTimeout(function(){deleteLog();},10);//调用批量删除的方法(延迟10毫秒是为了能够显示出现选中的操作)
	});
    
	//多选选中和取消选中,同时选中第一个单元格单选框,并联动全选单选框
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
		var logIds = $("input[name=logIds]");
		if(logIds.val() === ""){
			logIds.val($(para).val());
		}else{
			logIds.val(logIds.val()+","+$(para).val());
		}
	}
	
	/**
	 * 单选框取消选中时将它的value移除隐藏域
	 */
	function cancelValue(para){
		//取消选中checkbox要做的操作
		var logIds = $("input[name=logIds]");
		var array = logIds.val().split(",");
		logIds.val("");
		for (var i = 0; i < array.length; i++) {
			if (array[i] === $(para).val()) {
				continue;
			}
			if (logIds.val() === "") {
				logIds.val(array[i]);
			} else {
				logIds.val(logIds.val() + "," + array[i]);
			}
		}
	}
	/**
	 * 删除日志按钮事件
	 */
	function deleteLog(){
		var logIds = $("input[name=logIds]");
		var message_tips=$("span[name=deleteTips]");
		if(logIds.val() !== '' && logIds.val() !== null){
			if(confirm("确定删除这些日志记录？")){//再次确认
	    		$.ajax({
	    			type: "post",
	    			url:contextPath+"/log/logDelete?logIds="+logIds.val(),
	    			dataType: "text",
	    			success:function(data){
	                    message_tips.html(data+"条记录被删除!");
	                    setTimeout(function(){
	                    	 	table.ajax.reload(null,false);
	                    	 	logIds.val("");//将隐藏域清空
	                    	 	$('input[name=allChecked]')[0].checked=false;//取消全选状态
			 					message_tips.html("");
	                    },1000);
	    			}
	    		});
			}
			return false;
    	}else{
    		alert("没有任何数据被选中！");
    		return false;
    	}
	}  
});