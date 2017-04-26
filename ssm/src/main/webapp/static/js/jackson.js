$(function(){
	//单个新增或修改
	$('#one').click(function(){
		var user = {id:"1",userName:"张三",password:"123456",loginName:"zs",age:18};
		var json = $.toJSON(user);//将JS对象转换为JSON对象
		$.ajax({
			type:"POST",
			url:"users/user",
			data:json,
			contentType:"application/json",
			async:true,
			success:function(data){
				alert(data.status);
				alert(data.msg);
			}
		});
	});
});