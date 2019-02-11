function addsupplier(){
    $.ajax({
        type : "POST",
        url : "http://localhost:8080/supplier/add",
        data : {
            supplierId : $('#supplierId').val(),
            supplierName : $('#supplierName').val(),
            supplierLinkman : $('#supplierLinkman').val(),
            supplierPhone : $('#supplierPhone').val(),
            supplierAddress : $('#supplierAddress').val(),
            supplierBank : $('#supplierBank').val(),
            supplierAccount : $('#supplierAccount').val(),
            supplierNote : $('#supplierNote').val(),
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

function updateSupplier(){
    $.ajax({
        type : "POST",
        url : "http://localhost:8080/supplier/update",
        data : {
            supplierId : $('#supplierId').val(),
            supplierName : $('#supplierName').val(),
            supplierLinkman : $('#supplierLinkman').val(),
            supplierPhone : $('#supplierPhone').val(),
            supplierAddress : $('#supplierAddress').val(),
            supplierBank : $('#supplierBank').val(),
            supplierAccount : $('#supplierAccount').val(),
            supplierNote : $('#supplierNote').val(),
        },
        success : function () {

        },
        error : function () {

        }
    })
}

function toListSupplier(){
    $.ajax({
        type : "GET",
        url : "http://localhost:8080/supplier/to_list",
        data : {

        },
        success : function () {
            // 渲染数据
        },
        error : function () {
            // TODO
        }

    })
}
