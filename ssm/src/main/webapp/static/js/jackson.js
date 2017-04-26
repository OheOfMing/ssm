function changeurl(){
	var id = $("input[name=id]").val();
	var uri = "persons/"+id;
	$('#userform').prop("action",uri);
	return true;
}



$(function(){
	
	
	//单个新增
	$('#one').click(function(){
		var user = {userName:"张三",password:"123456",loginName:"zs",age:18};
		var json = $.toJSON(user);//将JS对象转换为JSON对象
		var uri = "users/0";
		$.ajax({
			type:"POST",
			url:uri,
			data:json,
			contentType:"application/json",
			async:true,
			success:function(data){
				alert(data.status);
				alert(data.msg);
			}
		});
	});
	
	//单个修改
	$('#two').click(function(){
		//user代表着需要修改的信息
		var user = {userName:"张三",password:"123456",loginName:"zs",age:18};
		var json = $.toJSON(user);//将JS对象转换为JSON对象
		var id = $('#u_id').val();//需要修改的对象ID
		var uri = "users/"+id;
		$.ajax({
			type:"PUT",
			url:uri,
			data:json,
			contentType:"application/json",
			async:true,
			success:function(data){
				alert(data.status);
				alert(data.msg);
			}
		});
	});
	
	
	//查询对象
	$('#three').click(function(){
		var id = $('#u_id').val();//需要查询的对象ID
		var uri = "users/"+id;
		$.ajax({
			type:"GET",
			url:uri,
			async:true,
			success:function(data){
				alert(data.userName);
				
			}
		});
	});
	
	$('#four').click(function(){
		var id = $('#u_id').val();//需要删除的对象ID
		var uri = "users/"+id;
		$.ajax({
			type:"DELETE",
			url:uri,
			async:true,
			success:function(data){
				alert(data.status);
				alert(data.msg);
			}
		});
	});
	
	
	
	
	
	
	
	
});