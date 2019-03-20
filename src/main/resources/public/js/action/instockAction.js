function queryinstock(){
    var pageNum = $("[name='pageNum']").val();
    var pageSize = $("[name='pageSize']").val();
    $.ajax({
        url : "http://localhost:8080/stock/inStock/to_list",
        type : "GET",
        data : {
            pageNum : pageNum,
            pageSize : pageSize,
            orderby : "instorage.is_time desc"
        },
        success : function (result) {
            var data = result.data;
            var total = data.total;
            var pageNum = data.pageNum;
            var pageSize = data.pageSize;//页大小
            var instocks = data.list;
            $('#instockTbody').html("");
            for(var i = 0, length_1 = instocks.length; i < length_1; i++){
                (function (instock) {
                    var index = (pageNum - 1) * pageSize + i + 1;
                    console.log(instock.goods);
                    var tr = '<tr>' + '<td>' + instock.isId + '</td>'
                        + '<td>' + instock.boId + '</td>'
                        + '<td>' + instock.goodsId  + '</td>'
                        + '<td>' + instock.goods.goodsName + '</td>'
                        + '<td>' + instock.goods.goodsSupplier + '</td>'
                        + '<td>' + instock.isNumber + '</td>'
                        + '<td>' + instock.isAfternumber + '</td>'
                        + '<td>' + instock.isOperatorName + '</td>'
                        + '<td>' + instock.isGoodsPrice + '</td>'
                        + '<td>' + instock.isGoodsTotal + '</td>'
                        + '<td>' + instock.isTime + '</td>'
                        + '<td>' + instock.isNote + '</td>';
                    tr = tr +  '<td><a href="#" id="row-edit' + instock.isId + '" class="row-delete" title="修改备注"' +
                        ' class="ml-5" style="text-decoration:none">' +
                        '<i class="Hui-iconfont">&#xe6df;</i></a> </td>'
                        + '</tr>';
                    $('#instockTbody').append(tr);
                    $('a#row-edit' + instock.isId).on('click', function () {
                        instock_edit(instock)
                    });
                })(instocks[i])
            }
            goodsPage(total,pageNum,pageSize);
        }
    });
}

function goodsPage(total,pageNum,pageSize){
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
                    queryinstock();//执行查询分页函数(这个函数必须写在这里)
                }
            }
        });
    });
}
function queryTrainSchemeFYBtn() {
    $("[name='pageNum']").val("");//清空页号
    queryinstock();//分页查询课程信息
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
    queryinstock();
}

function addInstock(){
    $.ajax({
        url : "http://localhost:8080/stock/inStock/add",
        type : "POST",
        data : {
            goodsId : $("#goodsId").val(),
            isNumber : $("#isNumber").val(),
            isGoodsPrice : $("#isGoodsPrice").val(),
            isNote : $("#isNote").val()
        },
        success: function(data){
            if (data.code != 0){
                layer.msg(data.msg,{icon:2,time:2000});
            } else {
                layer.msg('添加成功!',{icon:1,time:2000});
            }
        },
        error: function(XmlHttpRequest, textStatus, errorThrown){
            layer.msg('服务器异常!',{icon:2,time:1000});
        }
    })
}

function instock_add(){
    layer_show("添加入库","/stock/instock-add.html",600,500);
}
function instock_show(title,url,id,w,h){
    layer_show(title,url,w,h);
}

function instock_edit(instock) {
    var title = "编辑";
    var url = "/stock/instock-edit.html";
    var w = 800;
    var h = 500;
    layer_show3(instock,title,url,w,h);

}
function layer_show3(instock,title,url,w,h){
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
            var flag = iframeWin.renderInstockData(instock);
            console.log("成功");
            return flag;
        }
    });
}
