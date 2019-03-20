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
            alert("修改成功");
        },
        error : function () {
            alert("服务器异常");
        }
    })
}


function querysupplier2(){
    var pageNum = $("[name='pageNum']").val();
    var pageSize = $("[name='pageSize']").val();
    $.ajax({
        url : "http://localhost:8080/supplier/to_list2",
        type : "GET",
        data : {
            pageNum : pageNum,
            pageSize : pageSize,
            orderby : "supplier_create_time",
            beginTime : $("#beginTime").val(),
            endTime : $("#endTime").val(),
            factor : $("#factor").val()
        },
        success : function (result) {
            var data = result.data;
            var total = data.total;
            var pageNum = data.pageNum;
            var pageSize = data.pageSize;//页大小

            var suppliers = data.list;
            $('#supplierTbody').html("");
            for(var i = 0, length_1 = suppliers.length; i < length_1; i++){
                (function (supplier) {
                    var index = (pageNum - 1) * page
                    var tr = '<tr><td><input type="checkbox" value="" name=""></td>'
                        + '<td>' + supplier.supplierId + '</td>'
                        + '<td>' + supplier.supplierName + '</td>'
                        + '<td>' + suppliers.supplierLinkman + '</td>'
                        + '<td>' + supplier.supplierPhone + '</td>'
                        + '<td>' + supplier.supplierAddress + '</td>'
                        + '<td>' + supplier.supplierBank + '</td>'
                        + '<td>' + supplier.supplierAccount + '</td>'
                        + '<td>' + supplier.supplierNote + '</td>'
                        + '<td>' + supplier.supplierCreateTime + '</td>'
                        + '<td>' + supplier.supplierUpdateTime + '</td>'
                        + '<td class="td-manage"> <a title="编辑" href="javascript:;" id="row-edit' + supplier.supplierId + '" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" onclick="supplier_del(' + this + "," + supplier.supplierId + ')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>'
                        + '</tr>';
                    $('#supplierTbody').append(tr);
                })(suppliers[i]);

            }
            layui.use(['laypage', 'layer'], function(){
                var laypage = layui.laypage,layer = layui.layer;

                //执行一个laypage实例
                laypage.render({
                    elem: 'pageDiv', //注意，这里的 test1 是 ID，不用加 # 号
                    count: total, //数据总数，从服务端得到
                    limit: pageSize,//每页显示的条数。laypage将会借助 count 和 limit 计算出分页数。
                    curr: pageNum,//当前页号
                    limits: [6, 10, 15, 20],
                    layout: ['limit', 'prev', 'page', 'next', 'skip', 'count'],//显示哪些分页组件
                    jump: function (obj, first) {//点击页号的时候执行的函数
                        //obj包含了当前分页的所有参数，比如：
                        console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                        console.log(obj.limit); //得到每页显示的条数

                        $("[name='pageNum']").val(obj.curr);//向隐藏域设置当前页的值
                        $("[name='pageSize']").val(obj.limit);//向隐藏域设置当前页的大小
                        if (!first) {//首次不执行(点击的时候才执行)
                            querysupplier2();//执行查询分页函数(这个函数必须写在这里)
                        }
                    }
                });
            });
        }
    });

}



function querysupplier(){
    var pageNum = $("[name='pageNum']").val();
    var pageSize = $("[name='pageSize']").val();
    $.ajax({
        url : "http://localhost:8080/supplier/to_list",
        type : "GET",
        data : {
            pageNum : pageNum,
            pageSize : pageSize,
            orderby : "supplier_create_time"
        },
        success : function (result) {
            var data = result.data;
            var total = data.total;
            var pageNum = data.pageNum;
            var pageSize = data.pageSize;//页大小

            var suppliers = data.list;
            $('#supplierTbody').html("");
            for(var i = 0, length_1 = suppliers.length; i < length_1; i++){
                (function (supplier) {
                    var index = (pageNum - 1) * pageSize + i + 1;
                    console.log("supplierAccount:"+supplier.supplierAccount);
                    var tr = '<tr><td><input type="checkbox" value="" name=""></td>'
                        + '<td>' + supplier.supplierId + '</td>'
                        + '<td>' + supplier.supplierName + '</td>'
                        + '<td>' + supplier.supplierLinkman + '</td>'
                        + '<td>' + supplier.supplierPhone + '</td>'
                        + '<td>' + supplier.supplierAddress + '</td>'
                        + '<td>' + supplier.supplierBank + '</td>'
                        + '<td>' + supplier.supplierAccount + '</td>'
                        + '<td>' + supplier.supplierNote + '</td>'
                        + '<td>' + supplier.supplierCreateTime + '</td>'
                        + '<td>' + supplier.supplierUpdateTime + '</td>'
                        + '<td class="td-manage"> <a title="编辑" href="javascript:;" id="row-edit' + supplier.supplierId + '" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> <a title="删除" href="javascript:;" id="row-del' + supplier.supplierId +'" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>'
                        + '</tr>';
                    $('#supplierTbody').append(tr);
                    $('a#row-edit' + supplier.supplierId).on("click",function () {
                        supplier_edit(supplier);
                    })
                    $('a#row-del' + supplier.supplierId).on("click",function () {
                        supplier_del(this,supplier.supplierId);
                    })
                })(suppliers[i])
            }
            supplierPage(total,pageNum,pageSize);
        }
    });
}
function supplierPage(total,pageNum,pageSize){
    console.log(total);
    console.log(pageNum);
    console.log(pageSize);
    layui.use(['laypage', 'layer'], function(){
        var laypage = layui.laypage,layer = layui.layer;

        //执行一个laypage实例
        laypage.render({
            elem: 'pageDiv', //注意，这里的 test1 是 ID，不用加 # 号
            count: total, //数据总数，从服务端得到
            limit: pageSize,//每页显示的条数。laypage将会借助 count 和 limit 计算出分页数。
            curr: pageNum,//当前页号
            limits: [6, 10, 15, 20],
            layout: ['limit', 'prev', 'page', 'next', 'skip', 'count'],//显示哪些分页组件
            jump: function (obj, first) {//点击页号的时候执行的函数
                //obj包含了当前分页的所有参数，比如：
                $("[name='pageNum']").val(obj.curr);//向隐藏域设置当前页的值
                $("[name='pageSize']").val(obj.limit);//向隐藏域设置当前页的大小
                if (!first) {//首次不执行(点击的时候才执行)
                    querysupplier();//执行查询分页函数(这个函数必须写在这里)
                }
            }
        });
    });
}
function queryTrainSchemeFYBtn() {
    $("[name='pageNum']").val("");//清空页号
    querysupplier();//分页查询课程信息
}



function supplier_add(title,url,w,h){
    layer_show(title,url,w,h);
}
function supplier_show(title,url,id,w,h){
    layer_show(title,url,w,h);
}

function supplier_edit(supplier){
    console.log(supplier);
    var title = "编辑";
    var url = "/supplier/supplier-edit.html";
    var w = 800;
    var h = 500;
    layer_show2(supplier,title,url,w,h);
}

function layer_show2(supplier,title,url,w,h){
    console.log(w);
    console.log(h);
    if (title == null || title == '') {
        title=false;
    };
    if (url == null || url == '') {
        url="404.html";
    };
    if (w == null || w == '') {
        w=800;
    };
    if (h == null || h == '') {
        h=($(window).height() - 50);
    };
    layer.open({
        type: 2,
        area: [w+'px', h +'px'],
        fix: false, //不固定
        maxmin: true,
        shade:0.4,
        title: title,
        content: url,
        success : function (layero,index) {
            console.log("呵呵");
            var iframeWin = window[layero.find("iframe")[0]['name']];
            var flag = iframeWin.renderSupplierData(supplier);
            console.log("成功");
            return flag;
        }
    });
}


function supplier_del(obj,id){
    layer.confirm('确认要删除吗？',function(index){
        console.log("id+"+id);
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/supplier/delete/' + id,
            dataType: 'json',
            success: function(data){
                $(obj).parents("tr").remove();
                layer.msg('已删除!',{icon:1,time:1000});
            },
            error:function(data) {
                console.log(data.msg);
            },
        });
    });
}