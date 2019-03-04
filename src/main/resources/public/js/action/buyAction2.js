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
                        for(var i = 0; i < buyorder.buydetails.length; i++){
                            totalNumber += parseInt(buyorder.buydetails[i].bdNumber);
                        }
                        var index = (pageNum - 1) * pageSize + i + 1;
                        var tr = '<tr>' + '<td>' + buyorder.boId + '</td>'
                            + '<td>' + buyorder.boBuyerName + '</td>'
                            + '<td>' + buyorder.buydetails.length  + '</td>'
                            + '<td>' + totalNumber + '</td>'
                            + '<td>' + buyorder.boTotal + '</td>'
                            + '<td>' + buyorder.boIsfinished + '</td>'
                            + '<td>' + buyorder.boDate + '</td>'
                            + '<td>' + buyorder.createTime + '</td>'
                            + '<td>' + buyorder.boNote + '</td>';
                        td =  '<td class="td-manage">' + '<a id="row-detail' + buyorder.boId + '" class="ml-5" title="详情">' +
                            '<i class="Hui-iconfont">&#xe716;</i></input> ';
                        tr = tr + td;
                        tr = tr +  '<a href="#" id="row-edit'  + buyorder.boId + '" class="ml-5" title="添加备注"' +
                            ' class="ml-5" style="text-decoration:none">' +
                            '<i class="Hui-iconfont">&#xe60c;</i></a> ';
                        tr = tr +  '<a href="#" id="row-delete' + buyorder.boId + '" class="ml-5" title="删除"' +
                            ' class="ml-5" style="text-decoration:none">' +
                            '<i class="Hui-iconfont">&#xe6e2;</i></a> ';
                        + '</tr>';
                        $('#buyorderTBody').append(tr);
                        $('a#row-edit' + buyorder.boId).on('click', function () {
                            buyorder_addNote(salerecord)
                        });
                        $('a#row-detail'+buyorder.boId).on('click',function () {
                            buyorder_detail(salerecord);
                        });
                    })(buyorders[i])
                }
                buyorderPage(total,pageNum,pageSize);
            }
        });
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
    layer_show2(title,url,w,h)
}

function layer_show2(title,url,w,h){
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