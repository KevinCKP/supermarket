$(function () {
    $()
})
function addGoods(){
    $.ajax({
        type : "POST",
        url : "http://localhost:8080/goods/add",
        data : {
            goodsId : $('#goodsId').val(),
            categoryId : $('#categoryId').val(),
            supplierId : $('#supplierId').val(),
            goodsName : $('#goodsName').val(),
            goodsBarcode : $('#goodsBarcode').val(),
            goodsSaleprice : $('#goodsSaleprice').val(),
            goodsSpecification : $('#goodsSpecification').val(),
            goodsMetricUnit : $('#goodsMetricUnit').val(),
            goodsBuyprice : $('#goodsBuyprice').val(),
            goodsMemprice : $('#goodsMemprice').val(),
            goodsDescription : $('#goodsDescription').val(),
            goodsProduceplace : $('#goodsProduceplace').val(),
            goodsCategory : $('#goodsCategory').val(),
            goodsSupplier : $('#goodsSupplier').val(),
            goodsMaterial : $('#goodsMaterial').val(),
            goodsBrand : $('#goodsBrand').val(),
            goodsState : 1
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
function updateGoods(){
    var msg = "你确定要修改吗?";
    if(confirm(msg) == false){
        return;
    } else{
        $.ajax({
            type : "POST",
            url : "http://localhost:8080/goods/update",
            data : {
                goodsId : $('#goodsId').val(),
                categoryId : $('#categoryId').val(),
                supplierId : $('#supplierId').val(),
                goodsName : $('#goodsName').val(),
                goodsBarcode : $('#goodsBarcode').val(),
                goodsSaleprice : $('#goodsSaleprice').val(),
                goodsSpecification : $('#goodsSpecification').val(),
                goodsMetricUnit : $('#goodsMetricUnit').val(),
                goodsBuyprice : $('#goodsBuyprice').val(),
                goodsMemprice : $('#goodsMemprice').val(),
                goodsDescription : $('#goodsDescription').val(),
                goodsProduceplace : $('#goodsProduceplace').val(),
                goodsCategory : $('#goodsCategory').val(),
                goodsSupplier : $('#goodsSupplier').val(),
                goodsMaterial : $('#goodsMaterial').val(),
                goodsBrand : $('#goodsBrand').val(),
                goodsState : $('#goodsState').val()
            },
            success : function (data){
                if (data.code != 0){
                    layer.msg(data.msg,{icon:2,time:2000});
                } else {
                    alert("修改成功");
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    parent.querygoods();
                }
            },
            error : function () {
                layer.msg('服务器异常',{icon:2,time:2000});
            }
        })
    }


};
function updateGoodsState(){
    var goodsState = $('#goodsState').val();
    $.ajax({
        type : "POST",
        url : "http://localhost:8080/goods/update",
        data : {
            goodsId : $('#goodsId').val(),
            goodsState : goodsState
        },
        success : function (data){
            if (data.code != 0){
                layer.msg(data.msg,{icon:2,time:2000});
            } else {
                if (goodsState == 0){
                    layer.msg("已下架",{icon:1,time:2000});
                } else{
                    layer.msg("已上架",{icon:1,time:2000});
                }
            }
        },
        error : function () {
            layer.msg('服务器异常',{icon:2,time:2000});
        }
    })
};

function getGoodsById(){
    var goodsId = $('#goodsId').val();
    $.ajax({
        type : "GET",
        url : "http:localhost:8080/goods/detail/" + goodsId,
        success : function (data) {
            if (data.code != 0){

            } else {

            }
        },
        error :function () {
            alert("服务器异常");
        }
    })
}

// 条件查询
function getGoodsListByFactors(){

}

function querygoods(){
    var pageNum = $("[name='pageNum']").val();
    var pageSize = $("[name='pageSize']").val();
    $.ajax({
        url : "http://localhost:8080/goods/to_list",
        type : "GET",
        data : {
            pageNum : pageNum,
            pageSize : pageSize,
            orderby : "goods_id"
        },
        success : function (result) {
            var data = result.data;
            var total = data.total;
            var pageNum = data.pageNum;
            var pageSize = data.pageSize;//页大小
            var goodss = data.list;
            $('#goodsTbody').html("");
            for(var i = 0, length_1 = goodss.length; i < length_1; i++){
                (function (goods) {
                    var index = (pageNum - 1) * pageSize + i + 1;
                    var goodsId = goods.goodsId;
                    console.log("for" + goodsId);
                    var tr = '<tr><td><input type="checkbox" value="" name=""></td>'
                        + '<td >' + goods.goodsId + '</td>'
                        + '<td>' + goods.goodsName + '</td>'
                        + '<td>' + goods.goodsSupplier  + '</td>'
                        + '<td>' + goods.goodsSpecification + '</td>'
                        + '<td>' + goods.goodsMetricunit + '</td>'
                        + '<td>' + goods.goodsProduceplace + '</td>'
                        + '<td>' + goods.goodsMaterial + '</td>'
                        + '<td>' + goods.goodsBrand + '</td>'
                        + '<td>' + goods.goodsBuyprice + '</td>'
                        + '<td>' + goods.goodsSaleprice + '</td>'
                        + '<td>' + goods.goodsMemprice + '</td>'
                        + '<td>' + goods.goodsBarcode + '</td>'
                        + '<td>' + goods.goodsCreateTime + '</td>'
                        + '<td>' + goods.goodsUpdateTime + '</td>';
                    if(goods.goodsState == 1){
                        td = '<td class="td-status"><span class="label label-success radius">在售</span></td>';
                        tr += td;
                        td =  '<td class="td-manage">' + '<a id="row-stop' + goodsId + '"  title="下架">' +
                            '<i class="Hui-iconfont">&#xe631;</i></a>';
                        tr = tr + td;
                    }
                    if(goods.goodsState == 0){
                        td = '<td class="td-status"><span class="label label-fail radius">已下架</span></td>';
                        tr += td;
                        td = '<td class="td-manage"><a style="text-decoration:none" href="javascript:;" id="row-sale' + goodsId + '" title="出售">' +
                            '<i class="Hui-iconfont">&#xe603;</i></a>';
                        tr += td;
                    }
                    tr = tr +  '<a href="#" id="row-edit' + goodsId + '" class="row-edit" title="编辑"' +
                        ' class="ml-5" style="text-decoration:none">' +
                        '<i class="Hui-iconfont">&#xe6df;</i></a></td> '
                        + '</tr>';
                    $('#goodsTbody').append(tr);
                    $('a#row-edit' + goodsId).on('click', function () {
                        goods_edit(goods)
                    });
                    $('a#row-stop'+goodsId).on('click',function () {
                        goods_stop(goodsId);
                    })
                })(goodss[i])
            }
            goodsPage(total,pageNum,pageSize);
        }
    });
}

function goodsPage(total,pageNum,pageSize) {
    layui.use(['laypage', 'layer'], function () {
        var laypage = layui.laypage, layer = layui.layer;

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
                    querygoods();//执行查询分页函数(这个函数必须写在这里)
                }
            }
        });
    });
}

    function querygoods2(){
        var pageNum = $("[name='pageNum']").val();
        var pageSize = $("[name='pageSize']").val();
        console.log($("#startTime").val());
        $.ajax({
            url : "http://localhost:8080/goods/to_list2",
            type : "GET",
            data : {
                pageNum : pageNum,
                pageSize : pageSize,
                orderby : "goods_id",
                beginTime : $("#beginTime").val(),
                endTime : $("#endTime").val(),
                factor : $("#factor").val()
            },
            success : function (result) {
                var data = result.data;
                var total = data.total;
                var pageNum = data.pageNum;
                var pageSize = data.pageSize;//页大小
                var goodss = data.list;
                $('#goodsTbody').html("");
                for(var i = 0, length_1 = goodss.length; i < length_1; i++){
                    (function (goods) {
                        var index = (pageNum - 1) * pageSize + i + 1;
                        var goodsId = goods.goodsId;
                        console.log("for" + goodsId);
                        var tr = '<tr><td><input type="checkbox" value="" name=""></td>'
                            + '<td >' + goods.goodsId + '</td>'
                            + '<td>' + goods.goodsName + '</td>'
                            + '<td>' + goods.goodsSupplier  + '</td>'
                            + '<td>' + goods.goodsSpecification + '</td>'
                            + '<td>' + goods.goodsMetricunit + '</td>'
                            + '<td>' + goods.goodsProduceplace + '</td>'
                            + '<td>' + goods.goodsMaterial + '</td>'
                            + '<td>' + goods.goodsBrand + '</td>'
                            + '<td>' + goods.goodsBuyprice + '</td>'
                            + '<td>' + goods.goodsSaleprice + '</td>'
                            + '<td>' + goods.goodsMemprice + '</td>'
                            + '<td>' + goods.goodsBarcode + '</td>'
                            + '<td>' + goods.goodsCreateTime + '</td>'
                            + '<td>' + goods.goodsUpdateTime + '</td>';
                        if(goods.goodsState == 0){
                            tr += '<td>' + "已下架" + '</td>';
                        }
                        if(goods.goodsState == 1){
                            tr += '<td>' + "在售" + '</td>';
                        }
                        td =  '<td class="td-manage">' + '<a id="row-stop' + goodsId + '"  title="下架">' +
                            '<i class="Hui-iconfont">&#xe631;</i></a> ';
                        tr = tr + td;
                        tr = tr +  '<a href="#" id="row-edit' + goodsId + '" class="row-edit" title="编辑"' +
                            ' class="ml-5" style="text-decoration:none">' +
                            '<i class="Hui-iconfont">&#xe6df;</i></a>'
                            + '</tr>';
                        $('#goodsTbody').append(tr);
                        $('a#row-edit' + goodsId).on('click', function () {
                            goods_edit(goods)
                        });
                        $('a#row-stop'+goodsId).on('click',function () {
                            goods_stop(goodsId);
                        })
                    })(goodss[i])
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

                            $("[name='pageNum']").val(obj.curr);//向隐藏域设置当前页的值
                            $("[name='pageSize']").val(obj.limit);//向隐藏域设置当前页的大小
                            if (!first) {//首次不执行(点击的时候才执行)
                                querygoods2();//执行查询分页函数(这个函数必须写在这里)
                            }
                        }
                    });
                });
            }
        });
    }
function queryTrainSchemeFYBtn() {
    $("[name='pageNum']").val("");//清空页号
    querygoods();//分页查询课程信息
}

/**
 * 清空查询条件的按钮
 * 1.清空所有的条件，包括隐藏域的条件，2.重新查询一次
 * @param obj   将清空条件按钮自己传下来
 */
function clearQueryCondition(obj) {
    //1.清空条件
    var form = $(obj).parents("form");
    form.find("input").val("");
    form.find("select").val("");
    //2.重新查询一次
    querygoods();
}

/*员工-添加*/
function goods_add(title,url,w,h){
    layer_show(title,url,w,h);
}
/*员工-编辑*/
function goods_edit(goods){
    console.log(1);
    console.log(goods);
    console.log("Test");
    var url = "/goods/goods-edit.html";
    layer_show2("编辑",url,800,500,goods);
}
function layer_show2(title,url,w,h,goods){
    if (title == null || title == '') {
        title=false;
    }
    if (url == null || url == '') {
        url="404.html";
    }
    if (w == null || w == '') {
        w=800;
    }
    if (h == null || h == '') {
        h=($(window).height() - 50);
    }
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
            var flag = iframeWin.renderGoodsData(goods);
            console.log("成功");
            return flag;
        }
    });
}
function goods_stop(goodsId) {
    layer.confirm('确认要下架吗？',function(index){
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/goods/changeState/' + goodsId,
            data : {
                goodsState : 0
            },
            dataType: 'json',
            success: function(data){
                layer.msg('已下架!',{icon:1,time:1000});
                querygoods();
            },
            error:function(data) {
                console.log(data.msg);
            },
        });
    });

}