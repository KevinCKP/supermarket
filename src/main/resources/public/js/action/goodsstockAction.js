function querygoodsstock(){
    var pageNum = $("[name='pageNum']").val();
    var pageSize = $("[name='pageSize']").val();
    $.ajax({
        url : "http://localhost:8080/stock/to_list",
        type : "GET",
        data : {
            pageNum : pageNum,
            pageSize : pageSize,
            orderby : "goodsstock.goods_id"
        },
        success : function (result) {
            var data = result.data;
            var total = data.total;
            var pageNum = data.pageNum;
            var pageSize = data.pageSize;//页大小
            var goodsstocks = data.list;
            $('#goodsstockTbody').html("");
            for(var i = 0, length_1 = goodsstocks.length; i < length_1; i++){
                (function (goodsstock) {
                    var index = (pageNum - 1) * pageSize + i + 1;
                    console.log(goodsstock.goods);
                    var tr = '<tr>' + '<td>' + goodsstock.goods.goodsId + '</td>'
                        + '<td>' + goodsstock.goods.goodsName + '</td>'
                        + '<td>' + goodsstock.goods.goodsSupplier  + '</td>'
                        + '<td>' + goodsstock.goods.goodsBrand + '</td>';
                    if(goodsstock.goods.goodsState == 0){
                        tr += '<td>' + "已下架" + '</td>';
                    }
                    if(goodsstock.goods.goodsState == 1){
                        tr += '<td>' + "在售" + '</td>';
                    }
                    tr += '<td>' + goodsstock.gsNumber + '</td>'
                    + '<td>' + goodsstock.gsWarnnumber + '</td>'
                    + '<td>' + goodsstock.gsAddress + '</td>';
                    td =  '<td class="td-manage">' + '<a onclick="goods_stop(this,\'10001\')"  title="下架">' +
                        '<i class="Hui-iconfont">&#xe631;</i></input> ';
                    tr = tr + td;
                    tr = tr +  '<a href="#" id="row-edit' + goodsstock.gsId + '" class="row-edit" title="编辑"' +
                        ' class="ml-5" style="text-decoration:none">' +
                        '<i class="Hui-iconfont">&#xe6df;</i></a> '
                        + '</tr>';
                    $('#goodsstockTbody').append(tr);
                    $('a#row-edit' + goodsstock.gsId).on('click', function () {
                        goods_edit(goodsstock)
                    })
                })(goodsstocks[i])
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
                    querygoodsstock();//执行查询分页函数(这个函数必须写在这里)
                }
            }
        });
    });
}
function queryTrainSchemeFYBtn() {
    $("[name='pageNum']").val("");//清空页号
    querygoodsstock();//分页查询课程信息
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
    querygoodsstock();
}


function queryUnderWarning() {
    var pageNum = $("[name='pageNum']").val();
    var pageSize = $("[name='pageSize']").val();
    $.ajax({
        url : "http://localhost:8080/stock/underwarning/to_list",
        type : "GET",
        data : {
            pageNum : pageNum,
            pageSize : pageSize,
            orderby : "goodsstock.goods_id"
        },
        success : function (result) {
            var data = result.data;
            var total = data.total;
            var pageNum = data.pageNum;
            var pageSize = data.pageSize;//页大小
            var goodsstocks = data.list;
            $('#warngoodsTbody').html("");
            for(var i = 0, length_1 = goodsstocks.length; i < length_1; i++){
                (function (goodsstock) {
                    var index = (pageNum - 1) * pageSize + i + 1;
                    console.log(goodsstock.goods);
                    var tr = '<tr>' + '<td>' + goodsstock.goods.goodsId + '</td>'
                        + '<td>' + goodsstock.goods.goodsName + '</td>'
                        + '<td>' + goodsstock.goods.goodsSupplier  + '</td>'
                        + '<td>' + goodsstock.goods.goodsBrand + '</td>';
                    if(goodsstock.goods.goodsState == 0){
                        tr += '<td>' + "已下架" + '</td>';
                    }
                    if(goodsstock.goods.goodsState == 1){
                        tr += '<td>' + "在售" + '</td>';
                    }
                    tr += '<td>' + goodsstock.gsNumber + '</td>'
                        + '<td>' + goodsstock.gsWarnnumber + '</td>'
                        + '<td>' + goodsstock.gsAddress + '</td>';
                    td =  '<td class="td-manage">' + '<a href="#" id="row-cancel' + goodsstock.gsId +'" class="row-cancel"  title="取消预警">' +
                        '<i class="Hui-iconfont">&#xe631;</i></input> ';
                    tr = tr + td;
                    tr = tr +  '<a href="#" id="row-edit' + goodsstock.gsId + '" class="row-edit" title="修改预警"' +
                        ' class="ml-5" style="text-decoration:none">' +
                        '<i class="Hui-iconfont">&#xe6df;</i></a> '
                        + '</tr>';
                    $('#warngoodsTbody').append(tr);
                    $('a#row-edit' + goodsstock.gsId).on('click', function () {
                        warn_edit(goodsstock)
                    })

                    $('a#row-cancel' + goodsstock.gsId).on('click', function () {
                        warn_cancel(goodsstock)
                    })
                })(goodsstocks[i])
            }
            goodsPage3(total,pageNum,pageSize);
        }
    });
}

function querywarngoods() {
    var pageNum = $("[name='pageNum']").val();
    var pageSize = $("[name='pageSize']").val();
    $.ajax({
        url : "http://localhost:8080/stock/warning/to_list",
        type : "GET",
        data : {
            pageNum : pageNum,
            pageSize : pageSize,
            orderby : "goodsstock.goods_id"
        },
        success : function (result) {
            var data = result.data;
            var total = data.total;
            var pageNum = data.pageNum;
            var pageSize = data.pageSize;//页大小
            var goodsstocks = data.list;
            $('#warngoodsTbody').html("");
            for(var i = 0, length_1 = goodsstocks.length; i < length_1; i++){
                (function (goodsstock) {
                    var index = (pageNum - 1) * pageSize + i + 1;
                    console.log(goodsstock.goods);
                    var tr = '<tr>' + '<td>' + goodsstock.goods.goodsId + '</td>'
                        + '<td>' + goodsstock.goods.goodsName + '</td>'
                        + '<td>' + goodsstock.goods.goodsSupplier  + '</td>'
                        + '<td>' + goodsstock.goods.goodsBrand + '</td>';
                    if(goodsstock.goods.goodsState == 0){
                        tr += '<td>' + "已下架" + '</td>';
                    }
                    if(goodsstock.goods.goodsState == 1){
                        tr += '<td>' + "在售" + '</td>';
                    }
                    tr += '<td>' + goodsstock.gsNumber + '</td>'
                        + '<td>' + goodsstock.gsWarnnumber + '</td>'
                        + '<td>' + goodsstock.gsAddress + '</td>';
                    td =  '<td class="td-manage">' + '<a href="#" id="row-cancel' + goodsstock.gsId +'" class="row-cancel"  title="取消预警">' +
                        '<i class="Hui-iconfont">&#xe631;</i></input> ';
                    tr = tr + td;
                    tr = tr +  '<a href="#" id="row-edit' + goodsstock.gsId + '" class="row-edit" title="修改预警"' +
                        ' class="ml-5" style="text-decoration:none">' +
                        '<i class="Hui-iconfont">&#xe6df;</i></a> '
                        + '</tr>';
                    $('#warngoodsTbody').append(tr);
                    $('a#row-edit' + goodsstock.gsId).on('click', function () {
                        warn_edit(goodsstock)
                    })

                    $('a#row-cancel' + goodsstock.gsId).on('click', function () {
                        warn_cancel(goodsstock)
                    })
                })(goodsstocks[i])
            }
            goodsPage2(total,pageNum,pageSize);
        }
    });
}

function goodsPage2(total,pageNum,pageSize){
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
                    querywarngoods();//执行查询分页函数(这个函数必须写在这里)
                }
            }
        });
    });
}

function queryTrainSchemeFYBtn3() {
    $("[name='pageNum']").val("");//清空页号
    queryUnderWarning();//分页查询课程信息
}

/**
 * 清空查询条件的按钮
 * 1.清空所有的条件，包括隐藏域的条件，2.重新查询一次
 * @param obj   将清空条件按钮自己传下来
 */
function clearQueryCondition3(obj) {
    //1.清空条件
    var form = $(obj).parents("form");
    form.find("input").val("");
    form.find("select").val("");
    //2.重新查询一次
    queryUnderWarning();
}

function goodsPage3(total,pageNum,pageSize){
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
                    queryUnderWarning();//执行查询分页函数(这个函数必须写在这里)
                }
            }
        });
    });
}

function queryUponwarngoods(){
        var pageNum = $("[name='pageNum']").val();
        var pageSize = $("[name='pageSize']").val();
        $.ajax({
            url : "http://localhost:8080/stock/uponwarning/to_list",
            type : "GET",
            data : {
                pageNum : pageNum,
                pageSize : pageSize,
                orderby : "goodsstock.goods_id"
            },
            success : function (result) {
                var data = result.data;
                var total = data.total;
                var pageNum = data.pageNum;
                var pageSize = data.pageSize;//页大小
                var goodsstocks = data.list;
                $('#warngoodsTbody').html("");
                for(var i = 0, length_1 = goodsstocks.length; i < length_1; i++){
                    (function (goodsstock) {
                        var index = (pageNum - 1) * pageSize + i + 1;
                        console.log(goodsstock.goods);
                        var tr = '<tr>' + '<td>' + goodsstock.goods.goodsId + '</td>'
                            + '<td>' + goodsstock.goods.goodsName + '</td>'
                            + '<td>' + goodsstock.goods.goodsSupplier  + '</td>'
                            + '<td>' + goodsstock.goods.goodsBrand + '</td>';
                        if(goodsstock.goods.goodsState == 0){
                            tr += '<td>' + "已下架" + '</td>';
                        }
                        if(goodsstock.goods.goodsState == 1){
                            tr += '<td>' + "在售" + '</td>';
                        }
                        tr += '<td>' + goodsstock.gsNumber + '</td>'
                            + '<td>' + goodsstock.gsWarnnumber + '</td>'
                            + '<td>' + goodsstock.gsAddress + '</td>';
                        td =  '<td class="td-manage">' + '<a href="#" id="row-cancel' + goodsstock.gsId +'" class="row-cancel"  title="取消预警">' +
                            '<i class="Hui-iconfont">&#xe631;</i></input> ';
                        tr = tr + td;
                        tr = tr +  '<a href="#" id="row-edit' + goodsstock.gsId + '" class="row-edit" title="修改预警"' +
                            ' class="ml-5" style="text-decoration:none">' +
                            '<i class="Hui-iconfont">&#xe6df;</i></a> '
                            + '</tr>';
                        $('#warngoodsTbody').append(tr);
                        $('a#row-edit' + goodsstock.gsId).on('click', function () {
                            warn_edit(goodsstock)
                        })

                        $('a#row-cancel' + goodsstock.gsId).on('click', function () {
                            warn_cancel(goodsstock)
                        })
                    })(goodsstocks[i])
                }
                goodsPage4(total,pageNum,pageSize);
            }
        });
}

function goodsPage4(total,pageNum,pageSize){
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
                    queryUponwarngoods();//执行查询分页函数(这个函数必须写在这里)
                }
            }
        });
    });
}

function warn_cancel(goodsstock) {
    var gsWarnNumber = 2147483647;
    var msg = "确定要取消吗?";
    if (confirm(msg) == true){
        $.ajax({
            url : "http://localhost:8080/stock/warn/update",
            type : "POST",
            data : {
                goodsId : goodsstock.goodsId,
                gsWarnNumber : gsWarnNumber
            },
            success : function () {
                alert("取消成功");
                querywarngoods();
            }
        })
    }
}
function warn_edit(goodsstock) {
    var url = "/stock/stock-warn-update.html";
    layer_show2("编辑",url,800,500,goodsstock);
}
function layer_show2(title,url,w,h,goodsstock){
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
            var flag = iframeWin.renderGoodsstockData(goodsstock);
            console.log("成功");
            return flag;
        }
    });
}

function updateWarn() {
    $.ajax({
        url : "http://localhost:8080/stock/warn/update",
        type : "POST",
        data : {
            goodsId : $("#goodsId").val(),
            gsWarnNumber : $("#gsWarnnumber").val()
        },
        success : function () {
            alert("修改成功");
            querywarngoods();
        }
    })
}