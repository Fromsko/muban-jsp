// admin_kanban.js
function refreshChartData(getTotal) {
    // 获取数据并渲染图表
    getTotal().then(response => {
        let {timeList, valueList} = response;

        // 配置 ECharts 图表
        let option = {
            xAxis: {
                type: 'category', data: timeList
            }, yAxis: {
                type: 'value'
            }, series: [{
                data: valueList, type: 'line', smooth: true, lineStyle: {
                    color: '#4C51BF', width: 3
                }, itemStyle: {
                    color: '#4C51BF',
                }
            }]
        };

        // 初始化 ECharts 图表
        let myChart = echarts.init(document.getElementById('main'));
        myChart.setOption(option);
    }).catch(error => {
        console.error('获取数据失败:', error);
    });
}
