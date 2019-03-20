function queryCount(type) {
    var year = $("#year").val();
    var month = $("#month").val()
    if((month == "" || month == null) && year != null && year != ""){
        queryCountByYear(year,type)
    }
    if (month != null && month != "" && year != null && year != ""){
        queryCountByYearAndMonth(year,month,type);
    }
    
}
function queryCountByYear(year,type) {
    $.ajax({
        url : "http://localhost:8080/sale/count",
        type : "POST",
        data : {
            year : year
        },
        success : function (result) {
            var TPData = result.data;
            var categories = [];
            var total = [];
            var profit = [];
            for(var i = 1; i <= TPData.length; i++){
                var day = "" + i + "月";
                categories[i-1] = day;
                total[i-1] = TPData[i-1].total;
                profit[i-1] = TPData[i-1].profit;
            }
            if (type == "zhuzhuang") {
                queryByZhuzhuangtu(categories, total, profit);
            }
            if (type == "zhexian"){
                queryByLine(categories,total,profit);
            }
        },
        error : function () {
            layer.msg("服务器异常");
        }
    })
}


function queryCountByYearAndMonth(year,month,type) {
    $.ajax({
        url : "http://localhost:8080/sale/count",
        type : "POST",
        data : {
            year : year,
            month : month
        },
        success : function (result) {
            var TPData = result.data;
            var categories = [];
            var total = [];
            var profit = [];
            for(var i = 1; i <= TPData.length; i++){
                var day = "" + i + "号";
                categories[i-1] = day;
                total[i-1] = TPData[i-1].total;
                profit[i-1] = TPData[i-1].profit;
            }
            if (type == "zhuzhuang") {
                queryByZhuzhuangtu(categories, total, profit);
            }
            if (type == "zhexian"){
                queryByLine(categories,total,profit);
            }
        },
        error : function () {
            layer.msg("服务器异常");
        }
    })
}


function queryByLine(categories,total,profit) {
        Highcharts.chart('container', {
            title: {
                text: '销售情况',
                x: -20 //center
            },
            subtitle: {
            },
            xAxis: {
                categories: categories
            },
            yAxis: {
                title: {
                    text: '销售利润情况 (元)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: '元'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: '销售额',
                data: total
            }, {
                name: '利润',
                data: profit
            },
            ]
        });
}

function queryByZhuzhuangtu(categories,total,profit) {
    $('#container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '销售情况'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: categories
        },
        yAxis: {
            min: 0,
            title: {
                text: '销售利润统计'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} 元</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '销售额',
            data: total

        }, {
            name: '利润',
            data: profit
        }]
    });
}

function queryGoodsCount() {
    var year = $("#year").val();
    var month = $("#month").val();
    var goodsId = $("#goodsId").val();
    var type = "zhexian";
    if((month == "" || month == null) && year != null && year != ""){
        queryGoodsCountByYear(year,type,goodsId)
    }
    if (month != null && month != "" && year != null && year != ""){
        queryGoodsCountByYearAndMonth(year,month,type,goodsId);
    }

}
function queryGoodsCountByYear(year,type,goodsId) {
    $.ajax({
        url : "http://localhost:8080/sale/count/goods/" + goodsId,
        type : "GET",
        data : {
            year : year
        },
        success : function (result) {
            var TPData = result.data;
            var categories = [];
            var total = [];
            var profit = [];
            for(var i = 1; i <= TPData.length; i++){
                var day = "" + i + "月";
                categories[i-1] = day;
                total[i-1] = TPData[i-1].total;
                profit[i-1] = TPData[i-1].profit;
            }
            if (type == "zhuzhuang") {
                queryByZhuzhuangtu(categories, total, profit);
            }
            if (type == "zhexian"){
                queryByLine(categories,total,profit);
            }
        },
        error : function () {
            layer.msg("服务器异常");
        }
    })
}


function queryGoodsCountByYearAndMonth(year,month,type,goodsId) {
    $.ajax({
        url : "http://localhost:8080/sale/count/goods/" + goodsId,
        type : "GET",
        data : {
            year : year,
            month : month
        },
        success : function (result) {
            var TPData = result.data;
            var categories = [];
            var total = [];
            var profit = [];
            for(var i = 1; i <= TPData.length; i++){
                var day = "" + i + "号";
                categories[i-1] = day;
                total[i-1] = TPData[i-1].total;
                profit[i-1] = TPData[i-1].profit;
            }
            if (type == "zhuzhuang") {
                queryByZhuzhuangtu(categories, total, profit);
            }
            if (type == "zhexian"){
                queryByLine(categories,total,profit);
            }
        },
        error : function () {
            layer.msg("服务器异常");
        }
    })
}
