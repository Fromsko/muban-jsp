<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>数据看板</title>
    <link rel="stylesheet" href="<c:url value='/assets/css/tailwind.output.css'/>">
    <script type="text/javascript" src="<c:url value='/assets/js/http/axios_client.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/assets/js/admin/admin_kanban.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/assets/js/echarts.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/assets/js/axios.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/assets/js/jquery-3.6.0.min.js'/>"></script>
</head>
<body class="bg-base-200">

<!-- 顶部导航栏 -->
<nav class="bg-gradient-to-r from-blue-500 to-indigo-600 p-6 text-white">
    <div class="max-w-7xl mx-auto flex justify-between items-center">
        <div class="text-3xl font-bold">
            数据看板
        </div>
        <div>
            <ul class="flex space-x-6">
                <li><a href="#" class="hover:text-indigo-300">首页</a></li>
                <li><a href="#" class="hover:text-indigo-300">设置</a></li>
                <li><a href="#" class="hover:text-indigo-300">退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- 主体内容 -->
<div class="max-w-7xl mx-auto p-6">
    <!-- 卡片式布局 -->
    <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-2 gap-6">
        <!-- 流量数据卡片 -->
        <div class="card bg-base-100 shadow-xl hover:shadow-2xl transition-shadow duration-300">
            <div class="card-body">
                <h2 class="card-title text-xl font-semibold text-gray-800 mb-4">流量数据</h2>
                <div class="relative" id="main" style="height: 350px;"></div>
            </div>
        </div>

        <!-- 注册页面滚动列表卡片 -->
        <div class="card bg-base-100 shadow-xl hover:shadow-2xl transition-shadow duration-300">
            <div class="card-body">
                <h2 class="card-title text-xl font-semibold text-gray-800 mb-4">当前注册页面</h2>
                <div id="registeredPages" class="overflow-y-auto h-72 space-y-2 p-2 bg-base-200 rounded-lg">
                    <!-- 动态内容插入这里 -->
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    let {totalClient} = useWebClient();
    let {getTotal, getRoutes} = totalClient();

    $(document).ready(async function () {
        // 每隔 5 秒刷新一次图表
        setInterval(() => refreshChartData(getTotal), 5000);

        // 初始加载一次图表
        refreshChartData(getTotal);

        // 获取并展示注册的页面
        document.getElementById('registeredPages').innerHTML = await getRoutes();
    });
</script>

</body>
</html>
