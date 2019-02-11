function addStaff(){
    $.ajax({
        type : "POST",
        url : "http://localhost:8080/supplier/add",
        data : {
            staffId : $('#staffId').val(),
            staffName : $('#staffName').val(),
            staffSex : $("input[name='sex']:checked").val(),
            staffPlace : $('#staffPlace').val(),
            staffSalary : $('#staffSalary').val(),
            staffPhone : $('#staffPhone').val(),
            staffAddress : $('#staffAddress').val(),
            staffEmploydate : $('#staffEmploydate').val(),
            staffNote : $('#staffNote').val(),
            staffType : $('#staffType').val(),
            staffSalary : $('#staffSalary').val(),
            staffPassword : $('#staffPassword').val(),
            staffRole : $('#staffRole').val()
        },
        success : function (data){
            if (data.code != 0){
                layer.msg(data.msg,{icon:2,time:2000});
            } else {
                layer.msg("添加成功",{icon:1,time:2000});
            }
        },
        error : function () {
            layer.msg('服务器异常',{icon:2,time:2000});
        }
    })
};

function updateStaff(){
    $.ajax({
        type : "POST",
        url : "http://localhost:8080/supplier/update",
        data : {
            staffId : $('#staffId').val(),
            staffName : $('#staffName').val(),
            staffSex : $("input[name='sex']:checked").val(),
            staffPlace : $('#staffPlace').val(),
            staffSalary : $('#staffSalary').val(),
            staffPhone : $('#staffPhone').val(),
            staffAddress : $('#staffAddress').val(),
            staffEmploydate : $('#staffEmploydate').val(),
            staffNote : $('#staffNote').val(),
            staffType : $('#staffType').val(),
            staffSalary : $('#staffSalary').val(),
            staffPassword : $('#staffPassword').val(),
            staffRole : $('#staffRole').val()
        },
        success : function (data){
            if (data.code != 0){
                layer.msg(data.msg,{icon:2,time:2000});
            } else {
                layer.msg("修改成功",{icon:1,time:2000});
            }
        },
        error : function () {
            layer.msg('服务器异常',{icon:2,time:2000});
        }
    })

}

function toList(){
    $.ajax({
        type : "GET",
        url : "http://localhost:8080/staff/to_list",
        data: {
            pageNum : $('#pageNum').val(),
            pageSize : $('#pageSize').val(),
            orderby : $('#orderby').val()
        },
        success: function () {
            // 渲染数据
        },
        error : function () {
            layer.msg('服务器异常',{icon:2,time:2000});
        }
    })
}