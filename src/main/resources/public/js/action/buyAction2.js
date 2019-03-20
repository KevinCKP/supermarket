function querybuyorder() {
        var pageNum = $("[name='pageNum']").val();
        var pageSize = $("[name='pageSize']").val();
        $.ajax({
            url : "http://localhost:8080/buy/order/to_list",
            type : "GET",
            data : {
                pageNum : pageNum,
                pageSize : pageSize,
                orderby : "buyorder.bo_date desc"
            },
            success : function (result) {
                var data = result.data;
                var total = data.total;
                var pageNum = data.pageNum;
                var pageSize = data.pageSize;//页大小
                var buyorders = data.list;
                $('#buyorderTBody').html("");
                for(var i = 0, length_1 = buyorders.length; i < length_1; i++){
                    (function (buyorder) {
                        var totalNumber = 0;
                        var actualInNumber = 0;
                        for(var i = 0; i < buyorder.buydetails.length; i++){
                            totalNumber += parseInt(buyorder.buydetails[i].bdNumber)
                            actualInNumber += parseInt(buyorder.buydetails[i].bdInNumber);
                        }
                        var index = (pageNum - 1) * pageSize + i + 1;
                        var tr = '<tr>' + '<td>' + buyorder.boId + '</td>'
                            + '<td>' + buyorder.boBuyername + '</td>'
                            + '<td>' + buyorder.buydetails.length  + '</td>'
                            + '<td>' + totalNumber + '</td>'
                            + '<td>' + buyorder.boTotal + '</td>'
                            + '<td>' + actualInNumber + '</td>';
                        if(buyorder.boIsfinished == 1){
                            var td = '<td><select id="select' + buyorder.boId + '">' + '<option value="已完成" id="finish' + buyorder.boId + '" selected="selected">已完成</option>'
                                + '<option id="unfinish' + buyorder.boId + '" value="未完成">未完成</option></select></td>';
                            tr += td;
                        } else{
                            var td = '<td><select id="select' + buyorder.boId + '">' + '<option value="未完成" id="unfinish' + buyorder.boId + '" selected="selected">未完成</option>'
                                + '<option id="unfinish' + buyorder.boId + '" value="已完成">已完成</option></select></td>';
                            tr += td;
                        }

                           tr +=  '<td>' + buyorder.boDate + '</td>'
                            + '<td>' + buyorder.createTime + '</td>'
                            + '<td>' + buyorder.boNote + '</td>';
                        td =  '<td class="td-manage">' + '<a id="row-detail' + buyorder.boId + '" class="ml-5" title="详情">' +
                            '<i class="Hui-iconfont">&#xe716;</i></input> ';
                        tr = tr + td;
                        tr = tr +  '<a href="#" id="row-delete' + buyorder.boId + '" class="ml-5" title="删除"' +
                            ' class="ml-5" style="text-decoration:none">' +
                            '<i class="Hui-iconfont">&#xe6e2;</i></a></tr>';
                        $('#buyorderTBody').append(tr);
                        $('a#row-edit' + buyorder.boId).on('click', function () {
                            buyorder_addNote(buyorder)
                        });
                        $('a#row-detail'+buyorder.boId).on('click',function () {
                            buyorder_detail(buyorder);
                        });
                        $('a#row-delete'+buyorder.boId).on('click',function () {
                           deleteBuyorder(this,buyorder);
                        });
                    })(buyorders[i])
                }
                buyorderPage(total,pageNum,pageSize);
            }
        });
}
function deleteBuyorder(obj,buyorder) {
    layer.confirm("确认要删除吗?",function (index) {
        $.ajax({
            url : "http://localhost:8080/buy/order/delete",
            type : "POST",
            data : {
                boId : buyorder.boId
            },
            success : function (result) {
                if (result.code == 0){
                    layer.msg("删除成功");
                    $(obj).parents("tr").remove();
                } else{
                    layer.msg("不允许删除");
                }
            },
            error :function () {
                layer.msg("删除失败");
            }

        });
    })
}
function buyorderPage(total,pageNum,pageSize){
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
                    querybuyorder();//执行查询分页函数(这个函数必须写在这里)
                }
            }
        });
    });
}


function buyorder_add() {
    var url = "/buy/buyorder-add.html";
    var w = 800;
    var h = 500;
    var title = "添加";
    layer_show3(title,url,w,h)
}


function layer_show3(title,url,w,h){
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
    var index = layer.open({
        type: 2,
        area: [w+'px', h +'px'],
        fix: false, //不固定
        maxmin: true,
        shade:0.4,
        title: title,
        content: url,
    });
    layer.full(index);
}

function querygoods() {
    var goodsId = $("#queryGoodsId").val();
    $.ajax({
        url : "http://localhost:8080/goods/detail/"+goodsId,
        type : "GET",
        success : function (result) {
            var goods = result.data;
            var tr = '<tr><td>' + goods.goodsId + '</td>'
                    + '<td>' + goods.goodsName + '</td>'
                    + '<td>' + goods.goodsSupplier + '</td>'
                    + '<td>' + goods.goodsMetricunit + '</td>'
                    + '<td>' + goods.goodsBrand + '</td>'
                    + '<td><input type="text" value="0"  id="buyPrice' + goods.goodsId + '"/><input value="0" id="oldBuyPrice' + goods.goodsId + '" hidden/>' + '</td>'
                    + '<td><input type="text" value="0"  id="buyNumber' + goods.goodsId + '"/><input value="0" id="oldBuyNumber' + goods.goodsId + '" hidden />' + '</td>'
                    + '<td><input type="text"  disabled id="buyTotal' + goods.goodsId + '" value="0"/><input value="0" id="oldBuyTotal' + goods.goodsId + '" hidden/>' + '</td>'
                    + '<td><input type="text" id="note' + goods.goodsId + '">' + '</td>'
                    + '<td><a href="#" id="row-delete' + goods.goodsId + '" class="ml-5" title="删除"' +
                    ' class="ml-5" style="text-decoration:none">' +
                    '<i class="Hui-iconfont">&#xe6e2;</i></a></td></tr>';
            $("#buydetailTBody").append(tr);
            $('#buyPrice'+ goods.goodsId).on("change",function () {
                changeData(goods.goodsId);
            });
            $('#buyNumber'+ goods.goodsId).on("change",function () {
                changeData(goods.goodsId);
            });
            $('#row-delete'+goods.goodsId).on('click',function () {
                deleteGoods(this,goods.goodsId);
            });
            $("#goodszhonglei").val(parseInt($("#goodszhonglei").val())+1);
            $("#queryGoodsId").val("");
        }
    })
}
function changeData(goodsId) {
    var buyPrice = parseFloat($("#buyPrice" + goodsId).val());
    var buyNumber = parseInt($("#buyNumber" + goodsId).val());
    if(buyPrice ==0 || buyNumber ==0){
        $("#buyTotal"+goodsId).val("0");
    }
    else if(parseFloat(buyPrice) > 0 && parseInt(buyNumber) > 0){
        $("#buyTotal"+goodsId).val(parseFloat(buyPrice) * parseInt(buyNumber));
        updateBuyorderData(goodsId);
        $("#oldBuyPrice"+goodsId).val(buyPrice);
        $("#oldBuyNumber"+goodsId).val(buyNumber);
        var buyTotal = parseFloat($("#buyTotal" + goodsId).val());
        $("#oldBuyTotal"+goodsId).val(buyTotal);
        console.log($("#oldBuyPrice"+goodsId).val());
        console.log($("#oldBuyNumber"+goodsId).val());
        console.log(buyTotal);
    }
}
function deleteGoods(obj,goodsId){
    $("#goodsNumbers").val(parseInt($("#goodsNumbers").val()) - parseInt($("#oldBuyNumber"+goodsId).val()));
    $("#total").val(parseFloat($("#total").val()) - parseFloat($("#oldBuyTotal"+goodsId).val()));
    $(obj).parents("tr").remove();
    $("#goodszhonglei").val(parseInt($("#goodszhonglei").val())-1);
}
function updateBuyorderData(goodsId) {
    $("#goodsNumbers").val(parseInt($("#goodsNumbers").val()) - parseInt($("#oldBuyNumber"+goodsId).val()));
    $("#total").val(parseFloat($("#total").val()) - parseFloat($("#oldBuyTotal"+goodsId).val()));
    $("#goodsNumbers").val(parseInt($("#goodsNumbers").val()) + parseInt($("#buyNumber"+goodsId).val()));
    $("#total").val(parseFloat($("#total").val()) + parseFloat($("#buyTotal"+goodsId).val()));
}

function buyorder_save() {
    var buyorder = {};
    var buydetails = [];
    buyorder.boTotal = $("#total").val();
    buyorder.boIsfinished = 0;
    buyorder.boNote = $("#note").val();
    buyorder.boGoodsNumbers = $("#goodsNumbers").val();
    buyorder.boGoodsTypes = $("#goodszhonglei").val();
    buyorder.boDate = $("#boDate").val();
    var trList = $("#buydetailTBody").children("tr");
    for(var i = 0; i < trList.length; i++){
        var tdArr = trList.eq(i).find("td");
        var buydetail = {};
        buydetail.goodsId = tdArr.eq(0).text();
        buydetail.bdPrice = tdArr.eq(5).find("input").eq(0).val();
        buydetail.bdNumber = tdArr.eq(6).find("input").eq(0).val();
        buydetail.bdTotal = tdArr.eq(7).find("input").eq(0).val();
        buydetail.bdNote = tdArr.eq(8).find("input").eq(0).val();
        buydetail.bdState = 0;
        buydetails.push(buydetail);
    }
    buyorder.buydetails = buydetails;
    console.log(buydetails)
    $.ajax({
        url : "http://localhost:8080/buy/order/add",
        type : "POST",
        dataType: "json",
        contentType:"application/json",
        data : JSON.stringify(buyorder),
        success : function (result) {
            var buyorder = result.data;
            console.log(buyorder);
            layer.msg('添加成功!',{icon:1,time:1000});
        }
    })
}
function buyorder_detail(buyorder) {
    var url = "/buy/buyorder-detail.html";
    var w = 1000;
    var h = 700;
    var title = "详情";
    layer_show2(buyorder,title,url,w,h)
}


function layer_show2(buyorder,title,url,w,h){
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
            var flag = iframeWin.renderBuyorderDetailData(buyorder);
            console.log("成功");
            return flag;
        }
    });
}

function renderBuyorderDetailData(buyorder) {
    $('#buyorderTBody').html("");
    var actualInNumber = 0;
    for(var i = 0; i < buyorder.buydetails.length; i++){
        console.log(parseInt(buyorder.buydetails[i].bdInNumber));
        actualInNumber += parseInt(buyorder.buydetails[i].bdInNumber);
    }
    console.log(actualInNumber);
    var tr = '<tr>' + '<td>' + buyorder.boId + '</td>'
        + '<td>' + buyorder.boBuyername + '</td>'
        + '<td>' + buyorder.boGoodsTypes  + '</td>'
        + '<td>' + buyorder.boGoodsNumbers + '</td>'
        + '<td>' + buyorder.boTotal + '</td>'
        + '<td>' + actualInNumber + '</td>';
    if(buyorder.boIsfinished == 1){
        var td = '<td><select disabled="disabled" id="bo-select' + buyorder.boId + '">' + '<option value="已完成" id="finish' + buyorder.boId + '" selected="selected">已完成</option>'
            + '<option id="unfinish' + buyorder.boId + '" value="未完成">未完成</option></select></td>';
        tr += td;
    } else{
        var td = '<td><select id="bo-select' + buyorder.boId + '">' + '<option value="未完成" id="unfinish' + buyorder.boId + '" selected="selected">未完成</option>'
            + '<option id="unfinish' + buyorder.boId + '" value="已完成">已完成</option></select></td>';
        tr += td;
    }
        tr += '<td>' + buyorder.boDate + '</td>'
        + '<td>' + buyorder.createTime + '</td>'
        + '<td><input type="text" id="note' + buyorder.boId + '" value="' + buyorder.boNote + '">' + '</td>';
    tr += '<td><a href="#" id="bo-save'  + buyorder.boId + '" class="ml-5" title="保存"' +
        ' class="ml-5" style="text-decoration:none">' +
        '<i class="Hui-iconfont">&#xe632;</i></a></td></tr>';
    $('#buyorderTBody').append(tr);
    $('#note'+buyorder.boId).on("change",function () {
        buyorder.boNote = $("#note"+buyorder.boId).val();
        console.log(buyorder.boNote);
    });
    $('#bo-save'+buyorder.boId).on('click',function () {
        saveBuyorder(buyorder);
    });
    $('#bo-select'+buyorder.boId).change(function () {
        if ($(this).children('option:selected').val() == "未完成"){
            buyorder.boIsfinished = 0;
        } else{
            buyorder.boIsfinished = 1;
        }
    });
    $('#buydetailTBody').html("");
    for(var i = 0; i < buyorder.buydetails.length; i++){
        (function(buydetail) {
            var goods = buydetail.goods;
            var tr = '<tr>'
                + '<td >' + goods.goodsId + '</td>'
                + '<td>' + goods.goodsName + '</td>'
                + '<td>' + goods.goodsSupplier  + '</td>'
                + '<td>' + goods.goodsMetricunit + '</td>'
                + '<td>' + goods.goodsBrand + '</td>'
                + '<td>' + buydetail.bdPrice + '</td>'
                + '<td>' + buydetail.bdNumber + '</td>'
                + '<td>' + buydetail.bdTotal + '</td>'
                + '<td><input type="text" id="bdInNumber' + buydetail.bdId + '" value="' + buydetail.bdInNumber + '">' + '</td>';
            if (buydetail.bdState == 1) {
                var td = '<td><select disabled="disabled" id="select'  + buydetail.bdId + '">' + '<option value="已完成" id="finish' + buydetail.bdId + '" selected="selected">已完成</option>'
                    + '<option id="unfinish' + buydetail.bdId + '" value="未完成">未完成</option></select></td>';
                tr += td;
            } else {
                var td = '<td><select id="select' + buydetail.bdId + '">' + '<option id="unfinish' + buydetail.bdId + '" value="未完成" selected="selected">未完成</option>'
                    + '<option id="finish' + buydetail.bdId + '" value="完成">完成</option></select></td>';
                tr += td;
            }
            tr += '<td><a href="#" id="row-save'  + buydetail.bdId + '" class="ml-5" title="保存"' +
                ' class="ml-5" style="text-decoration:none">' +
                '<i class="Hui-iconfont">&#xe632;</i></a></td></tr>';
            $('#buydetailTBody').append(tr);
            $('#row-save'+buydetail.bdId).on("click",function () {
                buydetail_save(buydetail);
            });
            $('#bdInNumber'+buydetail.bdId).on("change",function () {
                inNumber_change(buydetail);
            });
            $('#select'+buydetail.bdId).change(function () {
                if ($(this).children('option:selected').val() == "未完成"){
                    buydetail.bdState = 0;
                } else{
                    buydetail.bdState = 1;
                }
            });
        })(buyorder.buydetails[i]);
    }
}
function saveBuyorder(buyorder) {
    $.ajax({
        url : "http://localhost:8080/buy/order/update",
        type : "POST",
        dataType: "json",
        contentType:"application/json",
        data : JSON.stringify(buyorder),
        success : function (result) {
            if (result.code == 0){
                layer.msg("修改成功");
            }else{
                layer.msg("已完成的订单不允许修改");
            }
        },
        error : function () {
            layer.msg("服务器异常");
        }
    })

}
function inNumber_change(buydetail) {
    buydetail.bdInNumber = $("#bdInNumber"+buydetail.bdId).val();
    console.log(buydetail);
}
function buydetail_save(buydetail) {
    $.ajax({
        url : "http://localhost:8080/buy/order/detail/update",
        type : "POST",
        dataType: "json",
        contentType:"application/json",
        data : JSON.stringify(buydetail),
        success : function (result) {
            if (result.code == 0) {
                layer.msg("修改成功");
            } else {
                layer.msg("修改失败");
            }
        },
        error : function () {
            layer.msg("服务器异常");
        }
    })

}
function querybuyorderByFactor() {
    var pageNum = $("[name='pageNum']").val();
    var pageSize = $("[name='pageSize']").val();
    $.ajax({
        url : "http://localhost:8080/buy/order/to_list2",
        type : "GET",
        data : {
            pageNum : pageNum,
            pageSize : pageSize,
            beginTime : $("#beginTime").val(),
            endTime : $("#endTime").val(),
            factor : $("#factor").val(),
            orderby : "buyorder.bo_date desc"
        },
        success : function (result) {
            var data = result.data;
            var total = data.total;
            var pageNum = data.pageNum;
            var pageSize = data.pageSize;//页大小
            var buyorders = data.list;
            $('#buyorderTBody').html("");
            for(var i = 0, length_1 = buyorders.length; i < length_1; i++){
                (function (buyorder) {
                    var totalNumber = 0;
                    var actualInNumber = 0;
                    for(var i = 0; i < buyorder.buydetails.length; i++){
                        totalNumber += parseInt(buyorder.buydetails[i].bdNumber)
                        actualInNumber += parseInt(buyorder.buydetails[i].bdInNumber);
                    }
                    var index = (pageNum - 1) * pageSize + i + 1;
                    var tr = '<tr>' + '<td>' + buyorder.boId + '</td>'
                        + '<td>' + buyorder.boBuyername + '</td>'
                        + '<td>' + buyorder.buydetails.length  + '</td>'
                        + '<td>' + totalNumber + '</td>'
                        + '<td>' + buyorder.boTotal + '</td>'
                        + '<td>' + actualInNumber + '</td>';
                    if(buyorder.boIsfinished == 1){
                        var td = '<td><select id="select' + buyorder.boId + '">' + '<option value="已完成" id="finish' + buyorder.boId + '" selected="selected">已完成</option>'
                            + '<option id="unfinish' + buyorder.boId + '" value="未完成">未完成</option></select></td>';
                        tr += td;
                    } else{
                        var td = '<td><select id="select' + buyorder.boId + '">' + '<option value="未完成" id="unfinish' + buyorder.boId + '" selected="selected">未完成</option>'
                            + '<option id="unfinish' + buyorder.boId + '" value="已完成">已完成</option></select></td>';
                        tr += td;
                    }

                    tr +=  '<td>' + buyorder.boDate + '</td>'
                        + '<td>' + buyorder.createTime + '</td>'
                        + '<td>' + buyorder.boNote + '</td>';
                    td =  '<td class="td-manage">' + '<a id="row-detail' + buyorder.boId + '" class="ml-5" title="详情">' +
                        '<i class="Hui-iconfont">&#xe716;</i></input> ';
                    tr = tr + td;
                    tr = tr +  '<a href="#" id="row-delete' + buyorder.boId + '" class="ml-5" title="删除"' +
                        ' class="ml-5" style="text-decoration:none">' +
                        '<i class="Hui-iconfont">&#xe6e2;</i></a></tr>';
                    $('#buyorderTBody').append(tr);
                    $('a#row-edit' + buyorder.boId).on('click', function () {
                        buyorder_addNote(buyorder)
                    });
                    $('a#row-detail'+buyorder.boId).on('click',function () {
                        buyorder_detail(buyorder);
                    });
                    $('a#row-delete'+buyorder.boId).on('click',function () {
                        deleteBuyorder(this,buyorder);
                    });
                })(buyorders[i])
            }
            buyorderPage2(total,pageNum,pageSize);
        }
    });
}
function buyorderPage2(total,pageNum,pageSize){
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
                    querybuyorderByFactor();//执行查询分页函数(这个函数必须写在这里)
                }
            }
        });
    });
}