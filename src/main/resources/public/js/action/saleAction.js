// 输入商品id后显示商品信息
function saleQueryGoods(){
    var goodsId = $('#goodsId').val();
    $.ajax({
        type : "GET",
        url : "http://localhost:8080/goods/detail/" + goodsId,
        success : function (result) {
            // 在table中显示多一行数据
            // 每次添加后，总价格要改变
            var goods = result.data;
            if (goods != null){
                var tr = '<tr>'
                    + '<td>' + goods.goodsId + '</td>'
                    + '<td>' + goods.goodsName + '</td>'
                    + '<td>' + goods.goodsBrand  + '</td>'
                    + '<td>' + goods.goodsMetricunit + '</td>'
                    + '<td>' + goods.goodsSaleprice + '</td>'
                    + '<td>' + goods.goodsMemprice + '</td>'
                    + '<td>' + '<input type="text" value="1" class="goodsNumber" id="goodsNumber'  + goods.goodsId +'"/>' + '</td>'
                    + '<td>' + '<input type="text" class="goodsTotal" id="goodsTotal' + goods.goodsId +'"  disabled/>' + '</td></tr>>';
                $("#saleTbody").append(tr);
                var oldGoodsNumbers = $("#goodsNumbers").val();
                $("#goodsTotal" + goods.goodsId).val(goods.goodsSaleprice);
                $("#goodsNumbers").val(parseInt(oldGoodsNumbers)+1);
                $("#total").val(parseFloat($("#total").val()) + parseFloat(goods.goodsSaleprice));
                $("#goodsId").val("");
                $('#goodsNumber' + goodsId).on('change', function () {
                    changeGoodsNumber(goods)
                })
            } else {
                alert("没有此商品");
            }
        },
        error : function () {

        }
    })
}

function sale(){
    var salerecord = {};
    var saledetails = [];
    salerecord.srTotal = $("#total").val();
    salerecord.srNumber = $("#goodsNumbers").val();
    salerecord.srActualcharge = $("#actual").val();
    salerecord.srChange = $("#change").val();
    var trList = $("#saleTbody").children("tr");
    for(var i = 0; i < trList.length; i++){
        var tdArr = trList.eq(i).find("td");
        var saledetail = {};
        saledetail.goodsId = tdArr.eq(0).text();
        saledetail.sdPrice = tdArr.eq(4).text();
        saledetail.sdNumber = tdArr.eq(6).find("input").val();
        saledetail.sdTotal = tdArr.eq(7).find("input").val();
        saledetails.push(saledetail);
    }
    salerecord.saledetails = saledetails;
    console.log(saledetails)
    $.ajax({
        url : "http://localhost:8080/sale/add",
        type : "POST",
        dataType: "json",
        contentType:"application/json",
        data : JSON.stringify(salerecord),


        success : function (result) {
            var salerecord = result.data;
            console.log(salerecord);
            layer.msg('销售成功!',{icon:1,time:1000});
            clear();
        }
    })
}
function clear() {
    $("#saleTbody").html("");
    $("#total").val("");
    $("#goodsNumbers").val("");
    $("#actual").val();
    $("#change").val();
}

function charge() {
    var total = $("#total").val();
    var charge = $("#actual").val();
    if(parseFloat(charge) >= parseFloat(total)){
        var change = parseFloat(charge) - parseFloat(total);
        $("#change").val(change);
    }
    else {
        alert("实收数额不对");
    }
}

function changeGoodsNumber(goods){
    console.log(goods)
    if($("#goodsNumber"+goods.goodsId).val() != null && parseInt($("#goodsNumber"+goods.goodsId).val()) > 0){
        $("#goodsTotal"+goods.goodsId).val(parseInt($("#goodsNumber"+goods.goodsId).val()) * parseFloat(goods.goodsSaleprice));
        $("#goodsNumbers").val("0");
        $("#total").val("0");
        $(".goodsNumber").each(function () {
            console.log($(this).val());
            $("#goodsNumbers").val(parseInt($("#goodsNumbers").val()) + parseInt($(this).val()));
        })
        $(".goodsTotal").each(function () {
            $("#total").val(parseFloat($("#total").val()) + parseFloat($(this).val()));
        })
    } else {
        alert("输入错误");
    }
}



function querysalerecord(){
    var pageNum = $("[name='pageNum']").val();
    var pageSize = $("[name='pageSize']").val();
    $.ajax({
        url : "http://localhost:8080/sale/to_list",
        type : "GET",
        data : {
            pageNum : pageNum,
            pageSize : pageSize,
            orderby : "salerecord.sr_date desc"
        },
        success : function (result) {
            var data = result.data;
            var total = data.total;
            var pageNum = data.pageNum;
            var pageSize = data.pageSize;//页大小
            var salerecords = data.list;
            $('#salerecordTbody').html("");
            for(var i = 0, length_1 = salerecords.length; i < length_1; i++){
                (function (salerecord) {
                    var index = (pageNum - 1) * pageSize + i + 1;
                    console.log(salerecord.goods);
                    var tr = '<tr>' + '<td>' + salerecord.srId + '</td>'
                        + '<td>' + salerecord.srSalesman + '</td>'
                        + '<td>' + salerecord.srTotal  + '</td>'
                        + '<td>' + salerecord.srActualcharge + '</td>'
                        + '<td>' + salerecord.srChange + '</td>'
                        + '<td>' + salerecord.srProfit + '</td>'
                        + '<td>' + salerecord.srNumber + '</td>'
                        + '<td>' + salerecord.srDate + '</td>'
                        + '<td>' + salerecord.srNote + '</td>';
                    td =  '<td class="td-manage">' + '<a id="row-detail' + salerecord.srId + '" class="ml-5" title="详情">' +
                        '<i class="Hui-iconfont">&#xe716;</i></input> ';
                    tr = tr + td;
                    tr = tr +  '<a href="#" id="row-edit'  + salerecord.srId + '" class="ml-5" title="添加备注"' +
                        ' class="ml-5" style="text-decoration:none">' +
                        '<i class="Hui-iconfont">&#xe60c;</i></a> ';
                    tr = tr +  '<a href="#" id="row-delete' + salerecord.srId + '" class="ml-5" title="删除"' +
                        ' class="ml-5" style="text-decoration:none">' +
                        '<i class="Hui-iconfont">&#xe6e2;</i></a> ';
                        + '</tr>';
                    $('#salerecordTbody').append(tr);
                    $('a#row-edit' + salerecord.srId).on('click', function () {
                        salerecord_addNote(salerecord)
                    });
                    $('a#row-detail'+salerecord.srId).on('click',function () {
                       salerecord_detail(salerecord);
                    });
                })(salerecords[i])
            }
            goodsPage(total,pageNum,pageSize);
        }
    });
}
function querysalerecordByFactor() {
    var pageNum = $("[name='pageNum']").val();
    var pageSize = $("[name='pageSize']").val();
    $.ajax({
        url : "http://localhost:8080/sale/to_list2",
        type : "GET",
        data : {
            pageNum : pageNum,
            pageSize : pageSize,
            orderby : "salerecord.sr_date desc",
            beginTime : $("#beginTime").val(),
            endTime : $("#endTime").val(),
            factor : $("#factor").val()
        },
        success : function (result) {
            var data = result.data;
            var total = data.total;
            var pageNum = data.pageNum;
            var pageSize = data.pageSize;//页大小
            var salerecords = data.list;
            $('#salerecordTbody').html("");
            for(var i = 0, length_1 = salerecords.length; i < length_1; i++){
                (function (salerecord) {
                    var index = (pageNum - 1) * pageSize + i + 1;
                    console.log(salerecord.goods);
                    var tr = '<tr>' + '<td>' + salerecord.srId + '</td>'
                        + '<td>' + salerecord.srSalesman + '</td>'
                        + '<td>' + salerecord.srTotal  + '</td>'
                        + '<td>' + salerecord.srActualcharge + '</td>'
                        + '<td>' + salerecord.srChange + '</td>'
                        + '<td>' + salerecord.srProfit + '</td>'
                        + '<td>' + salerecord.srNumber + '</td>'
                        + '<td>' + salerecord.srDate + '</td>'
                        + '<td>' + salerecord.srNote + '</td>';
                    td =  '<td class="td-manage">' + '<a id="row-detail' + salerecord.srId + '" class="ml-5" title="详情">' +
                        '<i class="Hui-iconfont">&#xe716;</i></input> ';
                    tr = tr + td;
                    tr = tr +  '<a href="#" id="row-edit'  + salerecord.srId + '" class="ml-5" title="添加备注"' +
                        ' class="ml-5" style="text-decoration:none">' +
                        '<i class="Hui-iconfont">&#xe60c;</i></a> ';
                    tr = tr +  '<a href="#" id="row-delete' + salerecord.srId + '" class="ml-5" title="删除"' +
                        ' class="ml-5" style="text-decoration:none">' +
                        '<i class="Hui-iconfont">&#xe6e2;</i></a> ';
                    + '</tr>';
                    $('#salerecordTbody').append(tr);
                    $('a#row-edit' + salerecord.srId).on('click', function () {
                        salerecord_addNote(salerecord)
                    });
                    $('a#row-detail'+salerecord.srId).on('click',function () {
                        salerecord_detail(salerecord);
                    });
                })(salerecords[i])
            }
            goodsPage2(total,pageNum,pageSize);
        }
    });

}
function salerecord_detail(salerecord) {
    var url = "/sale/saledetail.html";
    var w = 800;
    var h = 500;
    var title = "详情";
    layer_show2(salerecord,title,url,w,h)
}

function layer_show2(salerecord,title,url,w,h){
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
            var flag = iframeWin.renderSalerecordDetailData(salerecord);
            console.log("成功");
            return flag;
        }
    });
}

function renderSalerecordDetailData(salerecord) {
    $('#salerecordTbody').html("");
    var tr = '<tr>' + '<td>' + salerecord.srId + '</td>'
        + '<td>' + salerecord.srSalesman + '</td>'
        + '<td>' + salerecord.srTotal  + '</td>'
        + '<td>' + salerecord.srActualcharge + '</td>'
        + '<td>' + salerecord.srChange + '</td>'
        + '<td>' + salerecord.srProfit + '</td>'
        + '<td>' + salerecord.srNumber + '</td>'
        + '<td>' + salerecord.srDate + '</td>'
        + '<td>' + salerecord.srNote + '</td>';
    $('#salerecordTbody').append(tr);
    $('#saledetailTBody').html("");
    for(var i = 0; i < salerecord.saledetails.length; i++){
        var saledetail = salerecord.saledetails[i];
        var goods = saledetail.goods;
        var tr = '<tr>'
            + '<td >' + goods.goodsId + '</td>'
            + '<td>' + goods.goodsName + '</td>'
            + '<td>' + goods.goodsSupplier  + '</td>'
            + '<td>' + goods.goodsMetricunit + '</td>'
            + '<td>' + goods.goodsBrand + '</td>'
            + '<td>' + goods.goodsBuyprice + '</td>'
            + '<td>' + goods.goodsSaleprice + '</td>'
            + '<td>' + saledetail.sdNumber + '</td>'
            + '<td>' + saledetail.sdTotal + '</td>'
            + '<td>' + saledetail.sdProfit + '</td></tr>';
        $('#saledetailTBody').append(tr);
    }
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
                    querysalerecord();//执行查询分页函数(这个函数必须写在这里)
                }
            }
        });
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
                    querysalerecordByFactor();//执行查询分页函数(这个函数必须写在这里)
                }
            }
        });
    });
}
function queryTrainSchemeFYBtn() {
    $("[name='pageNum']").val("");//清空页号
    querysalerecord();//分页查询课程信息
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
    querysalerecord();
}